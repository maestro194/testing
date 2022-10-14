package maestro194.bomberman.testing;

import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.map.MapEntity;
import maestro194.bomberman.testing.map.IMapGenerator;
import maestro194.bomberman.testing.map.IMapParser;

public class Bomberman extends GameEngine<ObjectFactory, MapEntity> {
    public Bomberman() {
        super(
                (ObjectFactory) Factory.getObjectFactory(),
                (IMapParser<MapEntity>) Factory.getMapParser(),
                (IMapGenerator<MapEntity>) Factory.getMapGenerator(),
                Factory.getKeyEventHandler()
        );
    }
}
