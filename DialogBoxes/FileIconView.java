import java.awt.BorderLayout;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

public class FileIconView extends FileView {
    private FileFilter filter;
    private Icon icon;

    /**
    * Constructs a FileIconView.
    * @param aFilter a file filter--all files that this filter accepts will be shown
    * with the icon.
    * @param anIcon--the icon shown with all accepted files.
    */
    public FileIconView(FileFilter aFilter, Icon anIcon) {
        filter = aFilter;
        icon = anIcon;
    }

    public Icon getIcon(File f) {
        if (!f.isDirectory() && filter.accept(f)) return icon;
        else return null;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("File Icon View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter textFileFilter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.setFileFilter(textFileFilter);

        // Use default icon for demonstration
        Icon txtIcon = UIManager.getIcon("FileView.textIcon");
        FileIconView iconView = new FileIconView(textFileFilter, txtIcon);
        chooser.setFileView(iconView);

        frame.setLayout(new BorderLayout());
        frame.add(chooser, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
