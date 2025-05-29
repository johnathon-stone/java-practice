public class ExerciseEnums {

//  Part 1. Define and Use an Enum
//   p1.1. Create an enum named 'CoffeeSize' with three constants.
    enum CoffeeSize {
        SMALL,
        MEDIUM,
        LARGE
}

//  Part 2. Convert Enums to integer Values
//   p2.1. Create an enum named SeatSection with values.
    enum SeatSection {
        GENERAL,
        PREMIUM,
        VIP
}

    public static void main(String[] args) {

//       p1.2. Declare and initialize a variable of type 'CoffeeSize' to store a predefined coffee order.
        CoffeeSize coffeeOrder = CoffeeSize.MEDIUM;

//       p1.3. Print the selected coffee size.
        System.out.printf("Selected coffee size: %s\n\n", coffeeOrder);

//       p2.2. Print each section's corresponding integer value using the 'ordinal()' method.
        SeatSection sectionG = SeatSection.GENERAL;
        SeatSection sectionP = SeatSection.PREMIUM;
        SeatSection sectionV = SeatSection.VIP;

        System.out.println(sectionG + " is assigned value: " + sectionG.ordinal());
        System.out.println(sectionP + " is assigned value: " + sectionP.ordinal());
        System.out.println(sectionV + " is assigned value: " + sectionV.ordinal());
    }
}