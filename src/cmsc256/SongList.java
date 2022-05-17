package cmsc256;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;
import java.util.List;

public class SongList {

    public static void main(String[] args) {

        // This gets the artist from the arguments provided to the program
        String artist = args[0];
        // If user didn't pass artist prompt them to pass artist
        if (artist == null) {
            System.out.println("Please provide an artist in argument");
            return;
        }
        // Call method that gets formatted songs list for an artist and print it
        String songs = new SongList().getSongByArtist(artist);
        System.out.println(songs);
        return;

    }

    public String getSongByArtist(String artist) {
        // Get list of songs from bridges
        Bridges bridges = new Bridges(5, "rizviab", "758109054030");
        DataSource ds = bridges.getDataSource();
        List<Song> songData = null;

        try {
            songData = ds.getSongData();
        } catch (Exception e) {
            return "Unable to connect to Bridges.";
        }

        // Using custom song comparator class sort the songs list
        SongComparator songComparator = new SongComparator();
        songData.sort(songComparator);

        // Create a linked list and iterate/loop through the songs list from bridges and append each song to the linked list
        LList<Song> songList = new LList<Song>();
        int songDataSize = songData.size();

        for (int i = 0; i < songDataSize; i++) {
            Song song = songData.get(i);
            if (song.getArtist().equals(artist)) {
                songList.append(song);
            }
        }

        // If there are no songs for the artist tell the user no songs could be found
        if (songList.length() == 0) {
            return "No Songs found for this artist";
        }

        // Traverse the linked list and append formatted song data for each linked list node to formattedSongsList String
        String formattedSongsList = "";
        songList.moveToStart();
        while (!songList.isAtEnd()) {
            formattedSongsList += "Title: " + songList.getValue().getSongTitle() + " " +
                    "Artist: " + songList.getValue().getArtist() + " " +
                    "Album: " + songList.getValue().getAlbumTitle() + "\n";
            songList.next();
        }
        // return the formatted songs list
        return formattedSongsList;
    }
}