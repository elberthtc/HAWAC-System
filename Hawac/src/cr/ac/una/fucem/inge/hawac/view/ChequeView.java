/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;
/*import ferreteria.Application;
import ferreteriaentidades.Cheque;
import ferreteria.presentacion.controller.ChequeController;
import ferreteria.presentacion.controller.FacturaController;
import ferreteria.presentacion.controller.FacturasVentasController;
import ferreteria.presentacion.model.ChequeModel;*/
import cr.ac.una.fucem.inge.hawac.controller.ChequeController;
import cr.ac.una.fucem.inge.hawac.model.ChequeModel;
import javax.swing.JOptionPane;


public class ChequeView extends javax.swing.JDialog implements java.util.Observer {
    
    ChequeModel model;
    ChequeController controller;
    
    /**
     * Creates new form ChequeView
     * @param parent
     * @param modal
     */
    public ChequeView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ChequeModel getModel() {
        return model;
    }

    public ChequeController getController() {
        return controller;
    }

    public void setModel(cr.ac.una.fucem.inge.hawac.model.ChequeModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(cr.ac.una.fucem.inge.hawac.controller.ChequeController controller) {
        this.controller = controller;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TituloCheque = new javax.swing.JLabel();
        Numerodecheque = new javax.swing.JTextField();
        NChequeLabel = new javax.swing.JLabel();
        MontoLabel = new javax.swing.JLabel();
        Monto = new javax.swing.JTextField();
        PagarButton = new javax.swing.JButton();
        PagarLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TituloCheque.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        TituloCheque.setText(" Cheque");

        Numerodecheque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NChequeLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        NChequeLabel.setText("N° Cheque");

        MontoLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        MontoLabel.setText("Monto");

        Monto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PagarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/ferreteria/presentacion/view/icons/pagar.png"))); // NOI18N
        PagarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarButtonActionPerformed(evt);
            }
        });

        PagarLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        PagarLabel.setText("  Pagar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NChequeLabel)
                            .addComponent(MontoLabel))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Numerodecheque, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PagarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PagarLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TituloCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Numerodecheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NChequeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MontoLabel))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PagarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PagarLabel)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PagarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarButtonActionPerformed
        controller.registrarPago();
    }//GEN-LAST:event_PagarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChequeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChequeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChequeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChequeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChequeView dialog = new ChequeView(new javax.swing.JFrame(), true);
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
    public javax.swing.JTextField Monto;
    private javax.swing.JLabel MontoLabel;
    private javax.swing.JLabel NChequeLabel;
    public javax.swing.JTextField Numerodecheque;
    private javax.swing.JButton PagarButton;
    private javax.swing.JLabel PagarLabel;
    private javax.swing.JLabel TituloCheque;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        /*Cheque current = model.getCurrent();
        String ex = String.valueOf(current.getMonto());
        Monto.setText(ex);
         if (model.getErrores().get("Monto")!=null){
            MontoLabel.setBorder(Application.BORDER_ERROR);
            MontoLabel.setToolTipText(model.getErrores().get("Monto"));
         }
         else{
            MontoLabel.setBorder(null);
            MontoLabel.setToolTipText("");
          }
       
        String nx = String.valueOf(current.getNumeroCheque());
        Numerodecheque.setText(nx);
        if(model.getErrores().get("N° Cheque")!= null){
            NChequeLabel.setBorder(Application.BORDER_ERROR);
            NChequeLabel.setToolTipText(model.getErrores().get("N° Cheque"));
        }else{
            NChequeLabel.setBorder(null);
            NChequeLabel.setToolTipText("");
        }
        
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }*/
    }
}
