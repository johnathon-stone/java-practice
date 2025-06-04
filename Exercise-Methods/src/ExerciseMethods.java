public class ExerciseMethods {

//** Task 1: Define and Call a Simple Method.
        /*1.1 Define a method called printWelcomeMessage(it should not return anything).*/
public static void printWelcomeMessage() {
        /* 1.2 Inside the method, print the welcome message. */
        System.out.println("Welcome to the Java Methods Exercise!");
    }


//** Task 2: Calculate the Sum of Two Numbers.
        /*2.1 Define a method sum(int a, int b).*/
public static int sum(int a, int b) {
        /* 2.2 The method should return the sum of a and b. */
        return a + b;
    }


//** Task 3: Convert Celsius to Fahrenheit.
        /*3.1 Define a method convertToFahrenheit(double celsius).*/
public static double convertToFahrenheit(double celsius) {
        /* 3.2 The method should return the Fahrenheit value. */
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        /* 1.3 Call this method inside main. */
        printWelcomeMessage();

        /* 2.3 Call this method in main with different values and print the results. */
        System.out.println(sum(1, 5));
        System.out.println(sum(7, 3));

        /* 3.3 Call the method in main with different values and print the results. */
        System.out.println("38°C converts to " + convertToFahrenheit(38) + "°F.");
        System.out.println("29°C converts to " + convertToFahrenheit(29) + "°F.");

    }
}