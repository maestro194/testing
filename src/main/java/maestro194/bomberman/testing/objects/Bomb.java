package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.List;

public class Bomb extends Object {
    KeyCode currentlyPressed;
    private final long BOMB_TIMER = 2500;
    private int BOMB_LIMIT = 1;
    private int BOMB_COUNT = 0;
    private long startTime;
    public Bomb(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update(Scene scene, long time) {
        if(time - startTime > BOMB_TIMER) {
            // explode
        }
    }
}
