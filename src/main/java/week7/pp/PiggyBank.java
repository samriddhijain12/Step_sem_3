public class PiggyBank {
    // Requirements: Private savings field and a fixed ID locked forever
    private double savings;
    private final String id;

    // Expected Behavior: A new piggy bank starts at 0 savings and locks the ID
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0; 
    }

    // Requirements: Provide a way to check current savings (getter)
    public double getSavings() {
        return this.savings;
    }

    // Requirements: Give the piggy bank a final ID (getter)
    public String getId() {
        return this.id;
    }

    // Expected Behavior: Depositing adds exactly that amount
    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
            System.out.println("savings = " + this.savings);
        }
    }

    // Requirements: A withdrawal larger than current savings must be rejected
    public void withdraw(double amount) {
        if (amount > this.savings) {
            System.out.println("rejected, savings stays " + this.savings);
        } else if (amount > 0) {
            this.savings -= amount;
            System.out.println("savings = " + this.savings);
        }
    }
}