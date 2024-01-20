package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.image.FileImageLoader;
import software.ulpgc.imageviewer.image.Image;
import software.ulpgc.imageviewer.image.ImageDisplay;
import software.ulpgc.imageviewer.presenter.ImagePresenter;
import software.ulpgc.imageviewer.swing.MainFrame;
import software.ulpgc.imageviewer.swing.PathFrame;

import java.io.File;

public class Main {
    public static String root;
    public static void main(String[] args) {
        PathFrame pathFrame = new PathFrame();
        pathFrame.setVisible(true);
        while (root == null) {
            root = pathFrame.getPath();
        }
        pathFrame.setVisible(false);
        Image image = new FileImageLoader(new File(root)).load();
        MainFrame mainFrame = new MainFrame();
        ImageDisplay imageDisplay = mainFrame.imageDisplay();
        new ImagePresenter(image, imageDisplay);
        mainFrame.setVisible(true);

    }
}
