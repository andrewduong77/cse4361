package hw2;

import java.awt.Graphics2D;

public class Helloworld extends Shape
{
    private int x, y;
    public Helloworld(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawString("Hello world", x, y);
    }
}
