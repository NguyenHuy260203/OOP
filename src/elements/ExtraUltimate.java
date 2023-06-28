package elements;

import java.util.Random;

import lib.Point;

public class ExtraUltimate extends ExtraPresent{

	public ExtraUltimate() {
		super("/resourses/gamekit/spritesheets/cherry_ultimate.png", 60, 60);
		// TODO Auto-generated constructor stub
		this.setVector(new Point(0,11));
		Random random = new Random();
		this.setPosition(new Point((int) (random.nextDouble()*1100 + 100),0));
	}

	@Override
	public void effectPresent(SpaceShip spaceShip) {
		if (spaceShip.getUltiCount() < 3) 
			spaceShip.setUltiCount(spaceShip.getUltiCount()+1);
		
	}

}
