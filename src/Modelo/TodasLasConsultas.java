/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alumno
 */
public class TodasLasConsultas {
    public static String get1(){
        return "select nif from ATable where usuario =? and contra = ?";
    }

    public static String get2() {
        return "create table ATable(nif varchar(9) PRIMARY KEY,usuario varchar(30),contra varchar(20))";
    }

    public static String get3() {
        return "select * from ATable";
    }

    public static String get4() {
        return "select * from BTable where nif =?";
    }

    public static String get5() {
        return "update BTable set imagen=? where nif=? and codigo=?";
    }

    public static String get6() {
        return "update BTable set fechaLanzamiento=? where nif=? and codigo=?";
    }

    public static String get7() {
        return "insert into BTable values(?,?,?,?)";
    }

    public static String get8() {
        return "select * from CTable where CodB=?";
    }

    public static String get9() {
        return "select contador from CTable where codB = ?";
    }

    public static String get10() {
        return "select descuento from DTable where codigo=?";
    }

    public static String get11() {
        return "Insert into CTable values(?,?,?,?)";
    }
    
    public static String get12() {
        return "select codigo from DTable";
    }
    
}
