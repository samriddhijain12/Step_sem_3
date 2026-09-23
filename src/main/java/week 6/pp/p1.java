import java.util.Scanner;

// 1. Define the PlacementRecord class
class PlacementRecord {
    // Class fields
    String studentName;
    String company;
    double packageLpa;

    // 2. Constructor to set all three fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // 3. Instance method to print one formatted line
    public void printRecord() {
        System.out.printf("%s -> %s @ %.1f LPA\n", studentName, company, packageLpa);
    }
}

// Main class to execute the logic
public class p1{
    public static void main(String[] args) {
        // 4. Create three PlacementRecord objects and store them in an array
        PlacementRecord[] records = new PlacementRecord[3];

        // Populating the objects with the sample data
        records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        // Print each object using a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}