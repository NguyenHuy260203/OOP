package application;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import manager.MenuManager;

public class Main extends Application {
	private Stage mainStage = new Stage();
	
	@Override
	public void start(Stage arg0) throws Exception {
		new MenuManager(mainStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
