package Pieces;

import Game.Board;
import Game.Color;
import Game.Square;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class PawnTest extends TestCase {

    private Board board;
    private Pawn pawn;


    @Before
    public void setUp(){
        this.board = new Board(8);
        this.pawn = new Pawn(board,new Square(1,1), Color.WHITE);

    }

    @Test
    public void testIsMoveValid() {
        assertFalse(pawn.isMoveValid(new Square(2,2)));
        assertFalse(pawn.isMoveValid(new Square(1,9)));
        assertTrue(pawn.isMoveValid(new Square(1,2)));
        assertTrue(pawn.isMoveValid(new Square(1,3)));
    }

    @Test
    public void testGetPossibleMovesWhite() {
        ArrayList<Square> possibleMoves = pawn.getPossibleMoves();
        for(Square move : possibleMoves){
            assertEquals(move.getX(), pawn.getSquare().getX()); //pawn can't move in X coordinate except to kill another piece
            assertTrue(move.getY() == 2 || move.getY() == 3); //first move can be 1 ou 2 squares in Y axis
        }
    }

    @Test
    public void testGetPossibleMovesBlack(){
        Pawn blackPawn = new Pawn(board,new Square(6,6),Color.BLACK);
        ArrayList<Square> possibleMoves = blackPawn.getPossibleMoves();
        for(Square move : possibleMoves){
            assertEquals(move.getX(), blackPawn.getSquare().getX()); //pawn can't move in X coordinate except to kill another piece
            assertTrue(move.getY() == 5 || move.getY() == 4); //first move can be 1 ou 2 squares in Y axis
        }
    }
}