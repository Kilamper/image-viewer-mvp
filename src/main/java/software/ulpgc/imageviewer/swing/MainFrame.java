package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.image.ImageDisplay;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    public MainFrame(){
        ImageIcon icon = new ImageIcon("src/main/resources/Image_Viewer.png");
        this.setTitle("Image Viewer (Mobile Version)");
        this.setIconImage(icon.getImage());
        this.setSize(getToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createImageDisplay());
    }

    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }
}
