public class ExerciseMethods {

//** Task 1: Define and Call a Simple Method.
        /*1.1 Define a method called printWelcomeMessage(it should not return anything).*/
public static void printWelcomeMessage() {
        /*1.2 Inside the method, print the welcome message. */
        System.out.println("Welcome to the Java Methods Exercise!");
    }


//** Task 2: Calculate the Sum of Two Numbers.
        /*2.1 Define a method sum(int a, int b).*/
public static int sum(int a, int b) {
        /*2.2 The method should return the sum of a and b. */
        return a + b;
    }


//** Task 3: Convert Celsius to Fahrenheit.
        /*3.1 Define a method convertToFahrenheit(double celsius).*/
public static double convertToFahrenheit(double celsius) {
        /*3.2 The method should return the Fahrenheit value. */
        return (celsius * 9 / 5) + 32;
    }

//** Task 4: Check if a Number is Even or Odd.
        /*4.1 Define a method isEven(int number).*/
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

//** Task 5: Print a String Multiple Times.
        /*5.1 Define a method printMultipleTimes(String text, int times).*/
    public static void printMultipleTimes(String text, int times) {
        /*5.2 Use a for loop to print the text multiple times.*/
        for (int n = times - 1; n >= 0; n--) {
            System.out.println(text);
        }
    }

//** Task 6: Find the Maximum of Three Numbers.
        /*6.1 Define a method findMax(int a, int b, int c).*/
    public static int findMax(int a, int b, int c) {
        /*6.2 Use if statements to determine the largest number*/
        int largestNum;
        if (a > b && a > c) {
            largestNum = a;
        } else if (b > a && b > c) {
            largestNum = b;
        } else {
            largestNum = c;
        }
        /*6.3 Return the largest number.*/
        return largestNum;
    }

//** Task 7: Factorial Using Recursion.
        /*7.1 Define a method factorial(int n).*/
    public static int factorial(int n) {
        /*7.2 Use recursion.*/
        if (n >= 1) {
            return n * factorial(n - 1);
        } else return 1;
    }

//** Task 8: Method Overloading (Greeting Message).
        /*8.1 Method 1: greet(String name) --> Prints "Hello, [name]!"*/
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
        /*8.2 Method 2: greet(String name, int age) --> Prints "Hello, [name]! You are [age] years old."*/
    public static void greet(String name, int age) {
        System.out.printf("Hello, %s! You are %d years old.\n", name, age);
    }

//** Task 9: Count Vowels in a String.
        /*9.1 Define a method countVowels(String text).*/
    public static int countVowels(String text) {
        /*9.2 Use a for loop and if statements to count vowels(a, e, i, o, u).*/
        int a = 0;
        for (int i = 0; i < text.length(); i++) {
            char x = Character.toLowerCase(text.charAt(i));
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                a++;
            }
        }

        /*9.3 Return the count.*/
        return a;
    }

//** Task 10: Mini Calculator.
        /*10.1 Define calculator(int num1, int num2, char operator).*/
    public static int calculator(int num1, int num2, char operator) {
        /*10.2 Use a switch statement for the different operators.*/
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    yield num1;
                } else {
                    yield num1 / num2;
                }
            }
            default -> num1;
        };
    }

//** Bonus Challenge: Palindrome Checker.
        /*Bonus.1 Define isPalindrome that checks if a word is a palindrome (reads the same forward and backward).*/
    public static boolean isPalindrome(String text) {
        /*Bonus.2 Reverse the string and compare it with the original.*/
        String revWord = new StringBuilder(text).reverse().toString();
        /*Bonus.3 Return true if palindrome, false otherwise.*/
        return text.equals(revWord);
    }



    public static void main(String[] args) {
        System.out.println("\n----Task 1: Define and Call a Simple Method----");
        /*1.3 Call this method inside main. */
        printWelcomeMessage();

        System.out.println("\n----Task 2: Calculate the Sum of Two Numbers----");
        /*2.3 Call this method in main with different values and print the results. */
        System.out.println("The sum of 1 and 5 is: " + sum(1, 5));
        System.out.println("The sum of 7 and 3 is: " + sum(7, 3));

        System.out.println("\n----Task 3: Convert Celsius to Fahrenheit----");
        /*3.3 Call the method in main with different values and print the results. */
        System.out.println("38°C converts to " + convertToFahrenheit(38) + "°F.");
        System.out.println("29°C converts to " + convertToFahrenheit(29) + "°F.");

        System.out.println("\n----Task 4: Check if a Number is Even or Odd----");
        /*4.4 Call the method in main with different numbers and print the results.*/
        System.out.println("Is the number 50 even: " + isEven(50));
        System.out.println("Is the number 41 even: " + isEven(41));

        System.out.println("\n----Task 5: Print a String Multiple Times----");
        /*5.3 Call the method in main with different values*/
        printMultipleTimes("five times", 5);
        printMultipleTimes("three times", 3);

        System.out.println("\n----Task 6: Find the Maximum of Three Numbers----");
        /*6.4 Call the method in main with different values and print the results.*/
        System.out.println("With a=1, b=2, and c=3. This is the max value: " + findMax(1,2,3));
        System.out.println("With a=5, b=6, and c=4. This is the max value: " + findMax(5,6,4));
        System.out.println("With a=9, b=7, and c=8. This is the max value: " + findMax(9,7,8));

        System.out.println("\n----Task 7: Factorial Using Recursion----");
        /*7.3 Call the method in main and print results for numbers 5, 7, and 10.*/
        System.out.println("The factorial of 5 is: " + factorial(5));
        System.out.println("The factorial of 7 is: " + factorial(7));
        System.out.println("The factorial of 10 is: " + factorial(10));

        System.out.println("\n----Task 8: Method Overloading (Greeting Message)----");
        /*8.3 Call both methods in main with different arguments.*/
        greet("Joshua");
        greet("Eric", 27);

        System.out.println("\n----Task 9: Count Vowels in a String----");
        /*9.4 Call the method in main and print the result for "hello world" and "java programming".*/
        System.out.println("There are " + countVowels("hello world") + " vowels in 'hello world'.");
        System.out.println("There are " + countVowels("java programming") + " vowels in 'java programming'.");

        System.out.println("\n----Task 10: Mini Calculator----");
        /*10.4 Call it in main with different inputs.*/
        System.out.println("1 plus 2 is: " + calculator(1,2,'+'));
        System.out.println("4 minus 3 is: " + calculator(4,3,'-'));
        System.out.println("5 times 6 is: " + calculator(5,6,'*'));
        System.out.println("8 divided 7 is: " + calculator(8,7,'/'));

        System.out.println("\n----Bonus Challenge: Palindrome Checker----");
        /*Bonus.4 Call the method in main with "racecar" and "hello".*/
        System.out.println("Is 'racecar' a palindrome: " + isPalindrome("racecar"));
        System.out.println("Is 'hello' a palindrome: " + isPalindrome("hello"));
    }
}