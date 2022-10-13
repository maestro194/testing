package maestro194.bomberman.testing.util;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;

public interface KeyEventHandler {

    void init(Scene scene);

    void registerEvent(KeyEventListener handler);

    void removeEvent(KeyEventListener handler);
}
