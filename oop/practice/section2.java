/*
 * Q1: What is OOP, and what are its four pillars?
 * Answer:
 * OOP basically means — instead of writing a bunch of random functions and
 * variables floating around, you organize your code into objects. An object is
 * like a real world thing — it has some data (like a car has color, speed) and
 * some actions it can do (car can start, stop). So you group data + behavior
 * together into a class, and objects are just instances of that class.
 * 
 * 1. Encapsulation — basically hiding your data. You make variables private and
 * only let people access/change them through getters and setters. Real life
 * example: your bank balance — you can't directly change it, you gotta go
 * through proper methods (deposit/withdraw). Protects your data from getting
 * messed up randomly.
 * 
 * 2. Abstraction — showing only what's necessary, hiding the complicated stuff.
 * Like when you drive a car, you just use steering, brake, accelerator — you
 * don't need to know how the engine works internally. In code, that's like
 * using abstract classes/interfaces — you just say
 * "there's a method called startEngine()", you don't expose how it's done
 * internally.
 * 
 * 3. Inheritance — one class can reuse another class's stuff. Like if you have
 * a
 * class Animal, and Dog and Cat extend it — they automatically get whatever's
 * in Animal (like eat(), sleep()) without rewriting it. Saves you from
 * duplicate code. "is-a" relationship — Dog is an Animal.
 * 
 * 3. Polymorphism — same name, different behavior. Two types:
 * Overloading (compile time) — same method name, different parameters. Like
 * add(int,int) and add(int,int,int).
 * Overriding (runtime) — child class changes how a parent's method behaves.
 * Like Animal has sound(), but Dog overrides it to bark, Cat overrides it to
 * meow.
 */

/*
 * Q2: What's the difference between a class and an object?
 * Answer:
 * Class = blueprint/template, doesn't exist in memory as an actual thing, just
 * a design.
 * Object = the real thing created from that blueprint, takes memory, has actual
 * values.
 *
 * Ex: Car is the class. myCar = new Car() -> myCar is the object with real data
 * like color="red", speed=120.
 * You can make many objects from one class - car1, car2, car3 - all different
 * objects, same blueprint.
 *
 * Interview line: "Class is the definition/template, object is the actual
 * instance of that
 * class that exists in memory and holds real values."
 *
 * Extra point: class doesn't take memory until you create an object, memory
 * allocated only on 'new'.
 */

/*
 * Q3: Explain the 'new' keyword in Java? What happens if we don't use it?
 * Answer:
 * 'new' keyword is used to create an object. It does 3 things basically:
 * 1. Allocates memory for the object on the HEAP.
 * 2. Calls the constructor of that class to initialize the object.
 * 3. Returns a reference (address) to that object, which you store in a
 * variable.
 *
 * Ex: Car myCar = new Car();
 * Here 'new Car()' creates the actual object in heap memory, and myCar just
 * holds
 * the reference/address pointing to it. myCar itself is not the object, its a
 * reference variable.
 *
 * What if we don't use 'new'?
 * If you just do: Car myCar; -> this only declares a reference variable, no
 * object is created.
 * It just sits in memory as 'null', pointing to nothing.
 * If you try to call any method or access any field on it without using 'new'
 * first,
 * you'll get a NullPointerException, because there's no actual object, just an
 * empty reference.
 *
 * Interview line: "'new' allocates memory on heap, calls constructor, and gives
 * back a reference.
 * Without it, you only have a reference pointing to null, and using it directly
 * causes NullPointerException."
 */

/*
 * Q4: Explain encapsulation with a real-world example (different one).
 * Answer:
 * Encapsulation = wrapping data + methods together, and hiding the data from
 * outside,
 * only letting it be accessed thru controlled methods (getters/setters).
 *
 * Real world example: ATM Machine
 * When you withdraw cash, you don't directly touch the machine's internal cash
 * storage
 * or database. You just interact with a screen -> enter pin, enter amount,
 * click withdraw.
 * Internally it checks balance, validates pin, updates database - all hidden
 * from you.
 * You never get direct access to the internal logic/data, you only use the
 * exposed interface (buttons/screen).
 *
 * In code terms: internal cash count, account balance = private variables.
 * withdraw(), checkBalance() = public methods that control HOW those private
 * variables are accessed/changed.
 * You can't just directly set balance = 999999, gotta go thru proper method
 * which validates everything first.
 *
 * Interview line: "Encapsulation is like an ATM - you interact only through
 * defined actions
 * (withdraw/deposit), the actual sensitive data (account balance, cash inside)
 * stays hidden and
 * protected, accessible only through controlled methods."
 */

/*
 * Q5: Why does Java not allow multiple inheritance of classes, but allows it
 * for interfaces?
 * Answer:
 * The main reason is the "Diamond Problem".
 *
 * If Java allowed a class to extend 2 classes, and both parent classes have a
 * method
 * with SAME name and signature but DIFFERENT implementation, then compiler gets
 * confused
 * -> which version should the child class inherit? No way to decide ->
 * ambiguity.
 *
 * Ex: ClassA has show() printing "A", ClassB has show() printing "B".
 * If ClassC extends both A and B, and you call show() on ClassC object,
 * java has no idea which show() to pick. That's the diamond problem.
 *
 * Why interfaces are fine with multiple inheritance:
 * Before Java 8 - interfaces only had abstract methods (no body), so no
 * implementation
 * clash was possible, just method signatures, no conflict.
 *
 * After Java 8 - interfaces can have default methods (with body). So
 * technically diamond
 * problem CAN happen here too, but Java solves it by forcing you to override
 * that method
 * in the implementing class if there's a conflict. Compiler gives an error and
 * says
 * "you resolve it yourself" - so it's not silently ambiguous, YOU explicitly
 * decide which one to use.
 *
 * Interview line: "Java avoids multiple inheritance in classes to prevent the
 * diamond problem -
 * ambiguity when two parent classes have same method. Interfaces allow it
 * because either there's
 * no implementation to conflict (abstract methods), or if there is (default
 * methods), Java forces
 * the class to explicitly override and resolve the conflict itself."
 */

