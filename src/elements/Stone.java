package elements;

import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;

public class Stone extends ILU {
	private boolean no = false;
	public Stone(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh,2, vector);
	}
	public Stone() {
		this("/resourses/gamekit/spritesheets/enermy/stoneEnermy/stone1.png",
			 50, 50, new Point(0, 5));
		setPosition(new Point(ThreadLocalRandom.current().nextInt(40,1250), 0));
	}
	
	private double imageAngle = 0;
	
	@Override
	public void effect() {
		getImageView().setRotate(imageAngle);
		imageAngle += 3;
	}
	
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		
		if(!isBOOM) {
			spaceShip.dau();
			       if(spaceShip.getHP()>0)spaceShip.setHP(spaceShip.getHP()-1>0?spaceShip.getHP()-1:0);
		}
	}
	
}
