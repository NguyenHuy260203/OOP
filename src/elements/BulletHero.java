package elements;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;
public class BulletHero extends Bullet{
	Point position = new Point(30, 20);//vị trí so với ufo
	int mode;
	public BulletHero(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh, vector);
	}
	public BulletHero(int mode) {
		this("/resourses/gamekit/spritesheets/basicBullet.png",
			 30, 30, new Point(0, -15));
		this.mode = mode;
	}
	
	public void Shoot(SpaceShip spaceShip, AnchorPane pane,ArrayList<Entity> E) {
		spaceShip.setBulletStore(spaceShip.getBulletStore()-1);
		position.add(spaceShip.getPosition());
		this.setPosition(position);
		
		pane.getChildren().add(this.getImageView());
		
		AnimationTimer bulletTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				position.add(getVector());
				
				setPosition(position);
				for(int i = 0;i<E.size();i++) {
					Entity e = E.get(i);
					
					if(hasVaCham(e)) {
						e.setHP(e.getHP()-1);
						if(e.getHP()!=0) e.dau();
						if(e.getHP()<=0) {
							e.no();
							E.remove(e);
							e = null;
							if(e instanceof Stone) spaceShip.setScore(spaceShip.getScore()+1);
							else spaceShip.setScore(spaceShip.getScore()+2);
							
						}
					
						pane.getChildren().remove(getImageView());
						this.stop();
					}
					
				}
                if (mode == 1) {
                	if (position.getX() < 200 || position.getX() > 1200)
                		getVector().setX(-getVector().getX());
                }
				
				
				if (position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// dung animationTimer lai
				}	
			}
		};
		bulletTimer.start();
	}
}
