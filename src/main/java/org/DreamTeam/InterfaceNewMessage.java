package org.DreamTeam;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * écriture des messages
 * @author Mathieu
 * @version 1.0
 */

/**
 * <h1>InterfaceNewMessage</h1>
 * <h2>Attributs</h2>
 * <ul>
 *     <li>discussion : Discussion (récupère la discution sur laquel l'utilisateur est)</li>
 *     <li>hBox : HBox (Créer une boite horizontale dans laquelle sera mis en place les éléments de cette interface)</li>
 *     <li>textMessage : TextField (Champs de texte de saisie)</li>
 *     <li>button : Button (Button servant à valider l'envoi du text)</li>
 *     <li>sendMessage : Message (paramètre le message ecrit pour l'ajouter au Json et donc dans la conversation)</li>
 *     <li>utilisateur : Utilisateur (Utilisateur de l'application)</li>
 *     <li>formatter : SimpleDateFormat (Créer un format de date correspondant a format du fichier json)</li>
 *     <li>date : Date (Donne la date actuel au moment ou l'application appelle date)</li>
 * </ul>
 * <p>Le constructeur prend en paramètre la discussion et l'utilisateur actuel.</p>
 * <p>La fonction setSendMessage permet de configurer le message envoyer pour qu'il correspond au fichier JSON.</p>
 */
public class InterfaceNewMessage extends Parent {

    private Discussion discussion;
    private HBox hBox;
    private TextField textMessage;
    private Button button;
    private Message sendMessage;
    private Utilisateur utilisateur;
    private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    private Date date;

    /**
     * <h2>Constructeur : InterfaceNewMessage </h2>
     * <p>Le contructeur de l'interface va créer une boite horizontale avec une champs de text ainsi qu'un bouton.
     * Une fois la saisie de text entrée, l'appuie sur le bouton ou sur la touche 'Entrée' va ajouter le message a la liste de discussion.</p>
     * @param disc objet Discussion, permettant de récupérer les listes de messages, membre et le titre.
     * @param util objet Utilisateur, permettant de récuperer le pseudo de l'utilisateur
     */
    public InterfaceNewMessage(Discussion disc, Utilisateur util){
        this.discussion = disc;
        this.utilisateur = util;
        int derniereValeur = discussion.getFileMessages().size();
        button = new Button("Send");
        textMessage = new TextField();
        this.hBox = new HBox();
        this.hBox.setPrefHeight(Region.USE_COMPUTED_SIZE);
        this.hBox.setPrefWidth(Region.USE_COMPUTED_SIZE);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                sendMessage= setSendMessage(utilisateur, textMessage, derniereValeur);
                discussion.addMessage(sendMessage);
            }
        };

        textMessage.setOnAction(event);
        button.setOnAction(event);

        hBox.getChildren().add(textMessage);
        hBox.getChildren().add(button);
        this.getChildren().add(hBox);

    }

    /**
     *<h2>Méthode : setSendMessage </h2>
     * <p>Cette méthode à pour but de récupérer les informations nécessaire afin de créer un nouveau Message correspondant au format du fichier JSON</p>
     * @param util l'utilisateur de l'application pour paramétrer l'auteur
     * @param text le text entrée dans le champs de saisie de text
     * @param id id de discussion (se base sur la taille d'élément de discussion et ajoute 1 pour avoir un nouvel id)
     * @return objet Message avec les paramètres entrés
     */
    public Message setSendMessage(Utilisateur util, TextField text, int id){
        sendMessage.setAuthor(util);
        sendMessage.setContent(text.getText());
        sendMessage.setDate(formatter.format(date = new Date()));
        sendMessage.setId(id+1);
        return sendMessage;
    }

}
