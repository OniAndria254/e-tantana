public class NatureRubrique {
    private int idNatureRubrique;
    private String nom;

    public NatureRubrique() {}

    public NatureRubrique(int idNatureRubrique, String nom) {
        this.idNatureRubrique = idNatureRubrique;
        this.nom = nom;
    }

    public int getIdNatureRubrique() {
        return idNatureRubrique;
    }

    public void setIdNatureRubrique(int idNatureRubrique) {
        this.idNatureRubrique = idNatureRubrique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
