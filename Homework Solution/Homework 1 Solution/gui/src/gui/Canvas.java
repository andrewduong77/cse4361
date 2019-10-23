package gui;

import javax.swing.*;

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
import java.awt.*;
import shape.*;

public class Canvas extends JPanel {
   HW1Shape shapes;
   public Canvas() {
      super();
   }

   public void setShapes(HW1Shape shapes) {
      this.shapes=shapes;
   }

   //@Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (shapes!=null) shapes.draw(g);
   }
}
