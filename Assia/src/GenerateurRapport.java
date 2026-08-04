import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GenerateurRapport {

    public void genererRapport(
            Bibliotheque bibliotheque,
            String chemin
    ) {

        int nombreLivres = 0;
        int nombreMagazines = 0;
        int nombreLivresAudio = 0;
        int totalEmprunts = 0;

        Document plusEmprunte = null;

        for (Document document : bibliotheque.getDocuments()) {

            if (document instanceof Livre) {
                nombreLivres++;
            } else if (document instanceof Magazine) {
                nombreMagazines++;
            } else if (document instanceof LivreAudio) {
                nombreLivresAudio++;
            }

            totalEmprunts += document.getNombreEmprunts();

            if (plusEmprunte == null
                    || document.getNombreEmprunts()
                    > plusEmprunte.getNombreEmprunts()) {

                plusEmprunte = document;
            }
        }

        try (PrintWriter rapport =
                     new PrintWriter(new FileWriter(chemin))) {

            rapport.println("RAPPORT DE LA BIBLIOTHÈQUE");
            rapport.println("==========================");
            rapport.println(
                    "Nombre total de documents : "
                            + bibliotheque.getNombreDocuments()
            );

            rapport.println("Livres : " + nombreLivres);
            rapport.println("Magazines : " + nombreMagazines);
            rapport.println("Livres audio : " + nombreLivresAudio);
            rapport.println("Nombre total d'emprunts : " + totalEmprunts);

            if (plusEmprunte != null
                    && plusEmprunte.getNombreEmprunts() > 0) {

                rapport.println(
                        "Document le plus emprunté : "
                                + plusEmprunte.getTitre()
                                + " avec "
                                + plusEmprunte.getNombreEmprunts()
                                + " emprunt(s)"
                );
            } else {
                rapport.println(
                        "Aucun document n'a encore été emprunté."
                );
            }

            rapport.println();
            rapport.println("Documents jamais empruntés :");

            for (Document document : bibliotheque.getDocuments()) {
                if (document.getNombreEmprunts() == 0) {
                    rapport.println("- " + document.getTitre());
                }
            }

            System.out.println(
                    "\nRapport généré avec succès : " + chemin
            );

        } catch (IOException e) {
            System.out.println(
                    "Erreur pendant la création du rapport : "
                            + e.getMessage()
            );
        }
    }
}