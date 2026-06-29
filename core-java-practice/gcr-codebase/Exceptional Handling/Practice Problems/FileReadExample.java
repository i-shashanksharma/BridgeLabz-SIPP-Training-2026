import java.io.*;
public class FileReadExample {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}