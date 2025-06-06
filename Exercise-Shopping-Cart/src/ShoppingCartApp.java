import java.util.Scanner;

public class ShoppingCartApp {

    /*Method used to print an array.*/
    public static void displayChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    /*Method used to print prompt, gather, validate, and return integer input from user.*/
    private static int promptUserForInt(String prompt) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        boolean isValid = false;
        int result = -1;
        while (!isValid) {
            System.out.println(prompt);
            try {
                result = Integer.parseInt(input.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return result;
    }

    /*Method used to print prompt, gather, and return string input from user.*/
    private static String promptUserForString(String prompt) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println(prompt);
        return input.nextLine();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* Declare and assign variables. */
        boolean isConfirmed = false;
        String taxExempt = null;
        String shipping = null;
        int orderQty = 0;
        String promoCode = null;

        /*Enum assigned values.*/
        enum OrderStatus {
            PENDING, PROCESSING, SHIPPED, DELIVERED
        }

        enum ShippingStatus {
            STANDARD, TWO_DAY, OVERNIGHT
        }

        String[] addresses = {"123 Main St", "456 1st Street", "789 23rd Street"};
        String[] sizes = {"small", "medium", "large"};

        /* While loops to continue to get valid input from user to assign to variables. */
        while (!isConfirmed) {
            String address = null;
            String size = null;
            taxExempt = promptUserForString("Are you tax-exempt? (y/n)");
            while (address == null) {
                try {
                    displayChoices(addresses);
                    int addressIndex = promptUserForInt("Shipping address?") - 1;
                    address = addresses[addressIndex];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid menu option.");
                }
            }

            shipping = promptUserForString("Shipping? (standard/overnight/twoday)");
            while (size == null) {
                try {
                    displayChoices(sizes);
                    int sizeIndex = promptUserForInt("Sizes?") - 1;
                    size = sizes[sizeIndex];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid menu option.");
                }
            }

            orderQty = promptUserForInt("Order quantity?");
            promoCode = promptUserForString("Promo code for free shipping? ");
            System.out.println("\n----Details----");
            System.out.println("Tax-exempt: " + taxExempt);
            System.out.println("Address: " + address);
            System.out.println("Shipping: " + shipping);
            System.out.println("Size: " + size);
            System.out.println("Order quantity: " + orderQty);
            System.out.println("Promo code: " + promoCode);
            System.out.println("Confirm order y/n: ");
            isConfirmed = "y".equals(input.nextLine());
        }
        System.out.println("\nGoodbye.");
    }
}