import java.util.*;

abstract class PaymentMethod {
    protected String type;
    protected double amount;

    public PaymentMethod(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();

    public String getType() {
        return type;
    }
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount; // No fee
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        List<PaymentMethod> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
            }
        }

        double total = 0.0;
        for (PaymentMethod payment : payments) {
            double adjustedAmount = payment.calculateAdjustedAmount();
            total += adjustedAmount;
            System.out.printf("%s: %.2f%n", payment.getType(), adjustedAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        
        scanner.close();
    }
}