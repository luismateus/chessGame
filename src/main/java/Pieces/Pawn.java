package Pieces;

import Game.*;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Board board, Square square, Color color) {
        super(board, square, color);
        this.type = Type.PAWN;
    }

    /*
    * c_x -> current_x
    * c_y -> current_y
    * d_x -> destination_x
    * d_y -> destination_y
    * direction -> validates the direction; =1 if it goes upwards; -1 if downwards;
    * direction -> the white pieces start at the bottom and the black pieces start at the top
    * */

    public boolean isMoveValid(Square destination) {
        int destX = destination.getX();
        int destY = destination.getY();
        int currX = this.getSquare().getX();
        int currY = this.getSquare().getY();
        boolean isFirstMove = this.isFirstMove();

        int distX = Math.abs(destX - currX);
        int distY = Math.abs(destY - currY) ;

        if(distX == 0 && distY == 1){
            return true;
        }
        else if(distX == 0 && distY == 2 && isFirstMove){
            return this.board.getPieceByLocation(destination) == null;
        }
        else if(distX == 1 && distY == 1){
            Piece otherPiece = this.board.getPieceByLocation(destination);
            if(otherPiece != null){
                return !otherPiece.getColor().equals(this.getColor());
            }
        }
        return false;
    }

    @Override
    public ArrayList<Square> getPossibleMoves() {
        this.possibleMoves.clear();
        int direction = 1;
        if(this.getColor() == Color.BLACK){
            direction = -1;
        }


        Square square1 = new Square(this.getSquare().getX(),this.getSquare().getY()+direction);
        Square square2 = new Square(this.getSquare().getX(),this.getSquare().getY()+2*direction);
        Square square3 = new Square(this.getSquare().getX()+direction,this.getSquare().getY()+direction);
        Square square4 = new Square(this.getSquare().getX()-direction,this.getSquare().getY()+direction);

        if(isMoveValid(square1)){
            possibleMoves.add(square1);
        }
        if (isMoveValid(square2)){
            possibleMoves.add(square2);
        }
        if(isMoveValid(square3)){
            possibleMoves.add(square3);
        }
        if (isMoveValid(square4)){
            possibleMoves.add(square4);
        }

        return possibleMoves;
    }
}
