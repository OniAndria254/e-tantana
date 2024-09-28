import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentreDAO {
    private Connection connection;

    public CentreDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterCentre(Centre centre) {
        String sql = "INSERT INTO centre (nom, id_type_centre) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, centre.getNom());
            statement.setInt(2, centre.getIdTypeCentre());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourCentre(Centre centre) {
        String sql = "UPDATE centre SET nom = ?, id_type_centre = ? WHERE id_centre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, centre.getNom());
            statement.setInt(2, centre.getIdTypeCentre());
            statement.setInt(3, centre.getIdCentre());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerCentre(int idCentre) {
        String sql = "DELETE FROM centre WHERE id_centre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCentre);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Centre obtenirCentreParId(int idCentre) {
        String sql = "SELECT * FROM centre WHERE id_centre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCentre);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Centre centre = new Centre();
                    centre.setIdCentre(resultSet.getInt("id_centre"));
                    centre.setNom(resultSet.getString("nom"));
                    centre.setIdTypeCentre(resultSet.getInt("id_type_centre"));

                    return centre;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Centre> obtenirTousLesCentres() {
        List<Centre> centres = new ArrayList<>();
        String sql = "SELECT * FROM centre";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Centre centre = new Centre();
                centre.setIdCentre(resultSet.getInt("id_centre"));
                centre.setNom(resultSet.getString("nom"));
                centre.setIdTypeCentre(resultSet.getInt("id_type_centre"));

                centres.add(centre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return centres;
    }
}
