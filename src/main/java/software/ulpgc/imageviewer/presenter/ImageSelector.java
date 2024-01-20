package software.ulpgc.imageviewer.presenter;

import software.ulpgc.imageviewer.image.Image;

import static java.lang.Math.abs;

public class ImageSelector {
    private final int width;
    private final Image image;

    public ImageSelector(Image image, int width) {
        this.image = image;
        this.width = width;
    }

    public Image first(int offset) {
        return select(offset);
    }

    public Image second(int offset) {
        return offset < 0 ? select(offset).next() : select(offset).prev();
    }

    private Image select(int offset) {
        Image image = this.image;
        while (abs(offset) > width) {
            offset -= sign(offset) * width;
            image = offset < 0 ? image.next() : image.prev();
        }
        return image;
    }

    private int sign(int offset) {
        return offset < 0 ? -1 : 1;
    }
}
