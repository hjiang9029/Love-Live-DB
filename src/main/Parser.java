package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The parser for the program. This class will read
 * the json file and assign data based on the file.
 * 
 * @version 2017-01-06
 * @author Henry Jiang
 *
 */
public class Parser {
    
    private static final String filePath = "C:\\Users\\Henry\\eclipse-workspace\\Love Live Database\\data.json";
    
    public static MainGroup Muse = new MainGroup("µ's");
    public static MainGroup Aqours = new MainGroup("Aqours");
    
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
                // check for the special case.
                String check = (String) jsNames.get(0);
                if (!check.equals("temp")) {
                    handleNormal(object);
                } else {
                    handleSpecial(object);
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
     * Helper method to handle a normal case. Should be used for every
     * JSON Object except the last one.
     * @param object
     */
    private void handleNormal(JSONObject object) {
        JSONArray jsSeiyuu = (JSONArray) object.get("voice actress");
        String color = (String) object.get("color");
        String groupName = (String) object.get("group");
        String subUnit = (String) object.get("subunit");
        JSONArray jsNames = (JSONArray) object.get("name");
        String[] names = handleStringArray(jsNames);
        String[] voiceActress = handleStringArray(jsSeiyuu);
        Idol idol = new Idol(names, voiceActress, color);
        addToGroup(idol, groupName, subUnit);
        handleSongs(object, idol);
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
    private void addToGroup(Idol idol, String group, String subUnit) {
        switch (group) {
            case "µ's":
                Muse.addIdol(idol);
                Muse.addSubUnit(subUnit);
                break;
            case "Aqours":
                Aqours.addIdol(idol);
                Aqours.addSubUnit(subUnit);
                break;
            default:
                // should never get here.
                break;
        }
    }

    /**
     * Helper method to add songs. Uses the current
     * JSON Object and parses song names from it.
     * @param object a JSON object (the current object being worked on.)
     * @param idol the idol to add the songs to. (current idol).
     */
    private void handleSongs(JSONObject object, Idol idol) {
        JSONArray centersEN = (JSONArray) object.get("centersEN");
        JSONArray centersJP = (JSONArray) object.get("centersJP");
        JSONArray miscEN = (JSONArray) object.get("miscEN");
        JSONArray miscJP = (JSONArray) object.get("miscJP");
        
        // Create & add centers to this idol.
        handleCenters(centersEN, centersJP, idol);
        
        // Create & add misc songs to this idol.
        handleMisc(miscEN, miscJP, idol);
    }
    
    /**
     * Helper method to add songs.
     * Adds songs that are centers for an idol.
     * @param songsEN a jsonArray containing the center names in english.
     * @param songsJP a jsonArray containing the center names in japanese.
     * @param idol the idol to add songs to.
     */
    private void handleCenters(JSONArray songsEN, JSONArray songsJP, Idol idol) {
        for (int i = 0; i < songsEN.size(); i++) {
            String nameEN = (String) songsEN.get(i);
            String nameJP = (String) songsJP.get(i);
            idol.addCenter(nameEN, nameJP);
        }
    }
    
    /**
     * Helper method to add songs.
     * Adds songs that are duos/trios/solos for an idol.
     * @param songsEN a jsonArray containing the song names in English.
     * @param songsJP a jsonArray containing the song names in Japanese.
     * @param idol the idol to add songs to.
     */
    private void handleMisc(JSONArray songsEN, JSONArray songsJP, Idol idol) {
        for (int i = 0; i < songsEN.size(); i++) {
            String nameEN = (String) songsEN.get(i);
            String nameJP = (String) songsJP.get(i);
            idol.addMisc(nameEN, nameJP);
        }
    }
    
    /**
     * Handles special cases. These are:
     * Songs with no centers.
     * Sub unit songs.
     */
    private void handleSpecial(JSONObject object) {
        final int numberOfGroups = 6;
        ArrayList<String> toDo = new ArrayList<String>();
        for (Iterator iter = object.keySet().iterator(); iter.hasNext();) {
            String key = (String) iter.next();
            toDo.add(key);
        }
        for (int i = 2; i < numberOfGroups; i += 2) {
            String taskJP = toDo.get(i);
            String group = taskJP.substring(0, taskJP.length() - 2);
            String taskEN = group + "EN";
            JSONArray enNames = (JSONArray) object.get(taskEN);
            JSONArray jpNames = (JSONArray) object.get(taskJP);
            if (taskEN.substring(0, taskEN.length() - 2).equals("centers")) {
                handleAqours(enNames, jpNames);
            } else {
                handleSpecialSongs(enNames, jpNames, group);
            }
        }
    }
    
    /**
     * helper method to handle sub unit songs.
     * @param enNames the name as a string in English.
     * @param jpNames the name as a string in Japanese.
     * @param groupName the sub unit name as a string.
     */
    private void handleSpecialSongs(JSONArray enNames, JSONArray jpNames, String groupName) {
        SubUnit check = new SubUnit(groupName);
        MainGroup toUse = checkGroup(check);
        for (int i = 0; i < enNames.size(); i++) {
            String nameEN = (String) enNames.get(i);
            String nameJP = (String) jpNames.get(i);
            toUse.getSubUnit(check).addSong(nameEN, nameJP);
        }
    }
    
    /**
     * Helper method to check which group.
     * Checks which group contains the sub unit and
     * returns the group that does.
     * 
     * @param groupName the group name to check for.
     * @return The maingroup to use.
     */
    private MainGroup checkGroup(SubUnit toCheck) {
        if (Muse.getSubUnits().contains(toCheck)) {
            return Muse;
        } else if (Aqours.getSubUnits().contains(toCheck)) {
            return Aqours;
        }
        return null;
    }
    
    private void handleAqours(JSONArray enNames, JSONArray jpNames) {
        
    }
}
