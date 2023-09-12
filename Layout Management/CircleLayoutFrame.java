import javax.swing.*;

public class CircleLayoutFrame extends JFrame {
    
    public CircleLayoutFrame() {
        setLayout(new CircleLayout());
        add(new JButton("Yellow"));
        add(new JButton("Blue"));
        add(new JButton("Red"));
        add(new JButton("Green"));
        add(new JButton("Orange"));
        add(new JButton("Fuchsia"));
        add(new JButton("Indigo"));
        pack();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CircleLayoutFrame frame = new CircleLayoutFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
