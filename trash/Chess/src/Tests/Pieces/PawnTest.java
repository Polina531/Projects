package Pieces;

import Game.Board;
import Game.Pieces.Pawn;
import junit.framework.TestCase;

import static Game.Board.boardObjects;
import static Game.Board.onBoard;


public class PawnTest extends TestCase {
    Pawn p1 = new Pawn(1,0, 1, 1);


    public void testSteps() {
        p1.firstStep();
        int oldX = p1.getX();
        int oldY = p1.getY();
        assertEquals(3, p1.getY());
        p1.firstStep();
        assertEquals(4, p1.getY()); // fails, takes regular step
        assertSame(boardObjects[p1.getX()][p1.getY()], p1);
        assertNull(boardObjects[oldX][oldY]);
    }
    // the moral is, don't invent shit

    public void testCanCapture() {
        // not calling board since pieces in the way are irrelevant
        Pawn p2 = new Pawn(101, 1, 2, 2);
        assertTrue(new Pawn(101, 2, 1, 1).canCapture(p2));
        assertTrue(p2.canCapture(new Pawn(101, 2, 1, 1)));
        // p2     x=1 y=2 player=2
        assertFalse(p2.canCapture(new Pawn(101, 3, 3, 1))); // out of reach
        assertFalse(p2.canCapture(new Pawn(101, 2, 1, 2))); // its own piece
        assertFalse(p2.canCapture(new Pawn(101, 2, 3, 1))); // backwards
        assertFalse(p2.canCapture(new Pawn (101, 1, 1,1))); // out of reach (basic step)
    }

    public void testCapturing() {
        Pawn pCaptured = new Pawn(1,1, 2, 2);
        Pawn pCapturing = new Pawn(2,  2, 1, 1);
        Board b = new Board();
        pCaptured.putOnBoard();
        pCapturing.putOnBoard();
        int oldX = pCaptured.getX();
        int oldY = pCaptured.getY();
        pCapturing.capture(pCaptured);
        assertTrue(pCaptured.getX()==-1 && pCaptured.getY()==-1);
        System.out.println(boardObjects[oldX][oldY]);
        System.out.println(boardObjects[pCapturing.getX()][pCapturing.getY()]);
        System.out.printf("%d, %d", pCapturing.getX(), pCapturing.getY());
//        assertSame(boardObjects[oldX][oldY], pCapturing);

    }

}