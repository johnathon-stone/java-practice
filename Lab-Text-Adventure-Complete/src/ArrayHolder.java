public class ArrayHolder {

    /*Established private placeholders for the five boolean values in an array used to determine what can and has done prior.*/
    public boolean[] keys = {false, false, false, false, false};

    private final String[] whisperingForest = {"You travel to The Whispering Forest.",
            "If it wasn't for the sound of twigs a leafs crumbling under you \nthe dead silence would tremble up your spine.",
            "You continue heading towards a large tree located in the center.",
            "Noticing a section just big enough for you is hallowed out tempts you to climb in.",
            "Inside you find a chest and upon opening it locate half of the first key."
    };

    private final String[] ashfangRidge = {"You travel to Ashfang Ridge.",
            "To reach the half of the key, one must climb a jagged path up \nthe blackened cliffs of Ashfang Ridge.",
            "The rocks here are warm to the touch, and faint plumes of steam hiss from hidden vents.",
            "Small, obsidian lizards dart between cracks, watching with glinting eyes.",
            "At the summit, nestled in a volcanic crevice, the half-key rests atop of a \npedestal of scorched bone and emberglass.",
            "You grasp the key half from its pedestal."
    };

    private final String[] siltmirrorMarsh = {"You travel to Siltmirror Marsh.",
            "The trail winds across a maze of unstable boardwalks barely holding \nabove the thick, silver-tinted waters.",
            "Ghostly reflections shimmer beneath the surface, mimicking your every move — \nbut sometimes with a delay.",
            "The air is humid and thick with the scent of wet stone and blooming night-lilies.",
            "Deep within the misty center of the marsh, hidden beneath a slab of moonstone, \nlies the glistening half of an ornate key.",
            "You tuck the key half in your pocket."
    };

    private final String[] atlantis = {"You travel to the sunken city Atlantis.",
            "As you travel through the vast rings of the city.",
            "With moss covered walls and overgrown vegetation.",
            "You realize no life is to be found in the once advanced civilization.",
            "After hours of traveling within the city you reach the central ring \nwith a fortified structure signifying its importance.",
            "Inside the structure you see a hold containing vast amounts of prized possessions.",
            "One thing above all else catches your eye.",
            "A mosaic with a section peeling back. You gently begin to pull it away.",
            "Revealing a hidden compartment with half of an ornate key wrapped in velvet and dust.",
            "You clutch the key knowing it hold significance in your future adventures."
    };

    private final String[] crystalThrone = {"You unfurl both sets of key halves from your pocket joining them together \nto become whole.",
            "The ground starts to tremble like an earthquake is happening.",
            "In the distance you see light bouncing off something large.",
            "Upon making it closer you can tell it is a castle made of crystal.",
            "Every step you take in its direction you realize the key is magically \nbeing pulled from your hand and slides into the lock",
            "You hear contraptions from within the door clicking and spinning.",
            "The door inches open allowing you entry. Knowing you have reached the \npinnacle of your adventure."
    };

    public String[] getString(int choice) {
        return switch (choice) {
            case 1 -> whisperingForest;
            case 2 -> ashfangRidge;
            case 3 -> siltmirrorMarsh;
            case 4 -> atlantis;
            case 5 -> crystalThrone;
            default -> new String[0];
        };
    }

}
