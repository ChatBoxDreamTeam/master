package org.DreamTeam;

import com.google.gson.internal.bind.ArrayTypeAdapter;
import javafx.css.converter.DeriveSizeConverter;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class InterfaceDiscussion extends Parent implements DiscussionListener {

    private ArrayList<Discussion> ListeDiscussion;
    private InterfaceContact ic;
    double height, width;
    int i = 0;

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
        ListeDiscussion = new ArrayList<>();
        this.width = width;
        this.height = height;
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

    @Override
    public void update(Object o) {

        this.ListeDiscussion.add((Discussion) o);
        this.newInterfaceContact(((Discussion) o).getTitre(), i);
        i = i+1;
    }

    private void newInterfaceContact(String titre, int nbDiscussion) {
        ic = new InterfaceContact(this.width/5, this.width/5, titre, nbDiscussion);
        this.getChildren().add(ic);
    }
}
