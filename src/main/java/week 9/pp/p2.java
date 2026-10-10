import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    private String type;
    private double weightKg;
    private double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    public abstract double calculateCharge();

    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance(declaredValue);
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateCharge() + getInsurance();
    }

    public void printReport() {
        System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",
                type, calculateCharge(), getInsurance(), calculateTotal());
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * getWeightKg());
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * getWeightKg());
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return (40.0 + 10.0 * getWeightKg()) + 50.0;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            switch (type.toUpperCase()) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, declaredValue));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, declaredValue));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, declaredValue));
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            parcel.printReport();
            grandTotal += parcel.calculateTotal();
        }

        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}