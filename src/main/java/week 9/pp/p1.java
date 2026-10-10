import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Ticket {
    private String seatType;
    private int count;
    private static final double CONVENIENCE_FEE = 20.0;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getCount() {
        return count;
    }

    public abstract double getBasePrice();

    public double calculateAmount() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }

    public void printBooking() {
        System.out.printf("%s: %.2f\n", seatType, calculateAmount());
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

public class p1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();

            switch (seat.toUpperCase()) {
                case "REGULAR":
                    bookings.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerTicket(count));
                    break;
            }
        }

        double total = 0.0;
        for (Ticket booking : bookings) {
            booking.printBooking();
            total += booking.calculateAmount();
        }

        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}