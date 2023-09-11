import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;
    private JFrame frame;

    public ComboBoxFrame() {
        frame = new JFrame();  // Initialize the frame object first.

        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        frame.add(label, BorderLayout.CENTER);

        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("MonoSpaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        faceCombo.addActionListener(event ->
            label.setFont(
                new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                    Font.PLAIN, DEFAULT_SIZE)
            )
        );

        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        frame.add(comboPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 150);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String args[]) {
        new ComboBoxFrame();
    }
}


//wkrjg
