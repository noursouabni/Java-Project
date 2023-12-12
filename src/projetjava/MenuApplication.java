package projetjava;

import java.util.Scanner;
import projetjava.categorie;

public class MenuApplication {
    private static categorie categorie;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Administrateur administrateur = new Administrateur("NomAdmin");

        char userType;

        do {
            System.out.println("Êtes-vous un visiteur ou un administrateur ? Entrez 'V' pour visiteur, 'A' pour administrateur :");
            userType = scanner.next().charAt(0);

            if (userType == 'V' || userType == 'v') {
            	System.out.print("Entrez votre nom : ");
            	String nomVisiteur = scanner.next();
            	Utilisateur visiteur = new Utilisateur(nomVisiteur);
                administrateur.ajouterUtilisateur(visiteur);

                int choixVisiteur;
                do {
                    afficherMenuVisiteur();
                    choixVisiteur = scanner.nextInt();

                    switch (choixVisiteur) {
                        case 1:
                            publierAvis(visiteur, administrateur, scanner);
                            break;
                        case 2:
                            consulterAvisParCategorie(administrateur, scanner);
                            break;
                        case 3:
                            rechercherEtLireAvis(administrateur, scanner);
                            break;
                        case 4:
                            System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
                            break;
                        default:
                            System.out.println("Choix invalide. Veuillez réessayer.");
                    }
                } while (choixVisiteur != 4);

            } else if (userType == 'A' || userType == 'a') {
                int choixAdmin;
                do {
                    afficherMenuAdministrateur();
                    choixAdmin = scanner.nextInt();

                    switch (choixAdmin) {
                        case 1:
                            consulterAvisParCategorie(administrateur, scanner);
                            break;
                        case 2:
                            modererAvis(administrateur, scanner);
                            break;
                        case 3:
                            afficherStatistiques(administrateur);
                            break;
                        case 4:
                            System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
                            break;
                        default:
                            System.out.println("Choix invalide. Veuillez réessayer.");
                    }
                } while (choixAdmin != 4);

            } else {
                System.out.println("Type d'utilisateur invalide. Sortie de l'application.");
            }
        } while (userType != 'A' && userType != 'a');

        scanner.close();
    }

    private static void afficherMenuVisiteur() {
        System.out.println("Menu Visiteur :");
        System.out.println("1. Publier un avis");
        System.out.println("2. Consulter les avis par catégorie");
        System.out.println("3. Rechercher un objet et voir les avis");
        System.out.println("4. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    private static void afficherMenuAdministrateur() {
        System.out.println("Menu Administrateur :");
        System.out.println("1. Consulter les avis par catégorie");
        System.out.println("2. Modérer un avis");
        System.out.println("3. Afficher les statistiques");
        System.out.println("4. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    private static void publierAvis(Utilisateur utilisateur, Administrateur administrateur, Scanner scanner) {
        System.out.println("Vous souhaitez publier un avis.");

        System.out.println("Choisissez la catégorie de l'objet à évaluer :");
        System.out.println("1. PRODUIT");
        System.out.println("2. SITE DE LOISIR");
        System.out.print("Votre choix : ");
        int choixCategorie = scanner.nextInt();

        switch (choixCategorie) {
            case 1:
                categorie = categorie.PRODUIT;
                break;
            case 2:
                categorie = categorie.SITE_DE_LOISIR;
                break;
            default:
                System.out.println("Choix de catégorie non valide. Abandon de la publication d'avis.");
                return;
        }

        System.out.print("Entrez le nom de l'objet : ");
        String nomObjet = scanner.next();

        ObjetAvis1 objetAvis;

        if (categorie == categorie.PRODUIT) {
            System.out.print("Entrez la marque du produit : ");
            String marque = scanner.next();
            objetAvis = new produit(categorie, nomObjet, marque);
        } else {
            System.out.print("Entrez le type du site de loisir : ");
            String type = scanner.next();
            System.out.print("Entrez le pays du site de loisir : ");
            String pays = scanner.next();
            objetAvis = new SiteLoisir(categorie, nomObjet, type, pays);
        }

        System.out.print("Donnez votre évaluation en nombre d'étoiles (entre 0 et 5) : ");
        int note = scanner.nextInt();

        System.out.print("Entrez votre commentaire : ");
        String commentaire = scanner.next();

        utilisateur.publierAvis(objetAvis, note, commentaire);
        administrateur.ajouterObjet(objetAvis);

        System.out.println("Avis publié avec succès!");
    }

    private static void consulterAvisParCategorie(Administrateur administrateur, Scanner scanner) {
        System.out.println("Choisissez la catégorie pour consulter les avis :");
        System.out.println("1. PRODUIT");
        System.out.println("2. SITE DE LOISIR");
        System.out.print("Votre choix : ");
        int choixCategorie = scanner.nextInt();

        categorie category;

        switch (choixCategorie) {
            case 1:
                category = projetjava.categorie.PRODUIT;
                break;
            case 2:
                category = projetjava.categorie.SITE_DE_LOISIR;
                break;
            default:
                System.out.println("Choix de catégorie invalide.");
                return;
        }

        administrateur.consulterAvisParCategorie(category);
    }

    private static void rechercherEtLireAvis(Administrateur administrateur, Scanner scanner) {
        System.out.print("Entrez le nom de l'objet à rechercher : ");
        String nomObjetRecherche = scanner.next();
        administrateur.rechercherEtLireAvis(nomObjetRecherche);
    }

    private static void modererAvis(Administrateur administrateur, Scanner scanner) {
        System.out.print("Entrez le nom de l'objet pour la modération de l'avis : ");
        String nomObjet = scanner.next();

        System.out.print("Entrez le nom de l'utilisateur qui a écrit l'avis : ");
        String nomUtilisateur = scanner.next();

        Utilisateur utilisateur = new Utilisateur(nomUtilisateur);
        administrateur.modererAvis(nomObjet, utilisateur);
    }

    private static void afficherStatistiques(Administrateur administrateur) {
        administrateur.afficherStatistiques();
    }
}
