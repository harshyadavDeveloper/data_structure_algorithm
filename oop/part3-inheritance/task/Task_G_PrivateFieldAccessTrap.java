// Task G (the trap, on purpose): Same Vehicle/Car setup, but this time try to access the parent's private field directly from 
// inside Car (no getter) and see what Java tells you. Write down in a comment exactly what the compiler error says and why it 
// happens — then fix it properly using the getter. This one's about proving the access rule to yourself, not about the "correct" 
// final code.
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
        System.out.println(getBrand()); // The field Vehicle.brand is not visible. it happens because brand is a private
                                        // field that cannot be accessed by any other class directly but can be accessed
                                        // using a getter
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 200, 4);
        car.honk();

    }
}