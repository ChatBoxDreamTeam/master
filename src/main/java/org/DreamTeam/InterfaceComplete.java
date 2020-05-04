package org.DreamTeam;

import javafx.scene.Parent;

public class InterfaceComplete extends Parent {

    InterfaceMessage interDis;

    InterfaceDiscussion interMsg;

    double height, width;

    double pourcentageSeparation=35.0f/100.0f;

    public InterfaceComplete(double height, double width){
        this.height=height;
        this.width=width;

        interDis = new InterfaceMessage(getHeight(),(1-pourcentageSeparation)*getWidth());
        interDis.setTranslateX(pourcentageSeparation*width);

        interMsg = new InterfaceDiscussion(getHeight(),pourcentageSeparation*getWidth());

        this.getChildren().addAll(interMsg,interDis);
    }

    public void deplacementSeparation(){

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}