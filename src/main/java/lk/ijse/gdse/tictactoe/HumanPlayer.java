package lk.ijse.gdse.tictactoe;

public class HumanPlayer extends Player {

    public HumanPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void Move(int row, int col) {
        if (board.isLegalMove(row, col)) {
            board.updateMove(row, col, Piece.X);
        }
    }
}
