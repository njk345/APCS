
/**
 * Write a description of class Rect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rect
{
    private int x, y, w, h;
    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public int[] topLeft() {
        return new int[] {x,y};
    }
    public int[] topRight() {
        return new int[] {x + w, y};
    }
    public int[] bottomLeft() {
        return new int[] {x, y + h};
    }
    public int[] bottomRight() {
        return new int[] {x + w, y + h};
    }
    public int[] targetPoint(int[] p, int pSide) 
    {
        //takes point p on pSide, returns point to aim line to on corresponding side

        int[] target = new int[2];
        double ratio;
        if (pSide == 2 || pSide == 4)
        { //if left or right side of square
            ratio = (double) (p[1] - y) / h;
            target[1] = (pSide == 2) ? y : (y + h);
            target[0] = (int)((double) ratio * w + x);
        }
        else
        { //if top of bottom side of square
            ratio = (double) (p[0] - x) / w;
            target[0] = (pSide == 1) ? x : (x + w);
            target[1] = (int)((double) (y + h) - (ratio * h));
        }
        return target;
    }
    public Rect scaled(double factor) {
        //returns Rect whose width and height are scaled by factor
        //top left corner of Rect is placed such that scaled version has same center
        int newWidth = (int)(w * factor);
        int newHeight = (int)(h * factor);
        int newTLX = (int)(x + (double)newWidth/2);
        int newTLY = (int)(y + (double)newHeight/2);
        return new Rect(newTLX, newTLY, newWidth, newHeight);
    }
}
