/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.MetodosVentaCantidades;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GHIA
 */
public class ReporteVentasFecha extends javax.swing.JFrame {

    /**
     * Creates new form ReporteVentasFecha
     */
    Date fecha1, fecha2;
    SimpleDateFormat formatomysql = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoexport = new SimpleDateFormat("dd-MM-yyyy");
    
    SimpleDateFormat formatoexportar = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
    Metodos.MetodosVentaCantidades met = new MetodosVentaCantidades();
    String fechainicio,fechafinal;
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static boolean controlmodelo = false;
    
    public static  DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    public ReporteVentasFecha() {
        initComponents();
        met.modeloTabla();
        tamañopantalla();
    }
    
    public void tamañopantalla(){
        Toolkit t = Toolkit.getDefaultToolkit();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(new Dimension((int) (screenSize.width/1.8), (int) (screenSize.height/1.4)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdcfin = new com.toedter.calendar.JDateChooser();
        jdcinicio = new com.toedter.calendar.JDateChooser();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbuscar = new javax.swing.JTable();
        btnexportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdcfin.setDateFormatString("dd/MM/y");

        jdcinicio.setDateFormatString("dd/MM/y");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tblbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblbuscar);

        btnexportar.setText("Exportar");
        btnexportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jdcfin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnexportar)
                    .addComponent(btnbuscar))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jdcfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addGap(65, 65, 65)
                        .addComponent(btnexportar)
                        .addGap(0, 284, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        fecha1 = jdcinicio.getDate();
        fecha2 = jdcfin.getDate();
        fechainicio = formatomysql.format(fecha1)+" 07:00:00";
        fechafinal = formatomysql.format(fecha2)+" 20:00:00";
        met.buscarcantidades(fechainicio, fechafinal);
       
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnexportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportarActionPerformed
        // TODO add your handling code here:
        fecha1 = jdcinicio.getDate();
        fecha2 = jdcfin.getDate();
        fechainicio = formatoexport.format(fecha1);
        fechafinal = formatoexport.format(fecha2);
        met.GeneraExcel(tblbuscar,fechainicio,fechafinal);
        
    }//GEN-LAST:event_btnexportarActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteVentasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteVentasFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnexportar;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.toedter.calendar.JDateChooser jdcfin;
    public static com.toedter.calendar.JDateChooser jdcinicio;
    public static javax.swing.JTable tblbuscar;
    // End of variables declaration//GEN-END:variables
}
