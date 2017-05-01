package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.InventariosController;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.utils.Validaciones;
import hawac.Application;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class InventariosView extends javax.swing.JInternalFrame implements java.util.Observer {
    InventariosController controller;
    InventariosModel model;
    /**
     * Creates new form UsuariosView
     */
    public InventariosView() {
        super("",false,true);
        initComponents();
    }

    public void setController(InventariosController controller) {
        this.controller = controller;
    }

    public InventariosModel getModel() {
        return model;
    }

    public void setModel(InventariosModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public InventariosController getController() {
        return controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busqueda = new javax.swing.ButtonGroup();
        nombreLb = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        agregarB = new javax.swing.JButton();
        agregarL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        eliminarB = new javax.swing.JButton();
        eliminarL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("INVENTARIO");

        nombreLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nombreLb.setText("Escriba el criterio a buscar");

        nombreTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombreTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTFActionPerformed(evt);
            }
        });

        buscarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel1.setText("Buscar");

        agregarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/agregar.png"))); // NOI18N
        agregarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBActionPerformed(evt);
            }
        });

        agregarL.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        agregarL.setText("Agregar");

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        eliminarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/cancel (2).png"))); // NOI18N
        eliminarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBActionPerformed(evt);
            }
        });

        eliminarL.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        eliminarL.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarL)
                            .addComponent(agregarB, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eliminarL)
                            .addComponent(eliminarB, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nombreLb)
                    .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarL)
                    .addComponent(eliminarL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregarB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        String key = nombreTF.getText();
        if(key.isEmpty())
            controller.buscar();
        else{
            if(Validaciones.isNumeric(key))
                controller.buscarPorId();
            else
                controller.buscarPorDescripcion();            
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void agregarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBActionPerformed
        Application.INVENTARIO_VIEW.setLocation(this.nombreTF.getLocationOnScreen());
        controller.preAgregar();
    }//GEN-LAST:event_agregarBActionPerformed

    private void eliminarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBActionPerformed
         int fila=this.tablaEmpleados.getSelectedRow();
            if(fila!=-1){
            int resp= JOptionPane.showConfirmDialog(this,"¿Desea eliminar el producto?");
            if(resp==JOptionPane.YES_OPTION){
                controller.borrar(fila);
            }
        }
    }//GEN-LAST:event_eliminarBActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
         if(evt.getClickCount()==2){
            int fila=this.tablaEmpleados.getSelectedRow();
            Application.INVENTARIO_VIEW.setLocation(evt.getLocationOnScreen());
            controller.editar(fila);
        }

    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void nombreTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTFActionPerformed

    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        if(model.getErrores().get("nomjTextField")!= null){
            nombreLb.setBorder(Application.BORDER_ERROR);
            nombreLb.setToolTipText(model.getErrores().get("nomjTextField"));
        }else{
             nombreLb.setBorder(null);
             nombreLb.setToolTipText("");
        }
        tablaEmpleados.setModel(model.getInventarios());
        this.revalidate(); 
        
        if(Application.USUARIO!=null && Application.USUARIO.tipo()!=0){
            agregarL.setVisible(false);
            agregarB.setVisible(false);
            eliminarL.setVisible(false);
            eliminarB.setVisible(false);
        }else{
            agregarL.setVisible(true);
            agregarB.setVisible(true);
            eliminarL.setVisible(true);
            eliminarB.setVisible(true);
        }
        
        tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaEmpleados.getColumnModel().getColumn(1).setPreferredWidth(30);
        tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(40);
  
        
    }

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
            public void run() {
                new InventariosView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarB;
    private javax.swing.JLabel agregarL;
    private javax.swing.JButton buscarButton;
    private javax.swing.ButtonGroup busqueda;
    private javax.swing.JButton eliminarB;
    private javax.swing.JLabel eliminarL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreLb;
    public javax.swing.JTextField nombreTF;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
