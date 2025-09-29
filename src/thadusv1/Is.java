/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

public class Is {
    public static void Is(String response) {
        response = response.replace("is", "").trim();

        String condition = response.replaceFirst("^.*?\\((.*?)\\).*", "$1").trim();
        String[] conditionarray = condition.split("(?=[<>=])|(?<=[<>=])");
        conditionarray[2] = conditionarray[2].trim();

        
        if (Text.getAllVariables().containsKey(conditionarray[0].trim()) && conditionarray[1].trim().equals("=")) {
            String textValue = Text.getVariable(conditionarray[0].trim());
            if (textValue != null && textValue.equals(conditionarray[2].trim())) {
                Main.printToConsole("yes");
            } else {
               Main.printToConsole("no");
            }
        }
        
        if (Input.getVariable2(conditionarray[0].trim()) != null && conditionarray[1].trim().equals("=")) {
            String textValue = Input.getVariable2(conditionarray[0].trim());
            if (textValue != null && textValue.equals(conditionarray[2].trim())) {
                Main.printToConsole("yes");
            } else {
                Main.printToConsole("no");
            }
        }
      
      
        if (!conditionarray[2].matches("-?\\d+(\\.\\d+)?")) {
            String varName = conditionarray[0].trim();
            if (Num.getAllVariables().containsKey(varName) && conditionarray[1].trim().equals("=")) {
                Double varValue = Num.getVariable(varName);  // Use getVariable to retrieve the value
                if (varValue != null && varValue.toString().equals(conditionarray[2].trim())) {
                    Main.printToConsole("yes");
                } else {
                    Main.printToConsole("no");
                }
            } else {
                Main.printToConsole("no");
            }
        }

        
        if (!conditionarray[0].matches("-?\\d+(\\.\\d+)?")) {
            String varName = conditionarray[0].trim();
            if (Num.getAllVariables().containsKey(varName)) {
                Double varValue = Num.getVariable(varName);  
                if (conditionarray[1].trim().equals("=")) {
                    Double conditionValue = Double.valueOf(conditionarray[2]);
                    if (Math.abs(varValue - conditionValue) < 1e-9) {
                        Main.printToConsole("yes");
                    } else {
                        Main.printToConsole("no");
                    }
                }

                if (conditionarray[1].trim().equals(">")) {
                    Double conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue > conditionValue) {
                        Main.printToConsole("yes");
                    } else {
                        Main.printToConsole("no");
                    }
                }

                if (conditionarray[1].trim().equals("<")) {
                    Double conditionValue = Double.valueOf(conditionarray[2]);
                    if (varValue < conditionValue) {
                        Main.printToConsole("yes");
                    } else {
                        Main.printToConsole("no");
                    }
                }
            }
        }

        
        if (conditionarray[0].matches("-?\\d+(\\.\\d+)?") && conditionarray[2].matches("-?\\d+(\\.\\d+)?")) {
            double value1 = Double.parseDouble(conditionarray[0]);
            String operand = conditionarray[1];
            double value2 = Double.parseDouble(conditionarray[2]);

            if (operand.equals(">")) {
                if (value1 > value2) {
                    Main.printToConsole("yes");
                } else {
                    Main.printToConsole("no");
                }
            }

            if (operand.equals("=")) {
                if (value1 == value2) {
                    Main.printToConsole("yes");
                } else {
                    Main.printToConsole("no");
                }
            }

            if (operand.equals("<")) {
                if (value1 < value2) {
                    Main.printToConsole("yes");
                } else {
                    Main.printToConsole("no");
                }
            }
        }
    }
}
