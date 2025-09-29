package thadusv1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColourPicker {
    public static void colourpicker() {
        JFrame frame = new JFrame("Colour Picker");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JColorChooser colorChooser = new JColorChooser();

        
        for (AbstractColorChooserPanel accp : colorChooser.getChooserPanels()) {
            if (!accp.getDisplayName().equals("RGB")) {
                colorChooser.removeChooserPanel(accp);
            }
        }

       
        JPanel colorSquarePreview = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(colorChooser.getColor());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        colorSquarePreview.setPreferredSize(new Dimension(50, 50));
        colorChooser.setPreviewPanel(colorSquarePreview);

       
        colorChooser.getSelectionModel().addChangeListener(e -> colorSquarePreview.repaint());

        

        frame.setLayout(new BorderLayout());
        frame.add(colorChooser, BorderLayout.CENTER);
       

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}