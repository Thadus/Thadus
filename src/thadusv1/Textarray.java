/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author netha
 */
public class Textarray {

    public static final HashMap<String, List<String>> textarray = new HashMap<>();

    // ---- Create a new text array ----
    public static void textarray(String response) {
        response = response.replace("text", "").replace("=", "").trim();

        String[] responseArray = response.split("[,\\s\\[\\]]+");

        if (responseArray.length < 2) {
            Main.printToConsole("Error: Invalid syntax. Use text name = [a,b,c]");
            return;
        }

        String varName = responseArray[1];
        ArrayList<String> elements = new ArrayList<>();

        for (int i = 2; i < responseArray.length; i++) {
            if (!responseArray[i].isEmpty()) {
                elements.add(responseArray[i]);
            }
        }

        textarray.put(varName, new ArrayList<>(elements));
        
        Main.printToConsole("Text array " + varName + " of length " + elements.size() + " created");
    }

   
    public static void textarraychange(String response) {
        response = response.replace("[text]","").replace("=", "").trim();
        String[] responseArray = response.split("[\\s\\[\\]]+");

        if (responseArray.length < 3) {
            Main.printToConsole("Error: Invalid syntax. Use array[index] = value");
            return;
        }

        String varName = responseArray[0];   // array name
        String indexStr = responseArray[1];  // index (number or variable)
        String valueStr = responseArray[2];  // value (string or variable)

        Map<String, String> variables = Text.getAllVariables();

        // ---- resolve index ----
        int index;
        if (indexStr.matches("\\d+")) {
            index = Integer.parseInt(indexStr);
        } else if (variables.containsKey(indexStr)) {
            try {
                index = Integer.parseInt(variables.get(indexStr));
            } catch (NumberFormatException e) {
                Main.printToConsole("Error: Index variable '" + indexStr + "' is not a valid number.");
                return;
            }
        } else {
            Main.printToConsole("Error: Invalid index '" + indexStr + "'.");
            return;
        }

        // ---- resolve value ----
        String value;
        if (variables.containsKey(valueStr)) {
            value = variables.get(valueStr);
        } else {
            value = valueStr; // treat as raw string
        }

        // ---- update array ----
        if (!textarray.containsKey(varName)) {
            Main.printToConsole("Error: Undefined array '" + varName + "'.");
            return;
        }

        List<String> elements = new ArrayList<>(textarray.get(varName));

        if (index < 0 || index >= elements.size()) {
            Main.printToConsole("Error: Index " + index + " out of bounds for array '" + varName + "'.");
            return;
        }

        elements.set(index, value);
        textarray.put(varName, new ArrayList<>(elements));

        Main.printToConsole("Text array " + varName + " of length " + elements.size() + " revised");
    }
}



