// Section 3 — 10 Tricky Ones (the gotchas)

/*
 * Q1: Can a constructor be private? If yes, why would you ever do that?
 * Answer:
 * YES, constructor can be private. It's legal in Java.
 *
 * If you make it private, NO OTHER class (not even subclasses) can create an
 * object
 * of this class using 'new' from outside. Only the class itself can create its
 * own objects
 * internally.
 *
 * WHY you'd do this - main use cases:
 *
 * 1. SINGLETON PATTERN - you want only ONE object of a class to ever exist in
 * the whole app.
 *
 * class Singleton {
 * private static Singleton instance; // holds the one and only object
 *
 * private Singleton() { } // private constructor, no one outside can call 'new
 * Singleton()'
 *
 * public static Singleton getInstance() {
 * if (instance == null) {
 * instance = new Singleton(); // only this class can create it, and only once
 * }
 * return instance;
 * }
 * }
 *
 * // Outside code:
 * Singleton s1 = Singleton.getInstance();
 * Singleton s2 = Singleton.getInstance();
 * // s1 == s2 -> true, same object always, cant create a new one with 'new
 * Singleton()' from outside
 *
 * 2. UTILITY/HELPER CLASSES - classes with only static methods (like Math
 * class),
 * you don't want anyone creating an object of it at all since it makes no
 * sense.
 *
 * class MathUtils {
 * private MathUtils() { } // prevents anyone from doing 'new MathUtils()'
 * static int square(int x) { return x*x; }
 * }
 *
 * 3. FACTORY PATTERN - you want object creation to happen only through a
 * specific
 * static method (factory method) that controls/validates how objects are made,
 * not letting people just randomly 'new' it.
 *
 * Interview line: "Yes, a constructor can be private - it stops the class from
 * being
 * instantiated directly from outside using new. Most common use is the
 * Singleton pattern,
 * where you want only one instance of a class to exist, or utility classes with
 * only
 * static methods where creating an object doesn't make sense."
 */

/*
 * Q2: If a subclass doesn't override a parent's method, and you call it through
 * a
 * parent-typed reference - which version runs, and why doesn't that contradict
 * polymorphism?
 * Answer:
 *
 * The PARENT's version runs. And no, this does NOT contradict polymorphism,
 * here's why:
 *
 * class Animal {
 * void eat() { System.out.println("Animal eats"); }
 * void sound() { System.out.println("some generic sound"); }
 * }
 *
 * class Dog extends Animal {
 * 
 * @Override
 * void sound() { System.out.println("Bark"); } // only sound() is overridden
 * // eat() is NOT overridden, Dog just inherits it as-is
 * }
 *
 * Animal a = new Dog();
 * a.eat(); // prints "Animal eats" <- parent's version runs
 * a.sound(); // prints "Bark" <- child's version runs (overridden)
 *
 * -----------------------------------------------------------
 * WHY this happens (the actual mechanism):
 *
 * Runtime polymorphism (dynamic method dispatch) only kicks in when the method
 * is
 * ACTUALLY OVERRIDDEN in the child class. JVM checks: "does the actual object
 * (Dog)
 * have its OWN version of this method?"
 * - eat() -> Dog doesn't have its own version -> so it just uses whatever it
 * inherited from Animal
 * - sound() -> Dog DOES have its own version -> JVM picks Dog's version
 *
 * So really what's happening is: Dog object literally doesn't have its own
 * eat() method at all,
 * it's using Animal's eat() because that's the only one that exists in its
 * inheritance hierarchy.
 * There's no "choice" being made here between two versions, there's only ONE
 * version of eat() total.
 *
 * -----------------------------------------------------------
 * WHY it doesn't contradict polymorphism:
 *
 * Polymorphism just means
 * "the actual object's method gets called, not decided by reference type."
 * It doesn't mean "child MUST have a different version of every method."
 * If child doesn't override something, the object still only HAS one version of
 * that method
 * (inherited one) - so calling it isn't really a "polymorphic decision",
 * there's nothing to
 * choose between. Polymorphism is still working correctly, it's just that in
 * this specific
 * case, both reference type and actual object happen to lead to the same method
 * because
 * that's literally the only implementation that exists for the Dog object.
 *
 * Interview line: "The parent's version runs, because if a subclass doesn't
 * override a method,
 * it simply inherits the parent's implementation - there's no separate version
 * in the child
 * to dispatch to. This doesn't contradict polymorphism because polymorphism
 * means the JVM picks
 * whichever version actually exists on the object at runtime; when only one
 * version exists
 * (the inherited one), that's naturally what gets called."
 */

