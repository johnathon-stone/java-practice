import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* Declare and assign variables. */
        String businessName = "Wally World";
        String contactInfo = "789-240-6384";
        int prodID = 1;
        String prodDesc = "The product description";
        int prodCategory = 2;
        double prodCost = 2.56;
        double prodPrice = 4.99;
        int prodQty = 78;
        String taxExempt = null;
        String shipping = null;
        String orderQty = null;
        String promoCode = null;

        /* Get input from user to assign to variables. */
        System.out.println("Are you tax-exempt? (y/n)");
        taxExempt = input.nextLine();
        System.out.println("Shipping? (y/n)");
        shipping = input.nextLine();
        System.out.println("Order quantity? ");
        orderQty = input.nextLine();
        System.out.println("Promo code for free shipping? ");
        promoCode = input.nextLine();

        /* Code to calculate the total cost of the product based on the inventory & print the value. */
        double totalCost = prodCost * prodQty;
        System.out.printf("The total cost for the full inventory of product ID: %d is: $%.2f", prodID, totalCost);

        /* Code to calculate the profit margin of the product & print the value. */
        double perItemProfit = prodPrice - prodCost;
        System.out.printf("%nOur expected profit margin for product ID: %d is: $%.2f", prodID, perItemProfit);

        /* Code to calculate the total potential profit & print the value. */
        double potentialProfit = perItemProfit * prodQty;
        System.out.printf("%nOur expected profit margin for product ID: %d is: $%.2f", prodID, potentialProfit);

        /* Code printing the string variables. */
        System.out.println("Business name: " + businessName);
        System.out.println("Business contact info: " + contactInfo);
        System.out.println("Product description: " + prodDesc);

        System.out.println("\nTax-exempt: " + taxExempt + "\nShipping: " + shipping + "\nOrder quantity: " + orderQty + "\nPromo code: " + promoCode);
    }
}