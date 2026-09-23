// Main class to run and test the program
public class p1 {
    public static void main(String[] args) {
        // Sample Input/Output Verification
        System.out.println("--- Starting Health Bar Test ---");
        
        // Character c = new Character(100);
        Character c = new Character(100);
        System.out.println("Created character with max health: " + c.getMaxHealth());
        System.out.println("Initial health: " + c.getCurrentHealth()); // Starts at 100
        System.out.println();

        // c.takeDamage(30) -> health = 70
        System.out.println("Applying 30 damage...");
        c.takeDamage(30);
        System.out.println("Current health: " + c.getCurrentHealth() + " (Expected: 70)");
        System.out.println();

        // c.heal(50) -> health = 100 (capped)
        System.out.println("Healing by 50...");
        c.heal(50);
        System.out.println("Current health: " + c.getCurrentHealth() + " (Expected: 100 - capped)");
        System.out.println();

        // c.takeDamage(150) -> health = 0 (floored)
        System.out.println("Applying 150 damage...");
        c.takeDamage(150);
        System.out.println("Current health: " + c.getCurrentHealth() + " (Expected: 0 - floored)");
    }
}

// Complete Character class implementation
class Character {
    // Private fields: cannot be accessed directly from outside
    private final int maxHealth;
    private int currentHealth;

    // Constructor: maximum health is final and fixed when the character is created
    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be greater than 0");
        }
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Starts fully healed
    }

    // Reduces health, clamping the minimum value at 0 (Hint 1 & 2)
    public void takeDamage(int amount) {
        if (amount < 0) return; // Prevent negative inputs from acting as heals
        
        int nextHealth = this.currentHealth - amount; // Calculate first
        if (nextHealth < 0) {
            this.currentHealth = 0; // Clamp at 0
        } else {
            this.currentHealth = nextHealth;
        }
    }

    // Increases health, clamping the maximum value at maxHealth (Hint 1 & 2)
    public void heal(int amount) {
        if (amount < 0) return; // Prevent negative inputs from acting as damage
        
        int nextHealth = this.currentHealth + amount; // Calculate first
        if (nextHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth; // Clamp at maximum
        } else {
            this.currentHealth = nextHealth;
        }
    }

    // Read-only method to check current health (no setter method provided)
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    // Read-only getter for maximum health
    public int getMaxHealth() {
        return this.maxHealth;
    }
}