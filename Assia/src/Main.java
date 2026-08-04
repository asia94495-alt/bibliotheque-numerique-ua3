import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Document> documents = new ArrayList<>();

        documents.add(new Livre(
                "L001",
                "Le Petit Prince",
                1943,
                "Antoine de Saint-Exupéry"
        ));

        documents.add(new Magazine(
                "M001",
                "Science et Vie",
                2026,
                1280
        ));

        documents.add(new LivreAudio(
                "A001",
                "L'Étranger",
                1942,
                180
        ));

        System.out.println("Documents de la bibliothèque :");

        for (Document document : documents) {
            System.out.println(document);
        }

        try {
            Document premierDocument = documents.get(0);

            premierDocument.emprunter();
            System.out.println("\nDocument emprunté : "
                    + premierDocument.getTitre());

            premierDocument.retourner();
            System.out.println("Document retourné : "
                    + premierDocument.getTitre());

        } catch (DocumentIndisponibleException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}