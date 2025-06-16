package org.example.spells;

public class HealSpell implements Spell {
    @Override
    public void cast() {
        System.out.println("You feel a beam of warm light surround and move through you, healing your wounds and what ails you.");
    }

    @Override
    public String getIncantation() {
        return "heal";
    }

    @Override
    public String getHelp() {
        return "Heals the caster of all ailments and dispels all special effects.";
    }
}
