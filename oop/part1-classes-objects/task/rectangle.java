// Task B: Build a Rectangle class with fields int width and int height, a constructor, and a method calculateArea() that 
// returns width * height. Create two rectangles, print both their areas.


// Task C (a small twist): Add a second constructor to your Rectangle class — one that takes no arguments at all, and defaults 
// width and height to 1 each (this is called constructor overloading — having multiple constructors with different parameter 
// lists, and Java picks the right one based on what you pass when you write new Rectangle(...)). Test both constructors — new 
// Rectangle(4, 5) and new Rectangle() — and confirm the second one correctly defaults to a 1×1 rectangle.

class Main{
    public static void main(String[] args){
        Rectangle rec1 = new Rectangle(6, 8);
        Rectangle rec2 = new Rectangle(4, 5);
        Rectangle rec3 = new Rectangle();


        rec1.calculateArea();
        rec2.calculateArea();
        rec3.calculateArea();
    }
}

class Rectangle{
    int height;
    int width;

    Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    }
    Rectangle(){
        this.height = 1;
        this.width = 1;
    }

    void calculateArea(){
        int area = height*width;
        System.out.println("Total Area: "+ area);
    }
}