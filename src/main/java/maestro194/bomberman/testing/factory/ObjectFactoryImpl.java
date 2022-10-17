package maestro194.bomberman.testing.factory;

import javafx.scene.image.Image;
import maestro194.bomberman.testing.objects.*;
import maestro194.bomberman.testing.sprites.Sprite;
import maestro194.bomberman.testing.util.KeyEventHandler;

public class ObjectFactoryImpl implements ObjectFactory{
    private static final int SIZE = 16;

    private KeyEventHandler keyEventHandler;

    public ObjectFactoryImpl(KeyEventHandler keyEventHandler) {
        super();
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public MoveObject getMoveObject(int x, int y, Image image) {
        return new MoveObject(x, y, image);
    }

    @Override
    public Bomb getBomb(int x, int y) {
        return new Bomb(x, y, Sprite.bomb.getFxImage());
    }
    @Override
    public Bomber getBomber(int x, int y) {
        return new Bomber(x, y, Sprite.player_right.getFxImage());
    }
    @Override
    public Brick getBrick(int x, int y) {
        return new Brick(x, y, Sprite.brick.getFxImage());
    }
    @Override
    public Grass getGrass(int x, int y) {
        return new Grass(x, y, Sprite.grass.getFxImage());
    }
    @Override
    public Wall getWall(int x, int y) {
        return new Wall(x, y, Sprite.wall.getFxImage());
    }
}