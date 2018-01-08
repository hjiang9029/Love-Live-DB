/**
 * 
 */
package main;

/**
 * A class representing a song.
 * @version 2018-01-07
 * @author Henry Jiang
 *
 */
public class Song implements AlternateLanguage {
    
    /**
     * the name romanized or english to represent the song.
     */
    private final String name;
    
    /**
     * the name in japanese.
     */
    private final String jpName;
    
    /**
     * the center for this song. This may or may not exist.
     */
    private Idol center;
    
    /**
     * the group this song belongs to. Can belong to either a
     * main group or a sub unit.
     */
    private IdolGroup group;
    
    /**
     * Constructor for a song. Takes in a name as a string
     * and an Idol object for the center.
     * @param name a string.
     * @param center an idol.
     */
    public Song(String name, String jpName, Idol center) {
        this.name = name;
        this.jpName = jpName;
        this.center = center;
    }
    
    /**
     * Overloaded constructor for a song, if the song does not
     * have a center use this.
     * @param name a string.
     */
    public Song(String name, String jpName) {
        this.name = name;
        this.jpName = jpName;
        this.center = null;
    }
    
    /**
     * Sets the idol group for this song.
     * @param group
     */
    public void setGroup(IdolGroup group) {
        this.group = group;
    }
    
    /**
     * Gets the name of this song. (In English).
     * @return
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the name of this song. (In Japanese).
     * @return
     */
    public String getJPName() {
        return this.jpName;
    }
    
    public String getName(Language lang) {
        switch (lang) {
            case EN:
                return this.name;
            case JP:
                return this.jpName;
            default:
                break;
        }
        throw new IllegalArgumentException("No such language");
    }
    
    /**
     * Gets the center for this song.
     * @return an Idol.
     */
    public Idol getCenter() {
        if (center != null) {
            return this.center;
        }
        throw new IllegalArgumentException("There is no center for this...");
    }
    
    /**
     * Sets the center for this song.
     * @param center
     */
    public void setCenter(Idol center) {
        this.center = center;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((jpName == null) ? 0 : jpName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass() || obj == null)
            return false;
        Song other = (Song) obj;
        if (jpName == null) {
            if (other.jpName != null)
                return false;
        } else if (!jpName.equals(other.jpName))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
    public String toString(Language lang) {
        String result = "";
        result += "Name: " + getName(lang);
        if (group != null) {
            result += "\nGroup: " + group.getName();
        }
        if (center != null) {
            result += "\nCenter: " + center.getName(lang); 
        }
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = "";
        result += "Name (JP): " + jpName;
        result += "\nName (EN): " + name;
        if (group != null) {
            result += "\nGroup: " + group.getName();
        }
        if (center != null) {
            result += "\nCenter: " + center; 
        }
        return result;
    }
}
