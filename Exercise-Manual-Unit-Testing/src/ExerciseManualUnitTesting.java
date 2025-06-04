public class ExerciseManualUnitTesting {

//** Task 1: Happy Path Testing.
    /*1.1 Create the selectDrink method that takes a String input and returns a message.*/
    public static String selectDrink(String choice) {

//** Task 3: Debugging with Print Statements.
        /*3.1 Show the received input before processing.*/
        System.out.println("Received input: " + choice);
        /*2.2 Modify selectDrink to make it case-insensitive using .toLowerCase().*/
        String lowerCaseChoice = choice.toLowerCase();
        switch (choice.toLowerCase()) {
            case "water":
                /*3.2 Show the selected drink before returning.*/
                System.out.println("Lowercased input: " + lowerCaseChoice);
                return "You selected Water";
            case "soda":
                System.out.println("Lowercased input: " + lowerCaseChoice);
                return "You selected Soda";
            case "juice":
                System.out.println("Lowercased input: " + lowerCaseChoice);
                return "You selected Juice";
            default:
                System.out.println("Lowercased input: " + lowerCaseChoice);
                /*3.3 Show a message when an invalid selection is detected.*/
                return "Invalid selection";
        }
    }

    /*1.2 Write a runTests method that automatically verifies the correct output for "water", "soda", and "juice".*/
    public static void runTests() {
//** Task 2: Edge Cases.
        /*2.1 Update runTests to include "WATER", "Tea", and "".*/
        String[] inputs = {"water", "soda", "juice", "WATER", "Tea", ""};
        String[] expectedOutputs = {
                "You selected Water",
                "You selected Soda",
                "You selected Juice",
                "You selected Water",
                "Invalid selection",
                "Invalid selection",
        };
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expected = expectedOutputs[i];
            System.out.print("Testing with " + input + "... \n");
            String actual = selectDrink(input);
            if (expected.equals(actual)) System.out.println("Passed!");
            else System.out.println("FAIL: Expected '" + expected + "', got '" + actual + "'");
        }
    }

    public static void main(String[] args) {

        /*1.3 Call runTests from main to ensure correct results.*/
        runTests();
    }
}