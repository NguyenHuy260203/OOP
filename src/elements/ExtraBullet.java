package elements;

import java.util.Random;

import lib.Point;

public class ExtraBullet extends ExtraPresent{

	public ExtraBullet() {
		super("/resourses/gamekit/spritesheets/AMM_bullet.png", 60, 60);
		this.setVector(new Point(0,11));
		Random random = new Random();
		this.setPosition(new Point((int) (random.nextDouble()*1100 + 100),0));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effectPresent(SpaceShip spaceShip) {
		// TODO Auto-generated method stub
		spaceShip.setBulletStore(spaceShip.getBulletStore() + 50);
		
	}

}
