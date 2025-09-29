/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.List;
import static thadusv1.If.textValue2;
import static thadusv1.If.textValue3;

/**
 *
 * @author netha
 */
public class Processes5 extends If {
    private static boolean e = false;
        
    public static void processes5(List responses2) {
        int i;
           
           
            
            
            while (textValue2 != null && textValue2.equals(textValue3)) { 
            i = 1;
            while (i < responses2.size()) {
            String whilecommand = (String) responses2.get(i);
            if (whilecommand.contains("print")&& !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if"))  { 
        Print.print(whilecommand);
        
        
        
        }
        
        
        if (whilecommand.contains("print")&& whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if"))  { 
        Printcalc.printcalc(whilecommand);
        
        
        }
        
        if (whilecommand.contains("num") && whilecommand.contains("=") && !whilecommand.contains("input")) {
            Num.num(whilecommand);
        
    }
        
        if (whilecommand.contains("text") && whilecommand.contains("=") && !whilecommand.contains("input")) {
            Text.text(whilecommand);
        }
        
        if (whilecommand.contains("input") && whilecommand.contains("=")) {
            Input.input(whilecommand);
            
        }
            
            
            
            
            
            
            
        i++;
        }
        
       
                
                
            }
           
        
        
    } 
        
    
}
