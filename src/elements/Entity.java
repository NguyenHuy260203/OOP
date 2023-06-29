package elements;

import lib.Point;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Entity {
	private ImageView imageView;
	private Point position = new Point();
	private double domainX,domainY;
	private double Width,Height;//Chiều rộng và chiều dài của thực thể
	private int HP;// máu
	public boolean isBOOM = false;
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public double getWidth() {
		return Width;
	}

	public void setWidth(double width) {
		Width = width;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position.setLocation(position);
		imageView.setLayoutX(position.getX());
		imageView.setLayoutY(position.getY());
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Entity(String linkImage, float width, float heigh, int HP) {
		this.Width = width;
		this.Height = heigh;
		this.HP = HP;
		imageView = new ImageView(linkImage);
		imageView.setFitWidth(width);
		imageView.setFitHeight(heigh);
		domainY = heigh/2;
		domainX = width/2;
		
	}
	//lấy tâm của thực thể
	public Point getCenter() {
		Point point = new Point(Width/2,Height/2);
		point.add(position);
		return point;
	}
	
	public boolean hasVaCham(Entity entity) {
		Point vector = new Point();
		vector.setLocation(getCenter());
		vector.sub(entity.getCenter());
		if(Math.abs(vector.getX())<=this.domainX+entity.domainX&&Math.abs(vector.getY())<=this.domainY+entity.domainY) {
			if(!entity.isBOOM) return true;
		}
		
		return false;
	}
	public void no() {//nổ
		isBOOM = true;   
		String[] FRAME_PATH = {
				"/resourses/gamekit/spritesheets/explosion1.png",
				"/resourses/gamekit/spritesheets/explosion2.png",
				"/resourses/gamekit/spritesheets/explosion3.png",
				"/resourses/gamekit/spritesheets/explosion4.png",
				"/resourses/gamekit/spritesheets/explosion5.png",
				"/resourses/gamekit/spritesheets/explosion6.png",
				"/resourses/gamekit/spritesheets/explosion7.png",
				"/resourses/gamekit/spritesheets/explosion8.png"
		};
		
		AnimationTimer timer = new AnimationTimer() {
			int currentFrame = 0;
			long lastTime = 0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(currentFrame == 8) {
					this.stop();
					
				}
				if(now - lastTime>=1e9/10 && currentFrame < 8) {
					Image image = new Image(FRAME_PATH[currentFrame]);
					getImageView().setImage(image);
					currentFrame++;
					lastTime = now;
				}

			}
			
		};timer.start();
		isBOOM = true;
	}
public void dau() {//đau
		
		FadeTransition fade = new FadeTransition();
		fade.setNode(getImageView());
		fade.setDuration(Duration.millis(100));
		fade.setCycleCount(4);
		fade.setInterpolator(Interpolator.LINEAR);
		fade.setFromValue(1);
		fade.setToValue(0.1);
		fade.setAutoReverse(true);
		fade.play();
		
	}
}
