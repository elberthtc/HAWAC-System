/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.ClientesApartadoController;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import hawac.Application;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class ClientesApartadoView extends javax.swing.JInternalFrame implements java.util.Observer {
    
    ClientesApartadoController controller;
    ClientesModel model;
   
    public ClientesApartadoController getController() {
        return controller;
    }

    public ClientesModel getModel() {
        return model;
    }

    public void setController(ClientesApartadoController controller) {
        this.controller = controller;
    }

    public void setModel(ClientesModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ClientesApartadoView() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        IdRadioButton = new javax.swing.JRadioButton();
        NombreRadioButton = new javax.swing.JRadioButton();
        seleccionarButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        agregarLb = new javax.swing.JLabel();
        agregarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Catálogo de Clientes");

        nombreLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nombreLb.setText("Seleccione el argumento a buscar");

        nombreTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombreTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFdActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

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

        seleccionarButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        seleccionarButton.setText("Seleccionar");
        seleccionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Ver Todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        agregarLb.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        agregarLb.setText("Agregar");

        agregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/addUser.png"))); // NOI18N
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NombreRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IdRadioButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(nombreTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1))
                                .addComponent(nombreLb, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(seleccionarButton))
                                    .addComponent(agregarLb))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(nombreLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agregarLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    }//GEN-LAST:event_clientesTableMouseClicked

    private void IdRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdRadioButtonActionPerformed

    private void NombreRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreRadioButtonActionPerformed

    private void seleccionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarButtonActionPerformed
        int row = this.clientesTable.getSelectedRow();
        if(row != -1){
            controller.seleccionar(row);
        }
    }//GEN-LAST:event_seleccionarButtonActionPerformed

    private void nombreTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        Application.CLIENTE_VIEW.setLocation(this.agregarButton.getLocationOnScreen());
        controller.preAgregar();
    }//GEN-LAST:event_agregarButtonActionPerformed
 
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
        clientesTable.getColumnModel().getColumn(2).setPreferredWidth(110);
        clientesTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        //clientesTable.getColumnModel().getColumn(4).setPreferredWidth(30);

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
                new ClientesApartadoView().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreLb;
    public javax.swing.JTextField nombreTextFd;
    private javax.swing.JButton searchButton;
    public javax.swing.JButton seleccionarButton;
    // End of variables declaration//GEN-END:variables
}
