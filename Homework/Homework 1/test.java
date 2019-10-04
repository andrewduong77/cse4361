import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

class test extends JFrame { 

    private static final long serialVersionUID = 1L;

    // main class 
    public static void main(String[] args) { 
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

        buttonCircle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        buttonBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
            }
        });
    }
} 