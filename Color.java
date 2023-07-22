import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.SystemColor;


import javax.swing.JComponent;
public class Main{
  public static void main(String args[]){
    EventQueue.invokeLater(()->{
      JFrame frame=new DrawFrame();
      frame.setTitle("Some1 Testing");
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

    double leftx=100;
    double topy=100;
    double width=200;
    double height=150;

    Rectangle2D rect=new Rectangle2D.Double(leftx,topy,width,height);
    g2.draw(rect);
   // g2.setPaint(new Color(0,128,128).brighter());
    g2.setBackground(SystemColor.menu);
    g2.fill(rect);

    Ellipse2D ellipse=new Ellipse2D.Double();
    ellipse.setFrame(rect);
    g2.draw(ellipse);

    
  }
  public Dimension getPreferredSize(){
    return new Dimension(defaultwidth,defaultheight);
  }
}


/*
///////////////////////////////////////////////////////////////////////////////
/////////////////////////SETTING A CUSTOM COLOR///////////////////////////////
/////////////////////////////////////////////////////////////////////////////
g2.setPaint(new Color(int red, int blue,int green);
Graphics Object              Graphics2D Object
setColor()                   fill()
BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW
g2.setPaint(Color.RED)
///////////////////////////////////////////////////////////////////////////////
/////////////////////////SETTING A BACKGROUND COLOR///////////////////////////
/////////////////////////////////////////////////////////////////////////////
p.setForeground();
this will help you set the default color


///////////////////////////////////////////////////////////////////////////////
/////////////////////////HIGHTLIGHT A SPECIFING COMPONENT///////////////////////
/////////////////////////////////////////////////////////////////////////////
use brighter and darker method of the Color class
a.brighter().brighter();


///////////////////////////////////////////////////////////////////////////////
/////////////////////////SYSTEM COLOR////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
SystemColor class
p.setBackground(SystemColor.window);
desktop              Background color of desktop
activeCaption             Background color for captions
activeCaptionText             Text color for captions
activeCaptionBorder            Border color for caption text
inactiveCaption           Background color for inactive captions
inactiveCaptionText         Text color for inactive captions
inactiveCaptionBorder         Border color for inactive captions
window         Background for windows
windowBorder         Color of window border frame
windowText         Text color inside windows
menu         Background for menus
menuText         Text color for menus
text         Background color for text
textText         Text color for text
textInactiveText         Text color for inactive controls
textHighlight         Background color for highlighted text
textHighlightText         Text color for highlighted text
control         Background color for controls
controlText         Text color for controls
controlLtHighlight         Light highlight color for controls
controlHighlight         Highlight color for controls
controlShadow         Shadow color for controls
controlDkShadow         Dark shadow color for controls
scrollbar         Background color for scrollbars
info Background         color for spot-help text
infoText         Text color for spot-help text
*/
