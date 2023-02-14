package main;

public class JaugeClerge extends Jauge {
    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public JaugeClerge(String nom, int valeur) {
        super("Clergé", valeur);
        super.setType(TypeJauge.CLERGE);
    }
}
