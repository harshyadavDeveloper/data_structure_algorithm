class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Trex", 2);
        Dog dog2 = new Dog("Bella", 7);

        dog1.bark(); // Trex says woof!

        dog2.bark(); // Bella says woof!

        System.out.println(dog1.age); // 2
        System.out.println(dog2.age); // 7

    }
}

class Dog {
    String name;
    int age;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;

    }

    void bark() {
        System.out.println(name + " says woof!");
    }
}