package Pieces;

import Game.*;

import java.util.ArrayList;

public class Bishop extends Piece {


    public Bishop(Board board, Square square, Color color) {
        super(board, square, color);
        this.type = Type.BISHOP;
    }

    public boolean addMoves(Square destination){

        Piece otherPiece;

        if(board.locationInBounds(destination)){
            otherPiece = board.getPieceByLocation(destination);
            if(otherPiece == null){
                possibleMoves.add(destination);
            }
            else if(!otherPiece.getColor().equals(this.getColor())){
                possibleMoves.add(destination);
                return false;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        possibleMoves.clear();

        int currX = this.getSquare().getX();
        int currY = this.getSquare().getY();

        boolean expandUpRight = true;
        boolean expandUpLeft = true;
        boolean expandDownRight = true;
        boolean expandDownLeft = true;

        //calc maxDistance to reduce the number of iterations below
        for(int i = 1; i < board.getDimension(); ++i){

            //++X , ++Y (Up-Right)
            Square upRight = new Square(currX + i , currY + i);
            if(expandUpRight){
                expandUpRight = addMoves(upRight);
            }

            Square upLeft = new Square( currX - i, currY + i);
            if (expandUpLeft){
                expandUpLeft = addMoves(upLeft);
            }

            Square downRight = new Square( currX + i, currY - i);
            if(expandDownRight){
                expandDownRight = addMoves(downRight);
            }

            Square downLeft = new Square( currX - i, currY - i);
            if(expandDownLeft){
                expandDownLeft = addMoves(downLeft);
            }
        }
        return possibleMoves;
    }
}
