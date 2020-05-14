package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * <b>Cette classe permet de présenter l'interface de discussion</b>
 *
 * <p>Cette classe va nous permettre d'afficher la totalité des personnes avec qui nous avons une discussion
 * j'y ajouterai un menu contextuel pour nous permettre d'ajoouter des membres
 * <a href="https://o7planning.org/fr/11115/tutoriel-javafx-contextmenu">voici un liens utile</a>
 * </p>
 *
 * @version 1.0
 * @author Pagalom
 */

public class InterfaceMessage extends Parent {

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
    public InterfaceMessage(double height, double width) {
        rectangle = new Rectangle(width, height, Color.CYAN);
        Label lbl = new Label("TEST");
        this.getChildren().add(rectangle);
        this.getChildren().add(lbl);
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
