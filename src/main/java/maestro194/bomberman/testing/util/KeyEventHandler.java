package maestro194.bomberman.testing.util;

import javafx.scene.Scene;

public interface KeyEventHandler {

    void init(Scene scene);

    void registerEvent(KeyEventListener handler);

    void removeEvent(KeyEventListener handler);
}
