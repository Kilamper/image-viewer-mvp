package software.ulpgc.imageviewer.image;

public interface Image {
    String name();

    Image prev();
    Image next();
}
