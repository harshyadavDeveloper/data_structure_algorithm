package oop.practice;

class Main {
    public static void main(String[] args) {
        // BankAccount ba = new BankAccount(100);
        // ba.deposit(30);
        // System.out.println("Balance after deposit " + ba.getBalance());
        // ba.deposit(0);
        // ba.withdraw(80);
        // System.out.println("Balance after withdraw " + ba.getBalance());
        // ba.withdraw(90);
        // ba.withdraw(0);

        // Person s = new Student("Harsh", 24, 36);
        // s.displayInfo();

        // Payment cc = new CreditCardPayment(2000);
        // cc.pay(300);
        // Payment upi = new UpiPayment(500);
        // upi.pay(600);

        // Animal fis = new Fish();
        // Animal bir = new Bird();

        // // Animal[] list = {fis, bir};
        // // for(Animal curr: list){
        // // curr.move();
        // // }
        // Animal[] list = { new Fish(), new Bird() };
        // for (Animal curr : list) {
        // curr.move();
        // }
        Vehicle f1 = new SportsCar("Ferrari", 2, 200);
    }

}

// task 1: BankAccount class: private balance, deposit(amt) rejects ≤0,
// withdraw(amt) rejects if amt > balance or ≤0.
class BankAccount {
    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amt) {
        if (amt <= 0) {
            System.out.println("cannot deposit this amount");
        } else {
            balance += amt;
        }
    }

    public void withdraw(int amt) {
        if (amt > balance) {
            System.out.println("withdraw amount exceeds your current balance");
        } else if (amt <= 0) {
            System.out.println("cannot withdraw the provided amount");
        } else {
            balance -= amt;
        }
    }

}

// task 2: Person (private name, age) → Student extends Person adds rollNo,
// overrides a displayInfo() that also calls super's version inside it (new:
// calling parent's overridden method explicitly via super.method()).
class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("info of this person is Name: " + name + " Age: " + age);
    }
}

class Student extends Person {
    private int rollNo;

    Student(String name, int age, int rollNo) {
        super(name, age);
        this.rollNo = rollNo;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("roll no of this student is " + rollNo);
    }
}

// task 3: Abstract class Payment with abstract pay(
// double amt);
// CreditCardPayment and UpiPayment both implement it differently.
abstract class Payment {

    abstract void pay(double amt);

}

class CreditCardPayment extends Payment {
    private double balance;

    CreditCardPayment(double balance) {
        this.balance = balance;
    }

    @Override
    void pay(double amt) {
        if (amt > balance) {
            System.out.println("Limit exceeded of your credit card");
        } else if (amt == 0) {
            System.out.println("Cannot make this payment");
        } else {
            balance -= amt;
            System.out.println("Current credit card limit after payment: " + balance);
        }
    }

}

class UpiPayment extends Payment {
    private double balance;

    UpiPayment(double balance) {
        this.balance = balance;
    }

    @Override
    void pay(double amt) {
        if (amt > balance) {
            System.out.println("Not enough amount in your account");
        } else if (amt == 0) {
            System.out.println("Cannot make this payment");
        } else {
            balance -= amt;
            System.out.println("Upi balance after the payment is " + balance);
        }

    }
}

// task 4: Interface Movable (move()) implemented by unrelated classes Car and
// Robot — prove interfaces cut across unrelated hierarchies.
interface Movable {
    abstract void move();
}

// class Car implements Movable {

// @Override
// public void move() {
// System.out.println("Car moves in 2 directions");
// }

// }

class Robot implements Movable {

    @Override
    public void move() {
        System.out.println("Robot moves in 4 directions");
    }

}

// task 5: Animal → Bird, Fish both override a move() method differently; loop
// over an Animal[] and call .move() on each.

abstract class Animal {
    abstract void move();
}

class Bird extends Animal {

    @Override
    void move() {
        System.out.println("Bird flies in the air");
    }

}

class Fish extends Animal {

    @Override
    void move() {
        System.out.println("Fish swims in the water");
    }

}

// task 6: Constructor chaining: Vehicle(brand) → Car(brand, doors) →
// SportsCar(brand, doors, topSpeed), three levels deep, each calling
// super(...).
abstract class Vehicle {
    private String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }
}

abstract class Car extends Vehicle {
    private int doors;

    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;

    }
}

class SportsCar extends Car {
    private int topSpeed;

    SportsCar(String brand, int doors, int topSpeed) {
        super(brand, doors);
        this.topSpeed = topSpeed;
        System.out.println(brand + " " + doors + " " + topSpeed);
    }

}
