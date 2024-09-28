import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciceDAO {
    private Connection connection;

    public ExerciceDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean ajouterExercice(Exercice exercice) {
        String sql = "INSERT INTO exercice (date_debut, date_fin) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new Date(exercice.getDateDebut().getTime()));
            statement.setDate(2, new Date(exercice.getDateFin().getTime()));

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean mettreAJourExercice(Exercice exercice) {
        String sql = "UPDATE exercice SET date_debut = ?, date_fin = ? WHERE id_exercice = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new Date(exercice.getDateDebut().getTime()));
            statement.setDate(2, new Date(exercice.getDateFin().getTime()));
            statement.setInt(3, exercice.getIdExercice());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean supprimerExercice(int idExercice) {
        String sql = "DELETE FROM exercice WHERE id_exercice = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idExercice);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Exercice obtenirExerciceParId(int idExercice) {
        String sql = "SELECT * FROM exercice WHERE id_exercice = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idExercice);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Exercice exercice = new Exercice();
                    exercice.setIdExercice(resultSet.getInt("id_exercice"));
                    exercice.setDateDebut(resultSet.getDate("date_debut"));
                    exercice.setDateFin(resultSet.getDate("date_fin"));

                    return exercice;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Exercice> obtenirTousLesExercices() {
        List<Exercice> exercices = new ArrayList<>();
        String sql = "SELECT * FROM exercice";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Exercice exercice = new Exercice();
                exercice.setIdExercice(resultSet.getInt("id_exercice"));
                exercice.setDateDebut(resultSet.getDate("date_debut"));
                exercice.setDateFin(resultSet.getDate("date_fin"));

                exercices.add(exercice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exercices;
    }
}
