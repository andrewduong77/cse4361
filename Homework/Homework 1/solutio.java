import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
class solutio extends JFrame { 
  
    // JFrame 
    static JFrame f; 
  
    // JButton 
    static JButton b1, b2; 
    
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame to stor text field and button 
        f = new JFrame("panel"); 
    
        b1 = new JButton("button2"); 
        b2 = new JButton("button3"); 
  
        // create a panel to add buttons and textfield and a layout 
        JPanel p1 = new JPanel(); 
        JPanel p2 = new JPanel(); 
  
        // set Box Layout 
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); 
  
        // add buttons and textfield to panel 
         
        p1.add(b1); 
        p1.add(b2); 
  
        // setbackground of panel 
        p1.setBackground(Color.red); 
  
        // add panel to frame 
        f.add(p1); 
        f.add(p2); 
        // set the size of frame 
        f.setSize(300, 300); 
  
        f.show(); 
    } 
}