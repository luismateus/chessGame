package Pieces;

import Game.Board;
import Game.Color;
import Game.Square;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BishopTest extends TestCase {

    private Board board;
    private Bishop bishop;

    @Before
    public void setUp(){
        this.board = new Board(8);
        this.bishop = new Bishop(board,new Square(4,4), Color.WHITE);
    }

    @Test
    public void testGetPossibleMoves(){
        ArrayList<Square> possibleMoves = bishop.getPossibleMoves();
        assertEquals(possibleMoves.size(),13);
        board.updatePieceAndBoardPosition(bishop,new Square(0,0));
        possibleMoves = bishop.getPossibleMoves();
        assertEquals(possibleMoves.size(),7);
    }

    @Test
    public void testCollisionOpponent(){
        Pawn pawn = new Pawn(board,new Square(5,5),Color.BLACK);
        ArrayList<Square> possibleMoves = bishop.getPossibleMoves();
        for(var move: possibleMoves){
            assertFalse(move.getX() == 6 && move.getY() == 6);
            assertFalse(move.getX() == 7 && move.getY() == 7);
        }
    }
}
