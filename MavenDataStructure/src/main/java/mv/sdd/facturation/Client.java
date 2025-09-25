package mv.sdd.facturation;

public class Client implements Comparable<Client>{
    private int numCompte;
    private String nom;
    private String prenom;
    private double solde;

    public Client() {
    }

    public Client(int numCompte, String nom, String prenom, double solde) {
        this.solde = solde;
        this.prenom = prenom;
        this.nom = nom;
        this.numCompte = numCompte;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return  "{" + numCompte +
                ", " + nom + '\'' +
                ", " + prenom + '\'' +
                ", " + solde +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return Integer.compare(this.numCompte, o.numCompte);
    }
}
