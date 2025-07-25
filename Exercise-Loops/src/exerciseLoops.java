import java.util.Scanner;
import java.util.Random;

public class exerciseLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//**  Basic Loops Practice
        System.out.println("\n----Basic Loops Practice----\n");

//*      1. Count up!(For Loop)
        System.out.println("Count up!(For Loop)\n");

//       1.1 Write a program that prints numbers 1 to 100 using a for loop.
        for (int i=1; i<=100; i++){
            System.out.println(i);
        }
//       1.2 Modify the program to print only even numbers.
        for (int i=2; i<=100; i+=2){
            System.out.println(i);
        }

//*      2. Countdown Timer (While Loop)
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

//*      3. Guess the Number (Do-While Loop)
        System.out.println("Guess the Number (Do-While Loop)\n");

//       3.1 Generate a random number between 1 and 50.
        Random randgen = new Random();
        int randNum = randgen.nextInt(1, 50);
        int numGuess;
//       3.3 Keep asking until the user gets it right using a do-while loop.
        do {
//           3.2 Ask the user to guess the number.
            System.out.println("Guess the number: ");
            String numGuessSTR = input.nextLine();
            numGuess = Integer.parseInt(numGuessSTR);
            if (numGuess < randNum) {
                System.out.println("Higher. Try again.");
            } else if (numGuess > randNum) {
                System.out.println("Lower. Try again.");
            }
        } while (numGuess != randNum);
        System.out.println("You got it correct! The number was: " + randNum);

//**  Intermediate Loops Challenges
        System.out.println("\n----Intermediate Loops Challenges----\n");

//*      1. Multiplication Table (For Loop)
        System.out.println("Multiplication Table (For Loop)\n");

//       1.1 Ask the user for a number.
        System.out.println("Give me a number: ");
        String multiNumSTR = input.nextLine();
        int multiNum = Integer.parseInt(multiNumSTR);
//       1.2 Print the multiplication table (1 to 10) for that number.
        for (int i=1; i<=10; i++) {
            int solution = multiNum * i;
            System.out.printf("\n%d mutliplied by %d = %d\n", multiNum, i, solution);
        }

//*      2. Password Validator (While Loop)
        System.out.println("Password Validator (While Loop)\n");

        String passwd = "";
//       2.2 Keep asking until they enter the correct password("letmein").
        while (!passwd.equals("letmein")) {
//           2.1 Ask the user to enter a password.
            System.out.println("Enter the correct password: ");
            passwd = input.nextLine();
            if (passwd.equals("letmein")) {
                System.out.println("You got it correct! The password was letmein.");
                break;
            }
        }

//*      3. Find the First Vowel (For Loop)
        System.out.println("Find the First Vowel (For Loop)\n");

//       3.1 Ask the user to enter a word.
        System.out.println("Enter a word: ");
        String firstVowel = input.nextLine();
//       3.2 Use a for loop to find the first vowel in the word and print its position.
        for (int i = 0; i < firstVowel.length(); i++) {
            char x = Character.toLowerCase(firstVowel.charAt(i));
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                System.out.println("The first vowel " + firstVowel.charAt(i) + " was found at position: " + i);
                break;
            }
        }

//*      4. Simple ATM System (Do-While Loop)
        System.out.println("Simple ATM System (Do-While Loop)\n");

//       4.1 Start with an account balance of $500.
        double acctBalance = 500;
        int menuSelection;
//       4.3 Use a do-while loop to keep asking until they choose to exit.
        do {
//       4.2 Ask the user if they want to: Withdraw, Deposit, Check Balance, Exit.
            System.out.println("----ATM Menu Selection----");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Select an option 1-4: ");
            String menuSelectionSTR = input.nextLine();
            menuSelection = Integer.parseInt(menuSelectionSTR);

            switch (menuSelection) {
                case 1:
                    System.out.println("Here is your current balance: $" + acctBalance);
                    System.out.println("Enter how much would you like to withdraw: $");
                    String withdrawAmntSTR = input.nextLine();
                    double withdrawAmnt = Double.parseDouble(withdrawAmntSTR);
                    if (withdrawAmnt <= 0) {
                        System.out.println("Amount needs to be larger than 0.");
                    } else if (withdrawAmnt > acctBalance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        acctBalance -= withdrawAmnt;
                        System.out.println("Success! Your new balance is: $" + acctBalance);
                    }
                    break;

                case 2:
                    System.out.println("Enter an amount to deposit: $");
                    String depoAmntSTR = input.nextLine();
                    double depoAmnt = Double.parseDouble(depoAmntSTR);
                    if (depoAmnt <= 0) {
                        System.out.println("Amount needs to be larger than 0.");
                    } else {
                        acctBalance += depoAmnt;
                        System.out.println("Success! Your new balance is: $" + acctBalance);
                    }
                    break;

                case 3:
                    System.out.println("The current balance is: $" + acctBalance);
                    break;

                case 4:
                    System.out.println("Thank you. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection. Choose 1-4 please.");
            }
        } while (menuSelection != 4);

