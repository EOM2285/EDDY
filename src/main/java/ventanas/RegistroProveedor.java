/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

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
public class RegistroProveedor extends javax.swing.JFrame {

    int contador = 0;
    String iva ;
    public RegistroProveedor() {
        initComponents();
        limpiarPantalla();
        verPantalla();
        desabilitado();
        idCompañia.setVisible(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
                
    }
    
    public void habilitaPantalla(){
        pantalla.setEnabled(true);
    }
    
    public void desabilitaPantalla(){
        pantalla.setEnabled(false);
    }
    
     public void desabilitado(){
        nombreCompañia.setEnabled(false); 
        correo.setEnabled(false);
        telefono.setEnabled(false);
       
     
     }
     
        public void habilitado(){
        nombreCompañia.setEnabled(true);    
        correo.setEnabled(true);
        telefono.setEnabled(true);
        nombreCompañia.requestFocus();
     
     }

     public void limpiar(){
        correo.setText("");
        nombreCompañia.setText(""); 
        telefono.setText("");
               
    }
    
        public void limpiarPantalla(){
        DefaultTableModel Modelo = (DefaultTableModel) pantalla.getModel();
        String titulos[] = {"ID PROVEEDOR","NOMBRE","CORREO","TELEFONO"};
        Modelo = new DefaultTableModel(null,titulos);
        pantalla.setModel(Modelo);
    }
    
    public void verPantalla(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) pantalla.getModel();
            Conexion conect1 = new Conexion();
            con1 = conect1.getConnection();
            String dts[] = new String[4];
            String sql = "select * from Compania";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);  
            while(rs.next()){
                dts[0] = rs.getString("CodCompania");
                dts[1] = rs.getString("NombreCompania");
                dts[2] = rs.getString("Correo");
                dts[3] = rs.getString("Telefono");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreCompañia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        correo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTable();
        idCompañia = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnMenuPrincipal = new javax.swing.JMenuItem();
        btnCerrarS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CORREO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRE DE PROVEEDOR");

        nombreCompañia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreCompañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCompañiaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("TELEFONO");

        telefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        correo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        pantalla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID PROVEEDOR", "NOMBRE", "CORREO", "TELEFONO"
            }
        ));
        pantalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pantallaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pantalla);

        idCompañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCompañiaActionPerformed(evt);
            }
        });

        jMenu1.setText("OPCIONES");

        btnMenuPrincipal.setText("MENÚ PRINCIPAL");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(btnMenuPrincipal);

        btnCerrarS.setText("CERRAR SESIÓN");
        btnCerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSActionPerformed(evt);
            }
        });
        jMenu1.add(btnCerrarS);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(telefono))
                            .addComponent(correo)
                            .addComponent(nombreCompañia, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(idCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addComponent(btnNuevo)
                        .addGap(32, 32, 32)
                        .addComponent(btnGuardar)
                        .addGap(37, 37, 37)
                        .addComponent(btnModificar)
                        .addGap(44, 44, 44)
                        .addComponent(btnBorrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreCompañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCompañiaActionPerformed
        nombreCompañia.transferFocus();
    }//GEN-LAST:event_nombreCompañiaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (correo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL CÓDIGO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            correo.requestFocus();
        } else if (nombreCompañia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DESCRIPCION", "Advertencia", JOptionPane.WARNING_MESSAGE);
            nombreCompañia.requestFocus();
        } else if (telefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA UNIDAD X EMPAQUE", "Advertencia", JOptionPane.WARNING_MESSAGE);
            telefono.requestFocus();
        }  else {
            try {
                Connection con = null;
                Conexion conect = new Conexion();
                con = conect.getConnection();
                Statement st = con.createStatement();
                String sql = "INSERT INTO Compania (NombreCompania,Correo,Telefono) VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, nombreCompañia.getText());
                pst.setString(2, correo.getText());               
                pst.setString(3, telefono.getText());
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
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE "+ e , "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        telefono.transferFocus();
    }//GEN-LAST:event_telefonoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        correo.transferFocus();
    }//GEN-LAST:event_correoActionPerformed

        
    
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
            Statement st = con.createStatement();
            String sql = "update Compania set NombreCompania = ?, Correo = ?, Telefono = ?  where CodCompania = ?";
            String sql2 = "update Productos set Compania = ?  where CodCompania = ?";
            PreparedStatement pst = con.prepareStatement(sql); 
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst.setString(1, nombreCompañia.getText());
            pst.setString(2, correo.getText());
            pst.setString(3, telefono.getText());
            pst.setInt(4, Integer.parseInt(idCompañia.getText()));
            int n = pst.executeUpdate();
            pst2.setString(1, nombreCompañia.getText());
            pst2.setInt(2, Integer.parseInt(idCompañia.getText()));
            int n2 = pst2.executeUpdate();
            if (n > 0 )
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
            JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnModificarActionPerformed

    private void pantallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pantallaMouseClicked
                try
        {
            int fila = pantalla.getSelectedRow();  
            idCompañia.setText(pantalla.getValueAt(fila, 0).toString());
            nombreCompañia.setText(pantalla.getValueAt(fila, 1).toString());
            correo.setText(pantalla.getValueAt(fila, 2).toString());
            telefono.setText(pantalla.getValueAt(fila, 3).toString());
            
                     
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
                    Statement st = con.createStatement();
                    String sql = "delete from Compania where CodCompania = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(idCompañia.getText()));
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

    private void idCompañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCompañiaActionPerformed
       idCompañia.transferFocus();
    }//GEN-LAST:event_idCompañiaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JMenuItem btnCerrarS;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JMenuItem btnMenuPrincipal;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField idCompañia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreCompañia;
    private javax.swing.JTable pantalla;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
