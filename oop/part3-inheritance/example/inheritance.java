class Main {
    public static void main(String[] args) {
        Dog d = new Dog("Rex", "Bull Dog");
        d.makeSound();
        d.bark();
    }

}

class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor ran for: " + name);
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println(name + " makes generaic animal sound");
    }
}

class Dog extends Animal {
    private String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
        System.out.println("Dog constructor ran for: " + breed);
    }

    public void bark() {
        System.out.println(getName() + " (" + breed + ") says woof!");
    }
}