/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static thadusv1.Main.playBuildPanel;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import static thadusv1.Input.input;
import static thadusv1.Login.user1;
import static thadusv1.Main.sound;
import static thadusv1.Object.objectname;


/**
 *
 * @author netha
 */
public class PlayBuild extends JPanel  {
    public static int x = -1;
    public static int y = -1;
    private final Random random = new Random();
    public Image Puppy = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Puppy.png")).getImage();
    public Image Grass = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Grass.png")).getImage();
    public Image Ball = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Ball.png")).getImage();
    public Image F1Car = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Racecar.png")).getImage();
    public Image Road = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Road.png")).getImage();
    public Image Finish = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Finish.png")).getImage();
    public Image Jetplane = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Jet.png")).getImage();
    public Image Sky = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Sky.png")).getImage();
    public Image Tanker = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/Tanker.png")).getImage();
    public Image Runway = new ImageIcon(PlayBuild.class.getResource("/thadusv1/Images/runway.png")).getImage();
    
    public static AudioInputStream dogSound;
    public static AudioInputStream carSound;
    public static AudioInputStream jetSound;
    public static AudioInputStream introMusic;
    public static AudioInputStream winMusic;
    public static Clip clip1;
    
    public static int a = 35;
    public static int b = 20;
    public static int points = 0;
    public static JButton ObjectsButton;
    public static JButton ResetButton;
    public static JButton modeButton;
    public static JButton colourButton;
    public static JButton photoButton;
    public static JLabel pointslabel;
    public static boolean dogselect = false;
    public static boolean carselect = false;
    public static boolean jetselect = false;
    public static boolean buildmodeselect = false;
    public static boolean playmodeselect = false;
    public static boolean menu = true;
    public static JPopupMenu objects;        
    public static JMenuItem Title;
    public static JMenuItem Dog2;
    public static JMenuItem Racecar2;
    public static JMenuItem Jet2;
    public static JMenuItem Title3;
    public static JMenuItem skin;
    public static JMenuItem eyes;
    public static JMenuItem eyebrows;
    public static JMenuItem nose;
    public static JMenuItem mouth;
    public static JMenuItem hair;
    public static JMenuItem shirt;
    public static JMenuItem longsleeve;
    public static JMenuItem pants;
    public static JMenuItem shorts;
    public static JMenuItem shoes;
    public static JMenuItem socks;
    public static JMenuItem cap;
    
    public static String hairtype;
    public static boolean straight = false;
    public static boolean curly = false;
    public static boolean shaggy = false;
    public static int skinr;
    public static int sking;
    public static int skinb;
    public static int hairr;
    public static int hairg;
    public static int hairb;
    public static int browsr;
    public static int browsg;
    public static int browsb;
    public static int eyesr;
    public static int eyesg;
    public static int eyesb;
    public static int noser;
    public static int noseg;
    public static int noseb;
    
    public static boolean skintype = false;
    public static boolean browstype = false;
    public static boolean eyestype = false;
    public static boolean nosetype = false;
    public static boolean smile = false;
    public static boolean happy = false;
    public static boolean frown = false;
    public static boolean neutral = false;
    public static boolean sad = false;
    public static String mouthtype;
    public static int mouthr;
    public static int mouthg;
    public static int mouthb;
    public static boolean sleevetype;
    public static int sleever;
    public static int sleeveg;
    public static int sleeveb;
    public static boolean shirttype;
    public static int shirtr;
    public static int shirtg;
    public static int shirtb;
    public static boolean pantstype;
    public static int pantsr;
    public static int pantsg;
    public static int pantsb;
    public static boolean shortstype;
    public static int shortsr;
    public static int shortsg;
    public static int shortsb;
    public static boolean sockstype = false;
    public static int socksr;
    public static int socksg;
    public static int socksb;
    public static boolean shoestype = false;
    public static int shoesr;
    public static int shoesg;
    public static int shoesb;
    public static boolean hattype = false;
    public static int hatr;
    public static int hatg;
    public static int hatb;
    
