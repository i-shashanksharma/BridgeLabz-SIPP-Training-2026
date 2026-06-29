import java.io.*;
public class SchoolResultPortal {
    public static void main(String[] args) {

        try (
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("reportcard.txt", true))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];
                int total = 0;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / (data.length - 1);

                bw.write("Student Name : " + name);
                bw.newLine();
                bw.write("Total Marks  : " + total);
                bw.newLine();
                bw.write("Average Marks: " + String.format("%.2f", average));
                bw.newLine();
                bw.write("--------------------------------");
                bw.newLine();
            }

            System.out.println("Report cards generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("students.txt file not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}