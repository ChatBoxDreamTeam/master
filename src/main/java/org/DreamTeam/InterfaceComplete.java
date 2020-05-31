package org.DreamTeam;

import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    double pourcentageSeparation=35.0f/100.0f;

    /**
     * <p>Menu contextuel pour les options lors du clic droit</p>
     */
    final ContextMenu contactContextMenu, mainContextMenu;

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

        Discussion discussion = new Discussion();
        discussion.addObserver(interDisc);
        try(Stream<Path> walk = Files.walk(Paths.get("src\\Discussions"))){
            List<Path> paths = walk.filter(Files::isRegularFile).collect(Collectors.toList());
            for(Path path : paths){
                discussion.importFromJSON(path);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
        this.getChildren().addAll(interDisc, interMsg);
        
        contactContextMenu = new ContextMenu();
        mainContextMenu = new ContextMenu();
        /*contextMenu.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("showing");
            }
        });
        contextMenu.setOnShown(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent e) {
                System.out.println("shown");
            }
        });
        final InterfaceContact[] ictest = {null};
        EventHandler<MouseEvent> eventHandler = event -> {

            ictest[0] = (InterfaceContact) event.getSource();
            System.out.println(ictest[0].getDiscussionTitle().getText());
            if(event.isPrimaryButtonDown()){
                interMsg.setColor();
            } else if(event.isSecondaryButtonDown()){
                contextMenu.show(event.getPickResult().getIntersectedNode(),Side.BOTTOM, 0, 0);
            }

        };
        for(Node node : interDisc.getInterfaceContactArrayList()){
            node.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
        }*/


        /*MenuItem item1 = new MenuItem("Delete message");
        item1.setOnAction(e -> {
            System.out.println(e.toString());
            interDisc.deleteDiscussion(ictest[0]);
        });
        MenuItem item2 = new MenuItem("Create discussion");
        item2.setOnAction(event -> interDisc.createDiscussion());
        contextMenu.getItems().addAll(item1, item2);*/
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

    /**
     * <h2>createContextMenu</h2>
     * <p>Fonction qui crée le menu contextuel, les options de ce menu et les actions associées.</p>
     */
    public void createContextMenu() {
        this.contactContextMenu.setOnShowing(event -> System.out.println("showing"));
        this.contactContextMenu.setOnShown(event -> System.out.println("shown"));
        final InterfaceContact[] contacts = {null};
        EventHandler<MouseEvent> eventHandler = event -> {
            contacts[0] = (InterfaceContact) event.getSource();
            if(event.isPrimaryButtonDown()){
                interMsg.setColor();
            } else if(event.isSecondaryButtonDown()){
                contactContextMenu.show(event.getPickResult().getIntersectedNode(), Side.BOTTOM, 0, 0);
            }
        };
        updateBehavior(eventHandler);
        /*for(Node node : interDisc.getInterfaceContactArrayList()){
            node.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
        }*/
        MenuItem item1 = new MenuItem("Delete message");
        item1.setOnAction(e -> {
            System.out.println(e.toString());
            interDisc.deleteDiscussion(contacts[0]);
        });
        MenuItem item2 = new MenuItem("Create discussion");
        item2.setOnAction(event -> {
            interDisc.createDiscussion();
            updateBehavior(eventHandler);
        });
        MenuItem item3 = new MenuItem("Create discussion");
        item3.setOnAction(event -> {
            interDisc.createDiscussion();
            updateBehavior(eventHandler);
        });
        contactContextMenu.getItems().addAll(item1, item2);
        mainContextMenu.getItems().add(item3);

        /*interDisc.setOnMousePressed(event -> {
            if(event.isSecondaryButtonDown()){
                mainContextMenu.show(event.getPickResult().getIntersectedNode().getParent(), Side.BOTTOM, event.getSceneX(), event.getSceneY());
            }
        });*/
    }

    public void updateBehavior(EventHandler<MouseEvent> eventHandler){
        for(Node node : interDisc.getInterfaceContactArrayList()){
            node.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
        }
    }
}