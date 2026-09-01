class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public void paycheck() {
        System.out.println(name + " gets base salary");
    }
}

class Manager extends Employee {
    Manager(String name) {
        super(name);
    }

    @Override
    public void paycheck() {
        System.out.println(name + " gets base salary + bonus");

    }
}

class Salesperson extends Employee {
    Salesperson(String name) {
        super(name);
    }

    @Override
    public void paycheck() {
        System.out.println(name + " gets base salary + comission");
    }
}

class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Harsh");
        Employee e2 = new Manager("John");
        Employee e3 = new Salesperson("Jane");

        e1.paycheck();
        e2.paycheck();
        e3.paycheck();
    }
}