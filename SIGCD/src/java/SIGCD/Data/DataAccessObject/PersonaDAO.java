/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGCD.Data.DataAccessObject;

import SIGCD.Logic.Persona.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class PersonaDAO {

   public Persona read(int idPersona) throws Exception {
        String sql = "select * from Persona where idPersona=?";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        preparedStatement.setInt(1, idPersona);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        if (resultSet.next()) {
            return from(resultSet);
        } else {
            return null;
        }
    }

    public Persona from(ResultSet resultSet) {
        try {
            Persona persona = new Persona();
            persona.setIdPersona(resultSet.getInt("idPersona"));
            persona.setCedula(resultSet.getString("cedula"));
            persona.setNombre(resultSet.getString("nombre"));
            persona.setPrimerApellido(resultSet.getString("primerApellido"));
            persona.setSegundoApellido(resultSet.getString("segundoApellido"));
            return persona;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(Persona persona) throws SQLException {
        String personaSQL = "insert into Persona (cedula,nombre,primerApellido,segundoApellido) values(?,?,?,?)";
        Database database = Database.instance();
        PreparedStatement preparedStatement = null;
        preparedStatement = database.getConnection().prepareStatement(personaSQL);
        preparedStatement.setString(1, persona.getCedula());
        preparedStatement.setString(2, persona.getNombre());
        preparedStatement.setString(3, persona.getPrimerApellido());
        preparedStatement.setString(4, persona.getSegundoApellido());
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public Persona findById(int idPersona) {
        String sql = "select idPersona from Persona where idPersona=?;";
        PreparedStatement preparedStatement = null;
        Database database = Database.instance();
        ResultSet resultSet = null;
        Persona temp = null;
        try {
            preparedStatement = database.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idPersona);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                temp = new Persona(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public ArrayList<Persona> readAll() throws Exception {
        String sql = "select * from Persona;";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        ArrayList<Persona> listaPersona = new ArrayList<>();
        while (resultSet.next()) {
            listaPersona.add(from(resultSet));
        }
        return listaPersona;
    }

    public void close() {
    }
}
