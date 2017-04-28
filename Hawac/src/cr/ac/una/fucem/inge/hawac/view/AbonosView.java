package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.AbonosController;
import cr.ac.una.fucem.inge.hawac.model.AbonosModel;
import hawac.Application;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbonosView extends javax.swing.JInternalFrame implements java.util.Observer {

    AbonosController controller;
    AbonosModel model;
    DefaultTableModel productos;

    public AbonosController getController() {
        return controller;
    }

    public AbonosModel getModel() {
        return model;
    }

    public void setController(AbonosController controller) {
        this.controller = controller;
    }

    public void setModel(AbonosModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public DefaultTableModel getProductos() {
        return productos;
    }

    public void setProductos(DefaultTableModel productos) {
        this.productos = productos;
        model.addObserver(this);
    }

    public AbonosView() {
        super("", false, true);
        initComponents();
    }

    /**
     * Creates new form ProductosView
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descripcionT = new javax.swing.JTextField();
        agregarButton = new javax.swing.JButton();
        AgregarLabel = new javax.swing.JLabel();
        ProductosScrollPane = new javax.swing.JScrollPane();
        CatalogoTable = new javax.swing.JTable();
        buscarLb = new javax.swing.JLabel();
        verTodoB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("ABONOS");

        descripcionT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        agregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/agregar.png"))); // NOI18N
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        AgregarLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        AgregarLabel.setText("Agregar ");

        ProductosScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductosScrollPaneMouseClicked(evt);
            }
        });

        CatalogoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CatalogoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CatalogoTableMouseClicked(evt);
            }
        });
        ProductosScrollPane.setViewportView(CatalogoTable);

        buscarLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        buscarLb.setText("Seleccione el argumento a buscar");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProductosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarLabel)
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(descripcionT)
                            .addComponent(buscarLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(verTodoB)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verTodoB))
                .addGap(18, 18, 18)
                .addComponent(ProductosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgregarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        Application.ABONO_VIEW.setLocation(this.verTodoB.getLocationOnScreen());
        controller.preAgregar();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void ProductosScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosScrollPaneMouseClicked

    }//GEN-LAST:event_ProductosScrollPaneMouseClicked

    private void CatalogoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CatalogoTableMouseClicked
//        if (evt.getClickCount() == 2) {
//            int row = this.CatalogoTable.getSelectedRow();
//            Application.PRODUCTO_VIEW.setLocation(this.agregarButton.getLocationOnScreen());
//            //controller.editar(row);
//        }
    }//GEN-LAST:event_CatalogoTableMouseClicked

    private void verTodoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoBActionPerformed
        int apartado=model.getFilter().getA().getIdApartado();
        controller.buscar(apartado);
    }//GEN-LAST:event_verTodoBActionPerformed

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        if(model.getFilter().getA().getIdApartado()!=0){
            descripcionT.setText("Apartado número: "+model.getFilter().getA().getIdApartado()+"");
            descripcionT.setEditable(false);
        
        }else
            descripcionT.setText("");
        if (model.getErrores().get("DescripcionText") != null) {
            buscarLb.setBorder(Application.BORDER_ERROR);
            buscarLb.setToolTipText(model.getErrores().get("DescripcionText"));
        } else {
            buscarLb.setBorder(null);
            buscarLb.setToolTipText("");
        }
        
        if(model.getFilter().getA().getSaldo()==0){
            agregarButton.setVisible(false);
            AgregarLabel.setVisible(false);
        }else{
            agregarButton.setVisible(true);
            AgregarLabel.setVisible(true);
        }

        CatalogoTable.setModel(model.getAbonos());
        this.revalidate();
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoView dialog = new ProductoView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgregarLabel;
    public javax.swing.JTable CatalogoTable;
    private javax.swing.JScrollPane ProductosScrollPane;
    private javax.swing.JButton agregarButton;
    private javax.swing.JLabel buscarLb;
    public javax.swing.JTextField descripcionT;
    private javax.swing.JButton verTodoB;
    // End of variables declaration//GEN-END:variables
}
