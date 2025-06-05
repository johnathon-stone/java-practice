import java.util.Scanner;

public class ExerciseExceptionHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*Placeholder for user input.*/
        int age;
        String email;
        int pin;

        /*Age validation loop.*/
        while (true) {
            System.out.print("Enter your age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age > 0 && age < 115) {
                    break;
                } else {
                    System.out.println("Invalid age entered. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }

        /*Email validation loop.*/
        while (true) {
            System.out.print("Enter your email: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Error: Email can't be null.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter your 4-digit PIN: ");

            try {
                pin = Integer.parseInt(scanner.nextLine());
                String pinSTR = String.valueOf(pin);
                if (pinSTR.length() == 4) {
                    break;
                } else {
                    System.out.println("Error: Not a 4 digit integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            } finally {
                System.out.println("Registration Attempt Complete!");
            }
        }


        System.out.println("\nRegistration Successful!");
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("PIN: " + pin);

    }
}
