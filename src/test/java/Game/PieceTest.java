package Game;

import Pieces.Pawn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest{

    private Board board;
    private Pawn pawn;


    @Before
    public void setUp(){
        this.board = new Board(8);
        this.pawn = new Pawn(board,new Square(1,1),Color.WHITE);

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
        Square testLocation = new Square(1,1);
        assertEquals(pawn.getSquare().getX(), testLocation.getX(), "piece.getLocation - X coordinate");
        assertEquals(pawn.getSquare().getY(), testLocation.getY(), "piece.getLocation - Y coordinate");
    }

    @Test
    public void testIsSetDead() {
        assertEquals(pawn.isDead(),false); //tests if pawn is alive
        pawn.setDead(); //kills pawn
        assertTrue(pawn.isDead()); // tests if setDead function worked
    }

    @Test
    public void testUpdateLocation() {
        int xCoord = pawn.getSquare().getX();
        int yCoord = pawn.getSquare().getY();
        pawn.updateLocation(xCoord + 1, yCoord + 1);
        assertNotEquals(xCoord, pawn.getSquare().getX());
        assertNotEquals(yCoord, pawn.getSquare().getY());
        assertEquals(pawn.getSquare().getX(),xCoord + 1);
        assertEquals(pawn.getSquare().getY(),yCoord + 1);
    }


    @Test
    public void testIsFirstMove() {
        assertTrue(pawn.isFirstMove());
        pawn.updateLocation(1, 2);
        assertFalse(pawn.isFirstMove());
    }
}