/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.ClientesController;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import hawac.Application;
import javax.swing.JOptionPane;
/*import ferreteria.Application;
import ferreteria.presentacion.controller.ClientesController;
import ferreteria.presentacion.model.ClientesModel;*/
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class ClientesView extends javax.swing.JInternalFrame implements java.util.Observer {
    
    ClientesController controller;
    ClientesModel model;
   
    public ClientesController getController() {
        return controller;
    }

    public ClientesModel getModel() {
        return model;
    }

    public void setController(ClientesController controller) {
        this.controller = controller;
    }

    public void setModel(ClientesModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ClientesView() {
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

        Busqueda = new javax.swing.ButtonGroup();
        nombreLb = new javax.swing.JLabel();
        nombreTextFd = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        agregarButton = new javax.swing.JButton();
        agregarLb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        eliminarLb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        IdRadioButton = new javax.swing.JRadioButton();
        NombreRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Catálogo de Clientes");

        nombreLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nombreLb.setText("Seleccione el argumento a buscar");

        nombreTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        agregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/addUser.png"))); // NOI18N
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        agregarLb.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        agregarLb.setText("Agregar");

        clientesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        clientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientesTable);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/deleteUser.png"))); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        eliminarLb.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        eliminarLb.setText("Eliminar");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel1.setText("Buscar");

        Busqueda.add(IdRadioButton);
        IdRadioButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        IdRadioButton.setText("Id");
        IdRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdRadioButtonActionPerformed(evt);
            }
        });

        Busqueda.add(NombreRadioButton);
        NombreRadioButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        NombreRadioButton.setText("Nombre");
        NombreRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreRadioButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Ver Todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLb, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NombreRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(IdRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarLb))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarLb))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreLb)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(agregarLb)
                    .addComponent(eliminarLb))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
       Application.CLIENTE_VIEW.setLocation(this.agregarButton.getLocationOnScreen());
       controller.preAgregar();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
      if(IdRadioButton.isSelected()==false && NombreRadioButton.isSelected()==false){
              nombreLb.setBorder(Application.BORDER_ERROR);
              nombreLb.setToolTipText(model.getErrores().get("nombreTextFd"));
        }else{
                nombreLb.setBorder(null);
                nombreLb.setToolTipText("");
                if(NombreRadioButton.isSelected()==true && nombreTextFd.getText().length()==0){
                    model.getErrores().put("nombreTextFd","Digite la descripcion a buscar");
                    nombreLb.setBorder(Application.BORDER_ERROR);
                    nombreLb.setToolTipText(model.getErrores().get("nombreTextFd"));
                }
                if(NombreRadioButton.isSelected()==true && nombreTextFd.getText().length()!=0){
                    controller.buscarPorNombre();
                }
                if(IdRadioButton.isSelected()==true && nombreTextFd.getText().length()==0){
                    model.getErrores().put("nombreTextFd","Digite la descripcion a buscar");
                    nombreLb.setBorder(Application.BORDER_ERROR);
                    nombreLb.setToolTipText(model.getErrores().get("nombreTextFd"));
                }
                if(IdRadioButton.isSelected()==true && nombreTextFd.getText().length()!=0){
                    controller.buscarPorId();
                }
      }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTableMouseClicked
        if (evt.getClickCount() == 2) {
            int row = this.clientesTable.getSelectedRow();
            Application.CLIENTE_VIEW.setLocation(evt.getLocationOnScreen());
            controller.editar(row);
        }
    }//GEN-LAST:event_clientesTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = this.clientesTable.getSelectedRow();
        if (row != -1) {
            int ax = JOptionPane.showConfirmDialog(null, "Estas seguro que desea eliminarlo?");
            if (ax == JOptionPane.YES_OPTION) {
                controller.borrar(row);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void IdRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdRadioButtonActionPerformed

    private void NombreRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreRadioButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        nombreTextFd.setText(model.getFilter().getNombre());
        if(model.getErrores().get("nombreTextFd")!=null){
            nombreLb.setBorder(Application.BORDER_ERROR);
            nombreLb.setToolTipText(model.getErrores().get("nombreTextFd"));
        }
        else{
            nombreLb.setBorder(null);
            nombreLb.setToolTipText("");
        }
        clientesTable.setModel(model.getClientes());
        this.revalidate();
        
        /*
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        } 
        */
   
        clientesTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        clientesTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        clientesTable.getColumnModel().getColumn(1).setPreferredWidth(30);

        
        if (Application.USUARIO != null && Application.USUARIO.getTipo() != 0) {
            deleteButton.setVisible(false);
            eliminarLb.setVisible(false);
        }
       /* clientesTable.getColumnModel().getColumn(2).setPreferredWidth(110);
        clientesTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        clientesTable.getColumnModel().getColumn(4).setPreferredWidth(30);*/

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
                new ClientesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Busqueda;
    private javax.swing.JRadioButton IdRadioButton;
    private javax.swing.JRadioButton NombreRadioButton;
    public javax.swing.JButton agregarButton;
    public javax.swing.JLabel agregarLb;
    private javax.swing.JTable clientesTable;
    public javax.swing.JButton deleteButton;
    public javax.swing.JLabel eliminarLb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreLb;
    public javax.swing.JTextField nombreTextFd;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
