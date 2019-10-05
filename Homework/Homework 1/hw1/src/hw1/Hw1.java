/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author Andrew Duong
 */
import java.util.ArrayList;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

interface shape
{
    public void Draw(Graphics2D graphics);
}
class Circle implements shape
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
class Box implements shape
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

class Model
{
    private ArrayList<Point> points;
    private ArrayList<Point> points2;
    public static String flag = "";
    
    public Model()
    {
        points = new ArrayList<Point>();
        points2 = new ArrayList<Point>();
    }
    public void addPoint(String s)
    {
        if(s == "circle")
        {
            points.add(new Point());
        }
        if(s == "box")
        {
            points.add(new Point());
        }
    }
    public void getPoint(int i)
    {
        points.get(i);
    }
}
class View extends JFrame
{
    private Model model = new Model();
    private Controller controller = new Controller(model);
    public View(Model model, Controller controller)
    {
        JFrame frame = new JFrame("HW1 GUI");

        // create a new buttons
        // JButton buttonCircle, buttonBox;
        JButton buttonCircle = new JButton("Circle");
        JButton buttonBox = new JButton("Box");

        // create a panel to add buttons 
        JPanelDraw panelLeft = new JPanelDraw(); 
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.DARK_GRAY);

        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.white); 

        // add buttons and textfield to panel 
        panelLeft.add(buttonCircle,BorderLayout.WEST); 
        panelLeft.add(buttonBox,BorderLayout.WEST);

        // add panel to frame 
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight,BorderLayout.CENTER);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

        buttonCircle.addActionListener(controller.actionListenerCircle);
        buttonBox.addActionListener(controller.actionListenerBox);
    }
}
class Controller
{
    private Model model = new Model();
    public Controller(Model model)
    {
        this.model = model;
    }
    public static ActionListener actionListenerCircle = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Model.flag = "circle";
        }
    };
    public static ActionListener actionListenerBox = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Model.flag = "box";
        }
    };
}
class JPanelDraw extends JPanel
{
    
}
class Hw1 {
    /**
     * @param args the command line arguments
     */
    // private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        // create a new frame to stor text field and button 
        
    }
}
