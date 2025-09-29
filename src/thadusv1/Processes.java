/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author netha
 */


public class Processes extends If {
        private static boolean e = false;
        private static ArrayList alternative = new ArrayList<String>();
    public static void processes(List responses2) {
        int i = 1;
        
            e = false;
            
            while (i < responses2.size()) {
                
                if (responses2.get(i).equals("else")) {
                    e = true;
                    responses2.remove(i);
                }
                
                if(e) {
                    alternative.add(responses2.get(i));
                   
                    responses2.remove(i);
                }
                i++;
            }
           
           
            
            
            if (textValue != null && textValue.equals(conditionarray2[2].trim())) { 
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
        } else {
              i = 0;
              while (i < alternative.size()) {
            String command2 = (String) alternative.get(i);
            
            
            if (command2.contains("print")&& !command2.contains(")") && !command2.contains("(") && !command2.contains("loop") && !command2.contains("if"))  { 
        Print.print(command2);
        }
            
            if (command2.contains("print")&& command2.contains(")") && command2.contains("(") && !command2.contains("loop") && !command2.contains("if"))  { 
        Printcalc.printcalc(command2);
        
        
        }
        
        if (command2.contains("num") && command2.contains("=") && !command2.contains("input")) {
            Num.num(command2);
        
    }
        
        if (command2.contains("text") && command2.contains("=") && !command2.contains("input")) {
            Text.text(command2);
        }
        
        if (command2.contains("input") && command2.contains("=")) {
            Input.input(command2);
        
            
        } 
        
        
        
            
            
            
            
            
            
            
        i++;
        }  
                
       
                
                
            }
           
        
        
    } 
        
    
}
    

    

