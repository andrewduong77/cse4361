/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.awt.Graphics2D;

/**
 *
 * @author Andrew Duong
 */
public class String2 extends Shape
{
    private int x, y;
    public String2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawString("Hello World!", x, y);
    }
}
