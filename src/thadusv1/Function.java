/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author netha
 */
public class Function extends Main{
    
    public static HashMap<String, List<String>> functionmap = new HashMap<>();
    
    public static void Function(List responses3) {
      String response = (String) responses3.get(0);
     
      String functionname = response.replace("function", "").trim();
      
      responses3.remove(0);
     
      
      
      
      functionmap.put(functionname, new ArrayList<>(responses3));
      
      
      
      
    }
    
    
    public static void Function2(String response) {
        
        String funcname = response.replace("run","").trim();
        
        ArrayList f = (ArrayList) functionmap.get(funcname);
        
        Processes8.processes8(f);
        
        
        
    }
    
    
    
}
