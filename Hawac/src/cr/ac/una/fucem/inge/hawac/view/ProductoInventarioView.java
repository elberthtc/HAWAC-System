/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;
import cr.ac.una.fucem.inge.hawac.controller.ProductoFacturaController;
import cr.ac.una.fucem.inge.hawac.controller.ProductoInventarioController;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import hawac.Application;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProductoInventarioView extends javax.swing.JInternalFrame implements java.util.Observer{
    ProductoInventarioController controller;
    ProductosModel model;
    DefaultTableModel productos;
    
    public ProductoInventarioController getController() {
        return controller;
    }

    public ProductosModel getModel() {
        return model;
    }

    public void setController(ProductoInventarioController controller) {
        this.controller = controller;
    }

    public void setModel(ProductosModel model) {
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
    
    public ProductoInventarioView() {
        super("",false,true);
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

        Busqueda = new javax.swing.ButtonGroup();
        DescripcionText = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();
        BuscarLabel = new javax.swing.JLabel();
        ProductosScrollPane = new javax.swing.JScrollPane();
        CatalogoTable = new javax.swing.JTable();
        DescripcionRadioButton = new javax.swing.JRadioButton();
        CodigoRadioButton2 = new javax.swing.JRadioButton();
        buscarLb = new javax.swing.JLabel();
        verTodoRdButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Catalogo de Productos");

        DescripcionText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BuscarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        BuscarLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        BuscarLabel.setText("Buscar");

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
        ProductosScrollPane.setViewportView(CatalogoTable);

        Busqueda.add(DescripcionRadioButton);
        DescripcionRadioButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        DescripcionRadioButton.setText("Descripcion");

        Busqueda.add(CodigoRadioButton2);
        CodigoRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        CodigoRadioButton2.setText("Codigo");
        CodigoRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoRadioButton2ActionPerformed(evt);
            }
        });

        buscarLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        buscarLb.setText("Seleccione el argumento a buscar");

        Busqueda.add(verTodoRdButton);
        verTodoRdButton.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        verTodoRdButton.setText("Ver Todo");
        verTodoRdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodoRdButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jButton1.setText("Seleccionar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(DescripcionRadioButton)
                                    .addGap(27, 27, 27)
                                    .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(buscarLb)
                                .addComponent(CodigoRadioButton2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BuscarLabel)))
                        .addComponent(verTodoRdButton)
                        .addComponent(ProductosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarLb)
                    .addComponent(BuscarLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DescripcionRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CodigoRadioButton2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verTodoRdButton)
                .addGap(18, 18, 18)
                .addComponent(ProductosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void CodigoRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoRadioButton2ActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        if(CodigoRadioButton2.isSelected()==false && DescripcionRadioButton.isSelected()==false && verTodoRdButton.isSelected()== false ){
              buscarLb.setBorder(Application.BORDER_ERROR);
              buscarLb.setToolTipText(model.getErrores().get("DescripcionText"));
        }else{
             buscarLb.setBorder(null);
             buscarLb.setToolTipText("");
             if(verTodoRdButton.isSelected()==true){
                 controller.buscar();
             }
             if(DescripcionRadioButton.isSelected()==true && DescripcionText.getText().length()==0){
                   model.getErrores().put("DescripcionText","Digite la descripcion a buscar");
                   buscarLb.setBorder(Application.BORDER_ERROR);
                   buscarLb.setToolTipText(model.getErrores().get("DescripcionText"));
             }
            if(DescripcionRadioButton.isSelected()==true && DescripcionText.getText().length()!=0){
                controller.buscarPorDescripcion();
            }
            if(CodigoRadioButton2.isSelected()==true && DescripcionText.getText().length()==0){
                   model.getErrores().put("DescripcionText","Digite la descripcion a buscar");
                   buscarLb.setBorder(Application.BORDER_ERROR);
                   buscarLb.setToolTipText(model.getErrores().get("DescripcionText"));
             }
            if(CodigoRadioButton2.isSelected()==true && DescripcionText.getText().length()!=0){
                 controller.buscarPorId();
             }
        }
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void ProductosScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosScrollPaneMouseClicked
    
    }//GEN-LAST:event_ProductosScrollPaneMouseClicked

    private void verTodoRdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoRdButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verTodoRdButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = this.CatalogoTable.getSelectedRow();
        if(row != -1){
            controller.seleccionar(row);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        DescripcionText.setText(model.getFilter().getDescripcion());
        if(model.getErrores().get("DescripcionText")!=null){
            buscarLb.setBorder(Application.BORDER_ERROR);
            buscarLb.setToolTipText(model.getErrores().get("DescripcionText"));
        }else{
             buscarLb.setBorder(null);
             buscarLb.setToolTipText("");
        }
        CatalogoTable.setModel(model.getProductos());
        this.revalidate();
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
    private javax.swing.JButton BuscarButton;
    private javax.swing.JLabel BuscarLabel;
    private javax.swing.ButtonGroup Busqueda;
    public javax.swing.JTable CatalogoTable;
    public javax.swing.JRadioButton CodigoRadioButton2;
    public javax.swing.JRadioButton DescripcionRadioButton;
    public javax.swing.JTextField DescripcionText;
    private javax.swing.JScrollPane ProductosScrollPane;
    private javax.swing.JLabel buscarLb;
    private javax.swing.JButton jButton1;
    public javax.swing.JRadioButton verTodoRdButton;
    // End of variables declaration//GEN-END:variables

}
