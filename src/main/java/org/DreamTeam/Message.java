package org.DreamTeam;

import java.io.Serializable;

/**
 * <h1>Message</h1>
 * <h2>Attributs</h2>
 * <ul>
 *     <li>content : String (contenu du message)</li>
 *     <li>date : String (date d'envoi du message)</li>
 *     <li>author : String (auteur du message)</li>
 * </ul>
 * <p>Cette classe correspond à la description d'un message. Les différentes fonctions présentes sont les getters et
 * setters.</p>
 */
public class Message implements Serializable {

    public int id;
    public String content;
    public String date;
    public Utilisateur author;

    /**
     * <h2>getId</h2>
     * @return l'ID du message
     */
    public int getId() {
        return id;
    }

    /**
     * <h2>setId</h2>
     * @param id id du message
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <h2>getContent</h2>
     * @return le contenu du message
     */
    public String getContent() {
        return content;
    }

    /**
     * <h2>setContent</h2>
     * @param content contenu du message
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * <h2>getDate</h2>
     * @return la date du message
     */
    public String getDate() {
        return date;
    }

    /**
     * <h2>setDate</h2>
     * @param date du message
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * <h2>getAuthor</h2>
     * @return l'auteur du message
     */
    public Utilisateur getAuthor() {
        return author;
    }

    /**
     * <h2>setAuthor</h2>
     * @param author du message
     */
    public void setAuthor(Utilisateur author) {
        this.author = author;
    }

    /**
     * <h2>Fonction toString</h2>
     * @return une chaîne de caractères avec tous les détails du message.
     */
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
