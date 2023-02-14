package main;

public class JaugePeuple extends Jauge {
    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     * @param valeur La valeur de la jauge
     */
    public JaugePeuple(String nom, int valeur) {
        super("Peuple", valeur);
        super.setType(TypeJauge.PEUPLE);
    }
}
