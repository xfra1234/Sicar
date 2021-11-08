/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.MetodosreporteVentaMayoreo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class frmReporteVentaMayoreo extends javax.swing.JFrame {

    /**
     * Creates new form frmReporteVentaMayoreo
     */
    int sucursal;
    SimpleDateFormat formatomysql = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatorestameses = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoexportar = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
    String fecha1, fecha2;
    String fechauno, fechados;
    Metodos.MetodosreporteVentaMayoreo met = new MetodosreporteVentaMayoreo();
    
    public frmReporteVentaMayoreo() {
        initComponents();
        jdcfinal.setDate(new Date());
        jdcinicio.setDate(new Date());
        rbtnbodega.setSelected(true);
    }

    public int valorsucursal() {
        if (rbtnbodega.isSelected()) {
            sucursal = 3;
        } else if (rbtnmagisterio.isSelected()) {
            sucursal = 1;
        } else if (rbtncoapinole.isSelected()) {
            sucursal = 2;
        } else {
            sucursal = 0;
        }

        return sucursal;
    }

    public int RestarMeses() {
        int difM = 0;
        try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(formatorestameses.format(jdcinicio.getDate())));
            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(formatorestameses.format(jdcfinal.getDate())));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return difM;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsucursales = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jdcinicio = new com.toedter.calendar.JDateChooser();
        jdcfinal = new com.toedter.calendar.JDateChooser();
        btncrear = new javax.swing.JButton();
        rbtnbodega = new javax.swing.JRadioButton();
        rbtnmagisterio = new javax.swing.JRadioButton();
        rbtncoapinole = new javax.swing.JRadioButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 191));

        jdcinicio.setDateFormatString("dd/MM/yyyy");
        jdcinicio.setOpaque(false);

        jdcfinal.setDateFormatString("dd/MM/yyyy");
        jdcfinal.setOpaque(false);

        btncrear.setBackground(new java.awt.Color(255, 255, 191));
        btncrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        btnsucursales.add(rbtnbodega);
        rbtnbodega.setText("Bodega");
        rbtnbodega.setOpaque(false);

        btnsucursales.add(rbtnmagisterio);
        rbtnmagisterio.setText("Magisterio");
        rbtnmagisterio.setOpaque(false);

        btnsucursales.add(rbtncoapinole);
        rbtncoapinole.setText("Coapinole");
        rbtncoapinole.setOpaque(false);
        rbtncoapinole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtncoapinoleActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 255, 191));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnRegresar.setToolTipText("Menu Principal");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setOpaque(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Reporte  de Ventas Mayoreo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Guradar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnbodega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbtnmagisterio)
                                .addGap(18, 18, 18)
                                .addComponent(rbtncoapinole))
                            .addComponent(jLabel2)
                            .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jdcfinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcfinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnmagisterio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtnbodega)
                        .addComponent(rbtncoapinole)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btncrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        // TODO add your andling code here:
        if (valorsucursal() == 0) {
            JOptionPane.showMessageDialog(null, "Favor de Seleccionar una sucursal", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println(RestarMeses());
        if (RestarMeses() > 11) {
            JOptionPane.showMessageDialog(null, "Solo Puede Seleccionar un Plazo de 12 Meses", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (jdcinicio.getDate().after(jdcfinal.getDate())) {
                JOptionPane.showMessageDialog(null, "Error en las Fechas", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                fecha1 = formatomysql.format(jdcinicio.getDate()) + " 00:00:00";
                fecha2 = formatomysql.format(jdcfinal.getDate()) + " 23:59:59";
                fechauno = formatoexportar.format(jdcinicio.getDate());
                fechados = formatoexportar.format(jdcfinal.getDate());

               met.sucursales(fecha1, fecha2, fechauno, fechados, valorsucursal());
            }
        }

    }//GEN-LAST:event_btncrearActionPerformed

    private void rbtncoapinoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtncoapinoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtncoapinoleActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmPrinicipal principal = new frmPrinicipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporteVentaMayoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteVentaMayoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteVentaMayoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteVentaMayoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporteVentaMayoreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btncrear;
    private javax.swing.ButtonGroup btnsucursales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static com.toedter.calendar.JDateChooser jdcfinal;
    public static com.toedter.calendar.JDateChooser jdcinicio;
    private javax.swing.JRadioButton rbtnbodega;
    private javax.swing.JRadioButton rbtncoapinole;
    private javax.swing.JRadioButton rbtnmagisterio;
    // End of variables declaration//GEN-END:variables
}