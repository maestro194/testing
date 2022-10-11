package maestro194.bomberman.testing.objects;

import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public abstract class Object {
    protected List<Animation> animationList = new ArrayList<>();
    public Shape node;
    public double vX;
    public double vY;
    public boolean isDead;

    public abstract void update(Scene scene, long time);

    public boolean isColliding(Object obj) {
        if(!node.isVisible() || !obj.node.isVisible() || this == obj) {
            return false;
        }

        return node.getBoundsInParent().intersects(obj.node.getBoundsInParent());
    }

    // public abstract <T extends ObjectFactory>
}
