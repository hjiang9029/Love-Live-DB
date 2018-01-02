/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class representing an idol/character and its methods.
 * @version 2017-12-31
 * @author Henry
 *
 */
public class Idol {

    /**
     * The list of names this idol can be represented.
     */
    private final ArrayList<String> names;
    
    /**
     * The names for the voice actress of this idol.
     */
    private final ArrayList<String> vaName;
    
    /**
     * A string to represent an idol's image colour.
     */
    private final String color;
    
    /**
     * List of songs this idol centers in.
     */
    private ArrayList<Song> centers;
    
    /**
     * List of solos, duets or trios.
     */
    private ArrayList<Song> misc;
    
    /**
     * The groups this Idol is in (Includes sub unit).
     */
    private IdolGroup[] groups;
    
    /**
     * constructor for the idol class. Takes in two array of strings
     * from the parser for the names and
     * voice actress' names and another string for the image color.
     * @param names an array of strings.
     * @param voiceActress an array of strings.
     * @param color a string.
     */
    public Idol(String[] names, String[] voiceActress, String color) {
        this.names = new ArrayList<String>();
        this.names.addAll(Arrays.asList(names));
        
        vaName = new ArrayList<String>();
        vaName.addAll(Arrays.asList(voiceActress));
        
        centers = new ArrayList<Song>();
        misc = new ArrayList<Song>();
        
        groups = new IdolGroup[1];
        
        this.color = color;
    }

    /**
     * gets the arraylist of names as strings.
     * @return the names a string
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * returns the arraylist of names as strings.
     * @return the vaName a string.
     */
    public ArrayList<String> getVaName() {
        return vaName;
    }

    /**
     * returns the image colour as a string.
     * @return the color a string.
     */
    public String getColor() {
        return color;
    }
    
    /**
     * assigns the idol group a position in the array
     * depending on whether the object is a main group
     * or a sub unit.
     * @param group
     */
    public void assignGroup(IdolGroup group) {
        // the first IdolGroup must be a main group.
        if (group instanceof MainGroup) {
            groups[0] = group;
        }
        // the second IdolGroup must be a sub unit.
        else if (group instanceof SubUnit) {
            groups[1] = group;
        }
    }
    
    /**
     * creates and adds a center for this idol. also
     * adds it to the main group's list of songs.
     * @param name
     */
    public void addCenter(String name) {
        Song song = new Song(name, this);
        centers.add(song);
        groups[0].addSong(song);
    }
}
