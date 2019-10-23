package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import shape.HW1Controller;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Frame1 extends JFrame {
   JPanel contentPane;
   BorderLayout borderLayout1 = new BorderLayout();
   Canvas canvas=new Canvas();
   JPanel jPanel1 = new JPanel();
   JButton boxButton = new JButton();
   JButton circleButton = new JButton();
   private HW1Controller controller;
   public Frame1() {
      super();
      try {
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         jbInit();
      } catch(Exception exception) {
         exception.printStackTrace();
      }
   }

   public HW1Controller getController() {
      return controller;
   }


   /**
    * Component initialization.
    *
    * @throws java.lang.Exception
    */
   private void jbInit() throws Exception {
      contentPane = (JPanel) getContentPane();
      contentPane.setLayout(borderLayout1);
      canvas.setBackground(Color.white);
      canvas.setVisible(true);
      setSize(new Dimension(800, 600));
      setTitle("HW1 GUI");
      jPanel1.setPreferredSize(new Dimension(100, 200));
      boxButton.setText(" Box  ");
      circleButton.setText("Circle");
      contentPane.add(canvas, java.awt.BorderLayout.CENTER);
      contentPane.add(jPanel1, java.awt.BorderLayout.WEST);
      jPanel1.add(circleButton);
      jPanel1.add(boxButton);
      controller=new HW1Controller();
      canvas.addMouseListener(new MouseAdapter() {
         //@Override
         public void mousePressed(MouseEvent e) {
            controller.canvasClicked( (int) e.getPoint().getX(),
               (int) e.getPoint().getY());
            canvas.shapes=controller.getShapes();
            canvas.repaint();
         }
      });
      circleButton.addActionListener(new ActionListener() {

         //@Override
         public void actionPerformed(ActionEvent e) {
            controller.cirClicked();
         }
      });
      boxButton.addActionListener(new ActionListener() {

         //@Override
         public void actionPerformed(ActionEvent e) {
            controller.boxClicked();
         }
      });



   }
}
