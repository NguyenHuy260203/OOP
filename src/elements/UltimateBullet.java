package elements;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;

public class UltimateBullet extends Bullet {
	public UltimateBullet(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width,heigh,0, vector);
		// TODO Auto-generated constructor stub
	}
	public UltimateBullet() {
		this("/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_00.png",150,700,new Point(0,1));
		
	}
	public void Shoot(SpaceShip spaceShip, AnchorPane pane, ArrayList<Entity> E) {
		if (spaceShip.getUltiCount() > 0) {
			System.out.println("Kamehamehahahaahahahaah....");
			//ultiCount -1
			spaceShip.setUltiCount(spaceShip.getUltiCount() - 1);
			
//			spaceShip.setBulletStore(spaceShip.getBulletStore()-6);
//			spaceShip.setCachBan(1);
			Point position = new Point(-30, -700);
			position.add(spaceShip.getPosition());
			pane.getChildren().add(getImageView());
			
			setPosition(position);
			String[] FRAME_PATH = {
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_00.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_01.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_02.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_03.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_04.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_05.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_06.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_07.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_08.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_09.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_10.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_11.png",
					"/resourses/gamekit/spritesheets/UltimateBullet/Heaven's Fury VFX_Animation 1_12.png"};
			AnimationTimer timer = new AnimationTimer() {
				int currentFrame = 0;
				long lastTime;
				@Override
				public void handle(long now) {
					// TODO Auto-generated method stub
					if(currentFrame == 1) {
						spaceShip.canDiChuyen = false;
						PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
						delay.setOnFinished(event ->{
							spaceShip.canDiChuyen = true;
						});
						delay.play();
						
					}
					if(currentFrame == 3) {
						for(int i = 0;i<E.size();i++) {
							Entity e = E.get(i);
						
							if(hasVaCham(e)) {
								e.setHP((e.getHP()-3)>0?(e.getHP()-3):0);
								if(e.getHP()!=0)e.dau();
								if(e.getHP()<=0) {
									e.no();
									E.remove(e);
									e = null;
									if(e instanceof Stone) spaceShip.setScore(spaceShip.getScore()+1);
									else spaceShip.setScore(spaceShip.getScore()+2);
									
								}
							}
						}
					}
					if(currentFrame == 12 ) {
						this.stop();
						
					}
					if(now - lastTime>=1e9/10 && currentFrame < 12) {
						Image image = new Image(FRAME_PATH[currentFrame]);
						getImageView().setImage(image);
						currentFrame++;
						lastTime = now;
					}
				}	
				
				
			};timer.start();
		}
	}
}

	


	   
	
	


	


