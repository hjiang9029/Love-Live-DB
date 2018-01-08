/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * Main method of the program.
 * @version 2018-01-07
 * @author Henry Jiang
 *
 */
public class Main {
    
    private static Parser parser = new Parser();
    
    private static Scanner input = new Scanner(System.in);
    
    /**
     * Drives the program
     * @param args unused.
     */
    public static void main(String[] args) {
        // set up.
        parser.parse();
        
        System.out.println("Please input in a format like this: ");
        System.out.println("[Item] {Language}");
        System.out.println("Square bracket fields are required, and Curly brackets are"
                + "Optional.");

        System.out.println("Please enter input");
        while (true) {
            String entered = input.nextLine();
            String[] splitted = entered.split(" ");
            
            String item = splitted[0];
            Language toUse = null;
            if (splitted.length == 2) {
                toUse = chooseLanguage(splitted[1]);
            }
        }
    }
    
    /**
     * Helper method to determine language if inputted.
     * @param choice a string.
     * @return the language to use.
     */
    private static Language chooseLanguage(String choice) {
        switch (choice) {
        case "JP":
            return Language.JP;
            
        case "EN":
            return Language.EN;
        
        default:
            break;
        }
        throw new IllegalArgumentException("There was no Language");
    }
    
    private static void compute(String input1, Language input2) {
        
        if (input2 == null) {
            switch(input1.toLowerCase()) {
            //TODO
            }
        }
    }
    
    private static void handleSubUnit(String name) {
        
    }

}
