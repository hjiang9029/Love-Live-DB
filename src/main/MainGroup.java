/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * A class that represents the main groups. A main group has
 * 9 members, a list of songs, 3 sub units, and a name.
 * 
 * @version 2018-01-01
 * @author Henry Jiang
 *
 */
public class MainGroup implements IdolGroup {
    
    /**
     * the list of names this represents
     */
    private String name;
    
    /**
     * the list of idols this object has.
     */
    private ArrayList<Idol> idols;
    
    /**
     * the list of sub units this object has.
     */
    private ArrayList<SubUnit> units;
    
    /**
     * the list of songs this object has.
     */
    private ArrayList<Song> songs;
    
    public MainGroup(String name) {
        this.idols = new ArrayList<Idol>(9);
        this.songs = new ArrayList<Song>();
        this.name = name;
        this.units = new ArrayList<SubUnit>();
    }
    
    public void addSubUnit(SubUnit sub) {
        if (units.size() < 3) {
            units.add(sub);
        }
    }
    
    public ArrayList<SubUnit> getSubUnits() {
        return units;
    }

    /* (non-Javadoc)
     * @see main.IdolGroup#addIdol()
     */
    @Override
    public void addIdol(Idol idol) {
        if (idols.size() < 9) {
            idols.add(idol);
        }
    }
    
    /* (non-Javadoc)
     * @see main.IdolGroup#addIdol()
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
