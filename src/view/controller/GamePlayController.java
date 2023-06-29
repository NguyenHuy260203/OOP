package view.controller;

import elements.SpaceShip;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GamePlayController {
	
	@FXML private AnchorPane GamePane;
	public AnchorPane getGamePane() {
		return GamePane;
	}
	@FXML private ProgressBar hpBar;
	public ProgressBar getHpBar() {
		return hpBar;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public void setHpBar(ProgressBar hpBar) {
		this.hpBar = hpBar;
	}
	@FXML private ImageView background1;
	@FXML private ImageView background2;
	@FXML private Text countBullet;
	@FXML private Text score;
	@FXML private ProgressBar ultiBar;
	@FXML
	private Text level;
	@FXML
	private VBox vBox;
	public void setLevel(String s) {
		level.setText(s);
		FadeTransition fade = new FadeTransition();
		fade.setNode(level);
		fade.setDuration(Duration.seconds(2));
		fade.setCycleCount(1);
	
		fade.setFromValue(1);
		fade.setToValue(0);
		fade.play();
		fade.setOnFinished(event->{
			level.setOpacity(0);
		});
		
	}
	public Text getLevel() {
		return this.level; 
	}
	public ProgressBar getUltiBar() {
		return ultiBar;
	}
	public void setUltiBar(ProgressBar ultiBar) {
		this.ultiBar = ultiBar;
	}
	public Text getCountBullet() {
		return countBullet;
	}

	public void setCountBullet(Text countBullet) {
		this.countBullet = countBullet;
	}

	public Text getScore() {
		return score;
	}

	public void setScore(Text score) {
		this.score = score;
	}

	public void initialize() {
		hpBar.setProgress(1);
		spaceShip = new SpaceShip();
		GamePane.getChildren().add(spaceShip.getImageView());
		vBox.toFront();
		countBullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		hpBar.setProgress(spaceShip.getHP()/10.0);
		//bullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		score.setText("Score: "+ spaceShip.getScore());
		level.setFont(Font.loadFont(getClass().getResourceAsStream("/view/font_dep.ttf"), 100));
		level.setOpacity(0);
		
	}
	public void createMoveBackground() {
		background1.setLayoutY(background1.getLayoutY()+1.5);
		background2.setLayoutY(background2.getLayoutY()+1.5);
		if (background1.getLayoutY()> 808) {
			background1.setLayoutY(-808);
		}
		if (background2.getLayoutY() > 808) {
			background2.setLayoutY(-808);
		}
	}
	private SpaceShip spaceShip;
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	private boolean canShoot = true;
	private Text bossText;
	private int mode;

	public void displayInfor() {
		countBullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		hpBar.setProgress(spaceShip.getHP()/15.0);
		ultiBar.setProgress(spaceShip.getUltiCount()/7.0);
		score.setText("Score: "+ spaceShip.getScore());
	}

	
	
}
