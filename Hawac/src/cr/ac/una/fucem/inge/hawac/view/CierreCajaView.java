/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;
import cr.ac.una.fucem.inge.hawac.controller.CierreCajaController;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.CierreCajaModel;
import hawac.Application;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CierreCajaView extends javax.swing.JInternalFrame implements java.util.Observer {

    CierreCajaController controller;
    CierreCajaModel model;
    
    public CierreCajaView() {
         super("",false,true);
         initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busquedaBG = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        hoyB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        totalL = new javax.swing.JLabel();
        montoL = new javax.swing.JLabel();
        habilitarCB = new javax.swing.JCheckBox();
        fecha1 = new com.toedter.calendar.JDateChooser();
        fecha2 = new com.toedter.calendar.JDateChooser();
        deL = new javax.swing.JLabel();
        aL = new javax.swing.JLabel();
        buscarB = new javax.swing.JButton();
        buscarL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("FACTURAS PAGADAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaFacturas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 67, 550, 360));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("CIERRE DE CAJA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 0, -1, -1));

        hoyB.setText("Vendido Hoy");
        hoyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoyBActionPerformed(evt);
            }
        });
        getContentPane().add(hoyB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("                                                                                FACTURAS");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 44, 547, -1));

        totalL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalL.setText("TOTAL:");
        getContentPane().add(totalL, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, -1, -1));

        montoL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(montoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 66, 21));

        habilitarCB.setText("Buscar entre Fechas");
        habilitarCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarCBActionPerformed(evt);
            }
        });
        getContentPane().add(habilitarCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));
        getContentPane().add(fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));
        getContentPane().add(fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        deL.setText("De:");
        getContentPane().add(deL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        aL.setText("A:");
        getContentPane().add(aL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        buscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBActionPerformed(evt);
            }
        });
        getContentPane().add(buscarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 42, -1));

        buscarL.setText("Buscar");
        getContentPane().add(buscarL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hoyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoyBActionPerformed
       controller.vendidoHoyB();
    }//GEN-LAST:event_hoyBActionPerformed

    private void habilitarCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarCBActionPerformed
        // TODO add your handling code here:
        if(habilitarCB.isSelected()){
            fecha1.setVisible(true);
            fecha2.setVisible(true);
            deL.setVisible(true);
            aL.setVisible(true);
            buscarL.setVisible(true);
            buscarB.setVisible(true);
        } else{
            fecha1.setVisible(false);
            fecha2.setVisible(false);
            deL.setVisible(false);
            aL.setVisible(false);
            buscarL.setVisible(false);
            buscarB.setVisible(false);
        }
    }//GEN-LAST:event_habilitarCBActionPerformed

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        Date a = fecha1.getDate();
        a.setHours(0);
        a.setMinutes(0);
        a.setSeconds(0);
        Date b = fecha2.getDate();
        b.setHours(0);
        b.setMinutes(0);
        b.setSeconds(0);
        if(a!=null && b!=null){
            controller.vendidoEntreFechasB(a, b);
        } else
            JOptionPane.showMessageDialog(this, "Por Favor seleccione las fechas correspondientes a la Busqueda");
    }//GEN-LAST:event_buscarBActionPerformed

    public CierreCajaController getController() {
        return controller;
    }

    public CierreCajaModel getModel() {
        return model;
    }

    public void setController(CierreCajaController controller) {
        this.controller = controller;
    }

    public void setModel(CierreCajaModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
   @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        tablaFacturas.setModel(model.getFacturas());
        if(habilitarCB.isSelected()){
            fecha1.setVisible(true);
            fecha2.setVisible(true);
            deL.setVisible(true);
            aL.setVisible(true);
            buscarL.setVisible(true);
            buscarB.setVisible(true);
        } else{
            fecha1.setVisible(false);
            fecha2.setVisible(false);
            deL.setVisible(false);
            aL.setVisible(false);
            buscarL.setVisible(false);
            buscarB.setVisible(false);
        }
        this.revalidate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
        tablaFacturas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaFacturas.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaFacturas.getColumnModel().getColumn(1).setPreferredWidth(40);
        tablaFacturas.getColumnModel().getColumn(2).setPreferredWidth(40);
        tablaFacturas.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablaFacturas.getColumnModel().getColumn(4).setPreferredWidth(30);
    }
    
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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CierreCajaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aL;
    private javax.swing.JButton buscarB;
    private javax.swing.JLabel buscarL;
    private javax.swing.ButtonGroup busquedaBG;
    private javax.swing.JLabel deL;
    private com.toedter.calendar.JDateChooser fecha1;
    private com.toedter.calendar.JDateChooser fecha2;
    private javax.swing.JCheckBox habilitarCB;
    public javax.swing.JButton hoyB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel montoL;
    public javax.swing.JTable tablaFacturas;
    private javax.swing.JLabel totalL;
    // End of variables declaration//GEN-END:variables
}
