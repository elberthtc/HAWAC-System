/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.view;

import cr.ac.una.fucem.inge.hawac.controller.FacturaController;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import hawac.Application;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FacturaView extends javax.swing.JInternalFrame implements java.util.Observer{

    FacturaController controller;
    FacturaModel model;
  
    public FacturaView() {
        super("",false,true);
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

        jLabel1 = new javax.swing.JLabel();
        numFacturaLb = new javax.swing.JLabel();
        numFacTextFd = new javax.swing.JTextField();
        fechaLb = new javax.swing.JLabel();
        FechaTextFd = new javax.swing.JTextField();
        ClienteLb = new javax.swing.JLabel();
        nomClienteTextFd = new javax.swing.JTextField();
        TelefonoLb = new javax.swing.JLabel();
        idClienteTextFd = new javax.swing.JTextField();
        cedulaLb = new javax.swing.JLabel();
        telefonoClienteTextFd = new javax.swing.JTextField();
        descuentoLb = new javax.swing.JLabel();
        descuentoTextFd = new javax.swing.JTextField();
        formadePagoLb = new javax.swing.JLabel();
        metodoPagoComboBox = new javax.swing.JComboBox<String>();
        vendedorLb = new javax.swing.JLabel();
        vendedorTextFd = new javax.swing.JTextField();
        listaProductosLb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProductosTable = new javax.swing.JTable();
        SubTotalLb = new javax.swing.JLabel();
        subtotalTextFd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ivTextFd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TotalTextFd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AgregarButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        grabarButton = new javax.swing.JButton();
        GrabarLb = new javax.swing.JLabel();
        addClienteButton = new javax.swing.JButton();
        horaLb = new javax.swing.JLabel();
        horaTextFd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Venta de Productos");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Datos Generales");

        numFacturaLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        numFacturaLb.setText("N° Factura");

        numFacTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numFacTextFd.setEnabled(false);
        numFacTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFacTextFdActionPerformed(evt);
            }
        });

        fechaLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        fechaLb.setText("Fecha de Emisión");

        FechaTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FechaTextFd.setEnabled(false);
        FechaTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaTextFdActionPerformed(evt);
            }
        });

        ClienteLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ClienteLb.setText("Cliente");

        nomClienteTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nomClienteTextFd.setEnabled(false);

        TelefonoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        TelefonoLb.setText("Telefono");

        idClienteTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idClienteTextFd.setEnabled(false);

        cedulaLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cedulaLb.setText("Cedula");

        telefonoClienteTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        telefonoClienteTextFd.setEnabled(false);
        telefonoClienteTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoClienteTextFdActionPerformed(evt);
            }
        });

        descuentoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        descuentoLb.setText("Descuento");

        descuentoTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descuentoTextFd.setEnabled(false);
        descuentoTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoTextFdActionPerformed(evt);
            }
        });

        formadePagoLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        formadePagoLb.setText("Forma De Pago");

        metodoPagoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efectivo", "TarjetaCredito", "Cheque" }));
        metodoPagoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoPagoComboBoxActionPerformed(evt);
            }
        });

        vendedorLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        vendedorLb.setText("Vendedor");

        vendedorTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vendedorTextFd.setEnabled(false);

        listaProductosLb.setBackground(new java.awt.Color(0, 0, 0));
        listaProductosLb.setForeground(new java.awt.Color(255, 255, 255));
        listaProductosLb.setText("                                                                                                 LISTA DE PRODUCTOS");
        listaProductosLb.setOpaque(true);

        ListProductosTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ListProductosTable);

        SubTotalLb.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        SubTotalLb.setText("SUB TOTAL:");

        subtotalTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("I.V");

        ivTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ivTextFd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ivTextFdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setText("TOTAL:");

        TotalTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setText("FERRETERIA");

        AgregarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/agregar.png"))); // NOI18N
        AgregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarButtonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/cancel (2).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/cancel.png"))); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("AGREGAR");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("ELIMINAR");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("SALIR");

        grabarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/save2.png"))); // NOI18N
        grabarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarButtonActionPerformed(evt);
            }
        });

        GrabarLb.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        GrabarLb.setText("GRABAR");

        addClienteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cr/ac/una/fucem/inge/hawac/view/icons/addUser.png"))); // NOI18N
        addClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClienteButtonActionPerformed(evt);
            }
        });

        horaLb.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        horaLb.setText("Hora");

        horaTextFd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        horaTextFd.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numFacturaLb)
                            .addComponent(ClienteLb)
                            .addComponent(cedulaLb)
                            .addComponent(vendedorLb))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idClienteTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(numFacTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(nomClienteTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addComponent(formadePagoLb)
                                .addGap(18, 18, 18)
                                .addComponent(metodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(fechaLb)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(FechaTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(horaLb)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(horaTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TelefonoLb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(telefonoClienteTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vendedorTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addComponent(descuentoLb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(descuentoTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(listaProductosLb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(145, 145, 145)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(GrabarLb)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SubTotalLb)
                                        .addGap(18, 18, 18)
                                        .addComponent(subtotalTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ivTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(TotalTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(grabarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(AgregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numFacturaLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numFacTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fechaLb)
                                    .addComponent(FechaTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(horaLb)
                                    .addComponent(horaTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClienteLb)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefonoClienteTextFd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TelefonoLb))
                            .addComponent(nomClienteTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idClienteTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cedulaLb))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(descuentoLb)
                                .addComponent(descuentoTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(formadePagoLb)
                                .addComponent(metodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vendedorLb)
                            .addComponent(vendedorTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(listaProductosLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SubTotalLb)
                        .addComponent(subtotalTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(ivTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(TotalTextFd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(grabarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(GrabarLb)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numFacTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFacTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numFacTextFdActionPerformed

    private void descuentoTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descuentoTextFdActionPerformed

    private void metodoPagoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoPagoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodoPagoComboBoxActionPerformed

    private void ivTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ivTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ivTextFdActionPerformed

    private void AgregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarButtonActionPerformed
        controller.guardarDatosBasicos();
        controller.preAgregarProducto();
    }//GEN-LAST:event_AgregarButtonActionPerformed

    private void grabarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarButtonActionPerformed
        controller.guardar();
    }//GEN-LAST:event_grabarButtonActionPerformed

    private void FechaTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaTextFdActionPerformed

    private void addClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteButtonActionPerformed
        controller.preAgregarCliente();
    }//GEN-LAST:event_addClienteButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        controller.salir();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void telefonoClienteTextFdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoClienteTextFdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoClienteTextFdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = this.ListProductosTable.getSelectedRow();
        if(row != -1){
        int ax = JOptionPane.showConfirmDialog(null, "Estas seguro que desea eliminarlo?");
        if(ax == JOptionPane.YES_OPTION){
            controller.eliminar(row);
       }
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    public FacturaController getController() {
        return controller;
    }

    public FacturaModel getModel() {
        return model;
    }

    public void setController(cr.ac.una.fucem.inge.hawac.controller.FacturaController controller) {
        this.controller = controller;
    }

    public void setModel(cr.ac.una.fucem.inge.hawac.model.FacturaModel model) {
        this.model = model;
        model.addObserver(this);
    }
    public double subtotal(){
        double subtotal =0;
        for(int row=0;row<model.getLineas().getRowCount();row++){
            subtotal = subtotal + (double)model.getLineas().getValueAt(row,3);
        }
        return subtotal;
    }
    public double impuesto(){
        double sub = this.subtotal()*0.13;
        return sub;
    }
    public double total(){
        double total = this.subtotal()+this.impuesto();
        return total;
    }

       @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        
        this.numFacTextFd.setText(Application.CANTIDAD+"");
        if(model.getCurrent().getCliente()!=0){
            nomClienteTextFd.setText(model.getCliente().getNombre());
        }else
            nomClienteTextFd.setText("");
        
        idClienteTextFd.setText("");
        if(model.getCliente().getCedula()==0)
            idClienteTextFd.setText("");
        else
            idClienteTextFd.setText(String.valueOf(model.getCliente().getCedula()));
        telefonoClienteTextFd.setText(model.getCliente().getTelefono());
        FechaTextFd.setText(model.getCurrent().getFechaActual());
        horaTextFd.setText(model.getCurrent().getHoraActual());
        
        
        //String desc = String.valueOf(model.getCurrent().getCliente().getPorcentajeDescuento());
        descuentoTextFd.setText("NOAI");
        vendedorTextFd.setText(model.getEmpleado().getNombre());
        if(model.getErrores().get("GRABAR")!= null){
            GrabarLb.setBorder(Application.BORDER_ERROR);
            GrabarLb.setToolTipText(model.getErrores().get("GRABAR"));
        }else{
            GrabarLb.setBorder(null);
            GrabarLb.setToolTipText("");
        }
        String sub = String.valueOf(this.subtotal());
        String imp = String.valueOf(this.impuesto());
        String total = String.valueOf(this.total());
        subtotalTextFd.setText(sub);
        ivTextFd.setText(imp);
        TotalTextFd.setEnabled(false);
        TotalTextFd.setText(total);
        
        ListProductosTable.setModel(model.getLineas());
        this.revalidate();
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
            @Override
            public void run() {
                new FacturaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarButton;
    private javax.swing.JLabel ClienteLb;
    private javax.swing.JTextField FechaTextFd;
    private javax.swing.JLabel GrabarLb;
    public javax.swing.JTable ListProductosTable;
    private javax.swing.JLabel SubTotalLb;
    private javax.swing.JLabel TelefonoLb;
    public javax.swing.JTextField TotalTextFd;
    private javax.swing.JButton addClienteButton;
    private javax.swing.JLabel cedulaLb;
    private javax.swing.JLabel descuentoLb;
    public javax.swing.JTextField descuentoTextFd;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel fechaLb;
    private javax.swing.JLabel formadePagoLb;
    private javax.swing.JButton grabarButton;
    private javax.swing.JLabel horaLb;
    public javax.swing.JTextField horaTextFd;
    public javax.swing.JTextField idClienteTextFd;
    private javax.swing.JTextField ivTextFd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listaProductosLb;
    public javax.swing.JComboBox<String> metodoPagoComboBox;
    public javax.swing.JTextField nomClienteTextFd;
    public javax.swing.JTextField numFacTextFd;
    private javax.swing.JLabel numFacturaLb;
    private javax.swing.JTextField subtotalTextFd;
    public javax.swing.JTextField telefonoClienteTextFd;
    private javax.swing.JLabel vendedorLb;
    private javax.swing.JTextField vendedorTextFd;
    // End of variables declaration//GEN-END:variables

}
