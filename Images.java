import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
public class Main{
  public static void main(String args[]){
   EventQueue.invokeLater(()->{
     JFrame frame=new JFrame();
     frame.setTitle("Testing Image");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
   });   
  }
}
class ImageFrame extends JFrame{
  public ImageFrame(){
    add(new ImageComponent());
    pack();
  }
}
class ImageComponent extends JComponent{
  private static final int DEFAULT_WIDTH=1000;
  private static final int DEFAULT_HEIGHT=1000;
  private Image image;
  public ImageComponent(){
    image=new ImageIcon("lady.jpg").getImage();
  }
  public void paintComponent(Graphics g){
    if(image == null) return;
    int imageWidth=image.getWidth(this);
    int imageHeight=image.getHeight(this);

  g.drawImage(image,0,0,null);

  for(int i =0;i*imageWidth<=getWidth();i++){
    for(int j=0;j*imageHeight<=getHeight();j++){
      if(i+j>0){
        g.copyArea(0, 0, imageWidth,imageHeight,i*imageWidth,i*imageHeight);
    }
  }
    
  }
  }
  public Dimension getPreferredSize(){
    return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
  }
}
//been working in this code
