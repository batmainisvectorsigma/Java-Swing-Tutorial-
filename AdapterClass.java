import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class Main implements WindowListener{
  public Main(){
    JFrame frame=new JFrame("Creating some frame");
    WindowListener listener=new Main();
    frame.addWindowListener(listener);
    frame.setSize(450,500);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Override the default close operation
    frame.setVisible(true);
  }

  public void windowClosing(WindowEvent e){
    int result = JOptionPane.showConfirmDialog((JFrame)e.getSource(), "Are you sure you want to exit?");
    if(result == JOptionPane.YES_OPTION){
      System.exit(0);
    }
  }
  
  // Other methods...
  public void windowOpened(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}

  public static void main(String args[]){
    Main object=new Main();
  }
}
/*
Explaination will be make in a short period 




*/
