/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.Metodosporcentajeproducto;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author GHIA
 */
public class frmproductosporcentaje extends javax.swing.JFrame {

    /**
     * Creates new form frmproductosporcentaje
     */
    Date fecha1, fecha2;
    SimpleDateFormat formatomysql = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoexport = new SimpleDateFormat("dd-MM-yyyy");

    SimpleDateFormat formatoexportar = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
    Metodos.Metodosporcentajeproducto met = new Metodosporcentajeproducto();
    String fechainicio, fechafinal;
    public static boolean controlmodelo = false;
    String fechauno, fechados;

    public frmproductosporcentaje() {
        initComponents();
        jdcfin.setDate(new Date());
        jdcinicio.setDate(new Date());
        ImageIcon img = new ImageIcon("C:\\Users\\\\Cpu\\Documents\\NetBeansProjects\\Sicar\\logo.png");
//define el icon a tu JFrame
        this.setIconImage(img.getImage());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporte de Productos 80%");

        jdcfin.setDateFormatString("dd/MM/y");

        jdcinicio.setDateFormatString("dd/MM/y");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jdcfin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnbuscar)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(btnbuscar)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        fecha1 = jdcinicio.getDate();
        fecha2 = jdcfin.getDate();

        fechainicio = formatomysql.format(fecha1) + " 07:00:00";
        fechafinal = formatomysql.format(fecha2) + " 20:00:00";
        fechauno = formatoexportar.format(fecha1);
        fechados = formatoexportar.format(fecha2);

        //met.buscarcantidades(fechainicio, fechafinal);
        if (jdcinicio.getDate().after(jdcfin.getDate())) {
            JOptionPane.showMessageDialog(null, "Error en las Fechas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            met.prueba(fechainicio, fechafinal, fechauno, fechados);
        }


    }//GEN-LAST:event_btnbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmproductosporcentaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmproductosporcentaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmproductosporcentaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmproductosporcentaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmproductosporcentaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    public static com.toedter.calendar.JDateChooser jdcfin;
    public static com.toedter.calendar.JDateChooser jdcinicio;
    // End of variables declaration//GEN-END:variables
}
