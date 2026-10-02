import java.util.*;

abstract class DeliveryRequest {
    protected String type;
    protected double weight;
    protected double distance;

    public DeliveryRequest(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public String getType() {
        return type;
    }
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class delivery{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<DeliveryRequest> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if (type.equals("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            } else if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            }
        }

        double totalFee = 0.0;
        for (DeliveryRequest delivery : deliveries) {
            double fee = delivery.calculateFee();
            totalFee += fee;
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", totalFee);

        scanner.close();
    }
}