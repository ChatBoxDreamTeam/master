package org.DreamTeam;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 *
 * <p>pour l'utilisation des tags de javaDocs, liens pour les tags : <a href="https://idratherbewriting.com/java-javadoc-tags/">ici</a></p>
 *
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Group root = new Group();

        root.getChildren().add(new InterfaceComplete());

        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}