/*
 * Q3: Can you override a private method? What actually happens if you try?
 * Answer:
 * NO, you cannot override a private method. Private methods are NOT visible to
 * subclasses at all - they're not even inherited in the "overridable" sense.
 *
 * What actually happens if you try:
 * If you write a method with the SAME name and signature as the parent's
 * private
 * method inside the child class, Java does NOT treat it as overriding.
 * Instead, it's treated as a completely NEW, independent method that just
 * happens
 * to have the same name. This is called "METHOD HIDING" (not overriding).
 *
 * class Animal {
 * private void sound() { System.out.println("Animal sound"); }
 *
 * public void makeSound() {
 * sound(); // this always calls Animal's own private sound()
 * }
 * }
 *
 * class Dog extends Animal {
 * private void sound() { System.out.println("Dog sound"); } // NOT overriding,
 * new method
 * }
 *
 * Animal a = new Dog();
 * a.makeSound(); // prints "Animal sound" <- NOT "Dog sound"!
 *
 * -----------------------------------------------------------
 * WHY: Since Animal's sound() is private, it's only accessible/callable within
 * Animal
 * class itself. makeSound() calls sound() which resolves to Animal's own
 * private method
 * at COMPILE time (static binding, not dynamic dispatch) because private
 * methods don't
 * participate in runtime polymorphism at all. Dog's sound() is basically
 * invisible to
 * Animal, they don't even know about each other - they're two totally separate
 * methods
 * that just share a name by coincidence.
 *
 * Quick way to spot this in code: if you see @Override on a method trying to
 * override
 * a private method, Java will actually give a COMPILE ERROR saying method does
 * not
 * override a method from its superclass - because there's nothing to override,
 * private
 * methods aren't part of the inheritance contract at all.
 *
 * Interview line: "No, private methods can't be overridden because they're not
 * visible
 * to subclasses - they're not part of inheritance at all. If you write a
 * same-named method
 * in the child class, it's not overriding, it's a completely separate method
 * (method hiding),
 * and calls from the parent class will always resolve to the parent's own
 * private method,
 * not the child's."
 */

/*
 * Q4: Can you override a static method? Difference between "hiding" and
 * "overriding"?
 * Answer:
 * NO, static methods cannot be overridden. If you write a static method with
 * the
 * same name+signature in the child class, it's called METHOD HIDING, not
 * overriding.
 *
 * WHY: Static methods belong to the CLASS itself, not to any object. They're
 * resolved
 * at COMPILE time based on the REFERENCE TYPE, not the actual object.
 * Overriding
 * only works with instance methods because that needs runtime dynamic dispatch
 * (JVM checking actual object type) - static methods never go through that
 * mechanism at all.
 *
 * class Animal {
 * static void sound() { System.out.println("Animal static sound"); }
 * void run() { System.out.println("Animal runs"); } // instance method
 * }
 *
 * class Dog extends Animal {
 * static void sound() { System.out.println("Dog static sound"); } // HIDING,
 * not overriding
 *
 * @Override
 * void run() { System.out.println("Dog runs"); } // real overriding
 * }
 *
 * Animal a = new Dog();
 * a.sound(); // prints "Animal static sound" <- decided by REFERENCE TYPE
 * (Animal), compile time
 * a.run(); // prints "Dog runs" <- decided by ACTUAL OBJECT (Dog), runtime
 *
 * -----------------------------------------------------------
 * THE REAL DIFFERENCE - HIDING vs OVERRIDING:
 *
 * OVERRIDING (instance methods):
 * - Resolved at RUNTIME based on ACTUAL OBJECT type
 * - a.run() -> JVM looks at what 'a' actually points to (Dog) -> calls Dog's
 * run()
 * - This is dynamic method dispatch, true polymorphism
 *
 * HIDING (static methods):
 * - Resolved at COMPILE TIME based on REFERENCE TYPE (the declared type, left
 * side)
 * - a.sound() -> compiler only looks at 'a' being declared as Animal -> calls
 * Animal's sound()
 * - Doesn't matter what actual object a points to, compiler doesn't even check
 * that for statics
 * - No polymorphism involved here at all, its purely based on how you declared
 * the variable
 *
 * Extra trick to catch this in interview: if you call static method using the
 * CLASS NAME
 * directly (like Dog.sound() or Animal.sound()) instead of an object reference,
 * it makes
 * this even more obvious - you're literally calling "that class's version", no
 * ambiguity,
 * no runtime object involved at all.
 *
 * Interview line: "Static methods can't be overridden, only hidden. The key
 * difference is
 * WHEN and HOW the method is resolved - overriding is resolved at runtime based
 * on the
 * actual object type (dynamic dispatch), hiding is resolved at compile time
 * based on the
 * reference type. That's why calling a hidden static method through a parent
 * reference
 * always calls the parent's version, even if the actual object is a child."
 */

