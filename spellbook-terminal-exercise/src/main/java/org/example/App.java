package org.example;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        SpellBook spellBook = new SpellBook();

        //- While loop to start and continue the program until the exit requirement is met.
        while (true) {
            System.out.println("Recite a spell: ");
            String choice = input.nextLine().toLowerCase();
            if (choice.equals("help")) {
                spellBook.help();
            } else {
                spellBook.tryIncantation(choice);
            }
        }
    }
}
