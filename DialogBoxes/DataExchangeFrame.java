import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DataExchangeFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {
        // Setup the main frame
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu fileMenu = new JMenu("File");
        mbar.add(fileMenu);

        JMenuItem connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(e -> connect());
        fileMenu.add(connectItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    private void connect() {
        if (dialog == null) {
            dialog = new PasswordChooser();
        }
        dialog.setUser(new User("yourname", null));
        if (dialog.showDialog(DataExchangeFrame.this, "Connect")) {
            User u = dialog.getUser();
            textArea.append("user name = " + u.getName() + ", password = " + new String(u.getPassword()) + "\n");
        }
    }

    public static void main(String[] args) {
        DataExchangeFrame frame = new DataExchangeFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // User class
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

    // PasswordChooser class
    public class PasswordChooser extends JDialog {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private boolean accepted = false;
        private User user;

        public PasswordChooser() {
            setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2));

            panel.add(new JLabel("Username:"));
            usernameField = new JTextField();
            panel.add(usernameField);

            panel.add(new JLabel("Password:"));
            passwordField = new JPasswordField();
            panel.add(passwordField);

            add(panel, BorderLayout.CENTER);

            JButton okButton = new JButton("OK");
            okButton.addActionListener(e -> {
                accepted = true;
                user = new User(usernameField.getText(), passwordField.getPassword());
                setVisible(false);
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(e -> setVisible(false));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);
            add(buttonPanel, BorderLayout.SOUTH);

            pack();
        }

        public void setUser(User u) {
            usernameField.setText(u.getName());
        }

        public User getUser() {
            return user;
        }

        public boolean showDialog(Component parent, String title) {
            setTitle(title);
            setModal(true);
            setLocationRelativeTo(parent);
            setVisible(true);
            return accepted;
        }
    }
}
