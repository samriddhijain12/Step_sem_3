import java.util.Arrays;

// The Playlist class meeting all structural and security requirements
class Playlist {
    // Private attributes to encapsulate the state
    private String[] songs;
    private int songCount;

    // Constructor to initialize the playlist with a fixed maximum size
    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    // Method to add a song to the playlist
    public void addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount] = songTitle;
            songCount++;
        } else {
            System.out.println("Playlist is full! Cannot add: " + songTitle);
        }
    }

    // Method that returns a safe copy of the songs added so far (Defensive Copy)
    public String[] getSongs() {
        // Creates and returns a brand new array matching the exact count of songs added
        return Arrays.copyOf(this.songs, this.songCount);
    }

    // Read-only getter method for the current song count
    public int getSongCount() {
        return this.songCount;
    }
}

// Main class to run and test the program behavior
public class p2{
    public static void main(String[] args) {
        // 1. Create a playlist with a fixed maximum size of 10
        Playlist p = new Playlist(10);

        // 2. Add songs to the playlist
        p.addSong("Song A");
        p.addSong("Song B");

        // 3. Get the list of songs (returns a copy)
        String[] copy = p.getSongs();
        System.out.println("Songs in copy: " + Arrays.toString(copy));
        System.out.println("Song count: " + p.getSongCount());

        // 4. Attempt to modify the retrieved array from the outside
        System.out.println("\n--- Attempting to hack/modify the array copy ---");
        copy[0] = "Hacked"; 

        // 5. Verify if the original playlist contents remain safe
        System.out.println("Modified copy[0]: " + copy[0]);
        System.out.println("Actual playlist song at index 0: " + p.getSongs()[0]);
        
        if (p.getSongs()[0].equals("Song A")) {
            System.out.println("\nSuccess: The playlist is safe from external changes!");
        } else {
            System.out.println("\nFailure: The internal playlist was modified.");
        }
    }
}
