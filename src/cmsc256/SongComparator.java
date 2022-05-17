/*

 *  SongComparator

 *  implements a comparator interface/method to sort through albums and songs alphabetically

 *

 * CMSC 256 Project 3

 * @author Anna Rizvi

 */

package cmsc256;

import bridges.data_src_dependent.Song;
import java.util.Comparator;

public class SongComparator implements Comparator<Song> {

    @Override
    public int compare(Song song1, Song song2) {

        // If song1 album is null move null albums to the bottom
        if (song1.getAlbumTitle() == null) {
            return -1;
        }

        // If song2 album is null move null albums to the bottom
        if (song2.getAlbumTitle() == null) {
            return 1;
        }


        if (song1.getAlbumTitle().compareTo(song2.getAlbumTitle()) > 0) { // If album1 is greater return greater
            return 1;
        } else if (song1.getAlbumTitle().compareTo(song2.getAlbumTitle()) < 0) {  // If album 2 is greater return lesser
            return -1;
        } else { // When equal then that means albums are the same and now we can sort songs within album group
            // If song1 artist is null move null albums to the bottom
            if (song1.getSongTitle() == null) {
                return -1;
            }

            // If song1 artist is null move null albums to the bottom
            if (song2.getSongTitle() == null) {
                return 1;
            }

            if (song1.getSongTitle().compareTo(song2.getSongTitle()) > 0) { // same logic as above
                return 1;
            } else if (song1.getSongTitle().compareTo(song2.getSongTitle()) < 0) { // same logic as above
                return -1;
            } else { // same logic as above
                return 0;
            }
        }
    }


};