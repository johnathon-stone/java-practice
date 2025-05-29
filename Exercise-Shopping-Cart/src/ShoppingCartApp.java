public class ShoppingCartApp {
    public static void main(String[] args) {

//       1. Declare and assign numeric variables
        int productID = 1;
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

//       2. Write code to calculate the total cost of the product based on the inventory & print the value
        double totalCost = productCost * productQuantity;
        System.out.printf("The total cost for the full inventory of product ID: %d is: $%.2f", productID, totalCost);

//       3. Write code to calculate the profit margin of the product & print the value
        double perItemProfit = productPrice - productCost;
        System.out.printf("%nOur expected profit margin for product ID: %d is: $%.2f", productID, perItemProfit);

//       4. Write code to calculate the total potential profit & print the value
        double potentialProfit = perItemProfit * productQuantity;
        System.out.printf("%nOur expected profit margin for product ID: %d is: $%.2f", productID, potentialProfit);
    }
}