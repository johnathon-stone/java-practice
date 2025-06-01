import java.util.Scanner;
import java.util.Random;

public class exerciseLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//  Basic Loops Practice
        System.out.println("\n----Basic Loops Practice----\n");

//      1. Count up!(For Loop)
        System.out.println("Count up!(For Loop)\n");

//       1.1 Write a program that prints numbers 1 to 100 using a for loop.
        for (int i=1; i<=100; i++){
            System.out.println(i);
        }
//       1.2 Modify the program to print only even numbers.
        for (int i=2; i<=100; i+=2){
            System.out.println(i);
        }
//      2. Countdown Timer (While Loop)
        System.out.println("Countdown Timer (While Loop)\n");

//       2.1 Prompt the user for a starting number.
        System.out.println("Choose a starting number: ");
        String startingNumSTR = input.nextLine();
        int startingNum = Integer.parseInt(startingNumSTR);

//       2.2 Use a while loop to count down to zero.
        while (startingNum >= 0) {
            System.out.println(startingNum);
            startingNum--;
        }
//       2.3 Print "Blast off!" when it reaches zero.
        System.out.println("Blast off!\n");
//      3. Guess the Number (Do-While Loop)
        System.out.println("Guess the Number (Do-While Loop)\n");

//       3.1 Generate a random number between 1 and 50.
        Random randgen = new Random();
        int randNum = randgen.nextInt(1, 5);
        int numGuess;

//       3.3 Keep asking until the user gets it right using a do-while loop.
        do{
//           3.2 Ask the user to guess the number.
            System.out.println("Guess the number: ");
            String numGuessSTR = input.nextLine();
            numGuess = Integer.parseInt(numGuessSTR);
        } while (numGuess != randNum);
        System.out.println("You got it correct! The number was: " + randNum);

//  Intermediate Loops Challenges
        System.out.println("\n----Intermediate Loops Challenges----\n");

//      1. Multiplication Table (For Loop)
        System.out.println("Multiplication Table (For Loop)\n");

//       1.1 Ask the user for a number.

//       1.2 Print the multiplication table (1 to 10) for that number.

//      2. Password Validator (While Loop)
        System.out.println("Password Validator (While Loop)\n");

//       2.1 Ask the user to enter a password.

//       2.2 Keep asking until they enter the correct password("letmein").

//      3. Find the First Vowel (For Loop)
        System.out.println("Find the First Vowel (For Loop)\n");

//       3.1 Ask the user to enter a word.

//       3.2 Use a for loop to find the first vowel in the word and print its position.

//      4. Simple ATM System (Do-While Loop)
        System.out.println("Simple ATM System (Do-While Loop)\n");

//       4.1 Start with an account balance of $500.

//       4.2 Ask the user if they want to: Withdraw, Deposit, Check Balance, Exit.

//       4.3 Use a do-while loop to keep asking until they choose to exit.

//  Advanced Loops Exercises
        System.out.println("\n----Advanced Loops Exercises----\n");

//      1. FizzBuzz Challenge (For Loop)
        System.out.println("FizzBuzz Challenge (For Loop)\n");

//       1.1 Print numbers from 1 to 100.

//       1.2 If a number is divisible by 3, print "Fizz".

//       1.3 If a number is divisible by 5, print "Buzz".

//       1.4 If a number is divisible by both 3 and 5, print "FizzBuzz".

//      2. Reverse a String (For Loop)
        System.out.println("Reverse a String (For Loop)\n");

//       2.1 Ask the user for a word.

//       2.2 Use a for loop to print it in reverse order.

//      3. Prime Number Checker (While Loop)
        System.out.println("Prime Number Checker (While Loop)\n");

//       3.1 Ask the user for a number.

//       3.2 Use a while loop to check if it's prime.

//      4. Word Counter (For Loop with Split)
        System.out.println("Word Counter (For Loop with Split)\n");

//       4.1 Ask the user for a sentence.

//       4.2 Count the number of words (words are separated by spaces).

//  Break & Continue Challenges
        System.out.println("\n----Break & Continue Challenges----\n");

//      1. Skip Negative Numbers (Continue Statement)
        System.out.println("Skip Negative Numbers (Continue Statement)\n");

//       1.1 Ask the user to enter numbers.

//       1.2 If the number is negative, skip it using continue.

//       1.3 Stop asking if they enter 0.

//      2. Find the First Prime Number (Break Statement)
        System.out.println("Find the First Prime Number (Break Statement)\n");

//       2.1 Ask the user for a range (e.g., 1-100).

//       2.2 User a for loop to find the first prime number in that range.

//       2.3 Stop checking once you find the first prime number.

//  Infinite Loops & Fixing Them
        System.out.println("\n----Infinite Loops & Fixing Them----\n");

//      1. Fix the Infinite Loop
        System.out.println("Fix the Infinite Loop\n");

//       1.1 Fix it so that it stops at 10.

//      2. Even Number Checker (Preventing Infinite Loops)
        System.out.println("Even Number Checker (Preventing Infinite Loops)\n");

//       2.1 Ask the user for an even number.

//       2.2 If they enter an off number, keep asking.

//       2.3 If they enter an even number, exit the loop.

//  Bonus Challenges
        System.out.println("\n----Bonus Challenges----\n");

//      1. Bank Withdrawal System (While Loop)
        System.out.println("Bank Withdrawal System (While Loop)\n");

//       1.1 Start with a balance of $1000.

//       1.2 Ask the user how much they want to withdraw.

//       1.3 If the withdrawal amount is greater than balance, deny the transaction.

//       1.4 Stop when balance reaches 0.

//      2. Find the Longest Word (For Loop)
        System.out.println("Find the Longest Word (For Loop)\n");

//       2.1 Ask the user to enter a sentence.

//       2.2 Find and print the longest word.

//      3. Number Reversal (While Loop)
        System.out.println("Number Reversal (While Loop)\n");

//       1.1 Ask the user for a number.

//       3.2 Reverse the digits and print the reversed number.

//  Final Challenge: Mini Game
        System.out.println("\n----Final Challenge: Mini Game----\n");

//      1. Guess the Word Game (While Loop)
        System.out.println("Guess the Word Game (While Loop)\n");

//       1.1 The computer selects a random word from a list ("apple", "banana", "cherry")

//       1.2 Ask the user to guess the word.

//       1.3 Keep asking until they guess it correctly.

//       1.4 Provide hints if they get it partially correct.

    }
}