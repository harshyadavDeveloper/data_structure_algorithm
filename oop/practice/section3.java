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
