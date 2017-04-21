/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.ApplicationController;
import cr.ac.una.fucem.inge.hawac.model.ApplicationModel;
import hawac.Application;
import javax.swing.JInternalFrame;

public class ApplicationView extends javax.swing.JFrame implements java.util.Observer{
    ApplicationController controller;
    ApplicationModel model;
    
    public ApplicationView(){
        initComponents();
        this.setSize(1000,750);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        salirItem = new javax.swing.JMenuItem();
        FacturacionMenu = new javax.swing.JMenu();
        ventaItem = new javax.swing.JMenuItem();
        compraItem = new javax.swing.JMenuItem();
        facturasItem = new javax.swing.JMenuItem();
        apartadoItem = new javax.swing.JMenuItem();
        MantenimientoMenu = new javax.swing.JMenu();
        ListaClientesItem = new javax.swing.JMenuItem();
        productosItem = new javax.swing.JMenuItem();
        usuarioItem = new javax.swing.JMenuItem();
        cobrosMenu = new javax.swing.JMenu();
        cobrosMenuItem = new javax.swing.JMenuItem();
        inventariosMenu = new javax.swing.JMenu();
        tiendaMenuItem = new javax.swing.JMenuItem();
        bitacoraMenu = new javax.swing.JMenu();
        entradaItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIENDA");
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPane);

        MenuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fileMenu.setText("SISTEMA");
        fileMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N

