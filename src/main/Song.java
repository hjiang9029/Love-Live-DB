/**
 * 
 */
package main;

/**
 * A class representing a song.
 * @version 2018-01-01
 * @author Henry
 *
 */
public class Song {
    
    private final String name;
    
    private final Idol center;
    
    /**
     * Constructor for a song. Takes in a name as a string
     * and an Idol object for the center.
     * @param name a string.
     * @param center an idol.
     */
    public Song(String name, Idol center) {
        this.name = name;
        this.center = center;
    }
    
    /**
     * Overloaded constructor for a song, if the song does not
     * have a center use this.
     * @param name a string.
     */
    public Song(String name) {
        this.name = name;
        this.center = null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (center == null) {
            return name;
        } return name + "\n Center: " + center.getNames().get(0);
    }
    
}
