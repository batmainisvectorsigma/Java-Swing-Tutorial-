import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChooserPanel extends JPanel {
    public ColorChooserPanel() {
        JButton modalButton = new JButton("Modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        JButton modelessButton = new JButton("Modeless");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);

        JButton immediateButton = new JButton("Immediate");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    private class ModalListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background", defaultColor);
            if (selected != null) setBackground(selected);
        }
    }

    private class ModelessListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ModelessListener() {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color",
                    false /* not modal */, chooser,
                    event -> setBackground(chooser.getColor()),
                    null /* no Cancel button listener */);
        }

        public void actionPerformed(ActionEvent event) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

    private class ImmediateListener implements ActionListener {
        private JDialog dialog;
        private JColorChooser chooser;

        public ImmediateListener() {
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(event -> setBackground(chooser.getColor()));
            dialog = new JDialog((Frame) null, false /* not modal */);
            dialog.add(chooser);
            dialog.pack();
        }

        public void actionPerformed(ActionEvent event) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Chooser Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        
        ColorChooserPanel panel = new ColorChooserPanel();
        frame.add(panel);
        
        frame.setVisible(true);
    }
}
