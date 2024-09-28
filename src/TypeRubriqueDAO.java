import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRubriqueDAO {
    private Connection connection;

    public TypeRubriqueDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterTypeRubrique(TypeRubrique typeRubrique) {
        String sql = "INSERT INTO type_rubrique (nom) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, typeRubrique.getNom());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourTypeRubrique(TypeRubrique typeRubrique) {
        String sql = "UPDATE type_rubrique SET nom = ? WHERE id_type_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, typeRubrique.getNom());
            statement.setInt(2, typeRubrique.getIdTypeRubrique());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerTypeRubrique(int idTypeRubrique) {
        String sql = "DELETE FROM type_rubrique WHERE id_type_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTypeRubrique);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TypeRubrique obtenirTypeRubriqueParId(int idTypeRubrique) {
        String sql = "SELECT * FROM type_rubrique WHERE id_type_rubrique = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTypeRubrique);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    TypeRubrique typeRubrique = new TypeRubrique();
                    typeRubrique.setIdTypeRubrique(resultSet.getInt("id_type_rubrique"));
                    typeRubrique.setNom(resultSet.getString("nom"));

                    return typeRubrique;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TypeRubrique> obtenirTousLesTypesRubrique() {
        List<TypeRubrique> typesRubrique = new ArrayList<>();
        String sql = "SELECT * FROM type_rubrique";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                TypeRubrique typeRubrique = new TypeRubrique();
                typeRubrique.setIdTypeRubrique(resultSet.getInt("id_type_rubrique"));
                typeRubrique.setNom(resultSet.getString("nom"));

                typesRubrique.add(typeRubrique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typesRubrique;
    }
}
