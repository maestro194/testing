package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.objects.Object;

import java.util.ArrayList;
import java.util.List;

public abstract class MapGenerator<Entity> implements IMapGenerator<Entity>{

    public List<Object> generate(List<List<Entity>> mapEntity) {
        List<Object> gameObjects = new ArrayList<>();

        for(int i = 0; i < mapEntity.size(); i ++) {
            List<Entity> li = mapEntity.get(i);
            for(int j = 0; j < li.size(); j ++) {
                Object generateEntity = generateEntity(j, i, li.get(j));
                if(generateEntity != null)
                    gameObjects.add(generateEntity);
            }
        }

        return gameObjects;
    }

    protected abstract Object generateEntity(int x, int y, Entity e);
}
