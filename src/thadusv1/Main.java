/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thadusv1;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static thadusv1.Function.functionmap;
import static thadusv1.If.conditionarray2;
import static thadusv1.Num.variables;
import static thadusv1.Numarray.numarray;
import static thadusv1.Object.objectname;
import static thadusv1.Object.objects;
import static thadusv1.PlayBuild.ObjectsButton;
import static thadusv1.PlayBuild.a;
import static thadusv1.PlayBuild.b;
import static thadusv1.PlayBuild.clip1;
import static thadusv1.PlayBuild.introMusic;
import static thadusv1.PlayBuild.winMusic;
import static thadusv1.PlayBuild.carSound;
import static thadusv1.PlayBuild.jetSound;
import static thadusv1.PlayBuild.dogSound;
import static thadusv1.Textarray.textarray;
import static thadusv1.While.conditionarray3;



public class Main {
    private static JFrame frame;
    public static JFrame frame1;
    public static JPanel loginPanel;
    private static JTextArea codeEditor;
    private static JTextArea outputConsole;
    private static JTextField inputField;
    private static JPanel logoPanel;
    private static JPanel buttonPanel;
    private static JPanel topPanel;
    private static JPanel helpButton;
    private static JLabel logoLabel;
    public static List<String> responses;
    public static List<Integer> loopactiveflag;
    public static int currentline;
    public static List<Integer> afterloopflag;
    public static List<Integer> ifactiveflag;
    public static List<String> responses2;
    public static List<Integer> afterifflag;
    public static List<String> functioncode;
    public static List<Integer> functionactiveflag;
    public static List<Integer> afterfunctionflag;
    public static PlayBuild playBuildPanel;
    public static JButton runButton;
    public static JButton clearButton;
    public static JButton helpButton2;
    public static JToggleButton togglebutton;
    public static JButton openButton;
    public static String openfile;
    public static Image raw2;
    public static String savefile;
    public static Image raw;
    public static JButton saveButton;
    public static Image raw6;
  
    public static boolean sound = true;
    public static String sBFile;
    public static Image raw7;
    
