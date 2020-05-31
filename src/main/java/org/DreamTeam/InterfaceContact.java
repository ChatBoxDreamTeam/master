package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class InterfaceContact extends Parent {

    Rectangle rectangle;
    Text discussionTitle;
    double height, width;

    /**
     * <p>Constructeur, créer un rectangle définissant la zone
     * </p>
     * @param height hauteur que doit occuper le rectangle (l'interface)
     * @param width longueur que doit occuper le rectangle (l'interface)
     * @param nbDiscussion
     */
    public InterfaceContact(double height, double width, String discussionTitle, int nbDiscussion){
        this.height = height;
        this.width = width;
        this.rectangle = new Rectangle(width, height, Color.color(Math.random(), Math.random(), Math.random()));
        this.rectangle.setX(this.rectangle.getX()+10);
        //System.out.println(this.rectangle.getY()*nbDiscussion+10+this.rectangle.getWidth()*nbDiscussion);
        this.rectangle.setY(5+nbDiscussion*(this.rectangle.getY()+10+this.rectangle.getWidth()));
        //System.out.println(discussionTitle);
        this.discussionTitle = new Text(this.rectangle.getWidth()+this.rectangle.getX(), this.rectangle.getY()+this.rectangle.getWidth()/2+5, discussionTitle);
        this.getChildren().addAll(rectangle, this.discussionTitle);
    }

    public double getPositionX() {
        return this.rectangle.getX();
    }

    public double getPositionY() {
        return this.rectangle.getY();
    }

    public void setPositionX(double coord) {
        this.rectangle.setX(coord);
        this.discussionTitle.setX(this.rectangle.getWidth()+this.rectangle.getX());
    }

    public void setPositionY(double coord) {
        this.rectangle.setY(coord);
        this.discussionTitle.setY(this.rectangle.getY()+this.rectangle.getWidth()/2+5);
    }

    public Text getDiscussionTitle() {
        return discussionTitle;
    }

    public void setDiscussionTitle(String discussionTitle) {
        this.discussionTitle.setText(discussionTitle);
    }
}
