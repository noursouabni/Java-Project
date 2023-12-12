package projetjava;
import projetjava.categorie;

public class produit extends ObjetAvis1 {
	private String marque;
	public produit(categorie categorie, String nom, String marque) {
		// TODO Auto-generated constructor stub
		super(categorie,nom);
		this.marque=marque;
	}
	public String getmarque() {
		return marque;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
