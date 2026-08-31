// Task A: Build a Car class with fields String model and int year, a constructor to set both, and a method displayInfo() that 
// prints something like "2020 Corolla". Create two different Car objects with different values, call displayInfo() on both.
class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Corolla", 1999);
        Car car2 = new Car("Toyota", 2005);

        car1.displayInfo();
        car2.displayInfo();

    }
}

class Car {
    String model;
    int year;

    Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    void displayInfo() {
        System.out.println(year + " " + model);
    }
}