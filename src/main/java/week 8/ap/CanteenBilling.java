import java.util.*;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }

    @Override
    public String getType() { return "STUDENT"; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.85; // 15% discount
    }

    @Override
    public String getType() { return "STAFF"; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // ₹10 service charge
    }

    @Override
    public String getType() { return "GUEST"; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    bills.add(new StudentCustomer(amount));
                    break;
                case "STAFF":
                    bills.add(new StaffCustomer(amount));
                    break;
                case "GUEST":
                    bills.add(new GuestCustomer(amount));
                    break;
            }
        }

        double grandTotal = 0;
        for (Customer c : bills) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}