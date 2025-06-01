import java.util.Scanner; // 2.3 Get user input using Scanner.

public class ExerciseDecisions {
    public static void main(String[] args) {
//       2.3 Get user input using Scanner.
        Scanner input = new Scanner(System.in);

//       7.3 Optionally, allow them to restart the game.
        boolean play;

//       7.3 Optionally, allow them to restart the game.
        do {
//           7.1 Print a final message summarizing the player's journey.
            String summary = "";

//           2.1 Print a welcome message introducing the player to the game.
            System.out.println("Welcome weary Adventurer!\nYou have come across a cave that can give a break from the elements of the outside world.\n"); // 2.1 Print a welcome message introducing the player to the game.

//           2.2 Ask if they want to enter the cave(yes/no).
            System.out.println("Do you wish to enter (y)es or (n)o?");

//           2.3 Get user input using Scanner.
            String start = input.nextLine();

            if ("y".equalsIgnoreCase(start)) {
//               7.1 Print a final message summarizing the player's journey.
                summary += "You chose to enter the cave. ";
                System.out.println("You enter the cave and everything becomes dark.");

//               3.1 If the player enters the cave, present two options: left or right.
                System.out.println("Feeling with your hands you can tell there is a pathway (l)eft or (r)ight which do you choose?");

//               2.3 Get user input using Scanner.
                String lr = input.nextLine();

//               3.2 Use an if-else statement to handle their choice.
                if ("l".equalsIgnoreCase(lr)) {
//                   7.1 Print a final message summarizing the player's journey.
                    summary += "You went left and stumbled into a Dragons nesting grounds. ";

//                   4.1 If the player chooses left, introduce an obstacle.
                    System.out.println("As you head to the left down a dark damp pathway everything begin to get warmer.");
                    System.out.println("Oh no! You have stumbled into the middle of a Dragons nesting grounds! The Dragon has yet to notice your presence..");

//                   4.2 Ask if they want to fight or flee.
                    System.out.println("With only seconds remaining you decide to (r)un or (f)ight?");

//                   2.3 Get user input using Scanner.
                    String rf = input.nextLine();

//                   4.3 Use a nested if statement to handle both cases.
                    if ("f".equalsIgnoreCase(rf)) {
//                       7.1 Print a final message summarizing the player's journey.
                        summary += "You then decided to fight the Dragon. Slaying it with your broadsword. ";
                        System.out.println("You fearlessly, climb up the Dragon before it has a chance and wedge your broadsword through the back of its skull claiming victory!");

//                   4.3 Use a nested if statement to handle both cases.
                    } else if ("r".equalsIgnoreCase(rf)){
//                       7.1 Print a final message summarizing the player's journey.
                        summary += "You then decided it was not in you to fight the Dragon and instead ran to live another day.";
                        System.out.println("With your legs trembling you inch closer to the way you came.");
                        System.out.println("After your close call you decide it is best to leave the cave and never return.");

//                   4.3 Use a nested if statement to handle both cases.
                    } else {
//                       7.1 Print a final message summarizing the player's journey.
                        summary += "You hesitated and the Dragon took advantage of your moment of weakness.";
                        System.out.println("Invalid selection! The Dragon smells your fear and sends a burst of fire quickly claiming you to the ashes on the floor.");
                    }
//               3.2 Use an if-else statement to handle their choice.
                } else {
//                   7.1 Print a final message summarizing the player's journey.
                    summary += "You went right and discovered a treasure room with riches that you became trapped in with a sign requesting you to make a choice.  ";
                    System.out.println("You start to see a light at the end of the pathway.");
                    System.out.println("Up ahead you see an open doorway leading to a treasure room filled with riches!");
                    System.out.println("There is a treasure chest in the center of the room with a sign that says choice ONLY one artifact if you ever want the chance to leave..");
                    System.out.println("The door you came through slams shut and won't budge!");

//                   5.2 Present them with three artifacts: a gem, a key, and a book.
                    System.out.println("Upon looking in the treasure chest you see a \ngem(1) \na key(2) \na book(3).");
                    System.out.println("What do you choose?");

//                   2.3 Get user input using Scanner.
                    String treasureSTR = input.nextLine();
                    int treasure = Integer.parseInt(treasureSTR);

//                   5.3 Use a switch statement to process their choice.
                    switch (treasure) {
                        case 1:{
//                           7.1 Print a final message summarizing the player's journey.
                            summary += "You chose the gem that pulled the life out of you thanks to your greedy desires.";

//                           5.4 Each item should have a different consequence.
                            System.out.println("You select the gem. It's beauty grows the closer you hold it.");
                            System.out.println("Slowly you feel the life being pulled from you, and you can't stop it.");
                            System.out.println("You have died. Forever to lay with your greedy desires.");
                            break;
                        }
                        case 2:{
//                           7.1 Print a final message summarizing the player's journey.
                            summary += "You chose the key securing your freedom from the treasure room.";

//                           5.4 Each item should have a different consequence.
                            System.out.println("You selected the key. After you look closer you notice it seems to match the keyhole of the door.");
                            System.out.println("Without hesitation you attempt to unlock the door.");
                            System.out.println("You feel the breeze channeling down the pathway hit your face and are able to taste freedom again.");
                            break;
                        }
                        case 3: {
//                           7.1 Print a final message summarizing the player's journey.
                            summary += "You chose the book and realized it was a journal log of previous Adventures trapped there forever.";

//                           5.4 Each item should have a different consequence.
                            System.out.println("You selected the book. After close inspection of the first few pages you realize it is a journal.");
                            System.out.println("Inside it's aged pages are entries from previous Adventurers who met the same fate.");
                            System.out.println("You legs become weak as you realize you shall meet the same fate as those before and you slump to the floor.");
                            break;
                        }
                        default:{
//                           7.1 Print a final message summarizing the player's journey.
                            summary += "You grabbing a piece of treasure that caught your attention. Thus setting off a chain reaction of events killing you where you stand.";

//                           6.2 Print a message informing them of invalid input.
                            System.out.println("Not following the sign you grab another item in the chest setting off a crossbow trap killing you right in front of the chest.");
                        }
                    }
                }

            } else if ("n".equalsIgnoreCase(start)){
//               7.1 Print a final message summarizing the player's journey.
                summary += "You chose to turn away from the cave.";
                System.out.println("You turn away not knowing whether it is fear or logic that has come over you but you continue down your original path.");;
            } else {
//               7.1 Print a final message summarizing the player's journey.
                summary += "Your mistake possibly saved your life or cost you a fortune of riches.";

//               2.4 Handle invalid inputs with an error message.
                System.out.println("Your mistake possibly saved your life or cost you a fortune of riches.");
            }
//           7.1 Print a final message summarizing the player's journey.
            System.out.println("\n---- Summary of your Journey ----\n");
            System.out.println(summary);

//           7.3 Optionally, allow them to restart the game.
            System.out.println("Would you like to play again? (y)es/(n)o: ");
            String again = input.nextLine();
            play = "y".equalsIgnoreCase(again);
//       7.3 Optionally, allow them to restart the game.
        } while (play);

//       7.2 Thank them for playing the game.
        System.out.println("Thank you for playing!");
        input.close();
    }
}