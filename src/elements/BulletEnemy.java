package elements;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;

public class BulletEnemy extends Bullet{

	public BulletEnemy(String linkImage, float width, float heigh, int hP, Point vector) {
		super(linkImage, width, heigh, hP, vector);
		// TODO Auto-generated constructor stub
	}

	public BulletEnemy() {
		this("/resourses/gamekit/spritesheets/jjj.png",80,80,0,new Point(0,7));
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
			spaceShip.setHP(spaceShip.getHP()-1);
			spaceShip.dau();
	}
	
	public void move(SpaceShip spaceShip, AnchorPane pane, Point endPosition) {
		pane.getChildren().add(this.getImageView());
		Point vector = endPosition;
		vector.sub(getPosition());
		vector.mul(0.015);
		
		 AnimationTimer timer = new AnimationTimer() {
//			 long lastTime = 0;
			@Override
			public void handle(long now) {
			     
//					if(now - lastTime >= 1e9/1000) {
					getPosition().add(vector);
					setPosition(getPosition());
					getImageView().setRotate(getImageView().getRotate()+5);
//					lastTime = now;
//					}
					if ( hasVaCham(spaceShip)) {
						if(!isBOOM) 
						{
							no();
							System.out.println("BOOM");
							attack(spaceShip, pane);
							pane.getChildren().remove(getImageView());
						}
						PauseTransition delay = new PauseTransition(Duration.seconds(1));
						delay.setOnFinished(event->{	
							this.stop();// stop animationTimer
						});
						delay.play();
					}
				}
		};
		timer.start();
	}
}
