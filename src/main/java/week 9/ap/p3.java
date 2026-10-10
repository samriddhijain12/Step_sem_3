import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ElectricityConnection {
    private String type;
    private int units;

    public ElectricityConnection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public int getUnits() {
        return units;
    }

    public abstract double calculateBill();

    public void printBill() {
        System.out.printf("%s: %.2f\n", type, calculateBill());
    }
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        int units = getUnits();
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(getUnits() * 6.0, 1000.0);
    }
}

public class p3{
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            switch (type.toUpperCase()) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        double total = 0.0;
        for (ElectricityConnection conn : connections) {
            conn.printBill();
            total += conn.calculateBill();
        }

        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}