package Game.Pieces;

//  -1 -1 - captured
//   board starts at 0 0


import static Game.Board.updatePosition;

abstract public class Piece {

    private int x;
    private int y;
    private int player;
    // white or black
    private String id;

    public boolean canCapture(Piece captured) {
        return this.getPlayer() != captured.getPlayer();
    }

    public void capture(Piece captured) {
        if (canCapture(captured)) {
            int oldX = this.getX();
            int oldY = this.getY();
            int oldXCaptured = captured.getX();
            int oldYCaptured = captured.getY();
            setX(captured.getX());
            setY(captured.getY());
            captured.setX(-1);
            captured.setY(-1);
            updatePosition(captured, oldXCaptured, oldYCaptured);
            updatePosition(this, oldX, oldY);

        }
    }
    
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
    
    public void setPlayer(int player) {
        this.player = player;
    }
    public String getId() { return id; }

}

