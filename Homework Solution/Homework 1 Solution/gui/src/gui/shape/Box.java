package gui.shape;

import java.awt.Graphics;

public class Box extends HW1Shape {

        public Box(int x, int y) {
           super(x, y);
        }

	//@Override
	public void draw(Graphics graphics) {
		graphics.drawRect(this.x, this.y, 120, 120);
	}

}
