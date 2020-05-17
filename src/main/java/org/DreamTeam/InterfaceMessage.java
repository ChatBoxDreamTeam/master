package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
     * Pour le moment un simple rectangle pour représenter la zone
     */
    public InterfaceMessage(double height, double width) {
        rectangle = new Rectangle(width, height, Color.CYAN);
        this.getChildren().add(rectangle);
        Label txt = new Label("test");
        this.getChildren().add(txt);
    }

    /**
     * Je réfléchis à pouvoir changer la taille de l'interface via cette méthode
     * @param addVal valeur d'agrandissement de l'interface
     * @see DragResizeMod
     * @see #deplace(double décalage)
     */
    public void resize(double addVal){
        rectangle.setWidth(rectangle.getWidth()+addVal);
        deplace(addVal);
    }

    /**
     * Celle ci permettra de décaler l'interface agrandie ou rétrécie pour maintenir le coté droit.
     *Sachant cependant que je regarde un <a href = "https://o7planning.org/fr/10645/tutoriel-javafx-anchorpane-layout">Anchor Pane</a> pour voir si on ne peut pas faire les choses différement
     * @param addVal
     */
    public void deplace(double addVal){
        rectangle.setTranslateX(addVal);
    }
}
