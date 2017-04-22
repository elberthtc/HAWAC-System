package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.InventarioController;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.model.InventarioModel;
import hawac.Application;
import java.util.Arrays;
import javax.swing.JOptionPane;



public class InventarioView extends javax.swing.JDialog implements java.util.Observer {

    InventarioController controller;
    InventarioModel model;
    
    public InventarioView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setController(cr.ac.una.fucem.inge.hawac.controller.InventarioController controller){
        this.controller=controller;
    }
    public InventarioController  getController(){
        return controller;
    }
    
    public void setModelo(cr.ac.una.fucem.inge.hawac.model.InventarioModel model){
        this.model=model;

        
        model.addObserver(this);
    }
    
    public InventarioModel getModelo(){
        return model;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cantidadLb = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        productoLb = new javax.swing.JLabel();
        cantidadTextField = new javax.swing.JTextField();
        guardarjButton = new javax.swing.JButton();
        canceljButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        estadoLb = new javax.swing.JLabel();
        buscarB = new javax.swing.JButton();
        estadoCB = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGREGAR AL INVENTARIO");

        cantidadLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cantidadLb.setText("Cantidad:");

        idTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        productoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        productoLb.setText("Producto:");

        cantidadTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cantidadTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadTextFieldActionPerformed(evt);
            }
        });

        guardarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/save2.png"))); // NOI18N
        guardarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarjButtonActionPerformed(evt);
            }
        });

        canceljButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/cancel.png"))); // NOI18N
        canceljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceljButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel4.setText("Guardar");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel5.setText("Salir");

        estadoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        estadoLb.setText("Estado:");

        buscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBActionPerformed(evt);
            }
        });

        estadoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Espera", "En Proceso", "Listo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productoLb)
                    .addComponent(cantidadLb)
                    .addComponent(estadoLb))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(guardarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(productoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadLb)
                    .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
       
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void guardarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarjButtonActionPerformed
        this.controller.guardar();
    }//GEN-LAST:event_guardarjButtonActionPerformed

    private void canceljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceljButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_canceljButtonActionPerformed

    private void cantidadTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadTextFieldActionPerformed

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        this.setVisible(false);
        controller.abrirProductos();
    }//GEN-LAST:event_buscarBActionPerformed

   
    public void update(java.util.Observable o, Object arg) {
        Producto current = model.getProductoActual();
        Inventario inv = model.getCurrent();
        if (current.getIdProducto() == -1) {
            this.idTextField.setText("");
            this.idTextField.setEnabled(false);
        } else {
            this.idTextField.setText(current.getIdProducto() + "");
            this.idTextField.setEnabled(false);
        }
        if (model.getErrores().get("Id") != null) {
            productoLb.setBorder(Application.BORDER_ERROR);
            productoLb.setToolTipText(model.getErrores().get("id"));
        } else {
            productoLb.setBorder(null);
            productoLb.setToolTipText("");
        }

        if(inv.getCantidad()==-1){
            cantidadTextField.setText("");
        } else
            cantidadTextField.setText(inv.getCantidad()+"");
        
        if (model.getErrores().get("cantidad") != null) {
            estadoLb.setBorder(Application.BORDER_ERROR);
            estadoLb.setToolTipText(model.getErrores().get("cantidad"));
        } else {
            estadoLb.setBorder(null);
            estadoLb.setToolTipText("");
        }

        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        //cantidadTextField.setEnabled(editable);
        // nombreTextField.setText(current.getNombre());
        /*if (model.getErrores().get("Nombre") != null) {
            cantidadLb.setBorder(Application.BORDER_ERROR);
            cantidadLb.setToolTipText(model.getErrores().get("Nombre"));
        } else {
            cantidadLb.setBorder(null);
            cantidadLb.setToolTipText("");
        }
        */
        
        if(inv.getEstado().compareTo("")!=0){
            estadoCB.setSelectedItem(inv.getEstado());
        }

        guardarjButton.setVisible(editable);
        this.validate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }

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
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
      });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buscarB;
    private javax.swing.JButton canceljButton;
    private javax.swing.JLabel cantidadLb;
    public javax.swing.JTextField cantidadTextField;
    public javax.swing.JComboBox estadoCB;
    private javax.swing.JLabel estadoLb;
    private javax.swing.JButton guardarjButton;
    public javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel productoLb;
    // End of variables declaration//GEN-END:variables


}
