package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;
import maestro194.bomberman.testing.sprites.Sprite;

public class Flame extends Object{

    public Flame(int x, int y, int explosion_type) {
        super(x, y, Sprite.explosion_horizontal.getFxImage());
    }
    @Override
    public void update(Scene scene, long time) {

    }
}