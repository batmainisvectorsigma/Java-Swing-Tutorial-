import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;

public class Main extends JFrame {
    private JPanel buttonPanel;

    public Main() {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels(); 
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        pack();
        setSize(450,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void makeButton(String name, String className) {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
/*
description of the code
call the staticUiManagersetLookAndFeel method and give it the name of the look-and-feel class that you want
Then call the static method, SwingUtilities.updateComponentTreeUI to refresh the entire set of components
Supply one component to that method it will find others

Example where you can switch to the motif look-and-feel in your program
String className="com.sun.java.swing.plaf.MofiflookAndFeel"
try{
  UIManager.setLookAndFeel(className);
  Swingutilites.updateComponentTreeUI(frame);
  pack();
  }
  catch(Exception e){
    e.printStackTrace();
    }
    To mention all installed look-and-feel implemetations call
    UIManager.LookAndFeelinfo[] infos=UIManager.getinstalledLookAndFeels();

    Using this below code you will g et the name and class name for each look and feel as 
    String name=infos[i].getName();
    String className=infos[i].getClassName();

    Here in our program we have used lambda expression to specify the button action
    















*/
