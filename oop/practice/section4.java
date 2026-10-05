/*
 * Q1: Walk me through designing a class hierarchy for [some real-world system]
 * Answer:
 *
 * This is a LIVE/ON-SPOT question - they give you a random system (parking lot,
 * library, ATM, zoo, food delivery app, elevator...) and watch your THOUGHT PROCESS,
 * not just the final code. So don't just start typing, talk out loud step by step.
 *
 * MY GENERAL APPROACH (say this out loud in interview, step by step):
 *
 * STEP 1: Identify the NOUNS (these become your classes)
 * Listen to the problem, pick out the main "things" involved.
 *
 * STEP 2: Identify relationships between them
 * - IS-A -> inheritance (Dog IS-A Animal)
 * - HAS-A -> composition (Car HAS-A Engine)
 *
 * STEP 3: Identify common behavior -> goes in parent class / interface
 * If multiple classes share some behavior/fields, pull it up to a common
 * parent (abstract class) or interface.
 *
 * STEP 4: Decide abstract class vs interface
 * - Related classes sharing code/state -> abstract class
 * - Unrelated classes needing same capability -> interface
 *
 * STEP 5: Add the 4 pillars naturally as you go
 * - Encapsulation: private fields, public getters/setters with validation
 * - Abstraction: abstract methods for things that differ per subclass
 * - Inheritance: shared structure pulled into parent
 * - Polymorphism: overridden methods behave differently per subclass
 *
 * STEP 6: Keep it SIMPLE first, then mention you'd extend it
 * Don't over-engineer on the spot, build a basic version, then say
 * "this can be extended further with X, Y, Z if needed"
 *
 * -----------------------------------------------------------
 * EXAMPLE WALKTHROUGH: "Design a class hierarchy for a Parking Lot system"
 * (so you have a template, same steps apply to ANY system they give you)
 *
 * Step 1 - Nouns: ParkingLot, ParkingSpot, Vehicle, Car, Bike, Truck, Ticket
 * Step 2 - Relationships: Car/Bike/Truck IS-A Vehicle. ParkingLot HAS-A list of ParkingSpots.
 * Step 3 - Common behavior: all vehicles have licensePlate, type -> goes in Vehicle class
 * Step 4 - Vehicle = abstract class (related, shared fields+behavior)
 */

abstract class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    abstract String getType(); // forces every vehicle to say what type it is
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    String getType() {
        return "Car";
    }
}

class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate);
    }

    @Override
    String getType() {
        return "Bike";
    }
}

class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (isOccupied) {
            return false;
        }
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
        return true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}

class ParkingLot {
    private ParkingSpot[] spots;

    public ParkingLot(int totalSpots) {
        spots = new ParkingSpot[totalSpots];
        for (int i = 0; i < totalSpots; i++) {
            spots[i] = new ParkingSpot(i + 1);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return spot.parkVehicle(vehicle);
            }
        }
        return false; // parking lot full
    }
}

/*
 * Step 5 - Pillars used here:
 * - Encapsulation: licensePlate, isOccupied are private, accessed thru methods
 * - Abstraction: getType() is abstract, each vehicle defines its own
 * - Inheritance: Car, Bike extend Vehicle, reuse licensePlate logic
 * - Polymorphism: getType() behaves differently per subclass (if called via
 * Vehicle ref)
 *
 * Step 6 - Say this at the end: "This is a basic version, in a real system I'd
 * also
 * add things like pricing strategy, different spot types for different vehicle
 * sizes,
 * a Ticket class to track entry/exit time, maybe a payment module etc."
 *
 * Interview line: "For live design questions, I talk through my process - first
 * I pick
 * out the nouns as classes, figure out IS-A vs HAS-A relationships, pull shared
 * behavior
 * into a parent abstract class or interface depending on whether the classes
 * are related
 * or just need a common capability, then apply encapsulation and polymorphism
 * naturally
 * as I build it out, keeping the first version simple and mentioning what I'd
 * extend later."
 */

