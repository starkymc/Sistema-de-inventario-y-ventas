/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;


import CapaEntidad.ConstructorVentas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import CapaDatos.VentasDAO;
import CapaEntidad.ConstructorDetalle_Venta;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian
 */
public class FrmVentas extends javax.swing.JFrame {

    VentasDAO oVentaDAO = new VentasDAO();
    
 //BOLETAS//
    void ListarBoletas(){     
          DefaultTableModel modelo=new DefaultTableModel();
        String [] titulos= {"COD","PRODUCTOS","COD VENTA","CANTIDAD","IMPORTE"};
        modelo.setColumnIdentifiers(titulos);
        ArrayList<ConstructorDetalle_Venta> lista= oVentaDAO.listarBoletaVenta();
        for(ConstructorDetalle_Venta ocomDatos:lista){
            Object data[]={ocomDatos.getCodigo(),ocomDatos.getProducto(),ocomDatos.getVenta(),ocomDatos.getCantidad(),ocomDatos.getPrecio()};
            modelo.addRow(data);
        }
        TblBoleta.setModel(modelo);
        personalizarTablaBoletas(); 
    }
     private void personalizarTablaBoletas(){
        TblBoleta.getColumnModel().getColumn(0).setPreferredWidth(50);
        TblBoleta.getColumnModel().getColumn(1).setPreferredWidth(120);
        TblBoleta.getColumnModel().getColumn(2).setPreferredWidth(100);
        TblBoleta.getColumnModel().getColumn(3).setPreferredWidth(80);
        TblBoleta.getColumnModel().getColumn(4).setPreferredWidth(80);
          
     
    }
    
       public void ReporteBoleta(String number) {
       {
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BD_VENTAS;user=sa;password=123");
            String archivo=System.getProperty("user.dir")+"\\src\\CapaNegocios\\ReporteBoleta.jasper";
            JasperReport reporte=(JasperReport) JRLoader.loadObject(archivo);
            
             Map param=new HashMap();
            param.put("number", number);
            JasperPrint jasperprint=JasperFillManager.fillReport(reporte,param,cn);
            JasperViewer visor=new JasperViewer(jasperprint,false);
            visor.setTitle ("REPORTE DE BOLETAS");
                    visor.setVisible(true);
        } catch (ClassNotFoundException | SQLException | JRException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
   }}
      
      
    public FrmVentas() {
        initComponents();
     ListarBoletas();
     txtidboletacli.requestFocusInWindow();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlbackground = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtidboletacli = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblBoleta = new javax.swing.JTable();
        lblimgusuario = new javax.swing.JLabel();
        pnlarriba1 = new javax.swing.JPanel();
        pnlarriba = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Boleta Cliente");
        setMinimumSize(new java.awt.Dimension(880, 600));
        setPreferredSize(new java.awt.Dimension(880, 650));
        setResizable(false);

        pnlbackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlbackground.setPreferredSize(new java.awt.Dimension(884, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Boleta Cliente:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 40, 110, 17);

        txtidboletacli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidboletacliKeyTyped(evt);
            }
        });
        jPanel1.add(txtidboletacli);
        txtidboletacli.setBounds(150, 30, 50, 30);

        btnReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cuenta.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setBorder(null);
        btnReporte.setBorderPainted(false);
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setFocusPainted(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte);
        btnReporte.setBounds(220, 20, 120, 40);

        jLabel1.setFont(new java.awt.Font("Javanese Text", 1, 28)); // NOI18N
        jLabel1.setText("Lista de boletas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 100, 316, 43);

        TblBoleta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TblBoleta);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 592, 268);

        lblimgusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boleta.png"))); // NOI18N

        pnlarriba1.setBackground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout pnlarriba1Layout = new javax.swing.GroupLayout(pnlarriba1);
        pnlarriba1.setLayout(pnlarriba1Layout);
        pnlarriba1Layout.setHorizontalGroup(
            pnlarriba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
        );
        pnlarriba1Layout.setVerticalGroup(
            pnlarriba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlbackgroundLayout = new javax.swing.GroupLayout(pnlbackground);
        pnlbackground.setLayout(pnlbackgroundLayout);
        pnlbackgroundLayout.setHorizontalGroup(
            pnlbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbackgroundLayout.createSequentialGroup()
                .addComponent(lblimgusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlarriba1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlbackgroundLayout.setVerticalGroup(
            pnlbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbackgroundLayout.createSequentialGroup()
                .addGroup(pnlbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlbackgroundLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblimgusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlbackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlarriba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlarriba.setBackground(new java.awt.Color(51, 0, 51));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boletalogo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Javanese Text", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Boletas");

        javax.swing.GroupLayout pnlarribaLayout = new javax.swing.GroupLayout(pnlarriba);
        pnlarriba.setLayout(pnlarribaLayout);
        pnlarribaLayout.setHorizontalGroup(
            pnlarribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlarribaLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlarribaLayout.setVerticalGroup(
            pnlarribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
            .addGroup(pnlarribaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlarriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlbackground, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlarriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlbackground, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
         String num= txtidboletacli.getText();
        ReporteBoleta(num);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtidboletacliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidboletacliKeyTyped
         char validar= evt.getKeyChar();
      if(Character.isLetter(validar)){
          getToolkit().beep();
          evt.consume();
          JOptionPane.showMessageDialog((rootPane), "Ingresar solo Números");
          
      }
              if(txtidboletacli.getText().length()>=4)
        {
             getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog((rootPane), "Solo se permite 4 digitos");
        }
    }//GEN-LAST:event_txtidboletacliKeyTyped

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
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblBoleta;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblimgusuario;
    private javax.swing.JPanel pnlarriba;
    private javax.swing.JPanel pnlarriba1;
    private javax.swing.JPanel pnlbackground;
    private javax.swing.JTextField txtidboletacli;
    // End of variables declaration//GEN-END:variables
}
