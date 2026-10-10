import java.util.Scanner;

interface SaverModeCapable {
    default double applySaverDiscount(double units) {
        return units * 0.75; // 25% reduction
    }
}

abstract class Appliance {
    private String name;
    private double powerWatts;

    public Appliance(String name, double powerWatts) {
        this.name = name;
        this.powerWatts = powerWatts;
    }

    public String getName() {
        return name;
    }

    public double calculateUnits(double hours, boolean saverMode) {
        double rawUnits = (powerWatts * hours) / 1000.0;
        if (saverMode && this instanceof SaverModeCapable) {
            return ((SaverModeCapable) this).applySaverDiscount(rawUnits);
        }
        return rawUnits;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge() {
        super("FRIDGE", 150.0);
    }
}

class AirConditioner extends Appliance implements SaverModeCapable {
    public AirConditioner() {
        super("AC", 1500.0);
    }
}

class TV extends Appliance {
    public TV() {
        super("TV", 100.0);
    }
}

class WashingMachine extends Appliance implements SaverModeCapable {
    public WashingMachine() {
        super("WASHER", 500.0);
    }
}

public class p5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String applianceName = scanner.next();
            double hours = scanner.nextDouble();
            
            // Check if SAVER parameter was provided in the line
            String line = scanner.nextLine().trim();
            boolean isSaver = line.equalsIgnoreCase("SAVER");

            Appliance appliance = null;
            switch (applianceName.toUpperCase()) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                case "WASHER":
                    appliance = new WashingMachine();
                    break;
            }

            if (appliance != null) {
                if (isSaver && !(appliance instanceof SaverModeCapable)) {
                    System.out.printf("%s: saver mode not supported\n", appliance.getName());
                } else {
                    double units = appliance.calculateUnits(hours, isSaver);
                    double cost = appliance.calculateCost(units);
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliance.getName(), units, cost);
                    totalCost += cost;
                }
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}