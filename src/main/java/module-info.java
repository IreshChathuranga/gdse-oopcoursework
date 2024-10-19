module lk.ijse.gdse.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.gdse.tictactoe to javafx.fxml;
    exports lk.ijse.gdse.tictactoe;
    exports lk.ijse.gdse.tictactoe.controller;
    opens lk.ijse.gdse.tictactoe.controller to javafx.fxml;
}