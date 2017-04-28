package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.UsuariosController;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import hawac.Application;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class UsuariosView extends javax.swing.JInternalFrame implements java.util.Observer {
    UsuariosController controller;
    UsuariosModel model;
    /**
     * Creates new form UsuariosView
     */
    public UsuariosView() {
        super("",false,true);
        initComponents();
    }

    public void setController(UsuariosController controller) {
        this.controller = controller;
    }

    public UsuariosModel getModel() {
        return model;
    }

    public void setModel(UsuariosModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public UsuariosController getController() {
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
        nomjTextField = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        agregarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        eliminarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        IdRadioButton = new javax.swing.JRadioButton();
        NombreRadioButton = new javax.swing.JRadioButton();
        verTodoB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Planilla De Empleados");

        nombreLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nombreLb.setText("Seleccione el argumento a buscar");

        nomjTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nomjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomjTextFieldActionPerformed(evt);
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

        agregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/addUser.png"))); // NOI18N
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel2.setText("Agregar");

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

        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/deleteUser.png"))); // NOI18N
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel3.setText("Eliminar");

        busqueda.add(IdRadioButton);
        IdRadioButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        IdRadioButton.setText("Id");
        IdRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdRadioButtonActionPerformed(evt);
            }
        });

        busqueda.add(NombreRadioButton);
        NombreRadioButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        NombreRadioButton.setText("Nombre");

        verTodoB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        verTodoB.setText("Ver Todo");
        verTodoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodoBActionPerformed(evt);
            }
        });

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
                            .addComponent(jLabel2)
                            .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nombreLb)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verTodoB))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IdRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombreRadioButton)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreLb)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verTodoB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreRadioButton)
                    .addComponent(IdRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        if (IdRadioButton.isSelected() == false && NombreRadioButton.isSelected() == false) {
            nombreLb.setBorder(Application.BORDER_ERROR);
            nombreLb.setToolTipText(model.getErrores().get("nomjTextField"));
        } else {
            nombreLb.setBorder(null);
            nombreLb.setToolTipText("");
            if (NombreRadioButton.isSelected() == true && nomjTextField.getText().length() == 0) {
                model.getErrores().put("nombreTextFd", "Digite el nombre a buscar");
                nombreLb.setBorder(Application.BORDER_ERROR);
                nombreLb.setToolTipText(model.getErrores().get("nomjTextField"));
            }
            if (NombreRadioButton.isSelected() == true && nomjTextField.getText().length() != 0) {
                controller.buscarPorNombre();
            }
            if (IdRadioButton.isSelected() == true && nomjTextField.getText().length() == 0) {
                model.getErrores().put("nombreTextFd", "Digite la identificación a buscar");
                nombreLb.setBorder(Application.BORDER_ERROR);
                nombreLb.setToolTipText(model.getErrores().get("nomjTextField"));
            }
            if (IdRadioButton.isSelected() == true && nomjTextField.getText().length() != 0) {
                controller.buscarPorId();
            }
        }
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        Application.EMPLEADO_VIEW.setLocation(this.verTodoB.getLocationOnScreen());
        controller.preAgregar();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
         int fila=this.tablaEmpleados.getSelectedRow();
            if(fila!=-1){
            int resp= JOptionPane.showConfirmDialog(this,"¿Desea eliminar al empleado?");
            if(resp==JOptionPane.YES_OPTION){
                controller.borrar(fila);
            }
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
         if(evt.getClickCount()==2){
            int fila=this.tablaEmpleados.getSelectedRow();
            Application.EMPLEADO_VIEW.setLocation(evt.getLocationOnScreen());
            controller.editar(fila);
        }

    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void nomjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjTextFieldActionPerformed

    private void IdRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdRadioButtonActionPerformed

    private void verTodoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoBActionPerformed
        // TODO add your handling code here:
        controller.buscar();
    }//GEN-LAST:event_verTodoBActionPerformed

    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        if(model.getFiltro().getNombre().length()==0 && model.getFiltro().getIdUsuario() == 0){
            nomjTextField.setText(model.getFiltro().getNombre());
        } else if(model.getFiltro().getNombre().length()==0){
            nomjTextField.setText(model.getFiltro().getIdUsuario()+"");
        } else
            nomjTextField.setText(model.getFiltro().getNombre());
        
        if(model.getErrores().get("nomjTextField")!= null){
            nombreLb.setBorder(Application.BORDER_ERROR);
            nombreLb.setToolTipText(model.getErrores().get("nomjTextField"));
        }else{
             nombreLb.setBorder(null);
             nombreLb.setToolTipText("");
        }
        tablaEmpleados.setModel(model.getUsuarios());
        this.revalidate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
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
                new UsuariosView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton IdRadioButton;
    private javax.swing.JRadioButton NombreRadioButton;
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.ButtonGroup busqueda;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreLb;
    public javax.swing.JTextField nomjTextField;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JButton verTodoB;
    // End of variables declaration//GEN-END:variables
}
