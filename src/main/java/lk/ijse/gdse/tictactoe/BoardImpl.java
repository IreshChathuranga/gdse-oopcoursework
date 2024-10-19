package lk.ijse.gdse.tictactoe;

public class BoardImpl implements Board {
    private Piece[][] board;

    public BoardImpl() {
        initializeBoard();
    }
    @Override
    public void initializeBoard() {
        board = new Piece[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }
    @Override
    public boolean isLegalMove(int row, int col) {
        return board[row][col] == Piece.EMPTY;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    @Override
    public Piece checkWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != Piece.EMPTY) {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != Piece.EMPTY) {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Piece.EMPTY) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Piece.EMPTY) {
            return board[0][2];
        }
        return Piece.EMPTY;
    }
    @Override
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

}

