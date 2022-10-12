package maestro194.bomberman.testing;

import javafx.scene.Group;
import javafx.scene.Scene;
import maestro194.bomberman.testing.objects.ObjectFactory;
import maestro194.bomberman.testing.objects.ObjectManager;

public abstract class GameEngine {

    private Scene scene;
    private Group groupNodes;
    private ObjectManager objectManager = new ObjectManager();
    // private ObjectFactory objectFactory = new ObjectFactory();
    // map parser - map updater
    // map generator -
    // key logger - for key event

    public GameEngine() {
        setGameLoop();
    }

    public void setGameLoop() {
        // animationTimer
        /**
         * handle
         *  sprite update
         *  collision check
         *  cleanup dead obj
         */
    }

    public void init() {

    }

    public void removeObj() {

    }

    public void addObj() {

    }
}
