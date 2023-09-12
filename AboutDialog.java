import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About Dialog", true);
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));

        JLabel label = new JLabel("This is the About Dialog!");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(ok, BorderLayout.SOUTH);
        
        add(panel);

        pack();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame owner = new JFrame();
            AboutDialog dialog = new AboutDialog(owner);
            dialog.setTitle("Dialog Test");
            dialog.setVisible(true);
        });
    }       
}
