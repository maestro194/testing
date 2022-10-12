package maestro194.bomberman.testing.map;

public class GameMapParser extends MapParser<MapEntity> {
    @Override
    protected MapEntity parseEntity(char charAt) {
        return MapEntity.valueOf(String.valueOf(charAt));
    }
}
