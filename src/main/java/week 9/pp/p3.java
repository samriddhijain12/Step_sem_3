import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;
    
    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }

    public void printReport() {
        System.out.printf("%s: %.2f\n", name, calculateTotalFee());
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }
}

public class p3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarStudent(name));
                    break;
            }
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            student.printReport();
            totalCollected += student.calculateTotalFee();
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}