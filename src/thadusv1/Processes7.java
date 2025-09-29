/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.List;
import static thadusv1.If.numValue2;
import static thadusv1.If.numValue3;
import static thadusv1.While.conditionarray3;
import static thadusv1.While.operator;

/**
 *
 * @author netha
 */
public class Processes7 extends If {
   
    public static void processes7(List responses2) {
        int i;
        
       
           
           
            
            
            while (operator.equals("=") && numValue2 == numValue3 || operator.equals(">") && numValue2 > numValue3 || operator.equals("<") && numValue2 < numValue3)  { 
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
        else if (whilecommand.contains("if") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("end") && !whilecommand.contains("while")) {
                          ifactive = true;  
                          whilecommands.add(whilecommand);
                          ifcount++;
                          
             } else if (whilecommand.contains("end if") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("while")) {
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
                      
            } else if (whilecommand.contains("while") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("end")) {
                          whileactive = true;  
                          whilecommands.add(whilecommand);      
                          whilecount++;
                          
            } else if (whilecommand.contains("end while") && !whilecommand.contains(")") && !whilecommand.contains("(")) {
                          endwhilecount++;
                          
                          if(endwhilecount == whilecount) {
                
                
                          whileactive = false; 
                          
                          While.While(whilecommands);
                         
                          whilecommands.clear();
                          
                          } else {
                              whilecommands.add(whilecommand);
                          }
             } else if (whileactive) {
                      
                      whilecommands.add(whilecommand);
                      
        
                }
         else if (whilecommand.contains("num") && whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while")) {
                            Numarray.numarray(whilecommand);
            } else if (whilecommand.contains("[num]") && !whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while")) {
                            Numarray.numarraychange(whilecommand);    
            }
         else if (whilecommand.contains("text") && whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while")) {
                            Textarray.textarray(whilecommand);
            } else if (whilecommand.contains("[text]") && !whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while")) {
                            Textarray.textarraychange(whilecommand);    
            } 
            
            
            
            
            
            
            
        i++;
        
            }
            
            i = 1;
        
            
            if (Input.getVariable(conditionarray3[0].trim()) != null) {
                numValue2 = Input.getVariable(conditionarray3[0].trim());
            } else {
                numValue2 = Num.getVariable(conditionarray3[0].trim());
            }
            
            if (Input.getVariable(conditionarray3[2].trim()) != null) {
                numValue3 = Input.getVariable(conditionarray3[2].trim());
            } else {
                numValue3 = Num.getVariable(conditionarray3[2].trim());
            }
            
            
       
                
                
            }
           
        
        
    } 
        
    
}
