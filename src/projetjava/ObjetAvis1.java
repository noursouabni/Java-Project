package projetjava;

import java.util.ArrayList;
import java.util.List;
import projetjava.categorie;

public abstract class ObjetAvis1 {
    private categorie categorie;
    private String nom;
    private List<Avis> avisList = new ArrayList<>();

    // Constructor
    public ObjetAvis1(categorie categorie, String nom) {
        this.categorie = categorie;
        this.nom = nom;
    }

    // Méthode pour permettre aux utilisateurs de publier des avis
    public void publierAvis(Utilisateur utilisateur, int note, String commentaire) {
        Avis nouvelAvis = new Avis(utilisateur, this, note, commentaire);
        avisList.add(nouvelAvis);
        System.out.println("Avis publié avec succès!");
    }

    // Getter pour récupérer la liste des avis associés à cet objet
    public List<Avis> getAvisList() {
        return avisList;
    }

    // Getter for the category
    public categorie getCategorie() {
        return categorie;
    }

    // Getter for the name
    public String getNom() {
        return nom;
    }
}
