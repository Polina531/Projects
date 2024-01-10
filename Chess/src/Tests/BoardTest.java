import Game.Board;
import Game.Pieces.Pawn;
import junit.framework.TestCase;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static Game.Board.*;


public class BoardTest extends TestCase {

    public void testGettingPawns() {
        Board b = new Board();
        b.getPawns();
        assertNotNull(boardObjects);
    }

    public void testUpdating() {
        Board b = new Board();
        Pawn p = new Pawn(1, 0,1,1);
        boardObjects[p.getX()][p.getY()] = p;
        System.out.println(boardObjects[p.getX()][p.getY()]);
        System.out.printf("\nTesting Updating...\non the board: %d, %d\n", p.getX(), p.getY());
        int x = p.getX(); // saving old x and y
        int y = p.getY();
        p.step();
        assertEquals(p, boardObjects[p.getX()][p.getY()]);
        System.out.printf("taking a step...\non the board: %d, %d\n", p.getX(), p.getY());
        assertNull(boardObjects[x][y]);
        // first step for white

        /// it works. crazy.
    }

    public void testArrayLength() {
        Board b = new Board();
    }

}
