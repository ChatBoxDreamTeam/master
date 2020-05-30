package org.DreamTeam;

import javafx.beans.value.ChangeListener;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * listage des messages
 * @author César
 * @version 1.0
 */
public class InterfaceListeMessage extends Parent {

    private Discussion discussion;
    private VBox vbox;
    private ScrollPane scrollPane;

    public InterfaceListeMessage(){}

    public InterfaceListeMessage(Discussion disc){
        discussion=disc;
        scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
        scrollPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        vbox = new VBox();
        vbox.setPrefHeight(Region.USE_COMPUTED_SIZE);
        vbox.setPrefWidth(Region.USE_COMPUTED_SIZE);
        scrollPane.setContent(vbox);

        for (Message m:discussion.getFileMessages()){
            vbox.getChildren().add(new BulleMessage(m.getAuthor(),m.getContent()));
        }
    }
}
