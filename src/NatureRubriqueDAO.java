import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NatureRubriqueDAO {
    private Connection connection;

    public NatureRubriqueDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterNatureRubrique(NatureRubrique natureRubrique) {
        String sql = "INSERT INTO nature_rubrique (nom) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, natureRubrique.getNom());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourNatureRubrique(NatureRubrique natureRubrique) {
        String sql = "UPDATE nature_rubrique SET nom = ? WHERE id_nature_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, natureRubrique.getNom());
            statement.setInt(2, natureRubrique.getIdNatureRubrique());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerNatureRubrique(int idNatureRubrique) {
        String sql = "DELETE FROM nature_rubrique WHERE id_nature_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idNatureRubrique);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NatureRubrique obtenirNatureRubriqueParId(int idNatureRubrique) {
        String sql = "SELECT * FROM nature_rubrique WHERE id_nature_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idNatureRubrique);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    NatureRubrique natureRubrique = new NatureRubrique();
                    natureRubrique.setIdNatureRubrique(resultSet.getInt("id_nature_rubrique"));
                    natureRubrique.setNom(resultSet.getString("nom"));

                    return natureRubrique;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NatureRubrique> obtenirToutesLesNatureRubriques() {
        List<NatureRubrique> natureRubriques = new ArrayList<>();
        String sql = "SELECT * FROM nature_rubrique";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                NatureRubrique natureRubrique = new NatureRubrique();
                natureRubrique.setIdNatureRubrique(resultSet.getInt("id_nature_rubrique"));
                natureRubrique.setNom(resultSet.getString("nom"));

                natureRubriques.add(natureRubrique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return natureRubriques;
    }
}
