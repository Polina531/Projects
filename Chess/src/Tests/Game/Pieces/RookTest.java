package Game.Pieces;

import Game.Board;
import junit.framework.TestCase;

import static Game.Board.boardObjects;

public class RookTest extends TestCase {
    
    
    public void testingMyPatience() {
        
        Rook r = new Rook(101, 1,1,1);
        boolean i = r.isValidPath(2,2);
        assertFalse(new Rook(101, 1,1,1).isValidPath(2,2)); // diagonal
        assertFalse(new Rook(101, 1,1,1).isValidPath(9,1)); // off board
        assertFalse(new Rook(101, 1,1,1).isValidPath(1,9)); // off board
        assertFalse(new Rook(101, 1,1,1).isValidPath(3,5)); // not a straight path
        assertTrue(new Rook(101, 5,7,1).isValidPath(5,2));
        assertTrue(new Rook(101, 1,1,1).isValidPath(1,7));
        assertTrue(new Rook(101, 1,1,1).isValidPath(7,1));
        
        Board b = new Board();
        Pawn p = new Pawn(101,1,4,1);
        Pawn p1 = new Pawn(101,4,1,1);
        p.putOnBoard();
        p1.putOnBoard();

        assertNotNull(boardObjects[p.getX()][p.getY()]);
        assertFalse(new Rook(102, 1, 1,1).isValidPath(1,5)); // jumping over a pawn
        assertFalse(new Rook(102, 1, 1,1).isValidPath(5,1));
        
        
    }
    
    public void testCapturing() {
        Rook r = new Rook(1,1, 1);
        
        Pawn p = new Pawn(1,3,2);
        Pawn p1 = new Pawn(3,1,2);
        Pawn p2 = new Pawn(1,1,2);
        Pawn p3 = new Pawn(1,1,2);
        Pawn p4 = new Pawn(1,1,2);
        p.putOnBoard();
        p1.putOnBoard();
//        p2.putOnBoard();
//        p3.putOnBoard();
//        p4.putOnBoard();
        
        assertTrue(r.isValidPath(1,3));
        assertEquals(boardObjects[1][3], r);
        assertEquals(p.getX(), -1);
        assertEquals(p.getY(), -1);
        
//        assertTrue(r.isValidPath(3,1));
//
//
//        assertTrue(r.isValidPath(1,3));
//        assertTrue(r.isValidPath(1,3));
    }

}