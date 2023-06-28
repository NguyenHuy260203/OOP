package elements;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;
import lib.Point;

public class UpgradeShoot {
	private int soDan;
	private int mode;
	public UpgradeShoot(int soDan, double goc, int mode) {
		this.soDan = soDan;
		for(int i = 0;i<soDan;i++) {
			Point vector = new Point(0, -15);
			vector.rotateLeft(goc/180.0*3.14);
			
			BulletHero bulletHero = new BulletHero(mode);
			bulletHero.setVector(vector);
			
			bullet.add(bulletHero);
		}
	}
	//ban nhieu tia
	ArrayList<BulletHero> bullet = new ArrayList<BulletHero>();
	
	public void Shoot(SpaceShip spaceShip,AnchorPane pane, ArrayList<Entity> E) {
			switch(soDan) {
			case 2: {
				bullet.get(0).getVector().rotateLeft(15.0/180*3.14);
				bullet.get(1).getVector().rotateLeft(-15.0/180*3.14);
				break;
				}
			case 3: {
				bullet.get(0).getVector().rotateLeft(20.0/180*3.14);
				bullet.get(2).getVector().rotateLeft(-20.0/180*3.14);
				break;
				}
			case 4: {
				bullet.get(0).getVector().rotateLeft(20.0/180*3.14);
				bullet.get(1).getVector().rotateLeft(12.0/180*3.14);
				bullet.get(2).getVector().rotateLeft(-12.0/180*3.14);
				bullet.get(3).getVector().rotateLeft(-20.0/180*3.14);
				break;
				
			}
			case 5: {
				bullet.get(0).getVector().rotateLeft(20.0/180*3.14);
				bullet.get(1).getVector().rotateLeft(5.0/180*3.14);
				bullet.get(3).getVector().rotateLeft(-5.0/180*3.14);
				bullet.get(4).getVector().rotateLeft(-20.0/180*3.14);
				break;
			}
			}
			for(int i = 0;i<soDan;i++) {
				bullet.get(i).Shoot(spaceShip, pane, E);
			}
			
				
		}
			
		
		
	}
	

