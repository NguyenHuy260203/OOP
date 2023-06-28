package elements;

import lib.Point;

public abstract class Bullet extends ILU {
	
	public Bullet(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh,0, vector);
	}
}
