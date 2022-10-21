package maestro194.bomberman.testing.objects;

import javafx.scene.canvas.GraphicsContext;
import maestro194.bomberman.testing.GameEngine;
import maestro194.bomberman.testing.sprites.Sprite;

import java.util.*;

public class ObjectManager {
    private List<Object> objectList = new ArrayList<>();
    private Set<Object> cleanUpSet = new HashSet<>();

    public void addObject(Object... objects) {
        objectList.addAll(Arrays.asList(objects));
    }

    public void removeObject(Object... objects) {
        objectList.removeAll(Arrays.asList(objects));
    }

    public void addToCleanUp(Object... objects) {
        cleanUpSet.addAll(Arrays.asList(objects));
    }

    public void cleanUpObject() {
        objectList.removeAll(cleanUpSet);
        cleanUpSet.clear();
    }

    public void renderSprites(GraphicsContext graphicsContext) {
        for(Object object: objectList)
            if(object instanceof Wall || object instanceof Brick || object instanceof Grass)
                object.render(graphicsContext);
        for(Object object: objectList)
            if(object instanceof MoveObject || object instanceof RandomMoveObject)
                object.render(graphicsContext);
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public Set<Object> getObjectSet() {
        return cleanUpSet;
    }
}
