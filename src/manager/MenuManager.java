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
		// playButton.setOnAction(event->menuStage.hide());
	}

	public void showCreditStage(Stage creditStage, Stage menuStage) {
		try {

			Parent creditParent = FXMLLoader.load(getClass().getResource("/view/CreditScene.fxml"));
			Scene creditScene = new Scene(creditParent);
			creditStage.setScene(creditScene);
			creditStage.show();
			menuStage.close();
			// BACkBUTTON
			Button backButton = (Button) creditParent.lookup("#backButton");
			// backButton.setOnAction(EventHandler -> start(primaryStage));
			backButton.setOnAction(event -> {
				menuStage.show();
				creditStage.close();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// HELP SCENE
	public void showHelpStage(Stage helpStage, Stage menuStage) {
		try {
			Parent helpParent = FXMLLoader.load(getClass().getResource("/view/HelpScene.fxml"));
			Scene helpScene = new Scene(helpParent);
			helpStage.setScene(helpScene);
			helpStage.show();
			menuStage.close();
			// BACkBUTTON
			Button backButton = (Button) helpParent.lookup("#backButton");
			// backButton.setOnAction(EventHandler -> start(primaryStage));
			backButton.setOnAction(event -> {
				menuStage.show();
				helpStage.close();

			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showModeStage(Stage modeStage, Stage menuStage) {
		try {
			Parent modeParent = FXMLLoader.load(getClass().getResource("/view/ModeScene.fxml"));
			Scene modeScene = new Scene(modeParent);
			modeStage.setScene(modeScene);
			modeStage.show();
			menuStage.close();
			
			Stage playStage = new Stage();
			
			Button easyButton = (Button) modeParent.lookup("#easyButton");
			easyButton.setOnAction(event -> showPlayStage(playStage, modeStage, 0));
			
			Button hardButton = (Button) modeParent.lookup("#hardButton");
			hardButton.setOnAction(event -> showPlayStage(playStage, modeStage, 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showPlayStage(Stage playStage, Stage modeStage, int mode) {
		/*
		 * public void Play(ActionEvent event) throws IOException {
		 * 
		 * menuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 * menuStage.hide();
		 * 
		 * gameStage = new Stage(); new GamePlayManager(gameStage); gameStage.show(); }
		 */
		try {
			new GamePlayManager(playStage, mode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playStage.show();
		modeStage.close();
	}
	
}
