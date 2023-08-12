import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
/* 
public class MouseEve implements MouseListener {
    private JLabel label;
    private JFrame frame;

    public MouseEve() {
        frame = new JFrame();  // Initialization of frame
        frame.setSize(500, 500);
        
        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.RED);
        label.setOpaque(true);
        
        // Adding the mouse listener
        label.addMouseListener(this);
       // frame.addMouseListener(this);
        
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You pressed the mouse");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("You release the mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       System.out.println("You entered the mouse");
    }

    @Override
    public void mouseExited(MouseEvent e) {
       System.out.println("You exited the component");
    }

    public static void main(String[] args) {
        new MouseEve();
    }
}
*/
//writing the code in my way
public class MouseEve{
    private JLabel label;
    private JFrame frame;
    public MouseEve(){
        frame=new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        label=new JLabel();
        label.setBackground(Color.RED);
        label.setBounds(0,0,50,50);
        label.setVisible(true);
        label.setOpaque(true);
        frame.add(label);
        label.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e){
                label.setBackground(Color.CYAN);
            }
            public void mousePressed(MouseEvent e){
                label.setBackground(Color.PINK);
            }
            public void mouseReleased(MouseEvent e){
                label.setBackground(Color.GREEN);
            }
            public void mouseEntered(MouseEvent e){
                label.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e){
                label.setBackground(Color.RED);
            }
        });
    }
    public static void main(String args[]){
        new MouseEve();
    }
}
