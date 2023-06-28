package elements;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import lib.Point;

//vat pham roi tu tren troi xuong
public abstract class ExtraPresent extends Entity {

	private Point vector;
	public Point getVector() {
		return vector;
	}

	public void setVector(Point vector) {
		this.vector = vector;
	}

	public ExtraPresent(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh,0);
		// TODO Auto-generated constructor stub
	}

	public void move(SpaceShip spaceShip,AnchorPane pane) {
		//di chuyen xuong duoi, neu UFO do duoc thi bien mat va tac dung hieu ung len UFO
		pane.getChildren().add(this.getImageView());
		Point position = this.getPosition();
		AnimationTimer presentTimer = new AnimationTimer() {
			

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				position.add(vector);
				setPosition(position);
				if(hasVaCham(spaceShip)) {
					effectPresent(spaceShip);
					setPosition(new Point(1000,1000));
					this.stop();
				}
				
			}
			
			
		};presentTimer.start();
		
		
	}
	public abstract void effectPresent(SpaceShip spaceShip);
}
