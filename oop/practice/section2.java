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