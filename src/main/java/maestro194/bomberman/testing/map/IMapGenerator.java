package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.objects.Object;

import java.util.List;

public interface IMapGenerator<Entity> {
    List<Object> generate(List<List<Entity>> mapEntity);
}
