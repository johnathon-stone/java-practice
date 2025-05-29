public class ExerciseEnums {

//  Part 1. Define and Use an Enum
//   1. Create an enum named 'CoffeeSize' with three constants.
    enum CoffeeSize {
        SMALL,
        MEDIUM,
        LARGE
}
    public static void main(String[] args) {

//       2. Declare and initialize a variable of type 'CoffeeSize' to store a predefined coffee order.
        CoffeeSize coffeeOrder = CoffeeSize.MEDIUM;

//       3. Print the selected coffee size.
        System.out.println("Selected coffee size: " + coffeeOrder);
    }
}