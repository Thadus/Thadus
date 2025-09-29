/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package thadusv1;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static thadusv1.Textarray.textarray;

public class Text {
    
    private static String varName;
    private static String varValue;
    private static HashMap<String, String> variables = new HashMap<>();



    public static void text(String response) {
        response = response.replace("text", "").trim();

        String[] responseArray = response.split("=", 2);
        if (responseArray.length < 2) {
            Main.printToConsole("Error: Invalid syntax. Use text x = value");
            return;
        }

        String varName = responseArray[0].trim();
        String valueStr = responseArray[1].trim();

        // ---- Handle array access pattern: arrayName[index] ----
        Pattern arrayAccess = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)\\[([a-zA-Z_][a-zA-Z0-9_]*|\\d+)]");
        Matcher arrayMatcher = arrayAccess.matcher(valueStr);
        StringBuffer sb = new StringBuffer();

        while (arrayMatcher.find()) {
            String arrayName = arrayMatcher.group(1);
            String indexStr = arrayMatcher.group(2);

            int index;
            if (indexStr.matches("\\d+")) {
                index = Integer.parseInt(indexStr);
            } else {
                // First check numeric variables
                if (Num.variables.containsKey(indexStr)) {
                    index = Num.variables.get(indexStr).intValue();
                } 
                // Then check text variables
                else if (variables.containsKey(indexStr)) {
                    try {
                        index = Integer.parseInt(variables.get(indexStr));
                    } catch (NumberFormatException e) {
                        Main.printToConsole("Error: Text variable '" + indexStr + "' is not a valid index.");
                        return;
                    }
                } else {
                    Main.printToConsole("Error: Undefined variable '" + indexStr + "' used as array index.");
                    return;
                }
            }

            if (!textarray.containsKey(arrayName)) {
                Main.printToConsole("Error: Undefined text array '" + arrayName + "'.");
                return;
            }

            List<String> arr = textarray.get(arrayName);
            if (index < 0 || index >= arr.size()) {
                Main.printToConsole("Error: Index " + index + " out of bounds for array '" + arrayName + "'.");
                return;
            }

            // substitute array element into string
            arrayMatcher.appendReplacement(sb, Matcher.quoteReplacement(arr.get(index)));
        }
        arrayMatcher.appendTail(sb);
        valueStr = sb.toString();

        // ---- If valueStr is another text variable, resolve it ----
        if (variables.containsKey(valueStr)) {
            valueStr = variables.get(valueStr);
        }

        // ---- Store variable ----
        variables.put(varName, valueStr);
        Main.printToConsole("Text variable " + varName + " of value " + valueStr + " created");
    }

   

    
    public Text(String varName, String varValue) {
        this.varName = varName;
        this.varValue = varValue;
    }

    // Get a specific variable by name
    public static String getVariable(String varName) {
        return variables.getOrDefault(varName, null); 
    }

    // Get all text variables
    public static HashMap<String, String> getAllVariables() {
        return variables;  // Returns all text variables stored in the HashMap
    }
    
    public static String getVarName() {
        return varName;  
    }
    
    public static String getVarValue() {
        return varValue;
    }
}
