package Pieces;

import Game.*;

import java.util.ArrayList;

public class Bishop extends Piece {


    public Bishop(Board board, Location location, Type type, Color color, boolean isDead) {
        super(board, location, type, color, isDead);
    }

    @Override
    public ArrayList<Location> getPossibleMoves() {
        return null;
    }
}
