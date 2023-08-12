import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;

import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Image;

public class CursorCheck {
    private JFrame frame;
    private JPanel panel;
    private JLabel label1,label2;
    private Cursor cursor1,cursor2;
    private Image img1,img2;
    private Toolkit tkit;
    public CursorCheck(){
        frame=new JFrame();
        frame.setTitle("Custom Cursor");
        frame.setBounds(100,250,350,300);
        panel=new JPanel();
        Point point=new Point(0,0);
        label1=new JLabel("CodeSpeedy Pointer");
        label2=new JLabel("Another Custom Pointer");

        tkit=Toolkit.getDefaultToolkit();

        img1=tkit.getImage("cursor-png-1104.png");
        img2=tkit.getImage("cursor-png-1142.png");

        cursor1=tkit.createCustomCursor(img1, point, "Bello");
        cursor2=tkit.createCustomCursor(img2, point, "Hello");

        label1.setCursor(cursor1);
        label2.setCursor(cursor2);

        panel.add(label1);
        panel.add(label2);

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    public static void main(String args[]){
        new CursorCheck();
    }
}
