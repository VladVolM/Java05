/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author alumno
 */
public  class Conexion {
    private static Connection con;
    
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
}
