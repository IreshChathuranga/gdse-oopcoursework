package lk.ijse.gdse.tictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import lk.ijse.gdse.tictactoe.AiPlayer;
import lk.ijse.gdse.tictactoe.BoardImpl;
import lk.ijse.gdse.tictactoe.Piece;

import java.io.IOException;

public class BoardController {
    @FXML
    public GridPane gridPane;
    @FXML
    private BoardImpl board;
    @FXML
    private AiPlayer aiPlayer;
    @FXML
    private boolean playerTurn = true;

    @FXML
    private Button btn00;

    @FXML
    private Button btn01;

    @FXML
    private Button btn02;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private Button btnRestart;

    @FXML
    private Label lblLable;

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    public void initialize() {
        board = new BoardImpl();
        aiPlayer = new AiPlayer(board);
    }

    @FXML
    public void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);

        if (board.isLegalMove(row, col)) {
            // Human (X) move
            clickedButton.setText("X");
            board.updateMove(row, col, Piece.X);

            // Check for a winner or tie after the human move
            if (checkGameState(Piece.X)) return;

            // AI (O) move
            aiPlayer.Move(row, col);  // AI calculates its move and updates the board
            updateBoardUI();  // Update the buttons in the UI with AI's move

            // Check for a winner or tie after the AI move
            checkGameState(Piece.O);
        }
    }
    @FXML
    private boolean checkGameState(Piece currentPlayerPiece) {
        if (board.checkWinner() != Piece.EMPTY) {
            lblLable.setText("Player " + (currentPlayerPiece == Piece.X ? "X" : "O") + " wins!");
            disableBoard();
            return true;
        } else if (board.isFull()) {
            lblLable.setText("It's a tie!");
            return true;
        } else {
            lblLable.setText("Player " + (currentPlayerPiece == Piece.X ? "O" : "X") + "'s turn");
            return false;
        }
    }
    @FXML
    private void updateBoardUI() {
        // Update the UI with AI's move
        updateButton(btn00, 0, 0);
        updateButton(btn01, 1, 0);
        updateButton(btn02, 2, 0);
        updateButton(btn10, 0, 1);
        updateButton(btn11, 1, 1);
        updateButton(btn12, 2, 1);
        updateButton(btn20, 0, 2);
        updateButton(btn21, 1, 2);
        updateButton(btn22, 2, 2);
    }
    private void updateButton(Button button, int row, int col) {
        if (board.getPiece(row, col) == Piece.O) {
            button.setText("O");
        }
    }

    @FXML
    private void disableBoard() {
        btn00.setDisable(true);
        btn01.setDisable(true);
        btn02.setDisable(true);
        btn10.setDisable(true);
        btn11.setDisable(true);
        btn12.setDisable(true);
        btn20.setDisable(true);
        btn21.setDisable(true);
        btn22.setDisable(true);
    }

    @FXML
    public void btnRestartOnAction(ActionEvent actionEvent) throws IOException {
        navigateTo("/view/Board.fxml");
    }
    public void navigateTo(String fxmlPath)  {
        try {
            mainAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            mainAnchor.getChildren().add(load);
        }catch (IOException e){
            new Alert(Alert.AlertType.ERROR,"Fail ui").show();
        }
    }
}
