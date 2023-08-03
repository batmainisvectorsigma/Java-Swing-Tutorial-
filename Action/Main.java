import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
  private JPanel buttonPanel;
  private static final int DEFAULT_WIDTH=300;
  private static final int DEFAULT_HEIGHT=200;
  
  public Main(){
    setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    buttonPanel=new JPanel();

    Action yellowAction=new ColorAction("Yellow", Color.YELLOW);
    Action blueAction=new ColorAction("Blue", Color.BLUE);
    Action redAction=new ColorAction("Red", Color.RED);

    buttonPanel.add(new JButton(yellowAction));
    buttonPanel.add(new JButton(blueAction));
    buttonPanel.add(new JButton(redAction));

    add(buttonPanel);

    InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
    imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
    imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");

    ActionMap amap=buttonPanel.getActionMap();
    amap.put("panel.yellow", yellowAction);
    amap.put("panel.blue", blueAction);
    amap.put("panel.red", redAction); 
  }
  
  public class ColorAction extends AbstractAction{
    public ColorAction(String name, Color c){
      putValue(Action.NAME, name);
      putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
      putValue("color", c);
    }
    
    public void actionPerformed(ActionEvent event){
      Color c=(Color) getValue("color");
      buttonPanel.setBackground(c);
    }
  }
  
  public static void main(String args[]){
    Main object=new Main();
    object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    object.setVisible(true);
  }
}
