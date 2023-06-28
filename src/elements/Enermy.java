package elements;

import javafx.scene.layout.AnchorPane;
import lib.Point;

public abstract class Enermy extends Entity{
	private Point endPosition;
	public Point getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Point endPosition) {
		this.endPosition = endPosition;
	}

	public Enermy(String linkImage, float width, float heigh, int hp) {
		super(linkImage, width, heigh, hp);
	}
	
	public abstract void move(SpaceShip spaceShip, AnchorPane pane);
	public abstract void attack(SpaceShip spaceShip, AnchorPane pane);
}
