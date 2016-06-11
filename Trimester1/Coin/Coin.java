import java.awt.Image;
import java.awt.Graphics;
import java.util.Random;

public class Coin {
    private Image head, tail;
    private Image currSide;

    public Coin (Image front, Image back) {
        head = front;
        tail = back;
        currSide = head; //coin is heads by default
    }

    public void flip (boolean randomFlip) {
        if (randomFlip) {
            Random rgen = new Random();
            boolean r = rgen.nextBoolean();
            currSide = r ? head : tail;
        }
        else {
            currSide = (currSide == head) ? tail : head;
        }
    }

    public void draw (Graphics g, int x, int y) {
        int w = currSide.getWidth(null);
        int h = currSide.getHeight(null);
        g.drawImage(currSide, x-w/2, y-h/2, null);
    }
}