import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecteurCSV {

    public void chargerDocuments(
            String chemin,
            Bibliotheque bibliotheque
    ) {
        try (BufferedReader lecteur =
                     new BufferedReader(new FileReader(chemin))) {

            String ligne;
            int numeroLigne = 0;

            // Ignorer la première ligne contenant les titres des colonnes
            lecteur.readLine();
            numeroLigne++;

            while ((ligne = lecteur.readLine()) != null) {
                numeroLigne++;

                try {
                    Document document = creerDocument(ligne);
                    bibliotheque.ajouterDocument(document);

                } catch (DonneeInvalideException e) {
                    System.out.println(
                            "Ligne " + numeroLigne
                                    + " ignorée : "
                                    + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Erreur de lecture du fichier : "
                            + e.getMessage()
            );
        }
    }

    private Document creerDocument(String ligne)
            throws DonneeInvalideException {

        String[] donnees = ligne.split(",", -1);

        if (donnees.length != 5) {
            throw new DonneeInvalideException(
                    "Le nombre de colonnes est incorrect."
            );
        }

        String type = donnees[0].trim();
        String id = donnees[1].trim();
        String titre = donnees[2].trim();
        String detail = donnees[4].trim();

        if (type.isEmpty()
                || id.isEmpty()
                || titre.isEmpty()
                || detail.isEmpty()) {

            throw new DonneeInvalideException(
                    "Une donnée est manquante."
            );
        }

        int annee;

        try {
            annee = Integer.parseInt(donnees[3].trim());
        } catch (NumberFormatException e) {
            throw new DonneeInvalideException(
                    "L'année est invalide."
            );
        }

        try {
            switch (type.toUpperCase()) {

                case "LIVRE":
                    return new Livre(
                            id,
                            titre,
                            annee,
                            detail
                    );

                case "MAGAZINE":
                    return new Magazine(
                            id,
                            titre,
                            annee,
                            Integer.parseInt(detail)
                    );

                case "AUDIO":
                    return new LivreAudio(
                            id,
                            titre,
                            annee,
                            Integer.parseInt(detail)
                    );

                default:
                    throw new DonneeInvalideException(
                            "Type de document inconnu : " + type
                    );
            }

        } catch (NumberFormatException e) {
            throw new DonneeInvalideException(
                    "Le numéro ou la durée est invalide."
            );
        }
    }
}
