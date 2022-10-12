package maestro194.bomberman.testing;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import maestro194.bomberman.testing.map.MapGenerator;
import maestro194.bomberman.testing.map.MapParser;
import maestro194.bomberman.testing.objects.Object;
import maestro194.bomberman.testing.objects.ObjectManager;

import java.io.File;
import java.util.List;

public abstract class GameEngine<Entity> {

    public static int WIDTH;
    public static int HEIGHT;
    private TimerWithStat animationTimer;
    private Scene scene;
    private Group groupNodes;
    private ObjectManager objectManager = new ObjectManager();
    // private ObjectFactory objectFactory = new ObjectFactory();
    private MapParser mapParser;
    private MapGenerator mapGenerator;
    // key logger - for key event

    public GameEngine(MapParser mapParser, MapGenerator mapGenerator) {
        this.mapParser = mapParser;
        this.mapGenerator = mapGenerator;
        setGameLoop();
    }

    public void setGameLoop() {
        animationTimer = new TimerWithStat() {
            @Override
            public void handle(long time) {
            updateSprites(time);
            checkCollision();
            cleanSprites();
            }
        };
    }

    public void init(Stage stage, File map) {
        stage.setTitle("Bomberman");
        this.groupNodes = new Group();
        this.scene = new Scene(groupNodes, WIDTH, HEIGHT);
        List<List<Entity>> parse = getMapParser().parse(map);
        // map gen
        // key logger
        stage.setScene(scene);
        // add obj
    }

    public void removeObj() {

    }

    public void addObj() {

    }

    public void updateSprites(long time) {
        for(Object object: objectManager.getObjectList())
            object.update(scene, time);
    }

    public void checkCollision() {

    }

    public void cleanSprites() {

    }

    public MapParser getMapParser() {
        return mapParser;
    }

    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }
}
