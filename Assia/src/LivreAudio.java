public class LivreAudio extends Document {

    private int dureeMinutes;

    public LivreAudio(String id, String titre, int anneePublication, int dureeMinutes) {
        super(id, titre, anneePublication);
        this.dureeMinutes = dureeMinutes;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    @Override
    public String getType() {
        return "Livre audio";
    }

    @Override
    public String toString() {
        return super.toString() + ", durée : " + dureeMinutes + " minutes";
    }
}
