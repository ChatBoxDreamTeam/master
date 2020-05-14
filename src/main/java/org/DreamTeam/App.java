package org.DreamTeam;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * <b>JavaFX App</b>
 *
 * <p>pour l'utilisation des tags de javaDocs, liens pour les tags : <a href="https://idratherbewriting.com/java-javadoc-tags/">ici</a></p>
 * <p>pour l'ordre d'utilisation dee ces tags, lien documentation : <a href="https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html#tag">ici</a></p>
 *
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        var scene = new Scene(root, 640, 480);

        InterfaceComplete interfaceC = new InterfaceComplete(scene.getHeight(), scene.getWidth());
        root.getChildren().add(interfaceC);

        stage.setScene(scene);
        stage.show();

        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) ->
                interfaceC.changeSize(stage.getHeight(), stage.getWidth());
        stage.widthProperty().addListener(stageSizeListener);
        stage.heightProperty().addListener(stageSizeListener);
    }

    public static void main(String[] args) {
        launch();
    }
}