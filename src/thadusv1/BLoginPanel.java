package thadusv1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BLoginPanel extends JPanel {

    private Image backgroundImage;

    public BLoginPanel(String imPath) {
        try {
            URL imageURL = getClass().getResource(imPath);
            if (imageURL == null) {
                // Fallback to file system
                File file = new File(imPath);
                if (file.exists()) {
                    backgroundImage = ImageIO.read(file);
                } else {
                    throw new IOException("File not found: " + file.getAbsolutePath());
                }
            }
            else {
                backgroundImage = ImageIO.read(imageURL);
            }
        } catch (Exception e) {
            System.err.println("Error loading background image:");
            e.printStackTrace();
            setBackground(new Color(231, 245, 255));
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(backgroundImage != null) {
            int x = (getWidth() - backgroundImage.getWidth(null)) / 2;
            int y = (getHeight() - backgroundImage.getHeight(null)) / 2;

            g.drawImage(backgroundImage, x, y, this);

            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }


}
