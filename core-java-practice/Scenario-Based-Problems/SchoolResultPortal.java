import java.io.*;
import java.util.*;
public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "reportcards.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                double sum = 0;

                for (int i = 1; i < data.length; i++) {
                    sum += Double.parseDouble(data[i].trim());
                }

                double average = sum / (data.length - 1);

                writer.write("Student: " + name);
                writer.newLine();
                writer.write("Average Marks: " + String.format("%.2f", average));
                writer.newLine();
                writer.write("--------------------------");
                writer.newLine();
            }

            System.out.println("Report cards generated successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format in input file.");
        }
    }
}