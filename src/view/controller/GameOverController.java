package view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverController implements Initializable  {
		@FXML
		private Text first;
		@FXML
		private Text second;
		@FXML
		private Text third;
		@FXML
		private Text gameOver;
		@FXML 
		private Text yourScore;
		@FXML
		private Text highScore;
		public void setFirst(String s) {
			first.setText(s);
		}
		public void setSecond(String s) {
			second.setText(s);
		}
		public void setThird(String s) {
			third.setText(s);
		}
		public void setScore(int score) {
			yourScore.setText("Your Score: "+score);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			gameOver.setFont(Font.loadFont(getClass().getResourceAsStream("/view/font_dep.ttf"), 130));
			first.setFont(Font.loadFont(getClass().getResourceAsStream("/view/font_dep.ttf"), 30));

		//	third.setFont(Font.loadFont(getClass().getResourceAsStream("/view/font_dep.ttf"), 30));
			highScore.setFont(Font.loadFont(getClass().getResourceAsStream("/view/font_dep.ttf"), 40));
			yourScore.setFont(Font.loadFont(getClass().getResourceAsStream("/view/font_dep.ttf"), 40));
			
		}
		
}
