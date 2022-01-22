package Pieces;

import Game.*;

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

    @Override
    public boolean isMoveValid(Location destination) {
        int d_x = destination.getX();
        int d_y = destination.getY();
        int c_x = this.getLocation().getX();
        int c_y = this.getLocation().getY();
        boolean isFirstMove = this.isFirstMove;

        int direction = 1;
        if(this.getColor() == Color.BLACK){
            direction = -1;
        }

        int distance_x = (d_x - c_x) * direction;
        int distance_y= (d_y - c_y) * direction;

        if(distance_x == 0 && distance_y == 1){
            return true;
        }
        else if(distance_x == 0 && distance_y == 2 && isFirstMove){
            return true;
        }

        return false;
    }

    @Override
    public boolean isPieceInTheWay(Location destination) {
        return false;
    }

}
