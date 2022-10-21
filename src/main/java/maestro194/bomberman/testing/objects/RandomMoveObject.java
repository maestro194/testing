package maestro194.bomberman.testing.objects;

import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import maestro194.bomberman.testing.GameEngine;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.sprites.Sprite;

public class RandomMoveObject extends Object {
    protected Position last;
    protected Direction direction;
    protected int speed = 1;
    protected boolean isDead;

    public RandomMoveObject(int x, int y, Image image) {
        super(x, y, image);
        this.last = new Position(x * Sprite.SCALED_SIZE, y * Sprite.SCALED_SIZE);
        position = new Position(x * Sprite.SCALED_SIZE, y * Sprite.SCALED_SIZE);
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
        Direction tmp;
        direction = (tmp = randomDirection()) == direction ? randomDirection() : tmp;
    }

    public Direction randomDirection() {
        Random random = new Random();
        return Direction.values()[random.nextInt(Direction.values().length)];
    }

    public void update(Scene scene, long time) {
        if(isDead)
            return;
        this.last = new Position(position.getX(), position.getY());
        position = move(position, direction);
    }

    public void moveToPos(Position newPosition) {
        position.setX(newPosition.getX());
        position.setY(newPosition.getY());
    }

    // collision
    @Override
    public <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Object object) {
        if(object instanceof Wall)
            collide(gameEngine, (Wall) object);
        else if(object instanceof Brick)
            collide(gameEngine, (Brick) object);
        else if(object instanceof Flame)
            collide(gameEngine, (Flame) object);
        else if(object instanceof Bomber)
            collide(gameEngine, (Bomber) object);
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Wall wall) {
        if(last != null)
            position = last;
        last = null;
        moveToPos(position);
        changeDirection();
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Brick brick) {
        if(last != null)
            position = last;
        last = null;
        moveToPos(position);
        changeDirection();
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Flame flame) {
        // die
        if (!isDead) {
            speed = 0;
            isDead = true;
        }
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Bomber bomber) {
        // kill
    }
}