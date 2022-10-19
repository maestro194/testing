package maestro194.bomberman.testing.objects;

import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class MoveObject extends Object{
    protected Position last;
    protected Direction direction;
    protected int speed;
    protected boolean isDead = false;

    public MoveObject(int x, int y, Image image) {
        super(x, y, image);
        this.last = new Position(x, y);
        this.position = new Position(x, y);
        this.direction = Direction.R;
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
        this.last = new Position(position.getX(), position.getY());
        this.position = move(position, direction);
    }
}
