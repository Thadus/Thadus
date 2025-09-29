/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.HashMap;
import javax.swing.JOptionPane; 

public class Input {
    private static HashMap<String, Double> variables = new HashMap<>();
    private static HashMap<String, String> variables2 = new HashMap<>();
    private static String message2;
    private static String message3;
    
    
    public static void input(String response) {
        response = response.replace("input","").replace("=","").trim();
        
        if (response.contains("num")) {
            response = response.replace("num", "").trim();
            String[] responseArray = response.split("\\s+");
     
         
    
            String varName = responseArray[responseArray.length - 1];
            
            response = response.replace(varName, "");
            response = response.replace("=","");
            response = response.replace("input","");
            response = response.replace("num","");
            Main.printToConsole(response);
            
            
            
            
            
            
            String inputValue = JOptionPane.showInputDialog(response);
            
            if (inputValue != null) {
                try {
                    double varValue = Double.parseDouble(inputValue);
                    variables.put(varName, varValue);
                    Num.storeVariable(varName, varValue);  
                    
                    Main.printToConsole("Numeric variable " + varName + " of value " + varValue + " created");
                } catch (NumberFormatException e) {
                    Main.printToConsole("Error: Invalid number format.");
                }
            }
        }
        
        if (response.contains("text")) {
            response = response.replace("text", "").trim();
            String[] responseArray = response.split("\\s+");
            
            int i = 0;
            while (i < responseArray.length - 1) {
                String message = responseArray[i];
                Main.printToConsole(message + " ");
                if (i != 0) {
                    message2 = message2 + " " + message + " ";
                } else {
                    message2 = message + " ";
                }
                i++;
            }
            Main.printToConsole("");  
            
            String varName = responseArray[responseArray.length - 1];
            
            response = response.replace(varName, "");
            response = response.replace("=","");
            
            String varValue = JOptionPane.showInputDialog(message2);
            
            
            
            if (varValue != null) {
                variables2.put(varName, varValue);
                Main.printToConsole("Text variable " + varName + " of value \"" + varValue + "\" created");
            }
        }
        
        
    }
    
    public static Double getVariable(String varName) {
        return variables.getOrDefault(varName, null);
    }
    
    public static String getVariable2(String varName) {
        return variables2.getOrDefault(varName, null);
    }
}
