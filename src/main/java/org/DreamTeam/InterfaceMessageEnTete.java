package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InterfaceMessageEnTete extends Parent {

    private Label content;
    private Color couleur;
    private Rectangle rect;
    private double height,width;


    public InterfaceMessageEnTete(String content, Color couleur, double height, double width) {
        this.content=new Label();
        this.content.setText(content);
        this.couleur = couleur;
        this.rect = new Rectangle(height,width);
        rect.setFill(couleur);
        this.height=height;
        this.width=width;
        resize(width,height);
        this.getChildren().addAll(rect,this.content);
    }

    @Override
    public void resize(double v, double v1) {
        super.resize(v, v1);
        this.width=v1;
        this.height=v;
    }

    public String getTitle() {
        return content.getText();
    }

    public Color getCouleur() {
        return couleur;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setTitle(String content) {
        this.content.setText(content);
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        this.rect.setFill(couleur);
    }
}
