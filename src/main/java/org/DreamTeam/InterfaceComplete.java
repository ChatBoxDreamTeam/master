package org.DreamTeam;

import javafx.scene.Parent;

public class InterfaceComplete extends Parent {

    /**
     * Interface Message, pour la partie droite de la fenêtre
     */
    InterfaceMessage interMsg;

    /**
     * Interface Discussion, pour la partie gauche de la fenêtre
     */
    InterfaceDiscussion interDisc;

    /**
     * Dimension de l'interface globale = dimension de la fenêtre
     */
    double height, width;

    /**
     * Pourcentage de place occupée par l'interface Discussion dans la partie gauche de la fenetre
     */
    double pourcentageSeparation=30.0f/100.0f;

    /**
     * <p>Methode permettant de changer la dimension de l'interface, dit "InterfaceComplete"
     * </p>
     * @param height hauteur que doit occuper le nouvel interface
     * @param width longueur que doit occuper le nouvel interface
     */
    public void changeSize(double height, double width){
        this.height=height;
        this.width=width;
        interMsg.resize(getHeight(),(1-pourcentageSeparation)*getWidth());
        interMsg.setTranslateX(pourcentageSeparation*width);
        interDisc.resize(getHeight(),pourcentageSeparation*getWidth());

    }

    /**
     * <p>Constructeur, créer l'interface
     * </p>
     * @param height hauteur que doit occuper l'interface
     * @param width longueur que doit occuper l'interface
     */
    public InterfaceComplete(double height, double width){
        this.height=height;
        this.width=width;

        interMsg = new InterfaceMessage(getHeight(),(1-pourcentageSeparation)*getWidth());
        interMsg.setTranslateX(pourcentageSeparation*width);

        interDisc = new InterfaceDiscussion(getHeight(),pourcentageSeparation*getWidth());

        this.getChildren().addAll(interDisc, interMsg);
    }

    /**
     * <p>Methode permettant de récupérer la hauteur de l'interface
     * </p>
     * @return la hauteur de l'interface
     */
    public double getHeight() {
        return height;
    }

    /**
     * <p>Methode permettant de récupérer la longueur de l'interface
     * </p>
     * @return la longueur de l'interface
     */
    public double getWidth() {
        return width;
    }
}