/**
 * 
 */
package main;

import java.util.HashMap;

/**
 * An interface representing an idol group.
 * @version 2018-01-06
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
     * Overloaded method to add a song to the group.
     * Uses two strings to construct the song and add 
     * it to the group.
     * 
     * @param nameEN a string.
     * @param nameJP a string.
     */
    void addSong(String nameEN, String nameJP);
    
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
