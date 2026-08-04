public class StatistiquesBibliotheque {

    private Bibliotheque bibliotheque;

    public StatistiquesBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public void afficherNombreParCategorie() {

        int nombreLivres = 0;
        int nombreMagazines = 0;
        int nombreLivresAudio = 0;

        for (Document document : bibliotheque.getDocuments()) {

            if (document instanceof Livre) {
                nombreLivres++;
            } else if (document instanceof Magazine) {
                nombreMagazines++;
            } else if (document instanceof LivreAudio) {
                nombreLivresAudio++;
            }
        }

        System.out.println("\nStatistiques par catégorie :");
        System.out.println("Livres : " + nombreLivres);
        System.out.println("Magazines : " + nombreMagazines);
        System.out.println("Livres audio : " + nombreLivresAudio);
    }

    public void afficherDocumentsJamaisEmpruntes() {

        System.out.println("\nDocuments jamais empruntés :");

        for (Document document : bibliotheque.getDocuments()) {
            if (document.getNombreEmprunts() == 0) {
                System.out.println("- " + document.getTitre());
            }
        }
    }

    public void afficherDocumentPlusEmprunte() {

        Document plusEmprunte = null;

        for (Document document : bibliotheque.getDocuments()) {
            if (plusEmprunte == null
                    || document.getNombreEmprunts()
                    > plusEmprunte.getNombreEmprunts()) {

                plusEmprunte = document;
            }
        }

        if (plusEmprunte != null
                && plusEmprunte.getNombreEmprunts() > 0) {

            System.out.println(
                    "\nDocument le plus emprunté : "
                            + plusEmprunte.getTitre()
                            + " avec "
                            + plusEmprunte.getNombreEmprunts()
                            + " emprunt(s)"
            );

        } else {
            System.out.println(
                    "\nAucun document n’a encore été emprunté."
            );
        }
    }
}
