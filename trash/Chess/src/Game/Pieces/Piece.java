package Game.Pieces;

//  -1 -1 - captured
//   board starts at 0 0


import static Game.Board.updatePosition;

abstract public class Piece {

    public int x;
    public int y;
    public int player;
    // white or black
    public String pieceType;
    public String id;

    public boolean canCapture(Piece captured) {
        return this.getPlayer() != captured.getPlayer();
    }

    public void capture(Piece captured) {
        if (canCapture(captured)) {
            int oldX = this.getX();
            int oldY = this.getY();
            int oldXCaptured = captured.getX();
            int oldYCaptured = captured.getY();
            this.x = (captured.getX());
            this.y = (captured.getY());
            captured.setX(-1);
            captured.setY(-1);
            updatePosition(this, oldX, oldY);
            updatePosition(captured, oldXCaptured, oldYCaptured);
        }
    }
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getId() { return id; }
    // ew
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPlayer() {
        return player;
    }

}

