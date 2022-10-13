package maestro194.bomberman.testing.objects;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class Object {
    protected List<Animation> animationList = new ArrayList<>();

    public static Image image;
    public double xPos;
    public double yPos;
    public static final double width = 16;
    public static final double height = 16;
    public double vX;
    public double vY;
    public boolean isDead;

    public Object(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public abstract void update(Scene scene, long time);

    public Rectangle2D getBoundary() {
        return new Rectangle2D(xPos, yPos, width, height);
    }
    public boolean isColliding(Object object) {
        return object.getBoundary().intersects(this.getBoundary());
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, xPos, yPos);
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }
}
