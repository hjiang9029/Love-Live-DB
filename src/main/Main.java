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
    
    private static String[] inputs;
    
    /**
     * Drives the program
     * @param args unused.
     */
    public static void main(String[] args) {
        // set up.
        parser.parse();
        
        System.out.println("The syntax is as follows: ");
        System.out.println("[Item] {Specifics} {Language}");
        System.out.println("Square bracket fields are required, and Curly brackets are"
                + "Optional.");

        inputs = new String[3];
        System.out.println("Please enter input");
        while (true) {
            String entered = input.nextLine();
            String[] splitted = entered.split(" ");
        }
    }
    

}
