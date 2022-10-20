package maestro194.bomberman.testing.map;

public class GameMapParser extends MapParser<MapEntity> {

    @Override
    protected MapEntity parseEntity(char charAt) {
        switch (charAt) {
            case '#':
                return MapEntity.WALL;
            case 'p':
                return MapEntity.BOMBER;
            case '*':
                return MapEntity.BRICK;
            case ' ':
                return MapEntity.GRASS;
            case '1':
                return MapEntity.BALLOOM;
            default:
                return null;
        }
    }
}
