//Nick Keirstead


import java.awt.*;
import java.applet.*;

public class Point105 extends Applet
{
    private static int increment = 10;

    public static int[] arcSides = {1,2,3,4}; //Draw Arcs From All 4 Sides
    

    public void paint(Graphics g) 
    {
        Rect screen = new Rect(10,10,980,630);
        boolean computerCanCrash = true; //decides if the increment shrinks as the scale factor is applied to the square
        int times = 2;
        
        inception(g, screen, arcSides, increment, times, 0.5, computerCanCrash);
        
        //word of warning: as long as crashComputer is true, dont call inception with times set as more than 4 or 5
    }

    void inception(Graphics g, Rect r, int[] sides, int increment, int times, double factor, boolean computerCanCrash) {
        //especially inception-y because it's a recursive function...
        if (times == 0) return; //staaahhhp
        
        g.drawRect(r.topLeft()[0], r.topLeft()[1], r.getWidth(), r.getHeight());
        drawArcsFromSides(g, r, sides, increment);
        Rect innerRect = r.scaled(factor);
        
        int newIncrement = computerCanCrash ? (int)(increment * factor) : increment;
        inception(g, innerRect, sides, newIncrement, times-1, factor, computerCanCrash);
    }
    void drawArcsFromSides (Graphics g, Rect r, int[] sides, int increment){
        for (int i = 0; i < arcSides.length; i++) {
            drawArcInRect(g, r, sides[i], increment);
        }
    }
    void drawLineTo(Graphics g, int[] p1, int[] p2)
    {
        g.drawLine(p1[0], p1[1], p2[0], p2[1]);
    }

    void drawArcInRect(Graphics g, Rect r, int fromSide, int increment)
    {
        int[] tl = r.topLeft();
        int[] tr = r.topRight();
        int[] bl = r.bottomLeft();
        int[] br = r.bottomRight();

        if (fromSide == 1) //draw arc from top onto left side
        {
            for (int x = tr[0]; x > tl[0]; x -= increment)
            {
                int[] currPoint = {x, tr[1]};
                int[] target = r.targetPoint(currPoint,fromSide);
                drawLineTo(g, currPoint, target);
            }
        }
        else if (fromSide == 4) //draw arc from left onto bottom side
        {
            for (int y = tl[1]; y < bl[1]; y += increment) 
            {
                int[] currPoint = {tl[0], y};
                int[] target = r.targetPoint(currPoint, fromSide);
                drawLineTo(g, currPoint, target);
            }
        }
        else if (fromSide == 3) //draw arc from bottom onto right side
        {
            for (int x = bl[0]; x < br[0]; x += increment) 
            {
                int[] currPoint = {x, bl[1]};
                int[] target = r.targetPoint(currPoint, fromSide);
                drawLineTo(g, currPoint, target);
            }
        }
        else 
        {//fromSide == 2 //draw arc from right onto top side
            for (int y = br[1]; y > tr[1]; y -= increment) 
            {
                int[] currPoint = {br[0], y};
                int[] target = r.targetPoint(currPoint, fromSide);
                drawLineTo(g, currPoint, target);
            }
        }
    }
}
