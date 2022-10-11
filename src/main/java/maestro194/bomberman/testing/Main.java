package maestro194.bomberman.testing;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Bomberman bomberman = new Bomberman();
        // bomberman init
        // bomberman start game loop
        stage.show();
    }

}