//**  Advanced Loops Exercises
        System.out.println("\n----Advanced Loops Exercises----\n");

//*      1. FizzBuzz Challenge (For Loop)
        System.out.println("FizzBuzz Challenge (For Loop)\n");

//       1.1 Print numbers from 1 to 100.
        for (int i = 1; i<=100; i++){
            if (i % 3 == 0 && i % 5 == 0) {
//               1.4 If a number is divisible by both 3 and 5, print "FizzBuzz".
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
//               1.2 If a number is divisible by 3, print "Fizz".
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
//               1.3 If a number is divisible by 5, print "Buzz".
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

//*      2. Reverse a String (For Loop) !* Issue somewhere in the code not stopping to get user input *!
        System.out.println("\nReverse a String (For Loop)\n");

//       2.1 Ask the user for a word.
        System.out.println("Input a word to print in reverse: ");
        String revWord = input.nextLine();
//       2.2 Use a for loop to print it in reverse order.
        for (int i = revWord.length() - 1; i >= 0; i--) {
            System.out.println(revWord.charAt(i));
        }

//*      3. Prime Number Checker (While Loop)
        System.out.println("Prime Number Checker (While Loop)\n");


//       3.2 Use a while loop to check if it's prime.
        while (true) {
//           3.1 Ask the user for a number.
            System.out.println("Enter a number to check if it's prime: ");
            String numPrimeSTR = input.nextLine();
            int numPrime = Integer.parseInt(numPrimeSTR);
            if (numPrime <= 1) {
                System.out.println(numPrime + " is not prime.");
            } else {
                boolean primeCheck = true;
                int i = 2;
                while (i <= Math.sqrt(numPrime)) {
                    if (numPrime % i == 0) {
                        primeCheck = false;
                        break;
                    } i++;
                } if (primeCheck) {
                    System.out.println(numPrime + " is a prime number.");
                    break;
                } else {
                    System.out.println(numPrime + " isn't a prime number.");
                    break;
                }
            }
        }
//*      4. Word Counter (For Loop with Split)
        System.out.println("Word Counter (For Loop with Split)\n");

//       4.1 Ask the user for a sentence.
        System.out.println("Please enter a sentence: ");
        String sentence = input.nextLine();
        String[] sentenceList = sentence.split(" ");
//       4.2 Count the number of words (words are separated by spaces).
        int count = 0;
        for (String word : sentenceList) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        System.out.println("The total number of words entered is: " + count);

//**  Break & Continue Challenges
        System.out.println("\n----Break & Continue Challenges----\n");

//*      1. Skip Negative Numbers (Continue Statement)
        System.out.println("Skip Negative Numbers (Continue Statement)\n");

//       1.1 Ask the user to enter numbers.
        while (true) {
            System.out.println("Enter a number or 0 to stop: ");
            String negNumSTR = input.nextLine();
            int negNum = Integer.parseInt(negNumSTR);
//           1.3 Stop asking if they enter 0.
            if (negNum == 0) {
                break;
//           1.2 If the number is negative, skip it using continue.
            } if (negNum < 0) {
                System.out.println("You entered a negative number.");
                continue;
            } System.out.println("You entered: " + negNum);
        }

//*      2. Find the First Prime Number (Break Statement)
        System.out.println("Find the First Prime Number (Break Statement)\n");

//       2.1 Ask the user for a range (e.g., 1-100).
        System.out.println("Enter a the start of the range: ");
        String startRangeSTR = input.nextLine();
        int startRange = Integer.parseInt(startRangeSTR);
        System.out.println("Enter the end point of the range: ");
        String endRangeSTR = input.nextLine();
        int endRange = Integer.parseInt(endRangeSTR);
//       2.2 User a for loop to find the first prime number in that range.
        for (int i = startRange; i <= endRange; i++) {
//           2.3 Stop checking once you find the first prime number.
            if (i < 2) continue;
            boolean primeCheck = true;
            for (int x = 2; x <= Math.sqrt(i); x++) {
                if (i % x == 0) {
                    primeCheck = false;
                    break;
                }
            } if (primeCheck) {
                System.out.println("The first prime number is: " + i);
                break;
            }
        }

//**  Infinite Loops & Fixing Them
        System.out.println("\n----Infinite Loops & Fixing Them----\n");

//*      1. Fix the Infinite Loop
        System.out.println("Fix the Infinite Loop\n");

//       1.1 Fix it so that it stops at 10.
        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

//*      2. Even Number Checker (Preventing Infinite Loops)
        System.out.println("\nEven Number Checker (Preventing Infinite Loops)\n");

        boolean isEven;
        do {
//           2.3 If they enter an even number, exit the loop.
            isEven = true;
//           2.1 Ask the user for an even number.
            System.out.println("Enter an even number to break the loop: ");
            String evenNumSTR = input.nextLine();
            int evenNum = Integer.parseInt(evenNumSTR);
//           2.2 If they enter an off number, keep asking.
            if (evenNum % 2 != 0) isEven = false;
        } while (!isEven);

//**  Bonus Challenges
        System.out.println("\n----Bonus Challenges----\n");

//*      1. Bank Withdrawal System (While Loop)
        System.out.println("Bank Withdrawal System (While Loop)\n");

//       1.1 Start with a balance of $1000.
        double accountBalance = 1000;
//       1.4 Stop when balance reaches 0.
        while (accountBalance > 0) {
            System.out.println("Current balance: $" + accountBalance);
//           1.2 Ask the user how much they want to withdraw.
            System.out.println("How much would you like to withdraw?");
            String withdrawAmntSTR = input.nextLine();
            double withdrawAmnt = Double.parseDouble(withdrawAmntSTR);
//           1.3 If the withdrawal amount is greater than balance, deny the transaction.
            if (withdrawAmnt > accountBalance) {
                System.out.println("Your current balance of : $" + accountBalance + " can't handle the transaction amount.");
            } else {
                accountBalance -= withdrawAmnt;
                System.out.println("Transaction processed successfully.");
            }
        }

//*      2. Find the Longest Word (For Loop)
        System.out.println("Find the Longest Word (For Loop)\n");

//       2.1 Ask the user to enter a sentence.
        System.out.println("Please enter a sentence: ");
        String longSentence = input.nextLine();
        String[] longSentenceList = longSentence.split(" ");
        String longestWord = "";
//       2.2 Find and print the longest word.
        for (int l = 0; l < longSentenceList.length; l++) {
            if (sentenceList[l].length() > longestWord.length()) {
                longestWord = sentenceList[l];
            }
        }
        System.out.println("The Longest number of words entered is: " + longestWord);

//*      3. Number Reversal (While Loop)
        System.out.println("Number Reversal (While Loop)\n");

//       3.1 Ask the user for a number.
        System.out.println("Input a number to print in reverse: ");
        String numSTR = input.nextLine();
        int num = Integer.parseInt(numSTR);
        int revNum = 0;
//       3.2 Reverse the digits and print the reversed number.
        while (num != 0) {
            int singleNum = num % 10;
            revNum = revNum * 10 + singleNum;
            num /= 10;
        }
        System.out.println("The number you entered reversed is: " + revNum);

//**  Final Challenge: Mini Game
        System.out.println("\n----Final Challenge: Mini Game----\n");

//*      1. Guess the Word Game (While Loop)
        System.out.println("Guess the Word Game (While Loop)\n");
        String[] wordList = {"apple", "banana", "cherry"};
//       1.1 The computer selects a random word from a list ("apple", "banana", "cherry")
        String secWord = wordList[new Random().nextInt(wordList.length)];
//       1.3 Keep asking until they guess it correctly.
        while (true) {
//           1.2 Ask the user to guess the word.
            System.out.println("Guess the secret word: ");
            String guess = input.nextLine().toLowerCase();
            if (guess.equals(secWord)) {
                System.out.println("You got it!");
                break;
            }
//           1.4 Provide hints if they get it partially correct.
            StringBuilder hints = new StringBuilder();
            for (int h = 0; h < secWord.length(); h++) {
                if (h < guess.length() && guess.charAt(h) == secWord.charAt(h)) {
                    hints.append(secWord.charAt(h));
                } else {
                    hints.append("_");
                }
            }
            System.out.println("Hint: " + hints);
        }
    }
}