/*
 * Q2: What design pattern would you use for X, and why? (Singleton asked
 * constantly)
 * Answer:
 *
 * This is also an "on the spot" type question - they describe a scenario (X)
 * and want
 * you to pick the RIGHT pattern and explain WHY. Singleton comes up the most,
 * so let's
 * go deep on that, then quickly cover a few other commonly asked ones so you
 * recognize
 * which pattern fits which scenario.
 *
 * -----------------------------------------------------------
 * SINGLETON PATTERN (most asked)
 *
 * WHAT: Ensures only ONE instance of a class exists in the entire application,
 * and gives a global point of access to it.
 *
 * WHEN to use it (say these out loud when asked "why"):
 * - Database connection manager -> don't want multiple separate connections
 * eating resources
 * - Logger class -> one single logger instance writing to the same log file
 * across app
 * - Configuration/Settings manager -> app-wide settings should be consistent,
 * one source of truth
 * - Thread pool manager -> managing a fixed set of threads, shouldn't have
 * multiple pools randomly
 *
 * Basic version (NOT thread-safe, mention this limitation):
 */

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor stops 'new Singleton()' from outside
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/*
 * PROBLEM with above: if two threads call getInstance() at the EXACT same time,
 * BOTH might see instance == null and create TWO separate objects -> breaks
 * singleton!
 *
 * THREAD-SAFE version (mention this, shows depth):
 */

class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance;

    private SingletonThreadSafe() {
    }

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}

/*
 * This is called "double-checked locking" - checks null twice, only locks when
 * actually needed (not every single call), so its efficient AND thread-safe.
 * 'volatile' keyword makes sure changes to 'instance' are visible to all
 * threads immediately.
 *
 * -----------------------------------------------------------
 * OTHER PATTERNS YOU SHOULD QUICKLY RECOGNIZE (just the "when to use" part):
 *
 * FACTORY PATTERN
 * - Use when: object creation logic is complex or depends on some condition,
 * and you want to hide that creation logic from the caller
 * - Ex: "Create a Shape based on user input (circle/square/triangle)"
 *
 * class ShapeFactory {
 * static Shape createShape(String type) {
 * if (type.equals("circle")) return new Circle();
 * if (type.equals("square")) return new Square();
 * return null;
 * }
 * }
 *
 * BUILDER PATTERN
 * - Use when: an object has MANY optional fields/parameters, avoids giant
 * constructors with 10 parameters (telescoping constructor problem)
 * - Ex: Building a complex object like a "Pizza" with many optional toppings
 *
 * OBSERVER PATTERN
 * - Use when: one object's state change needs to automatically notify multiple
 * other objects (like a publish-subscribe setup)
 * - Ex: "Notification system - when a new post is made, notify all subscribers"
 *
 * STRATEGY PATTERN
 * - Use when: you have multiple ways of doing something (algorithms) and want
 * to
 * switch between them at runtime without changing the class using them
 * - Ex:
 * "Different payment methods - credit card, UPI, wallet, all implement same interface"
 *
 * -----------------------------------------------------------
 * Simple way to answer in interview when they give you a random scenario X:
 * Ask yourself:
 * - "Should only ONE object ever exist?" -> Singleton
 * - "Is object creation complex/conditional?" -> Factory
 * - "Does object have tons of optional fields?" -> Builder
 * - "Do multiple things need to react when something changes?" -> Observer
 * - "Are there multiple interchangeable ways to do the same task?" -> Strategy
 *
 * Interview line: "For scenario X, I'd use [pattern] because [specific reason
 * tied to
 * the scenario]. For example, Singleton makes sense when you need exactly one
 * shared
 * instance across the app, like a database connection or logger - it saves
 * resources
 * and keeps state consistent everywhere, and I'd implement it with
 * double-checked locking
 * to make sure it's thread-safe too."
 */

