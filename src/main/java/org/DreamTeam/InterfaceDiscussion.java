package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class InterfaceDiscussion extends Parent {

    ArrayList<Discussion> ListeDiscussion;


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
        rectangle = new Rectangle(width, height, Color.WHITE);
        this.getChildren().add(rectangle);
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
        //deplace(width);
    }
}
