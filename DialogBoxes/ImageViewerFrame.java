import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            chooser.setCurrentDirectory(new File("."));
            // show file chooser dialog
            int result = chooser.showOpenDialog(ImageViewerFrame.this);
            // if image file accepted, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
                pack();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));

        // use a label to display the images
        label = new JLabel();
        add(label);

        // set up file chooser
        chooser = new JFileChooser();
        // accept all image files ending with .jpg, .jpeg, .gif
        javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);

        chooser.setAccessory(new JLabel() {
            {
                setPreferredSize(new Dimension(100, 100));
                setBorder(BorderFactory.createEtchedBorder());

                chooser.addPropertyChangeListener(event -> {
                    if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                        File file = (File) event.getNewValue();
                        if (file == null) {
                            setIcon(null);
                            return;
                        }
                        ImageIcon icon = new ImageIcon(file.getPath());
                        if (icon.getIconWidth() > getWidth()) {
                            icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
                        }
                        setIcon(icon);
                    }
                });
            }
        });

        chooser.setFileView(new FileView() {
            private javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "gif");
            private Icon icon = new ImageIcon("palette.gif");

            public Icon getIcon(File f) {
                if (!f.isDirectory() && filter.accept(f)) return icon;
                else return null;
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ImageViewerFrame frame = new ImageViewerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
