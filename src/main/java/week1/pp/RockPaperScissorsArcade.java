import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsArcade {

    // Main execution method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 5; // Suggested N = 5
        
        // Arrays to store history for the summary table
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];
        
        // Score trackers
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Welcome to The College Coding Arcade ===");
        System.out.println("Please enter Rock, Paper, or Scissors for each round.\n");

        for (int i = 0; i < totalRounds; i++) {
            System.out.print("Round " + (i + 1) + " — Enter your move: ");
            String playerMove = scanner.nextLine().trim();
            
            // Basic normalization to handle case inconsistencies
            playerMove = capitalize(playerMove);
            
            // Generate computer move randomly
            String computerMove = generateComputerMove(random);
            
            // Evaluate the winner
            String result = playRound(playerMove, computerMove);
            
            // Store data for the summary table
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;
            
            // Update stats
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            
            // Display round result immediately
            System.out.println("Round " + (i + 1) + " — Player: " + playerMove + ", Computer: " + computerMove + " -> " + result);
        }
        
        // After all rounds, print the summary table
        System.out.println("\n========================================================");
        System.out.printf("%-10s | %-12s | %-13s | %-13s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("Round %-5d | %-12s | %-13s | %-13s\n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("========================================================");
        
        // Print the final summary stats
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("Final Summary (after %d rounds)\n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        
        scanner.close();
    }

    /**
     * core task: Determine and display the winner of each round using standard rules.
     * Suggested method signature implemented here.
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        // Check winning conditions for the player
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        
        // If it's not a draw and player didn't win, computer wins
        return "Computer Wins";
    }

    // Helper method to randomly pick the computer's choice
    private static String generateComputerMove(Random random) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    // Helper method to ensure uniform casing for the print layout
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return "";
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}