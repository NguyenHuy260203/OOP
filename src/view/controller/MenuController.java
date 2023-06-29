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
	public void start(Stage primaryStage) {

//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("/view/MenuScene.fxml"));
//			Scene menuScene = new Scene(root);
//			primaryStage.setScene(menuScene);
//			primaryStage.show();

			// EXITBUTTON
//			Button exitButton = (Button) root.lookup("#exitButton");
//			exitButton.setOnAction(event -> Platform.exit());
//
//			// CREDITBUTTON
//			Button creditButton = (Button) root.lookup("#creditButton");
//			creditButton.setOnAction(event -> showCreditStage(primaryStage));
//			
//			
//			// HELP BUTTON
//			Button helpButton = (Button) root.lookup("#helpButton");
//			helpButton.setOnAction(EventHandler -> showHelpStage(primaryStage));
//			
//			// PLAYBUTTON
//			Button playButton = (Button) root.lookup("#startButton");
////			playButton.setOnAction(EventHandler -> showModeStage(primaryStage));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
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
//	public void showCreditStage(Stage primaryStage) {
//		try {
//			Parent root1 = FXMLLoader.load(getClass().getResource("CreditScene.fxml"));
//			Scene creditScene = new Scene(root1);
//			primaryStage.setScene(creditScene);
//			primaryStage.show();
//			// BACkBUTTON
//			Button backButton = (Button) root1.lookup("#backButton");
//			backButton.setOnAction(EventHandler -> start(primaryStage));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	//HELP SCENE
//		public void showHelpStage(Stage primaryStage) {
//			try {
//				Parent root2 = FXMLLoader.load(getClass().getResource("HelpScene.fxml"));
//				Scene helpScene = new Scene(root2);
//				primaryStage.setScene(helpScene);
//				primaryStage.show();
//				// BACkBUTTON
//				Button backButton = (Button) root2.lookup("#backButton");
//				backButton.setOnAction(EventHandler -> start(primaryStage));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		@FXML private ImageView start;
		@FXML private ImageView help;
		@FXML private ImageView credit;
		@FXML private ImageView exit;
		@FXML private ImageView back;
		@FXML private Text banTumLum;
		
		public void on() {
			back.setOpacity(0.85);
		}
		public void off() {
			back.setOpacity(0.85);
		}
//		private MediaPlayer mediaPlayer;
//		public void playMusic() {
//			mediaPlayer.play();
//		}
//		public void stopMusic() {
//			mediaPlayer.stop();
//		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
//			String soundFile = "src/manager/m.mp3";
//			Media media = new Media(new File(soundFile).toURI().toString());
//			mediaPlayer = new MediaPlayer(media);
//			mediaPlayer.setVolume(0.5);
//			playMusic();
			banTumLum.setFont(Font.loadFont(getClass().getResourceAsStream("/view/KickhornetfreepersonalusBold-DOZ6D.otf"), 200));;

		}
		
}
