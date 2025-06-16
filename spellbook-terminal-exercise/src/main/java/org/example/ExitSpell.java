package org.example;
//- Class to handle the ExitSpell functionality through interface implementation.
class ExitSpell implements Spell {

    @Override
    public void cast() {
        System.out.println("A portal opens beneath your feet. Goodbye, wizard!");
        System.exit(0);
    }

    @Override
    public String getIncantation() {
        return "quit";
    }

    @Override
    public String getHelp() {
        return "Opens a portal beneath the caster(exit the program).";
    }
}