    public static boolean lightmode = true;
    public static boolean admin = false;
    public static String inputUserName;
    public static String inputPassword;
    public static ArrayList<User> users = new ArrayList<>();
    
    
    public static void main(String[] args) {
        frame1 = new JFrame("Thadus Coder");
        frame1.setSize(800, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        
        
        Login.login();
        frame1.setVisible(true);
        
        
        
}
    
    

public static void mainBuild() {
    frame = new JFrame("Thadus Coder");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    
    URL imageUrl = Main.class.getResource("/thadusv1/Images/ThadusLogo.png");
    if (imageUrl != null) {
    ImageIcon logoIcon = new ImageIcon(imageUrl);
    
    
    Image image = logoIcon.getImage();
    Image resizedImage = image.getScaledInstance(150, -1, Image.SCALE_SMOOTH); 
    
    
    
    ImageIcon resizedLogoIcon = new ImageIcon(resizedImage);
    
    
    logoLabel = new JLabel("Thadus");
    logoLabel.setFont(new Font("Agency FB",Font.BOLD,20));
 
    togglebutton = new JToggleButton("Dark mode");
    togglebutton.setFont(new Font("Dialog", Font.BOLD,12));
    togglebutton.setBorder(new RoundedBorder(5));
    togglebutton.setOpaque(false);
    togglebutton.setContentAreaFilled(false);
    togglebutton.setBorderPainted(false);
    togglebutton.addItemListener(e -> {
    lightmode = !togglebutton.isSelected();
    togglebutton.setText(lightmode ? "Dark mode" : "Light mode");
    
    updateTheme(logoPanel, codeEditor, buttonPanel, topPanel, logoLabel, runButton, clearButton, helpButton2, togglebutton, openButton, raw2, saveButton); 
});
    if (lightmode) {
        openfile = "/thadusv1/Images/Open.png";
        savefile = "/thadusv1/Images/Save.png";
    } else {
        openfile = "/thadusv1/Images/Open2.png";
        savefile = "/thadusv1/Images/Save2.png";
    }
    
    if (sound) {
        sBFile = "/thadusv1/Images/mute.png";
        
    }else {
        sBFile = "/thadusv1/Images/sound.png";
    }
    
    
    
    raw = new ImageIcon(Main.class.getResource(savefile)).getImage();
    Image scaled = raw.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    ImageIcon Save = new ImageIcon(scaled);
    
    
    
   
    saveButton = new JButton (Save);
    saveButton.setBackground(Color.green);
    saveButton.setContentAreaFilled(false);
    saveButton.setOpaque(false);
    saveButton.setBorderPainted(false);
    
    
    raw2 = new ImageIcon(Main.class.getResource(openfile)).getImage();
    Image scaled2 = raw2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    ImageIcon open2 = new ImageIcon(scaled2);
    
    
    
    
    
    openButton = new JButton (open2);
    
    
    
  
    openButton.setContentAreaFilled(false);
    openButton.setOpaque(false);
    openButton.setBorderPainted(false);
    
    
    
   
    
    
    openButton.setBorder(new RoundedBorder(5));

    
   
    logoPanel = new JPanel();
    logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS)); 
    logoPanel.add(logoLabel);
    togglebutton.setAlignmentX(Component.LEFT_ALIGNMENT);
    logoPanel.add(Box.createRigidArea(new Dimension(0, 10))); // 10px vertical gap
    logoPanel.add(togglebutton);
    logoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    logoPanel.add(saveButton);
    saveButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    logoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    logoPanel.add(openButton);
    openButton.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    
    saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");

        int userSelection = fileChooser.showSaveDialog(codeEditor);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(codeEditor.getText());
                JOptionPane.showMessageDialog(frame, "File saved successfully!");
            }          catch (IOException ex) { 
                           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                       } 
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            outputConsole.setText("Save operation cancelled.");
        }
            }
        });
    
    openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    codeEditor.setText("");
                    File selectedFile = fileChooser.getSelectedFile();
                    try (Scanner scanner = new Scanner(selectedFile)) {
                        while (scanner.hasNextLine()) {
                            codeEditor.append((scanner.nextLine())+"\n");
                        }
                    outputConsole.setText("Now open: " + selectedFile.getName());
                    } catch (FileNotFoundException ex) {
                        outputConsole.setText("File not found: " + ex.getMessage());
                    }
                }
            }
        });
            
     
    
    
    
    
    if (lightmode) {
        logoPanel.setBackground(new Color(238,238,238));
    } else {
        logoPanel.setBackground(new Color(0,0,0));
    }


   
    frame.add(logoPanel, BorderLayout.WEST);
    } else {
    System.out.println("Error: Image not found.");
    }


        
        JPanel editorPanel = new JPanel(new BorderLayout());
        codeEditor = new JTextArea();
        codeEditor.setFont(new Font("Consolas", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(codeEditor);
        
        playBuildPanel = new PlayBuild(); 
        
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, playBuildPanel);

        
        splitPane.setResizeWeight(0.5); 
        splitPane.setDividerLocation(0.5); 

        
        splitPane.setBorder(null);

        editorPanel.add(splitPane, BorderLayout.CENTER);
        
        
        
        
        
        
        

        
        outputConsole = new JTextArea();
        outputConsole.setEditable(true);
        outputConsole.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputConsole.setBackground(new Color(255, 255, 255));
        JScrollPane consoleScroll = new JScrollPane(outputConsole);
        consoleScroll.setPreferredSize(new Dimension(800, 150));
        
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        
        
        
        
        
        helpButton2 = new JButton("Help");
        helpButton2.setBorder(new RoundedBorder(10));
        helpButton2.setOpaque(false);
        helpButton2.setContentAreaFilled(false);
        helpButton2.setBorderPainted(false);
        topPanel.add(helpButton2, BorderLayout.EAST);
        
        Image raw5 = new ImageIcon(Main.class.getResource("/thadusv1/Images/turkeythad.png")).getImage();
        Image scaled2 = raw5.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon mascot = new ImageIcon(scaled2);
        JLabel mascotlogo = new JLabel(mascot);
        
        
        topPanel.add(mascotlogo, BorderLayout. WEST);
        
        
        
        
        
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        runButton = new JButton("Run");
        runButton.setBorder(new RoundedBorder(5));
        runButton.setOpaque(false);
        runButton.setContentAreaFilled(false);
        runButton.setBorderPainted(false);
        
        clearButton = new JButton("Clear");
        clearButton.setBorder(new RoundedBorder(5));
        clearButton.setOpaque(false);
        clearButton.setBackground(Color.white);
        clearButton.setBorderPainted(false);
        
        
        
        
    
    
    
   
    
    
    
        
        
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        buttonPanel.add(runButton);
        buttonPanel.add(clearButton);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        topPanel.add(buttonPanel, BorderLayout.CENTER);
        
        
        

        
        frame.add(editorPanel, BorderLayout.CENTER);
        frame.add(consoleScroll, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);
        
       
        codeEditor.setBackground(new Color(231, 245, 255));
        buttonPanel.setBackground(new Color(238,238,238));
        
        

        
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputConsole.setText("");
                runThadusCode();
            }
        });

        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codeEditor.setText("");
                outputConsole.setText("");
            }
        });
        
        helpButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Help.Help();
            }
        });
        
        
        
        
        
        
        

        
        frame.setVisible(true);
        Main.printToConsole("Welcome to Thadus!");
        Main.printToConsole("This is your output");
        codeEditor.setText("Write your code here and then press run");
        codeEditor.append("\n" + "Save your code as a .thad file to work on it later");
        
        // Remove everything (loginPanel + any lingering components)


