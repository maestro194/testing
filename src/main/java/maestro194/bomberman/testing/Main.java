package maestro194.bomberman.testing;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Bomberman bomberman = new Bomberman();
        bomberman.init(stage, "level_1.m");
        bomberman.startGameLoop();
        stage.show();
    }

}