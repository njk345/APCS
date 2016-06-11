// Chapter 5 Question 27

// Nick Keirstead

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LargeRainbow extends JPanel
{
  private final Color skyColor = Color.CYAN;
  private final Color INDIGO = new Color(111, 0, 255);
  private final Color VIOLET = new Color(127, 0, 255);
  private final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, INDIGO, VIOLET};

  public LargeRainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();

    int outerRadius = width*4/10;
    //radius of largest semicircle
    
    int xCenter = width/2;
    int yCenter = 3*height/4;
    //coordinates of "center" (bottom middle) of largest semicircle
    
    for (int i = 0; i < colors.length; i++) {
        int radius = Math.round(outerRadius * ((float) (7-i) / 7));
        //so biggest semicircle is 7/7 of outerRadius, then 6/7, 5/7, 4/7 ... 1/7
        g.setColor(colors[i]);
        g.fillArc(xCenter-radius, yCenter-radius, 2*radius, 2*radius, 0, 180);
    }
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new LargeRainbow());
    w.setVisible(true);
  }
}
