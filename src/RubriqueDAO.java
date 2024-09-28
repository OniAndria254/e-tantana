import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RubriqueDAO {
    private Connection connection;

    public RubriqueDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterRubrique(Rubrique rubrique) {
        String sql = "INSERT INTO rubrique (nom, unite_oeuvre, prix_unitaire, id_nature_rubrique, id_type_rubrique, quantite) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, rubrique.getNom());
            statement.setString(2, rubrique.getUniteOeuvre());
            statement.setDouble(3, rubrique.getPrixUnitaire());
            statement.setInt(4, rubrique.getIdNatureRubrique());
            statement.setInt(5, rubrique.getIdTypeRubrique());
            statement.setDouble(6, rubrique.getQuantite());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourRubrique(Rubrique rubrique) {
        String sql = "UPDATE rubrique SET nom = ?, unite_oeuvre = ?, prix_unitaire = ?, id_nature_rubrique = ?, id_type_rubrique = ?, quantite = ? WHERE id_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, rubrique.getNom());
            statement.setString(2, rubrique.getUniteOeuvre());
            statement.setDouble(3, rubrique.getPrixUnitaire());
            statement.setInt(4, rubrique.getIdNatureRubrique());
            statement.setInt(5, rubrique.getIdTypeRubrique());
            statement.setDouble(6, rubrique.getQuantite());
            statement.setInt(7, rubrique.getIdRubrique());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerRubrique(int idRubrique) {
        String sql = "DELETE FROM rubrique WHERE id_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idRubrique);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Rubrique obtenirRubriqueParId(int idRubrique) {
        String sql = "SELECT * FROM rubrique WHERE id_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idRubrique);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Rubrique rubrique = new Rubrique();
                    rubrique.setIdRubrique(resultSet.getInt("id_rubrique"));
                    rubrique.setNom(resultSet.getString("nom"));
                    rubrique.setUniteOeuvre(resultSet.getString("unite_oeuvre"));
                    rubrique.setPrixUnitaire(resultSet.getDouble("prix_unitaire"));
                    rubrique.setIdNatureRubrique(resultSet.getInt("id_nature_rubrique"));
                    rubrique.setIdTypeRubrique(resultSet.getInt("id_type_rubrique"));
                    rubrique.setQuantite(resultSet.getDouble("quantite"));

                    return rubrique;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Rubrique> obtenirToutesLesRubriques() {
        List<Rubrique> rubriques = new ArrayList<>();
        String sql = "SELECT * FROM rubrique";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Rubrique rubrique = new Rubrique();
                rubrique.setIdRubrique(resultSet.getInt("id_rubrique"));
                rubrique.setNom(resultSet.getString("nom"));
                rubrique.setUniteOeuvre(resultSet.getString("unite_oeuvre"));
                rubrique.setPrixUnitaire(resultSet.getDouble("prix_unitaire"));
                rubrique.setIdNatureRubrique(resultSet.getInt("id_nature_rubrique"));
                rubrique.setIdTypeRubrique(resultSet.getInt("id_type_rubrique"));
                rubrique.setQuantite(resultSet.getDouble("quantite"));

                rubriques.add(rubrique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rubriques;
    }
}
