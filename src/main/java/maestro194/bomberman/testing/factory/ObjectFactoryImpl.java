package maestro194.bomberman.testing.factory;

import maestro194.bomberman.testing.objects.*;
import maestro194.bomberman.testing.sprites.Sprite;
import maestro194.bomberman.testing.util.KeyEventHandler;

public class ObjectFactoryImpl implements ObjectFactory{
    private static final int SIZE = 16;

    private final KeyEventHandler keyEventHandler;

    public ObjectFactoryImpl(KeyEventHandler keyEventHandler) {
        super();
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public Bomb getBomb(int x, int y) {
        return new Bomb(x, y, Sprite.bomb.getFxImage());
    }
    @Override
    public Bomber getBomber(int x, int y) {
        Bomber bomber = new Bomber(x, y, Sprite.player_right.getFxImage());
        keyEventHandler.registerEvent(bomber);
        return bomber;
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

    @Override
    public Balloom getBalloom(int x, int y) {
        return new Balloom(x, y, Sprite.balloom_right1.getFxImage());
    }
}