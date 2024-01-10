package Game.Pieces;

import java.util.ArrayList;
import java.util.Arrays;

import static Game.Board.boardObjects;
import static Game.Board.updatePosition;

public class Rook extends Piece {
private final String id;
public final String pieceType = "rook";

    public Rook(int id, int x, int y, int player) {
        setX(x);
        setY(y);
        setPlayer(player);
        this.id = pieceType + id + "u" + player;
    }
    
    public Rook(int x, int y, int player) {
        setX(x);
        setY(y);
        setPlayer(player);
        this.id = pieceType + "u" + player;
    }

// for valid path either x or y should stay the same
// board boundaries followed and no pieces in the way
    public void step() {
    
    }

// damn
// TODO
//  add check for player + capture if theres a piece at end cords
// basically checks for a clear path,
// but also captures if end cords are occupied and it can
    public boolean isValidPath(int endX, int endY) { // endX andY should be -1, cus board index ends at 7
        int startX = getX();
        int startY = getY();
        boolean bul = false;
        
        if (((endX <= 7) && (endY <= 7))) {
            if ((boardObjects[endX][endY] == null) &&
                    (clearWay(stepCasesCheck(startX, startY, endX, endY), startX, startY, endX, endY))) {
                bul = true;
            }
            else if ((clearWay(stepCasesCheck(startX, startY, endX, endY), startX, startY, endX, endY))) {
                if (canCapture(boardObjects[endX][endY])) {
                    capture(boardObjects[endX][endY]);
                    bul = true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return bul;
    }

    private int stepCasesCheck(int startX, int startY, int endX, int endY) {
        boolean clearWay = true;
        ArrayList<Boolean> cases = new ArrayList<>
                (Arrays.asList((startY == endY) && (startX > endX), (startY == endY) && (startX < endX),
                        (startX == endX) && (startY > endY), (startX == endX) && (startY < endY)));
        int ind;
        if (!cases.contains(true)) {
            ind = -1;
        } else {
            ind = cases.indexOf(true);
        }
        
        return ind;
    }

    private boolean clearWay(int ind, int startX, int startY, int endX, int endY) {
        boolean clear = false;
        int operation = 0;
        switch(ind) {
            case -1:
                break; // TODO ????? god help me
            case 0,2:
                operation = -1;
                break;
            case 1,3:
                operation = 1;
        }
        
        if (ind == 0 || ind == 1) {
            for (int i = startX; i != endX; i += operation) {
//                System.out.println("checking "+ i + " " + startY + "- " + boardObjects[i][startY]);
                if (boardObjects[i][startY] == null) {
                    clear = true;
                }
                else {
                    clear = false;
                    break;
                }
            }
        }
        else if (ind == 2 || ind == 3) {
            for (int i = startY; i != endY; i += operation) {
//                System.out.println("checking " + startX + " " + i + "- " + boardObjects[startX][i]);
                if (boardObjects[startX][i] == null) {
                    clear = true;
                }
                else {
                    clear = false;
                    break;
                }
            }
        }
        return clear;
    }

    
    public String getId() {
        return id;
    }
}