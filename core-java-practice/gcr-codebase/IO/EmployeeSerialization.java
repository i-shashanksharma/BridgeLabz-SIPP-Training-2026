import java.io.*;
import java.util.Scanner;
public class EmployeeSerialization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, dept, salary);

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("employee.dat"));

            oos.writeObject(emp);
            oos.close();

            System.out.println("\nEmployee Serialized Successfully.");

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("employee.dat"));

            Employee recovered =
                    (Employee) ois.readObject();

            ois.close();

            System.out.println("\nRecovered Employee Information:");
            recovered.display();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}