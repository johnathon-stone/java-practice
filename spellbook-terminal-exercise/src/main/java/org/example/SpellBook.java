package org.example;
import java.util.ArrayList;

public class SpellBook {
    //- Private ArrayList to hold all the spells.
    private final ArrayList<Spell> spellbook = new ArrayList<>();

    //- Constructor adding specific spells to spellbook.
    public SpellBook() {
        spellbook.add(new CometSpell());
        spellbook.add(new HealSpell());
        spellbook.add(new InvisibilitySpell());
        spellbook.add(new RotSpell());
        spellbook.add(new ExitSpell());
    }

    //- Method to loop through spellbook and cast if found or return a statement if not
    public void tryIncantation(String incantation) {
        for (Spell spell : spellbook) {
            if (spell.getIncantation().equalsIgnoreCase(incantation)) {
                spell.cast();
                return;
            }
        }
        System.out.println("The spell fizzled out! Try again.");
    }

    //- Method to display the incantation(getIncantation()) and description(getHelp()).
    public void help() {
        System.out.println("Incantation        ||        Description");
        System.out.println("----------------------------------------");
        for (Spell spell : spellbook) {
            System.out.println(spell.getIncantation() + " || " + spell.getHelp());
        }
    }
}
