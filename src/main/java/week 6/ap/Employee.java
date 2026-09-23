class Employee {
    // 1. Define fields
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // 2. Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // 3. Constructor for interns (chains to the 3-argument constructor)
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0); // Chains via this(...) setting salary to 0
        this.isIntern = true;      // Sets isIntern to true afterwards
    }

    // 4. Method to print profile fields on one line
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    // 5. Main method to create objects and test functionality
    public static void main(String[] args) {
        // Create permanent employee object
        Employee permanentEmp = new Employee("E-101", "Divya", 65000.0);
        
        // Create intern employee object
        Employee internEmp = new Employee("E-102", "Arjun");

        // Call printProfile() on both
        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}