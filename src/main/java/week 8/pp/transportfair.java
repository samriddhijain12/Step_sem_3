import java.util.*;

abstract class TransportJourney {
    protected String type;
    protected double distance;

    public TransportJourney(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public abstract double calculateFare();

    public String getType() {
        return type;
    }
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Max fare capped at $10
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class transportfair{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<TransportJourney> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            if (type.equals("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journeys.add(new MetroJourney(distance, peakHourFactor));
            } else if (type.equals("BUS")) {
                journeys.add(new BusJourney(distance));
            } else if (type.equals("TRAIN")) {
                journeys.add(new TrainJourney(distance));
            }
        }

        double totalFare = 0.0;
        for (TransportJourney journey : journeys) {
            double fare = journey.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f%n", journey.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", totalFare);

        scanner.close();
    }
}
