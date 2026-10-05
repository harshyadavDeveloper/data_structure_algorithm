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