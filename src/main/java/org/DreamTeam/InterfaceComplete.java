package org.DreamTeam;

import javafx.scene.Parent;

public class InterfaceComplete extends Parent {
    InterfaceDiscussions interDis;
    InterfaceMessages interMsg;
    public InterfaceComplete(){
        interDis = new InterfaceDiscussions();
        this.getChildren().add(interDis);
    }
}
