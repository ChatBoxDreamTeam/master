package org.DreamTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListContact {

    /**
     * ArrayList d'un objet Contact
     */
    private static ArrayList<Contact> contactList = new ArrayList<Contact>();

    /**
     * Methode pour ajouter un contact de la liste
     * @param contact le nom de l'object Contact à mettre dans la liste des contact
     */
    static void AddContact(Contact contact){
        contactList.add(contact);
    }

    /**
     * Methode pour retirer un contact de la liste
     * @param contact le nom de l'object Contact à enlever dans la liste des contact
     */
    static void removeContact(Contact contact){
        contactList.remove(contact);
    }

    /**
     * Methode pour modifier le prénom d'un contact de la liste
     * @param contact le nom de l'object Contact dans la liste des contact
     * @param newFirstName le nouveau prénom que l'on souhaite donner au contact
     */
    public void editFirstNameContact(Contact contact, String newFirstName){
        contact.setFirstName(newFirstName);
    }

    /**
     * Methode pour modifier le nom d'un contact de la liste
     * @param contact le nom de l'object Contact dans la liste des contact
     * @param newLastName le nouveau prénom que l'on souhaite donner au contact
     */
    public static void editLastNameContact(Contact contact, String newLastName){
        contact.setLastName(newLastName);
    }

    /**
     * Methode pour modifier le nom d'un contact de la liste
     * @param contact le nom de l'object Contact dans la liste des contact
     * @param newPhoneNumber le nouveau numero que l'on souhaite donner au contact
     */
    public static void editPhoneContact(Contact contact, String newPhoneNumber){
        contact.setPhoneNumber(newPhoneNumber);
    }

    /**
     * Methode pour trier les contact par prenom
     */
    public static void orderContactByFirstName(){
        Collections.sort(contactList, Contact.contactFirstName);
    }

    /**
     * Methode pour trier les contact par nom
     */
    public static void orderContactByLastName(){
        Collections.sort(contactList, Contact.contactLastName);
    }

    /**
     * Methode pour trier les contact par numero
     */
    public static void orderContactByPhone(){
        Collections.sort(contactList, Contact.contactPhoneNumber);
    }

    /**
     * Methode pour afficher la liste des contact
     */
    public static void showContactList(){
        for(Contact str: contactList){
            System.out.println(str);
        }
    }
}
