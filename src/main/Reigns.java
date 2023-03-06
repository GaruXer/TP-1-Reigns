package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Reigns {
    private static Personnage personnage;
    private static ArrayList<Question> questions;
    private static int nbTours;

    public static void main(String[] args) {
        initJeu();

        // tirage des questions
        while(!finDuJeu()){
            tourDeJeu();
        }
    }

    /**
     * Méthodes
     */

    private static void initJeu() {
        nbTours = 0;
        System.out.println("Bienvenue sur Reigns");

        initBanqueQuestions();
        initPersonnage();

        System.out.println(personnage.getGenre().longRegne() + " " + personnage.getNom());

        personnage.AfficheJauges();
    }

    private static void initPersonnage() {
        System.out.println("Création du personnage...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();

        String nom = scanner.nextLine();
        System.out.println("Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();

        Genre roiReine;

        if (genre == 1) {
            roiReine = Genre.ROI;
        } else {
            roiReine = Genre.REINE;
        }

        Reigns.personnage = new Personnage(nom,roiReine);
    }

    private static void initBanqueQuestions() {
        questions = new ArrayList<>();

        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                new Effets("Oui"),
                new Effets("Non")
        );
        question1.effetsGauche.ajouteEffet(TypeJauge.ARMEE, -5);
        question1.effetsGauche.ajouteEffet(TypeJauge.PEUPLE, +5);
        question1.effetsDroite.ajouteEffet(TypeJauge.PEUPLE, -7);
        questions.add(question1);

        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                new Effets("Importer de la nourriture"),
                new Effets("Ne rien faire")
        );
        question2.effetsGauche.ajouteEffet(TypeJauge.FINANCE,-5);
        question2.effetsGauche.ajouteEffet(TypeJauge.PEUPLE, +5);
        question2.effetsDroite.ajouteEffet(TypeJauge.PEUPLE, -5);
        questions.add(question2);

        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                new Effets("Faire un sacrifice") ,
                new Effets("Ne rien faire")
        );
        question3.effetsGauche.ajouteEffet(TypeJauge.CLERGE, +5);
        question3.effetsGauche.ajouteEffet(TypeJauge.PEUPLE, -3);
        question3.effetsDroite.ajouteEffet(TypeJauge.CLERGE, -5);
        questions.add(question3);

        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                new Effets("Le soutenir"),
                new Effets("Rester neutre")
        );
        question4.effetsGauche.ajouteEffet(TypeJauge.ARMEE, +3);
        question4.effetsGauche.ajouteEffet(TypeJauge.FINANCE, -3);
        question4.effetsGauche.ajouteEffet(TypeJauge.CLERGE, -3);
        question4.effetsDroite.ajouteEffet(TypeJauge.PEUPLE, +3);
        questions.add(question4);

        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                new Effets("Taxer énormément"),
                new Effets("Taxer un tout petit peu")
        );
        question5.effetsGauche.ajouteEffet(TypeJauge.FINANCE, +10);
        question5.effetsGauche.ajouteEffet(TypeJauge.PEUPLE, -5);
        question5.effetsDroite.ajouteEffet(TypeJauge.FINANCE, +1);
        question5.effetsDroite.ajouteEffet(TypeJauge.PEUPLE, -3);
        questions.add(question5);
    }

    private static void tourDeJeu() {
        nbTours++;
        Question question = getQuestionAleatoire();
        reponseQuestion(question);
        personnage.AfficheJauges();
    }

    private static boolean finDuJeu() {
        for (Map.Entry<TypeJauge, Jauge> jauge : personnage.jauges.entrySet()) {
            int value = jauge.getValue().getValeur();

            if (value <= 0 || value >= 50) {
                System.out.println(personnage.getNom() + " a perdu ! Son règne a duré " + nbTours + " tours");
                return true;
            }
        }
        return false;
    }

    private static Question getQuestionAleatoire() {
        int numQuestion = (int) (Math.random() * questions.size());
        return questions.get(numQuestion);
    }

    private static void reponseQuestion(Question question) {
        question.afficheQuestion();

        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";

        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }

        appliqueEffets(question, reponse);
    }

    private static void appliqueEffets(Question question, String reponse) {
        if (reponse.equals("G")) {
            question.effetsGauche.appliqueEffets(personnage);
        } else {
            question.effetsDroite.appliqueEffets(personnage);
        }
    }
}
