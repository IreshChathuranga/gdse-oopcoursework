package lk.ijse.gdse.tictactoe;

import java.util.Random;

public class AiPlayer extends Player {
    private Random random = new Random();

    public AiPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void Move(int row, int col) {
        // Call the minimax function and make the best move
        int[] bestMove = findBestMove();
        board.updateMove(bestMove[0], bestMove[1], Piece.O);
    }
    private int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2]; // Store the best move

        // Iterate over all possible moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isLegalMove(i, j)) {
                    // Make the move
                    board.updateMove(i, j, Piece.O);

                    // Evaluate the move using Minimax
                    int score = minimax(board, 0, false);

                    // Undo the move
                    board.updateMove(i, j, Piece.EMPTY);

                    // If the move is better than the current best, update bestScore and move
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }

    private int minimax(BoardImpl board, int depth, boolean isMaximizing) {
        Piece winner = board.checkWinner();

        // Check terminal states and return the corresponding score
        if (winner == Piece.O) {
            return 1; // AI wins
        } else if (winner == Piece.X) {
            return -1; // Human wins
        } else if (board.isFull()) {
            return 0; // Draw
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            // AI's turn
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.isLegalMove(i, j)) {
                        board.updateMove(i, j, Piece.O);
                        int score = minimax(board, depth + 1, false);
                        board.updateMove(i, j, Piece.EMPTY);
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            // Human's turn
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.isLegalMove(i, j)) {
                        board.updateMove(i, j, Piece.X);
                        int score = minimax(board, depth + 1, true);
                        board.updateMove(i, j, Piece.EMPTY);
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

}
