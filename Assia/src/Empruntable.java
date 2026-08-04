public interface Empruntable {

    void emprunter() throws DocumentIndisponibleException;

    void retourner();
}
