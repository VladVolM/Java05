/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TodasLasConsultas;
import Vistas.VerB;
import Vistas.VerC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alumno
 */
public  class Conexion {
    private static Connection con;
    private VerB b;
    private VerC c;
    
    public static void realizarConexion(String usuario, String contraseña) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",usuario,contraseña);
    }
    public static PreparedStatement getUpdatable(String query) throws SQLException {
        return con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    }

    public static PreparedStatement getPS(String query) throws SQLException {
        return con.prepareStatement(query);
    }
    
    public static VerB setVistasUsuaro(String us,String cod) throws ExcepcionPropia{
        try {
        PreparedStatement p = getUpdatable(TodasLasConsultas.get1());
        
            p.setString(1, us);
        
        p.setString(2, cod);
        ResultSet r = p.executeQuery();
        if (r.next())
            return new VerB(r.getString(1));
        
        return new VerB(null);
        } catch (SQLException ex) {
            throw new ExcepcionPropia(2);
        }
    }
}
