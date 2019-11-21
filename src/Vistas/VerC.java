/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import Modelo.CTabla;
import Modelo.TodasLasConsultas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumno
 */
public class VerC extends javax.swing.JPanel {
    Collection<CTabla> tabla = new LinkedList<>();
    int paraInsertado;
    /**
     * Creates new form VerC
     * @param c
     * @param i
     * @throws java.sql.SQLException
     */
    public VerC(Collection<Integer> c,int i) throws SQLException {
        initComponents();
        paraInsertado=i;
        origenLabel.setText("Has entrado desde B: "+ i);
        Iterator itr = c.iterator();
        while (itr.hasNext()){
            PreparedStatement p = Conexion.getPS(TodasLasConsultas.get8());
            p.setInt(1,(int)itr.next());//Funciona???
            ResultSet rs = p.executeQuery();

            while (rs.next()){
                //crear objeto CTabla y añadirlo a la coleccion
                tabla.add(new CTabla(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getFloat(4)));
            }
        }
        insertarTabla();
    }
    //////////////VALOR CALCULADO AUTOMATICO POR HACER
    private void insertarTabla(){//Introduce la collection dentro de las tablas
        Iterator itr=tabla.iterator();
        CTabla c;
        DefaultTableModel model;//para que tenga en cuenta el diseño de la tabla para el insrtado
        while(itr.hasNext()) {
            c = (CTabla)itr.next();
            model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{c.getCodB(),c.getCodD(),c.getContador(),c.getValorCalculado()});
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

        origenLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        volverButton = new javax.swing.JButton();
        insertarButton = new javax.swing.JButton();

        origenLabel.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "B", "D", "Contador", "Calculo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        insertarButton.setText("Insertar");
        insertarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(volverButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(origenLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(origenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertarButton)
                    .addComponent(volverButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void insertarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarButtonActionPerformed
        // TODO add your handling code here:
        try {
            ((Menu)SwingUtilities.getWindowAncestor(this)).insertarC(paraInsertado);//para ver el menu de insertar C
        } catch (SQLException ex) {
            System.out.println("ERROR al usar boton insertar C");
            Logger.getLogger(InsertarC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertarButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        // TODO add your handling code here:
        ((Menu)SwingUtilities.getWindowAncestor(this)).verB();
    }//GEN-LAST:event_volverButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insertarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel origenLabel;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
