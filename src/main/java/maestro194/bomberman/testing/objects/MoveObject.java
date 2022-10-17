package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public abstract class MoveObject extends Object{
    protected Position last;
    protected Position position;
    protected Direction direction;
    protected int speed = 1;
    protected boolean isDead = false;

    public MoveObject(int x, int y, Image image) {
        super(x, y, image);
        this.last = new Position(x, y);
        this.position = new Position(x, y);
    }

    public Position move(Position position, Direction direction) {
        Position newPosition;
        switch (direction) {
            case L:
                newPosition = position.left(speed);
                break;
            case U:
                newPosition = position.up(speed);
                break;
            case D:
                newPosition = position.down(speed);
                break;
            default:
                newPosition = position.right(speed);
                break;
        }
        return newPosition;
    }

    public void moveToPos(Position newPosition) {
        position.setX(newPosition.getX());
        position.setY(newPosition.getY());
    }

    @Override
    public void update(Scene scene, long time) {
        if(isDead)
            return;
        this.last = this.position;
        this.position = move(position, direction);
    }
}
