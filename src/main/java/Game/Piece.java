package Game;

import java.util.ArrayList;

public abstract class Piece {

    private Square square;
    protected Type type;
    private Color color;
    private boolean isDead;
    private boolean isFirstMove; //some pieces can have special moves if they were no moved b4 (like pawn or (rook and knight))
    protected Board board;
    protected ArrayList<Square> possibleMoves;

    //constructor
    public Piece(Board board, Square square, Color color){
        this.board = board;
        this.square = square;
        this.color = color;
        this.isDead = false;
        this.isFirstMove = true;
        this.possibleMoves = new ArrayList<Square>();

        this.board.placePieceInBoard(this);
    }


    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Square getSquare(){
        return this.square;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        this.isDead = true;
        this.square.setX(-1);
        this.square.setY(-1);
    }

    public void updateLocation(int x, int y){
        this.square.setX(x);
        this.square.setY(y);
        if(this.isFirstMove) {
            this.isFirstMove = false;
        }
    }

    public abstract ArrayList<Square> getPossibleMoves();


    public boolean isFirstMove() {
        return isFirstMove;
    }
}
