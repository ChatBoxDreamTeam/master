package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class BulleMessage extends Parent {
    private String author;
    private String content;
    private Color couleur;
    private TextFlow lbl;
    public BulleMessage(Utilisateur author, String content){
        this.author=author.getPseudo();
        this.content=content;
        this.couleur=Color.web(author.getCouleurChat());

        Text auth = new Text(author.pseudo+" : ");
        auth.setFill(couleur);
        auth.setStyle("-fx-font-weight: bold");
        Text cont = new Text(content);

        lbl.getChildren().addAll(auth,cont);
        lbl.setPrefSize( Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().add(lbl);
    }
}
