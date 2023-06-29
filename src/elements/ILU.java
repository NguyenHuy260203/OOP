package elements;

import lib.Point;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;

public class ILU extends Entity {
	private AnimationTimer timer ;

	public AnimationTimer getTimer() {
		return this.timer;
	}
	public ILU(String linkImage, float width, float heigh,int HP, Point vector) {
		super(linkImage, width, heigh, HP);
		this.vector = vector;
	}
	
	private Point vector = new Point();
	public void setVector(Point p) {
		this.vector = p;
	}
	public Point getVector() {
		return vector;
	}
	
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		getImageView().toBack();
		pane.getChildren().add(this.getImageView());
		Point position = this.getPosition();
		
		 timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
			     
				position.add(vector);
				setPosition(position);
				
				if (position.getY() > 800 || position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// stop animationTimer
				}
				else if (hasVaCham(spaceShip)) {
					System.out.println("BOOM");
					pane.getChildren().remove(getImageView());
					attack(spaceShip, pane);
					this.stop();
				}
				effect();
			}
		};
		timer.start();
	}
	public void attack(SpaceShip spaceShip, AnchorPane pane) {}
	public void init(SpaceShip spaceShip) {}
	public void effect() {}
}
