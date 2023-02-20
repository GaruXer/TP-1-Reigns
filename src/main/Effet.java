package main;

import java.util.Map;
import java.util.TreeMap;

public class Effet {
    protected String effet;
    protected Map<TypeJauge, Integer> effetJauge;

    public Effet(String effet) {
        this.effet = effet;
        this.effetJauge = new TreeMap<>();
    }

    /**
     * Getter et setter
     */

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public Map<TypeJauge, Integer> getEffetJauge() {
        return effetJauge;
    }

    public void setEffetJauge(Map<TypeJauge, Integer> effetJauge) {
        this.effetJauge = effetJauge;
    }

    /**
     * Méthodes
     */

    public String afficheEffet() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<TypeJauge, Integer> effet : effetJauge.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }

    public void appliqueEffet(Personnage personnage){
        for (Map.Entry<TypeJauge,Integer> effet : this.effetJauge.entrySet()) {
            switch (effet.getKey()) {
                case ARMEE:
                    personnage.getJaugeArmee().setValeur(
                            personnage.getJaugeArmee().getValeur()
                                    + effet.getValue());
                    break;
                case CLERGE:
                    personnage.getJaugeClerge().setValeur(
                            personnage.getJaugeClerge().getValeur()
                                    + effet.getValue());
                    break;
                case FINANCE:
                    personnage.getJaugeFinance().setValeur(
                            personnage.getJaugeFinance().getValeur()
                                    + effet.getValue());
                    break;
                case PEUPLE:
                    personnage.getJaugePeuple().setValeur(
                            personnage.getJaugePeuple().getValeur()
                                    + effet.getValue());
                    break;
            }
        }
    }

    public void ajouteEffet(TypeJauge jauge, int valeur){
        effetJauge.put(jauge, valeur);
    }
}
