import java.util.Scanner;
public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        double areaCm = 0.5 * base * height;
        double baseInches = base / 2.54;
        double heightInches = height / 2.54;
        double areaInches = 0.5 * baseInches * heightInches;
        System.out.println("The Area of the triangle in sq in is "
                + areaInches + " and sq cm is " + areaCm);
    }
}