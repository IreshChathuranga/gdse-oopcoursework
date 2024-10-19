package lk.ijse.gdse.tictactoe;

public abstract class Player {
    protected BoardImpl board;

    public Player(BoardImpl board) {
        this.board = board;
    }

    // Abstract method to make a move
    public abstract void Move(int row, int col);
}
