package Game.Pieces;

import static Game.Board.*;

public class Pawn extends Piece {

    public String id;
    String pieceType = "Pawn";
    public Pawn(int id, int x, int y, int player) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.id = pieceType + id + "u" + player;
    }

    private final int stepX = 0;
    // step for white
    private final int stepYW = 1;
    // step for black
    private final int stepYB = -1;

    public void step() {
        int oldX = x;
        int oldY = y;
        if (player == 1) {
            if (isValidPath(x+stepX, y+stepYW)) {
                x += stepX;
                y += stepYW;
            }
        }
        else {
            if (isValidPath(x+stepX, y+stepYB)) {
                x += stepX;
                y += stepYB;
            }
        }
        updatePosition(this, oldX, oldY);
    }
    public void firstStep() {
        int oldX = x;
        int oldY = y;
        if (isValidPath(x,y + 2)) {
            this.x += stepX;
            if (player == 1) {this.y += 2;}
            else {this.y -= 2;}
        }
        else { step(); }
        updatePosition(this, oldX, oldY);
    }

    // ew, disgusting
    public boolean isValidPath(int X, int Y) {
        // capturing; stepping; double stepping
        boolean bul = false;
        if ((X <= 8 && Y <= 8) && (X >= 0 && Y >= 0)) {
            if (this.getPlayer() == 1) {
                if ((isValidStepW(X, Y)) || (isDiagonalStep(X,Y))) {bul = true;}
            }
            else {
                if ((isValidStepB(X, Y)) || (isDiagonalStep(X,Y))) {bul = true;}
            }
        }
        return bul;
    }
    private boolean isValidStepW(int X, int Y) {
        if ((X == x && Y == y + 1) && (boardObjects[X][Y]==null)) {return true;}
        else if ((y == 1 && Y == y + 2 && x == X) &&
                (boardObjects[X][y+1]==null && boardObjects[X][y+2]==null)) {return true;}
        else return false;
    }
    private boolean isValidStepB(int X, int Y) {
        if ((X == x && Y == y - 1) && (boardObjects[X][Y]==null)) {return true;}
        else if ((y == 7 && Y == y - 2 && x == X) &&
                (boardObjects[X][y-1]==null && boardObjects[X][y-2]==null)) {return true;}
        else return false;
    }

    // called on a pawn to know if the intended step is diagonal
    private boolean isDiagonalStep(int X, int Y) {
        if (this.getPlayer() == 1) {
            return (((X == x - 1) || (X == x + 1 )) && (Y == y + 1));
        }
        else {
            return (((X == x - 1) || (X == x + 1 )) && (Y == y - 1));
        }
    }
    public boolean canCapture(Piece captured) {
        return (getPlayer() != captured.getPlayer() &&
                isDiagonalStep(captured.getX(), captured.getY()));
    }
    private boolean checkIfOnBoard(int x, int y) { return(onBoard(x, y));}
// onBoard for all board objs cus static

    // for tests
    public void putOnBoard() {
        boardObjects[this.getX()][this.getY()] = this;
    }

    @Override
    public String getId() { return id; }

}

