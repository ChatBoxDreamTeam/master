package org.DreamTeam;

import javafx.scene.Parent;
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

public class InterfaceDiscussions extends Parent {

    Rectangle rectangle;
    /**
     * Pour le moment un simple rectangle pour représenter la zone
     */
    public InterfaceDiscussions(double height, double width) {
        rectangle = new Rectangle(width, height, Color.CYAN);
        this.getChildren().add(rectangle);
    }

    public void resize(double addVal){
        rectangle.setWidth(rectangle.getWidth()+addVal);
        deplace(addVal);
    }

    public void deplace(double addVal){
        rectangle.setTranslateX(addVal);
    }
}
