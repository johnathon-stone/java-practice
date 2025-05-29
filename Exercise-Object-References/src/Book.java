//  Part 2. Reference Types and Object Behavior
//   p2.1.1 Create a class with 'String title, String author, boolean isAvailable'.
public class Book {
    String title;
    String author;
    boolean isAvailable;

//   p2.1.2 Create a constructor to initialize these variables.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

//   *! This step isn't outlined in the documentation but required for it to function properly. !*  \\
    public void displayStatus() {
        System.out.println("Book: " + title + " by " + author + "(Available: " + isAvailable + ")");
    }
//   p2.1.3 Create a method 'borrowBook()' that sets 'isAvailable = false'.
    public void borrowBook() {
        this.isAvailable = false;
    }
}
