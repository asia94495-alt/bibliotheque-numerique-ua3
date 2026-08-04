public class Livre extends Document {

    private String auteur;

    public Livre(String id, String titre, int anneePublication, String auteur) {
        super(id, titre, anneePublication);
        this.auteur = auteur;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String getType() {
        return "Livre";
    }

    @Override
    public String toString() {
        return super.toString() + ", auteur : " + auteur;
    }
}