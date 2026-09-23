// Define the HallTicket class
class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor to initialize the fields
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class p2 {
    public static void main(String[] args) {
        // 1. Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // 2. Assign a second variable to point at that same object
        HallTicket copy = priya;

        // 3. Through the second variable, change seatNumber
        copy.seatNumber = 45;

        // 4. Print the field's value as seen through the first variable
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);

        // Print whether the two variables are == to each other
        System.out.println("copy == priya: " + (copy == priya));

        // 5. Create a third, separate HallTicket object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Print whether it is == to the first
        System.out.println("separate == priya: " + (separate == priya));
    }
}