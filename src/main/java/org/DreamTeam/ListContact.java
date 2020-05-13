package org.DreamTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListContact {
    private static ArrayList<Contact> contactList = new ArrayList<Contact>();

    static void AddContact(Contact contact){
        contactList.add(contact);
    }

    static void removeContact(Contact contact){
        contactList.remove(contact);
    }

    public void editFirstNameContact(Contact contact, String newFirstName){
        contact.setFirstName(newFirstName);
    }

    public static void editLastNameContact(Contact contact, String newLastName){
        contact.setLastName(newLastName);
    }

    public static void editPhoneContact(Contact contact, String newPhoneNumber){
        contact.setPhoneNumber(newPhoneNumber);
    }

    public static void orderContactByFirstName(){
        Collections.sort(contactList, Contact.contactFirstName);
    }

    public static void orderContactByLastName(){
        Collections.sort(contactList, Contact.contactLastName);
    }

    public static void orderContactByPhone(){
        Collections.sort(contactList, Contact.contactPhoneNumber);
    }

    public static void showContactList(){
        for(Contact str: contactList){
            System.out.println(str);
        }
    }
}
/*
      private void sortContactByFirstName(ArrayList<Contact> contactList, Contact contact){
        contactList.sort(contact.getFirstName());
      }
*/
/*
    private void supressContact(String phoneNumber){
        //Cherche les informations dans les () et le supprime de la ListContact
    }
*/
/*
    private void editContact(String firstName, String lastName, String phoneNumber){
        //Cherche les informations dans les () et le modifie de la ListContact
    }
*/
/*
    Nergiz 22ans curde 100%
    Avril dans support : solution et outil
    Elle joue un instrument de musique spécialité de l'orient : du "saz"
*/

