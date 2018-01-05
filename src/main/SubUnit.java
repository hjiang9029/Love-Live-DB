/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class representing a sub unit. A sub unit has
 * three members, a name, a main group and a list of songs.
 * 
 * Should create 6 instances of this type of object at the beginning,
 * 3 for each Main Group.
 * 
 * @version 2018-01-01
 * @author Henry Jiang
 *
 */
public class SubUnit implements IdolGroup {
    
    /**
     * the name for the sub unit.
     */
    private String name;
    
    /**
     * the list of songs for the sub unit.
     */
    private HashMap<Integer, Song> songs;
    
    /**
     * the list of idols in the sub unit.
     */
    private ArrayList<Idol> idols;
    
    /**
     * the main group this sub unit is a part of.
     */
    private MainGroup main;
    
    public SubUnit(String name) {
        this.name = name;
        songs = new HashMap<Integer, Song>();
        idols = new ArrayList<Idol>();
    }

    public void setMain(MainGroup main) {
        this.main = main;
    }
    
    /* (non-Javadoc)
     * @see main.IdolGroup#addIdol(main.Idol)
     */
    @Override
    public void addIdol(Idol idol) {
        if (idols.size() < 3) {
            idols.add(idol);
            idol.assignGroup(this);
        }
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#addSong(main.Song)
     */
    @Override
    public void addSong(Song song) {
        if (main.getSongs().containsValue(song)) {
            main.removeSong(song);
        }
        song.setGroup(this);
        songs.put(song.hashCode(), song);
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#getSongs()
     */
    @Override
    public HashMap<Integer, Song> getSongs() {
        return songs;
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = "";
        result += "Name: " + name;
        return result;
    }

}
