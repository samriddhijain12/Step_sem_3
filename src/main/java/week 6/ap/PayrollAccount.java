public class PayrollAccount {
    // Private variables to prevent direct outside access
    private double basicSalary;
    private double bonus;

    // Public constructor with negative value validation
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Opening basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0; // Initialized to 0 by default
    }

    // Public method to safely add bonus
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Public method to deduct tax by percentage
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100.");
        } else {
            double taxAmount = (this.basicSalary * percent) / 100;
            this.basicSalary -= taxAmount;
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }

    // Read-only getter that calculates and returns the net salary
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    // Main method to test and match the sample Input/Output
    public static void main(String[] args) {
        // Sample Input simulation
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        
        // Output result
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
