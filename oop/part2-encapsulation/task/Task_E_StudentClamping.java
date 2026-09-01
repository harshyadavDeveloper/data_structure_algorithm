// Task E: Student class with private name and marks (0–100). Constructor clamps invalid marks to the nearest valid bound (not 
// reject — e.g. -5 becomes 0, 150 becomes 100). Getters for both fields. A printReport() method.

class Main {
    public static void main(String[] args) {
        Student stud = new Student("Harsh", 150);
        System.out.println("Student Name: "+ stud.getName());
        System.out.println("Obtained Marks: "+ stud.getMarks());
        stud.printReport();

    }
}

class Student {
    private String name;
    private int marks;

    Student(String name, int obtainedMarks) {
        this.name = name;
        if (obtainedMarks < 0) {
            this.marks = 0;
        } else if (obtainedMarks > 100) {
            this.marks = 100;
        } else {
            this.marks = obtainedMarks;
        }

    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void printReport() {
        System.out.println(name + " scored " + marks);
    }
}