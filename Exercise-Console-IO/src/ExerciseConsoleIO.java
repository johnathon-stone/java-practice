import java.util.Scanner;

public class ExerciseConsoleIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//      Step 1. Ask the user for their name.
        System.out.println("What is your name? ");
        String name = input.nextLine();
        System.out.printf("\nHello, %s! Let's get started with you order.", name);

//      Step 2. Get product details.
        System.out.println("What product would you like to purchase? ");
        String productName = input.nextLine();
        System.out.printf("\nHow many %s would you like to buy? ", productName);
        String productQuantitySTR = input.nextLine();
        int productQuantity = Integer.parseInt(productQuantitySTR);
        System.out.printf("\nWhat is the unit price of %s? ", productName);
        String productPriceSTR = input.nextLine();
        double productPrice = Double.parseDouble(productPriceSTR);
//      Step 3. Calculate total price.
        double subtotal = productQuantity * productPrice;
        double tax = subtotal * 0.07;
        double grandTotal = subtotal + tax;

//      Step 4. Print a formatted receipt.
        System.out.println("\nOrder Summary");
        System.out.println("-----------------------------");
        System.out.printf("\nItem:                   %s\n", productName);
        System.out.printf("\nQuantity:               %s\n", productQuantity);
        System.out.printf("\nUnit Price:            $%s\n", productPrice);
        System.out.println("-----------------------------");
        System.out.printf("\nSubtotal:              $%.2f\n", subtotal);
        System.out.printf("\nTax %s:                 %.2f\n", "7%",tax);
        System.out.printf("\nGrand Total:           $%.2f\n", grandTotal);
        System.out.println("-----------------------------");
        System.out.printf("\nThank you for your order, %s", name);
    }
}