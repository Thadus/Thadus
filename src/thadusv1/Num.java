/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.Arrays;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static thadusv1.Numarray.numarray;

public class Num {
    public static double varValue;
 
    public static final HashMap<String, Double> variables = new HashMap<>();

   public static void num(String response) {
    response = response.replace("num", "").trim();

    String[] responseArray = response.split("=", 2);
    if (responseArray.length < 2) {
        Main.printToConsole("Error: Invalid syntax. Use num x = expression");
        return;
    }

    String varName = responseArray[0].trim();
    String expressionStr = responseArray[1].trim();


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

        if (!variables.containsKey(indexStr)) {
            Main.printToConsole("Error: Undefined variable '" + indexStr + "' used as array index.");
            return;
        }
        index = variables.get(indexStr).intValue(); // convert double to int
    }

    if (!numarray.containsKey(arrayName)) {
        Main.printToConsole("Error: Undefined array '" + arrayName + "'.");
        return;
    }
    List<Double> arr = numarray.get(arrayName);
    if (index < 0 || index >= arr.size()) {
        Main.printToConsole("Error: Index " + index + " out of bounds for array '" + arrayName + "'.");
        return;
    }

    arrayMatcher.appendReplacement(sb, String.valueOf(arr.get(index)));
}
arrayMatcher.appendTail(sb);
expressionStr = sb.toString();


    
    Pattern varPattern = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
    Matcher varMatcher = varPattern.matcher(expressionStr);

    while (varMatcher.find()) {
        String usedVar = varMatcher.group();
        if (!variables.containsKey(usedVar) 
            && !isBuiltInFunction(usedVar)) { // <-- avoid rejecting math functions
            Main.printToConsole("Error: Undefined variable '" + usedVar + "'.");
            return;
        }
    }

  
    try {
        Expression expression = new ExpressionBuilder(expressionStr)
                .variables(variables.keySet())
                .build()
                .setVariables(variables);

        double result = expression.evaluate();
        variables.put(varName, result); // <-- store the result properly
        Main.printToConsole("Numeric variable " + varName + " of value " + result + " created");

    } catch (Exception e) {
        Main.printToConsole("Error: Invalid expression.");
    }
}


private static boolean isBuiltInFunction(String token) {
    return Arrays.asList("sin","cos","tan","sqrt","log","abs","exp").contains(token);
}



    public static void storeVariable(String varName, Double varValue) {
        variables.put(varName, varValue);
    }

    public static Double getVariable(String varName) {
        return variables.get(varName);
    }
    

    public static HashMap<String, Double> getAllVariables() {
        return variables;
    }
}
