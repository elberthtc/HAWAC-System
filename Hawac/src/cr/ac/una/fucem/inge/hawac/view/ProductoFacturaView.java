/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;
import cr.ac.una.fucem.inge.hawac.controller.ProductoFacturaController;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import hawac.Application;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProductoFacturaView extends javax.swing.JInternalFrame implements java.util.Observer{
    ProductoFacturaController controller;
    ProductosModel model;
    DefaultTableModel productos;
    
    public ProductoFacturaController getController() {
        return controller;
    }

    public ProductosModel getModel() {
        return model;
    }

    public void setController(ProductoFacturaController controller) {
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
    
    public ProductoFacturaView() {
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
        BuscarButton = new javax.swing.JButton();
        DescripcionText = new javax.swing.JTextField();
        BuscarLabel = new javax.swing.JLabel();
        ProductosScrollPane = new javax.swing.JScrollPane();
        CatalogoTable = new javax.swing.JTable();
        DescripcionRadioButton = new javax.swing.JRadioButton();
        CodigoRadioButton2 = new javax.swing.JRadioButton();
        buscarLb = new javax.swing.JLabel();
        seleccionarB = new javax.swing.JButton();
        cantidadTextField = new javax.swing.JTextField();
        cantidadLb = new javax.swing.JLabel();
        verTodoB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Catalogo de Productos");

        BuscarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/search2.png"))); // NOI18N
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        DescripcionText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        seleccionarB.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        seleccionarB.setText("Seleccionar");
        seleccionarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBActionPerformed(evt);
            }
        });

        cantidadLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cantidadLb.setText("Cantidad");

        verTodoB.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        verTodoB.setText("Ver Todos");
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
                .addGap(10, 10, 10)
                .addComponent(buscarLb))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cantidadLb)
                .addGap(4, 4, 4)
                .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verTodoB))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(CodigoRadioButton2)
                .addGap(0, 0, 0)
                .addComponent(DescripcionRadioButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ProductosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BuscarLabel)
                .addGap(4, 4, 4)
                .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seleccionarB))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(buscarLb)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cantidadLb))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cantidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(verTodoB)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodigoRadioButton2)
                    .addComponent(DescripcionRadioButton))
                .addGap(7, 7, 7)
                .addComponent(ProductosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BuscarLabel))
                    .addComponent(seleccionarB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void CodigoRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoRadioButton2ActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        if(CodigoRadioButton2.isSelected()==false && DescripcionRadioButton.isSelected()==false){
              buscarLb.setBorder(Application.BORDER_ERROR);
              buscarLb.setToolTipText(model.getErrores().get("DescripcionText"));
        }else{
             buscarLb.setBorder(null);
             buscarLb.setToolTipText("");
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

    private void seleccionarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBActionPerformed
        int row = this.CatalogoTable.getSelectedRow();
        if(row != -1){
            controller.seleccionar(row);
        }else
            JOptionPane.showConfirmDialog(this, "No ha seleccionado ningun producto");
    }//GEN-LAST:event_seleccionarBActionPerformed

    private void verTodoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoBActionPerformed
        controller.buscar();
    }//GEN-LAST:event_verTodoBActionPerformed

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
        cantidadTextField.setText("");
         if(model.getErrores().get("cantidadTextField")!=null){
            cantidadLb.setBorder(Application.BORDER_ERROR);
            cantidadLb.setToolTipText(model.getErrores().get("cantidadTextField"));
        }else{
             cantidadLb.setBorder(null);
             cantidadLb.setToolTipText("");
        }

        CatalogoTable.setModel(model.getProductos());
        this.revalidate();
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
    public javax.swing.JLabel cantidadLb;
    public javax.swing.JTextField cantidadTextField;
    private javax.swing.JButton seleccionarB;
    private javax.swing.JButton verTodoB;
    // End of variables declaration//GEN-END:variables

}
