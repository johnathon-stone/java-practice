import java.util.Scanner;

public class LabTextAdventureThroughLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//  Established placeholders for the five boolean values used within the switch and if statements to determine what can and has done prior.
        boolean keyHalfOne = false;
        boolean keyHalfTwo = false;
        boolean locationOne = false;
        boolean locationTwo = false;
        boolean locationThree = false;
        System.out.println("Welcome to the Text Adventure!");

//  Established while loop with menu to help the user navigate with their input.
        while (true) {
            System.out.println("Choose where you would like to go: ");
            System.out.println("(1) The Whispering Forest.");
            System.out.println("(2) Atlantis.");
            System.out.println("(3) The Crystal Throne");
            System.out.println("(4) to Exit.");

//  Catching user input and assigning it.
            String choice = input.nextLine();

//  Established switch to direct user based on input appropriately.
            switch (choice) {

//  Choice "1" with if and else to handle if the user has been there prior.
                case "1":
                    if (!locationOne) {
                        System.out.println("You travel to the dark ancient forest filled with mystery.");
                        System.out.println("If it wasn't for the sound of twigs a leafs crumbling under you \nthe dead silence would tremble up your spine.");
                        System.out.println("You continue heading towards a large tree located in the center.");
                        System.out.println("Noticing a section just big enough for you is hallowed out tempts you to climb in.");
                        System.out.println("Inside you find a chest and upon opening it locate half of a key.");
                        locationOne = true;
                        keyHalfOne = true;
                    } else {
                        System.out.println("You remember that you've been here before and found half of a key last time.");
                    }
                    break;

//  Choice "2" with if and else to handle if the user has been there prior.
                case "2":
                    if (!locationTwo) {
                        System.out.println("You travel to the sunken city Atlantis.");
                        System.out.println("As you travel through the vast rings of the city.");
                        System.out.println("With moss covered walls and overgrown vegetation.");
                        System.out.println("You realize no life is to be found in the once advanced civilization.");
                        System.out.println("After hours of traveling within the city you reach the central ring \nwith a fortified structure signifying its importance.");
                        System.out.println("Inside the structure you see a hold containing vast amounts of prized possessions.");
                        System.out.println("One thing above all else catches your eye.");
                        System.out.println("Part of a key. Resting on top of a pedestal.");
                        System.out.println("You take the key knowing it hold significance in your future adventures.");
                        locationTwo = true;
                        keyHalfTwo = true;
                    } else {
                        System.out.println("You remember that you've been here before and found half of a key last time");
                    }
                    break;

//  Choice "3" with if and else to handle if the user is able to access.
                case "3":
                    if (keyHalfOne && keyHalfTwo) {
                        if (!locationThree) {
                            System.out.println("You join both key halves together forming it whole.");
                            System.out.println("The ground starts to tremble like an earthquake is happening.");
                            System.out.println("In the distance you see light bouncing off something large.");
                            System.out.println("Upon making it closer you can tell it is a castle made of crystal.");
                            System.out.println("Every step you take in its direction you realize the key is magically \nbeing pulled from your hand and slides into the lock");
                            System.out.println("You hear contraptions from within the door clicking and spinning.");
                            System.out.println("The door inches open allowing you entry. Knowing you have reached the \npinnacle of your adventure.");
                            locationThree = true;
                        }
                    } else {
                        System.out.println("You must find the two key halves and assemble it to enter.");
                    }
                    break;

//  Choice "4" allowing the user to exit the program.
                case "4":
                    System.out.println("Thank you for playing. Goodbye.");
                    return;

//  Used to handle out of parameters choice.
                default:
                    System.out.println("Invalid input. Enter a number between 1-4.");
            }
//  If statement to handle if all three locations have been visited.
            if (locationOne && locationTwo && locationThree) {
                System.out.println("You were able to visit all three locations!");
                break;
            }
        }
    }
}