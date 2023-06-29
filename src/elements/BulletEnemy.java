package elements;

import javafx.scene.layout.AnchorPane;
import lib.Point;

public class BulletEnemy extends Bullet{

	public BulletEnemy(String linkImage, float width, float heigh, int hP, Point vector) {
		super(linkImage, width, heigh, hP, vector);
		// TODO Auto-generated constructor stub
	}

	public BulletEnemy() {
		this("/resourses/gamekit/spritesheets/enermy/danTim.png",50,50,3,new Point(0,7));
		
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		if (this.getPosition().getY() == (spaceShip.getPosition().getY() - 20) || hasVaCham(spaceShip)) {
			this.no();
		}
		if (hasVaCham(spaceShip)) {
			spaceShip.setHP(spaceShip.getHP() - 2);
			spaceShip.dau();
		}
	}
	
}
