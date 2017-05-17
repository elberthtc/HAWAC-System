/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.ClienteController;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.model.ClienteModel;
import hawac.Application;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ClienteView extends javax.swing.JDialog implements java.util.Observer{

    ClienteModel model;
    ClienteController controller;
    
    public ClienteView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        nombreLb = new javax.swing.JLabel();
        idLb = new javax.swing.JLabel();
        numTelefonoLb = new javax.swing.JLabel();
        CorreoLb = new javax.swing.JLabel();
        nombreTextFd = new javax.swing.JTextField();
        numTelefonoTextFd = new javax.swing.JTextField();
        correoTextFd = new javax.swing.JTextField();
        idTextFd = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTE");

        nombreLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nombreLb.setText("Nombre");

        idLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        idLb.setText("Cédula");

        numTelefonoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        numTelefonoLb.setText("Numero Telefono");

        CorreoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        CorreoLb.setText("Correo");

        nombreTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombreTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFdActionPerformed(evt);
            }
        });

        numTelefonoTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        correoTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        idTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/save2.png"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/cancel.png"))); // NOI18N
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Guardar");

        jLabel2.setText("Salir");

        jLabel3.setText("9 caracateres númericos)");

        jLabel4.setText("(8 digitos)");

        jLabel5.setText("Ej: xyz@ejem.com");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numTelefonoLb)
                            .addComponent(CorreoLb)
                            .addComponent(nombreLb)
                            .addComponent(idLb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(correoTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numTelefonoTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(nombreTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLb))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLb)
                    .addComponent(idTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numTelefonoLb)
                    .addComponent(numTelefonoTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CorreoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correoTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFdActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       controller.guardar();
    }//GEN-LAST:event_saveButtonActionPerformed

    public ClienteModel getModel() {
        return model;
    }

    public ClienteController getController() {
        return controller;
    }

    public void setModel(cr.ac.una.fucem.inge.hawac.model.ClienteModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(cr.ac.una.fucem.inge.hawac.controller.ClienteController controller) {
        this.controller = controller;
    }
    
  
    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        Cliente current = model.getCurrent();
        this.idTextFd.setEnabled(model.getModo()==Application.MODO_AGREGAR);
        if(current.getCedula()==-1){
            idTextFd.setText("");
        } else {
            idTextFd.setText(current.getCedula()+"");
        }
         if (model.getErrores().get("Id")!=null){
            idLb.setBorder(Application.BORDER_ERROR);
            idLb.setToolTipText(model.getErrores().get("Id"));
         }
         else{
            idLb.setBorder(null);
            idLb.setToolTipText("");
          }
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        
        nombreTextFd.setEnabled(editable);
        nombreTextFd.setText(current.getNombre());
        if(model.getErrores().get("Nombre")!= null){
            nombreLb.setBorder(Application.BORDER_ERROR);
            nombreLb.setToolTipText(model.getErrores().get("Nombre"));
        }else{
            nombreLb.setBorder(null);
            nombreLb.setToolTipText("");
        }
        
        numTelefonoTextFd.setEnabled(editable);
        numTelefonoTextFd.setText(current.getTelefono());
        if(model.getErrores().get("Telefono")!= null){
            numTelefonoLb.setBorder(Application.BORDER_ERROR);
            numTelefonoLb.setToolTipText(model.getErrores().get("Numero Telefono"));
        }else{
            numTelefonoLb.setBorder(null);
            numTelefonoLb.setToolTipText("");
        }
        
        correoTextFd.setEnabled(editable);
        correoTextFd.setText(current.getCorreo());
        if(model.getErrores().get("Correo")!= null){
            CorreoLb.setBorder(Application.BORDER_ERROR);
            CorreoLb.setToolTipText(model.getErrores().get("Correo"));
        }else{
            CorreoLb.setBorder(null);
            CorreoLb.setToolTipText("");
        }
        
        saveButton.setVisible(editable);
        this.validate();
        if (!model.getMensaje().equals("")){
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
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteView dialog = new ClienteView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel CorreoLb;
    public javax.swing.JTextField correoTextFd;
    public javax.swing.JLabel idLb;
    public javax.swing.JTextField idTextFd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel nombreLb;
    public javax.swing.JTextField nombreTextFd;
    public javax.swing.JLabel numTelefonoLb;
    public javax.swing.JTextField numTelefonoTextFd;
    public javax.swing.JButton returnButton;
    public javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
