package main;

public class JaugeArmee extends Jauge {
    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public JaugeArmee(String nom, int valeur) {
        super("Armée", valeur);
        super.setType(TypeJauge.ARMEE);
    }
}
