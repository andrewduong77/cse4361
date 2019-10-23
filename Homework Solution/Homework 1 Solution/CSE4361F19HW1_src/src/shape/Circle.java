package shape;

import java.awt.Graphics;

public class Circle extends HW1Shape {

        public Circle(int x, int y) {
           super(x, y);
        }

	//@Override
	public void draw(Graphics graphics) {
		graphics.drawOval(this.x, this.y, 120, 120);
	}

}
