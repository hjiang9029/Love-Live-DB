/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A class representing an idol/character and its methods.
 * @version 2018-01-07
 * @author Henry Jiang
 *
 */
public class Idol implements AlternateLanguage {

    /**
     * The list of names this idol can be represented.
     * The first half of the names are in English,
     * the second half are in Japanese.
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
    private HashMap<Integer, Song> centers;
    
    /**
     * List of solos, duets or trios.
     */
    private HashMap<Integer, Song> misc;
    
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
        
        centers = new HashMap<Integer, Song>();
        misc = new HashMap<Integer, Song>();
        
        groups = new IdolGroup[2];
        
        this.color = color;
    }

    /**
     * gets the arraylist of names as strings.
     * @return the names a string
     */
    public ArrayList<String> getNames() {
        return names;
    }
    
    public ArrayList<String> getNames(Language lang) {
        ArrayList<String> result = new ArrayList<String>();
        switch (lang) {
            case EN:
                for (int i = 0; i < names.size() / 2; i++) {
                    result.add(names.get(i));
                }
                return result;
            case JP:
                for (int i = names.size() / 2; i < names.size(); i++) {
                    result.add(names.get(i));
                }
                return result;
            default:
                break;
        }
        throw new IllegalArgumentException("No such language");
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
     * assigns the idolgroup a position in the array
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
     * 
     * @param name the name of the song to add.
     * @param jpName the name in japanese.
     */
    public void addCenter(String name, String jpName) {
        Song song = new Song(name, jpName, this);
        centers.put(song.hashCode(), song);
        groups[0].addSong(song);
    }
    
    /**
     * creates and adds a solo/duo/trio song for this idol.
     * Also adds the song to the main group's list of songs.
     * 
     * @param name the name of the song to add.
     * @param jpName the name in japanese.
     */
    public void addMisc(String name, String jpName) {
        Song song = new Song(name, jpName);
        misc.put(song.hashCode(), song);
        groups[0].addSong(song);
    }
    
    public String toStringFull() {
        String result = "";
        result += "Names: ";
        result += MainGroup.turnToString(names);
        result += "\nGroup: ";
        result += groups[0].getName();
        result += "\nVoice Actress: " + MainGroup.turnToString(vaName);
        result += "\nCenters: " + MainGroup.turnToString(centers);
        result += "\nSolos/Duos/Trios: " + MainGroup.turnToString(misc);
        result += "\nSub unit: " + groups[1].getName();
        return result;
    }
    
    /**
     * Returns the name in the language specified.
     * @param lang the language.
     * @return the name as a string.
     */
    public String toString(Language lang) {
        if (lang.equals(Language.EN)) {
            return names.get(0);
        } else {
            if (lang.equals(Language.JP)) {
                return names.get(names.size() / 2);
            }
        }
        // should not get here.
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[" + names.get(0) + ", " + names.get(names.size() / 2) + "]";
    }
}
