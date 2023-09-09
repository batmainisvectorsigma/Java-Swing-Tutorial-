import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
public class BorderFrame {
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;
    private JFrame frame;

    public BorderFrame() {
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        frame = new JFrame();

        addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched", BorderFactory.createEtchedBorder());
        addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
        addRadioButton("Empty", BorderFactory.createEmptyBorder());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Border types");
        buttonPanel.setBorder(titled);

        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(demoPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.pack();
    }

    public void addRadioButton(String buttonName, Border b) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(event -> demoPanel.setBorder(b));
        group.add(button);
        buttonPanel.add(button);
    }

    public static void main(String[] args) {
        new BorderFrame();
    }
}
