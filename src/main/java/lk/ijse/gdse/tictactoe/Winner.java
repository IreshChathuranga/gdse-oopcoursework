package lk.ijse.gdse.tictactoe;

public class Winner {
    int col1, row1, col2, row2, col3, row3;
    Piece winingPiece;

    public Winner(int col1, int row1, int col2, int row2, int col3, int row3, Piece winingPiece) {
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
        this.col3 = col3;
        this.row3 = row3;
        this.winingPiece = winingPiece;
    }
    public Piece getWinningPiece() {
        return winingPiece;
    }
}
