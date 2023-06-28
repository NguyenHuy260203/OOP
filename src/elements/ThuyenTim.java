package elements;

import java.sql.Time;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import lib.Point;
import lib.Timer;

public class ThuyenTim extends Enermy {
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
			long temp = 0;
			Random random = new Random();
			@Override
			public void handle(long now) {
				if(getCenter().distance(getEndPosition())>5) {
					position.add(vector);
					setPosition(position);
				}
				
				// TODO Auto-generated method stub
				if(isBOOM)this.stop();
				if(currentFrame == 2)currentFrame = 0;
				if(now - lastTime>1e9/10) {
					Image image = new Image(linkImage[currentFrame]);
					getImageView().setImage(image);
					currentFrame++;	
					lastTime = now;
				}
				if(now % (random.nextInt(5000 )+1)==0 ){
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
class DanTim extends ILU{

	public DanTim(String linkImage, float width, float heigh, int HP, Point vector) {
		super(linkImage, width, heigh, HP, vector);
		// TODO Auto-generated constructor stub
	}

	public DanTim() {
		this("/resourses/gamekit/spritesheets/enermy/danTim.png",40,40,1,new Point(0,7));
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		spaceShip.setHP(spaceShip.getHP()-1);
		spaceShip.dau();
		
	}

	
}
