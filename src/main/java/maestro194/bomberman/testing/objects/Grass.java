package maestro194.bomberman.testing.objects;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import maestro194.bomberman.testing.GameEngine;
import maestro194.bomberman.testing.factory.ObjectFactory;

public class Grass extends Object {

    public Grass(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update(Scene scene, long time) {

    }

    @Override
    public <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Object object) {

    }
}
