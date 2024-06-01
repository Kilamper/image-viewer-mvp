package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.image.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    public MainFrame() throws MalformedURLException {
        URL url = new URL("https://sunrust.org/wiki/images/a/a9/Gallery_icon.png");
        ImageIcon icon = new ImageIcon(url);
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