    Object Dog = new Object("Dog",Puppy,Grass,20, Ball, dogSound);
    Object Racecar = new Object("Racecar",F1Car,Road,30, Finish, carSound);
    Object Jet = new Object("Jet",Jetplane,Sky,40, Tanker, jetSound);
            
    
    public static Image Screenshot1;
    
    
    public PlayBuild () {
        setBackground(Color.WHITE); 
        
        Image raw = new ImageIcon(getClass().getResource("/thadusv1/Images/Plus.png")).getImage();
        Image scaled = raw.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon Plussign = new ImageIcon(scaled);
        setLayout(null);
        ObjectsButton = new JButton (Plussign);
       
        
        ObjectsButton.setContentAreaFilled(false);
        ObjectsButton.setOpaque(false);
        ObjectsButton.setBorderPainted(false);
                
        
        objects = new JPopupMenu();
        Title = new JMenuItem("Select object");
        Title.setFont(new Font("Arial", Font.PLAIN,14));
        Title.setEnabled(false);
        Dog2 = new JMenuItem("Dog 🐶");
        Racecar2 = new JMenuItem("Race car 🏎️");
        Jet2 = new JMenuItem("Jet ✈️");
        Title3 = new JMenuItem("Variables to add");
        Title3.setFont(new Font("Arial", Font.PLAIN,14));
        Title3.setEnabled(false);
        skin = new JMenuItem("Skin");
        skin.setEnabled(false);
        eyes = new JMenuItem("Eyes");
        eyes.setEnabled(false);
        eyebrows = new JMenuItem("Eyebrows");
        eyebrows.setEnabled(false);
        nose = new JMenuItem("Nose");
        nose.setEnabled(false);
        mouth = new JMenuItem("Mouth");
        mouth.setEnabled(false);
        hair = new JMenuItem("Hair");
        hair.setEnabled(false);
        shirt = new JMenuItem("Shirt");
        shirt.setEnabled(false);
        longsleeve = new JMenuItem("Longsleeve");
        longsleeve.setEnabled(false);
        pants = new JMenuItem("Pants");
        pants.setEnabled(false);
        shorts = new JMenuItem("Shorts");
        shorts.setEnabled(false);
        shoes = new JMenuItem("Shoes");
        shoes.setEnabled(false);
        socks = new JMenuItem("Socks");
        socks.setEnabled(false);
        cap = new JMenuItem("Cap");
        cap.setEnabled(false);
        
        
        
        
        
        
        
         
       ObjectsButton.addActionListener(e -> {
    
       objects.show(ObjectsButton, 0, ObjectsButton.getHeight());
       });
       
       Dog2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dogselect = true;
        carselect = false;
        jetselect = false;
    }
});
       
     Racecar2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dogselect = false;
        carselect = true;
        jetselect = false;
    }
});  
    Jet2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dogselect = false;
        carselect = false;
        jetselect = true;
    }
});     
    
    
        Image raw4 = new ImageIcon(getClass().getResource("/thadusv1/Images/Reset.png")).getImage();
        Image scaled4 = raw4.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        ImageIcon Resetsign = new ImageIcon(scaled4);
        setLayout(null);
        ResetButton = new JButton (Resetsign);
       
       
        ResetButton.setContentAreaFilled(false);
        ResetButton.setOpaque(false);
        ResetButton.setBorderPainted(false);
    
    
    
    
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               a = 35;
               b = 20;
               straight = false;
               curly = false;
               shaggy = false;
               skintype = false;
               browstype = false;
               eyestype = false;
               nosetype = false;
               smile = false;
               happy = false;
               frown = false;
               neutral = false;
               sad = false;
               sleevetype = false;
               shirttype = false;
               pantstype = false;
               sockstype = false;
               shortstype = false;
               shoestype = false;
               hattype = false;
               playBuildPanel.repaint();
               
            }
        });
    
        
        if (dogselect == false && carselect == false && jetselect == false) {
             try {
               if (sound) {
               introMusic = AudioSystem.getAudioInputStream(getClass().getResource("/thadusv1/Sounds/Intro.wav"));
               
               }
           } catch (Exception e) {
           e.printStackTrace();
}
        } 
        
        
        Image raw5 = new ImageIcon(getClass().getResource("/thadusv1/Images/Triangle.png")).getImage();
        Image scaled5 = raw5.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon triangle = new ImageIcon(scaled5);
        setLayout(null);
        modeButton = new JButton (triangle);
       
       
        modeButton.setContentAreaFilled(false);
        modeButton.setOpaque(false);
        modeButton.setBorderPainted(false);
        
        JPopupMenu modes = new JPopupMenu();
        JMenuItem Title2 = new JMenuItem("Select mode");
        Title2.setFont(new Font("Arial", Font.PLAIN,14));
        Title2.setEnabled(false);
        JMenuItem playmode = new JMenuItem("Play mode ⛳");
        JMenuItem buildmode = new JMenuItem("Build mode️ 👷🏾‍️");
        
        
        modes.add(Title2);
        modes.add(playmode);
        modes.add(buildmode);
        
        
         
       modeButton.addActionListener(e -> {
    
       modes.show(modeButton, 0, modeButton.getHeight());
       });
       
       playmode.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        playmodeselect = true;
        buildmodeselect = false;
        menu = false;
    }
});     
       
       buildmode.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        buildmodeselect = true;
        playmodeselect = false;
        menu = false;
    }
});     
       
       Image raw6 = new ImageIcon(getClass().getResource("/thadusv1/Images/brush.png")).getImage();
        Image scaled6 = raw6.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon brush = new ImageIcon(scaled6);
        setLayout(null);
        colourButton = new JButton (brush);
       
       
        colourButton.setContentAreaFilled(false);
        colourButton.setOpaque(false);
        colourButton.setBorderPainted(false);
       
       
       colourButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ColourPicker.colourpicker();
    }
});     
        
        
        
        Image raw7 = new ImageIcon(getClass().getResource("/thadusv1/Images/camera.png")).getImage();
        Image scaled7 = raw7.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon camera = new ImageIcon(scaled7);
        setLayout(null);
        photoButton = new JButton (camera);
       
       
        photoButton.setContentAreaFilled(false);
        photoButton.setOpaque(false);
        photoButton.setBorderPainted(false);
       
        photoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   Screenshot.takeScreenshot();
                   
       
        }
    
       
        });
        
        pointslabel = new JLabel("Pts: " + points);
        pointslabel.setFont(new Font("Arial",Font.PLAIN,16));
        pointslabel.setForeground(Color.red);
        
    }
                
                
              
       
       
       

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pointslabel.setText("Pts: " + user1.getPoints());
        
        
         ObjectsButton.setSize(50,50);
         ResetButton.setSize(50,50);
         modeButton.setSize(50,50);
         colourButton.setSize(50,50);
         photoButton.setSize(50,50);
         setLayout(new BorderLayout());
         add(ObjectsButton, BorderLayout.NORTH);
         add(ResetButton, BorderLayout.EAST);
         add(modeButton, BorderLayout.WEST);
         
         
         
        
        if (x == -1 && y == -1) {
            x = random.nextInt((getWidth()));
            y = random.nextInt((getHeight()));
            
            if (a >= x-20 && a <= x+20 && b >= y -20 && b<= y+20) {
                x = random.nextInt((getWidth()));
                y = random.nextInt((getHeight()));
            }
            
        }
        
        if (menu) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.BOLD,16));
            g.drawString("Welcome to Thadus PlayBuild!", 100, 100);
            g.drawString("Click on the triangle button to select the mode", 100, 120);
            g.setFont(new Font("Arial",Font.PLAIN,16));
            g.drawString("Play mode - code objects to targets", 100, 160);
            g.drawString("Build mode - create your own avatar objects", 100, 180);
        }
        
        
        
        
        
        
        if (playmodeselect) {
            
            remove(photoButton);
            remove(colourButton);
            add(pointslabel, BorderLayout.SOUTH);
            
            objects.remove(Title3);
            objects.remove(skin);
            objects.remove(eyebrows);
            objects.remove(eyes);
            objects.remove(nose);
            objects.remove(mouth);
            objects.remove(hair);
            objects.remove(shirt);
            objects.remove(longsleeve);
            objects.remove(pants);
            objects.remove(shorts);
            objects.remove(shoes);
            objects.remove(socks);
            objects.remove(cap);
            objects.add(Title);
            objects.add(Dog2);
            objects.add(Racecar2);
            objects.add(Jet2);
            
            
        
        if (dogselect) {
            g.setColor(Color.black);
            g.drawImage(Dog.getObjectBackground(), 0, 0, playBuildPanel.getWidth(), playBuildPanel.getHeight(), Color.white, this);
            g.drawImage(Dog.getObjectImage(), a, b, 50, 50, this); 
            g.drawImage(Dog.getObjectTarget(), x, y, 50, 50, this);
            clip1.stop();
        } else if (carselect) {
            g.setColor(Color.black);
            g.drawImage(Racecar.getObjectBackground(), 0, 0, playBuildPanel.getWidth(), playBuildPanel.getHeight(), Color.white, this);
            g.drawImage(Racecar.getObjectImage(), a, b, 50, 50, this); 
            g.drawImage(Racecar.getObjectTarget(), x, y, 50, 50, this);
            clip1.stop();
        } else if (jetselect) {
            g.setColor(Color.black);
            g.drawImage(Jet.getObjectBackground(), 0, 0, playBuildPanel.getWidth(), playBuildPanel.getHeight(), Color.white, this);
            g.drawImage(Jet.getObjectImage(), a, b, 50, 50, this); 
            g.drawImage(Jet.getObjectTarget(), x, y, 50, 50, this);
            clip1.stop();
        } else {
            g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.BOLD,16));
            g.drawString("Play mode", 100, 100);
            g.drawString("Click on the Plus Button to select your object", 100, 120);
            g.drawString("Code the object to the target!", 100, 140);
            g.setFont(new Font("Arial",Font.PLAIN,16));
            g.drawString("Some objects are faster than others...", 100, 180);
            
        }
        
        
        }
        
        if (buildmodeselect) {
            add(photoButton, BorderLayout.EAST);
            remove(pointslabel);
            g.drawImage(Runway, 0, 0, playBuildPanel.getWidth(), playBuildPanel.getHeight(), Color.white, this);
            
            
            add(colourButton, BorderLayout.SOUTH);
            objects.remove(Title);
            objects.remove(Dog2);
            objects.remove(Racecar2);
            objects.remove(Jet2);
            objects.add(Title3);
            objects.add(skin);
            objects.add(eyebrows);
            objects.add(eyes);
            objects.add(nose);
            objects.add(mouth);
            objects.add(hair);
            objects.add(shirt);
            objects.add(longsleeve);
            objects.add(pants);
            objects.add(shorts);
            objects.add(shoes);
            objects.add(socks);
            objects.add(cap);

            
            g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.BOLD,16));
            g.drawString("Build mode", 100, 100);
            g.setFont(new Font("Arial",Font.PLAIN,16));
            g.drawString("Start building your avatar with code", 100, 120);
            g.drawString("Add skin, hair and other variables", 100, 140);
            g.drawString("Click the Plus Button for variable recommendations", 100, 160);
            
            
            int[] rightarmx = {336, 380, 380, 336};
            int [] rightarmy = {265,335,360, 300};
            
            int[] leftarmx = {280, 236, 236, 280};
            int [] leftarmy = {265, 335, 360, 300};
            
            int[] sleevedshirtx = {336,380,380, 336, 336,280,280,236,236,280};
            int[] sleevedshirty = {265,335,360,300,345,345,300,360,335,265};
            
            int[] shirtx = {336,360, 336, 336,280,280,256,280};
            int[] shirty = {265,300,300,345,345,300,300,265};
            
            int[] hatbx = {284,293,316,324};
            int[] hatby = {208,202,202,208};
            
           
            
            g.drawOval(280, 200, 50, 50); //head
            g.drawRect(296, 250, 19, 15); //neck
            
            g.drawRect(280, 265, 56, 80); //body
            g.drawRect(280, 345, 28, 80); //left leg
            g.drawRect(308, 345, 28, 80); // right leg
            g.drawOval(280, 425, 30, 30); // left foot
            g.drawOval(308, 425, 30, 30); // right foot
            g.drawPolygon(rightarmx, rightarmy, rightarmx.length); //right arm
            g.drawOval(380, 338, 20, 20); // right hand
            g.drawPolygon(leftarmx, leftarmy, leftarmx.length); // left arm
            g.drawOval(216, 338, 20, 20); // left hand
            g.drawOval(330, 225, 10, 10); // right ear
            g.drawOval(270, 225, 10, 10); //left ear
           
            
            if (skintype) {
                 g.setColor(new Color(skinr,sking,skinb));
                 g.fillOval(280, 200, 50, 50); //head
                 g.fillRect(296, 250, 19, 15); //neck
                 g.fillRect(280, 265, 56, 80); //body
                 g.fillRect(280, 345, 28, 80); //left leg
                 g.fillRect(308, 345, 28, 80); // right leg
                 g.fillOval(280, 425, 30, 30); // left foot
                 g.fillOval(308, 425, 30, 30); // right foot
                 g.fillPolygon(rightarmx, rightarmy, rightarmx.length); //right arm
                 g.fillOval(380, 338, 20, 20); // right hand
                 g.fillPolygon(leftarmx, leftarmy, leftarmx.length); // left arm
                 g.fillOval(216, 338, 20, 20); // left hand
                 g.fillOval(330, 225, 10, 10); // right ear
                 g.fillOval(270, 225, 10, 10); //left ear
                 
                 objects.remove(skin);
                 
            }
            
           
            
            
            
            
            
            if (straight) {
                g.setColor(new Color(hairr,hairg,hairb));
                int i = 1;
                int x = 288;
                int y = 205;
                while (i < 20) {
                    g.drawLine(x, y, x, y-15);
                    x = x +2;
                    if (x >= 308) {
                        y = y + 1;
                    } else {
                        y = y-1;
                    }
                    i++;
                }
                objects.remove(hair);

            }
            
            if (curly) {
                g.setColor(new Color(hairr,hairg,hairb));
                int i = 1;
                int x = 288;
                int y = 195;
                while (i < 18) {
                    g.drawOval(x, y, 10, 10);
                    x = x +2;
                    i++;
                }
                objects.remove(hair);
            }
            
            if (shaggy) {
                g.setColor(new Color(hairr,hairg,hairb));
                int i = 1;
                int x = 284;
                int y = 242;
                int a = 15;
                while (i < 24) {
                    if (x <= 298 || x >= 315) {
                     g.drawLine(x, y, x, y + a);
                     
                    if (x >= 308) {
                        y = y-1;
                    } else {
                        y = y + 1;
                    }   
                    } else {
                        y = 248;
                    }
                x = x +2;
                i++;
               
        }
                objects.remove(hair);
        
    }
            
            
            if(browstype) {
                g.setColor(new Color(hairr,hairg,hairb));
                g.drawArc(290, 220,15, 15, 45, 90);
                g.drawArc(305, 220,15, 15, 45, 90);
                
                objects.remove(eyebrows);
            }
            
            if (eyestype) {
                g.setColor(new Color(eyesr,eyesg,eyesb));
                g.drawArc(292, 225,10, 10, 45, 90);
                g.fillArc(292, 225,10, 10, 45, 90);
                g.drawArc(292, 220,10, 10, -45, -90);
                g.fillArc(292, 220,10, 10, -45, -90); // left eye
                
                g.drawArc(307, 225,10, 10, 45, 90);
                g.fillArc(307, 225,10, 10, 45, 90);
                g.drawArc(307, 220,10, 10, -45, -90);
                g.fillArc(307, 220,10, 10, -45, -90); // right eye
                
                objects.remove(eyes);
            }
            
            if (nosetype) {
                g.setColor(new Color(noser,noseg,noseb));
                g.drawLine(305, 230, 305, 233);
                
                objects.remove(nose);
            }
            
            
            if (smile) {
                g.setColor(new Color(mouthr,mouthg,mouthb));
                g.drawArc(295, 223, 20, 20, -45, -90);
                
                objects.remove(mouth);
            }
            
            if (happy) {
                g.setColor(new Color(mouthr,mouthg,mouthb));
                g.drawArc(295, 223, 20, 20, -180, 180);
                g.fillArc(295, 223, 20, 20, -180, 180);
                
                objects.remove(mouth);
            }
            
            if (frown) {
                g.setColor(new Color(mouthr,mouthg,mouthb));
                g.drawArc(295, 240, 20, 20, 45, 90 );
                
                objects.remove(mouth);
            }
            
            if (neutral) {
                g.setColor(new Color(mouthr,mouthg,mouthb));
                g.drawLine(300, 240, 310, 240);
                
                objects.remove(mouth);
            }
            
            if (sad) {
                g.setColor(new Color(mouthr,mouthg,mouthb));
                g.drawArc(295, 236, 20, 20, 180, -180);
                g.fillArc(295, 236, 20, 20, 180, -180);
                
                objects.remove(mouth);
            }
            
            if (sleevetype) {
                g.setColor(new Color(sleever,sleeveg,sleeveb));
                g.fillPolygon(sleevedshirtx, sleevedshirty, sleevedshirtx.length);
                
                objects.remove(longsleeve);
            }
            
            if (shirttype) {
                g.setColor(new Color(shirtr,shirtg,shirtb));
                g.fillPolygon(shirtx, shirty, shirtx.length);
                
                objects.remove(shirt);
            }
            
            if (pantstype) {
                g.setColor(new Color(pantsr,pantsg,pantsb));
                g.fillRect(280, 345, 28, 80); //left leg
                g.fillRect(308, 345, 28, 80); // right leg
                g.setColor(Color.black);
                g.drawLine(308, 345, 308, 425);
                
                objects.remove(pants);
            }
            
            if (shortstype) {
                g.setColor(new Color(shortsr,shortsg,shortsb));
                g.fillRect(280, 345, 28, 40); //left leg
                g.fillRect(308, 345, 28, 40); // right leg
                g.setColor(Color.black);
                g.drawLine(308, 345, 308, 425);
                
                objects.remove(shorts);
            }
            
            if (sockstype) {
                g.setColor(new Color(socksr,socksg,socksb));
                g.fillRect(280, 405, 28, 20); //left leg
                g.fillRect(308, 405, 28, 20); // right leg
                g.setColor(Color.black);
                g.drawLine(308, 345, 308, 425);
                
                objects.remove(socks);
            }
            
            if (shoestype) {
                g.setColor(new Color(shoesr,shoesg,shoesb));
                g.fillOval(280, 425, 30, 30); // left foot
                g.fillOval(308, 425, 30, 30); // right foot
                
                objects.remove(shoes);
            }
            
            if(hattype) {
                g.setColor(Color.black);
                g.drawArc(284, 190, 40,40, 180, -180);
                g.setColor(new Color(hatr,hatg,hatb));
                g.fillArc(284, 190, 40, 40, 180, -180);
                g.setColor(Color.black);
                g.drawPolygon(hatbx, hatby, hatbx.length);
                g.setColor(new Color(hatr,hatg,hatb));
                g.fillPolygon(hatbx, hatby, hatbx.length);
                
                objects.remove(cap);
            }
            
            
            
            
            
            
            
   }
        
    }
    
    
    
    
    
    
    public void playMode(String response) {
        
        
        
        
        
        if (dogselect && sound && (response.contains("moveUp") || response.contains("moveDown") || response.contains("moveLeft") || response.contains("moveRight"))) {
            try {
               dogSound = AudioSystem.getAudioInputStream(getClass().getResource("/thadusv1/Sounds/dog.wav"));
              
           } catch (Exception e) {
           e.printStackTrace();
}
        }
        
        if (carselect && sound && (response.contains("moveUp") || response.contains("moveDown") || response.contains("moveLeft") || response.contains("moveRight"))) {
            try {
               carSound = AudioSystem.getAudioInputStream(getClass().getResource("/thadusv1/Sounds/car.wav"));
               
               
           } catch (Exception e) {
           e.printStackTrace();
}
        }
        
        if (jetselect && sound && (response.contains("moveUp") || response.contains("moveDown") || response.contains("moveLeft") || response.contains("moveRight"))) {
            try {
               jetSound = AudioSystem.getAudioInputStream(getClass().getResource("/thadusv1/Sounds/jet.wav"));
               
           } catch (Exception e) {
           e.printStackTrace();
}
        }
        
        
        
        
        
        
        
        
        if (response.contains("moveUp")) {
            response = response.replace(objectname, "").replace("moveUp(", "").replace(")","").trim();
            
            int movement = Integer.parseInt(response);
            if (dogselect) {
                movement = movement * Dog.getObjectSpeed();
            }
            if (carselect) {
                movement = movement * Racecar.getObjectSpeed();
            }
            if (jetselect) {
                movement = movement * Jet.getObjectSpeed();
            }
            
            
            b = b - movement;
           
            repaint();
            
            
        }
        
        if (response.contains("moveDown")) {
            response = response.replace(objectname, "").replace("moveDown(", "").replace(")","").trim();
            int movement = Integer.parseInt(response);
            if (dogselect) {
                movement = movement * Dog.getObjectSpeed();
            }
            if (carselect) {
                movement = movement * Racecar.getObjectSpeed();
            }
            if (jetselect) {
                movement = movement * Jet.getObjectSpeed();
            }
            
            b = b + movement;
           
            repaint();
                    
        }
        
        if (response.contains("moveLeft")) {
            response = response.replace(objectname, "").replace("moveLeft(", "").replace(")","").trim();
            int movement = Integer.parseInt(response);
            if (dogselect) {
                movement = movement * Dog.getObjectSpeed();
            }
            if (carselect) {
                movement = movement * Racecar.getObjectSpeed();
            }
            if (jetselect) {
                movement = movement * Jet.getObjectSpeed();
            }
            
            a = a - movement;
           
            repaint();
                    
        }
        
        if (response.contains("moveRight")) {
            response = response.replace(objectname, "").replace("moveRight(", "").replace(")","").trim();
            int movement = Integer.parseInt(response);
            if (dogselect) {
                movement = movement * Dog.getObjectSpeed();
            }
            if (carselect) {
                movement = movement * Racecar.getObjectSpeed();
            }
            if (jetselect) {
                movement = movement * Jet.getObjectSpeed();
            }
            
            a = a + movement;
           
            repaint();
                    
        }
        
        if (a >= x-25 && a <= x+50 && b >= y -50 && b<= y+50) {
            Main.printToConsole("Good job! You got the target!");
            Main.printToConsole("Here's another challenge!");
            user1.setPoints(user1.getPoints()+1);
            try {
               if(sound) {
               winMusic = AudioSystem.getAudioInputStream(getClass().getResource("/thadusv1/Sounds/Win.wav"));
               
               }
           } catch (Exception e) {
           e.printStackTrace();
}
            
            x = -1;
            y = -1;
            a = 35;
            b = 20;
        }
        
        
     
    }
    
    
    public static void buildMode(String response) {
        if (response.contains("addHair")) {
            String hair = response;
            Pattern pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+)\\s+(\\w+)\\)");
            Matcher matcher = pattern.matcher(hair);
            if (matcher.find()) {
            hairtype = matcher.group(4);  
            }
            hairr = Integer.parseInt(matcher.group(1));
            hairg = Integer.parseInt(matcher.group(2));
            hairb = Integer.parseInt(matcher.group(3));
           
            if (hairtype.equals("straight")) {
                straight = true;
                curly = false;
                shaggy = false;
            }
            
            if (hairtype.equals("curly")) {
                curly = true;
                straight = false;
                shaggy = false;
            }
            
            if (hairtype.equals("long")) {
                shaggy = true;
                curly = false;
                straight = false;
            }
        }
        
        if(response.contains("addSkin")) {
            skintype = true;
            response = response.replace(objectname, "").replace("addSkin(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            skinr = Integer.parseInt(rgb[0]);
            sking = Integer.parseInt(rgb[1]);
            skinb = Integer.parseInt(rgb[2]);
                    
        }
        
        if (response.contains("addEyebrows")) {
            browstype = true;
            response = response.replace(objectname, "").replace("addEyebrows(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            browsr = Integer.parseInt(rgb[0]);
            browsg = Integer.parseInt(rgb[1]);
            browsb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addEyes")) {
            eyestype = true;
            response = response.replace(objectname, "").replace("addEyes(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            eyesr = Integer.parseInt(rgb[0]);
            eyesg = Integer.parseInt(rgb[1]);
            eyesb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addNose")) {
            nosetype = true;
            response = response.replace(objectname, "").replace("addNose(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            noser = Integer.parseInt(rgb[0]);
            noseg = Integer.parseInt(rgb[1]);
            noseb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addMouth")) {
            String mouth = response;
            Pattern pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+)\\s+(\\w+)\\)");
            Matcher matcher = pattern.matcher(mouth);
            if (matcher.find()) {
            mouthtype = matcher.group(4);  
            }
            mouthr = Integer.parseInt(matcher.group(1));
            mouthg = Integer.parseInt(matcher.group(2));
            mouthb = Integer.parseInt(matcher.group(3));
           
            if (mouthtype.equals("smile")) {
                smile = true;
                happy = false;
                frown = false;
                neutral = false;
                sad = false;
            }
            
            if (mouthtype.equals("happy")) {
                happy = true;
                smile = false;
                frown = false;
                neutral = false;
                sad = false;
                       
            }
            
            if (mouthtype.equals("frown")) {
                frown = true;
                smile = false;
                happy = false;
                neutral = false;
                sad = false;
            }
            
            if (mouthtype.equals("neutral")) {
                neutral = true;
                frown = false;
                smile = false;
                happy = false;
                sad = false;
            }
            
            if (mouthtype.equals("sad")) {
                sad = true;
                frown = false;
                smile = false;
                happy = false;
                neutral = false;
             
            }
            
            
        }
        
        
        if (response.contains("addLongsleeve")) {
            sleevetype = true;
            response = response.replace(objectname, "").replace("addLongsleeve(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            sleever = Integer.parseInt(rgb[0]);
            sleeveg = Integer.parseInt(rgb[1]);
            sleeveb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addShirt")) {
            shirttype = true;
            response = response.replace(objectname, "").replace("addShirt(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            shirtr = Integer.parseInt(rgb[0]);
            shirtg = Integer.parseInt(rgb[1]);
            shirtb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addPants")) {
            pantstype = true;
            response = response.replace(objectname, "").replace("addPants(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            pantsr = Integer.parseInt(rgb[0]);
            pantsg = Integer.parseInt(rgb[1]);
            pantsb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addShorts")) {
            shortstype = true;
            response = response.replace(objectname, "").replace("addShorts(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            shortsr = Integer.parseInt(rgb[0]);
            shortsg = Integer.parseInt(rgb[1]);
            shortsb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addSocks")) {
            sockstype = true;
            response = response.replace(objectname, "").replace("addSocks(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            socksr = Integer.parseInt(rgb[0]);
            socksg = Integer.parseInt(rgb[1]);
            socksb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addShoes")) {
            shoestype = true;
            response = response.replace(objectname, "").replace("addShoes(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            shoesr = Integer.parseInt(rgb[0]);
            shoesg = Integer.parseInt(rgb[1]);
            shoesb = Integer.parseInt(rgb[2]);
        }
        
        if (response.contains("addCap")) {
            hattype = true;
            response = response.replace(objectname, "").replace("addCap(","").replace(")","").trim();
            String [] rgb = response.split(",");
            
            hatr = Integer.parseInt(rgb[0]);
            hatg = Integer.parseInt(rgb[1]);
            hatb = Integer.parseInt(rgb[2]);
        }
        
        
        
            
        
        
            
        
    }
    
    

    
    
    
    
    
    
    
    
    
}

