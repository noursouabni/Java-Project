package projetjava;

public class Utilisateur {
    private String nom;

    // Constructeur
    public Utilisateur(String nom) {
        this.nom = nom;
    }

    // Méthode pour publier un avis
    public void publierAvis(ObjetAvis1 objetAvis, int note, String commentaire) {
        Avis nouvelAvis = new Avis(this, objetAvis, note, commentaire);
        objetAvis.getAvisList().add(nouvelAvis);
        System.out.println("Avis publié avec succès!");
    }

    // Méthode pour modérer un avis
    public void modererAvis(Avis avis) {
        if (contenuIndécent(avis.getCommentaire())) {
            avis.getObjetAvis().getAvisList().remove(avis);
            System.out.println("Avis modéré avec succès!");
        } else {
            System.out.println("Avis conforme aux règles.");
        }
    }

    private boolean contenuIndécent(String commentaire) {
        return commentaire.toLowerCase().contains("insulte");
    }

    // Getter pour le nom de l'utilisateur
    public String getNom() {
        return nom;
    }
}
