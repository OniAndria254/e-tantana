public class GestionGenerale {
    private double chiffreAffaires;
    private double coutsTotaux;

    public GestionGenerale(double chiffreAffaires, double coutsTotaux) {
        this.chiffreAffaires = chiffreAffaires;
        this.coutsTotaux = coutsTotaux;
    }

    public double calculerResultatGestionGenerale() {
        return chiffreAffaires - coutsTotaux;
    }

    public double calculerMargeBrute() {
        return chiffreAffaires - coutsTotaux;
    }
}
