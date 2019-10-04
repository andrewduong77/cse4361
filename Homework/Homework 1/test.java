import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
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
        g.drawOval(x, y, 30, 30);
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
        g.drawRect(x, y, 30, 30);
    }
}
class JPanelDraw extends JPanel
{
    // private static final long serialVersionUID = 1L;
    private ArrayList<shape> points = new ArrayList<shape>();
    public String figure = "";
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(shape point : points)
        {
            point.Draw(g2);
        }
    }
    public JPanelDraw()
    {
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(figure.equals("circle"))
                {
                    Circle c = new Circle(e.getX(), e.getY());
                    System.out.println("Circle");
                }
                if(figure.equals("box"))
                {
                    Box s =new Box(e.getX(), e.getY());
                    System.out.println("Box");
                }
                repaint();
            }
        });
    }
}
class test
{ 
    // private static final long serialVersionUID = 1L;
    
    public static void main(String[] args)
    { 
        // create a new frame to stor text field and button 
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

        // add mouse click listeners
        buttonCircle.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panelLeft.figure = "circle";
            }
        });
        buttonBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panelLeft.figure = "box";
            }
        });

        // add panel to frame 
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight,BorderLayout.CENTER);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

        buttonCircle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        buttonBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            
            }
        });
    }
} 