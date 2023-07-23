import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.font.LineMetrics;
import java.awt.font.FontRenderContext;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class Main{
  public static void main(String args[]){
    EventQueue.invokeLater(()->{
      JFrame frame=new FontFrame();
      frame.setTitle("Testing Font");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}
class FontFrame extends JFrame{
  public FontFrame(){
    add(new FontComponent());
    pack();
  }
}
class FontComponent extends JComponent{
  private static final int DEFAULT_WIDTH=300;
  private static final int DEFAULT_HEIGHT=200;

  public void paintComponent(Graphics g){
    Graphics2D g2=(Graphics2D) g;
    String message="Hello World";
    Font f=new Font("Serif",Font.BOLD,36);
    g2.setFont(f);

    FontRenderContext context=g2.getFontRenderContext();
    Rectangle2D bounds=f.getStringBounds(message,context);

    double x=(getWidth() - bounds.getWidth())/2; //help you to set the start and end coordinate
    double y=(getHeight() - bounds.getHeight())/2;// here I will get the text in the middle of my gui centers string with the surrounding component

    double ascent=-bounds.getY();
    double baseY=y+ascent;

    g2.drawString(message,(int) x,(int) baseY);
    g2.setPaint(Color.LIGHT_GRAY);

    g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
    Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
    g2.draw(rect);
  }
  public Dimension getPreferredSize(){
    return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
  }
}
/*
program to list all the font present in the users system 
import java.awt.*;
public class ListFont{
  public static void main(String args[]){
    String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    for(String fontName:fontNames){
      System.out.println(fontName);
      }
    }
  font faces can get copyrighted font foundary gets royalty payments
  but some companies have made he copy so they don't have to pay royalties
  For example,
    Helvetics is shipped to Arial
  Common baselines,
  five logical font names:
  Sans Serif
  Serif
  Monospaced
  Dialog
  DialogInput
  You will always find these fonts in client machine

  values
  Font.PLAIN
  Font.BOLD
  Font.ITALIC
  Font.BOLD+Font.Italic

  Mapping from logical to physical font names
  jre/lib subdirectory
  fontconfig.properties files

  Java fonts contain the usual ASCII characters as well as symbols 
  \u2297 gets a unique character

  Typesetting terms
  ascent
  descent 
  leading
  baseline
  height
  baseline

  height=ascent+descent+leading
  
*/
