package maestro194.bomberman.testing;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import maestro194.bomberman.testing.map.MapGenerator;
import maestro194.bomberman.testing.map.MapParser;
import maestro194.bomberman.testing.objects.Object;
import maestro194.bomberman.testing.objects.ObjectManager;
import maestro194.bomberman.testing.util.KeyEventHandler;

import java.io.File;
import java.util.List;

public abstract class GameEngine<Entity> {

    public static int WIDTH;
    public static int HEIGHT;
    private TimerWithStat animationTimer;
    private Canvas canvas;
    private Scene scene;
    private Group groupNodes;
    private ObjectManager objectManager = new ObjectManager();
    // private ObjectFactory objectFactory = new ObjectFactory();
    private MapParser mapParser;
    private MapGenerator mapGenerator;
    private KeyEventHandler keyEventHandler;

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
        getGroupNodes().getChildren().add(canvas);
        List<List<Entity>> parse = getMapParser().parse(map);
        List<Object> generate = getMapGenerator().generate(parse);
        keyEventHandler.init(getScene());
        stage.setScene(getScene());
        addObj(generate);
    }

    public void removeObj() {

    }

    public void addObj(List<Object> generate) {
        objectManager.addObject(generate.toArray(new Object[0]));
        for(Object obj : generate) {

        }
    }

    public void updateSprites(long time) {
        for(Object object: objectManager.getObjectList())
            object.update(scene, time);
    }

    public void checkCollision() {

    }

    public void cleanSprites() {

    }

    public TimerWithStat getAnimationTimer() {
        return animationTimer;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Scene getScene() {
        return scene;
    }

    public Group getGroupNodes() {
        return groupNodes;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public MapParser getMapParser() {
        return mapParser;
    }

    public MapGenerator getMapGenerator() {
        return mapGenerator;
    }

    public KeyEventHandler getKeyEventHandler() {
        return keyEventHandler;
    }
}
