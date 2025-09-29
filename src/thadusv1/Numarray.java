/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

/**
 *
 * @author netha
 */
import java.util.ArrayList;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Numarray {
   
 
    public static final HashMap<String, List<Double>> numarray = new HashMap<>();

    public static void numarray(String response) {
        response = response.replace("num", "").replace("=", "").trim();
        
        
        String[] responseArray = response.split("[,\\s\\[\\]]+");

        

        String varName = responseArray[1];
        ArrayList elements = new ArrayList<Double>();
        
        int i = 2;
        
        while (i < responseArray.length) {
            elements.add(responseArray[i]);
            i++;
        }
                
                
        numarray.put(varName, new ArrayList<>(elements));
        Main.printToConsole("Numeric array " + varName + " of length " + elements.size() + " created");
        
    
}
    
    public static void numarraychange(String response) {
    response = response.replace("[num]","").replace("=", "").trim();
    
    String[] responseArray = response.split("[\\s\\[\\]]+");

    if (responseArray.length < 3) {
        
        Main.printToConsole("Error: Invalid syntax. Use array[index] = value");
        return;
    }

    String varName = responseArray[0];   // array name
    String indexStr = responseArray[1];  // index (number or variable)
    String valueStr = responseArray[2];  // value (number or variable)

    Map<String, Double> variables = Num.getAllVariables();

    // ---- resolve index ----
    int index;
    if (indexStr.matches("\\d+")) {
        index = Integer.parseInt(indexStr);
    } else if (variables.containsKey(indexStr)) {
        index = variables.get(indexStr).intValue();
    } else {
        Main.printToConsole("Error: Invalid index '" + indexStr + "'.");
        return;
    }

    // ---- resolve value ----
    double value;
    if (valueStr.matches("-?\\d+(\\.\\d+)?")) {
        value = Double.parseDouble(valueStr);
    } else if (variables.containsKey(valueStr)) {
        value = variables.get(valueStr);
    } else {
        Main.printToConsole("Error: Invalid value '" + valueStr + "'.");
        return;
    }

    // ---- update array ----
    if (!numarray.containsKey(varName)) {
        Main.printToConsole("Error: Undefined array '" + varName + "'.");
        return;
    }

    List<Double> elements = new ArrayList<>(numarray.get(varName));

    if (index < 0 || index >= elements.size()) {
        Main.printToConsole("Error: Index " + index + " out of bounds for array '" + varName + "'.");
        return;
    }

    elements.set(index, value);
    numarray.put(varName, new ArrayList<>(elements));

    Main.printToConsole("Numeric array " + varName + " of length " + elements.size() + " revised");
}

    
    
}


