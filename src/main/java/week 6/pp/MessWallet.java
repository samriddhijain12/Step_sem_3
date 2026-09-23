public class MessWallet {
    // Define a class MessWallet with a private double balance field
    private double balance;

    // Write a public constructor that accepts an opening balance
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            // If a negative value is given, start at 0 instead and print a warning
            System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Write a public method topUp(double amount)
    public void topUp(double amount) {
        // Rejects amount <= 0 with a message
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0.");
        } else {
            // Otherwise adds it to the balance
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Write a public method deduct(double amount)
    public void deduct(double amount) {
        // Rejects any amount greater than the current balance, printing a clear message
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    // Write a public getBalance() method for read-only access
    public double getBalance() {
        return this.balance;
    }

    // Main method to test the sample input / output scenario
    public static void main(String[] args) {
        // Sample Input: opening = 500
        MessWallet wallet = new MessWallet(500);

        // topUp(200)
        wallet.topUp(200);

        // deduct(1000)
        wallet.deduct(1000);

        // Print final balance
        System.out.println("Final balance: " + wallet.getBalance());
    }
}