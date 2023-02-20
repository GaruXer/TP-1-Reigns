package main;

import java.util.Map;
import java.util.TreeMap;

public class Effets {
    protected String nom;
    protected Map<TypeJauge, Integer> effetsJauge;

    public Effets(String nom) {
        this.nom = nom;
        this.effetsJauge = new TreeMap<>();
    }

    /**
     * Getter et setter
     */

    public String getEffets() {
        return nom;
    }

    public void setEffets(String nom) {
        this.nom = nom;
    }

    public Map<TypeJauge, Integer> getEffetsJauge() {
        return effetsJauge;
    }

    public void setEffetsJauge(Map<TypeJauge, Integer> effetsJauge) {
        this.effetsJauge = effetsJauge;
    }

    /**
     * Méthodes
     */

    public String afficheEffets() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<TypeJauge, Integer> effet : this.effetsJauge.entrySet()) {
            int effetValeur = effet.getValue();

            result.append("jauge ").append(effet.getKey()).append(": ");
            if (effetValeur > 0) {
                result.append("+");
            }
            result.append(effetValeur).append("; ");
        }
        return result.toString();
    }

    public void ajouteEffet(TypeJauge jauge, int valeur){
        effetsJauge.put(jauge, valeur);
    }

    public void appliqueEffets(Personnage personnage){
        for (Map.Entry<TypeJauge, Integer> effet : this.effetsJauge.entrySet()) {
            switch (effet.getKey()) {
                case ARMEE -> personnage.getJaugeArmee().setValeur(
                        personnage.getJaugeArmee().getValeur()
                                + effet.getValue());
                case CLERGE -> personnage.getJaugeClerge().setValeur(
                        personnage.getJaugeClerge().getValeur()
                                + effet.getValue());
                case FINANCE -> personnage.getJaugeFinance().setValeur(
                        personnage.getJaugeFinance().getValeur()
                                + effet.getValue());
                case PEUPLE -> personnage.getJaugePeuple().setValeur(
                        personnage.getJaugePeuple().getValeur()
                                + effet.getValue());
            }
        }
    }
}
