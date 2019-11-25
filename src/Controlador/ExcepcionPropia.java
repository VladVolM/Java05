package Controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ExcepcionPropia extends Exception {
    String errorReciente;

    public String getErrorReciente() {
        return errorReciente;
    }
    public ExcepcionPropia(int e){
        try {
            String descripcion= ControlDeFichero.buscarError(e+1);
            GregorianCalendar g =new GregorianCalendar();
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            String s = formato.format(g.getTime());
            errorReciente=s+" - "+descripcion+"\n";
            try {
                ControlDeFichero.escribirLog(errorReciente);
            } catch (IOException ex) {
                try {
                    throw new ExcepcionPropia(1);
                } catch (ExcepcionPropia ex1) {
                    JOptionPane.showMessageDialog(null, "No se guardo el log");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ExcepcionPropia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