/*
 * Q3: How would you implement a Singleton class in Java, and what problems can
 * arise with it in multi-threaded code?
 * Answer:
 *
 * (We touched this in Q2, but here they want FULL focus on implementation +
 * threading
 * problems specifically, so let's go step by step properly)
 *
 * -----------------------------------------------------------
 * APPROACH 1: Basic/Lazy Singleton (NOT thread-safe)
 */

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/*
 * THE PROBLEM in multi-threading:
 *
 * Imagine Thread-1 and Thread-2 BOTH call getInstance() at almost the exact
 * same time,
 * when instance is still null.
 *
 * Thread-1: checks "instance == null" -> true -> about to create object...
 * Thread-2: checks "instance == null" -> ALSO true (Thread-1 hasn't finished
 * yet!) -> about to create object too...
 * Thread-1: creates object A, assigns to instance
 * Thread-2: creates object B, assigns to instance (OVERWRITES Thread-1's
 * object!)
 *
 * Result: TWO different Singleton objects got created at some point, breaking
 * the
 * whole purpose of Singleton (only one instance). Depending on timing, some
 * code
 * might even be holding a reference to the OLD object (A) while instance now
 * points to B
 * -> inconsistent state across the application, hard to debug bugs.
 *
 * -----------------------------------------------------------
 * APPROACH 2: Make getInstance() fully synchronized (fixes the problem, but
 * SLOW)
 */

class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
    }

    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}

/*
 * This works correctly - only one thread can enter getInstance() at a time.
 * PROBLEM: EVERY single call to getInstance() has to wait for the lock, even
 * AFTER the instance is already created and there's no real risk anymore.
 * This hurts performance if this method gets called A LOT (which it usually
 * does
 * since that's the whole point of a frequently-accessed singleton like a
 * logger).
 *
 * -----------------------------------------------------------
 * APPROACH 3: Double-Checked Locking (BEST - fixes both correctness AND
 * performance)
 */

class SingletonDoubleChecked {
    private static volatile SingletonDoubleChecked instance;

    private SingletonDoubleChecked() {
    }

