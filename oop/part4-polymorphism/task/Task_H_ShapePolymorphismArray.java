// Task H: Build Shape (parent) with a method area() that just prints "Shape area not defined." Build Circle extends Shape 
// (field: radius) and Rectangle extends Shape (fields: width, height), each overriding area() with the correct real formula. In 
// main, create an array of type Shape[] containing one Circle and one Rectangle, loop through it, and call .area() on each — 
// prove to yourself that the right formula runs for each even though the array is typed as Shape[].

class Shape {
    public void area() {
        System.out.println("Shape is not defined");
    }
}

class Circle extends Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle is: " + area);
    }

}

class Rectangle extends Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void area() {
        int area = width * height;
        System.out.println("Area of rectangle is: " + area);
    }
}

class Main {
    public static void main(String[] args) {
        Shape circ = new Circle(4);
        Shape rect = new Rectangle(3, 7);
        Shape newShape = new Shape();

        // circ.area();
        // rect.area();
        // newShape.area();

        Shape[] arr = {
                circ, rect, newShape
        };
        for (Shape shape : arr) {
            shape.area();
        }

    }
}