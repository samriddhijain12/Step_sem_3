import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    private String title;
    private int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public abstract double calculateFine();

    public void printFine() {
        System.out.printf("%s: %.2f\n", title, calculateFine());
    }
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 2.0;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(getDaysLate() * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 1.0;
    }
}

public class p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            switch (type.toUpperCase()) {
                case "BOOK":
                    items.add(new Book(title, daysLate));
                    break;
                case "DVD":
                    items.add(new DVD(title, daysLate));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title, daysLate));
                    break;
            }
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            item.printFine();
            totalFines += item.calculateFine();
        }

        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}