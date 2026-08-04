public class Main {

    public static void main(String[] args) {

        Bibliotheque bibliotheque = new Bibliotheque();
        LecteurCSV lecteurCSV = new LecteurCSV();

        // Chargement des documents depuis le fichier CSV
        lecteurCSV.chargerDocuments(
                "Assia/data/documents.csv",
                bibliotheque
        );

        // Affichage de tous les documents
        System.out.println("\nDocuments de la bibliothèque :");
        bibliotheque.afficherDocuments();

        // Affichage du nombre total de documents valides
        System.out.println(
                "\nNombre total de documents valides : "
                        + bibliotheque.getNombreDocuments()
        );

        // Recherche d’un document par son identifiant
        Document document = bibliotheque.rechercherParId("L001");

        if (document != null) {

            try {
                // Premier emprunt
                document.emprunter();

                System.out.println(
                        "\nDocument emprunté : "
                                + document.getTitre()
                );

                // Deuxième tentative volontaire :
                // le document est déjà emprunté
                document.emprunter();

            } catch (DocumentIndisponibleException e) {

                System.out.println(
                        "Erreur détectée : "
                                + e.getMessage()
                );

                // Retour du document après le test
                document.retourner();

                System.out.println(
                        "Document retourné : "
                                + document.getTitre()
                );
            }

        } else {
            System.out.println(
                    "Le document recherché n’existe pas."
            );
        }

        // Calcul et affichage des statistiques
        StatistiquesBibliotheque statistiques =
                new StatistiquesBibliotheque(bibliotheque);

        statistiques.afficherNombreParCategorie();
        statistiques.afficherDocumentPlusEmprunte();
        statistiques.afficherDocumentsJamaisEmpruntes();

        // Génération du rapport TXT
        GenerateurRapport generateurRapport =
                new GenerateurRapport();

        generateurRapport.genererRapport(
                bibliotheque,
                "Assia/data/rapport_bibliotheque.txt"
        );
    }
}