/*
 * Q5: If parent class has no no-arg constructor, and child doesn't call
 * super(...)
 * explicitly - what happens at compile time?
 * Answer:
 * COMPILE ERROR. The code won't compile at all.
 *
 * WHY: In Java, if you don't explicitly write super(...) as the first line of a
 * child constructor, Java AUTOMATICALLY inserts an implicit super() call
 * (no-arg version)
 * for you behind the scenes. But this only works if the parent class actually
 * HAS a
 * no-arg constructor available.
 *
 * If parent only has a PARAMETERIZED constructor (and no no-arg one), Java
 * still tries
 * to insert that implicit super() -> but there's no matching no-arg constructor
 * in parent
 * to call -> compiler throws an error.
 *
 * class Animal {
 * Animal(String name) { // only parameterized constructor exists
 * System.out.println("Animal: " + name);
 * }
 * // NO no-arg constructor here
 * }
 *
 * class Dog extends Animal {
 * Dog() {
 * // Java tries to insert super() here automatically
 * // but Animal has no no-arg constructor -> ERROR
 * System.out.println("Dog created");
 * }
 * }
 * // COMPILE ERROR: "implicit super constructor Animal() is undefined.
 * // Must explicitly invoke another constructor"
 *
 * -----------------------------------------------------------
 * HOW TO FIX IT - 2 ways:
 *
 * Fix 1: Explicitly call the parameterized super constructor yourself
 * class Dog extends Animal {
 * Dog() {
 * super("Default Name"); // explicitly call parent's parameterized constructor
 * System.out.println("Dog created");
 * }
 * }
 *
 * Fix 2: Add a no-arg constructor to the parent class itself
 * class Animal {
 * Animal() { System.out.println("Animal default"); } // add this
 * Animal(String name) { System.out.println("Animal: " + name); }
 * }
 *
 * -----------------------------------------------------------
 * KEY POINT to remember: Java ALWAYS needs SOME constructor call to happen
 * first in every
 * constructor chain (either explicit super()/this(), or implicit default
 * super()).
 * It never just skips constructor calling - that's why if the implicit option
 * isn't
 * available, it forces you to be explicit instead, otherwise compile fails.
 *
 * Interview line: "It's a compile error. Java automatically inserts an implicit
 * super()
 * call in the child constructor if you don't write one yourself, but that only
 * works if
 * the parent has a no-arg constructor. If parent only has a parameterized
 * constructor,
 * that implicit call fails to find a match, so compilation fails unless you
 * explicitly
 * call super(args) yourself or add a no-arg constructor to the parent."
 */

