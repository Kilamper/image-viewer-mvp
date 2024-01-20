package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.image.ImageDisplay;
import software.ulpgc.imageviewer.image.Resizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private final List<PaintOrder> orders;
    private BufferedImage bitmap;
    private int shiftStart;
    private Dragged dragged = Dragged.Null;
    private Released released = Released.Null;

    public SwingImageDisplay() {
        this.orders = new ArrayList<>();
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(mouseMotionListener());
    }

    private MouseMotionListener mouseMotionListener() {
        return new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                dragged.to(e.getX() - shiftStart);
            }

            public void mouseMoved(MouseEvent e) { }
        };
    }

    private MouseListener mouseListener() {
        return new MouseListener() {
            public void mouseClicked(MouseEvent e) {}

            public void mousePressed(MouseEvent e) {
                shiftStart = e.getX();
            }

            public void mouseReleased(MouseEvent e) {
                released.at(e.getX() - shiftStart);
            }

            public void mouseEntered(MouseEvent e) { }

            public void mouseExited(MouseEvent e) { }
        };
    }

    @Override
    public int width() {
        return this.getWidth();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,getWidth(), getHeight());
        for (PaintOrder order : orders) {
            bitmap = load(order.image);
            Resizer resizer = new Resizer(bitmap);
            BufferedImage resized = resizer.resize(scaleFactor());
            int x = (this.getWidth() - resized.getWidth()) / 2;
            int y = (this.getHeight() - resized.getHeight()) / 2;
            g.drawImage(resized, x + order.offset, y, null);
        }
    }

    private BufferedImage load(String name) {
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        orders.clear();
        repaint();
    }

    @Override
    public void paint(String image, int offset) {
        orders.add(new PaintOrder(image, offset));
        repaint();
    }

    @Override
    public void on(Dragged dragged) {
        this.dragged = dragged != null ? dragged : Dragged.Null;
    }

    @Override
    public void on(Released released) {
        this.released = released != null ? released : Released.Null;
    }

    private record PaintOrder(String image, int offset) {}

    private double scaleFactor() {
        double widthFactor = (double) this.getWidth() / bitmap.getWidth();
        double heightFactor = (double) this.getHeight() / bitmap.getHeight();
        return min(widthFactor, heightFactor);
    }
}
