public class Main {

    public static void main(String[] args) {

        Bibliotheque bibliotheque = new Bibliotheque();

        bibliotheque.ajouterDocument(
                new Livre(
                        "L001",
                        "Le Petit Prince",
                        1943,
                        "Antoine de Saint-Exupéry"
                )
        );

        bibliotheque.ajouterDocument(
                new Magazine(
                        "M001",
                        "Science et Vie",
                        2026,
                        1280
                )
        );

        bibliotheque.ajouterDocument(
                new LivreAudio(
                        "A001",
                        "L'Étranger",
                        1942,
                        180
                )
        );

        System.out.println("Documents de la bibliothèque :");
        bibliotheque.afficherDocuments();

        System.out.println(
                "\nNombre total de documents : "
                        + bibliotheque.getNombreDocuments()
        );

        Document document = bibliotheque.rechercherParId("L001");

        if (document != null) {
            try {
                document.emprunter();
                System.out.println(
                        "Document emprunté : " + document.getTitre()
                );

                document.retourner();
                System.out.println(
                        "Document retourné : " + document.getTitre()
                );

            } catch (DocumentIndisponibleException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}