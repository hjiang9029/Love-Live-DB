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
 * @version 2017-01-04
 * @author Henry Jiang
 *
 */
public class Parser {
    
    private static final String filePath = "C:\\Users\\Henry\\eclipse-workspace\\Love Live Database\\data.json";
    
    public static MainGroup Muse;
    public static MainGroup Aqours;
    
    /**
     * Parses the json and returns data based on it.
     */
    public void parse() {
        
        try {
            FileReader reader = new FileReader(filePath);
            
            JSONParser parser = new JSONParser();
            // represents the array of objects.
            JSONArray arrObject = (JSONArray) parser.parse(reader);
            
            for (int i = 0; i < arrObject.size(); i++) {
                
                // represents one individual object
                JSONObject object = (JSONObject) arrObject.get(i);
                JSONArray jsNames = (JSONArray) object.get("name");
                
                String check = (String) jsNames.get(0);
                if (!check.equals("temp")) {
                    JSONArray jsSeiyuu = (JSONArray) object.get("voice actress");
                    String color = (String) object.get("color");
                    String groupName = (String) object.get("group");
                    String[] names = handleStringArray(jsNames);
                    String[] voiceActress = handleStringArray(jsSeiyuu);
                    Idol idol = new Idol(names, voiceActress, color);
                    addToGroup(idol, groupName);
                } else {
                    handleSpecial();
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
    
    /**
     * Handles string arrays in the json object. For now handles the names of
     * the idol and the name of the voice actresses.
     * @param names
     * @return
     */
    private String[] handleStringArray(JSONArray names) {
        String[] result = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            String name = (String) names.get(i);
            result[i] = name;
        }
        return result;
    }
    
    /**
     * Helper method to add the idol to the proper group.
     * @param idol the idol to add.
     * @param group a string representing the group to be added to.
     */
    private void addToGroup(Idol idol, String group) {
        switch (group) {
            case "µ's":
                Muse.addIdol(idol);
                break;
            case "Aqours":
                Aqours.addIdol(idol);
                break;
            default:
                // should never get here.
                break;
        }
    }

    /**
     * Helper method to handle songs.
     */
    private void handleSongs() {
        
    }
    
    /**
     * Handles special cases. These are:
     * Songs with no centers.
     * Sub unit songs.
     */
    private void handleSpecial() {
        
    }
}
