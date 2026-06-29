import java.io.*;
public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int goodCount = 0;

        System.out.println("Enter 5 feedback messages:");

        for (int i = 1; i <= 5; i++) {

            System.out.print("Feedback " + i + ": ");
            String feedback = br.readLine();

            if (feedback.toLowerCase().contains("good")) {
                goodCount++;
            }
        }

        System.out.println("\nGood Feedback Count = " + goodCount);
    }
}