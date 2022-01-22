package Pieces;

import Game.*;

import java.util.ArrayList;

public class Bishop extends Piece {


    public Bishop(Board board, Location location, Type type, Color color, boolean isDead) {
        super(board, location, type, color, isDead);
    }

    @Override
    public boolean isMoveValid(Location destination) {
        return false;
    }

    @Override
    public boolean isPieceInTheWay(Location destination) {
        return false;
    }
}
