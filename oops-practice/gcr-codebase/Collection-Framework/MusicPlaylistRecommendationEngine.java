import java.util.*;
public class MusicPlaylistRecommendationEngine {

    static LinkedList<String> playlist = new LinkedList<>();

    static void playSong(String song) {
        playlist.addFirst(song);

        if (playlist.size() > 10) {
            playlist.removeLast();
        }

        System.out.println(song + " added.");
    }

    static void searchSong(String song) {
        if (playlist.contains(song))
            System.out.println(song + " found.");
        else
            System.out.println(song + " not found.");
    }

    static void displayPlaylist() {
        System.out.println("Recently Played:");

        for (String song : playlist)
            System.out.println(song);
    }

    public static void main(String[] args) {

        playSong("Song A");
        playSong("Song B");
        playSong("Song C");
        playSong("Song D");
        playSong("Song E");
        playSong("Song F");
        playSong("Song G");
        playSong("Song H");
        playSong("Song I");
        playSong("Song J");
        playSong("Song K");

        searchSong("Song C");

        displayPlaylist();
    }
}