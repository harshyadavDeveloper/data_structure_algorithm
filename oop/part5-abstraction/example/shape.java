package example;

abstract class Shape {
    // abstract method — no body, subclasses MUST override this
    abstract double area();

    // a normal concrete method - shared, inherited as-is, no override required
    public void describe() {
        System.out.println("This is a shape with area: " + area());
        // notice: describe calls area(), but WHICH area() runs depends
        // on the actual object,
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        double area = Math.PI * radius * radius;
        System.out.println("area of circle is: " + area);
        return area;
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
        double area = height * width;
        System.out.println("area of rectangle is: " + area);
        return area;
    }
}

class Main {
    public static void main(String[] args) {
        // Shape newShape = new Shape(); throws complie error Cannot instantiate the
        // type Shape
        Shape c = new Circle(5);
        c.describe();

        Shape r = new Rectangle(4, 8.9);
        r.area();
        r.describe();
    }
}