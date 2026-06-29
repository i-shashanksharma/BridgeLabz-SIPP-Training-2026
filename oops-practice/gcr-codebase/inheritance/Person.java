class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }
}

class Student extends Person {
    final int studentId;
    double gpa;

    Student(String name, int age, int studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() + "\nStudent ID: " + studentId + "\nGPA: " + gpa;
    }
}

class GradStudent extends Student {
    String thesis;

    GradStudent(String name, int age, int studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    public String toString() {
        return super.toString() + "\nThesis: " + thesis;
    }

    public static void main(String[] args) {
        GradStudent g = new GradStudent("Rahul", 24, 101, 9.2, "Artificial Intelligence");
        System.out.println(g);
        System.out.println(g instanceof Student);
        System.out.println(g instanceof Person);
    }
}