/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.List;
import static thadusv1.While.conditionarray3;
import static thadusv1.If.numValue;
import static thadusv1.While.numValue1;
import static thadusv1.While.operator;


/**
 *
 * @author netha
 */

public class Processes6 extends If {
    
    public static void processes6(List responses2) {
        int i;
        final String vname  = conditionarray3[0].trim();
        final double num2 =  Double.valueOf(conditionarray3[2].trim());    
            
            while (operator.equals("=") && numValue == numValue1 || operator.equals(">") && numValue > numValue1 || operator.equals("<") && numValue < numValue1)  { 
           
            i = 1;
            ArrayList whilecommands = new ArrayList<>();
            whilecommands.clear();
            boolean ifactive = false;
            boolean whileactive = false;  
            int ifcount = 0;
            int endifcount = 0;
            int whilecount = 0;
            int endwhilecount = 0;
            
            
            
            
            while (i < responses2.size()) {
            String whilecommand = (String) responses2.get(i);
            if (whilecommand.contains("print")&& !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") &&  whileactive == false &&  ifactive == false)  { 
        Print.print(whilecommand);
        
        
        
        }
        
        
        if (whilecommand.contains("print")&& whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") &&  whileactive == false &&  ifactive == false)  { 
        Printcalc.printcalc(whilecommand);
        
        
        }
        
        if (whilecommand.contains("num") && !whilecommand.contains(",") && !whilecommand.contains("[num]")&& whilecommand.contains("=") && !whilecommand.contains("input") &&  whileactive == false &&  ifactive == false) {
            Num.num(whilecommand);
        
    }
        
        if (whilecommand.contains("text") && !whilecommand.contains(",") && !whilecommand.contains("[text]")&& whilecommand.contains("=") && !whilecommand.contains("input") &&  whileactive == false &&  ifactive == false  ) {
            Text.text(whilecommand);
        }
        
        if (whilecommand.contains("input") && whilecommand.contains("=")) {
            Input.input(whilecommand);
            
        }
        else if (whilecommand.contains("if") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("end") && !whilecommand.contains("while") &&  whileactive == false) {
                          ifactive = true;  
                          whilecommands.add(whilecommand);
                          ifcount++;
                          
             } else if (whilecommand.contains("end if") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("while") &&  whileactive == false) {
                          endifcount++;
                          if (endifcount == ifcount) {
                          ifactive = false;
                          If.If(whilecommands);
                          whilecommands.clear();
                          
                          } else {
                              whilecommands.add(whilecommand);
                          }
             } else if (ifactive &&  whileactive == false) {
                      
                      whilecommands.add(whilecommand);
                      
            } else if (whilecommand.contains("while") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("end") &&  ifactive == false ) {
                          whileactive = true;  
                          whilecommands.add(whilecommand);      
                          whilecount++;
                          
                          
            } else if (whilecommand.contains("end while") && !whilecommand.contains(")") && !whilecommand.contains("(") &&  ifactive == false) {
                          endwhilecount++;
                          
                          if(endwhilecount == whilecount) {
                
                
                          whileactive = false; 
                          
                          While.While(whilecommands);
                         
                          whilecommands.clear();
                          
                          } else {
                              whilecommands.add(whilecommand);
                              
                          }
             } else if (whileactive &&  ifactive == false) {
                      
                      whilecommands.add(whilecommand);
                      
                      
        
                }
         else if (whilecommand.contains("num") && whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false ) {
                            Numarray.numarray(whilecommand);
            } else if (whilecommand.contains("[num]") && !whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false ) {
                            Numarray.numarraychange(whilecommand);    
            }
         else if (whilecommand.contains("text") && whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false ) {
                            Textarray.textarray(whilecommand);
            } else if (whilecommand.contains("[text]") && !whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false ) {
                            Textarray.textarraychange(whilecommand);    
            } 
            
            
            
            
            
            
            
        i++;
        
            }
        
        i = 1;
        
        if (Input.getVariable(conditionarray3[0].trim()) != null) {
                numValue = Input.getVariable(conditionarray3[0].trim());
            } else {
                numValue = Num.getVariable(conditionarray3[0].trim());
               
            }
        if (operator.equals("=") && numValue != Double.valueOf(conditionarray3[2].trim())  ||  operator.equals(">") && numValue <= Double.valueOf(conditionarray3[2].trim()) || operator.equals("<") && numValue >= Double.valueOf(conditionarray3[2].trim())) {
            numValue1 = num2;
            if (Input.getVariable(conditionarray3[0].trim()) != null) {
                numValue = Input.getVariable(vname);
            } else {
                numValue = Num.getVariable(vname);
               
            }
       
        } 

    }
    
}
}
        
    
