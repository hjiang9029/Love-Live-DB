/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * A class that represents the main groups. A main group has
 * 9 members, a list of songs, 3 sub units, and a name.
 * 
 * Should create two static objects of this type at the beginning,
 * one for Muse, one for Aqours.
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
    
    /**
     * adds a sub unit to this group. A main group can only have up
     * to 3 sub units.
     * @param sub
     */
    public void addSubUnit(SubUnit sub) {
        if (units.size() < 3) {
            units.add(sub);
        }
    }
    
    /**
     * gets the list of sub units this group has.
     * @return
     */
    public ArrayList<SubUnit> getSubUnits() {
        return units;
    }
    
    /**
     * returns the total number of songs this group has.
     * @return
     */
    public int getTotalSongs() {
        int result = 0;
        result += songs.size();
        for (SubUnit unit : units) {
            result += unit.getSongs().size();
        }
        return result;
    }
    
    /**
     * removes a song from the list. Should only be called by
     * a SubUnit object to remove a sub unit song from this list
     * and add it to a sub unit.
     * 
     * @param song the song to remove.
     */
    public void removeSong(Song song) {
        if (songs.contains(song)) {
            int position = songs.indexOf(song);
            songs.get(position).setGroup(null);
            songs.remove(song);
        }
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
        if (!songs.contains(song)) {
            song.setGroup(this);
            songs.add(song);
        }
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
