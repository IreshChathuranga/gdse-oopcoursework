package lk.ijse.gdse.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent run= FXMLLoader.load(getClass().getResource("/view/Board.fxml"));
        Scene scene = new Scene(run);
        stage.setScene(scene);
        stage.setTitle("Sample Application");
        stage.show();
    }
}