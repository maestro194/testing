module maestro194.bomberman.testing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens maestro194.bomberman.testing to javafx.fxml;
    exports maestro194.bomberman.testing;
}