/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class Validacion {

    public Validacion(String usuario, String contraseña) throws ClassNotFoundException, SQLException {
        Connection conderby;
        String b = File.separator;
        String bdd = System.getProperty("user.dir")+b+"Bases_de_datos"+b+"BDDerby";
        File url = new File(bdd);
        PreparedStatement ps,ps2;
        ResultSet rs,rs2;
        boolean validacion = true,otro =true;
        
        if(url.exists()){
            System.out.println("La base de datos derby ya existe");
            conderby = DriverManager.getConnection("jdbc:derby:"+bdd+";");
        }else{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conderby = DriverManager.getConnection("jdbc:derby:"+bdd+";create=true");
            
            ps = conderby.prepareStatement("create table ATable(nif varchar(9) PRIMARY KEY,usuario varchar(30),contra varchar(20))");
            ps.execute();
            ps.close();
            
            ps = conderby.prepareStatement( "insert into ATable values('123456789', 'Liang', 'jsdhj4svuw');" +
                                            "insert into ATable values('234567890', 'Luca', 'itg3omfdd');" +
                                            "insert into ATable values('345678901', 'Andy', 'pqrnc6laug');" +
                                            "insert into ATable values('456789012', 'Osas', 'ncoe742d');" +
                                            "insert into ATable values('567890123', 'Volo', '12345');");
            ps.execute();
            ps.close();

            System.out.println("La base de datos derby se ha creado");
        }
        ps = conderby.prepareStatement("select * from ATable");
        rs = ps.executeQuery();
        
        ps2 = Conexion.getPS("select * from ATable");
        rs2 = ps2.executeQuery();

        if (rs.first()==rs2.first()){
            while(otro){
                if(rs.getString(1)==rs2.getString(1)){
                    if (rs.next())
                        rs2.next();
                    else if (!rs2.next())
                            otro =false;
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
            Conexion.realizarConexion(usuario, contraseña);//conexion a postgres 
    }
    
}
