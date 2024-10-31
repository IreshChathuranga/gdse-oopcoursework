package lk.ijse.gdse.tictactoe;

public enum Piece {
    X, O, EMPTY;

    @Override
    public String toString(){
        return this == EMPTY ? ".": this.name();
    }
}
