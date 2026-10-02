import java.util.*;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }

    @Override
    public String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }

    @Override
    public double calculateCharge() {
        // ₹30 for first hour + ₹20 for each additional hour
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    public String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }

    @Override
    public double calculateCharge() {
        // ₹50 per hour, minimum ₹100
        return Math.max(100.0, hours * 50.0);
    }

    @Override
    public String getType() { return "TRUCK"; }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
            }
        }

        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f\n", v.getType(), charge);
            grandTotal += charge;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}
