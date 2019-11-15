/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JDialog;

/**
 *
 * @author alumno
 */
public class Menu extends javax.swing.JFrame {
    InicioSesion in;
    VerB b;
    VerC c;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        jMenuBar1.setVisible(false);
        in = new InicioSesion();
        this.setContentPane(in);
        this.pack();
    }
    
    public void setBC(VerB bb,VerC cc){
        b=bb;
        c=cc;
    }
    
    public void verB(){
        jMenuBar1.setVisible(true);
        this.setContentPane(b);
        this.pack();
    }
    
    public void verC(){
        this.setContentPane(c);
        this.pack();
    }
    
    public void insertarB(){
        this.setContentPane(new InsertarB());
        this.pack();
    }
    
    public void incertarC(){
        this.setContentPane(new InsertarC());
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        InicioSesionMenuItem = new javax.swing.JMenuItem();
        AcercaDeMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Menu");

        InicioSesionMenuItem.setText("Cambiar Usuario");
        InicioSesionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSesionMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(InicioSesionMenuItem);

        AcercaDeMenuItem.setText("AcercaDe");
        AcercaDeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercaDeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(AcercaDeMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InicioSesionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioSesionMenuItemActionPerformed
        // TODO add your handling code here:
        this.setContentPane(in);
        this.pack();
    }//GEN-LAST:event_InicioSesionMenuItemActionPerformed

    private void AcercaDeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercaDeMenuItemActionPerformed
        // TODO add your handling code here:
        JDialog j= new AcercaDe(this, true);
        j.setVisible(true);
    }//GEN-LAST:event_AcercaDeMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AcercaDeMenuItem;
    private javax.swing.JMenuItem InicioSesionMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
