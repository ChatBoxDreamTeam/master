package org.DreamTeam;

import java.util.ArrayList;

/**
 * <h1>Utilisateur</h1>
 * <h2>Attributs</h2>
 * <ul>
 *     <li>pseudo : String (pseudo de l'utilisateur)</li>
 *     <li>couleurChat : String - temporaire (couleur du pseudo dans les discussions)</li>
 *     <li>password : String (mot de passe de l'utilisateur)</li>
 *     <li>messages : ArrayList (messages échangés par l'utilisateur)</li>
 * </ul>
 * <p>Cette classe correspond à la représentation d'un utilisateur. Les fonctions présentes sont les getters et setters.</p>
 */
public class Utilisateur {

    public String pseudo;
    public String couleurChat;
    public String password;
    public ArrayList<Message> messages;

    public Utilisateur() {
    }

    /**
     * <h2>getPseudo</h2>
     * @return le pseudo de l'utilisateur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * <h2>setPseudo</h2>
     * @param pseudo de l'utilisateur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * <h2>getCouleurChat</h2>
     * @return la couleur du pseudo de l'utilisateur
     */
    public String getCouleurChat() {
        return couleurChat;
    }

    /**
     * <h2>setCouleurChat</h2>
     * @param couleurChat couleur du pseudo de l'utilisateur
     */
    public void setCouleurChat(String couleurChat) {
        this.couleurChat = couleurChat;
    }

    /**
     * <h2>getPassword</h2>
     * @return le mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }

    /**
     * <h2>setPassword</h2>
     * @param password mot de passe de l'utilisateur
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <h2>getMessages</h2>
     * @return la liste des messages de l'utilisateur
     */
    public ArrayList<Message> getMessages() {
        return messages;
    }

    /**
     * <h2>setMessages</h2>
     * @param messages de l'utilisateur
     */
    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "pseudo='" + pseudo + '\'' +
                ", couleurChat='" + couleurChat + '\'' +
                ", password='" + password + '\'' +
                ", messages=" + messages +
                '}';
    }
}
