import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

//import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.JComponent;
public class DrawTest {
    public static void main(String args[]){
        EventQueue.invokeLater(()->{
            JFrame frame=new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class DrawFrame extends JFrame{
    public DrawFrame(){
        add(new DrawComponent());
        pack();
    }
}
class DrawComponent extends JComponent{
    private static final int defaultwidth=400;
    private static final int defaultheight=400;
    public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        //draw a rectangle
        double leftx=100;
        double topy=100;
        double width=200;
        double height=150;
        
        Rectangle2D rect=new Rectangle2D.Double(leftx,topy,width,height);
        g2.draw(rect);
        //draw an enclosed ellipse
        Ellipse2D ellipse=new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);
        //draw a diagonal line
        g2.draw(new Line2D.Double(leftx,topy,leftx+width,topy+height));
        //draw a circle with the same center
        double centerx=rect.getCenterX();
        double centery=rect.getCenterY();
        double radius=150;

        Ellipse2D circle=new Ellipse2D.Double();
        circle.setFrameFromCenter(centerx, centery, centery, radius);
        g2.draw(circle);
    } 
    public Dimension getPreferredSize(){
        return new Dimension(defaultwidth,defaultheight);
    }
}
