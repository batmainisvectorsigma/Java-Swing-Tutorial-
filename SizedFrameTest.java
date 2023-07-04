import java.awt.*;
import javax.swing.*;
public class SizedFrameTest {
    public static void main(String args[]){
        EventQueue.invokeLater(()->{
           JFrame frame=new SizedFrame();
           frame.setTitle("SizedFrame");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });
    }
}
class SizedFrame extends JFrame{
    
    public SizedFrame(){
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        Image img=new ImageIcon("vectorisonline.png").getImage();
        setIconImage(img);
    }
}

//Here in this program we tried to ask the browser to give the height and width using Toolkit class 
// and tried to give the icon to out java swing 
