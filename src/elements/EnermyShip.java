package elements;



import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.util.Pair;
import lib.Point;
//Boss
public class EnermyShip extends Enermy{
	public EnermyShip(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh,100);
	}
	public EnermyShip() {
		this("/resourses/gamekit/spritesheets/enermy/enemyOverlord.png", 360, 240);
//		Random random = new Random();
		this.setPosition(new Point(-200, -200));
		setEndPosition(new Point(500, 100));
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
			public void handle(long now) {
				// TODO Auto-generated method stub
				Random random = new Random();
				position.add(vector);
				setPosition(position);
				if (isBOOM) this.stop();
				if(now % (random.nextInt(5000)+1)==0 ){
					attack(spaceShip, pane);
				}
				if(getCenter().distance(getEndPosition())<5) {
					TranslateTransition ef = new TranslateTransition();
					ef.setNode(getImageView());
					ef.setDuration(Duration.seconds(5));
					ef.setAutoReverse(true);
					ef.setCycleCount(TranslateTransition.INDEFINITE);
					ef.setByX(500);
					ef.play();
//					this.stop();
				}
				
			}
		};timer.start();
		
		
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		BulletEnemy dan1 = new BulletEnemy();
		BulletEnemy dan2 = new BulletEnemy();
		Point temp1 = new Point(getCenter().getX()-150,getCenter().getY()+10);
		Point temp2 = new Point(getCenter().getX()+150,getCenter().getY()+10);
		
		Point pos1 = new Point();
		pos1.setLocation(spaceShip.getPosition());
		pos1.add(new Point(50, 0));
		Point pos2 = new Point();
		pos2.setLocation(spaceShip.getPosition());
		pos2.add(new Point(50, 0));
		
		dan1.setPosition(temp1);
		dan1.move(spaceShip, pane, pos1);
		dan2.setPosition(temp2);
		dan2.move(spaceShip,pane, pos2);
	}
	
}
