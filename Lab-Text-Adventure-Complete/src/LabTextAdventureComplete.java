public class LabTextAdventureComplete {

    public static void main(String[] args) {
        ArrayHolder ah = new ArrayHolder();
        IO io = new IO();
        boolean[] keyStatus = ah.keys;

        System.out.println("----Welcome to the Text Adventure!----");

        /*Established while loop*/
        while (true) {
            /*Called .displayMenu() to give the user visual to aid input.*/
            io.displayMenu();
            /*Declaring and assigning input to choice by calling getInput().*/
            int choice = io.getInput();

            /*Established switch to direct user based on input appropriately.*/
            switch (choice) {

                /*Choice 1 with if and else to handle if the user has been there prior.*/
                case 1:
                    if (!keyStatus[KeyIndex.KEYHALF1.ordinal()]) {
                        io.stringProcessor(ah.getString(choice));
                        keyStatus[KeyIndex.KEYHALF1.ordinal()] = true;
                    } else {
                        io.beenThere();
                    } break;

                /*Choice 2 with if and else to handle if the user has been there prior.*/
                case 2:
                    if (!keyStatus[KeyIndex.KEYHALF2.ordinal()]) {
                        io.stringProcessor(ah.getString(choice));
                        keyStatus[KeyIndex.KEYHALF2.ordinal()] = true;
                    } else {
                        io.beenThere();
                    } break;

                /*Choice 3 with if and else to handle if the user has been there prior.*/
                case 3:
                    if (!keyStatus[KeyIndex.KEY2HALF1.ordinal()]) {
                        io.stringProcessor(ah.getString(choice));
                        keyStatus[KeyIndex.KEY2HALF1.ordinal()] = true;
                    } else {
                        io.beenThere();
                    } break;

                /*Choice 4 with if and else to handle if the user has been there prior.*/
                case 4:
                    if (!keyStatus[KeyIndex.KEY2HALF2.ordinal()]) {
                        io.stringProcessor(ah.getString(choice));
                        keyStatus[KeyIndex.KEY2HALF2.ordinal()] = true;
                    } else {
                        io.beenThere();
                    } break;

                /*Choice 5 with if and else to handle if the user is able to access.*/
                case 5:
                    if (keyStatus[0] && keyStatus[1] && keyStatus[2] && keyStatus[3]) {
                        io.stringProcessor(ah.getString(choice));
                        keyStatus[KeyIndex.FINAL_LOCATION.ordinal()] = true;
                    } else {
                        System.out.println("You must find the two sets of key halves and assemble them to enter.");
                    } break;

                /*Choice 6 allowing the user to exit the program.*/
                case 6:
                    System.out.println("Thank you for playing. Goodbye.");
                    return ;

                /*Used to; handle out of parameters choice.*/
                default:
                    System.out.println("Invalid input. Enter a number between 1-6.");
            }
            /*If statement to handle if all three locations have been visited.*/
            if (keyStatus[KeyIndex.FINAL_LOCATION.ordinal()]) {
                System.out.println("\nYou were able to visit all five locations!");
                break;
            }
        }
    }
}