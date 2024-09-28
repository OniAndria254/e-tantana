import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LiaisonDAO {
    private Connection connection;

    public LiaisonDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterLiaison(Liaison liaison) {
        String sql = "INSERT INTO liaison (taux, id_exercice, id_centre, cout_fixe, cout_variable, id_rubrique) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, liaison.getTaux());
            statement.setInt(2, liaison.getIdExercice());
            statement.setInt(3, liaison.getIdCentre());
            statement.setDouble(4, liaison.getCoutFixe());
            statement.setDouble(5, liaison.getCoutVariable());
            statement.setInt(6, liaison.getIdRubrique());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourLiaison(Liaison liaison) {
        String sql = "UPDATE liaison SET taux = ?, id_exercice = ?, id_centre = ?, cout_fixe = ?, cout_variable = ?, id_rubrique = ? WHERE id_liaison = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, liaison.getTaux());
            statement.setInt(2, liaison.getIdExercice());
            statement.setInt(3, liaison.getIdCentre());
            statement.setDouble(4, liaison.getCoutFixe());
            statement.setDouble(5, liaison.getCoutVariable());
            statement.setInt(6, liaison.getIdRubrique());
            statement.setInt(7, liaison.getIdLiaison());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerLiaison(int idLiaison) {
        String sql = "DELETE FROM liaison WHERE id_liaison = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLiaison);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Liaison obtenirLiaisonParId(int idLiaison) {
        String sql = "SELECT * FROM liaison WHERE id_liaison = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLiaison);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Liaison liaison = new Liaison();
                    liaison.setIdLiaison(resultSet.getInt("id_liaison"));
                    liaison.setTaux(resultSet.getDouble("taux"));
                    liaison.setIdExercice(resultSet.getInt("id_exercice"));
                    liaison.setIdCentre(resultSet.getInt("id_centre"));
                    liaison.setCoutFixe(resultSet.getDouble("cout_fixe"));
                    liaison.setCoutVariable(resultSet.getDouble("cout_variable"));
                    liaison.setIdRubrique(resultSet.getInt("id_rubrique"));

                    return liaison;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Liaison> obtenirToutesLesLiaisons() {
        List<Liaison> liaisons = new ArrayList<>();
        String sql = "SELECT * FROM liaison";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Liaison liaison = new Liaison();
                liaison.setIdLiaison(resultSet.getInt("id_liaison"));
                liaison.setTaux(resultSet.getDouble("taux"));
                liaison.setIdExercice(resultSet.getInt("id_exercice"));
                liaison.setIdCentre(resultSet.getInt("id_centre"));
                liaison.setCoutFixe(resultSet.getDouble("cout_fixe"));
                liaison.setCoutVariable(resultSet.getDouble("cout_variable"));
                liaison.setIdRubrique(resultSet.getInt("id_rubrique"));

                liaisons.add(liaison);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liaisons;
    }
}
