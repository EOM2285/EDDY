/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import Conexiones.Clock;
import Conexiones.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PC
 */
public class RegistroProductos extends javax.swing.JFrame {

    int contador = 0;
    String iva ;
    
    
    public RegistroProductos() {
        
        
        
        
        initComponents();
        
        //HILO RELOJ
        Clock HiloClock = new Clock(lblClock2);
        HiloClock.start();
        
        limpiarPantalla();
        verPantalla();
        desabilitado();
        ID.setVisible(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        venta.setEditable(false);
        compañia.setEditable(false);
        codComp.setEditable(false);
        this.impuesto.addItem("SELECCIONE");
        this.impuesto.addItem("Grabado");
        this.impuesto.addItem("Exento");
        this.listCompañia.removeAllItems();
        this.listCompañia.addItem("SELECCIONAR PROVEEDOR");
        try{
            ResultSet rs = null;
            Connection con3 = null;
            Conexion conect3 = new Conexion();
            con3 = conect3.getConnection();
            Statement Sent = con3.createStatement();
            rs = Sent.executeQuery("select * from Compania");
            while(rs.next()){
                this.listCompañia.addItem(rs.getString("NombreCompania"));
            }
            contador++;
        }catch (SQLException e){
        }
        
    }
    
    public void habilitaPantalla(){
        pantalla.setEnabled(true);
    }
    
    public void desabilitaPantalla(){
        pantalla.setEnabled(false);
    }
    
     public void desabilitado(){
        descripcion.setEnabled(false); 
        codigo.setEnabled(false);
        UxE.setEnabled(false);
        compañia.setEnabled(false);
        codComp.setEnabled(false);
        costo.setEnabled(false);
        margen.setEnabled(false);
        venta.setEnabled(false);
        listCompañia.setEnabled(false);
        impuesto.setEnabled(false);
     
     }
     
        public void habilitado(){
        descripcion.setEnabled(true);    
        codigo.setEnabled(true);
        UxE.setEnabled(true);
        compañia.setEnabled(true);
        codComp.setEnabled(true);
        costo.setEnabled(true);
        margen.setEnabled(true);
        venta.setEnabled(true);
        listCompañia.setEnabled(true);
        impuesto.setEnabled(true);
        descripcion.requestFocus();
     
     }

     public void limpiar(){
        codigo.setText("");
        descripcion.setText(""); 
        UxE.setText("");
        compañia.setText("");
        codComp.setText("");
        costo.setText("");
        margen.setText("");
        venta.setText("");
        listCompañia.setSelectedItem("SELECCIONAR PROVEEDOR");
        impuesto.setSelectedItem("SELECCIONE"); 


        
    }
    
        public void limpiarPantalla(){
        DefaultTableModel Modelo = (DefaultTableModel) pantalla.getModel();
        String titulos[] = {"ID","COMPAÑIA","COD COMPAÑIA","CODIGO","PRODUCTO","UND X EMP","COSTO","MARGEN","VENTA","IVA"};
        Modelo = new DefaultTableModel(null,titulos);
        pantalla.setModel(Modelo);
    }
    
    public void verPantalla(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) pantalla.getModel();
            Conexion conect1 = new Conexion();
            con1 = conect1.getConnection();
            String dts[] = new String[10];
            String sql = "select * from Productos";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);  //codigo,descripcion,unidadXempaque,compania,codCompania,costo,margen,venta,impuesto
            while(rs.next()){
                dts[0] = rs.getString("id");
                dts[1] = rs.getString("compania");
                dts[2] = rs.getString("codCompania");
                dts[3] = rs.getString("codigo");
                dts[4] = rs.getString("descripcion");
                dts[5] = rs.getString("unidadXempaque");
                dts[6] = rs.getString("costo");               
                dts[7] = rs.getString("margen");
                dts[8] = rs.getString("venta");
                dts[9] = rs.getString("impuesto");
                miModelo.addRow(dts);
            }
            pantalla.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compañia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UxE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codComp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        costo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        margen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        venta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        listCompañia = new javax.swing.JComboBox();
        impuesto = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        lblClock2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Opcionesmnu = new javax.swing.JMenu();
        btnMenuPrincipal = new javax.swing.JMenuItem();
        btnCerrarS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        compañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compañiaActionPerformed(evt);
            }
        });

        jLabel1.setText("CODIGO");

        jLabel2.setText("DESCRIPCION");

        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });

        jLabel3.setText("UND x EMP");

        UxE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UxE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UxEActionPerformed(evt);
            }
        });

        jLabel4.setText("NOMBRE CONPAÑIA");

        jLabel5.setText("COD COMPAÑIA");

        codComp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codCompActionPerformed(evt);
            }
        });

        jLabel6.setText("COSTO");

        costo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoActionPerformed(evt);
            }
        });

        jLabel7.setText("MARGEN");

        margen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                margenActionPerformed(evt);
            }
        });
        margen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                margenKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                margenKeyTyped(evt);
            }
        });

        jLabel8.setText("VENTA");

        venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaActionPerformed(evt);
            }
        });

        jLabel9.setText("INPUESTO");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        listCompañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCompañiaActionPerformed(evt);
            }
        });

        impuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                impuestoItemStateChanged(evt);
            }
        });
        impuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impuestoActionPerformed(evt);
            }
        });

        jLabel10.setText("CONPAÑIA");

        codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        jLabel11.setText("%");

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        pantalla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "COMPAÑIA", "COD COMPAÑIA", "CODIGO", "PRODUCTO", "UND X EMP", "COSTO", "MARGEN", "VENTA", "IVA"
            }
        ));
        pantalla.setCellSelectionEnabled(true);
        pantalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pantallaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pantalla);

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        lblClock2.setText("jLabel12");

        Opcionesmnu.setText("OPCIONES");

        btnMenuPrincipal.setText("MENÚ PRINCIPAL");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        Opcionesmnu.add(btnMenuPrincipal);

        btnCerrarS.setText("CERRAR SESIÓN");
        btnCerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSActionPerformed(evt);
            }
        });
        Opcionesmnu.add(btnCerrarS);

        jMenuBar1.add(Opcionesmnu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(margen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel11)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(venta))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(UxE, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel9)
                                            .addGap(18, 18, 18)
                                            .addComponent(impuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(listCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(compañia, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(codComp)))
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClock2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(listCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(codComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(compañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UxE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(margen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClock2)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        descripcion.transferFocus();
    }//GEN-LAST:event_descripcionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (descripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DESCRIPCION","Advertencia", JOptionPane.WARNING_MESSAGE);
            descripcion.requestFocus();
        } else if (compañia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA SELECCIONAR LA COMPAÑIA", "Advertencia", JOptionPane.WARNING_MESSAGE); 
            listCompañia.requestFocus();
        } else if (codComp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA SELECCIONAR EL CODIGO DE LA COMPAÑIA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            codComp.requestFocus();
        } else if (codigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL CÓDIGO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            codigo.requestFocus();
        } else if (UxE.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA UNIDAD X EMPAQUE", "Advertencia", JOptionPane.WARNING_MESSAGE);
            UxE.requestFocus();
        } else if (impuesto.getSelectedItem().equals("") || impuesto.getSelectedItem().equals("SELECCIONE")) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCONAR TIPO DE IMPUESTO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            impuesto.requestFocus();
        }  else if (costo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL COSTO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            costo.requestFocus();
        } else if (margen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL MARGEN", "Advertencia", JOptionPane.WARNING_MESSAGE);
            margen.requestFocus();
        } else if (venta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR VENTA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            venta.requestFocus();
        }  else {
            try {
                Connection con = null;
                Conexion conect = new Conexion();
                con = conect.getConnection();
                //Statement st = con.createStatement();
                String sql = "INSERT INTO Productos (codigo,descripcion,unidadXempaque,compania,codCompania,costo,margen,venta,impuesto) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, codigo.getText());
                pst.setString(2, descripcion.getText());
                pst.setString(3, UxE.getText());
                pst.setString(4, compañia.getText());
                pst.setString(5, codComp.getText());
                pst.setString(6, costo.getText());
                pst.setString(7, margen.getText());
                pst.setString(8, venta.getText());
                pst.setString(9, (String) impuesto.getSelectedItem());
                int n = pst.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE");
                    limpiar();
                    limpiarPantalla();
                    verPantalla();
                    btnNuevo.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    desabilitado();
                    con.close();
                   
                }
            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void compañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compañiaActionPerformed
        compañia.transferFocus();
    }//GEN-LAST:event_compañiaActionPerformed

    private void UxEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UxEActionPerformed
        UxE.transferFocus();
    }//GEN-LAST:event_UxEActionPerformed

    private void codCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codCompActionPerformed
        codComp.transferFocus();
    }//GEN-LAST:event_codCompActionPerformed

    private void costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoActionPerformed
        costo.transferFocus();
    }//GEN-LAST:event_costoActionPerformed

    private void margenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_margenActionPerformed
        margen.transferFocus();
    }//GEN-LAST:event_margenActionPerformed

    private void ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaActionPerformed
        venta.transferFocus();
    }//GEN-LAST:event_ventaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        codigo.transferFocus();
    }//GEN-LAST:event_codigoActionPerformed

    private void impuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impuestoActionPerformed
        impuesto.transferFocus();
      
    }//GEN-LAST:event_impuestoActionPerformed

    private void listCompañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCompañiaActionPerformed
        listCompañia.transferFocus();
        if (!listCompañia.getSelectedItem().equals("SELECCIONAR PROVEEDOR")) {
            try {
                if (this.contador > 0) {
                    Connection con = null;
                    Conexion conect = new Conexion();
                    con = conect.getConnection();
                    Statement st2 = con.createStatement();
                    ResultSet rs1 = st2.executeQuery("SELECT * from Compania where NombreCompania = '" + this.listCompañia.getSelectedItem()+ "'");
                    rs1.next();
                    this.codComp.setText(String.valueOf(rs1.getInt("CodCompania")));
                    this.compañia.setText(String.valueOf(rs1.getString("NombreCompania")));
                    con.close();
                }
                                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_listCompañiaActionPerformed

    private void impuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_impuestoItemStateChanged
        
    }//GEN-LAST:event_impuestoItemStateChanged

    private void margenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_margenKeyPressed
     
    }//GEN-LAST:event_margenKeyPressed

        
    
    private void margenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_margenKeyTyped
    
        double cost = 0;
        double imp = 0;
        double impMonto = 0;
        double total = 0;
        try {
            cost = Integer.parseInt(costo.getText());
            imp = Integer.parseInt(margen.getText()) / 100.0;
            impMonto = cost * imp;
            total = cost + impMonto;
            venta.setText(String.valueOf(total));
        } catch (NumberFormatException e) {

        }

    }//GEN-LAST:event_margenKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        habilitado();
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try
        {
            Connection con = null;
            Conexion conect = new Conexion();
            con = conect.getConnection();
           // Statement st = con.createStatement();
            String sql = "update Productos set codigo = ?, descripcion = ?, unidadXempaque = ?, compania = ?, codCompania = ?, costo= ?, margen= ? , venta = ?, impuesto = ? where Id = ?";
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1, codigo.getText());
            pst.setString(2, descripcion.getText());
            pst.setString(3, UxE.getText());
            pst.setString(4, compañia.getText());
            pst.setString(5, codComp.getText());
            pst.setString(6, costo.getText());
            pst.setString(7, margen.getText());
            pst.setString(8, venta.getText());
            pst.setString(9, (String) impuesto.getSelectedItem());
            pst.setInt(10, Integer.parseInt(ID.getText()));
            int n = pst.executeUpdate();
            if (n > 0)
            {
                JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS CORRECTAMENTE");
                limpiar();
                limpiarPantalla();
                verPantalla();
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnBorrar.setEnabled(false);
                desabilitado();
                con.close();
            }
        } catch (SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE" + e, "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnModificarActionPerformed

    private void pantallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pantallaMouseClicked
                try
        {
            int fila = pantalla.getSelectedRow();  
            ID.setText(pantalla.getValueAt(fila, 0).toString());
            listCompañia.setSelectedItem(pantalla.getValueAt(fila, 1).toString());
            compañia.setText(pantalla.getValueAt(fila, 1).toString());
            codComp.setText(pantalla.getValueAt(fila, 2).toString());
            codigo.setText(pantalla.getValueAt(fila, 3).toString());
            descripcion.setText(pantalla.getValueAt(fila, 4).toString());
            UxE.setText(pantalla.getValueAt(fila, 5).toString());
            costo.setText(pantalla.getValueAt(fila, 6).toString());
            margen.setText(pantalla.getValueAt(fila, 7).toString());
            venta.setText(pantalla.getValueAt(fila, 8).toString());
            impuesto.setSelectedItem(pantalla.getValueAt(fila, 9).toString());
            
                     
            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnBorrar.setEnabled(true);
           
            habilitado();
        } catch (Exception ex)
        {
            System.out.println("ERROR AL SELECCIONAR UN EQUIPO : " + ex.getMessage());
        }
    }//GEN-LAST:event_pantallaMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila = pantalla.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int opc = JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION)
            {
                try
                {
                    Connection con = null;
                    Conexion conect = new Conexion();
                    con = conect.getConnection();
                    //Statement st = con.createStatement();
                    String sql = "delete from Productos where id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(ID.getText()));
                    int n = pst.executeUpdate();
                    if (n > 0)
                    {
                        JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
                        limpiar();
                        limpiarPantalla();
                        verPantalla();
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnModificar.setEnabled(false);
                        btnBorrar.setEnabled(false);
                        desabilitado();
                        con.close();
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
       ID.transferFocus();
    }//GEN-LAST:event_IDActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        this.dispose();
        Principal vPrincipal = new Principal();
        vPrincipal.setVisible(true);
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnCerrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSActionPerformed
        this.dispose();
        LoginUsuario vLogin = new LoginUsuario();
        vLogin.setVisible(true);
    }//GEN-LAST:event_btnCerrarSActionPerformed


   
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
            java.util.logging.Logger.getLogger(RegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JMenu Opcionesmnu;
    private javax.swing.JTextField UxE;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JMenuItem btnCerrarS;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnMenuPrincipal;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField codComp;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField compañia;
    private javax.swing.JTextField costo;
    private javax.swing.JTextField descripcion;
    private javax.swing.JComboBox<String> impuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClock2;
    private javax.swing.JComboBox listCompañia;
    private javax.swing.JTextField margen;
    private javax.swing.JTable pantalla;
    private javax.swing.JTextField venta;
    // End of variables declaration//GEN-END:variables
}
