import java.util.ArrayList;

public class Bibliotheque {

    private ArrayList<Document> documents;

    public Bibliotheque() {
        documents = new ArrayList<>();
    }

    public void ajouterDocument(Document document) {
        documents.add(document);
    }

    public Document rechercherParId(String id) {
        for (Document document : documents) {
            if (document.getId().equalsIgnoreCase(id)) {
                return document;
            }
        }

        return null;
    }

    public void afficherDocuments() {
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public int getNombreDocuments() {
        return documents.size();
    }

    public ArrayList<Document> getDocuments() {
        return new ArrayList<>(documents);
    }
}