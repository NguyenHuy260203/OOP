package elements;



import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.util.Pair;
import lib.Point;

public class EnermyShip extends Enermy{
	public EnermyShip(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh,5);
	}
	public EnermyShip() {
		this("/resourses/gamekit/spritesheets/enermy/enemyOverlord.png", 120, 90);
		Random random = new Random();
		this.setPosition(new Point(random.nextDouble()*1000, 10));
		setEndPosition(new Point(random.nextDouble()*1000, random.nextDouble()*400));
	}
	@Override
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		// TODO Auto-generated method stub
		pane.getChildren().add(getImageView());
		Point vector = new Point();
		vector.setLocation(getEndPosition());
		vector.sub(getCenter());
		double x = vector.doDai();
		vector.mul(5.0/x);
		Point position = getPosition();
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				
				position.add(vector);
				setPosition(position);
				if(getCenter().distance(getEndPosition())<5) {
					this.stop();
					TranslateTransition ef = new TranslateTransition();
					ef.setNode(getImageView());
					ef.setDuration(Duration.seconds(2));
					ef.setAutoReverse(true);
					ef.setCycleCount(TranslateTransition.INDEFINITE);
					ef.setByX(100);
					ef.play();
				
				}
			
			}
			
		};timer.start();
		
		
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	