/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Print {

    public static void print(String response) {
    response = response.replace("print", "").trim();

    String expressionStr = response; // no brackets for text print

    Map<String, String> textVars = Text.getAllVariables();      // text variables
    Map<String, List<String>> textArrays = Textarray.textarray; // text arrays

    // ---- Array access with index support (int or variable) ----
    Pattern arrayAccess = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)\\[([a-zA-Z_][a-zA-Z0-9_]*|\\d+)]");
    Matcher arrayMatcher = arrayAccess.matcher(expressionStr);
    StringBuffer sb = new StringBuffer();

    while (arrayMatcher.find()) {
        String arrayName = arrayMatcher.group(1);
        String indexStr  = arrayMatcher.group(2);

        int index;
        if (indexStr.matches("\\d+")) {
            index = Integer.parseInt(indexStr);
        } else {
            if (!textVars.containsKey(indexStr)) {
                Main.printToConsole("Error: Undefined variable '" + indexStr + "' used as index.");
                return;
            }
            try {
                index = Integer.parseInt(textVars.get(indexStr));
            } catch (NumberFormatException e) {
                Main.printToConsole("Error: Text variable '" + indexStr + "' is not a valid numeric index.");
                return;
            }
        }

        if (!textArrays.containsKey(arrayName)) {
            Main.printToConsole("Error: Undefined text array '" + arrayName + "'.");
            return;
        }

        List<String> arr = textArrays.get(arrayName);
        if (index < 0 || index >= arr.size()) {
            Main.printToConsole("Error: Index " + index + " out of bounds for array '" + arrayName + "'.");
            return;
        }

        arrayMatcher.appendReplacement(sb, arr.get(index));
    }
    arrayMatcher.appendTail(sb);
    expressionStr = sb.toString();

    // ---- Replace plain variables ----
    Pattern varPattern = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
    Matcher varMatcher = varPattern.matcher(expressionStr);
    StringBuffer sbVars = new StringBuffer();

    while (varMatcher.find()) {
        String varName = varMatcher.group();
        if (textVars.containsKey(varName)) {
            varMatcher.appendReplacement(sbVars, textVars.get(varName));
        } else {
            // keep literal text if not a variable
            varMatcher.appendReplacement(sbVars, varName);
        }
    }
    varMatcher.appendTail(sbVars);
    expressionStr = sbVars.toString();

    // ---- Print result ----
    Main.printToConsole(expressionStr);
}



        
       
}
