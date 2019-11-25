package Controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class ExcepcionPropia extends Exception {
    public ExcepcionPropia(int e){
        String descripcion;
        switch (e){
            case 1:descripcion="No se pudo guardar el Log"; break;
            case 2: descripcion="Debuelto tras 30 dias"; break;
            case 3: descripcion="Error al ver Socio"; break;
            case 4: descripcion="No se guardo la fecha socio"; break;
            case 5: descripcion="No se pudo crear Jlist"; break;
            case 6: descripcion="Devolver no ejecutado"; break;
            case 7: descripcion="Error en ver libro"; break;
            case 8: descripcion="Error al iniciar conexion"; break;
            case 9: descripcion="No se pudo ver prestamos"; break;
            case 10: descripcion=""; break;
            case 11: descripcion=""; break;
            default: descripcion=""; break;
        }
        java.util.Date fecha = new GregorianCalendar().getGregorianChange();       
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String s = formato.format(fecha);
        try {
            ControlDeFichero.escribirLog(s+"|"+descripcion+"\n");
        } catch (IOException ex) {
            try {
                throw new ExcepcionPropia(1);
            } catch (ExcepcionPropia ex1) {
                JOptionPane.showMessageDialog(null, "No se guardo el log");
            }
        }
    }
}
