package view.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import manager.GamePlayManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController implements Initializable{
	/*
	 * public void Play(ActionEvent event) throws IOException {
	 * 
	 * menuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	 * menuStage.hide();
	 * 
	 * gameStage = new Stage(); new GamePlayManager(gameStage); gameStage.show(); }
	 */
	public void start(Stage menuStage) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MenuScene.fxml"));
			Scene menuScene = new Scene(root);
			menuStage.setScene(menuScene);
			menuStage.show();

			
			// playButton.setOnAction(event->menuStage.hide());
			
////			 EXITBUTTON
//			Button exitButton = (Button) root.lookup("#exitButton");
//			exitButton.setOnAction(event -> Platform.exit());
//
//			// CREDITBUTTON
//			Button creditButton = (Button) root.lookup("#creditButton");
//			creditButton.setOnAction(event -> showCreditStage(primaryStage));
//			
////			
//			// HELP BUTTON
//			Button helpButton = (Button) root.lookup("#helpButton");
//			helpButton.setOnAction(EventHandler -> showHelpStage(primaryStage));
//			
//			// PLAYBUTTON
//			Button playButton = (Button) root.lookup("#startButton");
////			playButton.setOnAction(EventHandler -> showModeStage(primaryStage));
//			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	@FXML
	public void onCredit() {
		credit.setOpacity(0.85);
	}
	@FXML
	public void offCredit() {
		credit.setOpacity(1);
	}
	@FXML
	public void onStart() {
		start.setOpacity(0.85);
	}
	@FXML
	public void offStart() {
		start.setOpacity(1);
	}
	@FXML
	public void onHelp() {
		help.setOpacity(0.85);
	}
	@FXML
	public void offHelp() {
		help.setOpacity(1);
	}
	@FXML
	public void onExit() {
		exit.setOpacity(0.85);
	}
	@FXML
	public void offExit() {
		exit.setOpacity(1);
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
//			controller.stopMusic();
//			playMusic();
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
			
			Button backButton = (Button) modeParent.lookup("#backButton");
			backButton.setOnAction(event -> {
				menuStage.show();
				modeStage.close();
			});
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
		@FXML private ImageView start;
		@FXML private ImageView help;
		@FXML private ImageView credit;
		@FXML private ImageView exit;
		@FXML private ImageView back;
		@FXML private Text banTumLum = new Text();
		
		public void on() {
			back.setOpacity(0.85);
		}
		public void off() {
			back.setOpacity(0.85);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			banTumLum.setFont(Font.loadFont(getClass().getResourceAsStream("/view/KickhornetfreepersonalusBold-DOZ6D.otf"), 200));;

		}
		
}
