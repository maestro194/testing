package maestro194.bomberman.testing.factory;

import javafx.scene.image.Image;
import maestro194.bomberman.testing.objects.*;

public interface ObjectFactory extends BaseFactory{
    Bomb getBomb(int x, int y);                     // bomb
    Bomber getBomber(int x, int y);                 // bomber
    Brick getBrick(int x, int y);
    Grass getGrass(int x, int y);
    Wall getWall(int x, int y);                     // wall
    Balloom getBalloom(int x, int y);
}
