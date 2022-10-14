package maestro194.bomberman.testing.map;

import java.io.File;
import java.util.List;

public interface IMapParser<Entity> {
    List<List<Entity>> parse(String file);
}
