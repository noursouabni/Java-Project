package projetjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import projetjava.categorie;

public class Administrateur extends Utilisateur {
    private List<ObjetAvis1> objetsList = new ArrayList<>();
    private List<Avis> avisList = new ArrayList<>();
    private Set<Utilisateur> utilisateurs = new HashSet<>();
    
    

    // Constructor and other methods

    public List<Avis> getAllReviewsByCategory(categorie category) {
        List<Avis> reviewsByCategory = new ArrayList<>();

        for (Avis review : avisList) {
            if (review.getObjetAvis().getCategorie() == category) {
                reviewsByCategory.add(review);
            }
        }

        return reviewsByCategory;
    }




    // Constructeur pour un administrateur
    public Administrateur(String nom) {
        super(nom);
    }

    // Méthode pour ajouter un objet au site
    public void ajouterObjet(ObjetAvis1 objet) {
        objetsList.add(objet);
    }

    // Méthode pour ajouter un utilisateur au site
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    // Méthode pour consulter tous les avis par catégorie d'objets
    public void consulterAvisParCategorie(categorie category) {
        System.out.println("Reviews for category " + category + ":");
        boolean foundReviews = false;

        for (ObjetAvis1 object : objetsList) {
            if (object.getCategorie() == category) {
                System.out.println("Avis for " + object.getNom() + ":");
                for (Avis avis : object.getAvisList()) {
                    System.out.println(
                        object.getCategorie() + " " +
                        avis.getNote() + " stars: " +
                        avis.getCommentaire() + " by " +
                        avis.getUtilisateur().getNom()
                    );
                }
                foundReviews = true;
            }
        }

        if (!foundReviews) {
            System.out.println("No reviews found for the selected category.");
        }
    }

 
   
      
    	  private boolean containsViolentOrIndecentLanguage(String commentaire) {
    	        // List of inappropriate words 
    	        List<String> inappropriateWords = Arrays.asList("violent", "indecent", "moche");

    	        // Convert the comment to lowercase for case-insensitive matching
    	        String lowercaseCommentaire = commentaire.toLowerCase();

    	        // Check if the comment contains any inappropriate words
    	        for (String word : inappropriateWords) {
    	            if (lowercaseCommentaire.contains(word)) {
    	                return true; // Found an inappropriate word
    	            }
    	        }

    	        return false; // No inappropriate words found
    	    }

    	    

    	  public void modererAvis(String nomObjet, Utilisateur utilisateur) {
    		    boolean reviewFound = false;

    		    for (ObjetAvis1 object : objetsList) {
    		        if (object.getNom().equalsIgnoreCase(nomObjet)) {
    		            List<Avis> avisList = object.getAvisList();
    		            Iterator<Avis> iterator = avisList.iterator();

    		            while (iterator.hasNext()) {
    		                Avis avis = iterator.next();

    		                // Use equals method to compare Utilisateur objects
    		              //  if (avis.getUtilisateur().equals(utilisateur)) {
    		                    if (containsViolentOrIndecentLanguage(avis.getCommentaire())) {
    		                        // Remove the review using the iterator
    		                        iterator.remove();
    		                        System.out.println("Avis supprimer due a un langage violent ou indecent.");
    		                    } else {
    		                        System.out.println("cet avis n'est pas offensif.");
    		                    }

    		                    reviewFound = true;
    		                    break; // No need to continue searching once the review is found
    		                }
    		            }
    		        }
    		    

    		    if (!reviewFound) {
    		        System.out.println("avis introuvable pour l'objet: " + nomObjet + " by visiteur: " + utilisateur.getNom());
    		    }
    		}







    // Méthode pour afficher des statistiques 
    public void afficherStatistiques() {
        System.out.println("Statistiques:");
        System.out.println("Nombre total d'avis: " + getNombreTotalAvis());
        System.out.println("Nombre total d'avis par categorie:");
        System.out.println("  - Produit: " + getNombreAvisParCategorie(categorie.PRODUIT));
        System.out.println("  - Site de Loisir: " + getNombreAvisParCategorie(categorie.SITE_DE_LOISIR));
        System.out.println("Nombre de visiteurs different: " + getNombreVisiteursDifférents());
    }

    //  private helper methods to calculate statistics
    private int getNombreTotalAvis() {
        int totalAvis = 0;

        for (ObjetAvis1 object : objetsList) {
            totalAvis += object.getAvisList().size();
        }

        return totalAvis;
    }

    private int getNombreAvisParCategorie(categorie categorie) {
        int nombreAvis = 0;

        for (ObjetAvis1 object : objetsList) {
            if (object.getCategorie() == categorie) {
                nombreAvis += object.getAvisList().size();
            }
        }

        return nombreAvis;
    }

    private int getNombreVisiteursDifférents() {
        List<String> visiteurs = new ArrayList<>();

        for (ObjetAvis1 object : objetsList) {
            for (Avis avis : object.getAvisList()) {
                String nomUtilisateur = avis.getUtilisateur().getNom();
                if (!visiteurs.contains(nomUtilisateur)) {
                    visiteurs.add(nomUtilisateur);
                }
            }
        }

        return visiteurs.size();
    }

    public void rechercherEtLireAvis(String nomObjet) {
        boolean foundObject = false;

        for (ObjetAvis1 object : objetsList) {
            if (object.getNom().equalsIgnoreCase(nomObjet)) {
                System.out.println("Reviews for " + object.getNom() + ":");
                for (Avis avis : object.getAvisList()) {
                    System.out.println(avis.getUtilisateur().getNom() + ": " + avis.getCommentaire());
                }
                foundObject = true;
                break; // No need to continue searching once the object is found
            }
        }

        if (!foundObject) {
            System.out.println("No reviews found for the object: " + nomObjet);
        }
    }

    private int compterAvisParCategorie(categorie categorie) {
        int nombreAvis = 0;
        for (Avis avis : avisList) {
            if (avis.getObjetAvis().getCategorie() == categorie) {
                nombreAvis++;
            }
        }
        return nombreAvis;
    }



    
}
