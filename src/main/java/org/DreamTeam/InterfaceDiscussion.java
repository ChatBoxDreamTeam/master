package org.DreamTeam;

import com.google.gson.internal.bind.ArrayTypeAdapter;
import javafx.css.converter.DeriveSizeConverter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class InterfaceDiscussion extends Parent implements DiscussionListener {

    private ArrayList<Discussion> ListeDiscussion;
    private ArrayList<InterfaceContact> interfaceContactArrayList;
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
        interfaceContactArrayList = new ArrayList<>();
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(width, height, Color.WHITE);
        this.getChildren().add(rectangle);
        for(Node node : interfaceContactArrayList){
            node.setOnMouseClicked(event -> System.out.println("Clicked"));
        }
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
        interfaceContactArrayList.add(ic);
        this.getChildren().add(ic);
    }

    public void refreshUI() {
        for(int i=0; i<interfaceContactArrayList.size(); i++) {
            ic=interfaceContactArrayList.get(i);
            //ic.setPositionX(ic.getPositionX());
            ic.setPositionY((i*this.width/5+5)+i*10);
        }
    }

    public int getNumberOfDiscution() {
        return interfaceContactArrayList.size();
    }

    public ArrayList<InterfaceContact> getInterfaceContactArrayList(){
        return interfaceContactArrayList;
    }

    public void deleteDiscussion(InterfaceContact interfaceContact) {
        interfaceContactArrayList.remove(interfaceContact);
        this.getChildren().remove(interfaceContact);
        i = i - 1;
        refreshUI();
    }

    public void createDiscussion() {
        newInterfaceContact("Discussion " + String.valueOf(i), i);
        i = i +1;
    }
}
