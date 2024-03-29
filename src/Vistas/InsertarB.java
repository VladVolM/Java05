/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import Controlador.ExcepcionPropia;
import Modelo.TodasLasConsultas;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author alumno
 */
public class InsertarB extends javax.swing.JPanel {
    /**
     * Creates new form InsertarB
     * @param n
     */
    public InsertarB(String n) {
        initComponents();
        jTextField3.setText(n);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        imageButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();

        jLabel4.setText("NIF:");

        jLabel5.setText("Codigo:");

        jLabel6.setText("Fecha:");

        jTextField3.setEnabled(false);
        jTextField3.setMinimumSize(new java.awt.Dimension(110, 20));
        jTextField3.setPreferredSize(new java.awt.Dimension(110, 20));

        jTextField4.setMinimumSize(new java.awt.Dimension(110, 20));
        jTextField4.setPreferredSize(new java.awt.Dimension(110, 20));

        jTextField5.setEnabled(false);
        jTextField5.setMinimumSize(new java.awt.Dimension(110, 20));
        jTextField5.setPreferredSize(new java.awt.Dimension(110, 20));

        jLabel7.setText("Imagen:");

        imageButton.setText("Elegir imagen");
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insertar");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(49, 49, 49)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(volverButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(insertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(volverButton))
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
                jTextField5.setText(stringNombreImagen);
            } catch (IOException e) {
                try {
                    throw new ExcepcionPropia(14);
                } catch (ExcepcionPropia ex1) {
                    JOptionPane.showMessageDialog(null, ex1.getErrorReciente());
                }
            }
        }
    }//GEN-LAST:event_imageButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement p = Conexion.getUpdatable(TodasLasConsultas.get7());
            p.setString(1, jTextField3.getText());
            p.setInt(2, Integer.valueOf(jTextField4.getText()));
            p.setString(3, jTextField5.getText());
            java.util.Date fechaApertura = jXDatePicker2.getDate();       
            java.sql.Date dat = new java.sql.Date(fechaApertura.getTime());
            p.setDate(4, dat);
            p.executeUpdate();
            p.close();
            ((Menu)SwingUtilities.getWindowAncestor(this)).verB();
        } catch (SQLException ex) {
            try {
                throw new ExcepcionPropia(15);
            } catch (ExcepcionPropia ex1) {
                JOptionPane.showMessageDialog(null, ex1.getErrorReciente());
            }
        } catch (ExcepcionPropia ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorReciente());
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        // TODO add your handling code here:
        ((Menu)SwingUtilities.getWindowAncestor(this)).verB();
    }//GEN-LAST:event_volverButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imageButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