/*
 * Q5 (Visual): Diamond Problem
 *
 * ClassA
 * show() -> "A"
 * / \
 * / \
 * ClassB ClassC
 * (extends A) (extends A)
 * show() -> "B" show() -> "C" <-- imagine if this override existed
 * \ /
 * \ /
 * ClassD
 * (extends B, C) <-- NOT ALLOWED in java
 *
 * ClassD obj = new ClassD();
 * obj.show(); --> WHICH show()? B's version or C's version? AMBIGUOUS!
 *
 * That's why Java says "nah" and doesn't let a class extend 2 classes.
 *
 * -----------------------------------------------------------
 *
 * Same shape but with INTERFACES (this IS allowed):
 *
 * InterfaceA
 * default show()
 * / \
 * / \
 * InterfaceB InterfaceC
 * default show() default show()
 * \ /
 * \ /
 * ClassD
 * implements B, C
 *
 * Here Java says "ok fine, but YOU tell me which show() to use" ->
 * forces you to write:
 *
 * public void show() {
 * InterfaceB.super.show(); // explicitly pick one
 * }
 *
 * So ambiguity is resolved by YOU, not left hanging like in class multiple
 * inheritance.
 */

/*
 * Q6: Difference between Method Overloading and Method Overriding
 * Answer:
 *
 * OVERLOADING (compile time / static binding)
 * - Same method name, DIFFERENT parameters (number or type)
 * - Happens in the SAME class
 * - Decided by compiler at COMPILE time (based on method signature)
 * - No need for inheritance
 *
 * void add(int a, int b) {}
 * void add(int a, int b, int c) {}
 * void add(double a, double b) {}
 *
 * OVERRIDING (runtime / dynamic binding)
 * - Same method name, SAME parameters, but implementation changes
 * - Happens between PARENT and CHILD class (needs inheritance)
 * - Decided at RUNTIME (based on actual object type, not reference type)
 *
 * class Animal { void sound() { System.out.println("some sound"); } }
 * class Dog extends Animal { void sound() { System.out.println("bark"); } }
 *
 * -----------------------------------------------------------
 * MEMORY TRICK so you never confuse again:
 *
 * OVER-LOAD -> think "LOAD more stuff into the SAME method name" ->
 * you're loading extra/different PARAMETERS onto one name, same class, same
 * place.
 *
 * OVER-RIDE -> think "RIDE OVER / replace what's already there" ->
 * child class is literally riding over / stepping on top of the parent's method
 * and replacing its behavior. Needs parent-child (inheritance) relationship.
 *
 * Quick check whenever confused, ask yourself 2 questions:
 * 1. Is inheritance involved (parent-child)? -> if YES = overriding, if NO =
 * overloading
 * 2. Are parameters same or different? -> different = overloading, same =
 * overriding
 *
 * Interview line: "Overloading is same method name with different parameters in
 * the same class,
 * resolved at compile time. Overriding is same method same parameters but
 * different
 * implementation in parent vs child class, resolved at runtime based on actual
 * object type."
 */

/*
 * Q7: What is constructor chaining, and why use this(...) vs super(...)?
 * Answer:
 *
 * Constructor chaining = calling one constructor from another constructor.
 * Basically instead of repeating same init code in multiple constructors,
 * you call one constructor from another, so code doesn't get duplicated.
 *
 * this(...) -> calls ANOTHER constructor in the SAME class
 * super(...) -> calls a constructor in the PARENT class
 *
 * Both must be the FIRST line of the constructor if used, and you can only use
 * ONE
 * of them in a single constructor (cant use both this() and super() together).
 *
 * Example with this():
 * class Car {
 * String name;
 * int speed;
 *
 * Car() {
 * this("Default", 100); // calls the constructor below
 * System.out.println("Empty constructor called");
 * }
 *
 * Car(String name, int speed) {
 * this.name = name;
 * this.speed = speed;
 * }
 * }
 * Here Car() doesn't repeat the assignment logic, it just calls Car(String,int)
 * to do it.
 *
 * Example with super():
 * class Animal {
 * Animal(String sound) {
 * System.out.println("Animal makes sound: " + sound);
 * }
 * }
 * class Dog extends Animal {
 * Dog() {
 * super("Bark"); // calls parent Animal's constructor
 * System.out.println("Dog created");
 * }
 * }
 * Here Dog's constructor is telling the parent (Animal) to run its setup first,
 * then continues with its own extra setup.
 *
 * Why you'd use them:
 * - this() -> avoid duplicate code between constructors of the SAME class
 * (constructor overloading scenario)
 * - super() -> make sure parent class's setup/initialization happens before
 * child adds its own stuff.
 * (Also note: if you don't explicitly call super(), Java automatically calls
 * the parent's
 * no-arg constructor first anyway, that's default behavior)
 *
 * Interview line: "Constructor chaining means one constructor calls another to
 * avoid duplicate
 * init code. this() calls another constructor in the same class, super() calls
 * the parent
 * class's constructor - and whichever you use, it has to be the first statement
 * in the constructor."
 */