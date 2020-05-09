package org.DreamTeam;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b>JavaFX App</b>
 *
 * <p>pour l'utilisation des tags de javaDocs, liens pour les tags : <a href="https://idratherbewriting.com/java-javadoc-tags/">ici</a></p>
 * <p>pour l'ordre d'utilisation dee ces tags, lien documentation : <a href="https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html#tag">ici</a></p>
 * <p>Utilise java nio pour parcourir le repertoire des discussions et cree chaque utilisateur en fonction des discussions</p>
 *
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        var scene = new Scene(root, 640, 480);

        root.getChildren().add(new InterfaceComplete(scene.getHeight(),scene.getWidth()));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();

        Gson gson = new Gson();

        try(Stream<Path> walk = Files.walk(Paths.get("src\\Discussions"))){
            List<Path> result = walk.filter(Files::isRegularFile).collect(Collectors.toList());
            for (Path r : result){
                try (BufferedReader bufferedReader = Files.newBufferedReader(r)){
                    // Conversion du JSON
                    Utilisateur user = gson.fromJson(bufferedReader, Utilisateur.class);
                    listeUtilisateurs.add(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for(Utilisateur utilisateur : listeUtilisateurs){
                System.out.println(utilisateur);
            }
            // Lancement de l'interface graphique
            launch();
        }
    }
}