/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class that represents the main groups. A main group has 9 members, a list
 * of songs, 3 sub units, and a name.
 * 
 * Should create two static objects of this type at the beginning, one for Muse,
 * one for Aqours.
 * 
 * @version 2018-01-07
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
    private HashMap<Integer, Song> songs;

    /**
     * constructor for a main group. a main group has a name, list of idols, a list
     * of songs and a list of sub units.
     * 
     * @param name
     *            a string.
     */
    public MainGroup(String name) {
        this.idols = new ArrayList<Idol>(9);
        this.songs = new HashMap<Integer, Song>();
        this.name = name;
        this.units = new ArrayList<SubUnit>();
    }

    /**
     * adds a sub unit to this group. A main group can only have up to 3 sub units.
     * 
     * @param sub
     *            the sub unit to add.
     */
    public void addSubUnit(SubUnit sub) {
        if (units.size() < 3 && !(units.contains(sub))) {
            units.add(sub);
            sub.setMain(this);
        }
    }

    /**
     * Overloaded method to add a sub unit. Creates a sub unit with a string then
     * adds the sub unit.
     * 
     * @param sub
     *            a string.
     */
    public void addSubUnit(String sub) {
        if (units.size() < 3) {
            SubUnit newUnit = new SubUnit(sub);
            if (!units.contains(newUnit)) {
                units.add(newUnit);
                newUnit.setMain(this);
            }
        }
    }

    /**
     * Overloaded method to add a sub unit. If the sub unit already exists, just add
     * the idol. Otherwise add the idol to the sub unit then add the new sub unit to
     * the list.\
     * 
     * @param sub
     *            a string representing the name of the group.
     * @param idol
     *            an idol.
     */
    public void addSubUnit(String sub, Idol idol) {
        SubUnit newUnit = new SubUnit(sub);
        if (!units.contains(newUnit)) {
            newUnit.addIdol(idol);
            addSubUnit(newUnit);
        } else {
            getSubUnit(newUnit).addIdol(idol);
        }
    }

    /**
     * gets the list of sub units this group has.
     * 
     * @return
     */
    public ArrayList<SubUnit> getSubUnits() {
        return units;
    }

    /**
     * returns a specific sub unit.
     * 
     * @return a subunit.
     */
    public SubUnit getSubUnit(SubUnit unit) {
        for (int i = 0; i <= units.size(); i++) {
            if (units.get(i).equals(unit)) {
                return units.get(i);
            }
        }
        // Should not get here.
        return null;
    }

    /**
     * returns the total number of songs this group has.
     * 
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
     * removes a song from the list. Should only be called by a SubUnit object to
     * remove a sub unit song from this list and add it to a sub unit.
     * 
     * @param song
     *            the song to remove.
     */
    public void removeSong(Song song) {
        if (songs.get(song.hashCode()) != null) {
            songs.get(song.hashCode()).setGroup(null);
            songs.remove(song.hashCode());
        }
    }

    /**
     * returns the list of idols.
     * 
     * @return the idols
     */
    public ArrayList<Idol> getIdols() {
        return idols;
    }

    public Idol getIdol(String name) {
        for (Idol idol : idols) {
            for (String string : idol.getNames()) {
                if (string.equalsIgnoreCase(name)) {
                    return idol;
                }
            }
        }
        throw new IllegalArgumentException("This Idol does not exist" + "in this group.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.IdolGroup#addIdol()
     */
    @Override
    public void addIdol(Idol idol) {
        if (idols.size() < 9) {
            idols.add(idol);
            idol.assignGroup(this);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.IdolGroup#addIdol()
     */
    @Override
    public void addSong(Song song) {
        if (!songs.containsValue(song) && !checkSubUnits(song)) {
            song.setGroup(this);
            songs.put(song.hashCode(), song);
        }
    }

    @Override
    public void addSong(String nameEN, String nameJP) {
        Song song = new Song(nameEN, nameJP);
        if (!songs.containsValue(song) && !checkSubUnits(song)) {
            song.setGroup(this);
            songs.put(song.hashCode(), song);
        }
    }

    /**
     * helper method for addSong, checks if the sub unit has the song the main group
     * is trying to add.
     * 
     * @param song
     *            a song.
     * @return true if any of the sub units contain the song, false if not.
     */
    private boolean checkSubUnits(Song song) {
        for (SubUnit unit : units) {
            if (unit.getSongs().containsValue(song)) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.IdolGroup#getName()
     */
    @Override
    public Song getSong(String name) {
        for (Song song : songs.values()) {
            if (song.getName().equalsIgnoreCase(name)) {
                return song;
            }
        }
        for (SubUnit sub : units) {
            for (Song song : sub.getSongs().values()) {
                if (song.getName().equalsIgnoreCase(name)) {
                    return song;
                }
            }
        }
        throw new IllegalArgumentException("No such song in this group...");
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.IdolGroup#getSongs()
     */
    @Override
    public HashMap<Integer, Song> getSongs() {
        return songs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.IdolGroup#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    public static String turnToString(ArrayList<?> items) {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            if (i != items.size() - 1) {
                if ((i + 1) % 5 != 0) {
                    result += items.get(i) + ", ";
                } else {
                    result += "\n" + items.get(i) + ", ";
                }
            } else {
                result += items.get(i);
            }
        }
        return result;
    }

    public static String turnToString(ArrayList<AlternateLanguage> items, Language lang) {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            if (i != items.size() - 1) {
                if ((i + 1) % 5 != 0) {
                    result += items.get(i).getName(lang) + ", ";
                } else {
                    result += "\n" + items.get(i).getName(lang) + ", ";
                }
            } else {
                result += items.get(i).getName(lang);
            }
        }
        return result;
    }

    public static String turnToString(HashMap<Integer, Song> items) {
        String result = "";
        result += turnToString(items, Language.EN);
        result += "\n日本語で:";
        result += turnToString(items, Language.JP);
        return result;
    }

    public static String turnToString(HashMap<Integer, Song> items, Language lang) {
        String result = "";
        int valueSize = items.values().size();
        int count = 0;
        for (Song song : items.values()) {
            if (count != valueSize) {
                if (!(count % 5 == 0)) {
                    result += song.getName(lang) + ", ";
                } else {
                    result += "\n" + song.getName(lang) + ", ";
                }
            }
            count++;
        }
        return result;
    }

    public String toString(Language lang) {
        String result = "";
        ArrayList<AlternateLanguage> temp = new ArrayList<AlternateLanguage>();
        result += "Name: " + name;
        result += "\nMembers: ";
        temp.addAll(idols);
        result += turnToString(temp, lang);
        result += "\nSub Units: ";
        temp.removeAll(temp);
        result += turnToString(units);
        result += "\nSongs: ";
        result += turnToString(songs, lang);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = "";
        result += "Name: " + name;
        result += "\nMembers: ";
        result += turnToString(idols);
        result += "\nSub Units: ";
        result += turnToString(units);
        result += "\nSongs: ";
        result += turnToString(songs);
        return result;
    }

}
