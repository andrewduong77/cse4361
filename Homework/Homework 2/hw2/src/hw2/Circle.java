package hw2;

import java.awt.Graphics2D;

public class Circle extends Shape
{
    private int x, y;
    public Circle(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawOval(x, y, 75, 75);
    }
}
