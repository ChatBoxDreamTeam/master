package org.DreamTeam;

import javafx.scene.paint.Color;

import java.util.Comparator;

/**
 * <h1 color="8A5597">Contact</h1>
 * permet la création de contacts dans la liste, aini que leur gestion
 * @author Mathieu
 * @version 1.0
 * @see ListContact
 */
public class Contact {

    private String firstName;
    private String lastName;
    private Color couleurChat;

    /**
     * Constructeur d'un Contact
     * @param firstName prenom du contact
     * @param lastName nom du contact
     * @param color couleur du chat
     */
    public Contact(String firstName, String lastName, Color color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.couleurChat = color;
    }

    /**
     * Methode permettant de récupérer le prenom du contact
     * @return le prenom du contact
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Methode permettant de definir le prenom du contact
     * @param firstName prenom du contact
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Methode permettant de récupérer le nom du contact
     * @return le nom du contact
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Methode permettant de definir le nom du contact
     * @param lastName nom du contact
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Methode permettant de récupérer le numero du contact
     * @return le numero du contact
     */
    public Color getColor() {
        return couleurChat;
    }

    /**
     * Methode permettant de definir le numero du contact
     * @param couleur couleur du contact
     */
    public void setColor(Color couleur) {
        this.couleurChat = couleur;
    }

    /**
     * Override de toString : Affichage du contact
     * @return information du contact
     */
    @Override
    public String toString() {
        return ("FirstName : "+this.getFirstName()+
                "\tLastName : "+ this.getLastName());
    }

    /**
     * Methode de comparaison des prenom pour avoir une liste de contact trier par prenom
     */
    public static Comparator<Contact> contactFirstName = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String ContactFirstName1 = s1.getFirstName().toUpperCase();
            String ContactFirstName2 = s2.getFirstName().toUpperCase();

            return ContactFirstName1.compareTo(ContactFirstName2);
        }
    };

    /**
     * Methode de comparaison des prenom pour avoir une liste de contact trier par nom
     */
    public static Comparator<Contact> contactLastName = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String ContactLastName1 = s1.getLastName().toUpperCase();
            String ContactLastName2 = s2.getLastName().toUpperCase();

            return ContactLastName1.compareTo(ContactLastName2);
        }
    };

    /**
     * Methode de comparaison des prenom pour avoir une liste de contact trier par telephone
     */
    public static Comparator<Contact> contactPhoneNumber = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String ContactPhoneNumber1 = s1.getFirstName().toUpperCase();
            String ContactPhoneNumber2 = s2.getFirstName().toUpperCase();

            return ContactPhoneNumber1.compareTo(ContactPhoneNumber2);
        }
    };

}
