import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    private static final int correctPIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int enteredPIN = Integer.parseInt(sc.nextLine());

            if (enteredPIN != correctPIN) {
                throw new InvalidPINException("Invalid PIN entered.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = Double.parseDouble(sc.nextLine());

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Current Balance: " + balance);

        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter numeric values.");
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }
}
