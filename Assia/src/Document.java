public abstract class Document implements Empruntable {

    private String id;
    private String titre;
    private int anneePublication;
    private boolean disponible;
    private int nombreEmprunts;

    public Document(String id, String titre, int anneePublication) {
        this.id = id;
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.disponible = true;
        this.nombreEmprunts = 0;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getNombreEmprunts() {
        return nombreEmprunts;
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (!disponible) {
            throw new DocumentIndisponibleException(
                    "Le document " + titre + " est indisponible."
            );
        }

        disponible = false;
        nombreEmprunts++;
    }

    @Override
    public void retourner() {
        disponible = true;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "ID : " + id
                + ", titre : " + titre
                + ", année : " + anneePublication
                + ", type : " + getType()
                + ", disponible : " + disponible;
    }
}
