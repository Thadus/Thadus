/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.List;

import static thadusv1.If.numValue;
import static thadusv1.If.numValue2;
import static thadusv1.If.numValue3;
import static thadusv1.If.textValue;
import static thadusv1.If.textValue2;
import static thadusv1.If.textValue3;


/**
 *
 * @author netha
 */


public class While {
    
    public static String [] conditionarray3;
    public static String operator;
    public static double numValue1;
   public static void While(List responses2) {
        String response = (String) responses2.get(0);
        response = response.replace("while", "").trim();

        String condition = response.replaceFirst("^.*?\\((.*?)\\).*", "$1").trim();
        
        
        conditionarray3 = condition.split("(?=[<>=])|(?<=[<>=])");
        
        
        
        if (Input.getVariable2(conditionarray3[0].trim()) != null && conditionarray3[1].trim().equals("=")) { 
            textValue = Input.getVariable2(conditionarray3[0].trim());
            
                Processes4.processes4(responses2);
                //for text variables created by input
            
            return;
        }
        
        if (Input.getVariable2(conditionarray3[0].trim()) != null && Input.getVariable2(conditionarray3[2].trim()) != null && conditionarray3[1].trim().equals("=")) { 
            textValue2 = Input.getVariable2(conditionarray3[0].trim());
            textValue3 = Input.getVariable2(conditionarray3[2].trim());
            
                Processes5.processes5(responses2);
                //for two text variables created by input -> two text variable comparison
            
            return;
        }
        
       
        
        if (Text.getAllVariables().containsKey(conditionarray3[0].trim()) && conditionarray3[1].trim().equals("=") && !Text.getAllVariables().containsKey(conditionarray3[2].trim())) {
            textValue = Text.getVariable(conditionarray3[0].trim());
            if (textValue != null && textValue.equals(conditionarray3[2].trim())) {
                Processes4.processes4(responses2);
                // for text variables created normally
            } 
            return;
        }
        
        if (Text.getAllVariables().containsKey(conditionarray3[0].trim()) && conditionarray3[1].trim().equals("=") && Text.getAllVariables().containsKey(conditionarray3[2].trim())) {
            textValue2 = Text.getVariable(conditionarray3[0].trim());
            textValue3 = Text.getVariable(conditionarray3[2].trim());
            if (textValue2 != null && textValue2.equals(textValue3)) {
                Processes5.processes5(responses2);
                // for text variables created normally - two text variable comparison
            } 
            return;
        }
        
        if (Input.getVariable2(conditionarray3[0].trim()) != null && conditionarray3[1].trim().equals("=") && Text.getAllVariables().containsKey(conditionarray3[2].trim())) {
            textValue2 = Input.getVariable2(conditionarray3[0].trim());
            textValue3 = Text.getVariable(conditionarray3[2].trim());
            if (textValue2 != null && textValue2.equals(textValue3)) {
                Processes5.processes5(responses2);
                // for input text vs regular text 
            } 
            return;
        }
        
        if (Input.getVariable2(conditionarray3[2].trim()) != null && conditionarray3[1].trim().equals("=") && Text.getAllVariables().containsKey(conditionarray3[0].trim())) {
            textValue2 = Text.getVariable(conditionarray3[0].trim());
            textValue3 = Input.getVariable2(conditionarray3[2].trim());
            if (textValue2 != null && textValue2.equals(textValue3)) {
                Processes5.processes5(responses2);
                // for regular text vs input text
            } 
            return;
        }
        
        
        
        
        
        
        
        
        if (Input.getVariable(conditionarray3[0].trim()) != null && Input.getVariable(conditionarray3[2].trim()) == null && !Num.getAllVariables().containsKey(conditionarray3[2].trim())) { 
            numValue = Input.getVariable(conditionarray3[0].trim());
            numValue1 = Double.valueOf(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
            
                Processes6.processes6(responses2);
                
                //for one numeric variable created by input
            
            return;
        }
        
        if (Num.getAllVariables().containsKey(conditionarray3[0].trim()) && Num.getAllVariables().containsKey(conditionarray3[2].trim())) {
            numValue2 = Num.getVariable(conditionarray3[0].trim());
            numValue3 = Num.getVariable(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
            
          
            Processes7.processes7(responses2);
            
                // for numeric variables created normally -> two numeric comparison
            
            return;
        }
        
        
        
        
        if (Input.getVariable(conditionarray3[0].trim()) == null && Input.getVariable(conditionarray3[2].trim()) == null && !Num.getAllVariables().containsKey(conditionarray3[0].trim()) && !Num.getAllVariables().containsKey(conditionarray3[2].trim()) ) { 
            numValue = Double.valueOf(conditionarray3[0].trim());
            numValue1 = Double.valueOf(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
            
                Main.printToConsole("Infinite Loop Abandoned");
                
                //for two regular number comparisons
            
            return;
        }
        
        if (Num.getAllVariables().containsKey(conditionarray3[0].trim()) && !Num.getAllVariables().containsKey(conditionarray3[2].trim()) && Input.getVariable(conditionarray3[2].trim()) == null) { 
            numValue = Num.getVariable(conditionarray3[0].trim());
            numValue1 = Double.valueOf(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
           
                Processes6.processes6(responses2);
                
                //for one numeric variable created normally
            
            return;
        }
        
        
        
        
        
        
        if (Input.getVariable(conditionarray3[0].trim()) != null && Input.getVariable(conditionarray3[2].trim()) != null) { 
            numValue2 = Input.getVariable(conditionarray3[0].trim());
            numValue3 = Input.getVariable(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
            
                Processes7.processes7(responses2);
                
                //for numeric variables created by input -> two numeric variable comparison, if a = b
            
            return;
        }
        
        if (Input.getVariable(conditionarray3[0].trim()) != null && Num.getAllVariables().containsKey(conditionarray3[2].trim())) { 
            numValue2 = Input.getVariable(conditionarray3[0].trim());
            numValue3 = Num.getVariable(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
            
                Processes7.processes7(responses2);
                
                //for input numeric vs regular numeric 
            
            return;
        }
        if (Input.getVariable(conditionarray3[2].trim()) != null && Num.getAllVariables().containsKey(conditionarray3[0].trim())) { 
            numValue2 = Num.getVariable(conditionarray3[0].trim());
            numValue3 = Input.getVariable(conditionarray3[2].trim());
            operator = conditionarray3[1].trim();
            
                Processes7.processes7(responses2);
                
                //for regular numeric vs input numeric
            
            return;
        }
        
        

        
        
        

        
        
    
}
    
}


