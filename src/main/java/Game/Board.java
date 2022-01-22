package Game;

public class Board {

    private Piece[][] chessBoard;
    private int dimension;

    public Board(int dimension){
        this.dimension = dimension;
        this.chessBoard = new Piece[dimension][dimension];
    }

    public boolean locationInBounds(Location location){
        return location.getX()>=0 && location.getX()<this.dimension && location.getY()>=0 && location.getY()<this.dimension;
    }

    public Piece getPieceByLocation(Location location){
        if(locationInBounds(location)){
            return this.chessBoard[location.getX()][location.getY()];
        }
        return null;
    }
}
