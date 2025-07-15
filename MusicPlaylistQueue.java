
class SongNode {

    String title;
    String artist;
    SongNode next;
    SongNode prev;

    public SongNode(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
        this.prev = null;
    }
}

class MusicPlaylist {

    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // Add song at end
    public void addSong(String title, String artist) {
        SongNode newSong = new SongNode(title, artist);
        if (tail == null) {
            head = tail = current = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
    }

    // Remove song by title
    public void removeSong(String title) {
        SongNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                if (current == temp) {
                    current = temp.next != null ? temp.next : head;
                }
                break;
            }
            temp = temp.next;
        }
    }

    // Play next song
    public void playNext() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title + " by " + current.artist);
        } else {
            System.out.println("No next song in playlist.");
        }
    }

    // Play previous song
    public void playPrevious() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title + " by " + current.artist);
        } else {
            System.out.println("No previous song in playlist.");
        }
    }

    // Display current song
    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current song: " + current.title + " by " + current.artist);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Display all songs
    public void displayPlaylist() {
        SongNode temp = head;
        System.out.println("Playlist:");
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.artist);
            temp = temp.next;
        }
    }
}

public class MusicPlaylistQueue {

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();

        playlist.addSong("Shape of You", "Ed Sheeran");
        playlist.addSong("Blinding Lights", "The Weeknd");
        playlist.addSong("Levitating", "Dua Lipa");

        playlist.displayPlaylist();
        playlist.displayCurrentSong();

        playlist.playNext();
        playlist.playNext();
        playlist.playPrevious();

        playlist.removeSong("Blinding Lights");
        playlist.displayPlaylist();
    }
}
