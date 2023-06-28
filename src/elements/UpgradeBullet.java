package elements;

import java.util.Random;

import lib.Point;

public class UpgradeBullet extends ExtraPresent{
	//constructor
	
	public UpgradeBullet() {
		super("/resourses/gamekit/spritesheets/power-up.png",50,50);
		this.setVector(new Point(0,8));
		Random random = new Random();
		this.setPosition(new Point((int) (random.nextDouble()*1000 + 100),0));
	}

	@Override
	public void effectPresent(SpaceShip spaceShip) {
		// TODO Auto-generated method stub
	//	spaceShip.setBulletStore(spaceShip.getBulletStore()+30);
		int cachBan = spaceShip.getCachBan();
		if(cachBan<5) {
			spaceShip.setCachBan(cachBan + 1);
			spaceShip.setScore(spaceShip.getScore()+2);
		}
		
	}
	
}
