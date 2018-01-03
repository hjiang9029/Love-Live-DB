/**
 * 
 */
package main;

import java.util.HashMap;

/**
 * An interface representing an idol group.
 * @version 2018-01-01
 * @author Henry Jiang
 *
 */
public interface IdolGroup {
    
    /**
     * adds an idol to the group.
     * @param idol an idol object.
     */
    void addIdol(Idol idol);
    
    /**
     * adds a song to the group.
     * @param song a song object.
     */
    void addSong(Song song);
    
    /**
     * gets the list of songs.
     * @return a list of songs.
     */
    HashMap<Integer, Song> getSongs();
    
    /**
     * gets the list of names.
     * @return a list of names.
     */
    String getName();
    
}
