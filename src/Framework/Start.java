package Framework;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by peterzen on 2017-03-27.
 * Part of the framework project.
 */
public class Start extends Application {
    private Stage stage;

    public Start() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World from Framework.Start");

        System.out.println(Config.get("game", "turnTimeout"));

        Start.launch(args);

    }

    public void initialize() {
        // BoardController board = new BoardController();
        // board.drawGrid(3);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Games");
        Parent root = FXMLLoader.load(getClass().getResource("/Framework/GUI/View.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void newTTTGame(ActionEvent actionEvent) {
        System.out.println("Start new TicTacToe game...");
    }

    public void newOthGame(ActionEvent actionEvent) {
        System.out.println("Start new Othello game...");
    }

    public void pause(ActionEvent actionEvent) {
        System.out.println("Game paused");
    }

    public void endGame(ActionEvent actionEvent) {
        System.out.println("Game ended");
    }

    public void showHighScores(ActionEvent actionEvent) {
        System.out.println("High scores");
    }

    public void giveHint(ActionEvent actionEvent) {
        System.out.println("Possible next move");
    }

    public void undoMove(ActionEvent actionEvent) {
        System.out.println("Undo move");
    }

    public void saveGame(ActionEvent actionEvent) {
        System.out.println("Saving game...");
    }

    public void quit(ActionEvent actionEvent) {
        System.out.println("Quit game");
        Platform.exit();
    }

}
