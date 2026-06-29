import java.io.*;

public class ProductInventoryChecker {

    public static void main(String[] args) {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("inventory.txt"));

            String line;

            System.out.println("Out of Stock Items:");

            while ((line = br.readLine()) != null) {

                String[] data = line.split("-");

                String product = data[0];
                int quantity =
                        Integer.parseInt(data[1]);

                if (quantity == 0) {
                    System.out.println(
                            product +
                            " is out of stock"
                    );
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println(
                    "inventory.txt file not found."
            );
        } catch (IOException e) {
            System.out.println(
                    "Error reading file."
            );
        }
    }
}