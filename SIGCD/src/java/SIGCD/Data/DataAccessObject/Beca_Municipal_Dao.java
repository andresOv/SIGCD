package SIGCD.Data.DataAccessObject;

import SIGCD.Logic.Formulario.Beca_Municipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Beca_Municipal_Dao {

    public Beca_Municipal read(int id) throws Exception {
        String sql = "select * from t_beca_municipal where id_beca_municipal=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            return from(rs);
        } else {
            return null;
        }
    }

    public Beca_Municipal from(ResultSet rs) {
        try {
            Beca_Municipal OBeca_Municipal = new Beca_Municipal();
            OBeca_Municipal.setCedula(rs.getString(""));
            OBeca_Municipal.setNombre(rs.getString(""));
            OBeca_Municipal.setPrimer_Apellido(rs.getString(""));
            OBeca_Municipal.setSegundo_Apellido(rs.getString(""));
            OBeca_Municipal.setDistrito(rs.getString(""));
            OBeca_Municipal.setBarrio(rs.getString(""));
            OBeca_Municipal.setDireccion(rs.getString(""));
            OBeca_Municipal.setTelefono_Habitacion(rs.getString(""));
            OBeca_Municipal.setTelefono_Celular(rs.getString(""));
            OBeca_Municipal.setFecha_Nacimiento(rs.getString(""));
            OBeca_Municipal.setEdad(rs.getInt(""));
            OBeca_Municipal.setGrado_Cursando(rs.getString(""));
            OBeca_Municipal.setCedula_Madre(rs.getString(""));
            OBeca_Municipal.setNombre_Madre(rs.getString(""));
            OBeca_Municipal.setPrimer_Apellido_Madre(rs.getString(""));
            OBeca_Municipal.setSegundo_Apellido_Madre(rs.getString(""));
            OBeca_Municipal.setCedula_Padre(rs.getString(""));
            OBeca_Municipal.setNombre_Padre(rs.getString(""));
            OBeca_Municipal.setPrimer_Apellido_Padre(rs.getString(""));
            OBeca_Municipal.setSegundo_Apellido_Padre(rs.getString(""));
            OBeca_Municipal.setFecha((LocalDateTime) rs.getObject(""));
            return OBeca_Municipal;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(Beca_Municipal OBeca_Municipal) throws SQLException {
        String sql = "insert into pelicula (id_pelicula,nombre) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        Database db = Database.instance();
        ps = db.getConnection().prepareStatement(sql);
        ps.setInt(1, OBeca_Municipal.getId());
        ps.setString(1, OBeca_Municipal.getCedula());
        ps.setString(2, OBeca_Municipal.getNombre());
        ps.setString(3, OBeca_Municipal.getPrimer_Apellido());
        ps.setString(4, OBeca_Municipal.getSegundo_Apellido());
        ps.setString(6, OBeca_Municipal.getDistrito());
        ps.setString(7, OBeca_Municipal.getBarrio());
        ps.setString(8, OBeca_Municipal.getDireccion());
        ps.setString(9, OBeca_Municipal.getTelefono_Habitacion());
        ps.setString(10, OBeca_Municipal.getTelefono_Celular());
        ps.setString(11, OBeca_Municipal.getFecha_Nacimiento());
        ps.setString(12, OBeca_Municipal.getGrado_Cursando());
        ps.setInt(13, OBeca_Municipal.getEdad());
        ps.setString(14, OBeca_Municipal.getNombre_Madre());
        ps.setString(15, OBeca_Municipal.getCedula_Madre());
        ps.setString(16, OBeca_Municipal.getNombre_Padre());
        ps.setString(17, OBeca_Municipal.getCedula_Padre());
        ps.setObject(18, (LocalDateTime) OBeca_Municipal.getFecha());
        if (ps.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

//    public Pelicula findById(int id_pelicula) {
//        String sql = "select id_pelicula from pelicula where id_pelicula=?;";
//        PreparedStatement ps = null;
//        Database db = Database.instance();
//        ResultSet rs = null;
//        Pelicula u = null;
//        try {
//            ps = db.getConnection().prepareStatement(sql);
//            ps.setInt(1, id_pelicula);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                u = new Pelicula(
//                        rs.getInt(1),
//                        rs.getString(2)
//                );
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return u;
//    }
//
    public ArrayList<Beca_Municipal> readAll() throws Exception {
        String sql = "SELECT * from pelicula;";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        ResultSet rs = Database.instance().executeQuery(stm);
        ArrayList<Beca_Municipal> OLista_Beca_Municipal = new ArrayList<Beca_Municipal>();
        while (rs.next()) {
            OLista_Beca_Municipal.add(from(rs));
        }
        return OLista_Beca_Municipal;
    }

    public void close() {
    }
}
