/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;
import cr.ac.una.fucem.inge.hawac.controller.LoginController;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.model.LoginModel;
import hawac.Application;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class LoginView extends javax.swing.JFrame implements java.util.Observer {
    LoginController controller;
    LoginModel model;
    
    public LoginView() {
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

        idLabel = new javax.swing.JLabel();
        claveLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        claveTextField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACCESO AL SISTEMA");
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/user.png"))).getImage());
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        idLabel.setText("Id:");

        claveLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        claveLabel.setText("Clave:");

        idTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        idTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idTextFieldKeyReleased(evt);
            }
        });

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/login2.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/exit2.png"))); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        claveTextField.setToolTipText("");
        claveTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        claveTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                claveTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel2.setText("EXIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(17, 164, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(claveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField)
                            .addComponent(claveTextField))
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        this.controller.login();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.controller.exit();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            controller.login();
        }
        else{
            JOptionPane.showMessageDialog(this,evt.getKeyCode() + "   " + KeyEvent.VK_ENTER);
        }
    }//GEN-LAST:event_formKeyPressed

    private void idTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextFieldKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            controller.login();
        }
    }//GEN-LAST:event_idTextFieldKeyReleased

    private void claveTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveTextFieldKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            controller.login();
        }
    }//GEN-LAST:event_claveTextFieldKeyReleased

    public LoginController getController() {
        return controller;
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public void setModel(LoginModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public LoginModel getModel() {    
        return model;
    }
    @Override
    public void update(java.util.Observable updatedModel,Object parametros){
        Usuario current = model.getCurrent();
        if(current.getIdUsuario()<=0)
            idTextField.setText("");
        else
            idTextField.setText(current.getIdUsuario()+"");
        if(model.getErrores().get("Id")!= null){
            idLabel.setBorder(Application.BORDER_ERROR);
            idLabel.setToolTipText(model.getErrores().get("Id"));
        }else{
            idLabel.setBorder(null);
            idLabel.setToolTipText("");
        }
        claveTextField.setText(current.getPassword());
        if(model.getErrores().get("Clave") != null){
            claveLabel.setBorder(Application.BORDER_ERROR);
            claveLabel.setToolTipText(model.getErrores().get("Clave"));
        }else{
           claveLabel.setBorder(null);
           claveLabel.setToolTipText("");
        }
        this.validate();
        if(!model.getMensaje().equals("")){
             JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel claveLabel;
    public javax.swing.JPasswordField claveTextField;
    private javax.swing.JButton exitButton;
    public javax.swing.JLabel idLabel;
    public javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables

}
    
     

       
  
