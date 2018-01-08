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

        while (true) {
            System.out.println("Please enter input");
            String entered = input.nextLine();
            String[] splitted = entered.split(" ");
            
            String item = "";
            Language toUse = null;
            
            for (String string : splitted) {
                if (string.equalsIgnoreCase("EN") || string.equalsIgnoreCase("JP")) {
                    try {
                        toUse = chooseLanguage(splitted[splitted.length - 1]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("No such language");
                    }
                } else {
                    item += string + " ";
                }
            }
            compute(item.trim(), toUse);
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
        String result = "";
        if (input2 == null) {
            try {
                result = findElement(input1);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println("No such element.");
            }
        } else {
            try {
                result = findElement(input1, input2);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println("No such element.");
            }
        }
    }
    
    private static String findElement(String input) {
        if (Parser.Aqours.getName().equalsIgnoreCase(input)) {
            return Parser.Aqours.toString();
        } else if (Parser.Muse.getName().equalsIgnoreCase(input)) {
            return Parser.Muse.toString();
        }
        MainGroup[] groups = {Parser.Muse, Parser.Aqours};
        for (MainGroup main : groups) {
            for (SubUnit sub : main.getSubUnits()) {
                if (sub.getName().equalsIgnoreCase(input)) {
                    return sub.toStringFull();
                } else {
                    for (Idol idol : sub.getIdols()) {
                        for (String name : idol.getNames()) {
                            if (name.equalsIgnoreCase(input)) {
                                return idol.toStringFull();
                            }
                        }
                    }
                    for (Song song : sub.getSongs().values()) {
                        if (song.getName().equalsIgnoreCase(input)) {
                            return song.toString();
                        }
                    }
                }
            }
            for (Song song : main.getSongs().values()) {
                if (song.getName().equalsIgnoreCase(input)) {
                    return song.toString();
                }
            }
        }
        throw new IllegalArgumentException();
    }
    
    private static String findElement(String input, Language lang) {
        if (Parser.Aqours.getName().equalsIgnoreCase(input)) {
            return Parser.Aqours.toString(lang);
        } else if (Parser.Muse.getName().equalsIgnoreCase(input)) {
            return Parser.Muse.toString(lang);
        }
        MainGroup[] groups = {Parser.Muse, Parser.Aqours};
        for (MainGroup main : groups) {
            for (SubUnit sub : main.getSubUnits()) {
                if (sub.getName().equalsIgnoreCase(input)) {
                    return sub.toString(lang);
                } else {
                    for (Idol idol : sub.getIdols()) {
                        for (String name : idol.getNames()) {
                            if (name.equalsIgnoreCase(input)) {
                                return idol.toString(lang);
                            }
                        }
                    }
                    for (Song song : sub.getSongs().values()) {
                        if (song.getName().equalsIgnoreCase(input)) {
                            return song.toString(lang);
                        }
                    }
                }
            }
            for (Song song : main.getSongs().values()) {
                if (song.getName().equalsIgnoreCase(input)) {
                    return song.toString(lang);
                }
            }
        }
        throw new IllegalArgumentException();
    }

}
