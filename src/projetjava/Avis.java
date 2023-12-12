package projetjava;

public class Avis {
    private Utilisateur utilisateur;
    private ObjetAvis1 objetAvis;
    private int note;
    private String commentaire;

    // Constructor
    public Avis(Utilisateur utilisateur, ObjetAvis1 objetAvis, int note, String commentaire) {
        this.utilisateur = utilisateur;
        this.objetAvis = objetAvis;
        this.note = note;
        this.commentaire = commentaire;
    }
    

    // Getters and Setters
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public ObjetAvis1 getObjetAvis() {
        return objetAvis;
    }

    public void setObjetAvis(ObjetAvis1 objetAvis) {
        this.objetAvis = objetAvis;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}

