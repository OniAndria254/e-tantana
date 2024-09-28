public class Liaison {
    private int idLiaison;
    private double taux;
    private int idExercice;
    private int idCentre;
    private double coutFixe;
    private double coutVariable;
    private int idRubrique;

    public Liaison() {}

    public Liaison(int idLiaison, double taux, int idExercice, int idCentre,double coutFixe, double coutVariable, int idRubrique) {
        this.idLiaison = idLiaison;
        this.taux = taux;
        this.idExercice = idExercice;
        this.idCentre = idCentre;
        this.coutFixe = coutFixe;
        this.coutVariable = coutVariable;
        this.idRubrique = idRubrique;
    }

    public int getIdLiaison() {
        return idLiaison;
    }

    public void setIdLiaison(int idLiaison) {
        this.idLiaison = idLiaison;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public double getCoutFixe() {
        return coutFixe;
    }

    public void setCoutFixe(double coutFixe) {
        this.coutFixe = coutFixe;
    }

    public double getCoutVariable() {
        return coutVariable;
    }

    public void setCoutVariable(double coutVariable) {
        this.coutVariable = coutVariable;
    }

    public int getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }
}
