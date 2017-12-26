package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The parser for the program. This class will read
 * the json file and assign data based on the file.
 * 
 * @version 2017-12-25
 * @author Henry Jiang
 *
 */
public class Parser {
    
    private static final String filePath = "C:\\Users\\Henry\\eclipse-workspace\\Love Live Database\\data.json";
    
    public static void main(String[] args) {
        
        try {
            FileReader reader = new FileReader(filePath);
            
            JSONParser parser = new JSONParser();
            JSONArray arrObject = (JSONArray) parser.parse(reader);
            
            for (int i = 0; i < arrObject.size(); i++) {
                
                JSONObject object = (JSONObject) arrObject.get(i);
                
                String flag = (String) object.get("flag");
                System.out.println("This is a " + flag + " object");
                
                JSONArray arr = (JSONArray) object.get("name");
                
                for (int x = 0; x < arr.size(); x++) {
                    String name = (String) arr.get(x);
                    System.out.println("This is a name " + name);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("What even happened");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Can't parse?");
            e.printStackTrace();
        }
    }
}
