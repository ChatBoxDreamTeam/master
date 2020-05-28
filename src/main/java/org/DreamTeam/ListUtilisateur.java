package org.DreamTeam;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListUtilisateur {

    /**
     * ArrayList d'un objet Contact
     */
    private static ArrayList<Utilisateur> contactList = new ArrayList<Utilisateur>();

    /**
     * Methode pour ajouter un contact de la liste
     * @param contact le nom de l'object Contact à mettre dans la liste des contact
     */
    static void AddContact(Utilisateur contact){
        contactList.add(contact);
    }

    /**
     * Methode pour retirer un contact de la liste
     * @param contact le nom de l'object Contact à enlever dans la liste des contact
     */
    static void removeContact(Utilisateur contact){
        contactList.remove(contact);
    }

    /**
     * Methode pour modifier le prénom d'un contact de la liste
     * @param contact le nom de l'object Contact dans la liste des contact
     * @param newPseudo le nouveau pseudo que l'on souhaite donner au contact
     */
    public void editPseudoContact(Utilisateur contact, String newPseudo){
        contact.setPseudo(newPseudo);
    }

    /**
     * Methode pour modifier le nom d'un contact de la liste
     * @param contact le nom de l'object Contact dans la liste des contact
     * @param color la nouvelle couleur que l'on souhaite donner au contact
     */
    public static void editColorContact(Utilisateur contact, String color){
        contact.setCouleurChat(color);

    }

    /**
     * Methode pour trier les contact par pseudo
     */
    public static void orderContactByFirstName(){
        Collections.sort(contactList, Utilisateur.contactPseudo);
    }

    /**
     * Methode pour trier les contact par couleur
     */
    public static void orderContactByLastName(){
        Collections.sort(contactList, Utilisateur.contactColor);
    }

    /**
     * Methode pour afficher la liste des contact
     */
    public static void showContactList(){
        for(Utilisateur str: contactList){
            System.out.println(str);
        }
    }

}
