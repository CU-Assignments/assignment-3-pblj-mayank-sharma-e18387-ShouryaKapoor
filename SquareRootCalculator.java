import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        try {
            double num = Double.parseDouble(sc.nextLine());

            if (num < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
            }

            double result = Math.sqrt(num);
            System.out.println("Square root: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
