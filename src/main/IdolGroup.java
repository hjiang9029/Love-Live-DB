/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class representing an idol group and its methods.
 * @version 2017-12-31
 * @author Henry Jiang
 *
 */
public class IdolGroup {
    
    /**
     * a string to represent the name of the group.
     */
    private final ArrayList<String> names;
    
    /**
     * an array list to represent the idols in the group.
     */
    private ArrayList<Idol> idols;
    
    public IdolGroup(String[] names) {
        idols = new ArrayList<Idol>(9);
        this.names = new ArrayList<String>();
        this.names.addAll(Arrays.asList(names));
    }
    
    public void addIdol(Idol idol) {
        if (idols.size() != 9) {
            idols.add(idol);
        }
    }
}
