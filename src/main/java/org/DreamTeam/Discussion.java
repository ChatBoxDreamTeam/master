package org.DreamTeam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.image.Image;
import javafx.scene.paint.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * <h1>Discussion</h1>
 * <h2>Attributs</h2>
 * <ul>
 *     <li>titre : String (titre de la discussion)</li>
 *     <li>listeMembres : ArrayList (liste des membres de la discussion)</li>
 *     <li>fileMessages : ArrayList (liste des messages présents dans la discussion)</li>
 * </ul>
 * <p>Le constructeur ne fait rien mais la classe dispose de getters et setters pour définir les caractéristiques de la discussion.</p>
 * <p>Les fonctions qui permettent d'ajouter des membres et des messages retournent un booléen.
 * Ce sera utile dans le programme principal pour vérifier si l'ajout de l'élément a fonctionné</p>
 */

public class Discussion {

    public String titre;
    public ArrayList<Utilisateur> listeMembres;
    public ArrayList<Message> fileMessages;
    public ArrayList<DiscussionListener> listeners = new ArrayList<>();
    public String couleurChat;

    public Discussion() {
        this.listeMembres = new ArrayList<>();
        this.fileMessages = new ArrayList<>();
        if (!listeMembres.isEmpty())couleurChat = listeMembres.get(0).getCouleurChat();
    }

    /**
     * <h2>getTitre</h2>
     * @return le titre de la discussion
     */
    public String getTitre() {
        return titre;
    }

    /**
     * <h2>setTitre</h2>
     * @param titre titre de la discussion
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * <h2>getListeMembres</h2>
     * @return la liste des membres dans la discussion
     */
    public ArrayList<Utilisateur> getListeMembres() {
        return this.listeMembres;
    }

    /**
     * <h2>getFileMessages</h2>
     * @return la liste des messages envoyés
     */
    public ArrayList<Message> getFileMessages(){
        return this.fileMessages;
    }

    /**
     * <h2>addMembre</h2>
     * @param u membre de la discussion
     * @return un booléen qui indique si l'ajout a été fait
     */
    public boolean addMembre(Utilisateur u){
        this.listeMembres.add(u);
        return true;
    }

    /**
     * <h2>addMessage</h2>
     * @param m message de la discussion
     * @return un booléen qui indique si l'ajout a été fait
     */
    public boolean addMessage(Message m){
        this.fileMessages.add(m);
        return true;
    }

    /**
     * <h2>addMessage - Images</h2>
     * @param m message de la discussion
     * @param i image envoyée dans la discussion
     * @return un booléen qui indique si l'ajout a été fait
     */
    public boolean addMessage(Message m, Image i){
        this.fileMessages.add(m);
        return true;
    }

    /**
     * <h2>exportToJSON</h2>
     * Fonction qui exporte la discussion dans un fichier JSON.
     * @param filename nom du fichier JSON qui sera généré
     */
    public void exportToJSON(String filename){
        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(filename));
            gson.toJson(this, writer);
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * <h2>importFromJSON</h2>
     * Fonction qui importe la discussion depuis un fichier JSON.
     * @TODO TROUVER UN MOYEN DE SIMPLIFIER L'IMPORT
     * @param filename nom du fichier JSON à importer
     */
    public void importFromJSON(Path filename){
        try{
            Gson gson = new Gson();
            try(BufferedReader bufferedReader = Files.newBufferedReader(filename)){
                Discussion test = gson.fromJson(bufferedReader, Discussion.class);
                this.setTitre(test.getTitre());
                for(Utilisateur u : test.getListeMembres()){
                    this.addMembre(u);
                }
                for(Message m : test.getFileMessages()){
                    this.addMessage(m);
                }
                for(DiscussionListener listener : this.listeners){
                    listener.update(this);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addObserver(DiscussionListener listener){
        this.listeners.add(listener);
    }

    public void removeObserver(DiscussionListener listener){
        this.listeners.remove(listener);
    }


    /**
     * <h2>toString</h2>
     * Overrides the default toString function.
     * Affiche tous les détails de la discussion lors d'un println.
     * @return les attributs sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return "Discussion{" +
                "titre='" + titre + '\'' +
                ", listeMembres=" + listeMembres +
                ", fileMessages=" + fileMessages +
                '}';
    }

    public String getCouleur() {
        return couleurChat;
    }

    public void setCouleur(String couleur) {
        this.couleurChat = couleur;
    }
}
