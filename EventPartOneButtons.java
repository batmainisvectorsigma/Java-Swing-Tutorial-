import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class Main extends JFrame{
  private JPanel buttonPanel;
  private static final int DEFAULT_WIDTH=300;
  private static final int DEFAULT_HEIGHT=200;
  public Main(){
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    JButton yellowButton=new JButton("Yellow");
    JButton blueButton=new JButton("Blue");
    JButton redButton=new JButton("Red");

    buttonPanel=new JPanel();

    buttonPanel.add(yellowButton);
    buttonPanel.add(blueButton);
    buttonPanel.add(redButton);

    add(buttonPanel);

    ColorAction yellowAction=new ColorAction(Color.YELLOW);
    ColorAction blueAction=new ColorAction(Color.BLUE);
    ColorAction redAction=new ColorAction(Color.RED);

    yellowButton.addActionListener(yellowAction);
    blueButton.addActionListener(blueAction);
    redButton.addActionListener(redAction);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  private class ColorAction implements ActionListener{
    private Color backgroundColor;
    public ColorAction(Color c){
      backgroundColor=c;
    }
    public void actionPerformed(ActionEvent event){
      buttonPanel.setBackground(backgroundColor);
    }
  }
  public static void main(String args[]){
    Main object=new Main();
  }
}
//more explaination will be made tomorrow
