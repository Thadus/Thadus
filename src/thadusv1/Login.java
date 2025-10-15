/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static thadusv1.Main.frame1;
import static thadusv1.Main.inputPassword;
import static thadusv1.Main.inputUserName;
import static thadusv1.Main.mainBuild;
import static thadusv1.Main.loginPanel;
import static thadusv1.Main.users;
import static thadusv1.PlayBuild.Screenshot1;
import static thadusv1.PlayBuild.points;




/**
 *
 * @author netha
 */
public class Login {
    public static User user1;
    
    public static void login() {
        loginPanel = new BLoginPanel("/thadusv1/Images/background.png");
        loginPanel.setVisible(true);
        
        frame1.add(loginPanel, BorderLayout.CENTER);  
       
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Thadus CodeLabs Login");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(Box.createVerticalStrut(100));
        loginPanel.add(title);
        loginPanel.add(Box.createVerticalStrut(20));

        JTextField userField = new JTextField("Username");
        userField.setMaximumSize(new Dimension(250, 30));
        
        loginPanel.add(userField);
        loginPanel.add(Box.createVerticalStrut(10));

        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setVisible(true);
        passwordField.setMaximumSize(new Dimension(250, 30));
        
      
    
            
        loginPanel.add(passwordField);
        loginPanel.add(Box.createVerticalStrut(10));

        
        JButton loginButton = new JButton("Login");
        loginButton.setMaximumSize(new Dimension(200, 40));
        loginButton.setBackground(new Color(0, 176, 240));
        loginButton.setBorder(new RoundedBorder(15));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(loginButton);
        loginButton.addActionListener(e -> {
            inputUserName = userField.getText().trim();
            inputPassword = String.valueOf(passwordField.getPassword()).trim();
            
           try {
               loginrun(inputUserName, inputPassword);
           } catch (URISyntaxException ex) {
               Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        loginPanel.add(Box.createVerticalStrut(10));
        
        
        frame1.revalidate();
        frame1.repaint();        
    });
        
        
        
        
                
    }
    
    public static void loginrun(String inputUserName, String inputPassword) throws URISyntaxException {
    boolean found = false;
    boolean admin = false;
    
  
    
    try (BufferedReader reader = new BufferedReader(new FileReader("Files/users.csv"))) {
        String line;
        boolean skipHeader = true;

        while ((line = reader.readLine()) != null) {
            if (skipHeader) {
                skipHeader = false; // skip the first line (header)
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length >= 2) {
                String username = parts[0].trim();
                String password = parts[1].trim();

                if (username.equals(inputUserName) && password.equals(inputPassword)) {
                    found = true;
                    if (username.equals("neth")) {
                        admin = true;
                    }
                    user1 = new User(username,password,0,Screenshot1,0);
                    
                    users.add(user1);
                    break;
                }
            }
        }

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame1, "Error reading user file: " + ex.getMessage());
        ex.printStackTrace();
    }

    if (found && !admin) {
        frame1.dispose();
        mainBuild();
        
    } else if (found && admin) {
        frame1.dispose();
        mainBuild();
        Admin.adminDisplay();
        
    } else {
        JOptionPane.showMessageDialog(frame1, "Invalid username or password");
    }


    }
}
