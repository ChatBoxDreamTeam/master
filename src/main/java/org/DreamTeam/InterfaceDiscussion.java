package org.DreamTeam;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <h1>InterfaceDiscussion</h1>
 * <h2>Attributs</h2>
 * <ul>
 *     <li>ListeDiscussion : ArrayList<Discussion> (Tableau des discussions)</li>
 *     <li>interfaceContactArrayList : ArrayList<InterfaceContact> (Tableau des interfaces de discussion (=discussions graphiquement))</li>
 *     <li>ic : InterfaceContact (Interace en cours d'utilisation par la classe lors des fonctions, etc.)</li>
 *     <li>height : double (Hauteur de la partie gauche de la fenetre (interface discussion))</li>
 *     <li>width : double (Largeur de la partie gauche de la fenetre (interface discussion))</li>
 * </ul>
 */

public class InterfaceDiscussion extends Parent implements DiscussionListener {
    private ArrayList<Discussion> ListeDiscussion;
    private ArrayList<InterfaceContact> interfaceContactArrayList;
    private InterfaceContact ic;
    double height, width;
    int i = 0;

    /**
     * Ce rectangle représente la partie droite avec les messages
     */
    Rectangle rectangle;

    /**
     * <p>Constructeur, créer un rectangle définissant la zone
     * </p>
     * @param height hauteur que doit occuper le rectangle (l'interface)
     * @param width longueur que doit occuper le rectangle (l'interface)
     */
    public InterfaceDiscussion(double height, double width){
        ListeDiscussion = new ArrayList<>();
        interfaceContactArrayList = new ArrayList<>();
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(width, height, Color.LIGHTGRAY);
        this.getChildren().add(rectangle);
        for(Node node : interfaceContactArrayList){
            node.setOnMouseClicked(event -> System.out.println("Clicked"));
        }
    }

    /**
     * <p>Permet de redimensionner le rectangle (l'interface)
     * </p>
     * @param height hauteur que doit occuper le rectangle (l'interface)
     * @param width longueur que doit occuper le rectangle (l'interface)
     */
    public void resize(double height, double width){
        rectangle.setHeight(height);
        rectangle.setWidth(width);

    }

    /**
     * <p>Permet d'ajouter une nouvelle discussion à la liste
     * </p>
     * @param o nouvel élément à ajouter
     */
    @Override
    public void update(Object o) {
        this.ListeDiscussion.add((Discussion) o);
        this.newInterfaceContact(((Discussion) o).getListeMembres().get(0).getPseudo(), i);
        i = i+1;
    }

    /**
     * <p>Créer graphiquement la discussion
     * </p>
     * @param titre titre de la discussion
     * @param nbDiscussion nombre de discussion actuellement existant
     */
    private void newInterfaceContact(String titre, int nbDiscussion) {
        ic = new InterfaceContact(this.width/5, this.width/5, titre, nbDiscussion);
        interfaceContactArrayList.add(ic);
        this.getChildren().add(ic);
    }

    /**
     * <p>Permet de replacer correctement graphiquement les discussions lors d'une suppression d'élément
     * </p>
     */
    public void refreshUI() {
        for(int i=0; i<interfaceContactArrayList.size(); i++) {
            ic=interfaceContactArrayList.get(i);
            //ic.setPositionX(ic.getPositionX());
            ic.setPositionY((i*this.width/5+5)+i*10);
        }
    }

    /**
     * <p>Permet d'obtenir le nombre de discussion existante.
     * </p>
     * @return nombre de discussion existante
     */
    public int getNumberOfDiscution() {
        return interfaceContactArrayList.size();
    }

    /**
     * <p>Permet d'obtenir la liste des discussions
     * </p>
     * @return liste des discussions
     */
    public ArrayList<InterfaceContact> getInterfaceContactArrayList(){
        return interfaceContactArrayList;
    }

    /**
     * <p>Permet de supprimer une discussion
     * </p>
     * @param interfaceContact  discussions
     */
    public void deleteDiscussion(InterfaceContact interfaceContact) {
        interfaceContactArrayList.remove(interfaceContact);
        this.getChildren().remove(interfaceContact);
        i = i - 1;
        refreshUI();
    }

    /**
     * <p> Permet d'ajouter un membre a la discussion en cours
     * </p>
     * @param interfaceContact discussions
     */
    public void addMemberToDiscussion(InterfaceContact interfaceContact){
        Utilisateur utilisateur = null;
        this.ListeDiscussion.get(interfaceContact.getDiscussionId()).addMembre(utilisateur);
    }

    /**
     * <p> Permet d'ajouter un membre a la discussion en cours
     * </p>
     * @param interfaceContact discussions
     * @param pseudo Champs remplie
     */
    public void addMemberToDiscussion(InterfaceContact interfaceContact, TextField pseudo){
        Utilisateur util = new Utilisateur(pseudo.getText());
        Text Titre = interfaceContact.getDiscussionTitle();
        Titre.setText(Titre.getText() + " " + pseudo.getText());
        interfaceContact.setDiscussionTitle(Titre.getText());
        this.ListeDiscussion.get(interfaceContact.getDiscussionId()).addMembre(util);
    }

    /**
     * <p>Permet de créer une nouvelle discussion
     * </p>
     */
    public void createDiscussion() {
            newInterfaceContact("Discussion " + String.valueOf(i), i);
        i = i +1;
    }

    /**
     * <p>Permet de créer une nouvelle discussion
     * </p>
     * @param name Permet de donner un nom à une discussion
     */
    public void createDiscussion(String name) {
        Utilisateur util = new Utilisateur(name);
        Discussion disc = new Discussion(name, new ArrayList<Utilisateur>(Collections.singleton(util)), null, new ArrayList<DiscussionListener>(Collections.singleton(this)));
        newInterfaceContact(""+name, i);
        i = i +1;
        ListeDiscussion.add(disc);
    }

    public InterfaceContact getIc() {
        return ic;
    }

    /**
     * getter de la liste de discussion
     * @return Liste de Discussion
     */
    public ArrayList<Discussion> getListeDiscussion() {
        return ListeDiscussion;
    }
}
