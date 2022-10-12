package maestro194.bomberman.testing.map;

public enum MapEntity {
    BOMBER("Bomber"),
    WALL("Wall"),
    BOMB("Bomb"),
    GRASS("Grass");

    private String name;

    private MapEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
