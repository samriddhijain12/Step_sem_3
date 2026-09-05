import java.util.Arrays;

public class Player implements Comparable<Player> {
    // Encapsulated fields
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor required by the function signatures and examples
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded rule 1: Matches-played-only rule for established players (matches >= 10)
    // As per explanation: Virat and Dev clear this bar regardless of fitness
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Combined matches-and-fitness rule for everyone else (newer players)
    // As per explanation: Rahul falls short on experience (7), but clears this combined rule.
    // Therefore, thresholds can be defined as: matches >= 5 AND not injured.
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Must implement Comparable<Player> to sort descending by fantasy points (battingAverage)
    @Override
    public int compareTo(Player other) {
        // Since we want descending order (highest average first), compare other to this
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    // Static engine method to filter, sort, and format the draft order string
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        // 1. Filter out draftable players into a temporary collection/array
        Player[] draftableTemp = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            // A player is draftable if they meet the established bar OR the alternative combined bar
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableTemp[count++] = p;
            }
        }

        // Copy over exactly the elements that qualified
        Player[] draftableArray = Arrays.copyOf(draftableTemp, count);

        // 2. Sort the array using the native Standard Library implementation
        // This utilizes the descending compareTo() logic defined above
        Arrays.sort(draftableArray);

        // 3. Construct the output formatting string matching: "1. Name | 2. Name | 3. Name"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append(i + 1).append(". ").append(draftableArray[i].name);
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    // Main method to test the engine with the provided example case
    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);
        System.out.println("Output: \"" + result + "\"");
    }
}