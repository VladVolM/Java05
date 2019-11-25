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

/**
 *
 * @author alumno
 */
public  class Conexion {
    private static Connection con;
    private VerB b;
    private VerC c;
    
    public static void realizarConexion(String usuario, String contraseña) throws ExcepcionPropia {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",usuario,contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ExcepcionPropia(5);
        }
        
    }
    public static PreparedStatement getUpdatable(String query) throws ExcepcionPropia {
        try {
            return con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            throw new ExcepcionPropia(3);
        }
    }

    public static PreparedStatement getPS(String query) throws ExcepcionPropia {
        try {
            return con.prepareStatement(query);
        } catch (SQLException ex) {
            throw new ExcepcionPropia(4);
        }
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
