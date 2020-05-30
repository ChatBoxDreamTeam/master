package org.DreamTeam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceNewMessageTest extends Application {
    private Discussion discussion;
    private HBox hBox;
    private Button button;
    private TextField textMessage;
    private Label label;
    private Message sendMessage;
    private Utilisateur utilisateur;
    private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();

    public void start(Stage s) {

        s.setTitle("Test NewMessage");
        int dernièreValeur = discussion.getFileMessages().size();
        button = new Button("Send");
        textMessage = new TextField();
        this.hBox = new HBox();
        this.hBox.setPrefHeight(Region.USE_COMPUTED_SIZE);
        this.hBox.setPrefWidth(Region.USE_COMPUTED_SIZE);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                sendMessage.setAuthor(utilisateur.getPseudo());
                sendMessage.setContent(textMessage.getText());
                sendMessage.setDate(formatter.format(date));
                sendMessage.setId(dernièreValeur+1);
                discussion.addMessage(sendMessage);
            }
        };

        textMessage.setOnAction(event);
        button.setOnAction(event);

        hBox.getChildren().add(textMessage);
        hBox.getChildren().add(button);
        Scene sc = new Scene(hBox, 200, 200);
        s.setScene(sc);

        s.show();

    }
    public static void main(String args[]) {
        launch(args);
    }
}