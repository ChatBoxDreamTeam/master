package org.DreamTeam;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

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

    public Utilisateur() {
    }

    public Utilisateur(String pseudo) {
        this.pseudo = pseudo;
        this.couleurChat = randomColor();
    }

    public Utilisateur(String pseudo, String color) {
        this.pseudo = pseudo;
        if(isValidHexaCode(color)) this.couleurChat = color;
        else this.couleurChat = "49AA31";
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

    @Override
    public String toString() {
        return "Utilisateur{" +
                "pseudo='" + pseudo + '\'' +
                ", couleurChat='" + couleurChat + '\'';
    }


    /**
     * Methode de comparaison des prenom pour avoir une liste de contact trier par pseudo
     */
    public static Comparator<Utilisateur> contactPseudo = new Comparator<Utilisateur>() {

        public int compare(Utilisateur s1, Utilisateur s2) {
            String ContactPseudo1 = s1.getPseudo().toUpperCase();
            String ContactPseudo2 = s2.getPseudo().toUpperCase();

            return ContactPseudo1.compareTo(ContactPseudo2);
        }
    };

    /**
     * Methode de comparaison des prenom pour avoir une liste de contact trier par couleur (optionnelle)
     */
    public static Comparator<Utilisateur> contactColor = new Comparator<Utilisateur>() {

        public int compare(Utilisateur s1, Utilisateur s2) {
            String ContactColor1 = s1.getCouleurChat().toUpperCase();
            String ContactColor2 = s2.getCouleurChat().toUpperCase();

            return ContactColor1.compareTo(ContactColor2);
        }
    };

    /**
     * <h2>isValidHexaCode</h2>
     * <p>Fonction qui permet de vérifier si la chaine de caractères est un code hexadécimal valide.</p>
     * @param str chaîne de caractères à vérifier
     * @return la chaine de caractères vérifiée
     */
    public static boolean isValidHexaCode(String str)
    {
        String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        Pattern p = Pattern.compile(regex);

        if (str == null) return false;
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private String randomColor() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        return String.format("#%06x", rand_num);
    }
}
