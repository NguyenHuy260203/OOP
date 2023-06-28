package view.controller;

import java.io.IOException;

import manager.GamePlayManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {
	/*
	 * public void Play(ActionEvent event) throws IOException {
	 * 
	 * menuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	 * menuStage.hide();
	 * 
	 * gameStage = new Stage(); new GamePlayManager(gameStage); gameStage.show(); }
	 */
	public void start(Stage primaryStage) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MenuScene.fxml"));
			Scene menuScene = new Scene(root);
			primaryStage.setScene(menuScene);
			primaryStage.show();

			// EXITBUTTON
			Button exitButton = (Button) root.lookup("#exitButton");
			exitButton.setOnAction(event -> Platform.exit());

			// CREDITBUTTON
			Button creditButton = (Button) root.lookup("#creditButton");
			creditButton.setOnAction(event -> showCreditStage(primaryStage));

			// HELP BUTTON
			Button helpButton = (Button) root.lookup("#helpButton");
			helpButton.setOnAction(EventHandler -> showHelpStage(primaryStage));
			
			// PLAYBUTTON
			Button playButton = (Button) root.lookup("#startButton");
//			playButton.setOnAction(EventHandler -> showModeStage(primaryStage));
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void showCreditStage(Stage primaryStage) {
		try {
			Parent root1 = FXMLLoader.load(getClass().getResource("CreditScene.fxml"));
			Scene creditScene = new Scene(root1);
			primaryStage.setScene(creditScene);
			primaryStage.show();
			// BACkBUTTON
			Button backButton = (Button) root1.lookup("#backButton");
			backButton.setOnAction(EventHandler -> start(primaryStage));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//HELP SCENE
		public void showHelpStage(Stage primaryStage) {
			try {
				Parent root2 = FXMLLoader.load(getClass().getResource("HelpScene.fxml"));
				Scene helpScene = new Scene(root2);
				primaryStage.setScene(helpScene);
				primaryStage.show();
				// BACkBUTTON
				Button backButton = (Button) root2.lookup("#backButton");
				backButton.setOnAction(EventHandler -> start(primaryStage));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
