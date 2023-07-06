import javax.swing.*;
import java.awt.*;
public class NotHelloWorld{
    public static void main(String args[]){
        EventQueue.invokeLater(()->{
            JFrame frame=new NotHelloWorldFrame();
            frame.setTitle("Not Hello World");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class NotHelloWorldFrame extends JFrame{
    public NotHelloWorldFrame(){
        add(new NotHelloWorldComponent());
        pack();
    }
}
class NotHelloWorldComponent extends JComponent{
    public static final int messagex=75;
    public static final int messagey=100;
    private static final int defaultwidth=300; 
    private static final int defaultheight=200;
    
    public void paintComponent(Graphics g){
        g.drawString("Not a Hello World Program", messagex, messagey);
    }
    public Dimension getPreferredSize(){
        return new Dimension(defaultwidth, defaultheight);
    }
}
