package Game;

import java.util.ArrayList;

public abstract class Piece {

    private Location location;
    private Type type;
    private Color color;
    private boolean isDead;
    protected boolean isFirstMove; //some pieces can have special moves if they were no moved b4 (like pawn or (rook and knight))

    //constructor
    public Piece(Location location, Type type,Color color , boolean isDead){
        this.location = location;
        this.type = type;
        this.color = color;
        this.isDead = isDead;
        this.isFirstMove = true;
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

    public void setDead(boolean isDead) {
        this.isDead = isDead;
        this.location.setX(-1);
        this.location.setY(-1);
    }

    public void updateLocation(int x, int y){
        this.location.setX(x);
        this.location.setY(y);
    }

    //Each subclass its own movement pattern.
    //It will only check if the Piece moves as it is supposed to.
    //Does not check if it reaches the end of the board or if there is another piece in the way.
    public abstract boolean isMoveValid(int  x, int y);


    public boolean isFirstMove() {
        return isFirstMove;
    }
}
