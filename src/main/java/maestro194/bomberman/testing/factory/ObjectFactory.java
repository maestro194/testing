package maestro194.bomberman.testing.factory;

import maestro194.bomberman.testing.objects.*;

public interface ObjectFactory extends BaseFactory{
    MoveObject getMoveObject(int x, int y);         // moveObj
    Bomb getBomb(int x, int y);                     // bomb

    Bomber getBomber(int x, int y);                 // bomber

    Wall getWall(int x, int y);                     // wall
}
