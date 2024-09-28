import java.util.Date;

public class Exercice {
    private int idExercice;
    private Date dateDebut;
    private Date dateFin;

    public Exercice() {}

    public Exercice(int idExercice, Date dateDebut, Date dateFin) {
        this.idExercice = idExercice;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
