package SIGCD.Data.DataAccessObject;

import SIGCD.Logic.Persona.Solicitante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolicitanteDAO {

    public Solicitante read(int idSolicitante) throws Exception {
        String sql = "select * from Solicitante where idSolicitante=?";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        preparedStatement.setInt(1, idSolicitante);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        if (resultSet.next()) {
            return from(resultSet);
        } else {
            return null;
        }
    }

    public Solicitante from(ResultSet resultSet) {
        try {
            Solicitante solicitante = new Solicitante();
            solicitante.setIdPersona(resultSet.getInt("idSolicitante"));
            solicitante.setCedula(resultSet.getString("persona"));
            solicitante.setNombre(resultSet.getString("telefonoHabitacion"));
            solicitante.setPrimerApellido(resultSet.getString("telefonoCelular"));
            solicitante.setSegundoApellido(resultSet.getString("distrito"));
            solicitante.setSegundoApellido(resultSet.getString("barrio"));
            solicitante.setSegundoApellido(resultSet.getString("direccionExacta"));
            return solicitante;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(Solicitante solicitante) throws SQLException {
        String solicitanteSQL = "insert into Solicitante (persona,telefonoHabitacion,telefonoCelular,distrito,barrio,direccionExacta) values(?,?,?,?,?,?)";
        Database database = Database.instance();
        PreparedStatement preparedStatement = null;
        preparedStatement = database.getConnection().prepareStatement(solicitanteSQL);
        preparedStatement.setInt(1, solicitante.getIdPersona());
        preparedStatement.setString(2, solicitante.getTelefonoHabitacion());
        preparedStatement.setString(3, solicitante.getTelefonoCelular());
        preparedStatement.setInt(4, solicitante.getDireccion().getBarrio());
        preparedStatement.setInt(5, solicitante.getDireccion().getDistrito());
        preparedStatement.setString(6, solicitante.getDireccion().getDireccionExacta());
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
    public ArrayList<Solicitante> readAll() throws Exception {
        String sql = "select * from Solicitante;";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        ArrayList<Solicitante> listaSolicitante = new ArrayList<>();
        while (resultSet.next()) {
            listaSolicitante.add(from(resultSet));
        }
        return listaSolicitante;
    }

    public void close() {
    }
}
