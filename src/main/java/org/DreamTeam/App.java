package org.DreamTeam;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
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

    /**
     * <h2>start</h2>
     * <p>Démarre le stage avec la scène pour JavaFX</p>
     * @param stage stage pour l'affichage de la scène
     */
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

        // Définit la liste des utilisateurs
        ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();

        Gson gson = new Gson();
        /*
         Le try/catch/finally suivant va lire des discussions présentes dans des fichiers JSON dans le dossier Discussions.
         Pour chaque fichier JSON, le programme va les parser avec Files.walk et BufferedReader.
         Le programme va ensuite ajouter les utilisateurs présents dans les discussions.
         Pour s'assurer du bon fonctionnement, le programme va afficher chaque utilisateur avec ses attributs.
         */
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