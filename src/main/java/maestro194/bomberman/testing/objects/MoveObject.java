package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public class MoveObject extends Object{
    protected Position last;
    protected Position position;
    protected int speed = 1;

    public MoveObject(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update(Scene scene, long time) {

    }
}
