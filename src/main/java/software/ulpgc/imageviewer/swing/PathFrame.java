package software.ulpgc.imageviewer.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PathFrame extends JFrame implements ActionListener {
    private String path;
    private JTextField textField;
    private JButton accept;
    private JButton cancel;
    private JButton select;

    public PathFrame() {
        ImageIcon icon = new ImageIcon("src/main/resources/Image_Viewer.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Image Viewer (Desktop Version)");
        this.setSize(380, 160);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(createPanel());
    }

    private Component createPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Select a directory:");
        label.setBounds(10, 10, 200, 30);
        this.add(label);
        textField = new JTextField();
        textField.setBounds(10, 40, 300, 25);
        this.add(textField);
        this.add(createAcceptButton());
        this.add(createCancelButton());
        this.add(createSelectButton());
        return panel;
    }

    private Component createAcceptButton() {
        accept = new JButton("Accept");
        accept.setBounds(10, 75, 80, 25);
        accept.addActionListener(this);
        return accept;
    }

    private Component createCancelButton() {
        cancel = new JButton("Cancel");
        cancel.setBounds(100, 75, 80, 25);
        cancel.addActionListener(this);
        return cancel;
    }

    private Component createSelectButton() {
        ImageIcon icon = new ImageIcon("src/main/resources/Select_Folder.png");
        select = new JButton("");
        select.setIcon(icon);
        select.setBounds(310, 40, 40, 25);
        select.addActionListener(this);
        return select;
    }

    private void createFileChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("/C:/Users/-/Pictures/"));
        chooser.setDialogTitle("Select a folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.textField.setText(chooser.getSelectedFile().getPath());
        }
    }

    public String getPath() {
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        File file = new File(text);
        if (file.isDirectory() && e.getSource() == accept) {
            this.path = text;
        } else if (e.getSource() == cancel) {
            System.exit(0);
        } else if (e.getSource() == select) {
            createFileChooser();
        }
    }
}
