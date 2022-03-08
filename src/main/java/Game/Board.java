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

    private void placePieceInSquare(Piece piece, Square square){
        this.chessBoard[square.getY()][square.getY()] = piece;
    }

    private void removePieceFromSquare(Piece piece){
        this.chessBoard[piece.getSquare().getY()][piece.getSquare().getY()] = null;
    }

    public void updatePieceAndBoardPosition(Piece piece, Square square){
        removePieceFromSquare(piece);
        piece.updateLocation(square.getX(),square.getY());
        placePieceInSquare(piece,square);
    }
}
