package maestro194.bomberman.testing;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.map.IMapGenerator;
import maestro194.bomberman.testing.map.IMapParser;
import maestro194.bomberman.testing.objects.Object;
import maestro194.bomberman.testing.objects.ObjectManager;
import maestro194.bomberman.testing.util.KeyEventHandler;

import java.io.File;
import java.net.URL;
import java.util.List;

public abstract class GameEngine<OF extends ObjectFactory, Entity> {

    public static int WIDTH;
    public static int HEIGHT;
    private TimerWithStat animationTimer;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Scene scene;
    private Group groupNodes;
    private ObjectManager objectManager = new ObjectManager();
    private OF objectFactory;
    private IMapParser<Entity> mapParser;
    private IMapGenerator<Entity> mapGenerator;
    private KeyEventHandler keyEventHandler;

    public GameEngine(OF objectFactory, IMapParser<Entity> mapParser, IMapGenerator<Entity> mapGenerator, KeyEventHandler keyEventHandler) {
        this.objectFactory = objectFactory;
        this.mapParser = mapParser;
        this.mapGenerator = mapGenerator;
        this.keyEventHandler = keyEventHandler;
        setGameLoop();
    }

    public void setGameLoop() {
        animationTimer = new TimerWithStat() {
            @Override
            public void handle(long time) {
                updateSprites(time);
                checkCollision();
                cleanSprites();
                renderSprites();
            }
        };
    }

    public void init(Stage stage, String map) {
        stage.setTitle("Bomberman");
        this.groupNodes = new Group();
        this.scene = new Scene(groupNodes);
        canvas = new Canvas(WIDTH, HEIGHT);
        graphicsContext = getCanvas().getGraphicsContext2D();
        getGroupNodes().getChildren().add(canvas);
        List<List<Entity>> parse = getMapParser().parse(map);
        List<Object> generate = getMapGenerator().generate(parse);
        keyEventHandler.init(getScene());
        stage.setScene(getScene());
        addObj(generate);
    }

    public void startGameLoop() {
        getAnimationTimer().start();
    }

    public void addObj(List<Object> generate) {
        objectManager.addObject(generate.toArray(new Object[0]));
        for(Object obj : generate) {

        }
    }

    public void removeObj(Object... gameObjects) {

    }

    public void updateSprites(long time) {
        for(Object object: objectManager.getObjectList())
            object.update(scene, time);
    }

    public void checkCollision() {

    }

    public void cleanSprites() {
        getObjectManager().cleanUpObject();
    }

    public void renderSprites() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(Object obj: objectManager.getObjectList()) {
            obj.render(graphicsContext);
        }
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

    public IMapParser<Entity> getMapParser() {
        return mapParser;
    }

    public IMapGenerator<Entity> getMapGenerator() {
        return mapGenerator;
    }

    public KeyEventHandler getKeyEventHandler() {
        return keyEventHandler;
    }
}
