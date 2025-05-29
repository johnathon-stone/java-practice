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

//  Part 3. Convert Integer to Enum
//   p3.1. Create an enum named 'TrafficLight' with values.
    enum TrafficLight {
        RED,
        YELLOW,
        GREEN
}

    //  Part 4. Weekday Schedule
//   p4.1. Create an enum named 'Weekday' with values.
    enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
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
        System.out.printf("%s is assigned value: %d%n%n", sectionV, sectionV.ordinal());

//       p3.2. Store all values in an array using 'values()'.
        TrafficLight[] signals = TrafficLight.values();

//       p3.3. Retrieve the correct signal based on a predefined index '(1 for YELLOW)'.
        TrafficLight color = signals[1];

//       p3.4. Print the selected signal.
        System.out.println("Traffic light signal: " + color);

//       p4.2. Declare a predefined workday 'WEDNESDAY' and print it.
        Weekday workday = Weekday.WEDNESDAY;
        System.out.println("\nWorkday selected: " + workday);

//       p4.3. Check if the workday falls on a weekend 'SATURDAY or SUNDAY'.
        boolean isWeekend = workday.equals(Weekday.SATURDAY) || workday.equals(Weekday.SUNDAY);

//       p4.4. Print if it is a workday or weekend.
        System.out.println("Is it a weekend? " + isWeekend);
    }
}