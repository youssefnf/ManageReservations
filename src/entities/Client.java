package entities;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private static int cmp = 0;

    public Client(String nom, String prenom, String tel, String email) {
        this.id = ++cmp;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }

    public Client(int id, String nom, String prenom, String tel, String email) {
        this.id = +id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
