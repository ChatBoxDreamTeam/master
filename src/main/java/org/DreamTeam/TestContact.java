package org.DreamTeam;

import javafx.scene.paint.Color;

public class TestContact {
    public static void main(String[] args) {
        ListUtilisateur contact = null;
        //ArrayList<Contact> contactList;

        Utilisateur soeur1 = new Utilisateur("ErikaDziedzic");
        Utilisateur soeur2 = new Utilisateur("JulieDziedzic", "BD17AE");
        Utilisateur copine = new Utilisateur("prenomNom", "F7553F");


        copine.setPseudo("Claire");
        copine.setCouleurChat("5198824");

        ListUtilisateur.AddContact(soeur1);
        ListUtilisateur.AddContact(soeur2);
        ListUtilisateur.AddContact(copine);
        System.out.println("Total list : ");
        ListUtilisateur.showContactList();
        ListUtilisateur.orderContactByFirstName();
        System.out.println("\nordered list : ");
        ListUtilisateur.showContactList();
        ListUtilisateur.removeContact(soeur2);
        System.out.println("\nremoved contact list : ");
        ListUtilisateur.showContactList();
    }
}
