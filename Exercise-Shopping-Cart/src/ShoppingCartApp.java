public class ShoppingCartApp {
    public static void main(String[] args) {

        /* Declare and assign variables. */
        String businessName = "Wally World";
        String contactInfo = "789-240-6384";
        int productID = 1;
        String prodDesc = "The product description";
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

        /* Code to calculate the total cost of the product based on the inventory & print the value. */
        double totalCost = productCost * productQuantity;
        System.out.printf("The total cost for the full inventory of product ID: %d is: $%.2f", productID, totalCost);

        /* Code to calculate the profit margin of the product & print the value. */
        double perItemProfit = productPrice - productCost;
        System.out.printf("%nOur expected profit margin for product ID: %d is: $%.2f", productID, perItemProfit);

        /* Code to calculate the total potential profit & print the value. */
        double potentialProfit = perItemProfit * productQuantity;
        System.out.printf("%nOur expected profit margin for product ID: %d is: $%.2f", productID, potentialProfit);

        /* Code printing the string variables. */
        System.out.println("Business name: " + businessName);
        System.out.println("Business contact info: " + contactInfo);
        System.out.println("Product description: " + prodDesc);
    }
}