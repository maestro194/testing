package maestro194.bomberman.testing.objects;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        return Arrays.asList(A, D, W, S);
    }

    @Override
    public void notify(KeyEvent keyEvent) {
        EventType<? extends Event> eventType = keyEvent.getEventType();
        if(KeyEvent.KEY_RELEASED.equals(eventType)) {
            if(keyEvent.getCode().equals(currentlyPressed)) {
                this.speed = 0;
            }
        } else if(KeyEvent.KEY_PRESSED.equals(keyEvent)) {
            currentlyPressed = keyEvent.getCode();
            this.direction = getDirection(keyEvent);
            this.speed = 1;
        }
    }

    @Override
    public void update(Scene scene, long time) {
        super.update(scene, time);
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
}