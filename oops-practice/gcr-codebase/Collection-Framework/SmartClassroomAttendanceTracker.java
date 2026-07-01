import java.util.*;
public class SmartClassroomAttendanceTracker {

    static HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    static void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (!students.contains(student)) {
            students.add(student);
            System.out.println(student + " marked present in " + subject);
        } else {
            System.out.println("Duplicate Attendance Not Allowed.");
        }
    }

    static void displayAttendance() {
        System.out.println("Attendance Record");

        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);

            System.out.println("Subject: " + subject);

            for (String student : students)
                System.out.println(student);

            System.out.println("Total Students = " + students.size());
        }
    }

    public static void main(String[] args) {
        markAttendance("Java", "Rahul");
        markAttendance("Java", "Amit");
        markAttendance("Java", "Rahul");

        markAttendance("Python", "Priya");
        markAttendance("Python", "Rahul");

        displayAttendance();
    }
}