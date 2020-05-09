package org.DreamTeam;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Discussion {

    String titre;
    ArrayList<Utilisateur> listeMembres;
    ArrayList<Message> fileMessages;

    public Discussion() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<Utilisateur> getListeMembres() {
        return listeMembres;
    }

    public boolean addMembre(Utilisateur u){
        this.listeMembres.add(u);
        return true;
    }

    public boolean addMessage(Message m){
        this.fileMessages.add(m);
        return true;
    }

    public boolean addMessage(Message m, Image i){
        this.fileMessages.add(m);
        return true;
    }
}
