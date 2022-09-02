/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;
import CapaEntidad.ConstructorCaja;
import CapaDatos.CajaDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gian
 */
public class FrmCaja extends javax.swing.JFrame {
public static String monto="";
   CajaDAO oCajaDAO = new CajaDAO();
    public void fecha_actual(){
         Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formateador.format(fechaActual);
        txtFecha.setText(fecha);
        txtFecha.setEditable(false);
    } 
     void limpiar(){    
       
        txtMontoFinal.setText("");

    }
    void activarCajas(boolean v){
    
        txtMontoFinal.setEnabled(v);
       ;
       
       
   
        
        
    }
    void activarBotones(boolean botonAgregar,boolean botonBuscar,boolean botonActualizar,boolean botonEliminar){
        btnAgregar.setEnabled(botonAgregar);
        btnBuscar.setEnabled(botonBuscar);
        btnModificar.setEnabled(botonActualizar);
        btnEliminar.setEnabled(botonEliminar);   
    }

      void listar(){
          DefaultTableModel modelo=new DefaultTableModel();
        String [] titulos= {"CODIGO","MONTO FINAL","FECHA"};
        modelo.setColumnIdentifiers(titulos);
        ArrayList<ConstructorCaja> lista= oCajaDAO.listarCaja();
        for(ConstructorCaja ocomDatos:lista){
            Object data[]={ocomDatos.getCodigo(),ocomDatos.getMontoFinal(),ocomDatos.getFecha()};
            modelo.addRow(data);
        }
        tblCaja.setModel(modelo);
        personalizarTabla();   
    }
    private void personalizarTabla(){
        tblCaja.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblCaja.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCaja.getColumnModel().getColumn(2).setPreferredWidth(100);
             
    } 
    void mensaje(String men){
        JOptionPane.showMessageDialog(this, men,"Aviso",1);
    }
    
    public int id_auto(){
         int id_max2 = 1;
       
        
        try{
            id_max2 = oCajaDAO.auto_increm("SELECT MAX(IDCAJA) FROM CAJA;");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return id_max2;
        
    }
    public FrmCaja() {
        initComponents();
        this.setLocationRelativeTo(null);
        listar();
        activarCajas(false); 
        activarBotones(false,true,false,false);
          this.txtIdcaja.setText(String.valueOf(id_auto()));
          fecha_actual();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaja = new javax.swing.JTable();
        txtFecha = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtMontoFinal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdcaja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caja");
        setMinimumSize(new java.awt.Dimension(880, 580));
        setPreferredSize(new java.awt.Dimension(880, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCaja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCaja);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 790, 190));

        txtFecha.setEnabled(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 122, 31));

        btnBuscar.setBackground(new java.awt.Color(204, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        btnNuevo.setBackground(new java.awt.Color(204, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/archivo-nuevo (1).png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 110, -1));

        btnAgregar.setBackground(new java.awt.Color(204, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gasto.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, -1));

        btnModificar.setBackground(new java.awt.Color(204, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 130, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 120, -1));

        txtMontoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoFinalKeyTyped(evt);
            }
        });
        jPanel1.add(txtMontoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 120, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE CAJA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 520, 54));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cajaimg.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 150));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Id Caja:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        txtIdcaja.setEnabled(false);
        txtIdcaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdcajaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdcaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 67, 31));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Monto Final:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      try{
        ConstructorCaja oCaja;
        int dato=Integer.parseInt(JOptionPane.showInputDialog("Codigo a buscar "));
        oCaja=oCajaDAO.buscarCaja(dato);
        if(oCaja==null){
            mensaje("CODIGO NO EXISTE");
            limpiar();
            activarBotones(false,false,false,false);
            activarCajas(false);
        }else{
            txtIdcaja.setText(""+oCaja.getCodigo());
            
            txtMontoFinal.setText(""+oCaja.getMontoFinal());
            txtFecha.setText(oCaja.getFecha());

            activarBotones(false,false,true,true);
            activarCajas(true);
        }
      }catch(Exception ex){
              System.out.println("Buscar : "+ex.getMessage());
      }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
      
        try{
        if(btnNuevo.getText().equalsIgnoreCase("Nuevo")){
            limpiar();
            activarBotones(true,false,false,false);
            activarCajas(true);
            btnNuevo.setText("Cancelar");
            this.txtIdcaja.setText(String.valueOf(id_auto()));
        }else {
            limpiar();
            activarBotones(false,true,false,false);
            activarCajas(false);
            btnNuevo.setText("Nuevo");
           
        }
         }catch(Exception ex){
           System.out.println("Nuevo : "+ex.getMessage());
      }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            String m=oCajaDAO.agregarCaja(new ConstructorCaja(Integer.parseInt(txtIdcaja.getText()),Float.parseFloat(txtMontoFinal.getText()),txtFecha.getText()));
            mensaje(m);
            monto=txtMontoFinal.getText();
            listar();
            limpiar();
            this.txtIdcaja.setText(String.valueOf(id_auto()));
            activarBotones(false,true,false,false);
            activarCajas(false);
            btnNuevo.setText("Nuevo");
        } catch (Exception ex) {
            System.out.println("Agregar : "+ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       try{
        
        String m=oCajaDAO.actualizarCaja(new ConstructorCaja(Integer.parseInt(txtIdcaja.getText()),Float.parseFloat(txtMontoFinal.getText()),txtFecha.getText()));
        mensaje(m);
        monto=txtMontoFinal.getText();
        listar();
        limpiar();
       this.txtIdcaja.setText(String.valueOf(id_auto()));
        activarBotones(false,true,false,false);
        activarCajas(false);
        }catch(Exception ex){
           System.out.println("Modificar : "+ex.getMessage());
      }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
try{
        String m=oCajaDAO.eliminarCaja(Integer.parseInt(txtIdcaja.getText()));
        mensaje(m);
        listar();
        limpiar();
        this.txtIdcaja.setText(String.valueOf(id_auto()));
        activarBotones(false,true,false,false);
        activarCajas(false);
        }catch(Exception ex){
           System.out.println("Eliminar : "+ex.getMessage());
      }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtMontoFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoFinalKeyTyped

        int key = evt.getKeyChar();
       
       boolean numeros = key >=48 && key <= 57;
        if (!numeros)
        {
             getToolkit().beep();
            evt.consume();
           JOptionPane.showMessageDialog((rootPane), "Ingresar solo Números");
        }
        
        if(txtMontoFinal.getText().length()>=4)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoFinalKeyTyped

    private void txtIdcajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdcajaKeyTyped
    
    }//GEN-LAST:event_txtIdcajaKeyTyped

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
            java.util.logging.Logger.getLogger(FrmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCaja;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdcaja;
    private javax.swing.JTextField txtMontoFinal;
    // End of variables declaration//GEN-END:variables
}