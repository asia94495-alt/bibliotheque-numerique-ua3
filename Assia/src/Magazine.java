public class Magazine extends Document {

    private int numero;

    public Magazine(String id, String titre, int anneePublication, int numero) {
        super(id, titre, anneePublication);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public String toString() {
        return super.toString() + ", numéro : " + numero;
    }
}