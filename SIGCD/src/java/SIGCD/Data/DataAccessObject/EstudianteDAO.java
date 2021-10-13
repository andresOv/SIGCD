package SIGCD.Data.DataAccessObject;

import SIGCD.Logic.Persona.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstudianteDAO {

    public Estudiante read(int idSolicitante) throws Exception {
        String sql = "select * from Estudiante where idEstudiante=?";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        preparedStatement.setInt(1, idSolicitante);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        if (resultSet.next()) {
            return from(resultSet);
        } else {
            return null;
        }
    }

    public Estudiante from(ResultSet resultSet) {
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setIdPersona(resultSet.getInt("idEstudiante"));
            estudiante.setCedula(resultSet.getString("persona"));
            estudiante.setNombre(resultSet.getString("gradoAcademico"));
            estudiante.setPrimerApellido(resultSet.getString("edad"));
            estudiante.setSegundoApellido(resultSet.getString("fechaNacimiento"));
            return estudiante;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(Estudiante estudiante) throws SQLException {
        String estudianteSQL = "insert into Estudiante (persona,gradoAcademico,edad,fechaNacimiento) values(?,?,?,?)";
        Database database = Database.instance();
        PreparedStatement preparedStatement = null;
        preparedStatement = database.getConnection().prepareStatement(estudianteSQL);
        preparedStatement.setInt(1, estudiante.getIdPersona());
        preparedStatement.setInt(2, estudiante.getGradoAcademico());
        preparedStatement.setInt(3, estudiante.getEdad());
        preparedStatement.setString(4, estudiante.getFechaNacimiento());
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

// public Solicitante findById(int idAyudaTemporal) {
// String sql = "select idSolicitante from Solicitante where idSolictante=?;";
// PreparedStatement preparedStatement = null;
// Database database = Database.instance();
// ResultSet resultSet = null;
// Solicitante temp = null;
// try {
// preparedStatement = database.getConnection().prepareStatement(sql);
// preparedStatement.setInt(1, idAyudaTemporal);
// resultSet = preparedStatement.executeQuery();
// while (resultSet.next()) {
// temp = new Solicitante(
// resultSet.getInt(1),
// resultSet.getInt(2),
// resultSet.getString(3),
// resultSet.getString(4)
// );
// }
// } catch (SQLException ex) {
// Logger.getLogger(AyudaTemporalDAO.class.getName()).log(Level.SEVERE, null, ex);
// }
// return temp;
//}
    public ArrayList<Estudiante> readAll() throws Exception {
        String sql = "select * from Estudiante;";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
        while (resultSet.next()) {
            listaEstudiante.add(from(resultSet));
        }
        return listaEstudiante;
    }

    public void close() {
    }
}
