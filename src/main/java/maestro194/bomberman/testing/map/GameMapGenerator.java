package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.Factory;
import maestro194.bomberman.testing.objects.Object;

public class GameMapGenerator extends MapGenerator<MapEntity> {
//    private Factory factory;

//    public GameMapGenerator(Factory);

    @Override
    protected Object generateEntity(int x, int y, MapEntity e) {
        switch (e) {
            case BOMB:
                break;
            case BOMBER:
                break;
            case GRASS:
                break;
            case WALL:
                break;
        }
    }
}
