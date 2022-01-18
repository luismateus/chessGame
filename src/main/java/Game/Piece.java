package Game;

public abstract class Piece {

    private Location location;
    private Type type;
    private Color color;
    private boolean isDead;


    public Piece(Location location, Type type,Color color , boolean isDead){
        this.location = location;
        this.type = type;
        this.color = color;
        this.isDead = isDead;
    }

    public Type getType() {
        return type;
    }


    public Color getColor() {
        return color;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
