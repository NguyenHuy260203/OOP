package manager;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.controller.GamePlayController;

public class GamePlayManager {
	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private boolean isSpaceKeyPressed;
	private boolean isRKeyPressed;
	private boolean isFKeyPressed;
	public GamePlayManager() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GamePlay.fxml"));
		
		AnchorPane gameRoot = loader.load();
		controller = loader.getController();
		
		String css = getClass().getResource("/view/gamePlay.css").toExternalForm();
		gameScene = new Scene(gameRoot);
		gameScene.getStylesheets().add(css);
		gameScene.setOnKeyPressed(event->{
			KeyCode keyCode = event.getCode();
			if (keyCode == KeyCode.LEFT) isLeftKeyPressed = true;
			else if (keyCode == KeyCode.RIGHT) isRightKeyPressed = true;
			else if (keyCode == KeyCode.SPACE) isSpaceKeyPressed = true;
			else if (keyCode == KeyCode.R) isRKeyPressed = true;
			else if (keyCode == KeyCode.F) isFKeyPressed = true;
		});
		gameScene.setOnKeyReleased(event->{
			KeyCode keyCode = event.getCode();
			if (keyCode == KeyCode.LEFT) isLeftKeyPressed = false;
			else if (keyCode == KeyCode.RIGHT) isRightKeyPressed = false;
			else if (keyCode == KeyCode.SPACE) isSpaceKeyPressed = false;
			else if (keyCode == KeyCode.R) isRKeyPressed = false;
			else if (keyCode == KeyCode.F) isFKeyPressed = false;
		});
	}
	public GamePlayManager(Stage gameStage, int mode) throws IOException {
		this();
		gameStage.setScene(gameScene);
		controller.setMode(mode);
		controller.getSpaceShip().setMode(controller.getGamePane(), mode);
		Event event = new Event(controller);
		
		gameTimer = new AnimationTimer() {	
			
			@Override
			public void handle(long now) {
				event.timeLine(now);
				controller.displayInfor();
				controller.createMoveBackground();
				int dangChoi = controller.getSpaceShip().getHP();
				if(dangChoi <= 0) {
					controller.getSpaceShip().setHP(0);
					controller.getSpaceShip().no();
					
					this.stop();
					PauseTransition pause = new PauseTransition(Duration.seconds(0.9));
					pause.setOnFinished(x->{
						try {
							event.gameOver();
							gameStage.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					});			
					pause.play();
				}
				event.handleKey(isLeftKeyPressed, isRightKeyPressed, isSpaceKeyPressed, isRKeyPressed, isFKeyPressed);
				
			}
		};
		gameTimer.start();
	}
	
	private Scene gameScene;
	private GamePlayController controller;
	private AnimationTimer gameTimer;
}
