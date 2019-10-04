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
}
public void Draw(Graphics2D g)
{
    g.drawOval(x, y, 50, 50);
}
class Square implements shape
{
    private int x, y;
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawRect(x, y, 50, 50);
    }
}

class test extends JPanel
{ 
    private static final long serialVersionUID = 1L;
    // main class 
    public static void main(String[] args)
    { 
        // create a new frame to stor text field and button 
        JFrame frame = new JFrame("HW1 GUI");

        // create a new buttons
        // JButton buttonCircle, buttonBox;
        JButton buttonCircle = new JButton("Circle");
        JButton buttonBox = new JButton("Box");

        // create a panel to add buttons 
        JPanel panelLeft = new JPanel(); 
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
    // public void paintComponent(Graphics g)
    // {
    //     super.paintComponent(g);
    //     g.setColor(Color.RED);
    //     g.drawRect(30, 30, 30, 30);
    // }
} 