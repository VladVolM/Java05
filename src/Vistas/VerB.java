/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import Controlador.Validacion;
import Modelo.BTabla;
import Modelo.TodasLasConsultas;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author alumno
 */
public class VerB extends javax.swing.JPanel {
    private ResultSet rs;
    private VerC c;
    private BTabla b;
    private String recuerdaNif=null;

    public String getNif() {
        return recuerdaNif;
    }

    public VerC getC() {
        return c;
    }
    /**
     * Creates new form VerB
     * @param nif
     * @throws java.sql.SQLException
     */
    public VerB(String nif) throws SQLException {
        initComponents();

        new Validacion(nif);

        if(nif!=null){
            recuerdaNif=nif;
            PreparedStatement p = Conexion.getUpdatable(TodasLasConsultas.get4());
            p.setString(1, nif);
            rs = p.executeQuery();
            try {
                if (rs.first()){
                    Collection<Integer> coleccion = new LinkedList<>();
                    coleccion.add(rs.getInt(2));
                    while(rs.next()){
                        coleccion.add(rs.getInt(2));
                    }
                    c=new VerC(coleccion,1);//SE CREA PARA SOLAMENTE SER USABLE POR EL GET VERC

                }else System.out.println("ERROR en VerB no existe B para tal usuario");
                    //crearVerC
            } catch (SQLException ex) {
                System.out.println("Error al verC");
            }
        }else System.out.println("ERROR en VerB no existe tal usuario");
        rs.first();// para que empieze por ahí
        verTablaB();
        atrasButton.setEnabled(false);
        if(rs.isLast())
            adelanteButton.setEnabled(false);
    }

    private void verTablaB() {
        try {
            jTextField1.setText(rs.getString(1));
            jTextField2.setText(String.valueOf(rs.getInt(2)));
            BufferedImage img;
            img = ImageIO.read(new File("IMAGENES/"+rs.getString(3)));//lectura buffer de imagen
            Image dimg = img.getScaledInstance(imageLabel.getPreferredSize().width, imageLabel.getPreferredSize().height,Image.SCALE_SMOOTH);//usar buffer para CAMBIAR TAMAÑO
            imageLabel.setIcon(new ImageIcon(dimg));//representa imagen
            jXDatePicker1.setDate(rs.getDate(4));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de lectura B");
        }
        
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        imageButton = new javax.swing.JButton();
        atrasButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        adelanteButton = new javax.swing.JButton();

        jLabel1.setText("NIF:");
        jLabel1.setMaximumSize(new java.awt.Dimension(54, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(54, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(54, 15));

        jTextField1.setText("jTextField1");
        jTextField1.setEnabled(false);
        jTextField1.setMinimumSize(new java.awt.Dimension(152, 19));
        jTextField1.setPreferredSize(new java.awt.Dimension(152, 19));

        jLabel2.setText("Codigo:");

        jTextField2.setText("jTextField2");
        jTextField2.setEnabled(false);
        jTextField2.setMinimumSize(new java.awt.Dimension(152, 19));
        jTextField2.setPreferredSize(new java.awt.Dimension(152, 19));

        jLabel3.setText("Fecha:");
        jLabel3.setMaximumSize(new java.awt.Dimension(54, 15));
        jLabel3.setMinimumSize(new java.awt.Dimension(54, 15));
        jLabel3.setPreferredSize(new java.awt.Dimension(54, 15));

        imageLabel.setMaximumSize(new java.awt.Dimension(140, 140));
        imageLabel.setMinimumSize(new java.awt.Dimension(140, 140));
        imageLabel.setPreferredSize(new java.awt.Dimension(140, 140));

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        imageButton.setText("Cambiar imagen");
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        atrasButton.setText("<--");
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insertar B");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        cButton.setText("Ver C");
        cButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtonActionPerformed(evt);
            }
        });

