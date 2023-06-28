package elements;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import lib.Point;

public class BulletEnemy extends Bullet{

	public BulletEnemy(String linkImage, float width, float heigh, int hP, Point vector) {
		super(linkImage, width, heigh, hP, vector);
		// TODO Auto-generated constructor stub
	}

	public BulletEnemy() {
		this("/resourses/gamekit/spritesheets/enermy/danTim.png",200,100,3,new Point(0,7));
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
	
	public void move(SpaceShip spaceShip, AnchorPane pane, Point position) {
		pane.getChildren().add(this.getImageView());
		Point vector = position;
		vector.sub(getPosition());
		vector.mul(0.1);
		 AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
			     
				position.add(vector);
				setPosition(position);
				
				if (position.getY() > 890 || position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// stop animationTimer
				}
				else if (hasVaCham(spaceShip)) {
					System.out.println("BOOM");
					pane.getChildren().remove(getImageView());
					attack(spaceShip, pane);
					this.stop();
				}
				effect();
			}
		};
		timer.start();
	}
}
