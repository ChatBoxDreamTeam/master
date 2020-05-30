package org.DreamTeam;

import javafx.scene.image.Image;

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

    String titre;
    ArrayList<Utilisateur> listeMembres;
    ArrayList<Message> fileMessages;

    public Discussion() {
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
        return listeMembres;
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
     * <h2>getFileMessages</h2>
     * @return la liste des messages
     */
    public ArrayList<Message> getFileMessages() {
        return fileMessages;
    }
}
