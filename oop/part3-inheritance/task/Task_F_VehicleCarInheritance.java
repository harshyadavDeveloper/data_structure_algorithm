// Task F: Create a Vehicle class (private brand, private speed, constructor, getters, a method displayInfo() that prints brand 
// and speed). Create Car extends Vehicle that adds a private numDoors field, a constructor that calls super(...), and a method 
// honk() that prints something using both the inherited brand (via getter) and numDoors. Test in main.
class Vehicle {
    private String brand;
    private int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        System.out.println("Constructor ran for " + brand);
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void displayInfo() {
        System.out.println(brand + " has speed of " + speed);
    }
}

class Car extends Vehicle {
    private int numDoors;

    Car(String brand, int speed, int numDoors) {
        super(brand, speed);
        this.numDoors = numDoors;
        System.out.println("Constructor ran for: " + numDoors);
    }

    public void honk() {
        System.out
                .println(getBrand() + " honks at the speed of " + getSpeed() + " and has total " + numDoors + " doors");
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 200, 4);
        car.honk();

    }
}