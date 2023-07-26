import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Main extends JFrame {
    private JPanel buttonPanel;

    public Main(){
        buttonPanel = new JPanel();
        add(buttonPanel);
        pack();

        // Metal
        JButton metal = new JButton("Metal");
        buttonPanel.add(metal);
        metal.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Nimbus
        JButton nimbus = new JButton("Nimbus");
        buttonPanel.add(nimbus);
        nimbus.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Motif
        JButton motif = new JButton("Motif");
        buttonPanel.add(motif);
        motif.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // GTK (only works on Unix or Linux)
        JButton gtk = new JButton("Gtk");
        buttonPanel.add(gtk);
        gtk.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
      
       /*
       Recommended not to use this Look and feel which are commnted 
        // Windows (only works on Windows)
        JButton windows = new JButton("Windows");
        buttonPanel.add(windows);
        windows.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
       JButton systemDefault = new JButton("System Default");
       buttonPanel.add(systemDefault);
       systemDefault.addActionListener(event -> {
           try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                 SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
            e.printStackTrace();
            }
          });
          
       JButton macbook = new JButton("Macbook");
       buttonPanel.add(macbook);
       macbook.addActionListener(event -> {
           try {
                UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");
                 SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
            e.printStackTrace();
            }
          });
          */
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

/*
javax.swing.plaf.metal.MetalLookAndFeel
System
Motif
GTK
nimbus
java.swing.plaf.gtk.GTKLookAndFeel
java.swing.plaf.windows.WindowsLookAndFeel
javax.swing.plaf.metal.MetalLookAndFeel


You can even import other third party look-and-feel theme

Synthetica: A commercial library offering many different themes.

Substance: An open-source library providing a large set of different themes.

JGoodies: They offer a few free LookAndFeel themes.

WebLookAndFeel: This provides a LookAndFeel that imitates modern web styles.

Insubstantial: This is a fork of Substance and Flamingo, two projects that were originally created by Kirill Grouchnikov and are now inactive.

*/
