package shape;

import java.awt.Graphics;

public class HW1Controller {
   private final int INIT = 0, BOX = 1, CIR = 2;
   private int state = INIT;
   HW1Shape shapes;

   public HW1Controller() {
      shapes = new Shapes();
   }

   public HW1Shape getShapes() {
      return shapes;
   }

   public void boxClicked() {
      state = BOX;
   }

   public void cirClicked() {
      state = CIR;
   }

   public void canvasClicked(int x, int y) {
      switch(state) {
         case INIT:
            return;
         case BOX:
            HW1Shape shape = new Box(x, y);
            shapes.add(shape);
            state = INIT;
            return;
         case CIR:
            shape = new Circle(x, y);
            shapes.add(shape);
            state = INIT;
            return;
      }
   }
}
