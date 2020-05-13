package org.DreamTeam;

import java.util.ArrayList;

public class TestContact {
    public static void main(String[] args) {
        ListContact contact = null;
        //ArrayList<Contact> contactList;

        Contact soeur1 = new Contact("Erika", "Dziedzic", "0707070707");
        Contact soeur2 = new Contact("Julie", "Dziedzic", "0606060606");
        Contact copine = new Contact("prenom", "nom", "0111111111");


        copine.setFirstName("Claire");
        copine.setLastName("nom1");
        copine.setPhoneNumber("0607060706");
        ListContact.editLastNameContact(copine, "Dziedzic");

        ListContact.AddContact(soeur1);
        ListContact.AddContact(soeur2);
        ListContact.AddContact(copine);
        System.out.println("Total list : ");
        ListContact.showContactList();
        ListContact.orderContactByFirstName();
        System.out.println("\nordered list : ");
        ListContact.showContactList();
        ListContact.removeContact(soeur2);
        System.out.println("\nremoved contact list : ");
        ListContact.showContactList();
    }
}
