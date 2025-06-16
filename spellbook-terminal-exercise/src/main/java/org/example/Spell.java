package org.example;
//- Interface used to establish the base structure of the spells that use it.
interface Spell {

    //- Method when the spell is properly called on.
    void cast();

    //- Method to use the spell.
    String getIncantation();

    //- Bonus method to give a description.
    String getHelp();
}
