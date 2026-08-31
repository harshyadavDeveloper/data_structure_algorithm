// Task D: Rebuild your Task B Rectangle class with private fields width and height. Add public getters 
// (getWidth(), getHeight()) and public setters (setWidth(int w), setHeight(int h)) — but the setters must reject any value less than or equal 
// to 0 (print an error message and don't change the field if invalid). Test: create a rectangle, try setting a negative width (should be 
// rejected), try setting a valid width (should succeed), print the area after.

class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(7, 8);
        rec.setWidth(-3); // prints Width cannot be negative
        rec.setWidth(2);
        rec.calculateArea(); // prints Calculated area: 14

    }
}

class Rectangle {
    private int height;
    private int width;

    Rectangle(int startHeight, int startWidth) {
        if (startHeight > 0 && startWidth > 0) {
            this.height = startHeight;
            this.width = startWidth;
        } else {
            System.out.println("Height and width cannot be negative");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int h) {
        if (h > 0) {
            height = h;
        } else {
            System.out.println("Height must be greater than 0");
        }
    }

    public void setWidth(int w) {
        if (w > 0) {
            width = w;
        } else {
            System.out.println("Width must be greater than 0");
        }
    }

    public void calculateArea() {
        int area = height * width;
        System.out.println("Calculated area: " + area);
    }

}