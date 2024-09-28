public class TypeCentre {
    private int idTypeCentre;
    private String nom;

  
    public TypeCentre() {}

    public TypeCentre(int idTypeCentre, String nom) {
        this.idTypeCentre = idTypeCentre;
        this.nom = nom;
    }

   
    public int getIdTypeCentre() {
        return idTypeCentre;
    }

    public void setIdTypeCentre(int idTypeCentre) {
        this.idTypeCentre = idTypeCentre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
