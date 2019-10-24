package gui.shape;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * <p>Title: </p>
 *
 * <p>Description: Composite component of the composite pattern </p>
 *
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <p>Company: </p>
 *
 * @author David Kung
 * @version 1.0
 */
public class Shapes extends HW1Shape {
   Collection collection;
   public Shapes() {
         super(0, 0);
         collection = new ArrayList<HW1Shape> ();
   }
   public void add(HW1Shape s) {
      collection.add(s);
   }

   public void draw(Graphics graphics) {
      Iterator it=collection.iterator();
      while (it.hasNext()) {
         ((HW1Shape)it.next()).draw(graphics);
      }
   }
}
