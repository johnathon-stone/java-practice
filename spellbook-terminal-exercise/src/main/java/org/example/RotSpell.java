package org.example;
//- Class to handle the RotSpell functionality through interface implementation.
class RotSpell implements Spell {
    @Override
    public void cast() {
        System.out.println("You conjure a plague of death from your finger tips infecting those you choose.");
    }

    @Override
    public String getIncantation() {
        return "rot";
    }

    @Override
    public String getHelp() {
        return "The caster applies a DOT(Damage Over Time) to it's selected target.";
    }
}
