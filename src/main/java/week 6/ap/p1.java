// Define the BookInventory class
class BookInventory {
    // Fields
    String title;
    String author;
    int copiesAvailable;

    // Constructor to set all three fields
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method to print one formatted line matching the requested output format
    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

// Main class to run the program
public class p1 {
    public static void main(String[] args) {
        // Create an array to store four BookInventory objects
        BookInventory[] inventory = new BookInventory[4];

        // Instantiate four BookInventory objects with the sample input data
        inventory[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        inventory[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        inventory[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        inventory[3] = new BookInventory("Design Patterns", "GoF", 2);

        // Loop through the array and print each entry
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
