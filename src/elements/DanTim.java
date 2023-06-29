package elements;

import javafx.scene.layout.AnchorPane;
import lib.Point;

public class DanTim extends Bullet{

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

