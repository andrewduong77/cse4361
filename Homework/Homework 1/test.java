import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

class test extends JFrame { 

    private static final long serialVersionUID = 1L;

    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame to stor text field and button 
        JFrame frame = new JFrame("HW1 GUI");

        // create a new buttons
        // JButton button_circle, button_box;
        JButton button_circle = new JButton("Circle");
        JButton button_box = new JButton("Box");

        // create a panel to add buttons 
        JPanel panel_left = new JPanel(); 
        panel_left.setLayout(new BoxLayout(panel_left, BoxLayout.Y_AXIS));
        panel_left.setBackground(Color.DARK_GRAY);
     
        JPanel panel_right = new JPanel();
        panel_right.setBackground(Color.white); 

        // add buttons and textfield to panel 
        panel_left.add(button_circle,BorderLayout.WEST); 
        panel_left.add(button_box,BorderLayout.WEST); 

        // add panel to frame 
        frame.add(panel_left,BorderLayout.WEST);
        frame.add(panel_right,BorderLayout.CENTER);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

    } 
} 