/*
 * Q6: Can an abstract class have a constructor, if it can never be instantiated
 * directly?
 * If yes, what's the point?
 * Answer:
 * YES, abstract classes CAN have constructors. Totally legal.
 *
 * You're right that you can never do 'new AbstractClass()' directly. But the
 * constructor
 * still serves a purpose - it runs when a SUBCLASS object is created, because
 * every
 * subclass constructor implicitly (or explicitly) calls super(), which triggers
 * the
 * abstract class's constructor.
 *
 * abstract class Animal {
 * String name;
 *
 * Animal(String name) { // constructor in abstract class
 * this.name = name;
 * System.out.println("Animal constructor called, name set to: " + name);
 * }
 *
 * abstract void sound();
 * }
 *
 * class Dog extends Animal {
 * Dog(String name) {
 * super(name); // this CALLS Animal's constructor
 * System.out.println("Dog constructor called");
 * }
 * void sound() { System.out.println("Bark"); }
 * }
 *
 * Dog d = new Dog("Tommy");
 * // Output:
 * // Animal constructor called, name set to: Tommy
 * // Dog constructor called
 *
 * -----------------------------------------------------------
 * WHAT'S THE POINT (why it's useful):
 *
 * 1. INITIALIZE COMMON FIELDS - abstract class might have shared fields (like
 * 'name' above)
 * that EVERY subclass needs set up properly. Constructor handles that common
 * setup logic
 * once, instead of every subclass repeating the same init code.
 *
 * 2. ENFORCE RULES AT CREATION - you can force every subclass to provide
 * certain data
 * right when object is created. Like if Animal constructor requires a name
 * param,
 * every subclass MUST pass a name through super(name), no subclass can skip
 * this.
 *
 * 3. VALIDATION logic that should run for ALL subclasses, not duplicated in
 * each one.
 *
 * Simple way to think about it: you can't create an Animal object directly, but
 * you
 * CAN'T create a Dog without "passing through" Animal's constructor first
 * (super() always
 * runs). So the constructor isn't there for creating Animal objects, it's there
 * to help
 * SET UP whatever part of the Dog (or any subclass) object that belongs to
 * Animal.
 *
 * Interview line: "Yes, abstract classes can have constructors, even though you
 * can't
 * instantiate them directly. The constructor runs whenever a subclass object is
 * created,
 * since subclass constructors call super() which triggers it. It's useful for
 * initializing
 * common fields shared across all subclasses, and enforcing that subclasses
 * provide
 * required data at creation time."
 */

/*
 * Q7: What happens if two interfaces implemented by the same class both have a
 * method
 * with the identical signature?
 * Answer:
 * Depends on whether the methods are plain abstract methods or default methods.
 *
 * -----------------------------------------------------------
 * CASE 1: Both are plain abstract methods (no body) - NO PROBLEM at all
 *
 * interface Flyable {
 * void move();
 * }
 * interface Swimmable {
 * void move();
 * }
 *
 * class Duck implements Flyable, Swimmable {
 * public void move() { // ONE implementation satisfies BOTH interfaces
 * System.out.println("Duck moves");
 * }
 * }
 * This compiles totally fine. Since neither interface provides a body, there's
 * nothing
 * to conflict. The class just writes ONE implementation, and it counts as
 * fulfilling
 * the contract for both interfaces at once.
 *
 * -----------------------------------------------------------
 * CASE 2: Both are DEFAULT methods (have a body) - COMPILE ERROR (diamond
 * problem)
 *
 * interface Flyable {
 * default void move() { System.out.println("Flyable move"); }
 * }
 * interface Swimmable {
 * default void move() { System.out.println("Swimmable move"); }
 * }
 *
 * class Duck implements Flyable, Swimmable {
 * // COMPILE ERROR: "class Duck inherits unrelated defaults for move() from
 * // types Flyable and Swimmable"
 * }
 *
 * Java doesn't know which default implementation to use -> forces YOU to
 * resolve it by
 * overriding the method explicitly in Duck:
 *
 * class Duck implements Flyable, Swimmable {
 * 
 * @Override
 * public void move() {
 * Flyable.super.move(); // explicitly pick Flyable's version
 * // or Swimmable.super.move();
 * // or write completely new logic here
 * }
 * }
 *
 * -----------------------------------------------------------
 * Quick way to remember: only an actual BODY causes conflict. No body = no
 * conflict,
 * because there's nothing to "pick between", just one contract to fulfill. Body
 * = conflict,
 * because now there's two competing implementations and Java refuses to guess
 * which one you want.
 *
 * Interview line: "If both are plain abstract methods, there's no issue - the
 * implementing
 * class just writes one implementation that satisfies both. But if both are
 * default methods
 * with actual bodies, it's a compile error - the diamond problem - and Java
 * forces the class
 * to override the method explicitly and resolve which version to use, using
 * Interface.super.method()."
 */

