package main;

public class Jauge {
    protected TypeJauge type;
    protected String nom;
    protected int valeur;

    public Jauge(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    /**
     * Getter et setter
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public TypeJauge getType() {
        return type;
    }

    public void setType(TypeJauge type) {
        this.type = type;
    }

    /**
     * Méthodes
     */

    @Override
    public String toString() {
        return "[" +
            "#" . repeat(Math.max(0, this.valeur)) +
            "_" . repeat(Math.max(0, 50 - (Math.max(this.valeur, 0)))) +
            "] " +
            this.getNom();
    }
}
