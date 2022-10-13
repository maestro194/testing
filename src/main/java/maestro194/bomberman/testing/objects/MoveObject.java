package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;

public class MoveObject extends Object{
    protected Position last;
    protected Position position;
    protected int speed = 1;

    public MoveObject(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Scene scene, long time) {

    }
}
