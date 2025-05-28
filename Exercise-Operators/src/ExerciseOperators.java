public class ExerciseOperators {
    public static void main(String[] args) {
//       Finance - Loan Payment Calculator
//       Declare and initialize variables
        double loanAmount = 25000.00;
        double annualInterestRate = 5.5;
        int loanTermYears = 5;
        double monthlyPayment = (loanAmount*(annualInterestRate/100)/12); // Wording in the documentation imples this when it only calculates for 12 months

//       1. Use Assignment Operators
        loanAmount += 5000.00;
        annualInterestRate -= 1.0;
        loanTermYears++;

//       2. Use Comparison Operators
        boolean isLoanAmountHigh = loanAmount > 30000;
        boolean isMonthlyPaymentHigh = monthlyPayment > 500;

//       3. Use Logical Operators
        boolean isLoanAffordable = monthlyPayment < 500 && loanTermYears > 3;
        boolean isLoanExpensive = monthlyPayment > 700 || annualInterestRate > 6;

//       4. Print all results
        System.out.printf("Current Loan Amount: $%.2f\n", loanAmount);
        System.out.printf("Current Annual Interest Rate: %.1f%%", annualInterestRate);
        System.out.printf("Loan Term: %d years\n", loanTermYears);
        System.out.printf("Total Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.println("Does loan amount exceed $30,000.00: " + isLoanAmountHigh);
        System.out.println("Does monthly payment exceed $500.00: " + isMonthlyPaymentHigh);
        System.out.println("Is the loan affordable: " + isLoanAffordable);
        System.out.println("Is the loan expensive: " + isLoanExpensive);

//       Weather - Temperature Conversion & Forecast Analysis
//       Declare and Initialize Variables
        double temperatureCelsius = 25.0;
        boolean isRaining = false;
        int windSpeedKmh = 10;

//       1. Convert Celsius to Fahrenheit using the formula
        double temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;

//       2. Use Assignment Operators
        temperatureCelsius += 5;
        windSpeedKmh += 5;

//       3. Use Logical Operators
        boolean isTempWarm = temperatureFahrenheit > 85;
        boolean isItWindy = windSpeedKmh > 20;

//       4. Use Logical Operators
        boolean isGoodForOutside = isRaining != true && temperatureFahrenheit > 60 && temperatureFahrenheit < 85;
        boolean isWeatherWarning = windSpeedKmh > 30 || temperatureCelsius < 0;

//       5. Print the results in a readable format
        System.out.printf("\nCurrent temperature in Celsius is: %.1f°C\n", temperatureCelsius);
        System.out.println("Is it raining outside: " + isRaining + ".");
        System.out.printf("Current temperature in Fahrenheit is: %.1f°F\n", temperatureFahrenheit);
        System.out.printf("Current wind speed is: %d km/h\n", windSpeedKmh);
        System.out.println("Is the temperature in Fahrenheit above 85°F: " + isTempWarm);
        System.out.println("Is the wind speed greater than 20 km/h: " + isItWindy);
        System.out.println("Is it a good day to go outside: " + isGoodForOutside);
        System.out.printf("Is there a weather warning: %b", isWeatherWarning);

//       Gaming - Player Score and Level Up System
//       Declare and initialize variables // Documentation isn't clear on if we are allowed to add additional variables to make things function?
        int currentXP = 1200;
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp = false;
//        boolean isQuestCompleted = true;  // Variable isn't outlined in the documentation.
//        boolean isDoubleXP = true;  // Variable isn't outlined in the documentation.

//       1. Use Arithmetic Operators  // Commented this section out so it still runs.
//        if (isQuestCompleted) {  // The way the wording in the documentation currently is implying this is required.
//            currentXP += 300;
//            xpToNextLevel -= 300;
//        }
//
//        if (isDoubleXP) {  // The way the wording in the documentation currently is implying this is required.
//            currentXP *= 2;
//        }

//       2. Use Comparison Operators
        boolean isCurrentXP = currentXP >= xpToNextLevel;
        boolean isLevelTen = level >= 10;

//       3. Use Logical Operators
        boolean isLevelUpStatus = xpToNextLevel <= 0 && level > 10;
        boolean isPlayerPro = level > 7 || currentXP > 5000;

//       4. Print the updated values and level-up status
        System.out.println("Current XP: " + currentXP + "XP");
        System.out.println("Current level: LVL" + level);
        System.out.println("XP required for next level: " + xpToNextLevel + " XP");
        System.out.println("Has the player leveled up: " + levelUp);
        System.out.println("Is the current XP great or equal to get another level: " + isCurrentXP);
        System.out.println("Has the player reached level 10: " + isLevelTen);
        System.out.println("Does the player levels up: " + isLevelUpStatus);
        System.out.println("Is the player a pro: " + isPlayerPro);
    }
}
