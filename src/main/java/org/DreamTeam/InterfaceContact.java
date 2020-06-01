package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * <h1>InterfaceContact</h1>
 * <h2>Attributs</h2>
 * <ul>
 *     <li>rectangle : Rectangle (Représente l'image d'une discussion)</li>
 *     <li>discussionTitle : Text (Représente le nom de la discussion)</li>
 *     <li>height : double (Dimension du rectangle pour l'image)</li>
 *     <li>width : double (Dimension du rectangle pour l'image)</li>
 *     <li>discussionId : int (ID de la discussion)</li>
 * </ul>
 */

public class InterfaceContact extends Parent {
    Rectangle rectangle;
    Text discussionTitle;
    int discussionId;
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
        this.rectangle.setY(5+nbDiscussion*(this.rectangle.getY()+10+this.rectangle.getWidth()));
        this.discussionTitle = new Text(this.rectangle.getWidth()+this.rectangle.getX(), this.rectangle.getY()+this.rectangle.getWidth()/2+5, discussionTitle);
        this.getChildren().addAll(rectangle, this.discussionTitle);
        discussionId=nbDiscussion+1;
        System.out.println(rectangle.getStroke());
    }

    //=========================================================
    /**
     * <h2>setPositionX</h2>
     * @param coord coordonnée X de la discussion
     */
    public void setPositionX(double coord) {
        this.rectangle.setX(coord);
        this.discussionTitle.setX(this.rectangle.getWidth()+this.rectangle.getX());
    }
    /**
     * <h2>getPositionX</h2>
     * @return Renvoie la position X de la discussion
     */
    public double getPositionX() {
        return this.rectangle.getX();
    }
    //=========================================================

    /**
     * <h2>setPositionY</h2>
     * @param coord coordonnée Y de la discussion
     */
    public void setPositionY(double coord) {
        this.rectangle.setY(coord);
        this.discussionTitle.setY(this.rectangle.getY()+this.rectangle.getWidth()/2+5);
    }

    /**
     * <h2>getPositionY</h2>
     * @return Renvoie la position Y de la discussion
     */
    public double getPositionY() {
        return this.rectangle.getY();
    }

    //=========================================================
    /**
     * <h2>setDiscussionTitle</h2>
     * @param discussionTitle titre de la discussion
     */
    public void setDiscussionTitle(String discussionTitle) {
        this.discussionTitle.setText(discussionTitle);
    }

    /**
     * <h2>getDiscussionTitle</h2>
     * @return Renvoie le titre de la discussion
     */
    public Text getDiscussionTitle() {
        return discussionTitle;
    }
    //=========================================================

    /**
     * <h2>setDiscussionId</h2>
     * @param discussionIdNew titre de la discussion
     */
    public void setDiscussionId(int discussionIdNew) {
        this.discussionId=discussionIdNew;
    }

    /**
     * <h2>getDiscussionId</h2>
     * @return discussionId titre de la discussion
     */
    public int getDiscussionId() {
        return this.discussionId;
    }

    public void selectedContact(){
        rectangle.setStroke(Color.DARKBLUE);
    }
    public void unselectedContact(){
        rectangle.setStroke(null);
    }
    //=========================================================
}
