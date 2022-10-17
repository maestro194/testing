package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.objects.Object;

public class GameMapGenerator extends MapGenerator<MapEntity> {
    private final ObjectFactory factory;

    public GameMapGenerator(ObjectFactory factory) {
        this.factory = factory;
    }

    @Override
    protected Object generateEntity(int x, int y, MapEntity e) {
        switch (e.toString()) {
            case "Bomb":
                return factory.getBomb(x, y);
            case "Bomber":
                return factory.getBomber(x, y);
            case "Brick":
                return factory.getBrick(x, y);
            case "Grass":
                return factory.getGrass(x, y);
            case "Wall":
                return factory.getWall(x, y);
            default:
                return null;
        }
    }
}
