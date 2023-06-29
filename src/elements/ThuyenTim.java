package elements;

import java.sql.Time;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;
import lib.Timer;

public class ThuyenTim extends Enermy {
	public final long MAX6 = (long)1e9/60;
	public final long MAX10 = (long)1e9/10;
	private Timer time = new Timer();
	private static String[] linkImage = {"/resourses/gamekit/spritesheets/enermy/thuyenTim1.png",
			"/resourses/gamekit/spritesheets/enermy/thuyenTim2.png"
			
	};
	
	public ThuyenTim() {
		super(linkImage[0],119,89,4);
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
		vector.mul(3/x);
		Point position = getPosition();
		AnimationTimer timer = new AnimationTimer() {
			int currentFrame = 0;
			long lastTime = 0;
			long update = 0;
			long temp = 0;
			Random random = new Random();
			@Override
			public void handle(long now) {
				
				if(now - update>MAX6) {
					if(getCenter().distance(getEndPosition())>15) {
						position.add(vector);
						setPosition(position);
						update = now;
					}
					
				}
				// TODO Auto-generated method stub
				if(isBOOM) {
					
					
					this.stop();
				
				}
				if(currentFrame == 2)currentFrame = 0;
				if(now - lastTime>MAX10) {
					
					Image image = new Image(linkImage[currentFrame]);
					getImageView().setImage(image);
					currentFrame++;	
					lastTime = now;
				}
				if(now % (random.nextInt(50000 )+1)==0 ){
					attack(spaceShip, pane);
				}
				
		
			}
			
		};timer.start();
		
	}

	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		// TODO Auto-generated method stub
		DanTim dan = new DanTim();
		Point temp = new Point(getCenter().getX()-10,getCenter().getY()+10);
		dan.setPosition(temp);
		dan.move(spaceShip, pane);
	}

}
