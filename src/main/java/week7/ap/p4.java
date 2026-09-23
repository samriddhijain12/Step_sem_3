// Main entry point to run and verify the Shopping Cart logic
public class p4 {
    public static void main(String[] args) {
        // 1. Initialize a new cart matching the Sample Input/Output
        Cart cart = new Cart("CART-5", 20);

        // 2. Add prices exactly as specified in the assignment
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        // 3. Print out the expected dynamic values
        System.out.println("cart.getTotal() -> " + cart.getTotal());       // Output: 500.0
        System.out.println("cart.getItemCount() -> " + cart.getItemCount()); // Output: 3
    }
}

// Complete Cart class blueprint handling encapsulation and specifications
class Cart {
    // Requirements: Private, encapsulated data fields
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    /**
     * Constructor setting up a final cart ID and fixed-size internal array.
     * @param cartId Unique identifier fixed upon creation.
     * @param maxItems The static upper bound capacity limit for the array.
     */
    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0; // Starts empty
    }

    /**
     * Requirement: Method to append a single item's price into the array storage.
     * Includes array safety check to prevent IndexOutOfBounds exceptions.
     */
    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++; // Increments structural pointer tracking next slot
        } else {
            System.out.println("Error: The shopping cart has reached its limit of " + prices.length + " items.");
        }
    }

    /**
     * Requirement: Read-only dynamic total summary computed purely on demand.
     * Hint 1: Scans existing added slots sequentially without using static tracking variables.
     */
    public double getTotal() {
        double currentTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            currentTotal += prices[i];
        }
        return currentTotal;
    }

    /**
     * Requirement: Read-only active size count visibility.
     * Hint 2: Exposes the tracker showing exactly where the next slot maps.
     */
    public int getItemCount() {
        return this.itemCount;
    }

    /**
     * Optional accessor helper exposing the permanent identity token.
     */
    public String getCartId() {
        return this.cartId;
    }
}
