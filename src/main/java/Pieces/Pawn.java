package Pieces;

import Game.*;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(Board board, Location location, Type type, Color color, boolean isDead) {
        super(board,location, type, color, isDead);
        type = Type.PAWN;
    }

    /*
    * c_x -> current_x
    * c_y -> current_y
    * d_x -> destination_x
    * d_y -> destination_y
    * direction -> validates the direction; =1 if it goes upwards; -1 if downwards;
    * direction -> the white pieces start at the bottom and the black pieces start at the top
    * */

    public boolean isMoveValid(Location destination) {
        int d_x = destination.getX();
        int d_y = destination.getY();
        int c_x = this.getLocation().getX();
        int c_y = this.getLocation().getY();
        boolean isFirstMove = this.isFirstMove();

        int distance_x = (d_x - c_x);
        int distance_y= (d_y - c_y) ;

        if(distance_x == 0 && distance_y == 1){
            return true;
        }
        else if(distance_x == 0 && distance_y == 2 && isFirstMove){
            Location midLocation = new Location(c_x,c_y);
            return this.board.getPieceByLocation(midLocation) == null;
        }
        else if(distance_x == 1 && distance_y == 1){
            Piece otherPiece = this.board.getPieceByLocation(destination);
            if(otherPiece != null){
                return !otherPiece.getColor().equals(this.getColor());
            }
        }
        return false;
    }

    @Override
    public ArrayList<Location> getPossibleMoves() {
        this.possibleMoves.clear();
        int direction = 1;
        if(this.getColor() == Color.BLACK){
            direction = -1;
        }
        possibleMoves.add(new Location(this.getLocation().getX(),this.getLocation().getY()+direction));
        possibleMoves.add(new Location(this.getLocation().getX(),this.getLocation().getY()+2*direction));
        possibleMoves.add(new Location(this.getLocation().getX()+direction,this.getLocation().getY()+direction));

        for(Location Move : possibleMoves){
            if(!isMoveValid(Move)){
                possibleMoves.remove(Move);
            }
        }
        return possibleMoves;
    }
}
