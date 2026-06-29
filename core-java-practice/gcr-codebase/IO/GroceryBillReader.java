import java.io.*;

public class GroceryBillReader {

    public static void main(String[] args) {

        int lineCount = 0;

        try (BufferedReader br =
                     new BufferedReader(new FileReader("bill.txt"))) {

            String line;

            System.out.println("Bill Contents:");
            System.out.println("----------------");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("----------------");
            System.out.println("Total Lines = " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("bill.txt file not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}