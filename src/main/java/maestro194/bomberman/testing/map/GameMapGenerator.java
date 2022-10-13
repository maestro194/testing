package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.Factory;
import maestro194.bomberman.testing.objects.Object;

public class GameMapGenerator extends MapGenerator<MapEntity> {
    private Factory factory;

//    public GameMapGenerator(Factory);

    @Override
    protected Object generateEntity(int x, int y, MapEntity e) {
        switch (e) {
            case BOMB:
                return null;
            case BOMBER:
                return null;
            case GRASS:
                return null;
            case WALL:
                return null;
            default:
                return null;
        }
    }
}
