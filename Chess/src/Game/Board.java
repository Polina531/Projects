package Game;
import Game.Pieces.Pawn;
import Game.Pieces.Piece;

import java.util.Arrays;

public class Board {

    public Piece[][] panel1;

    public static Piece[][] boardObjects = new Piece[8][8];

    public void getPawns() {

        for (int i = 0; i < 8; i++) {
            Pawn p1 = new Pawn(i, i, 1, 1);
            Pawn p2 = new Pawn(i, i, 7, 2);
            boardObjects[i][1] = p1;
            boardObjects[i][7] = p2;
        }
    }

    public static boolean onBoard(int x, int y) {
        return boardObjects[x][y] != null;
    }


    public String getByCoordinate(int x, int y) {
        Piece piece = boardObjects[x][y];
        return piece.getId();
    }

    public static void updatePosition(Piece p, int oldX, int oldY) {
        boardObjects[oldX][oldY] = null;
        if (p.getX() != (-1)) {
            boardObjects[p.getX()][p.getY()] = p;
        }
    }
    
}