    public static SingletonDoubleChecked getInstance() {
        if (instance == null) { // first check (no locking, fast)
            synchronized (SingletonDoubleChecked.class) {
                if (instance == null) { // second check (inside lock, safe)
                    instance = new SingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}

/*
 * WHY this is better:
 * - First "if (instance == null)" check happens WITHOUT locking -> fast for all
 * the
 * calls AFTER instance is already created (most calls in real life), no
 * unnecessary waiting
 * - Lock only triggers the FEW times instance might still be null (early on)
 * - Second check INSIDE the lock makes sure that even if two threads both got
 * past the
 * first check together, only ONE of them actually creates the object (second
 * thread
 * sees instance is no longer null once it gets the lock, so it skips creating
 * again)
 *
 * WHY 'volatile' is needed here (important interview detail):
 * Without volatile, due to how JVM can reorder instructions for optimization,
 * another thread might see a "partially constructed" object - meaning instance
 * is NOT null, but the Singleton object's internal fields aren't fully
 * initialized yet.
 * 'volatile' prevents this reordering and makes sure writes to 'instance' are
 * immediately visible to all threads in proper order.
 *
 * -----------------------------------------------------------
 * APPROACH 4: Easiest fix of all - Eager initialization (if object creation
 * isn't expensive)
 */

class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

/*
 * This is automatically thread-safe because the JVM creates the instance when
 * the
 * CLASS itself is loaded (class loading is inherently thread-safe in Java),
 * before
 * any thread even gets a chance to race for it. No synchronized needed, no
 * checks needed.
 * ONLY DOWNSIDE: object gets created even if you never end up calling
 * getInstance(),
 * so not ideal if the object is heavy/expensive to create and might not always
 * be needed.
 *
 * -----------------------------------------------------------
 * Interview line: "The basic lazy singleton isn't thread-safe - two threads can
 * both
 * pass the null check at the same time and create two separate instances,
 * breaking the
 * singleton guarantee. You can fix it by synchronizing the whole method, but
 * that hurts
 * performance since every call gets locked even after the instance exists. The
 * better fix
 * is double-checked locking with a volatile instance variable - it only locks
 * on the rare
 * case the instance might still be null, and volatile prevents issues from
 * instruction
 * reordering during object construction. Alternatively, if the object isn't
 * expensive to
 * create, eager initialization avoids the threading problem entirely since the
 * JVM
 * guarantees thread-safe class loading."
 */

/*
 * Q4: Difference between composition and inheritance, and when to prefer one
 * over the other?
 * Answer:
 *
 * (We covered IS-A/HAS-A basics in section 2 Q9 - this question wants you to go
 * DEEPER on when to actually CHOOSE one over the other, which is what
 * interviewers
 * really care about here)
 *
 * QUICK RECAP of the difference:
 *
 * INHERITANCE (IS-A) -> subclass extends parent, gets its code/behavior
 * automatically
 * COMPOSITION (HAS-A) -> class contains an object of another class as a field,
 * uses its methods
 */

class Engine {
    void start() {
        System.out.println("Engine starting");
    }
}

// Inheritance example
class Vehicle {
    void move() {
        System.out.println("Vehicle moving");
    }
}

class Car extends Vehicle {
    // Car IS-A Vehicle, automatically gets move()
}

// Composition example
class CarComposed {
    private Engine engine = new Engine(); // Car HAS-A Engine

    void drive() {
        engine.start();
        System.out.println("Car driving");
    }
}

/*
 * -----------------------------------------------------------
 * PROBLEMS WITH INHERITANCE (why it's not always the best choice):
 *
 * 1. TIGHT COUPLING - child class is heavily dependent on parent's internal
 * implementation.
 * If parent class changes something, it can break child classes unexpectedly
 * ("fragile base class problem")
 *
 * 2. INHERITS EVERYTHING - even stuff you don't need or want. You can't
 * selectively
 * pick which methods to inherit, you get the whole package.
 *
 * 3. SINGLE INHERITANCE LIMIT - a class can only extend ONE class in Java, so
 * if you
 * need behavior from multiple sources, inheritance alone can't give you that.
 *
 * 4. BREAKS ENCAPSULATION sometimes - subclass can end up depending on parent's
 * internal behavior/implementation details, not just its public contract.
 *
 * -----------------------------------------------------------
 * WHY COMPOSITION IS OFTEN BETTER (the famous principle:
 * "favor composition over inheritance"):
 *
 * 1. LOOSE COUPLING - CarComposed just USES Engine thru a clean
 * interface/reference,
 * doesn't care how Engine works internally. Can even swap Engine for a
 * different
 * implementation (like ElectricEngine) easily.
 *
 * 2. MORE FLEXIBLE - you can combine MULTIPLE objects/behaviors freely
 * (Car can HAS-A Engine AND HAS-A GPS AND HAS-A SoundSystem - no
 * "single inheritance" limit)
 *
 * 3. CAN CHANGE AT RUNTIME - you can swap out the composed object dynamically,
 * inheritance relationship is fixed at compile time and can't change
 *
 * class CarFlexible {
 * private Engine engine;
 * CarFlexible(Engine engine) { this.engine = engine; } // inject any engine
 * type
 * void drive() { engine.start(); }
 * }
 * // Later: can pass PetrolEngine, ElectricEngine, anything that fits - true
 * flexibility
 *
 * -----------------------------------------------------------
 * WHEN TO ACTUALLY PREFER EACH:
 *
 * PREFER INHERITANCE when:
 * - There's a genuine, strong "IS-A" relationship (Dog IS-A Animal, truly makes
 * sense)
 * - You want polymorphism - treating different subclasses uniformly thru parent
 * reference
 * - The relationship is unlikely to change, and shared behavior is core to what
 * the class IS
 *
 * PREFER COMPOSITION when:
 * - Relationship is really "HAS-A" or "USES-A", not a true type relationship
 * - You want flexibility to change behavior at runtime
 * - You want to avoid tight coupling to a parent's implementation details
 * - You need to combine behaviors from multiple sources (since no multiple
 * inheritance of classes)
 *
 * Simple real test: say "X is a Y" out loud.
 * - Sounds natural and X truly behaves like a specialized version of Y ->
 * inheritance fine
 * - Sounds forced, or X just "uses"/"contains" Y -> composition is the better
 * choice
 *
 * Interview line: "Inheritance is an IS-A relationship where a subclass extends
 * a parent
 * and automatically gets its behavior, while composition is a HAS-A
 * relationship where a
 * class contains an instance of another class and uses it through its
 * interface. Inheritance
 * creates tight coupling to the parent's implementation and is fixed at compile
 * time, while
 * composition is more flexible - you can swap implementations, combine multiple
 * behaviors,
 * and avoid the fragile base class problem. The general guideline is to favor
 * composition
 * over inheritance unless there's a genuinely strong IS-A relationship where
 * polymorphism
 * is actually needed."
 */

/*
 * Q5: What is the "favor composition over inheritance" principle, and why does
 * it exist?
 * Answer:
 *
 * (This builds directly on Q5 - same core idea, but they want you to explain it
 * as its
 * OWN principle/concept, like a named design guideline you'd quote in
 * interview)
 *
 * WHAT IT MEANS:
 * When designing a class and deciding how to reuse code from another class,
 * prefer
 * using COMPOSITION (HAS-A, containing an object as a field) over INHERITANCE
 * (IS-A,
 * extending a class) - UNLESS there's a genuinely strong, natural "is-a"
 * relationship
 * AND you actually need polymorphism.
 *
 * It's not saying "never use inheritance", it's saying "don't reach for
 * inheritance
 * by default just to reuse code - think if composition fits better first."
 *
 * -----------------------------------------------------------
 * WHY THIS PRINCIPLE EXISTS - the real problems inheritance causes when
 * overused:
 *
 * 1. FRAGILE BASE CLASS PROBLEM
 * If parent class changes its internal implementation (even without changing
 * its
 * public contract), it can silently break subclasses that depended on the old
 * behavior.
 * Child classes are tightly bound to parent's internals, not just its public
 * API.
 */

class Parent {
    void process() {
        step1();
        step2();
    }

    void step1() {
        System.out.println("Parent step1");
    }

    void step2() {
        System.out.println("Parent step2");
    }
}

class Child extends Parent {
    @Override
    void step1() {
        System.out.println("Child custom step1");
    }
    // Child silently depends on process() calling step1() then step2() internally.
    // If Parent later changes process() to call step2() BEFORE step1(), Child
    // breaks,
    // even though Child never touched that code itself.
}

/*
 * 2. INHERITING STUFF YOU DON'T WANT
 * Classic example: in some older designs, Square extends Rectangle (since
 * mathematically a square IS a rectangle), but Rectangle has separate
 * setWidth()
 * and setHeight() methods. Square breaks this - if you setWidth() on a Square,
 * height should also change to keep it a square, but it inherited two
 * independent
 * setters that don't make sense together for a Square's actual behavior.
 * This is called violating the "Liskov Substitution Principle" - subclass
 * should
 * be usable wherever parent is expected, without breaking things.
 *
 * 3. TIGHT COUPLING = HARD TO CHANGE LATER
 * Inheritance relationship is locked in at compile time. If you realize later
 * that
 * the design doesn't fit, refactoring deep inheritance chains is painful and
 * risky.
 * Composition just needs you to swap which object you're holding - way less
 * disruptive.
 *
 * 4. NO MULTIPLE INHERITANCE OF CLASSES
 * If a class needs behavior from TWO different sources, inheritance alone
 * physically cannot do that in Java. Composition can combine as many behaviors
 * as needed since you're just holding multiple object references.
 *
 * -----------------------------------------------------------
 * HOW COMPOSITION AVOIDS THESE PROBLEMS:
 *
 * With composition, a class only depends on another class's PUBLIC
 * methods/interface,
 * not its internal step-by-step logic. So internal changes to the composed
 * class
 * don't ripple out and break anything, as long as the public method signatures
 * stay the same.
 */

class Logger {
    void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}

class OrderService {
    private Logger logger = new Logger(); // composition, OrderService HAS-A Logger

    void placeOrder() {
        logger.log("Order placed");
        // OrderService doesn't care HOW Logger logs internally, just calls log()
        // Logger's internals can change freely without breaking OrderService
    }
}

/*
 * Interview line: "Favor composition over inheritance means when you want to
 * reuse code,
 * default to containing an object as a field (HAS-A) rather than extending a
 * class (IS-A),
 * unless there's a genuinely strong is-a relationship that actually needs
 * polymorphism.
 * It exists because heavy inheritance creates tight coupling to a parent's
 * internal
 * implementation - known as the fragile base class problem - makes it easy to
 * violate
 * Liskov Substitution by inheriting behavior that doesn't truly fit, and locks
 * the
 * relationship at compile time. Composition only depends on the other class's
 * public
 * interface, so internal changes don't break things, and you can combine or
 * swap
 * behaviors much more flexibly."
 */

/*
 * Q6: Explain the difference between static and dynamic binding with an
 * example.
 * Answer:
 *
 * (This connects back to overloading vs overriding stuff from earlier sections,
 * but asked directly as "binding" terminology this time, so know both ways of
 * phrasing it)
 *
 * STATIC BINDING (a.k.a Compile-time binding / Early binding)
 * - The compiler decides WHICH method to call at COMPILE time itself
 * - Happens with: method overloading, private methods, static methods, final
 * methods
 * - Based on the REFERENCE TYPE (declared type), not the actual object
 *
 * DYNAMIC BINDING (a.k.a Runtime binding / Late binding)
 * - The call is resolved at RUNTIME, based on the ACTUAL OBJECT type
 * - Happens with: method overriding (instance methods that are overridden)
 * - This is what makes runtime polymorphism possible
 *
 * -----------------------------------------------------------
 * EXAMPLE showing BOTH together:
 */

class Animal {
    void sound() { // instance method - dynamic binding
        System.out.println("Some generic sound");
    }

    static void staticInfo() { // static method - static binding
        System.out.println("Animal class info");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }

    static void staticInfo() {
        System.out.println("Dog class info");
    }
}

class BindingDemo {
    public static void main(String[] args) {
        Animal a = new Dog();

        a.sound(); // DYNAMIC binding -> "Bark" (decided at runtime, based on actual object = Dog)
        a.staticInfo(); // STATIC binding -> "Animal class info" (decided at compile time, based on
                        // reference type = Animal)
    }
}

/*
 * -----------------------------------------------------------
 * WHY this happens - the core reasoning:
 *
 * a.sound() -> JVM waits until RUNTIME, checks
 * "what object does 'a' actually point to?"
 * -> sees Dog object -> calls Dog's overridden sound(). This is dynamic
 * dispatch, the whole mechanism behind runtime polymorphism.
 *
 * a.staticInfo() -> since its static, there's no "object" involved in the
 * decision at all.
 * Compiler just looks at 'a' being DECLARED as Animal type, and directly
 * binds the call to Animal.staticInfo() at compile time itself.
 * Doesn't even check what 'a' is actually pointing to.
 *
 * -----------------------------------------------------------
 * ANOTHER SIMPLE EXAMPLE - overloading = static binding:
 */

class Calculator {
    void add(int a, int b) {
        System.out.println("int add: " + (a + b));
    }

    void add(double a, double b) {
        System.out.println("double add: " + (a + b));
    }
}

/*
 * Calculator c = new Calculator();
 * c.add(2, 3); // compiler KNOWS at compile time which add() to call (int
 * version)
 * // just by looking at argument types - no object/runtime check needed
 * // this is STATIC binding, resolved purely by method signature matching
 *
 * -----------------------------------------------------------
 * QUICK TABLE to remember:
 *
 * | Static Binding | Dynamic Binding |
 * |--------------------------|---------------------------|
 * | Compile time | Runtime |
 * | Based on reference type | Based on actual object type|
 * | Overloading, static, | Overriding (instance |
 * | private, final methods | methods) |
 * | Faster (decided early) | Slightly slower (decided |
 * | | at runtime, needs lookup) |
 *
 * Interview line: "Static binding resolves which method to call at compile
 * time, based
 * on the reference type - this is what happens with overloading, static
 * methods, private
 * and final methods. Dynamic binding resolves the method call at runtime, based
 * on the
 * actual object type - this is what happens with method overriding, and it's
 * the mechanism
 * that makes runtime polymorphism possible."
 */