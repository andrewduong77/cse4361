package shape;

import java.awt.Graphics;
import java.util.List;

public abstract class HW1Shape {

   int x, y;

   public HW1Shape(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public abstract void draw(Graphics graphics);

   public void add(HW1Shape s) {
      // noop
   }

}
