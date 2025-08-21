import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input
        System.out.println("Welcome to the Simple Calculator!");
        System.out.print("Enter first number: ");
        double num1 = getValidNumber(sc);

        System.out.print("Enter second number: ");
        double num2 = getValidNumber(sc);

        System.out.print("Choose operation (+, -, *, /): ");
        char operation = sc.next().charAt(0);

        double result;

        // Arithmetic Operations + Data Validation
        switch (operation) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;

            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;

            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed!");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
                break;

            default:
                System.out.println("Invalid operation! Please choose +, -, *, or /.");
        }

        sc.close();
    }

    // Method to ensure valid number input
    public static double getValidNumber(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a number: ");
            sc.next(); // discard invalid input
        }
        return sc.nextDouble();
    }
}
