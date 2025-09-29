/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package thadusv1;

import java.util.List;

public class Ifelse extends Main{

    public static void Ifelse(List responses) {
        String response = (String) responses.get(0);
        response = response.replace("if", "").trim();

        String condition = response.replaceFirst("^.*?\\((.*?)\\).*", "$1").trim();
       
        String alternative = response.replaceFirst(".*\\belse\\b\\s*", "").trim();

        String conditionarray[] = condition.split("(?=[<>=])|(?<=[<>=])");
        conditionarray[2] = conditionarray[2].trim();
        
        
        if (Text.getAllVariables().containsKey(conditionarray[0].trim()) && conditionarray[1].trim().equals("=")) {
            String textValue = Text.getVariable(conditionarray[0].trim());
            if (textValue != null && textValue.equals(conditionarray[2].trim())) {
                Processes.processes(command);
                return;
            } else {
                Processes.processes(alternative);
                return;
                
               
            }
        }
        
        if (Input.getVariable2(conditionarray[0].trim()) != null && conditionarray[1].trim().equals("=")) {
            String textValue = Input.getVariable2(conditionarray[0].trim());
            if (textValue != null && textValue.equals(conditionarray[2].trim())) {
                Processes.processes(command);
                return;
            } else {
                Processes.processes(alternative);
                return;
                
            }
        }

        
        if (!conditionarray[2].matches("-?\\d+(\\.\\d+)?")) {
            String varName = conditionarray[0].trim();
            if (Num.getAllVariables().containsKey(varName) && conditionarray[1].trim().equals("=")) {
                Double varValue = Num.getVariable(varName); 
                if (varValue != null && varValue.toString().equals(conditionarray[2].trim())) {
                    Processes.processes(command);
                } else {
                    Main.printToConsole(alternative);
                }
            } else {
                Processes.processes(alternative);
            }
        }

        
        if (!conditionarray[0].matches("-?\\d+(\\.\\d+)?")) {
            String varName = conditionarray[0].trim();
            if (Num.getAllVariables().containsKey(varName)) {
                Double varValue = Num.getVariable(varName);  
                if (conditionarray[1].trim().equals("=")) {
                    Double conditionValue = Double.valueOf(conditionarray[2]);
                    if (Math.abs(varValue - conditionValue) < 1e-9) {
                        Processes.processes(command);
                    } else {
                        Processes.processes(alternative);
                    }
                }

                if (conditionarray[1].trim().equals(">")) {
                    Double conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue > conditionValue) {
                        Processes.processes(command);
                    } else {
                        Processes.processes(alternative);
                    }
                }

                if (conditionarray[1].trim().equals("<")) {
                    Double conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue < conditionValue) {
                        Processes.processes(command);
                    } else {
                        Processes.processes(alternative);
                    }
                }
            }
        }

        
        if (conditionarray[0].matches("-?\\d+(\\.\\d+)?") && (conditionarray[2].matches("-?\\d+(\\.\\d+)?"))) {
            double value1 = Double.parseDouble(conditionarray[0]);
            String operand = conditionarray[1];
            double value2 = Double.parseDouble(conditionarray[2]);

            if (operand.equals(">")) {
                if (value1 > value2) {
                    Processes.processes(command);
                } else {
                    Processes.processes(alternative);
                }
            }

            if (operand.equals("=")) {
                if (value1 == value2) {
                    Processes.processes(command);
                } else {
                    Processes.processes(alternative);
                }
            }

            if (operand.equals("<")) {
                if (value1 < value2) {
                    Processes.processes(command);
                } else {
                    Processes.processes(alternative);
                }
            }
        }
    }
}

*/ 
