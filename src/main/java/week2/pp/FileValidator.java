public class FileValidator {

    public static String validateFileExtension(String filename) {
        // 1. Find the last '.' using lastIndexOf()
        int dotIndex = filename.lastIndexOf('.');
        
        // Handle cases where no dot exists or it is the very last character
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        
        // 2. Extract the extension using substring()
        String extension = filename.substring(dotIndex + 1);
        
        // 3. Compare the extension case-insensitively using equalsIgnoreCase()
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    // Main method to test the sample inputs
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF")); // Output: Accepted
        System.out.println(validateFileExtension("notes.txt"));       // Output: Rejected — invalid file type
