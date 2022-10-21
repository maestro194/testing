package maestro194.bomberman.testing;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.map.IMapGenerator;
import maestro194.bomberman.testing.map.IMapParser;
import maestro194.bomberman.testing.objects.Grass;
import maestro194.bomberman.testing.objects.MoveObject;
import maestro194.bomberman.testing.objects.Object;
import maestro194.bomberman.testing.objects.ObjectManager;
import maestro194.bomberman.testing.sprites.Sprite;
import maestro194.bomberman.testing.util.KeyEventHandler;
import maestro194.bomberman.testing.util.KeyEventListener;

import java.util.List;

public abstract class GameEngine<OF extends ObjectFactory, Entity> {

    public static int WIDTH;
    public static int HEIGHT;
    private TimerWithStat animationTimer;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Scene scene;
    private Group groupNodes;
    private final ObjectManager objectManager = new ObjectManager();
    private final OF objectFactory;
    private final IMapParser<Entity> mapParser;
    private final IMapGenerator<Entity> mapGenerator;
    private final KeyEventHandler keyEventHandler;

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

        List<List<Entity>> parse = getMapParser().parse(map);
        List<Object> generate = getMapGenerator().generate(parse);

        this.groupNodes = new Group();
        canvas = new Canvas(WIDTH * Sprite.SCALED_SIZE, HEIGHT * Sprite.SCALED_SIZE);
        graphicsContext = getCanvas().getGraphicsContext2D();
        groupNodes.getChildren().add(canvas);
        this.scene = new Scene(groupNodes);
        stage.setScene(getScene());

        keyEventHandler.init(getScene());

        addObj(generate);
    }

    public void startGameLoop() {
        getAnimationTimer().start();
    }

    public void addObj(List<Object> generate) {
        objectManager.addObject(generate.toArray(new Object[0]));
        for(Object object: generate)
            if(object instanceof KeyEventListener)
                keyEventHandler.registerEvent((KeyEventListener) object);
        generate.clear();
    }

    public void removeObj(Object... gameObjects) {
        objectManager.addToCleanUp(gameObjects);
        for(Object object: gameObjects) {
            if(object instanceof KeyEventListener)
                keyEventHandler.removeEvent((KeyEventListener) object);
        }
    }

    public void updateSprites(long time) {
        // object update
        for(Object object: objectManager.getObjectList())
            object.update(scene, time);
    }

    public void checkCollision() {
        for(Object object1 : objectManager.getObjectList()) {
            for(Object object2 : objectManager.getObjectList()) {
                if(object1 instanceof Grass || object2 instanceof Grass)
                    continue;
                if(handleCollision(object1, object2))
                    break;
            }
        }
    }

    public boolean handleCollision(Object object1, Object object2) {
        if(object1.isColliding(object2)) {
            object1.collide(this, object2);
            object2.collide(this, object1);
            return true;
        }
        return false;
    }

    public void cleanSprites() {
        getObjectManager().cleanUpObject();
    }

    public void renderSprites() {
        graphicsContext.clearRect(0, 0, getCanvas().getWidth(), getCanvas().getHeight());
        getObjectManager().renderSprites(graphicsContext);
    }

    public TimerWithStat getAnimationTimer() {
        return animationTimer;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public OF getObjectFactory() {
        return objectFactory;
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
