public class GestionAnalytique {
    private double chargesIncorporables;
    private double chargesNonIncorporables;
    private double chargesSuppletives;
    private double chiffreAffaires;
    private double coutVariable;
    private double coutFixe;

    public GestionAnalytique(double chargesIncorporables, double chargesNonIncorporables,double chargesSuppletives, double chiffreAffaires,double coutVariable, double coutFixe) {
        this.chargesIncorporables = chargesIncorporables;
        this.chargesNonIncorporables = chargesNonIncorporables;
        this.chargesSuppletives = chargesSuppletives;
        this.chiffreAffaires = chiffreAffaires;
        this.coutVariable = coutVariable;
        this.coutFixe = coutFixe;
    }

    public double calculerChargesAnalytiques() {
        return chargesIncorporables - chargesNonIncorporables + chargesSuppletives;
    }

    public double calculerResultatGestionAnalytique() {
        double chargesAnalytiques = calculerChargesAnalytiques();
        double resultatGestionAnalytique = chiffreAffaires - chargesAnalytiques;
        return resultatGestionAnalytique;
    }

    public double calculerSeuilRentabilite() {
        double mcv = chiffreAffaires - coutVariable;
        return coutFixe / mcv;
    }
}
