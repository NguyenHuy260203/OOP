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
		setEndPosition(new Point(0, 100));
	}
	@Override
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		// TODO Auto-generated method stub
		pane.getChildren().add(getImageView());
		Point vector = new Point();
		vector.setLocation(getEndPosition());
		vector.sub(getCenter());
		double x = vector.doDai();
		vector.mul(5/x);
		Point position = getPosition();
		AnimationTimer timer = new AnimationTimer() {
			boolean flag = true;//re phai
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				Random random = new Random();
				
				if (isBOOM) this.stop();
				
				if(getCenter().distance(getEndPosition())<5) {
					this.stop();
					
					AnimationTimer timer2 = new AnimationTimer() {
						Point step = new Point(5, 0);
						long lastTime = 0;
						long deltaTime = 0;
						@Override
						public void handle(long now) {
							// TODO Auto-generated method stub
							if(!flag) {
								getPosition().sub(step);
								setPosition(getPosition());
								if(getPosition().getX() < 0) flag = true;
							}
							else{ 
								getPosition().add(step);
								setPosition(getPosition());
								if(getPosition().getX() > 1000) flag = false;
								
							}
							if(now - lastTime > 1e9) {
								deltaTime++;
								if(deltaTime%(random.nextInt(30) + 1) ==1) attack(spaceShip, pane);
								lastTime = now;
							}
							if(isBOOM) this.stop();
						}
						
					};timer2.start();
				}
				else {
					position.add(vector);
					setPosition(position);
				}
				
			}
		};timer.start();
		
		
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		BulletEnemy dan1 = new BulletEnemy();
		BulletEnemy dan2 = new BulletEnemy();
		Point temp1 = new Point(getCenter().getX()-150,getCenter().getY()+50);
		Point temp2 = new Point(getCenter().getX()+150,getCenter().getY()+50);
		
		Point pos1 = new Point(-75, 0);
		pos1.add(spaceShip.getPosition());
		Point pos2 = new Point(+75, 0);
		pos2.add(spaceShip.getPosition());
		 
		dan1.setPosition(temp1);
		dan1.move(spaceShip, pane, pos1);
		dan2.setPosition(temp2);
		dan2.move(spaceShip,pane, pos2);
	}
}
	
	