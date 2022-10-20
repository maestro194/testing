package maestro194.bomberman.testing.objects;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public class RandomMoveObject extends Object {
    protected Position last;
    protected Direction direction;
    protected int speed = 1;
    protected boolean isDead;

    public RandomMoveObject(int x, int y, Image image) {
        super(x, y, image);
        this.last = new Position(x, y);
        this.position = new Position(x, y);
        this.direction = Direction.R;
        this.isDead = false;
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

    public void changeDirection() {
        Random random = new Random();
        if(random.nextInt(100) > 80) {
            Direction tmp;
            direction = (tmp = randomDirection()) == direction ? randomDirection() : tmp;
        }
    }

    public Direction randomDirection() {
        Random random = new Random();
        return Direction.values()[random.nextInt(Direction.values().length)];
    }

    public void update(Scene scene, long time) {
        if(isDead)
            return;
        changeDirection();
        this.last = new Position(position.getX(), position.getY());
        this.position = move(position, direction);
    }
}