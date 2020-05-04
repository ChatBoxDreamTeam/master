package org.DreamTeam;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InterfaceDiscussion extends Parent {
    public InterfaceDiscussion(double height, double width){
        Rectangle rectangle = new Rectangle(width,height, Color.WHITE);
        this.getChildren().add(rectangle);
    }
}
