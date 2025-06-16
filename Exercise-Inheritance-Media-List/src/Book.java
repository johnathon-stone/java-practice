public class Book extends Media {
    //- Author in String for book.
    private final String author;
    //- Page Count in Integer for book.
    private final int pageCount;

    //- Setter for Book.
    public Book(String name, String author, int pageCount) {
        super(name);
        this.author = author;
        this.pageCount = pageCount;
    }

    //- Getter to return an instance of author.
    public String getAuthor() {
        return author;
    }

    //- Getter to return an instance of pageCount.
    public int getPageCount() {
        return pageCount;
    }

    //- Inherited method play from media formated for book.
    @Override
    public void play() {
        System.out.println("Reading book '" + name + "' using book reading software.");
    }

    //- Inherited method getDescription from media formated for book.
    @Override
    public String getDescription() {
        return "\nDescription: Book '" + name + "' - Author: " + author + ", Page Count: " + pageCount;
    }
}
