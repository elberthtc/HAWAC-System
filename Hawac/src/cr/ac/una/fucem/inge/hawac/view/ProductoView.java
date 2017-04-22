/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;
import cr.ac.una.fucem.inge.hawac.controller.ProductoController;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import hawac.Application;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class ProductoView extends javax.swing.JDialog implements java.util.Observer{

    
    ProductoModel model;
    ProductoController controller;
       
    public ProductoModel getModel() {
        return model;
    }

    public ProductoController getController() {
        return controller;
    }

    public void setModel(cr.ac.una.fucem.inge.hawac.model.ProductoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(cr.ac.una.fucem.inge.hawac.controller.ProductoController controller) {
        this.controller = controller;
    }
    
    public ProductoView(java.awt.Frame parent, boolean modal) {
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

        generoBG = new javax.swing.ButtonGroup();
        inventarioBG = new javax.swing.ButtonGroup();
        DescripcionLabel = new javax.swing.JLabel();
        CodigoLabel = new javax.swing.JLabel();
        PrecioLabel = new javax.swing.JLabel();
        CodigoText = new javax.swing.JTextField();
        DescripcionText = new javax.swing.JTextField();
        PrecioText = new javax.swing.JTextField();
        AgregarButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ColorLabel = new javax.swing.JLabel();
        ColorText = new javax.swing.JTextField();
        GeneroLabel = new javax.swing.JLabel();
        masculinoRB = new javax.swing.JRadioButton();
        femeninoRB = new javax.swing.JRadioButton();
        tallaLabel = new javax.swing.JLabel();
        tallaCB = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTO");

        DescripcionLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        DescripcionLabel.setText("Descripción");

        CodigoLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        CodigoLabel.setText("Código");

        PrecioLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        PrecioLabel.setText("Precio");

        CodigoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DescripcionText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PrecioText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PrecioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioTextActionPerformed(evt);
            }
        });

        AgregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/save2.png"))); // NOI18N
        AgregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarButtonActionPerformed(evt);
            }
        });

        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/cancel.png"))); // NOI18N
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel1.setText("Guardar");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel2.setText("Salir");

        ColorLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ColorLabel.setText("Color");

        ColorText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ColorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorTextActionPerformed(evt);
            }
        });

        GeneroLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        GeneroLabel.setText("Género");

        generoBG.add(masculinoRB);
        masculinoRB.setText("Masculino");
        masculinoRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoRBActionPerformed(evt);
            }
        });

        generoBG.add(femeninoRB);
        femeninoRB.setText("Femenino");

        tallaLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tallaLabel.setText("Talla");

        tallaCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4", "6", "8", "10", "12", "14", "16XXS", "XS", "S", "M", "L", "XL", "XXL", "XXXL", "4XL" }));
        tallaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallaCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CodigoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DescripcionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PrecioLabel))
                            .addComponent(ColorLabel)
                            .addComponent(GeneroLabel)
                            .addComponent(tallaLabel))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ColorText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CodigoText, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrecioText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tallaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(masculinoRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(femeninoRB)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(146, 146, 146)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescripcionLabel)
                    .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecioLabel)
                    .addComponent(PrecioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ColorLabel)
                    .addComponent(ColorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GeneroLabel)
                    .addComponent(masculinoRB)
                    .addComponent(femeninoRB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tallaLabel)
                    .addComponent(tallaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarButtonActionPerformed
       controller.guardar();
    }//GEN-LAST:event_AgregarButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ColorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColorTextActionPerformed

    private void masculinoRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculinoRBActionPerformed

    private void tallaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tallaCBActionPerformed

    private void PrecioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioTextActionPerformed

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        Producto current = model.getCurrent();
        this.CodigoText.setEnabled(model.getModo() == Application.MODO_AGREGAR);
        
        if(current.getIdProducto()<=0)
            this.CodigoText.setText("");
        else
            this.CodigoText.setText(current.getIdProducto()+"");
        if (model.getErrores().get("Codigo") != null) {
            CodigoLabel.setBorder(Application.BORDER_ERROR);
            CodigoLabel.setToolTipText(model.getErrores().get("Codigo"));
        } else {
            CodigoLabel.setBorder(null);
            CodigoLabel.setToolTipText("");
        }
        
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        this.DescripcionText.setEnabled(editable);
        this.DescripcionText.setText(current.getDescripcion());
        if (model.getErrores().get("Descripcion") != null) {
            DescripcionLabel.setBorder(Application.BORDER_ERROR);
            DescripcionLabel.setToolTipText(model.getErrores().get("Descripcion"));
        } else {
            DescripcionLabel.setBorder(null);
            DescripcionLabel.setToolTipText("");
        }
        
        this.ColorText.setEnabled(editable);
        this.ColorText.setText(current.getColor());
        if (model.getErrores().get("Descripcion") != null) {
            ColorLabel.setBorder(Application.BORDER_ERROR);
            ColorLabel.setToolTipText(model.getErrores().get("Descripcion"));
        } else {
            ColorLabel.setBorder(null);
            ColorLabel.setToolTipText("");
        }
                

        this.PrecioText.setEnabled(editable);
        String prec = String.valueOf(current.getPrecio());
        if(current.getPrecio() == 0){
            this.PrecioText.setText("");
        }
        else
            this.PrecioText.setText(prec);
        if (model.getErrores().get("Precio") != null) {
            PrecioLabel.setBorder(Application.BORDER_ERROR);
            PrecioLabel.setToolTipText(model.getErrores().get("Precio"));
        } else {
            PrecioLabel.setBorder(null);
            PrecioLabel.setToolTipText("");
        }
        
        tallaCB.setEnabled(editable);
        if(editable)
            this.tallaCB.setSelectedItem(current.getTalla());
        
        if(current.isGenero()){
            masculinoRB.setSelected(true);
        }
        else
            femeninoRB.setSelected(true);
        
        AgregarButton.setVisible(editable);
        this.validate();
        if (!model.getMensaje().equals("")) {
            JOptionPane.showMessageDialog(this, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoView dialog = new ProductoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton AgregarButton;
    private javax.swing.JLabel CodigoLabel;
    public javax.swing.JTextField CodigoText;
    public javax.swing.JLabel ColorLabel;
    public javax.swing.JTextField ColorText;
    private javax.swing.JLabel DescripcionLabel;
    public javax.swing.JTextField DescripcionText;
    private javax.swing.JButton ExitButton;
    public javax.swing.JLabel GeneroLabel;
    public javax.swing.JLabel PrecioLabel;
    public javax.swing.JTextField PrecioText;
    public javax.swing.JRadioButton femeninoRB;
    private javax.swing.ButtonGroup generoBG;
    private javax.swing.ButtonGroup inventarioBG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JRadioButton masculinoRB;
    public javax.swing.JComboBox tallaCB;
    public javax.swing.JLabel tallaLabel;
    // End of variables declaration//GEN-END:variables

}
