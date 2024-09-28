public class Centre {
    private int idCentre;
    private String nom;
    private int idTypeCentre;

    public Centre() {}

    public Centre(int idCentre, String nom, int idTypeCentre) {
        this.idCentre = idCentre;
        this.nom = nom;
        this.idTypeCentre = idTypeCentre;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdTypeCentre() {
        return idTypeCentre;
    }

    public void setIdTypeCentre(int idTypeCentre) {
        this.idTypeCentre = idTypeCentre;
    }
}
