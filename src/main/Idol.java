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
    
    // List of songs this idol centers in.
    // private final ArrayList<Songs> centers;
    
    // List of solos, duets or trios.
    // private final ArrayList<Songs> misc;
    
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
}
