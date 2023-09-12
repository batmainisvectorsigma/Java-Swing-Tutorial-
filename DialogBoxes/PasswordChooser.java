
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.*;

public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser() {
        setLayout(new BorderLayout());

        // construct a panel with user name and password fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("User name:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Password:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        // create Ok and Cancel buttons that terminate the dialog
        okButton = new JButton("Ok");
        okButton.addActionListener(event -> {
            ok = true;
            dialog.setVisible(false);
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dialog.setVisible(false));

        // add buttons to southern border
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setUser(User u) {
        username.setText(u.getName());
    }

    public User getUser() {
        return new User(username.getText(), password.getPassword());
    }

    public boolean showDialog(Component parent, String title) {
        ok = false;

        Frame owner = null;
        if (parent instanceof Frame) owner = (Frame) parent;
        else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }

    public static class User {
        private String name;
        private char[] password;

        public User(String name, char[] password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public char[] getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Password Chooser Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JButton button = new JButton("Show Password Chooser");
            button.addActionListener(e -> {
                PasswordChooser chooser = new PasswordChooser();
                if (chooser.showDialog(frame, "Enter Password")) {
                    User user = chooser.getUser();
                    System.out.println("User Name: " + user.getName());
                    System.out.println("Password: " + new String(user.getPassword()));
                }
            });
            
            frame.getContentPane().add(button);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
