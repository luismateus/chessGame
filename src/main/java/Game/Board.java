package Game;

public class Board {

    private Piece[][] chessBoard;
    private int dimension;

    public Board(int dimension){
        this.dimension = dimension;
        this.chessBoard = new Piece[dimension][dimension];
    }

    public int getDimension() {
        return dimension;
    }

    public boolean locationInBounds(Square location){
        return location.getX()>=0 && location.getX()<this.dimension && location.getY()>=0 && location.getY()<this.dimension;
    }

    public Piece getPieceByLocation(Square location){
        if(locationInBounds(location)){
            return this.chessBoard[location.getX()][location.getY()];
        }
        return null;
    }

    public void placePieceInBoard(Piece piece){
        this.chessBoard[piece.getSquare().getY()][piece.getSquare().getY()] = piece;
    }
}
