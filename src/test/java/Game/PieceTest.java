package Game;

import Pieces.Pawn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest{

    private Board board;
    private Pawn pawn;


    @Before
    public void setUp(){
        this.board = new Board(8);
        this.pawn = new Pawn(board,new Location(1,1),Color.WHITE,false);

    }

    @Test
    public void testGetType() {
        assertEquals(pawn.getType(), Type.PAWN, "piece.getType()");
    }

    @Test
    public void testGetColor() {
        assertEquals(pawn.getColor(), Color.WHITE, "piece.getColor()");
    }

    @Test
    public void testGetLocation() {
        Location testLocation = new Location(1,1);
        assertEquals(pawn.getLocation().getX(), testLocation.getX(), "piece.getLocation - X coordinate");
        assertEquals(pawn.getLocation().getY(), testLocation.getY(), "piece.getLocation - Y coordinate");
    }

    public void testIsDead() {
    }

    public void testSetDead() {
    }

    public void testUpdateLocation() {
    }

    public void testGetPossibleMoves() {
    }

    public void testIsFirstMove() {
    }
}