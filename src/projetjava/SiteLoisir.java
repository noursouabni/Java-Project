package projetjava;

public class SiteLoisir extends ObjetAvis1 {
    private String type;
    private String pays;

    public SiteLoisir(categorie categorie, String nom, String type, String pays) {
        super(categorie, nom); 
        this.type = type;
        this.pays = pays;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for pays
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
