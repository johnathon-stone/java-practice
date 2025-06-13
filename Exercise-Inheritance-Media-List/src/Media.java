public abstract class Media {

    protected String name;

    //- Constructor for Media so we can take advantage of the super to navigate easier.
    public Media(String name) {
        this.name = name;
    }

    //- Getter method for name field.
    public String getName() {
        return name;
    }

    //- Setter method for name field.
    public void setName(String name) {
        this.name = name;
    }

    //- Abstract method to be overridden by subclasses.
    public abstract void play();

    //- Abstract method to be overridden by subclasses.
    public abstract String getDescription();
}