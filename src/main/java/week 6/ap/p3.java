class Employee {
    // Instance fields (unique to each employee object)
    private String empName;
    private double salary;

    // Static fields (shared by all employee objects)
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    // Constructor
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        // Increment the employee count every time a new object is created
        employeeCount++;
    }

    // Static method to print company info
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class p3 {
    public static void main(String[] args) {
        // Create three Employee objects
        Employee emp1 = new Employee("Alice", 50000);
        Employee emp2 = new Employee("Bob", 60000);
        Employee emp3 = new Employee("Charlie", 75000);

        // Call printCompanyInfo() through the class name
        Employee.printCompanyInfo();
    }
}