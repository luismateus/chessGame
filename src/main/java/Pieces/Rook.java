package Pieces;

import Game.*;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Board board, Square square, Color color) {
            super(board, square, color);
            this.type = Type.ROOK;
        }


    public boolean addMove(Square square){
        if(board.locationInBounds(square)){
            Piece otherPiece = board.getPieceByLocation(square);

            if(otherPiece == null){
                possibleMoves.add(square);
                return true;
            }

            else if(otherPiece.getColor() != this.getColor()){
                possibleMoves.add(square);
                return false;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        possibleMoves.clear();

        boolean expandUp = true;
        boolean expandLeft= true;
        boolean expandDown = true;
        boolean expandRight = true;

        for(int i = 1; i < board.getDimension(); i++){

            Square squareRight = new Square(this.getSquare().getX() + i , this.getSquare().getY());
            Square squareLeft = new Square(this.getSquare().getX() - i , this.getSquare().getY());
            Square squareUp = new Square(this.getSquare().getX(), this.getSquare().getY() + i);
            Square squareDown = new Square(this.getSquare().getX(), this.getSquare().getY() - i);

            if (expandRight) {
                expandRight = addMove(squareRight);
            }
            if(expandLeft){
                expandLeft = addMove(squareLeft);
            }
            if(expandDown){
                expandDown = addMove(squareDown);
            }
            if(expandUp){
                expandUp = addMove(squareUp);
            }
        }

        return possibleMoves;
    }
}
