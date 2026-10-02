import java.util.*;

abstract class Room {
    public abstract double calculateBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    private int units;

    public SingleRoom(int units) {
        this.units = units;
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int units;
    private int occupants;

    public SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getType() { return "SHARED"; }
}

class ACRoom extends Room {
    private int units;

    public ACRoom(int units) {
        this.units = units;
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getType() { return "AC"; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            }
        }

        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f\n", r.getType(), bill);
            grandTotal += bill;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}