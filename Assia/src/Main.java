public class Main {

    public static void main(String[] args) {

        Bibliotheque bibliotheque = new Bibliotheque();
        LecteurCSV lecteurCSV = new LecteurCSV();

        lecteurCSV.chargerDocuments(
                "Assia/data/documents.csv",
                bibliotheque
        );

        System.out.println("\nDocuments de la bibliothèque :");
        bibliotheque.afficherDocuments();

        System.out.println(
                "\nNombre total de documents valides : "
                        + bibliotheque.getNombreDocuments()
        );

        Document document = bibliotheque.rechercherParId("L001");

        if (document != null) {
            try {
                document.emprunter();

                System.out.println(
                        "\nDocument emprunté : "
                                + document.getTitre()
                );

                document.retourner();

                System.out.println(
                        "Document retourné : "
                                + document.getTitre()
                );

            } catch (DocumentIndisponibleException e) {
                System.out.println(
                        "Erreur : " + e.getMessage()
                );
            }
        }

        StatistiquesBibliotheque statistiques =
                new StatistiquesBibliotheque(bibliotheque);

        statistiques.afficherNombreParCategorie();
        statistiques.afficherDocumentPlusEmprunte();
        statistiques.afficherDocumentsJamaisEmpruntes();

        GenerateurRapport generateurRapport =
                new GenerateurRapport();

        generateurRapport.genererRapport(
                bibliotheque,
                "Assia/data/rapport_bibliotheque.txt"
        );
    }
}