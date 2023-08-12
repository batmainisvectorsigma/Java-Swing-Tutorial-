import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Cursor;

public class DefaultCursorCheck {
    private JFrame frame;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12 , button13, button14,button15;

    public DefaultCursorCheck() {
        frame = new JFrame("Default cursor");
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout()); // setting layout to FlowLayout

        button1 = new JButton("Default Cursor");
        button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        button2 = new JButton("Cross hair Cursor");
        button2.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        button3 = new JButton("Hand cursor");
        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button4 = new JButton("Move cursor");
        button4.setCursor(new Cursor(Cursor.MOVE_CURSOR));

        button5 = new JButton("Text cursor");
        button5.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        button6 = new JButton("Wait cursor");
        button6.setCursor(new Cursor(Cursor.WAIT_CURSOR));

        button7 = new JButton("NE Resize cursor");
        button7.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        
        button8=new JButton("NE Resize cursor");
        button8.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));

        button9=new JButton("E Resize cursor");
        button9.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));

        button10=new JButton("SE Resize cursor");
        button10.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));

        button11=new JButton("SW Resize cursor");
        button11.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));

        button12=new JButton("W Resize cursor");
        button12.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));

        button13=new JButton("NW Resize cursor");
        button13.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        
        button14=new JButton("N Resize Cursor");
        button14.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));

        button15=new JButton("S Resize Curosr");
        button15.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
   
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
        frame.add(button11);
        frame.add(button12);
        frame.add(button13);
        frame.add(button14);
        frame.add(button15);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       new DefaultCursorCheck();
    }
}

