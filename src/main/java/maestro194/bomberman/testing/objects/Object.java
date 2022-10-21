package maestro194.bomberman.testing.objects;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import maestro194.bomberman.testing.GameEngine;
import maestro194.bomberman.testing.factory.BaseFactory;
import maestro194.bomberman.testing.factory.ObjectFactory;
import maestro194.bomberman.testing.sprites.Sprite;

import java.util.ArrayList;
import java.util.List;

public abstract class Object {
    protected List<Animation> animationList = new ArrayList<>();
    public Image image;
    public Position position;
    public static final double width = Sprite.SCALED_SIZE;
    public static final double height = Sprite.SCALED_SIZE;

    public Object(int x, int y, Image image) {
        position = new Position(x * Sprite.SCALED_SIZE, y * Sprite.SCALED_SIZE);
        this.image = image;
    }

    public abstract void update(Scene scene, long time);

    public Rectangle2D getBoundary() {
        return new Rectangle2D(position.getX(), position.getY(), width, height);
    }
    public boolean isColliding(Object object) {
        if(this == object)
            return false;
        return object.getBoundary().intersects(this.getBoundary());
    }

    public Position getPosition() {
        return position;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY());
    }

    // Collision
    public abstract <T extends ObjectFactory> void collide(GameEngine<T, ?> gameEngine, Object object);
}
