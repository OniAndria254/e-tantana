import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeCentreDAO {
    private Connection connection;

    public TypeCentreDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterTypeCentre(TypeCentre typeCentre) {
        String sql = "INSERT INTO type_centre (nom) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, typeCentre.getNom());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourTypeCentre(TypeCentre typeCentre) {
        String sql = "UPDATE type_centre SET nom = ? WHERE id_type_centre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, typeCentre.getNom());
            statement.setInt(2, typeCentre.getIdTypeCentre());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerTypeCentre(int idTypeCentre) {
        String sql = "DELETE FROM type_centre WHERE id_type_centre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTypeCentre);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TypeCentre obtenirTypeCentreParId(int idTypeCentre) {
        String sql = "SELECT * FROM type_centre WHERE id_type_centre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTypeCentre);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    TypeCentre typeCentre = new TypeCentre();
                    typeCentre.setIdTypeCentre(resultSet.getInt("id_type_centre"));
                    typeCentre.setNom(resultSet.getString("nom"));

                    return typeCentre;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TypeCentre> obtenirTousLesTypesCentre() {
        List<TypeCentre> typesCentre = new ArrayList<>();
        String sql = "SELECT * FROM type_centre";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                TypeCentre typeCentre = new TypeCentre();
                typeCentre.setIdTypeCentre(resultSet.getInt("id_type_centre"));
                typeCentre.setNom(resultSet.getString("nom"));

                typesCentre.add(typeCentre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typesCentre;
    }
}
