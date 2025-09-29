/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;



import java.util.*;
import java.util.regex.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import static thadusv1.Numarray.numarray;

public class Printcalc {

    public static void printcalc(String response) {
    response = response.replace("print", "").trim();

    if (!response.startsWith("(") || !response.endsWith(")")) {
        Main.printToConsole("Error: Invalid syntax. Use print(expression)");
        return;
    }

    String expressionStr = response.substring(1, response.length() - 1).trim(); 

    Map<String, Double> variables = Num.getAllVariables(); 

   
    Pattern arrayAccess = Pattern.compile("([a-zA-Z_][a-zA-Z0-9_]*)\\[([a-zA-Z_][a-zA-Z0-9_]*|\\d+)]");
    Matcher arrayMatcher = arrayAccess.matcher(expressionStr);
    StringBuffer sb = new StringBuffer();

    while (arrayMatcher.find()) {
        String arrayName = arrayMatcher.group(1);
        String indexStr = arrayMatcher.group(2);

        int index;
        if (indexStr.matches("\\d+")) {
            
            index = Integer.parseInt(indexStr);
        } else {
           
            if (!variables.containsKey(indexStr)) {
                Main.printToConsole("Error: Undefined variable '" + indexStr + "' used as index.");
                return;
            }
            index = variables.get(indexStr).intValue();
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
        String varName = varMatcher.group();
        if (!variables.containsKey(varName)) {
            Main.printToConsole("Error: Undefined variable '" + varName + "'.");
            return;
        }
    }

    
    try {
        Expression expression = new ExpressionBuilder(expressionStr)
                .variables(variables.keySet())
                .build()
                .setVariables(variables);  

        double result = expression.evaluate();
        Main.printToConsole("" + result);
    } catch (Exception e) {
        Main.printToConsole("Error: Invalid expression.");
    }
}


}
