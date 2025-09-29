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
public class Processes8 {
    public static void processes8(List whilecommands2) {
        int i = 0;
        ArrayList whilecommands = new ArrayList<>();
        boolean ifactive = false;
        boolean whileactive = false;  
        
        while (i < whilecommands2.size()) {
            
            
            
            String whilecommand = (String) whilecommands2.get(i);
            if (whilecommand.contains("print")&& !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") &&  whileactive == false &&  ifactive == false)  { 
        Print.print(whilecommand);
        
        
        
        }
        
        
        if (whilecommand.contains("print")&& whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") &&  whileactive == false &&  ifactive == false)  { 
        Printcalc.printcalc(whilecommand);
        
        
        }
        
        if (whilecommand.contains("num") && whilecommand.contains("=") && !whilecommand.contains("input") &&  whileactive == false &&  ifactive == false) {
            Num.num(whilecommand);
        
    }
        
        if (whilecommand.contains("text") && whilecommand.contains("=") && !whilecommand.contains("input") &&  whileactive == false &&  ifactive == false  ) {
            Text.text(whilecommand);
        }
        
        if (whilecommand.contains("input") && whilecommand.contains("=")) {
            Input.input(whilecommand);
            
        }
        else if (whilecommand.contains("if") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("while") &&  whileactive == false ) {
                          ifactive = true;  
                          whilecommands.add(whilecommand);
                          
             } else if (whilecommand.contains("end if") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("while") &&  whileactive == false) {
                          ifactive = false;
                          If.If(whilecommands);
                          whilecommands.clear();
             } else if (ifactive &&  whileactive == false) {
                      
                      whilecommands.add(whilecommand);
                      
            } else if (whilecommand.contains("while") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("loop")) {
                          whileactive = true;  
                          whilecommands.add(whilecommand);      
                          
                          
            } else if (whilecommand.contains("end while") && !whilecommand.contains(")") && !whilecommand.contains("(")) {
                          whileactive = false; 
                          
                          While.While(whilecommands);
                         
                          whilecommands.clear();
             } else if (whileactive) {
                      
                      whilecommands.add(whilecommand);
                      
        
                } 
            
        i++;
        
        
        
        }
      
    
    }
    
}
