package Game.Pieces;

import java.util.Arrays;

import static Game.Board.*;

public class Pawn extends Piece {

    private String id;
    private final String pieceType = "Pawn";
    public Pawn(int id, int x, int y, int player) {
        setX(x);
        setY(y);
        setPlayer(player);
        this.id = pieceType + id + "u" + player;
    }
    public Pawn(int x, int y, int player) {
        setX(x);
        setY(y);
        setPlayer(player);
        this.id = pieceType + "u" + player;
    }

    private final int stepX = 0;
    // step for white
    private final int stepYW = 1;
    // step for black
    private final int stepYB = -1;

    public void step() {
        int oldX = getX();
        int oldY = getY();
        if (getPlayer() == 1) {
            if (isValidPath(getX()+stepX, getY()+stepYW)) {
                setX(getX() + stepX);
                setY(getY() + stepYW);
            }
        }
        else {
            if (isValidPath(getX() + stepX, getY() + stepYB)) {
                setX(getX() + stepX);
                setY(getY() + stepYB);
            }
        }
        updatePosition(this, oldX, oldY);
    }
    public void firstStep() {
        int oldX = getX();
        int oldY = getY();
        if (isValidPath(getX(),getY() + 2)) {
            setX(getX() + stepX);
            if (getPlayer() == 1) {setY(getY() + 2);}
            else {setY(getY() - 2);}
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
        if ((X == getX() && Y == getY() + 1) && (boardObjects[X][Y]==null)) {return true;}
        else if ((getY() == 1 && Y == getY() + 2 && getX() == X) &&
                (boardObjects[X][getY()+1]==null && boardObjects[X][getY()+2]==null)) {return true;}
        else return false;
    }
    private boolean isValidStepB(int X, int Y) {
        if ((X == getX() && Y == getY() - 1) && (boardObjects[X][Y]==null)) {return true;}
        else if ((getY() == 7 && Y == getY() - 2 && getX() == X) &&
                (boardObjects[X][getY()-1]==null && boardObjects[X][getY()-2]==null)) {return true;}
        else return false;
    }

    // called on a pawn to know if the intended step is diagonal
    private boolean isDiagonalStep(int X, int Y) {
        if (this.getPlayer() == 1) {
            return (((X == getX() - 1) || (X == getX() + 1 )) && (Y == getY() + 1));
        }
        else {
            return (((X == getX() - 1) || (X == getX() + 1 )) && (Y == getY() - 1));
        }
    }
    @Override
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

