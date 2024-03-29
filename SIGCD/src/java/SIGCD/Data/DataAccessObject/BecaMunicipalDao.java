package SIGCD.Data.DataAccessObject;

import SIGCD.Logic.Formulario.BecaMunicipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BecaMunicipalDAO {

    public BecaMunicipal read(int idBecaMunicipal) throws Exception {
        String sql = "select * from BecaMunicipal where idBecaMunicipal=?";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        preparedStatement.setInt(1, idBecaMunicipal);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        if (resultSet.next()) {
            return from(resultSet);
        } else {
            return null;
        }
    }

    public BecaMunicipal from(ResultSet resultSet) {
        try {
            BecaMunicipal becaMunicipal = new BecaMunicipal();
            becaMunicipal.setIdFormulario(resultSet.getInt("idBecaMunicipal"));
            becaMunicipal.setEstado(resultSet.getInt("estado"));
            becaMunicipal.setEstudiante(resultSet.getInt("estudiante"));
            becaMunicipal.setFechaCreacion(resultSet.getTimestamp("fechaCreacion"));
            return becaMunicipal;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(BecaMunicipal becaMunicipal) throws SQLException {
        String ayudaTemporalSQL = "insert into BecaMunicipal (estado,estudiante,fechaCreacion) values(?,?,?)";
        Database database = Database.instance();
        PreparedStatement preparedStatement = null;
        preparedStatement = database.getConnection().prepareStatement(ayudaTemporalSQL);
        preparedStatement.setInt(1, becaMunicipal.getEstado());
        preparedStatement.setInt(2, becaMunicipal.getEstudiante());
        preparedStatement.setTimestamp(3, becaMunicipal.getFechaCreacion());
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public BecaMunicipal findById(int idAyudaTemporal) {
        String sql = "select idBecaMunicipal from BecaMunicipal where idBecaMunicipal=?;";
        PreparedStatement preparedStatement = null;
        Database database = Database.instance();
        ResultSet resultSet = null;
        BecaMunicipal temp = null;
        try {
            preparedStatement = database.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idAyudaTemporal);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                temp = new BecaMunicipal(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getTimestamp(3),
                        resultSet.getInt(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AyudaTemporalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public ArrayList<BecaMunicipal> readAll() throws Exception {
        String sql = "select* from BecaMunicipal;";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        ResultSet resultSet = Database.instance().executeQuery(stm);
        ArrayList<BecaMunicipal> listaBecaMunicipal = new ArrayList<>();
        while (resultSet.next()) {
            listaBecaMunicipal.add(from(resultSet));
        }
        return listaBecaMunicipal;
    }

    public void close() {
    }
}
