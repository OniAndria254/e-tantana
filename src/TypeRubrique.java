public class TypeRubrique {
    private int idTypeRubrique;
    private String nom;

    public TypeRubrique() {}

    public TypeRubrique(int idTypeRubrique, String nom) {
        this.idTypeRubrique = idTypeRubrique;
        this.nom = nom;
    }

    public int getIdTypeRubrique() {
        return idTypeRubrique;
    }

    public void setIdTypeRubrique(int idTypeRubrique) {
        this.idTypeRubrique = idTypeRubrique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
