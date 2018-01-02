/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * A class representing a sub unit. A sub unit has
 * three members, a name, a main group and a list of songs.
 * 
 * @version 2018-01-01
 * @author Henry
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
    private ArrayList<Song> songs;
    
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
        songs = new ArrayList<Song>();
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
        }
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#addSong(main.Song)
     */
    @Override
    public void addSong(Song song) {
        song.setGroup(this);
        songs.add(song);
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#getSongs()
     */
    @Override
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#getName()
     */
    @Override
    public String getName() {
        return name;
    }

}
