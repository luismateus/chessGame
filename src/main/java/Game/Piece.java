package Game;

import java.util.ArrayList;

public abstract class Piece {

    private Location location;
    protected Type type;
    private Color color;
    private boolean isDead;
    private boolean isFirstMove; //some pieces can have special moves if they were no moved b4 (like pawn or (rook and knight))
    protected Board board;
    protected ArrayList<Location> possibleMoves;

    //constructor
    public Piece(Board board, Location location, Color color , boolean isDead){
        this.board = board;
        this.location = location;
        this.color = color;
        this.isDead = isDead;
        this.isFirstMove = true;
        this.possibleMoves = new ArrayList<Location>();

        // this.board = placePiece(Location location)
    }


    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Location getLocation(){
        return this.location;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        this.isDead = true;
        this.location.setX(-1);
        this.location.setY(-1);
    }

    public void updateLocation(int x, int y){
        this.location.setX(x);
        this.location.setY(y);
    }

    public abstract ArrayList<Location> getPossibleMoves();


    public boolean isFirstMove() {
        return isFirstMove;
    }
}
