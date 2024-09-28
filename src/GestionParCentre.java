import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionParCentre {
    private Map<String, Double> centresChargesFixes;
    private Map<String, Double> centresChargesVariables;
    private Map<String, Double> chiffresAffairesParCentre;

    public GestionParCentre() {
        this.centresChargesFixes = new HashMap<>();
        this.centresChargesVariables = new HashMap<>();
        this.chiffresAffairesParCentre = new HashMap<>();
    }

    public void ajouterDonneesCentre(String centre, double chargeFixe, double chargeVariable, double chiffreAffaire) {
        centresChargesFixes.put(centre, chargeFixe);
        centresChargesVariables.put(centre, chargeVariable);
        chiffresAffairesParCentre.put(centre, chiffreAffaire);
    }

    public List<Map<String, Object>> calculerResultatParCentre() {
        List<Map<String, Object>> resultats = new ArrayList<>();

        for (String centre : centresChargesFixes.keySet()) {
            double chargesFixes = centresChargesFixes.getOrDefault(centre, 0.0);
            double chargesVariables = centresChargesVariables.getOrDefault(centre, 0.0);
            double chiffreAffaire = chiffresAffairesParCentre.getOrDefault(centre, 0.0);

            double coutTotal = chargesFixes + chargesVariables;
            double resultatCentre = chiffreAffaire - coutTotal;

            Map<String, Object> resultat = new HashMap<>();
            resultat.put("centre", centre);
            resultat.put("chiffreAffaire", chiffreAffaire);
            resultat.put("chargesFixes", chargesFixes);
            resultat.put("chargesVariables", chargesVariables);
            resultat.put("coutTotal", coutTotal);
            resultat.put("resultatCentre", resultatCentre);

            resultats.add(resultat);
        }

        return resultats;
    }
}
