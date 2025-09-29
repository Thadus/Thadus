/*
package thadusv1;
import java.util.List;
import thadusv1.Input;
import thadusv1.Main;
import static thadusv1.Main.responses;
import thadusv1.Num;
import static thadusv1.Num.varValue;
import thadusv1.Print;
import thadusv1.Printcalc;
import thadusv1.Processes;
import thadusv1.Text;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author netha
 */

/*
public class Loopwhile {
    public static String condition;

    /**
     *
     */
    /**
 * Stores the parts of a parsed condition (e.g., "x", ">", "5").
 */
    
    /*
    public static String[] conditionarray;
    public static Double conditionValue;
    public static String textValue;
    public static String varName;
    
    public static void loopwhile(List responses) {
        String response = (String) responses.get(0);
        response = response.replace("loop while", "").trim();
        condition = response.replaceFirst("^.*?\\((.*?)\\).*", "$1").trim();
        
        conditionarray = condition.split("(?=[<>=])|(?<=[<>=])");
        conditionarray[2] = conditionarray[2].trim();
        
        
        
        
        
        
        if (!conditionarray[0].matches("-?\\d+(\\.\\d+)?")) {
            varName = conditionarray[0].trim();
            if (Num.getAllVariables().containsKey(varName)) {
                varValue = Num.getAllVariables().get(varName);
                
                
             if (conditionarray[1].trim().equals("=")) {
                    conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue == conditionValue) {
                        Processes4.processes4(responses);
                    }
                    
             }


        

                if (conditionarray[1].trim().equals(">")) {
                    conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue > conditionValue) {
                        Processes2.processes2(responses);
                    
                        
                } 
                    
}
                if (conditionarray[1].trim().equals("<")) {
                    conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue < conditionValue) {
                        Processes3.processes3(responses);
        
                }
            }


                
        }
    }
    
}
}

*/
