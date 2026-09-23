// Save this file as Main.java

class TrafficLight {
    // Requirements: Private variables and a final fixed ID
    private final String id;
    private String color;

    // Ordered cycle as suggested by Hint 1
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private int currentIndex;

    // Expected Behavior: A new light starts on "RED" and takes a final ID
    public TrafficLight(String id) {
        this.id = id;
        this.currentIndex = 0; // Index 0 corresponds to "RED"
        this.color = COLORS[this.currentIndex];
    }

    // Requirement: Provide a read-only way to check the current color
    public String getColor() {
        return this.color;
    }

    // Requirement: Provide a read-only way to check the final ID
    public String getId() {
        return this.id;
    }

    // Requirement: Move forward strictly through the cycle (red -> green -> yellow -> red)
    public void next() {
        // Increment index and use modulo to cycle back to 0 after reaching the end
        this.currentIndex = (this.currentIndex + 1) % COLORS.length;
        this.color = COLORS[this.currentIndex];
    }
}

public class p3{
    public static void main(String[] args) {
        // Sample Input/Output from the assignment prompt
        TrafficLight t = new TrafficLight("TL-9");
        
        System.out.println("t.getColor() -> " + t.getColor()); // Expected: RED
        
        t.next();
        System.out.println("t.next() -> " + t.getColor());    // Expected: GREEN
        
        t.next();
        System.out.println("t.next() -> " + t.getColor());    // Expected: YELLOW
        
        t.next();
        System.out.println("t.next() -> " + t.getColor());    // Expected: RED
    }
}