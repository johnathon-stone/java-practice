package org.example.spells;

public class CometSpell implements Spell {
    @Override
    public void cast() {
        System.out.println("You reach deep within your soul pulling all the energy out into a large comet that launches from above you.");
    }

    @Override
    public String getIncantation() {
        return "comet";
    }

    @Override
    public String getHelp() {
        return "The caster uses up any remaining mana to conjure a comet that is then hurled toward the specified target.";
    }
}
