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
