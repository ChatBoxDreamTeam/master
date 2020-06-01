package org.DreamTeam;

import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * <b>Cette classe permet de présenter l'interface de discussion</b>
 *
 * <p>Cette classe va nous permettre d'afficher la totalité des personnes avec qui nous avons une discussion
 * j'y ajouterai un menu contextuel pour nous permettre d'ajoouter des membres
 * <a href="https://o7planning.org/fr/11115/tutoriel-javafx-contextmenu">voici un liens utile</a>
 * </p>
 *
 * @version 1.0
 * @author Pagalom
 */

public class InterfaceMessage extends Parent {

    private InterfaceMessageEnTete interfaceMessageEnTete;
    private InterfaceListeMessage interfaceListeMessage;
    private InterfaceNewMessage interfaceNewMessage;
    private Discussion discussion;
    private double height,width;
    private double endTitle=30.0f,startNewMessage = 50.f;

    /*public InterfaceMessage(double height, double width) {
        this.height=height;
        this.width=width;
    }*/

    public InterfaceMessage() {
    }

    public InterfaceMessage(double height, double width, Discussion discussion) {
        this.height=height;
        this.width=width;
        this.discussion=discussion;
        //interfaceMessageEnTete = new InterfaceMessageEnTete(discussion.getListeMembresToString(),Color.web(discussion.getCouleur()),endTitle,this.width);
        interfaceMessageEnTete = new InterfaceMessageEnTete(discussion.getListeMembresToString(),Color.LIGHTBLUE,this.width,endTitle);
        interfaceListeMessage = new InterfaceListeMessage(discussion,this.height-(endTitle+startNewMessage),this.width);
        //interfaceNewMessage = new InterfaceNewMessage(discussion,);//TODO mettre l'utilisateur lui même, c'est comme ça que Mathieu a créé son constructeur
        interfaceNewMessage = new InterfaceNewMessage(discussion);
        interfaceListeMessage.setTranslateY(endTitle);
        interfaceNewMessage.setTranslateY(this.height-startNewMessage);
        this.getChildren().addAll(interfaceMessageEnTete,interfaceListeMessage, interfaceNewMessage);
    }

    /*public InterfaceMessage(double height, double width) {
        //interfaceMessageEnTete = new InterfaceMessageEnTete(discussion.getListeMembresToString(),Color.web(discussion.getCouleur()),endTitle,this.width);
        interfaceMessageEnTete = new InterfaceMessageEnTete(discussion.getListeMembresToString(),Color.LIGHTBLUE,endTitle,this.width);
        interfaceListeMessage = new InterfaceListeMessage(discussion,this.width,this.height-(endTitle+startNewMessage));
        //interfaceNewMessage = new InterfaceNewMessage(discussion,);//TODO mettre l'utilisateur lui même, c'est comme ça que Mathieu a créé son constructeur
        interfaceNewMessage = new InterfaceNewMessage(discussion);
        interfaceListeMessage.setTranslateY(endTitle);
        interfaceNewMessage.setTranslateY(this.height-startNewMessage);
        this.height=height;
        this.width=width;
        this.discussion=discussion;
        Label tempLbl = new Label("test");
        System.out.println(tempLbl.getText());
        this.getChildren().addAll(interfaceMessageEnTete,interfaceListeMessage, interfaceNewMessage,tempLbl);
    }*/

    public InterfaceListeMessage getInterfaceListeMessage() {
        return interfaceListeMessage;
    }

    public void setInterfaceListeMessage(InterfaceListeMessage interfaceListeMessage) {
        this.interfaceListeMessage = interfaceListeMessage;
    }

    public InterfaceNewMessage getInterfaceNewMessage() {
        return interfaceNewMessage;
    }

    public void setInterfaceNewMessage(InterfaceNewMessage interfaceNewMessage) {
        this.interfaceNewMessage = interfaceNewMessage;
    }

    @Override
    public void resize(double v, double v1) {
        super.resize(v, v1);
        this.height=v1;
        this.width=v;
        // TODO resize();
    }

    /*
    public void setColor(){
        rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
    }
*/
    /**
     * Celle ci permettra de décaler l'interface agrandie ou rétrécie pour maintenir le coté droit.
     *Sachant cependant que je regarde un <a href = "https://o7planning.org/fr/10645/tutoriel-javafx-anchorpane-layout">Anchor Pane</a> pour voir si on ne peut pas faire les choses différement
     * @param addVal
     */
    /*
    public void deplace(double addVal){
        rectangle.setTranslateX(addVal);
    }
    */
}
