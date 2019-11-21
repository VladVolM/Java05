/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TodasLasConsultas;
import com.aeat.valida.Validador;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Validacion {
    boolean validacion = true;

    public Validacion(String nif) {
        Validador val = new Validador();
        if (val.checkNif(nif)!=0)
            JOptionPane.showMessageDialog(null,"No es un NIF de formato correcto");
    }

    public boolean isValidacion() {
        return validacion;
    }
    
    public Validacion() throws ClassNotFoundException, SQLException {
        Connection conderby;
        String b = File.separator;
        String bdd = System.getProperty("user.dir")+b+"Bases_de_datos"+b+"BDDerby";
        File url = new File(bdd);
        PreparedStatement ps,ps2;
        ResultSet rs,rs2;
        boolean otro =true;
        
        if(url.exists()){
            System.out.println("La base de datos derby ya existe");
            conderby = DriverManager.getConnection("jdbc:derby:"+bdd+";");
        }else{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conderby = DriverManager.getConnection("jdbc:derby:"+bdd+" ;create=true");
            ps = conderby.prepareStatement(TodasLasConsultas.get2());
            ps.execute();
            ps.close();
            
            ps = conderby.prepareStatement("insert into ATable values('123456789', 'Liang', 'jsdhj4svuw')");
            ps.execute();
            ps = conderby.prepareStatement("insert into ATable values('234567890', 'Luca', 'itg3omfdd')");
            ps.execute();
            ps = conderby.prepareStatement("insert into ATable values('345678901', 'Andy', 'pqrnc6laug')");
            ps.execute();
            ps = conderby.prepareStatement("insert into ATable values('456789012', 'Osas', 'ncoe742d')");
            ps.execute();
            ps = conderby.prepareStatement("insert into ATable values('567890123', 'Volo', '12345')");
            ps.execute();
            ps.close();

            System.out.println("La base de datos derby se ha creado");
        }
        ps = conderby.prepareStatement(TodasLasConsultas.get3());
        rs = ps.executeQuery();
        
        Conexion.realizarConexion("postgres", "example");
        ps2 = Conexion.getPS(TodasLasConsultas.get3());
        rs2 = ps2.executeQuery();
        if (rs.next()==rs2.next()){
            while(otro){
                if(rs.getString(1).equals(rs2.getString(1))){
                    rs.next();
                    otro =rs2.next();
                }else{
                    validacion = false;
                    otro = false;
                }
            }
        }
        rs2.close();
        rs.close();
        
        ps2.close();
        ps.close();
        
        if (validacion)
            Conexion.realizarConexion("postgres", "example");//conexion a postgres 
    }
    
}
