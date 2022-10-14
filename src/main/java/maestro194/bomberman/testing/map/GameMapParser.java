package maestro194.bomberman.testing.map;

public class GameMapParser extends MapParser<MapEntity> {
    @Override
    protected String charConv(char charAt) {
        switch (charAt) {
            case '#':
                return "WALL";
            case 'p':
                return "BOMBER";
            case '*':
                return "BRICK";
            case ' ':
                return "GRASS";
            default:
                return "";
        }
    }

    @Override
    protected MapEntity parseEntity(char charAt) {
        return MapEntity.valueOf(charConv(charAt));
    }
}
