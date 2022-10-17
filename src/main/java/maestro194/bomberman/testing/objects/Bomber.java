package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Bomber extends Object {
    private static final long BOMB_TIMER = 2500;
    private long startTime;

    public Bomber(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update(Scene scene, long time) {
        if(time - startTime > BOMB_TIMER) {
            // explode
        }
    }
}