        salirItem.setText("Cerrar sesion");
        salirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirItemActionPerformed(evt);
            }
        });
        fileMenu.add(salirItem);

        MenuBar.add(fileMenu);

        FacturacionMenu.setText("CAJA");
        FacturacionMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N

        ventaItem.setText("Venta");
        ventaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaItemActionPerformed(evt);
            }
        });
        FacturacionMenu.add(ventaItem);

        compraItem.setText("Compra");
        compraItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraItemActionPerformed(evt);
            }
        });
        FacturacionMenu.add(compraItem);

        facturasItem.setText("Facturas Pagadas");
        facturasItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasItemActionPerformed(evt);
            }
        });
        FacturacionMenu.add(facturasItem);

        apartadoItem.setText("Apartados");
        apartadoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apartadoItemActionPerformed(evt);
            }
        });
        FacturacionMenu.add(apartadoItem);

        MenuBar.add(FacturacionMenu);

        MantenimientoMenu.setText("MANTENIMIENTO");
        MantenimientoMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N

        ListaClientesItem.setText("Clientes");
        ListaClientesItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaClientesItemActionPerformed(evt);
            }
        });
        MantenimientoMenu.add(ListaClientesItem);

        productosItem.setText("Productos");
        productosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosItemActionPerformed(evt);
            }
        });
        MantenimientoMenu.add(productosItem);

        usuarioItem.setText("Usuarios");
        usuarioItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioItemActionPerformed(evt);
            }
        });
        MantenimientoMenu.add(usuarioItem);

        MenuBar.add(MantenimientoMenu);

        cobrosMenu.setText("COBROS");
        cobrosMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N

        cobrosMenuItem.setText("CAJA");
        cobrosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrosMenuItemActionPerformed(evt);
            }
        });
        cobrosMenu.add(cobrosMenuItem);

        MenuBar.add(cobrosMenu);

        inventariosMenu.setText("INVENTARIO");
        inventariosMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N

        tiendaMenuItem.setText("Tienda");
        tiendaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiendaMenuItemActionPerformed(evt);
            }
        });
        inventariosMenu.add(tiendaMenuItem);

        MenuBar.add(inventariosMenu);

        bitacoraMenu.setText("BITACORA");
        bitacoraMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        bitacoraMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitacoraMenuActionPerformed(evt);
            }
        });

        entradaItem.setText("Entradas");
        entradaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaItemActionPerformed(evt);
            }
        });
        bitacoraMenu.add(entradaItem);

        MenuBar.add(bitacoraMenu);

        HelpMenu.setText("AYUDA");
        HelpMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        HelpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpMenuActionPerformed(evt);
            }
        });

        AboutItem.setText("Acerca de");
        AboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutItem);

        MenuBar.add(HelpMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirItemActionPerformed
        controller.exit();
    }//GEN-LAST:event_salirItemActionPerformed

    private void ListaClientesItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaClientesItemActionPerformed
         controller.clientesShow();
    }//GEN-LAST:event_ListaClientesItemActionPerformed

    private void compraItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraItemActionPerformed
        controller.facturaCompraShow();
    }//GEN-LAST:event_compraItemActionPerformed

    private void ventaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaItemActionPerformed
        controller.facturaShow();
    }//GEN-LAST:event_ventaItemActionPerformed

    private void productosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosItemActionPerformed
        controller.productosShow();
    }//GEN-LAST:event_productosItemActionPerformed

    private void cobrosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrosMenuItemActionPerformed
       controller.cobrosShow();
    }//GEN-LAST:event_cobrosMenuItemActionPerformed

    private void HelpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HelpMenuActionPerformed

    private void facturasItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasItemActionPerformed
        controller.despachosShow();
    }//GEN-LAST:event_facturasItemActionPerformed

    private void AboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutItemActionPerformed
        controller.about();
    }//GEN-LAST:event_AboutItemActionPerformed

    private void tiendaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiendaMenuItemActionPerformed
        Application.INVENTARIO = "Tienda";
        Application.INVENTARIO_TIENDA_VIEW.setVisible(true);
    }//GEN-LAST:event_tiendaMenuItemActionPerformed

    private void usuarioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioItemActionPerformed
        Application.USUARIOS_VIEW.setVisible(true);
    }//GEN-LAST:event_usuarioItemActionPerformed

    private void apartadoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apartadoItemActionPerformed
        controller.apartadosShow();
    }//GEN-LAST:event_apartadoItemActionPerformed

    private void entradaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaItemActionPerformed
        controller.bitacorasShow();
    }//GEN-LAST:event_entradaItemActionPerformed

    private void bitacoraMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitacoraMenuActionPerformed
       
    }//GEN-LAST:event_bitacoraMenuActionPerformed

    public ApplicationController getController() {
        return controller;
    }

    public ApplicationModel getModel() {
        return model;
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public void setModel(ApplicationModel model) {
        this.model = model;
        model.addObserver(this);
    }
     public void addInternalFrame(JInternalFrame f){
       this.desktopPane.add(f);
   }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        if (model.getCurrent() != null) {
            this.setTitle("TIENDA \nUsuario: " + model.getCurrent().tipo() + "("+model.getCurrent().getNombre()+")");
        } else {
            this.setTitle("TIENDA");
        }
        
        this.compraItem.setVisible(false);
        cobrosMenu.setVisible(false);
        
        if(model.getCurrent()!=null && model.getCurrent().tipo()!=0){
            usuarioItem.setVisible(false);
            productosItem.setVisible(false);
            bitacoraMenu.setVisible(false);
        }else if(model.getCurrent()!=null && model.getCurrent().tipo()==0){
            usuarioItem.setVisible(true);
            productosItem.setVisible(true);
            bitacoraMenu.setVisible(true);
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
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutItem;
    private javax.swing.JMenu FacturacionMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem ListaClientesItem;
    private javax.swing.JMenu MantenimientoMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem apartadoItem;
    private javax.swing.JMenu bitacoraMenu;
    private javax.swing.JMenu cobrosMenu;
    private javax.swing.JMenuItem cobrosMenuItem;
    private javax.swing.JMenuItem compraItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem entradaItem;
    private javax.swing.JMenuItem facturasItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu inventariosMenu;
    private javax.swing.JMenuItem productosItem;
    private javax.swing.JMenuItem salirItem;
    private javax.swing.JMenuItem tiendaMenuItem;
    private javax.swing.JMenuItem usuarioItem;
    private javax.swing.JMenuItem ventaItem;
    // End of variables declaration//GEN-END:variables
}