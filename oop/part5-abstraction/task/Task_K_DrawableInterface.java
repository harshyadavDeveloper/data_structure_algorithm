package task;

// Task K (interface, new territory): Create an interface Drawable with one method signature: void draw();. Make Circle implements 
// Drawable (in addition to extending Shape) with a draw() that prints something like "Drawing a circle with radius X". Test: 
// create a Circle, call both .area()-related behavior and .draw().

class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.describe();
        c.draw();

    }
}

interface Drawable {
    abstract void draw();

}

abstract class Shape {
    abstract double area();

    public void describe() {
        System.out.println("This is shape with area: " + area());
    }
}

class Circle extends Shape implements Drawable {
    private double radius;

    Circle(double r) {
        this.radius = r;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

class Rectangle extends Shape {
    private double height, width;

    Rectangle(double h, double w) {
        this.height = h;
        this.width = w;
    }

    @Override
    double area() {
        return height * width;
    }

}
