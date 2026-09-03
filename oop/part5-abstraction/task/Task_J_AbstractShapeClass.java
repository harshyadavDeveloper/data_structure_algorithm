package task;

// Task J: Convert your Shape/Circle/Rectangle from Task H into this abstract-class version — make Shape abstract with an 
// abstract area(), add a concrete describe() method in Shape that prints using area() (like the worked example). Confirm in a 
// comment that new Shape() now fails to compile if you try it.

class Main {
    public static void main(String[] args) {
        // Shape newShape = new Shape(); // throws compile error of Cannot instantiate
        // the type Shape
        Shape c = new Circle(5);
        c.describe();

        Shape rec = new Rectangle(3.6, 9.7);
        rec.describe();

    }
}

abstract class Shape {
    abstract double area();

    public void describe() {
        System.out.println("this is a shape with area: " + area());
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double r) {
        this.radius = r;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
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
