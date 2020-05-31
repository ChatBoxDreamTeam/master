package org.DreamTeam;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
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

        interfaceC.createContextMenu();
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
        ArrayList<Discussion> listeDiscussions = new ArrayList<>();
        ArrayList<InterfaceContact> interfaceContactArrayList = new ArrayList<>();
        launch();

        /*
         Le try/catch/finally suivant va lire des discussions présentes dans des fichiers JSON dans le dossier Discussions.
         Pour chaque fichier JSON, le programme va les parser avec Files.walk et BufferedReader.
         Le programme va ensuite ajouter les utilisateurs présents dans les discussions.
         Pour s'assurer du bon fonctionnement, le programme va afficher chaque discussion avec ses attributs.
         */

        // PARTIE IMPORTATION DE JSON
        /*try(Stream<Path> walk = Files.walk(Paths.get("src\\Discussions"))){
            List<Path> paths = walk.filter(Files::isRegularFile).collect(Collectors.toList());
            for(Path path : paths){
                Discussion discussion = new Discussion();
                discussion.importFromJSON(path);
                interfaceContactArrayList.add(new InterfaceContact(50,50,discussion.getTitre()));

                listeDiscussions.add(discussion);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        for(Discussion d : listeDiscussions){
            System.out.println(d);
        }*/

        // PARTIE EXPORTATION DE JSON
        Discussion discussion = new Discussion();
        Utilisateur user1 = new Utilisateur();
        Utilisateur user2 = new Utilisateur();
        Message message1 = new Message();
        Message message2 = new Message();

        // définition des utilisateurs
        user1.setPseudo("Stan Pines");
        user2.setPseudo("Homer Simpson");
        user1.setCouleurChat("green");
        user2.setCouleurChat("blue");

        // définition des messages
        message1.setId(1);
        message1.setDate("2020-05-28");
        message1.setAuthor(user1.getPseudo());
        message1.setContent("Hello Homer Simpson");
        message2.setId(2);
        message2.setAuthor(user2.getPseudo());
        message2.setDate("2020-05-28");
        message2.setContent("Hello Stan Pines");

        // exportation
        discussion.addMembre(user1);
        discussion.addMembre(user2);
        discussion.addMessage(message1);
        discussion.addMessage(message2);
        discussion.setTitre("Discussion test");
        discussion.exportToJSON("src\\Discussions\\Stan_Pines.json");



    }
}