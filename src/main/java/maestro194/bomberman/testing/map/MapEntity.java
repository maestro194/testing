package maestro194.bomberman.testing.map;

public enum MapEntity {
    BOMB("Bomb"),
    BOMBER("Bomber"),
    BRICK("Brick"),
    GRASS("Grass"),
    WALL("Wall");

    private String name;

    private MapEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
