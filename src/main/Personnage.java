package main;

import java.util.Map;
import java.util.TreeMap;

public class Personnage {
    protected String nom;
    protected Genre genre;
    protected Map<TypeJauge, Jauge> jauges;

    public Personnage(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;

        // Initialisation des jauges entre 15 et 35 points
        jauges = new TreeMap<>();
        jauges.put(TypeJauge.CLERGE, new Jauge("Clergé", 15 + (int)(Math.random() * (35 - 15))));
        jauges.put(TypeJauge.PEUPLE, new Jauge("Peuple", 15 + (int)(Math.random() * (35 - 15))));
        jauges.put(TypeJauge.ARMEE, new Jauge("Armée", 15 + (int)(Math.random() * (35 - 15))));
        jauges.put(TypeJauge.FINANCE, new Jauge("Finance", 15 + (int)(Math.random() * (35 - 15))));
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

    public Jauge getJauges(TypeJauge type) {
        return jauges.get(type);
    }

    public void setJauges(TypeJauge typeJauge, Jauge jauge) {
        jauges.put(typeJauge, jauge);
    }

    /**
     * Méthodes
     */

    public void AfficheJauges() {
        for (Map.Entry<TypeJauge, Jauge> jauge : jauges.entrySet()) {
            System.out.println(jauge.getValue());
        }
        System.out.println();
    }
}
