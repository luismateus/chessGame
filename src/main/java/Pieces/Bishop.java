package Pieces;

import Game.Color;
import Game.Location;
import Game.Piece;
import Game.Type;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Location location, Type type, Color color, boolean isDead) {
        super(location, type, color, isDead);
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return false;
    }

}
