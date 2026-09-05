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

        Person s = new Student("Harsh", 24, 36);
        s.displayInfo();
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
