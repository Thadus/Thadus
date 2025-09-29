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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static thadusv1.Main.users;

/**
 *
 * @author netha
 */
public class Admin {
    private static JPanel mainPanel;
    private static JFrame frame2;
    private static JButton homeButton;
    private static JPanel topPanel;
    public static final int port = 12345;
    private static JLabel iPLabel;
    public static String IP;

    public static void adminDisplay() {
        frame2 = new JFrame("Thadus Admin");
        frame2.setSize(800, 600);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new BorderLayout());
        
        
        try {
        InetAddress localHost = InetAddress.getLocalHost();
        IP = localHost.getHostAddress();
        iPLabel = new JLabel("Server IP: " + localHost.getHostAddress() + "  Port: " + port);
        iPLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
    } catch (Exception e) {
        e.printStackTrace();
    }
        
        
        adminDisplaycont();
        
        
        

    
    new Thread(() -> server1()).start();
}

public static void server1() {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
        System.out.println("Server started, waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Handle each client in its own thread
            new Thread(() -> handleClient(clientSocket)).start();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void handleClient(Socket clientSocket) {
    try (
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
    ) {
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received from client: " + message);
            out.println("Server received: " + message);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    
    
        
        
        
        
    

        public static void adminDisplaycont() {

        topPanel = new JPanel();
        topPanel.setBackground((new Color(238, 238, 238)));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setPreferredSize(new Dimension(800, 90));

        JLabel logoLabel = new JLabel("Thadus Admin");
        logoLabel.setFont(new Font("Agency FB", Font.BOLD, 20));

        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(logoLabel);
        
        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN,16));
        homeButton.setBorder(new RoundedBorder(5));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setEnabled(false);
        homeButton.addActionListener(e -> {
            mainPanel.removeAll();
            adminDisplaycont();
            
        });
        
        
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(homeButton);
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(iPLabel);
        
        
        
        
        frame2.add(topPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(231, 245, 255));
        
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        
        
        JButton playButton = new JButton("Play Mode");
        playButton.setMaximumSize(new Dimension(100, 40));
        playButton.setBackground(new Color(0, 176, 240));
        playButton.setBorder(new RoundedBorder(15));
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addActionListener(e -> {
            playRun();
            
        });
        
        mainPanel.add(Box.createHorizontalStrut(500));
        mainPanel.add(playButton);
        
        JButton buildButton = new JButton("Build Mode");
        buildButton.setMaximumSize(new Dimension(100, 40));
        buildButton.setBackground(new Color(0, 176, 240));
        buildButton.setBorder(new RoundedBorder(15));
        buildButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buildButton.addActionListener(e -> {
            buildRun();
            
        });
        mainPanel.add(Box.createHorizontalStrut(50));
        mainPanel.add(buildButton);
        
        
        
        
        
        
        
        
        
        
        frame2.add(mainPanel, BorderLayout.CENTER);

        frame2.setVisible(true);
    }
    
    
    public static void playRun() {
        homeButton.setEnabled(true);
        ArrayList<User> users2 = new ArrayList<>();
        
        int i = 0;
        
        while (i < users.size()) {
            users2.add(users.get(i));
            i++;
        }
        
        
        int j = 0;
        while (j < users2.size() -1 ) {
        i = 0;
                
        while (i < users2.size() -1 ) {
            if (users2.get(i).getPoints() > users2.get(i+1).getPoints()) {
                User temp = new User(users2.get(i).getUserName(),users2.get(i).getPassword(),users2.get(i).getPoints(),users2.get(i).getAvatar(),users2.get(i).getVotes());
                users2.set(i, users2.get(i+1));
                users2.set(i+1, temp);
            }
            
            i++;
        }
        j++;
        
        }
        
        
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        if (users2.get(1) != null && users2.get(2) != null) { //first second and third
            JLabel podium = new JLabel("1st: " + users2.get(0).getUserName() + " Points: " + users2.get(0).getPoints() + "2nd: " + users2.get(1).getUserName() + " Points: " + users2.get(1).getPoints() + "3rd: " + users2.get(2).getUserName() + " Points: " + users2.get(2).getPoints());
            mainPanel.add(podium, BorderLayout.CENTER);
        }
        else if (users2.get(1) != null && users2.get(2) == null) { // first and second
            JLabel podium = new JLabel("1st: " + users2.get(0).getUserName() + " Points: " + users2.get(0).getPoints() + "2nd: " + users2.get(1).getUserName() + " Points: " + users2.get(1).getPoints());
            mainPanel.add(podium, BorderLayout.CENTER);
        }
        
        else { //first 
            JLabel podium = new JLabel("1st: " + users2.get(0).getUserName() + " Points: " + users2.get(0).getPoints());
            mainPanel.add(podium, BorderLayout.CENTER);
        }
         
        
        mainPanel.revalidate();
        mainPanel.repaint();
        
    }
    
    
    public static void buildRun(){
        homeButton.setEnabled(true);
        mainPanel.setLayout(new BorderLayout());
        
        int i = 0;
        
        ArrayList<User> users3 = new ArrayList<>();
        while (i < users.size()) {
            users3.add(users.get(i));
            i++;
        }
        
        
        int j = 0;
        while (j < users3.size() -1 ) {
        i = 0;
        
        while (i < users3.size() -1) {
            if (users3.get(i).getVotes() > users3.get(i+1).getVotes()) {
                User temp = new User(users3.get(i).getUserName(),users3.get(i).getPassword(),users3.get(i).getPoints(),users3.get(i).getAvatar(),users3.get(i).getVotes());
                users3.set(i, users3.get(i+1));
                users3.set(i+1, temp);
            }
            i++;  
        }
        j++;
        
        }
        
        
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        JLabel podium = new JLabel("1st: " + users3.get(0).getUserName() + " Votes: " + users3.get(0).getVotes());
        podium.setFont(new Font("Arial",Font.PLAIN,30));
        
        ImageIcon firstavatarimage = new ImageIcon(users3.get(0).getAvatar());
        JLabel avatarlabel1 = new JLabel(firstavatarimage);
        
        mainPanel.add(avatarlabel1, BorderLayout.CENTER);
        mainPanel.add(podium, BorderLayout.NORTH);
        
        mainPanel.revalidate();
        mainPanel.repaint();
        
        
    }

}
