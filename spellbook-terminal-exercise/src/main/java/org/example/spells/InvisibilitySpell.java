package org.example.spells;

public class InvisibilitySpell implements Spell {
    @Override
    public void cast() {
        System.out.println("You are now invisible enough to quietly walk by whoever you want undetected.");
    }

    @Override
    public String getIncantation() {
        return "invisibility";
    }

    @Override
    public String getHelp() {
        return "Makes the caster invisible for a short period of time but doesn't hide your noise.";
    }
}