// Re-add your layout components (already done above in your code)
frame.add(logoPanel, BorderLayout.WEST);
frame.add(editorPanel, BorderLayout.CENTER);
frame.add(consoleScroll, BorderLayout.SOUTH);
frame.add(topPanel, BorderLayout.NORTH);

// Refresh the frame to display the new UI
frame.revalidate();
frame.repaint();
        
        
    }
    
    private static void updateTheme(JPanel logoPanel, JTextArea editor, JPanel buttonPanel, JPanel topPanel, JLabel logoLabel, JButton runButton, JButton clearButton, JButton helpButton, JToggleButton togglebutton, JButton openButton, Image raw2, JButton saveButton) {
    Color bg = lightmode ? new Color(238, 238, 238) : new Color(0, 0, 0);
    Color bg2 = lightmode ? new Color(0, 0, 0) : new Color(238, 238, 238);
    Color editorBg = lightmode ? new Color(231, 245, 255) : new Color(11, 37, 77);
    Color textColor = lightmode ? Color.BLACK : Color.WHITE;
    String openfile = lightmode ? "/thadusv1/Images/Open.png" : "/thadusv1/Images/Open2.png";
    String savefile = lightmode ? "/thadusv1/Images/Save.png" : "/thadusv1/Images/Save2.png";
    

    logoPanel.setBackground(bg);
    logoPanel.setOpaque(true);

    editor.setBackground(editorBg);
    editor.setForeground(textColor);

    buttonPanel.setBackground(bg);
    topPanel.setBackground(bg);
    
    logoLabel.setForeground(bg2);
    runButton.setForeground(bg2);
    clearButton.setForeground(bg2);
    helpButton2.setForeground(bg2);
    togglebutton.setForeground(bg2);
    togglebutton.setFont(new Font("Dialog", Font.BOLD,12));
    
    raw2 = new ImageIcon(Main.class.getResource(openfile)).getImage();
    Image scaled2 = raw2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    ImageIcon open2 = new ImageIcon(scaled2);
    openButton.setIcon(open2);
    
    raw = new ImageIcon(Main.class.getResource(savefile)).getImage();
    Image scaled = raw.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    ImageIcon Save = new ImageIcon(scaled);
    saveButton.setIcon(Save);
    
    
    
    
    
    
    
    logoPanel.repaint();
    editor.repaint();
    buttonPanel.repaint();
    topPanel.repaint();
    logoLabel.repaint();
    runButton.repaint();
    clearButton.repaint();
    helpButton2.repaint();
    togglebutton.repaint();
    
}
    
   
    
    
    
    
    


    private static void runThadusCode() {
        outputConsole.setText("");
        String[] lines = codeEditor.getText().split("\n");
        conditionarray2 = null;
        conditionarray3 = null;
        functionmap.clear();
        variables.clear();
        textarray.clear();
        numarray.clear();
        
        
        
        /*returning PlayBuild dog to start when run is pressed */ 
        a = 35;
        b = 20;
        playBuildPanel.repaint();
        
        
        ArrayList responses = new ArrayList<>();
       
        boolean ifactive = false;
        
        boolean whileactive = false;
        boolean functionactive = false;
        int ifcount = 0;
        int endifcount = 0;
        int whilecount = 0;
        int endwhilecount = 0;
        
        for (String response : lines) {
            response = response.trim();
            if (response.isEmpty()) continue;
            
            if (response.contains("print") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Print.print(response);
             } else if (response.contains("print") && response.contains(")") && response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  whileactive == false && functionactive == false) {
                            Printcalc.printcalc(response);
                            
                            
             } else if (response.contains("if") && response.contains(")") && response.contains("(") && !response.contains("end") && !response.contains("while") &&  whileactive == false && functionactive == false) {
                          ifactive = true;  
                          responses.add(response);
                          
                          ifcount++;
                          
             } else if (response.contains("end if") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("while") &&  whileactive == false && functionactive == false) {
                          
                          endifcount++;
                          
                          if (endifcount == ifcount) {
                               If.If(responses); 
                               responses.clear();
                               ifactive = false;
                          } else {
                              responses.add(response);
                             
                              
                          }
                              
             } else if (ifactive == true &&  functionactive == false) {
                      
                      responses.add(response);
                      
                      
            } else if (response.contains("while") && response.contains(")") && response.contains("(") && !response.contains("end") && ifactive == false && functionactive == false) {
                          whileactive = true;  
                          responses.add(response); 
                         
                          whilecount++;
                          
                          
                          
            } else if (response.contains("end while") && !response.contains(")") && !response.contains("(") && ifactive == false && functionactive == false ) {
                          endwhilecount++;
                          
                          if (endwhilecount == whilecount) {
                          whileactive = false;
                          While.While(responses);
                          responses.clear();
                          } else {
                              responses.add(response);
                             
                          }
             } else if (whileactive && functionactive == false) {
                      
                      responses.add(response);
                      
                      
             } else if (response.contains("function") && !response.contains("run") && !response.contains("end")) {
                          functionactive = true;  
                          responses.add(response);       
                          
            } else if (response.contains("end function") && !response.contains(")") && !response.contains("(")) {
                          functionactive  = false;
                          Function.Function(responses);
                          responses.clear();
             } else if (functionactive) {
                      
                      responses.add(response);    
             } else if (response.contains("run")) {
                      
                      Function.Function2(response);   
                      
                      
                      
                      
            } else if (response.contains("input") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Input.input(response);               
            } else if (response.contains("new object") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Object.Object(response);
            } else if (response.contains("text") && !response.contains(",")&&!response.contains("[text]") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Text.text(response);                       
            } else if (response.contains("num") && !response.contains(",")&&!response.contains("[num]") &&!response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Num.num(response);                   
            } else if (response.contains("num") && response.contains(",") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Numarray.numarray(response);
            } else if (response.contains("[num]") && !response.contains(",") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Numarray.numarraychange(response); 
                            
            } else if (response.contains("text") && response.contains(",") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Textarray.textarray(response);
            } else if (response.contains("[text]") && !response.contains(",") && !response.contains(")") && !response.contains("(") && !response.contains("loop") && !response.contains("if") && !response.contains("while") &&  ifactive == false &&  whileactive == false && functionactive == false) {
                            Textarray.textarraychange(response);                      
            } else if (objects.containsValue(objectname) && !response.contains("add") &&!response.contains("new object")) {
                            Main.playBuildPanel.playMode(response);
            } else if (objects.containsValue(objectname) && response.contains("add") && !response.contains("move") &&!response.contains("new object") ) {
                            PlayBuild.buildMode(response);
            

            } else {
                printToConsole("Error: Unknown command - " + response);
            }
            
            currentline++;
            
        }
        
       
    }
        
    

    public static void processInput(String input) {
        if (input.contains("input")) {
            String variableName = input.replace("input", "").trim();
            printToConsole("Enter value for " + variableName + ":");
            String value = JOptionPane.showInputDialog("Enter value for " + variableName);
            printToConsole("You entered: " + value);
        }
    }

    public static void printToConsole(String message) {
        outputConsole.append(message.toString() + "\n");
    }
    
    
}
