package main;

public class Personnage {
    protected String nom;
    protected Genre genre;
    protected Jauge jaugeClerge, jaugePeuple, jaugeArmee, jaugeFinance;

    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;

        // Initialisation des jauges entre 15 et 35 points
        jaugeClerge = new Jauge("Clergé", 15 + (int)(Math.random() * (35 - 15)));
        jaugePeuple = new Jauge("Peuple", 15 + (int)(Math.random() * (35 - 15)));
        jaugeArmee = new Jauge("Armée", 15 + (int)(Math.random() * (35 - 15)));
        jaugeFinance = new Jauge("Finances", 15 + (int)(Math.random() * (35 - 15)));
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Jauge getJaugeClerge() {
        return jaugeClerge;
    }

    public void setJaugeClerge(Jauge jaugeClerge) {
        this.jaugeClerge = jaugeClerge;
    }

    public Jauge getJaugePeuple() {
        return jaugePeuple;
    }

    public void setJaugePeuple(Jauge jaugePeuple) {
        this.jaugePeuple = jaugePeuple;
    }

    public Jauge getJaugeArmee() {
        return jaugeArmee;
    }

    public void setJaugeArmee(Jauge jaugeArmee) {
        this.jaugeArmee = jaugeArmee;
    }

    public Jauge getJaugeFinance() {
        return jaugeFinance;
    }

    public void setJaugeFinance(Jauge jaugeFinance) {
        this.jaugeFinance = jaugeFinance;
    }

    /**
     * Méthodes
     */

    public void AfficheJauges() {
        System.out.println(jaugeClerge);
        System.out.println(jaugePeuple);
        System.out.println(jaugeArmee);
        System.out.println(jaugeFinance);
        System.out.println();
    }

    public boolean finDuJeu(){
        if (jaugeClerge.getValeur()<=0
                || jaugeClerge.getValeur()>=50
                || jaugePeuple.getValeur()<=0
                || jaugePeuple.getValeur()>=50
                || jaugeArmee.getValeur()<=0
                || jaugeArmee.getValeur()>=50
                || jaugeFinance.getValeur()<=0
                || jaugeFinance.getValeur()>=50){
            return true;
        } else {
            return false;
        }
    }
}
