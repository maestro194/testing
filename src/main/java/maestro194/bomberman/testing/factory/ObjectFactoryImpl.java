package maestro194.bomberman.testing.factory;

import maestro194.bomberman.testing.objects.*;
import maestro194.bomberman.testing.util.KeyEventHandler;

public class ObjectFactoryImpl implements ObjectFactory{
    private static final int SIZE = 16;

    private KeyEventHandler keyEventHandler;

    public ObjectFactoryImpl(KeyEventHandler keyEventHandler) {
        super();
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public MoveObject getMoveObject(int x, int y) {
        return new MoveObject(x, y);
    }

    @Override
    public Bomb getBomb(int x, int y) {
        return new Bomb(x, y);
    }

    @Override
    public Bomber getBomber(int x, int y) {
        return new Bomber(x, y);
    }

    @Override
    public Wall getWall(int x, int y) {
        return new Wall(x * SIZE, y * SIZE);
    }


}