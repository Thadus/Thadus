/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package thadusv1;

import java.util.List;



public class If extends Main{
    public static String textValue; 
    public static String textValue2;
    public static double numValue;
    public static double numValue2;
    public static double numValue3;
    public static String textValue3;
    public static String operator2;
    
    public static String [] conditionarray2;

    public static void If(List responses2) {
        String response = (String) responses2.get(0);
        response = response.replace("if", "").trim();

        String condition = response.replaceFirst("^.*?\\((.*?)\\).*", "$1").trim();
        
        
        conditionarray2 = condition.split("(?=[<>=])|(?<=[<>=])");
        
        
        
        if (Input.getVariable2(conditionarray2[0].trim()) != null && conditionarray2[1].trim().equals("=")) { 
            textValue = Input.getVariable2(conditionarray2[0].trim());
            
                Processes.processes(responses2);
                //for text variables created by input
            
            return;
        }
        
        if (Input.getVariable2(conditionarray2[0].trim()) != null && Input.getVariable2(conditionarray2[2].trim()) != null && conditionarray2[1].trim().equals("=")) { 
            textValue2 = Input.getVariable2(conditionarray2[0].trim());
            textValue3 = Input.getVariable2(conditionarray2[2].trim());
            
                Processes01.processes01(responses2);
                //for two text variables created by input -> two text variable comparison
            
            return;
        }
        
       
        
        if (Text.getAllVariables().containsKey(conditionarray2[0].trim()) && conditionarray2[1].trim().equals("=") && !Text.getAllVariables().containsKey(conditionarray2[2].trim())) {
            textValue = Text.getVariable(conditionarray2[0].trim());
            if (textValue != null && textValue.equals(conditionarray2[2].trim())) {
                Processes.processes(responses2);
                // for text variables created normally
            } 
            return;
        }
        
        if (Text.getAllVariables().containsKey(conditionarray2[0].trim()) && conditionarray2[1].trim().equals("=") && Text.getAllVariables().containsKey(conditionarray2[2].trim())) {
            textValue2 = Text.getVariable(conditionarray2[0].trim());
            textValue3 = Text.getVariable(conditionarray2[2].trim());
            if (textValue2 != null && textValue2.equals(textValue3)) {
                Processes01.processes01(responses2);
                // for text variables created normally - two text variable comparison
            } 
            return;
        }
        
        if (Input.getVariable2(conditionarray2[0].trim()) != null && conditionarray2[1].trim().equals("=") && Text.getAllVariables().containsKey(conditionarray2[2].trim())) {
            textValue2 = Input.getVariable2(conditionarray2[0].trim());
            textValue3 = Text.getVariable(conditionarray2[2].trim());
            if (textValue2 != null && textValue2.equals(textValue3)) {
                Processes01.processes01(responses2);
                // for input text variable vs regular text variable 
            } 
            return;
        }
        
        if (Input.getVariable2(conditionarray2[2].trim()) != null && conditionarray2[1].trim().equals("=") && Text.getAllVariables().containsKey(conditionarray2[0].trim())) {
            textValue2 = Input.getVariable2(conditionarray2[2].trim());
            textValue3 = Text.getVariable(conditionarray2[0].trim());
            if (textValue2 != null && textValue2.equals(textValue3)) {
                Processes01.processes01(responses2);
                // for regular text variable vs input text variable 
            } 
            return;
        }
        
        
        
        
        
        
        
        
        if (Input.getVariable(conditionarray2[0].trim()) != null && Input.getVariable(conditionarray2[2].trim()) == null && !Num.getAllVariables().containsKey(conditionarray2[2].trim())) { 
            numValue = Input.getVariable(conditionarray2[0].trim());
            operator2 = conditionarray2[1].trim();
            
                Processes2.processes2(responses2);
                //for one numeric variable created by input
            
            return;
        }
        
        if (Num.getAllVariables().containsKey(conditionarray2[0].trim()) && Num.getAllVariables().containsKey(conditionarray2[2].trim())) {
            numValue2 = Num.getVariable(conditionarray2[0].trim());
            numValue3 = Num.getVariable(conditionarray2[2].trim());
            operator2 = conditionarray2[1].trim();
            
            
            Processes3.processes3(responses2);
                // for numeric variables created normally -> two numeric comparison
            
            return;
        }
        
        if (Num.getAllVariables().containsKey(conditionarray2[0].trim()) && !Num.getAllVariables().containsKey(conditionarray2[2].trim()) && Input.getVariable(conditionarray2[2].trim()) == null) { 
            numValue = Num.getVariable(conditionarray2[0].trim());
            operator2 = conditionarray2[1].trim();
            
                Processes2.processes2(responses2);
                //for one numeric variable created normally
            
            return;
        }
        
        if (Input.getVariable(conditionarray2[0].trim()) == null && Input.getVariable(conditionarray2[2].trim()) == null && !Num.getAllVariables().containsKey(conditionarray2[0].trim()) && !Num.getAllVariables().containsKey(conditionarray2[2].trim()) ) { 
            numValue = Double.valueOf(conditionarray2[0].trim());
            operator2 = conditionarray2[1].trim();
            
            
            
                Processes2.processes2(responses2);
                
                //for two regular number comparisons
            
            return;
        }
        
        
        
        
        
        
        
        
        if (Input.getVariable(conditionarray2[0].trim()) != null && Input.getVariable(conditionarray2[2].trim()) != null) { 
            numValue2 = Input.getVariable(conditionarray2[0].trim());
            numValue3 = Input.getVariable(conditionarray2[2].trim());
            operator2 = conditionarray2[1].trim();
            
                Processes3.processes3(responses2);
                //for numeric variables created by input -> two numeric variable comparison, if a = b
            
            return;
        }
        
         if (Input.getVariable(conditionarray2[0].trim()) != null && Num.getAllVariables().containsKey(conditionarray2[2].trim())) { 
            numValue2 = Input.getVariable(conditionarray2[0].trim());
            numValue3 = Num.getVariable(conditionarray2[2].trim());
            operator2 = conditionarray2[1].trim();
            
                Processes3.processes3(responses2);
                //for input numeric variable vs regular numeric variable
            
            return;
        }
         
         if (Input.getVariable(conditionarray2[2].trim()) != null && Num.getAllVariables().containsKey(conditionarray2[0].trim())) { 
            numValue2 = Num.getVariable(conditionarray2[0].trim());
            numValue3 = Input.getVariable(conditionarray2[2].trim());
            operator2 = conditionarray2[1].trim();
            
                Processes3.processes3(responses2);
                //for regular numeric vs input numeric variables 
            
            return;
        }
        

        
        
        

        
        
    
}
    
}

