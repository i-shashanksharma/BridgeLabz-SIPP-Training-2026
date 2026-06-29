class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    protected final String studentId;
    protected double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Student{studentId='" + studentId + "', gpa=" + gpa + "}";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", GradStudent{thesis='" + thesis + "'}";
    }
}

public class UniversityDemo {
    public static void main(String[] args) {

        Person p = new Person("Amit", 45);
        Student s = new Student("Riya", 20, "S101", 8.5);
        GradStudent g = new GradStudent("Karan", 24, "G202", 9.1, "AI in Healthcare");

        System.out.println(p);
        System.out.println(s);
        System.out.println(g);

        System.out.println("\nDemonstrating IS-A relationship:");
        System.out.println("GradStudent IS-A Student: " + (g instanceof Student));
        System.out.println("Student IS-A Person: " + (s instanceof Person));
    }
}