package maestro194.bomberman.testing;

import maestro194.bomberman.testing.map.GameMapGenerator;
import maestro194.bomberman.testing.map.GameMapParser;
import maestro194.bomberman.testing.map.MapGenerator;
import maestro194.bomberman.testing.map.MapParser;
import maestro194.bomberman.testing.util.KeyEventHandleImpl;
import maestro194.bomberman.testing.util.KeyEventHandler;

public class Factory {
    private static final Factory FACTORY = new Factory();

    private final KeyEventHandler keyEventHandler;
    // object factory
    private final MapParser mapParser;
    private final MapGenerator mapGenerator;

    private Factory() {
        keyEventHandler = new KeyEventHandleImpl();
        // obj factory
        mapParser = new GameMapParser();
        mapGenerator = new GameMapGenerator();
    }

    // 4 getter methods

    public static KeyEventHandler getKeyEventHandler() {
        return FACTORY.keyEventHandler;
    }

    public static MapParser getMapParser() {
        return FACTORY.mapParser;
    }

    public static MapGenerator getMapGenerator() {
        return FACTORY.mapGenerator;
    }
}
