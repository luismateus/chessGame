package Game;

/*
* This class allows to record the moves
* */

public class Move {

    private int moveId;
    private Piece piece;
    private Piece deadPiece;
    private Square destination;

    public Move(int moveId, Piece piece, Piece deadPiece, Square destination){
        this.moveId = moveId;
        this.piece = piece;
        this.deadPiece = deadPiece;
        this.destination = destination;

        if (this.deadPiece != null) {
            this.deadPiece.setDead();
        }
    }


    public int getMoveId() {
        return moveId;
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getDestination() {
        return destination;
    }

    public Piece getDeadPiece() {
        return deadPiece;
    }
}
