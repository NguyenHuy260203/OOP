package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ModeController implements Initializable{
	@FXML private Text banTumLum;
	@FXML private Text easy;
	@FXML private Text hard;
	@FXML private Button easyButton;
	@FXML private Button hardButton;
	public void onEasy() {
		
		easy.setScaleX(1.3);
		easy.setScaleY(1.3);
		easy.setOpacity(0.85);
	}
	public void offEasy() {
		easy.setScaleX(1);
		easy.setScaleY(1);
		easy.setOpacity(1);
	}
	public void onHard() {
		hard.setScaleX(1.3);
		hard.setScaleY(1.3);
		hard.setOpacity(0.85);
	}
	public void offHard() {
		hard.setScaleX(1);
		hard.setScaleY(1);
		hard.setOpacity(1);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		banTumLum.setFont(Font.loadFont(getClass().getResourceAsStream("/view/KickhornetfreepersonalusBold-DOZ6D.otf"), 200));;
	}
}