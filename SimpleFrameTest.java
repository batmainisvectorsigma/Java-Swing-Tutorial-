import java.awt.*;
import javax.swing.*;
public class SimpleFrameTest{
    public static void main(String args[]){
        EventQueue.invokeLater(()->{
            SimpleFrame frame=new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true);
            frame.setVisible(true);
    });
    }
}
class SimpleFrame extends JFrame{
  private static final int DEFAULT_WIDTH=300;
  private static final int DEFAULT_HEIGHT=200;
  public SimpleFrame(){
    setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
  }
}
//Code Description
/*
Lets look on packages
          The javax.swing
          Swing classes are placed in javax.swing packages
          javax indicates a Java extension package, not a core package

For historical reasons swing is considered an extension.
But now it is present in every Java SE implementation since 1.2

about this piece of code
          EventQueue.invokeLater(() ->{
             //statements
             });
             is used to execute statements in the event dispatch thread 
             you can initialize the user interface in the event dispatch thread or in the main thread
        

*/
