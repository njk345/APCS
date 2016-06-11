// Chapter 5 Question 27

// Nick Keirstead

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SmallRainbow extends JPanel
{
  private final Color skyColor = Color.CYAN;

  public SmallRainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();

    int largeRadius = width/4;
    int smallRadius = height/4;
    int mediumRadius = Math.round((float)Math.sqrt(largeRadius * smallRadius));
    /*mediumRadius is geometric mean of other two, which is then converted to a float
    and passed into Math.round, which returns the nearest int value*/
    
    int xCenter = width/2;
    int yCenter = 3*height/4;
    //coordinates of "center" (bottom middle) of largest semicircle
    
    g.setColor(Color.RED);
    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, 2*largeRadius, 2*largeRadius, 0, 180);
    g.setColor(Color.GREEN);
    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, 2*mediumRadius, 2*mediumRadius, 0, 180);
    g.setColor(Color.MAGENTA);
    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, 2*smallRadius, 2*smallRadius, 0, 180);
    
    //make difference of mediumRadius and smallRadius equal the arithmetic average of the difference
    //between the large and mediumRadius, and the small and inner radius
    
    //mediumRadius - smallRadius = (largeRadius-mediumRadius) + (smallRadius-innerRadius) / 2
    //--> innerRadius = largeRadius - 3*mediumRadius + 3*smallRadius

    int innerRadius = largeRadius - 3*mediumRadius + 3*smallRadius;
    g.setColor(skyColor);
    g.fillArc(xCenter-innerRadius, yCenter-innerRadius, 2*innerRadius, 2*innerRadius, 0, 180);
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new SmallRainbow());
    w.setVisible(true);
  }
}
