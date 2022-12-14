package maestro194.bomberman.testing;

import maestro194.bomberman.testing.factory.BaseFactory;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.factory.ObjectFactoryImpl;
import maestro194.bomberman.testing.map.GameMapGenerator;
import maestro194.bomberman.testing.map.GameMapParser;
import maestro194.bomberman.testing.map.MapGenerator;
import maestro194.bomberman.testing.map.MapParser;
import maestro194.bomberman.testing.util.KeyEventHandleImpl;
import maestro194.bomberman.testing.util.KeyEventHandler;

public class Factory {
    private static final Factory FACTORY = new Factory();

    private final KeyEventHandler keyEventHandler;
    private final BaseFactory factory;
    private final MapParser<?> mapParser;
    private final MapGenerator<?> mapGenerator;

    private Factory() {
        keyEventHandler = new KeyEventHandleImpl();
        factory = new ObjectFactoryImpl(keyEventHandler);
        mapParser = new GameMapParser();
        mapGenerator = new GameMapGenerator((ObjectFactory) factory);
    }

    // 4 getter methods

    public static KeyEventHandler getKeyEventHandler() {
        return FACTORY.keyEventHandler;
    }

    public static BaseFactory getObjectFactory() {
        return FACTORY.factory;
    }

    public static MapParser<?> getMapParser() {
        return FACTORY.mapParser;
    }

    public static MapGenerator<?> getMapGenerator() {
        return FACTORY.mapGenerator;
    }
}
