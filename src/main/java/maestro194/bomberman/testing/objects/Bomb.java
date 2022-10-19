package maestro194.bomberman.testing.objects;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import maestro194.bomberman.testing.Factory;
import maestro194.bomberman.testing.util.KeyEventListener;

import java.awt.*;
import java.util.List;

public class Bomb extends Object implements KeyEventListener {
    KeyCode currentlyPressed;
    private final long BOMB_TIMER = 2500;
    private int BOMB_LIMIT = 1;
    private long startTime;
    public Bomb(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public List<KeyCode> interestedIn() {
        return List.of(KeyCode.SPACE);
    }

    @Override
    public void notify(KeyEvent keyEvent) {
        EventType<? extends Event> eventType = keyEvent.getEventType();
        if(KeyEvent.KEY_RELEASED.equals(eventType)) {
            if(keyEvent.getCode().equals(currentlyPressed)) {
                currentlyPressed = null;
            }
        } else if(KeyEvent.KEY_PRESSED.equals(eventType)) {
            currentlyPressed = keyEvent.getCode();
            if(currentlyPressed == KeyCode.SPACE) {
                Position newPosition = Bomber.getPosition();
                // spawn bomb
            }
        }
    }

    @Override
    public void update(Scene scene, long time) {
        if(time - startTime > BOMB_TIMER) {
            // explode
        }
    }
}
