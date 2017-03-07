
package cr.ac.una.fucem.inge.hawac.view;


import cr.ac.una.fucem.inge.hawac.controller.UsuarioController;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import hawac.Application;
import java.util.Arrays;
import javax.swing.JOptionPane;



public class UsuarioView extends javax.swing.JDialog implements java.util.Observer {

    UsuarioController controller;
    UsuarioModel model;
    
    public UsuarioView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setController(cr.ac.una.fucem.inge.hawac.controller.UsuarioController controller){
        this.controller=controller;
    }
    public UsuarioController  getController(){
        return controller;
    }
    
    public void setModelo(cr.ac.una.fucem.inge.hawac.model.UsuarioModel model){
        this.model=model;

        
        model.addObserver(this);
    }
    
    public UsuarioModel getModelo(){
        return model;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoUsuario = new javax.swing.ButtonGroup();
        NombreLb = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        IdLb = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        RolLb = new javax.swing.JLabel();
        guardarjButton = new javax.swing.JButton();
        canceljButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        administradorRB = new javax.swing.JRadioButton();
        dependienteRB = new javax.swing.JRadioButton();
        passwordLB = new javax.swing.JLabel();
        passwordText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empleado");

        NombreLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        NombreLb.setText("Nombre :");

        idTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        IdLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        IdLb.setText("Id :");

        nombreTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        RolLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        RolLb.setText("Rol :");

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

        tipoUsuario.add(administradorRB);
        administradorRB.setText("Administrador");

        tipoUsuario.add(dependienteRB);
        dependienteRB.setText("Dependiente");

        passwordLB.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        passwordLB.setText("Password:");

        passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdLb)
                            .addComponent(NombreLb)
                            .addComponent(RolLb))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(guardarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(administradorRB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dependienteRB)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel5))
                                        .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passwordLB)
                        .addGap(18, 18, 18)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLb)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(administradorRB)
                    .addComponent(dependienteRB)
                    .addComponent(RolLb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canceljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
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

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextActionPerformed

   
      public void update(java.util.Observable o, Object arg) {
        Usuario current = model.getCurrent();
        this.idTextField.setEnabled(model.getModo()== Application.MODO_AGREGAR);
        this.idTextField.setText(current.getIdUsuario()+":P");
        if(model.getErrores().get("Id")!= null){
            IdLb.setBorder(Application.BORDER_ERROR);
            IdLb.setToolTipText(model.getErrores().get("id"));
        }else{
            IdLb.setBorder(null);
            IdLb.setToolTipText("");
        }
        
        this.passwordText.setText(current.getPassword()+":B");
        if(model.getErrores().get("Password")!= null){
            passwordLB.setBorder(Application.BORDER_ERROR);
            passwordLB.setToolTipText(model.getErrores().get("password"));
        }else{
            passwordLB.setBorder(null);
            passwordLB.setToolTipText("");
        }
        
        
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        nombreTextField.setEnabled(editable);
        nombreTextField.setText(current.getNombre());
        if(model.getErrores().get("Nombre")!= null){
            NombreLb.setBorder(Application.BORDER_ERROR);
            NombreLb.setToolTipText(model.getErrores().get("Nombre"));
        }else{
            NombreLb.setBorder(null);
            NombreLb.setToolTipText("");
        }
        administradorRB.setEnabled(editable);
        dependienteRB.setEnabled(editable);
        guardarjButton.setVisible(editable);
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
      });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdLb;
    private javax.swing.JLabel NombreLb;
    private javax.swing.JLabel RolLb;
    public javax.swing.JRadioButton administradorRB;
    private javax.swing.JButton canceljButton;
    public javax.swing.JRadioButton dependienteRB;
    private javax.swing.JButton guardarjButton;
    public javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel passwordLB;
    public javax.swing.JTextField passwordText;
    private javax.swing.ButtonGroup tipoUsuario;
    // End of variables declaration//GEN-END:variables


}
