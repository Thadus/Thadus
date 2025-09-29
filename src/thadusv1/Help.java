/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.URL;
import java.awt.Image;
import static thadusv1.Main.lightmode;

/**
 *
 * @author netha
 */
public class Help {

    private static JPanel logoPanel;
    private static JEditorPane helpSheet;
    private static JButton backButton;
    private static JLabel logoLabel;

    public static void Help() {
        JFrame frame2 = new JFrame("Thadus V1 Live IDE");
        frame2.setSize(800, 600);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setLayout(new BorderLayout());

        // Set logo image
        URL imageUrl = Main.class.getResource("/thadusv1/Images/ThadusLogo.png");
        if (imageUrl != null) {
            ImageIcon logoIcon = new ImageIcon(imageUrl);

            Image image = logoIcon.getImage();
            Image resizedImage = image.getScaledInstance(150, -1, Image.SCALE_SMOOTH);

            ImageIcon resizedLogoIcon = new ImageIcon(resizedImage);
            backButton = new JButton("Close");
            backButton.setBorder(new RoundedBorder(5));

            logoLabel = new JLabel("Thadus");
            logoLabel.setFont(new Font("Agency FB",Font.BOLD,20));
            logoPanel = new JPanel();
            logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
            logoPanel.add(logoLabel);
            backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            logoPanel.add(Box.createRigidArea(new Dimension(0, 10))); // 10px vertical gap
            logoPanel.add(backButton);
            Color bg = lightmode ? new Color(255, 255, 255) : new Color(0, 0, 0);
            Color bg2 = lightmode ? new Color(0,0,0) : new Color(255,255,255);
            logoPanel.setBackground(bg);
            logoPanel.repaint();
            logoLabel.setForeground(bg2);
            logoLabel.repaint();
            frame2.add(logoPanel, BorderLayout.WEST);
        } else {
            System.out.println("Error: Image not found.");
        }

        // Action for back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        });

        // Set up the help text area
        helpSheet = new JEditorPane();
        helpSheet.setContentType("text/html");
        helpSheet.setEditable(false);
        if (lightmode) {
            helpSheet.setBackground(new Color(231, 245, 255));  
        } else {
            helpSheet.setBackground(new Color(11, 37, 77));  
        }

        // Add dynamic font color based on lightmode
        String textColor = lightmode ? "#000000" : "#FFFFFF";  
        String headingColor = lightmode ? "#000000" : "#FFFFFF";  
        String codeColor = lightmode ? "#000000" : "#000000";    

        helpSheet.setText(
                "<html>" +
                        "<head><style>" +
                        "body { font-family: Calibri, sans-serif; font-size: 14px; color: " + textColor + "; }" +  
                        "h2 { font-size: 20px; margin-bottom: 10px; color: " + headingColor + "; }" +  
                        "table { border-collapse: collapse; width: 100%; }" +
                        "th { text-align: left; font-size: 16px; padding: 8px; background-color: #f0f0f0; color: #000000; }" +  
                        "td { padding: 8px; vertical-align: top; }" +
                        "tr:nth-child(even) { background-color: #f9f9f9; }" +
                        "code { font-family: Consolas, monospace; background-color: #f4f4f4; padding: 2px 4px; border-radius: 4px; color: " + codeColor + "; }" +  
                        "</style></head>" +
                        "<body>" +
                        "<h2>Thadus Syntax Help</h2>" +
                        "<table>" +
                        "<tr><th>Command Example</th><th>What it does</th><th>Output</th></tr>" +
                        "<tr><td><code>print hello</code></td><td>Prints literal text or text variable</td><td>output: hello</td></tr>" +
                        "<tr><td><code>print (5+5)</code></td><td>Prints calculation or numeric variable</td><td>output: 10</td></tr>" +
                        "<tr><td><code>num x = 50</code></td><td>Creates a numeric variable</td><td>output: numeric variable x of value 50 created</td></tr>" +
                        "<tr><td><code>text city = LA</code></td><td>Creates a text variable</td><td>output: text variable city of value LA created</td></tr>" +
                        "<tr><td><code>input how old are you = num age</code></td><td>Gets numeric input from user</td><td>user input → 20<br>output: numeric variable age of value 20 created</td></tr>" +
                        "<tr><td><code>input sport = text sport</code></td><td>Gets text input from user</td><td>user input → cricket<br>output: text variable sport of value cricket created</td></tr>" +
                        "<tr><td><code>loop (2) print (5+5)</code></td><td>Repeats a command a set number of times</td><td>output: 10 10</td></tr>" +
                        "<tr><td><code>loop (forever) print hello</code></td><td>Repeats a command endlessly</td><td>output: hello hello hello ...</td></tr>" +
                        "<tr><td><code>if (5>4) print true</code></td><td>Checks numeric condition</td><td>output: true</td></tr>" +
                        "<tr><td><code>text name = zoe<br>if (name = zoe) print correct</code></td><td>Checks text variable condition</td><td>output: correct</td></tr>" +
                        "<tr><td><code>num age = 20<br>if (age < 21) print yes</code></td><td>Checks numeric variable condition</td><td>output: yes</td></tr>" +
                        "<tr><td><code>if (5<4) print true else print no</code></td><td>Numeric condition with else fallback</td><td>output: no</td></tr>" +
                        "<tr><td><code>text name = zoe<br>if (name = zoeo) print correct else print false</code></td><td>Text condition with else fallback</td><td>output: false</td></tr>" +
                        "<tr><td><code>num age = 20<br>if (age > 21) print yes else print nope</code></td><td>Numeric variable condition with else</td><td>output: nope</td></tr>" +
                        "<tr><td><code>is (222 > 221)</code></td><td>Checks if a statement is true</td><td>output: yes</td></tr>" +
                        "</table>" +
                        "</body>" +
                        "</html>"
        );

        JScrollPane scrollPane = new JScrollPane(helpSheet);
        frame2.add(scrollPane, BorderLayout.CENTER);

        frame2.setVisible(true);
    }
}
