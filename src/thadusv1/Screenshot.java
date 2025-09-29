/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thadusv1;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static thadusv1.Login.user1;
import static thadusv1.Main.playBuildPanel;
import static thadusv1.PlayBuild.Screenshot1;

/**
 *
 * @author netha
 */
public class Screenshot {
    public static boolean screenshotted = false;
    
    public static void takeScreenshot() {
    try {
        // Get the location of the target panel on the screen
        Point p = playBuildPanel.getLocationOnScreen();

        // Define polygon coordinates relative to the panel location
        int[] xPoints = {282, 326, 407, 330, 282, 206, 282};
        int[] yPoints = {195, 195, 338, 455, 455, 338, 195};

        // Shift polygon by the panel's screen position
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] += p.x;
            yPoints[i] += p.y;
        }

        Polygon poly = new Polygon(xPoints, yPoints, xPoints.length);

        // Get bounding rectangle of the polygon
        Rectangle bounds = poly.getBounds();

        // Capture rectangular screenshot that covers polygon
        Robot robot = new Robot();
        BufferedImage screen = robot.createScreenCapture(bounds);

        // Prepare output image with transparency
        BufferedImage masked = new BufferedImage(
                bounds.width, bounds.height,
                BufferedImage.TYPE_INT_ARGB
        );

        // Shift polygon to align with the new cropped image
        Polygon shiftedPoly = new Polygon(
                shiftArray(xPoints, -bounds.x),
                shiftArray(yPoints, -bounds.y),
                xPoints.length
        );

        // Draw only polygon region
        Graphics2D g2d = masked.createGraphics();
        g2d.setClip(shiftedPoly);
        g2d.drawImage(screen, 0, 0, null);
        g2d.dispose();

        // Save file
        File screenshots = new File("Screenshots");
        if (!screenshots.exists()) {
            screenshots.mkdirs();
        }
        File outputFile = new File(screenshots, "myavatarobject.png");
        ImageIO.write(masked, "png", outputFile);

        JOptionPane.showMessageDialog(playBuildPanel,
                "Screenshot saved to: " + outputFile.getAbsolutePath());

        // Load into ImageIcon
        Screenshot1 = new ImageIcon(outputFile.getAbsolutePath()).getImage();
        screenshotted = true;
        user1.setAvatar(Screenshot1);

    } catch (AWTException | IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(playBuildPanel,
                "Error taking screenshot: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private static int[] shiftArray(int[] arr, int shift) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[i] + shift;
    }
    return result;
}


    
}
