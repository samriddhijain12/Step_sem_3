public class InventoryParser{

    public static void parseInventoryRecord(String csvLine) {
       
        String[] fields = csvLine.split(",");

        
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        
        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

       
        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + qty);
    }

    // Main method to test the sample inputs
    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.println("\n--- Test Case 2 ---");
        parseInventoryRecord("Wireless Mouse,150");
    }
}