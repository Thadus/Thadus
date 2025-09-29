/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.List;
import static thadusv1.If.conditionarray2;
import static thadusv1.If.textValue;
import static thadusv1.If.textValue2;


/**
 *
 * @author netha
 */

public class Processes2 extends If {
    private static boolean e = false;
        private static ArrayList alternative = new ArrayList<String>();
    public static void processes2(List whilecommands2) {
        int i = 1;
        
            e = false;
            int a = 0;
            
            while (i < whilecommands2.size()) {
                if (whilecommands2.get(a) == null) {
                    break;
                }
                
                
                if (whilecommands2.get(i).equals("else")) {
                    e = true;
                    a = i;
                    whilecommands2.remove(i);
                }
                
                
                
                if(e) {
                    alternative.add(whilecommands2.get(i));
                    
                   i = a;
                    
                    whilecommands2.remove(i);
                } else {
                    i++;
                }
                
               
                
            }
           
           
            
            if (operator2.equals("=") && numValue == Double.valueOf(conditionarray2[2].trim())  ||  operator2.equals(">") && numValue > Double.valueOf(conditionarray2[2].trim()) || operator2.equals("<") && numValue < Double.valueOf(conditionarray2[2].trim())        )  { 
            
            ArrayList whilecommands = new ArrayList<>();
            
            boolean whileactive = false;    
            boolean ifactive = false;
            
            int ifcount = 0;
            int endifcount = 0;
                
                
                i = 1;
            while (i < whilecommands2.size()) {
            String whilecommand = (String) whilecommands2.get(i);
            
            if (whilecommand.contains("print")&& !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") &&  ifactive == false &&  whileactive == false)  { 
        Print.print(whilecommand);
        
        
        
        }
        
        
        if (whilecommand.contains("print")&& whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") &&  ifactive == false &&  whileactive == false)  { 
        Printcalc.printcalc(whilecommand);
        
        
        }
        
        if (whilecommand.contains("num") && !whilecommand.contains(",") && !whilecommand.contains("[num]") && whilecommand.contains("=") && !whilecommand.contains("input") &&  ifactive == false &&  whileactive == false) {
            Num.num(whilecommand);
        
    }
        
        if (whilecommand.contains("text") && !whilecommand.contains(",") && !whilecommand.contains("[text]") && whilecommand.contains("=") && !whilecommand.contains("input") &&  ifactive == false &&  whileactive == false) {
            Text.text(whilecommand);
        }
        
        if (whilecommand.contains("input") && whilecommand.contains("=")) {
            Input.input(whilecommand);
            
         } else if (whilecommand.contains("if") && whilecommand.contains(")") && whilecommand.contains("(") && !whilecommand.contains("end") && !whilecommand.contains("while") &&  whileactive == false) {
                          ifactive = true;  
                          whilecommands.add(whilecommand);
                          
                          ifcount++;
                          
             } else if (whilecommand.contains("end if") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("while") &&  whileactive == false) {
                          
                          endifcount++;
                          
                          if (endifcount == ifcount) {
                               If.If(whilecommands); 
                               
                               whilecommands.clear();
                               ifactive = false;
                          } else {
                              whilecommands.add(whilecommand);
                            
                              
                          }
                              
             } else if (ifactive == true) {
                      
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
         else if (whilecommand.contains("num") && whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false) {
                            Numarray.numarray(whilecommand);
            } else if (whilecommand.contains("[num]") && !whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false) {
                            Numarray.numarraychange(whilecommand);    
              }
         else if (whilecommand.contains("text") && whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false) {
                            Textarray.textarray(whilecommand);
            } else if (whilecommand.contains("[text]") && !whilecommand.contains(",") && !whilecommand.contains(")") && !whilecommand.contains("(") && !whilecommand.contains("loop") && !whilecommand.contains("if") && !whilecommand.contains("while") &&  ifactive == false &&  whileactive == false) {
                            Textarray.textarraychange(whilecommand);    
            }
        
        
        
        
        
        
        
        
        
        
        
            
            
            
            
            
            
            
        i++;
        }
        } else {
                ArrayList whilecommands = new ArrayList<>();
            
            boolean whileactive = false;       
                
                
                
              i = 0;
              while (i < alternative.size()) {
            String command2 = (String) alternative.get(i);
            
            
            if (command2.contains("print")&& !command2.contains(")") && !command2.contains("(") && !command2.contains("loop") && !command2.contains("if"))  { 
        Print.print(command2);
        }
            
            if (command2.contains("print")&& command2.contains(")") && command2.contains("(") && !command2.contains("loop") && !command2.contains("if"))  { 
        Printcalc.printcalc(command2);
        
        
        }
        
        if (command2.contains("num") && !command2.contains(",") && !command2.contains("[num]") && command2.contains("=") && !command2.contains("input")) {
            Num.num(command2);
        
    }
        
        if (command2.contains("text") && !command2.contains(",") && !command2.contains("[text]")&& command2.contains("=") && !command2.contains("input")) {
            Text.text(command2);
        }
        
        if (command2.contains("input") && command2.contains("=")) {
            Input.input(command2);
        
        } else if (command2.contains("while") && command2.contains(")") && command2.contains("(") && !command2.contains("loop")) {
                          whileactive = true;  
                          whilecommands.add(command2);      
                          
                          
            } else if (command2.contains("end while") && !command2.contains(")") && !command2.contains("(")) {
                          whileactive = false; 
                          
                          While.While(whilecommands);
                         
                          whilecommands.clear();
             } else if (whileactive) {
                      
                      whilecommands.add(command2);
                      
        
                }
         else if (command2.contains("num") && command2.contains(",") && !command2.contains(")") && !command2.contains("(") && !command2.contains("loop") && !command2.contains("if") && !command2.contains("while")) {
                            Numarray.numarray(command2);
            } else if (command2.contains("[num]") && !command2.contains(",") && !command2.contains(")") && !command2.contains("(") && !command2.contains("loop") && !command2.contains("if") && !command2.contains("while")) {
                            Numarray.numarraychange(command2);    
            }
         else if (command2.contains("text") && command2.contains(",") && !command2.contains(")") && !command2.contains("(") && !command2.contains("loop") && !command2.contains("if") && !command2.contains("while")) {
                            Textarray.textarray(command2);
            } else if (command2.contains("[text]") && !command2.contains(",") && !command2.contains(")") && !command2.contains("(") && !command2.contains("loop") && !command2.contains("if") && !command2.contains("while")) {
                            Textarray.textarraychange(command2);    
            }

      
        
        
        
            
            
            
            
            
            
            
        i++;
        }  
                
       
                
                
            }
           
        
        
    } 
        
    
}


    

            

