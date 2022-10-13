package maestro194.bomberman.testing;

import maestro194.bomberman.testing.map.MapEntity;
import maestro194.bomberman.testing.map.MapGenerator;
import maestro194.bomberman.testing.map.MapParser;

public class Bomberman extends GameEngine{
    public Bomberman() {
        super(
                (MapParser<MapEntity>) Factory.getMapParser(),
                (MapGenerator<MapEntity>) Factory.getMapGenerator()
        );
    }
}
