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


    private InterfaceListeMessage HPan;
    private SplitPane sp;
    private InterfaceListeMessage interfaceListeMessage;
    private InterfaceNewMessage interfaceNewMessage;

    public InterfaceMessage(double height, double width) {
        sp = new SplitPane();
        sp.orientationProperty().setValue(Orientation.HORIZONTAL);
        interfaceListeMessage = new InterfaceListeMessage();
        interfaceNewMessage = new InterfaceNewMessage();
        sp.setDividerPosition(1,0.8f);
        sp.getItems().addAll(interfaceListeMessage, interfaceNewMessage);
    }


    public InterfaceListeMessage getHPan() {
        return HPan;
    }

    public void setHPan(InterfaceListeMessage HPan) {
        this.HPan = HPan;
    }

    public SplitPane getSp() {
        return sp;
    }

    public void setSp(SplitPane sp) {
        this.sp = sp;
    }

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
}
