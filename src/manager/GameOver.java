package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import elements.SpaceShip;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.controller.GameOverController;

public class GameOver extends GamePlayManager {

	Stage playStage = new Stage();
	Stage menuStage = new Stage();
	int mode;
	
	public GameOver(Stage gameOverStage, SpaceShip spaceShip, int mode) throws IOException {
		int yourScore = spaceShip.getScore();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		FileReader fileReader = new FileReader("src/manager/scores.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		String line;
		while((line = reader.readLine()) != null) {
			scores.add(Integer.parseInt(line));
			
		}
		reader.close();
		fileReader.close();
		scores.add(yourScore);
		Collections.sort(scores,(a,b)->b-a);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameOver.fxml"));
		Parent root = loader.load();
		GameOverController controller = loader.getController();
		controller.setScore(yourScore);
		controller.setFirst(scores.get(0)+"");
	
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/manager/scores.txt",false))) {
			for(int i = 0;i<3;i++) {
				writer.write(String.valueOf(scores.get(i)));
				writer.newLine();
			}
		}
		Scene scene = new Scene(root, 1280, 800);
		gameOverStage.setScene(scene);
		gameOverStage.show();

		Button playAgainButton = (Button) root.lookup("#playAgainButton");
		// playAgainButton.setOnAction(event -> gameOverStage.hide());
		playAgainButton.setOnAction(event -> showPlayStage(playStage, gameOverStage));

		Button mainMenuButton = (Button) root.lookup("#mainMenuButton");
		mainMenuButton.setOnAction(event -> showMainMenuStage(gameOverStage, menuStage));

		// mainMenuButton.setOnAction(event-> )

	}

	public void showPlayStage(Stage playStage, Stage gameOverStage) {


		try {
			new GamePlayManager(playStage, mode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playStage.show();
		gameOverStage.hide();

	}

	public void showMainMenuStage(Stage gameOverStage, Stage menuStage) {
		try {
			new MenuManager(menuStage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		menuStage.show();
		gameOverStage.hide();
	}
}
