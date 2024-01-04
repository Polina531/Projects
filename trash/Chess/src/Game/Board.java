package Game;
import Game.Pieces.Pawn;
import Game.Pieces.Piece;

public class Board {

    public static String[][] board = new String[8][8];  //!! only for science, scrape form the final version
    public static Piece[][] boardObjects = new Piece[8][8];

    public void getPawns() {

        for (int i = 0; i < 8; i++) {
            Pawn p1 = new Pawn(i, i, 1, 1);
            Pawn p2 = new Pawn(i, i, 7, 2);
            board[i][1] = p1.getId();
            board[i][7] = p2.getId();
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
        board[oldX][oldY] = "";
        boardObjects[oldX][oldY] = null;
        if (p.getX() != (-1)) {
            board[p.getX()][p.getY()] = p.getId();
            boardObjects[p.getX()][p.getY()] = p;
        }
    }


//    public static int getPosition(Piece p) {
//        int ind = Arrays.stream(boardObjects).toList().indexOf(p);
//        return ind;
//    } I don't even need this what am I doing
}
