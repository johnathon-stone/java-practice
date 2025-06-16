package org.example;
import org.example.spells.*;
import java.util.ArrayList;

public class SpellBook {

    private final ArrayList<Spell> spellbook = new ArrayList<>();

    public SpellBook() {
        spellbook.add(new CometSpell());
        spellbook.add(new HealSpell());
        spellbook.add(new InvisibilitySpell());
        spellbook.add(new RotSpell());
        spellbook.add(new ExitSpell());
    }

    public void tryIncantation(String incantation) {
        for (Spell spell : spellbook) {
            if (spell.getIncantation().equalsIgnoreCase(incantation)) {
                spell.cast();
                return;
            }
        }
        System.out.println("The spell fizzled out! Try again.");
    }

    public void help() {
        System.out.println("Incantation        ||        Description");
        System.out.println("----------------------------------------");
        for (Spell spell : spellbook) {
            System.out.println(spell.getIncantation() + " || " + spell.getHelp());
        }
    }
}
