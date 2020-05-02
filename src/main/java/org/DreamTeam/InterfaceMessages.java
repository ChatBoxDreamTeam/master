package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InterfaceMessages extends Parent {
    public InterfaceMessages(double height, double width){
        Rectangle rectangle = new Rectangle(width,height, Color.WHITE);
        this.getChildren().add(rectangle);
    }
}
