package org.DreamTeam;

import java.util.ArrayList;

public class Utilisateur {

    public String pseudo;
    public String couleurChat;
    public String password;
    public ArrayList<Message> messages;

    public Utilisateur() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getCouleurChat() {
        return couleurChat;
    }

    public void setCouleurChat(String couleurChat) {
        this.couleurChat = couleurChat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

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
