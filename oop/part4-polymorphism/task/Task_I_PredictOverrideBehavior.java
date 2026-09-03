// Task I (predict-before-run): Same three classes. Before writing any test code, write down on paper/comment: if you create Shape 
// s = new Circle(5); and call s.area(), what runs — and why, given s's declared type is Shape? Then write the test and confirm 
// your prediction.

// ans: here it will run the area defined in the circle. even tho its declared type is shape but at the runtime it checks what 
// actually inside the container(actual object type) i.e circle in this case

class Shape {
    public void area() {
        System.out.println("Shape is not defined");
    }

    public void newArea() {
        System.out.println("Only in shape");
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
        for(Shape shape: arr){
            shape.newArea();
        }

    }
}