        adelanteButton.setText("-->");
        adelanteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adelanteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(atrasButton)
                                .addGap(18, 18, 18)
                                .addComponent(insertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cButton)
                                .addGap(18, 18, 18)
                                .addComponent(adelanteButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(atrasButton)
                    .addComponent(adelanteButton)
                    .addComponent(cButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
        // TODO add your handling code here:
        int op;
        
        op = jFileChooser1.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION){
            File imagen = jFileChooser1.getSelectedFile();
            String pathImagen=imagen.getAbsolutePath();
            String stringNombreImagen= pathImagen.substring(pathImagen.lastIndexOf('/')+1);
            Path orig = Paths.get(pathImagen);
            Path dest = Paths.get("IMAGENES/"+stringNombreImagen);
            try {
                Files.copy(orig, dest, StandardCopyOption.REPLACE_EXISTING);
                BufferedImage img;
                img = ImageIO.read(new File("IMAGENES/"+stringNombreImagen));//lectura buffer de imagen
                Image dimg = img.getScaledInstance(imageLabel.getPreferredSize().width, imageLabel.getPreferredSize().height,Image.SCALE_SMOOTH);//usar buffer para CAMBIAR TAMAÑO
                imageLabel.setIcon(new ImageIcon(dimg));//representa imagen
                //update a la imagen
                PreparedStatement p = Conexion.getUpdatable(TodasLasConsultas.get5());
                p.setString(1, stringNombreImagen);
                p.setString(2, rs.getString(1));
                p.setInt(3, rs.getInt(2));
                if (p.executeUpdate()== 0) System.out.println("No se realizo el guardado de imagen");
                p.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de lectura de imagen");
            }
        }
    }//GEN-LAST:event_imageButtonActionPerformed

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
            // TODO add your handling code here:
        try {
            rs.previous();
            verTablaB();
            if(rs.isFirst())
                atrasButton.setEnabled(false);
            adelanteButton.setEnabled(true);
        } catch (SQLException ex) {
            System.out.println("error al moverse atras");
        }
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        ((Menu)SwingUtilities.getWindowAncestor(this)).insertarB();//para ver el menu de insertar B
    }//GEN-LAST:event_insertButtonActionPerformed

    private void cButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtonActionPerformed
        // TODO add your handling code here:
        try {
            int posB = rs.getInt(2); //guarda el codigo b

            if (rs.first()){
                Collection<Integer> coleccion = new LinkedList<>();
                coleccion.add(rs.getInt(2));
                while(rs.next()){
                    coleccion.add(rs.getInt(2));
                }
                c=new VerC(coleccion,posB);
                ((Menu)SwingUtilities.getWindowAncestor(this)).setBC(this);

            }else System.out.println("ERROR en VerB no existe B para tal usuario");
                //crearVerC
            ((Menu)SwingUtilities.getWindowAncestor(this)).verC();//para ver C
            
            rs.beforeFirst();
            while (rs.next() && rs.getInt(2)!=posB)
            {}
        } catch (SQLException ex) {
            System.out.println("Error al verC");
        }
        
    }//GEN-LAST:event_cButtonActionPerformed

    private void adelanteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adelanteButtonActionPerformed
        // TODO add your handling code here:
        try {
            rs.next();
            verTablaB();
            if(rs.isLast())
                adelanteButton.setEnabled(false);
            atrasButton.setEnabled(true);
        } catch (SQLException ex) {
            System.out.println("error al moverse adelante");
        }
    }//GEN-LAST:event_adelanteButtonActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement p = Conexion.getUpdatable(TodasLasConsultas.get6());
        java.util.Date fechaApertura = jXDatePicker1.getDate();       
        java.sql.Date dat = new java.sql.Date(fechaApertura.getTime());
        p.setDate(1, dat);
        p.setString(2, rs.getString(1));
        p.setInt(3, rs.getInt(2));
        if (p.executeUpdate()== 0) System.out.println("No se realizo el guardado de fecha");
        
            p.close();
        } catch (SQLException ex) {
            Logger.getLogger(VerB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en fecha modificada de verB");
        }
    }//GEN-LAST:event_jXDatePicker1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adelanteButton;
    private javax.swing.JButton atrasButton;
    private javax.swing.JButton cButton;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton insertButton;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
