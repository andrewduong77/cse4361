import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

class test extends JFrame { 

 private static final long serialVersionUID = 1L;

// JFrame 
 static JFrame f;
 static JPanel mainPanel;

 // JButton 
 static JButton b, b1; 

 // main class 
 public static void main(String[] args) 
 { 
	 System.out.println("Hello world");
     // create a new frame to stor text field and button 
     f = new JFrame("panel"); 
     mainPanel = new JPanel();
     mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

     // create a new buttons 
     b = new JButton("button1"); 
     b1 = new JButton("button2");

     // create a panel to add buttons 
     JPanel p1 = new JPanel(); 
     //p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
     p1.setBackground(Color.DARK_GRAY);
     JPanel p2 = new JPanel();
     //p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

     // add buttons and textfield to panel 
     p1.add(b); 
     p1.add(b1); 

     // setbackground of panel 
     p1.setBackground(Color.red); 

     // add panel to frame 
     mainPanel.add(p1); 
     mainPanel.add(p2); 
     
     f.add(mainPanel);
     // set the size of frame 
     f.setSize(1500, 1500); 
     f.setVisible(true);
     
 } 
} 