/*
 * Q8: Is it possible for a class to be both abstract and final? Why or why not?
 * Answer:
 * NO, not possible. COMPILE ERROR if you try.
 * "illegal combination of modifiers: abstract and final"
 *
 * WHY - think about what each keyword actually means:
 *
 * ABSTRACT -> means "this class CANNOT be instantiated directly, it MUST be
 * extended/subclassed
 * for it to ever be useful (someone has to implement the abstract methods)"
 *
 * FINAL -> means
 * "this class CANNOT be extended/subclassed by anyone, its final, no inheritance allowed"
 *
 * These two are literally CONTRADICTING each other:
 * - abstract says "you MUST extend me"
 * - final says "no one CAN extend me"
 *
 * abstract final class Test { // COMPILE ERROR
 * abstract void show();
 * }
 *
 * If this combo was allowed, you'd have a class that:
 * - can't be instantiated (because abstract)
 * - can't be extended (because final)
 * = completely USELESS class, cant ever be used in any way, dead code
 * essentially.
 * That's exactly why Java's compiler just blocks this combination outright,
 * doesn't even
 * let you try - no practical use case for this scenario could ever exist.
 *
 * Interview line: "No, it's not possible, it's a compile error. Abstract means
 * a class
 * must be subclassed to be useful, final means a class cannot be subclassed at
 * all -
 * these two directly contradict each other. If it were allowed, you'd end up
 * with a
 * class that can neither be instantiated nor extended, making it completely
 * unusable."
 */

/*
 * Q9: If a subclass overrides equals() but not hashCode(), what real bug can
 * this
 * cause later (HashMap/HashSet specific)?
 * Answer:
 *
 * The RULE in Java: "if two objects are equal (equals() returns true), they
 * MUST have
 * the SAME hashCode()." This is called the equals-hashCode contract.
 *
 * If you override equals() but DON'T override hashCode(), you break this
 * contract.
 * hashCode() still uses the default Object implementation (based on memory
 * address),
 * so two "equal" objects can end up having DIFFERENT hash codes.
 *
 * -----------------------------------------------------------
 * WHY this breaks HashMap/HashSet specifically:
 *
 * HashMap/HashSet work using hashCode() FIRST to decide which "bucket" to
 * put/look for
 * an object in, THEN uses equals() only to compare within that same bucket.
 *
 * So if two objects are equal() but have different hashCode() -> they get
 * placed in
 * DIFFERENT buckets entirely. HashSet/HashMap won't even check equals() between
 * them,
 * because it never even looks in the other bucket - it only searches the bucket
 * matching
 * the hashCode you gave it.
 *
 * class Person {
 * String name;
 * Person(String name) { this.name = name; }
 *
 * @Override
 * public boolean equals(Object o) {
 * if (!(o instanceof Person)) return false;
 * return name.equals(((Person)o).name);
 * }
 * // hashCode() NOT overridden - still default Object version
 * }
 *
 * Set<Person> set = new HashSet<>();
 * set.add(new Person("John"));
 * set.add(new Person("John")); // logically a DUPLICATE (equals() says true)
 *
 * System.out.println(set.size()); // prints 2, NOT 1!!
 * // Even though both Person("John") are .equals() to each other,
 * // HashSet still adds both because their hashCode() are different (different
 * objects,
 * // default hashCode based on memory address), so it put them in different
 * buckets
 * // and never even compared them with equals().
 *
 * ALSO breaks lookups:
 * set.contains(new Person("John")); // might return FALSE even though a "John"
 * exists in set
 * // because the NEW Person("John") you're searching with has a different
 * hashCode
 * // than the one already stored, so HashSet looks in wrong bucket, never finds
 * match
 *
 * -----------------------------------------------------------
 * THE FIX: Always override BOTH together, never just one.
 *
 * @Override
 * public int hashCode() {
 * return Objects.hash(name); // same fields used in equals() should be used in
 * hashCode()
 * }
 *
 * Interview line: "Breaking the equals-hashCode contract causes HashMap/HashSet
 * to behave
 * incorrectly - since these collections use hashCode() to find the bucket first
 * and only
 * use equals() within that bucket, two logically equal objects with different
 * hash codes
 * end up in different buckets. This causes duplicate entries in a Set, or
 * failed lookups
 * with contains()/get(), even though equals() would say they're the same. Rule
 * of thumb:
 * always override equals() and hashCode() together, never just one."
 */

