package manager;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.controller.MenuController;

public class MenuManager extends MenuController {
	private Scene menuScene;

	public MenuManager() throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("/view/MenuScene.fxml"));

		menuScene = new Scene(loader);
	}

	public MenuManager(Stage menuStage) throws IOException {
		this();
		menuStage.setScene(menuScene);
		menuStage.centerOnScreen();
		menuStage.setAlwaysOnTop(false);
		menuStage.show();

		Stage creditStage = new Stage();
		Stage helpStage = new Stage();
		Stage modeStage = new Stage();
		
		Button exitButton = (Button) menuScene.lookup("#exitButton");
		exitButton.setOnAction(event -> Platform.exit());

		// CREDITBUTTON
		Button creditButton = (Button) menuScene.lookup("#creditButton");
		creditButton.setOnAction(event -> showCreditStage(creditStage, menuStage));
		// creditButton.setOnAction(event-> menuStage.hide());

		// HELP BUTTON
		Button helpButton = (Button) menuScene.lookup("#helpButton");
		helpButton.setOnAction(event -> showHelpStage(helpStage,menuStage));
		
		// STARTBUTTON
		Button startButton = (Button) menuScene.lookup("#startButton");
		startButton.setOnAction(event -> showModeStage(modeStage, menuStage));
	}

	
}
