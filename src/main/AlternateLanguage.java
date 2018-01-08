/**
 * 
 */
package main;

/**
 * Represents classes that implement multiple (>1) languages.
 * @version 2018-01-07
 * @author Henry Jiang
 *
 */
public interface AlternateLanguage {
    /**
     * Returns this information in a certain language.
     * @param lang the language.
     * @return a string.
     */
    String toString(Language lang);
    
    String getName(Language lang);
}