/*
 * Q10: Given Shape s = new Circle(5); - can you call a method that exists on
 * Circle
 * but not on Shape, directly on 's'? Why or why not?
 * Answer:
 * NO, you cannot call it directly. COMPILE ERROR if you try.
 *
 * class Shape {
 * void draw() { System.out.println("Drawing shape"); }
 * }
 *
 * class Circle extends Shape {
 * double radius;
 * Circle(double radius) { this.radius = radius; }
 *
 * void draw() { System.out.println("Drawing circle"); } // overridden
 * double getArea() { return 3.14 * radius * radius; } // Circle-ONLY method,
 * not in Shape
 * }
 *
 * Shape s = new Circle(5);
 * s.draw(); // WORKS fine - "Drawing circle" (runtime polymorphism, from Q2/Q10
 * earlier)
 * s.getArea(); // COMPILE ERROR: "cannot find symbol - method getArea()"
 *
 * -----------------------------------------------------------
 * WHY this happens - the key concept here:
 *
 * The COMPILER only looks at the REFERENCE TYPE (declared type = Shape) to
 * decide
 * WHAT METHODS ARE ALLOWED TO BE CALLED AT ALL. It checks this at COMPILE time,
 * way before it even cares about which actual object is sitting there at
 * runtime.
 *
 * Since 's' is declared as type Shape, compiler only "knows about" whatever
 * methods
 * exist in the Shape class. It doesn't look ahead into Circle's extra methods,
 * because
 * for all the compiler knows, 's' could be pointing to ANY subclass of Shape
 * (Circle,
 * Square, Triangle...) - not all of them necessarily have getArea().
 *
 * This is literally the FLIP SIDE of what we saw in Q2/Q10:
 * - WHICH implementation runs (overriding) -> decided at RUNTIME, based on
 * actual object
 * - WHAT methods you're even ALLOWED to call -> decided at COMPILE time, based
 * on reference type
 *
 * So polymorphism lets runtime pick the right OVERRIDDEN version of a method,
 * but it does NOT let you access methods that don't exist on the reference type
 * at all.
 * Those are two totally separate things - polymorphism is about
 * behavior/dispatch,
 * not about expanding what's visible/accessible.
 *
 * -----------------------------------------------------------
 * HOW TO actually call getArea() - you need DOWNCASTING:
 *
 * Shape s = new Circle(5);
 * Circle c = (Circle) s; // explicitly downcast back to Circle
 * c.getArea(); // now this works
 *
 * // or inline:
 * ((Circle) s).getArea();
 *
 * // SAFER way - check type first to avoid ClassCastException:
 * if (s instanceof Circle) {
 * Circle c = (Circle) s;
 * c.getArea();
 * }
 *
 * Interview line: "No, you can't call it directly - it's a compile error. The
 * compiler
 * only allows calling methods that exist on the REFERENCE TYPE (Shape),
 * regardless of what
 * actual object it points to, because it checks this at compile time without
 * knowing what
 * subclass might actually be assigned. This is the flip side of polymorphism -
 * runtime
 * decides WHICH version of an existing method runs, but compile-time reference
 * type decides
 * WHAT methods are even callable in the first place. To access Circle-specific
 * methods,
 * you need to explicitly downcast back to Circle."
 */
