public class Rubrique {
    private int idRubrique;
    private String nom;
    private String uniteOeuvre;
    private double prixUnitaire;
    private int idNatureRubrique;
    private int idTypeRubrique;
    private double quantite;

    public Rubrique() {}

    public Rubrique(int idRubrique, String nom, String uniteOeuvre, double prixUnitaire,int idNatureRubrique, int idTypeRubrique, double quantite) {
        this.idRubrique = idRubrique;
        this.nom = nom;
        this.uniteOeuvre = uniteOeuvre;
        this.prixUnitaire = prixUnitaire;
        this.idNatureRubrique = idNatureRubrique;
        this.idTypeRubrique = idTypeRubrique;
        this.quantite = quantite;
    }

    public int getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUniteOeuvre() {
        return uniteOeuvre;
    }

    public void setUniteOeuvre(String uniteOeuvre) {
        this.uniteOeuvre = uniteOeuvre;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getIdNatureRubrique() {
        return idNatureRubrique;
    }

    public void setIdNatureRubrique(int idNatureRubrique) {
        this.idNatureRubrique = idNatureRubrique;
    }

    public int getIdTypeRubrique() {
        return idTypeRubrique;
    }

    public void setIdTypeRubrique(int idTypeRubrique) {
        this.idTypeRubrique = idTypeRubrique;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}
