package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.Factory;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.objects.Object;

public class GameMapGenerator extends MapGenerator<MapEntity> {
    private ObjectFactory factory;

    public GameMapGenerator(ObjectFactory factory) {
        this.factory = factory;
    }

    @Override
    protected Object generateEntity(int x, int y, MapEntity e) {
        switch (e) {
            case BOMB:
                factory.getBomb(x, y);
                return null;
            case BOMBER:
                factory.getBomber(x, y);
                return null;
            case BRICK:
                factory.getBrick(x, y);
                return null;
            case GRASS:
                return null;
            case WALL:
                factory.getWall(x, y);
                return null;
            default:
                return null;
        }
    }
}
