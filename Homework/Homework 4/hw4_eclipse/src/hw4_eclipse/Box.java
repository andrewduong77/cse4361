package hw4_eclipse;

import java.awt.Graphics2D;

public class Box implements Shape
{
    private int x, y;
    public Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawRect(x, y, 75, 75);
    }
}
