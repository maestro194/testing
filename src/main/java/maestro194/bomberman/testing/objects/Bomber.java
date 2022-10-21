package maestro194.bomberman.testing.objects;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import maestro194.bomberman.testing.GameEngine;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.util.KeyEventListener;

import java.util.Arrays;
import java.util.List;

import static javafx.scene.input.KeyCode.*;

public class Bomber extends MoveObject implements KeyEventListener {
    private KeyCode currentlyPressed;

    public Bomber(int x, int y, Image image) {
        super(x, y, image);
        this.speed = 0;
    }

    @Override
    public List<KeyCode> interestedIn() {
        return Arrays.asList(A, D, W, S, SPACE);
    }

    @Override
    public void notify(KeyEvent keyEvent) {
        EventType<? extends Event> eventType = keyEvent.getEventType();
        if(KeyEvent.KEY_RELEASED.equals(eventType)) {
            if(keyEvent.getCode().equals(currentlyPressed)) {
                this.speed = 0;
            }
        } else if(KeyEvent.KEY_PRESSED.equals(eventType)) {
            currentlyPressed = keyEvent.getCode();
            if(currentlyPressed == SPACE) {
                // spawn bomb
            } else {
                this.direction = getDirection(keyEvent);
                this.speed = 1;
            }

        }
    }

    @Override
    public void update(Scene scene, long time) {
        super.update(scene, time);

//        System.out.println("speed: " + this.speed);
//        System.out.println("xPos: " + this.position.getX() + ", yPos: " + this.position.getY());
    }

    private Direction getDirection(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case A:
                return Direction.L;
            case W:
                return Direction.U;
            case S:
                return Direction.D;
            default:
                return Direction.R;
        }
    }

    public Position getPosition() {
        return super.position;
    }

    // Collision
    @Override
    public <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Object object) {
        if(object instanceof RandomMoveObject)
            collide(gameEngine, (RandomMoveObject) object);
        else if(object instanceof Wall)
            collide(gameEngine, (Wall) object);
        else if(object instanceof Brick)
            collide(gameEngine, (Brick) object);
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?>  gameEngine, RandomMoveObject object) {
        if (!isDead) {
            speed = 0;
            isDead = true;
            System.out.println("You are dead");
            while (true) {
                // end screen
            }
        }
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Wall wall) {
        if(last != null)
            position = last;
        last = null;
        moveToPos(position);
    }

    protected <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Brick brick) {
        if(last != null)
            position = last;
        last = null;
        moveToPos(position);
    }

}