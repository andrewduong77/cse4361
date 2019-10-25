package hw2;

import java.io.*;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Stack;

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

interface Shape
{
    public void Draw(Graphics2D graphics);
}
class Circle implements Shape
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
class Box implements Shape
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
    private Stack<Shape> points;
    private Stack<Shape> pointsRemoved;
    private Shape temp;
//    public static String flag = "";
    private static String flag = "";
    
    public Model()
    {
        points = new Stack<Shape>();
        pointsRemoved = new Stack<Shape>();
    }
    public void addPoint(Shape shape)
    {
        points.push(shape);
    }
    public void removePoint()
    {
        temp = points.pop();
        pointsRemoved.push(temp);
    }
    public void getPoint(int i)
    {
        points.get(i);
    }
    public Stack<Shape> getPoints()
    {
         return points;
    }
    public static void setFlag(String newFlag)
    {
        flag = newFlag;
    }
    public String getFlag()
    {
        return flag;
    }
}
class View extends JFrame
{
    private Model model = new Model();
    private Controller controller = new Controller(model);
    public View(Model model, Controller controller)
    {
        // create a new frame to store text field and button 
        JFrame frame = new JFrame("HW1 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a new buttons
        // JButton buttonCircle, buttonBox;
        JButton buttonCircle = new JButton("Circle");
        JButton buttonBox = new JButton("Box");
        JButton buttonUndo = new JButton("Undo");
        JButton buttonRedo = new JButton("Redo");

        // create a panel to add buttons 
        JPanel panelLeft = new JPanel(); 
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.LIGHT_GRAY);

        JPanelDraw panelRight = new JPanelDraw();
        panelRight.setBackground(Color.white); 

        // add buttons and textfield to panel 
        panelLeft.add(buttonCircle,BorderLayout.WEST); 
        panelLeft.add(buttonBox,BorderLayout.WEST);
        panelLeft.add(buttonUndo,BorderLayout.WEST);
        panelLeft.add(buttonRedo,BorderLayout.WEST);

        // add panel to frame 
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

        buttonCircle.addActionListener(actionListenerCircle);
        buttonBox.addActionListener(actionListenerBox);
        buttonUndo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                model.removePoint();
                repaint();
            }
        });
        buttonRedo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        panelRight.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(model.getFlag().equals("circle"))
                {
                    panelRight.drawCircle(e);
                }
                if(model.getFlag().equals("box"))
                {
                    panelRight.drawBox(e);
                }
                repaint();
            }
        });
    }
    public static ActionListener actionListenerCircle = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
//            Model.flag = "circle";
            Model.setFlag("circle");
        }
    };
    public static ActionListener actionListenerBox = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
//            Model.flag = "box";
            Model.setFlag("box");
        }
    };
//    public ActionListener actionListenerUndo = new ActionListener()
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            model.removePoint();
//        }
//    };
    public static ActionListener actionListenerRedo = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    };

//    @Override
    public void mouseClicked(MouseEvent e) {}

//    @Override
    public void mousePressed(MouseEvent e) {}

//    @Override
    public void mouseReleased(MouseEvent e) {}

//    @Override
    public void mouseEntered(MouseEvent e) {}

//    @Override
    public void mouseExited(MouseEvent e) {}
}
class Controller
{
    private Model model = new Model();
    public Controller(Model model)
    {
        this.model = model;
    }
}
class JPanelDraw extends JPanel
{
    private Model model = new Model();
    private Controller controller = new Controller(model);
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Iterator it = model.getPoints().iterator();
        while(it.hasNext())
            ((Shape)it.next()).Draw(g2);
    }
//    public JPanelDraw() {}
    public void drawCircle(MouseEvent e)
    {
        Circle circle = new Circle(e.getX(), e.getY());
        model.addPoint(circle);
        Model.setFlag("");
//        model.flag = "";
        repaint();
}
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
        model.addPoint(box);
        Model.setFlag("");
//        model.flag = "";
        repaint();
    }
    public void panelRepaint()
    {
        repaint();
    }
}
public class Hw2
{
    public static void main(String[] args)
    {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
    }
}
