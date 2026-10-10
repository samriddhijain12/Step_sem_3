import java.util.Scanner;

interface NightServiceable {
    default double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    private String type;

    public Cab(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract double getRatePerKm();

    public double calculateFare(double km, String time) {
        double baseFare = Math.max(km * getRatePerKm(), 100.0);

        if (time.equalsIgnoreCase("NIGHT")) {
            if (this instanceof NightServiceable) {
                return ((NightServiceable) this).applyNightSurcharge(baseFare);
            }
            return -1.0; // rejected
        }

        return baseFare;
    }
}

class MiniCab extends Cab {
    public MiniCab() {
        super("MINI");
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab() {
        super("SEDAN");
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab() {
        super("SUV");
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

public class p4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double totalFare = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SUVCab();
                    break;
            }

            if (cab != null) {
                double fare = cab.calculateFare(km, time);
                if (fare < 0) {
                    System.out.printf("%s: night service not available\n", cab.getType());
                } else {
                    System.out.printf("%s: %.2f\n", cab.getType(), fare);
                    totalFare += fare;
                }
            }
        }

        System.out.printf("Total: %.2f\n", totalFare);
        scanner.close();
    }
}