package main;

import java.util.Map;
import java.util.TreeMap;

public class Question {
    protected String nomPersonnage;
    protected String question;
    protected Effet effetGauche;
    protected Effet effetDroite;

    public Question(String nomPersonnage, String question, Effet effetGauche, Effet effetDroite) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
    }

    /**
     * Getter et setter
     */

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Effet getEffetGauche() {
        return effetGauche;
    }

    public void setEffetGauche(Effet effetGauche) {
        this.effetGauche = effetGauche;
    }

    public Effet getEffetDroite() {
        return effetDroite;
    }

    public void setEffetDroite(Effet effetDroite) {
        this.effetDroite = effetDroite;
    }

    /**
     * Méthodes
     */

    public void afficheQuestion() {
        String result = "[" + nomPersonnage + "] "
                + question
                + "[G: " + effetGauche.effet
                + ",D: " + effetDroite.effet
                + "]";
        System.out.println(result);
        System.out.println("Effet G:" + effetGauche.afficheEffet());
        System.out.println("Effet D:" + effetDroite.afficheEffet());
        System.out.flush();
    }
}
