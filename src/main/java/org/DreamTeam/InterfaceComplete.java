package org.DreamTeam;

import javafx.scene.Cursor;
import javafx.scene.Parent;

public class InterfaceComplete extends Parent {

    InterfaceDiscussions interDis;

    InterfaceMessages interMsg;

    double height, width;

    double pourcentageSeparation=35.0f/100.0f;

    public InterfaceComplete(double height, double width){
        this.height=height;
        this.width=width;

        interDis = new InterfaceDiscussions(getHeight(),(1-pourcentageSeparation)*getWidth());
        interDis.setTranslateX(pourcentageSeparation*width);

        interMsg = new InterfaceMessages(getHeight(),pourcentageSeparation*getWidth());

        this.getChildren().addAll(interMsg,interDis);
        this.setOnMouseMoved(e->{
            double machin = pourcentageSeparation*width;
            if (e.getX()+8>machin && e.getX()-8<machin)this.setCursor(Cursor.E_RESIZE);
            else this.setCursor(Cursor.DEFAULT);
        });
        this.setOnMousePressed(e->{
            double machin = pourcentageSeparation*width;
            if (e.getX()+8>machin && e.getX()-8<machin){
                 this.setOnMouseDragged(e2->{
                     interDis.resize(e2.getX()-machin);
                 });
            }
        });
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