package Pieces;

import Game.*;

import java.util.ArrayList;

public class Bishop extends Piece {


    public Bishop(Board board, Location location, Color color, boolean isDead) {
        super(board, location, color, isDead);
    }

    @Override
    public ArrayList<Location> getPossibleMoves() {
        return null;
    }
}
