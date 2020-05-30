package org.DreamTeam;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BulleMessage {
    private Utilisateur author;
    private String content;
    private Color couleur;
    private Label lbl;
    public BulleMessage(Utilisateur author, String content, Color couleur){
        this.author=author;
        this.content=content;
        this.couleur=couleur;

        lbl=new Label(author+"\n"+content);
    }
}
