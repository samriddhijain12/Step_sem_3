public class NameTag {
    // Requirements state fields must be final to ensure immutability
    private final String firstName;
    private final String lastNameInitial;

    /**
     * Constructor that takes a full name, splits it into first and last name,
     * and stores the nickname components.
     */
    public NameTag(String fullName) {
        // Hint 1 & 2: Split the string once by space inside the constructor
        String[] nameParts = fullName.split(" ");
        
        this.firstName = nameParts[0];
        
        // Extract the first character of the last name and append a period
        this.lastNameInitial = nameParts[1].substring(0, 1) + ".";
    }

    /**
     * Method that returns the formatted nickname.
     */
    public String getNickname() {
        return this.firstName + " " + this.lastNameInitial;
    }

    // Main method to verify the sample input/output behavior
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname()); // Expected Output: Maria G.
    }
}