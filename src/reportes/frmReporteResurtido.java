/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.MetodosResurtido;
import Metodos.MetodosResurtidoesteaño;
import Metodos.Metodos_GenerarFecha_resurtidoBodega;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class frmReporteResurtido extends javax.swing.JFrame {

    /**
     * Creates new form frmReporteResurtido
     */
    SimpleDateFormat formatorestameses = new SimpleDateFormat("dd/MM/yyyy");
    int añoanterior = 0, mesanterior1 = 0, mesanterior2 = 0, mesanterior3 = 0;
    int añoactual, mesfuturo1 = 0, mesfuturo2 = 0, mesfuturo3 = 0;
    String fech, fech2;
    String fecha3mad;//variable para obtener el primer dial del mes de 3 meses atras
    String fehca1mud;//variable para obtener el ultimo dia del mes 1 mes atras
    String fechad3md;//Variable para obtener el primer dial del mes 1 meses adelante año ´pasadp
    String fechad1mud;// Variable para obtener el uliimo dia 3  meseses  despues año pasado
    SimpleDateFormat Mes = new SimpleDateFormat("EEEE dd MMMMM yyyy ");

    int sucursal;
    Metodos.MetodosResurtido met = new MetodosResurtido();
    Metodos.MetodosResurtidoesteaño met2 = new MetodosResurtidoesteaño();
    Metodos.Metodos_GenerarFecha_resurtidoBodega metfecha = new Metodos_GenerarFecha_resurtidoBodega();

    public frmReporteResurtido() {
        initComponents();
        cmbmes.setDate(new Date());
        rbtnbodega.setSelected(true);

    }

    public int valorsucursal() {
        if (rbtnbodega.isSelected()) {
            sucursal = 3;

        } else if (rbtnmagisterio.isSelected()) {
            sucursal = 1;
        } else if (rbtncoapinole.isSelected()) {
            sucursal = 2;
        } else if (rbtnbodegapdv.isSelected()) {
            sucursal = 4;
        } else if (rbtnmojoneras.isSelected()) {
            sucursal = 5;
        } else if (rbtnpitillal.isSelected()) {
            sucursal = 6;
        } else {
            sucursal = 0;
        }
        metfecha.generarfecha1mes(cmbmes.getDate(), sucursal);
        return sucursal;
    }

    public void Mesesañoanterior() {
        int difM = 0;
        int difA = 0;
        Calendar promfechaadelante = Calendar.getInstance();

        Calendar fechaactual = Calendar.getInstance();

        promfechaadelante.setTime(cmbmes.getDate());

////////////// Obtener fechas 3 meses atras del mismo año
        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, -3);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha3mad = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fecha3mad = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }

        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, -1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fehca1mud = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        } else {
            fehca1mud = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }
        System.out.println(fehca1mud);
        System.out.println(fecha3mad);
        /////////////////////fin ////////////////       

        ///// obtener 3 meses adelante año pasado ///////////////////////
        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, 1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechad1mud = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fechad1mud = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }

        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, 3);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechad3md = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        } else {
            fechad3md = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }

        //////////////////////// Fin //////////////////////////////////
        System.out.println(fechad1mud);
        System.out.println(fechad3md);
        Date actual = cmbmes.getDate();
        String Mesnueva;
        Mesnueva = Mes.format(actual);
        met.sucursales(fecha3mad, fehca1mud, fechad1mud, fechad3md, valorsucursal(), Mesnueva);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbComercios = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmbmes = new com.toedter.calendar.JDateChooser();
        rbtnbodega = new javax.swing.JRadioButton();
        rbtnmagisterio = new javax.swing.JRadioButton();
        rbtncoapinole = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rbtnbodegapdv = new javax.swing.JRadioButton();
        rbtnmojoneras = new javax.swing.JRadioButton();
        rbtnpitillal = new javax.swing.JRadioButton();
        rbtnnuevo = new javax.swing.JRadioButton();
        rbtnanterior = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporte Resurtido de Sucursal");
        setBackground(new java.awt.Color(255, 255, 191));

        jPanel1.setBackground(new java.awt.Color(255, 255, 191));

        cmbmes.setDateFormatString("dd/MM/yyyy");

        rdbComercios.add(rbtnbodega);
        rbtnbodega.setText("Bodega");
        rbtnbodega.setOpaque(false);

        rdbComercios.add(rbtnmagisterio);
        rbtnmagisterio.setText("Magisterio");
        rbtnmagisterio.setOpaque(false);

        rdbComercios.add(rbtncoapinole);
        rbtncoapinole.setText("Coapinole");
        rbtncoapinole.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Guardar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Reporte  Para Resurtido de Sucursal");

        rdbComercios.add(rbtnbodegapdv);
        rbtnbodegapdv.setText("Bodega pdv");
        rbtnbodegapdv.setOpaque(false);

        rdbComercios.add(rbtnmojoneras);
        rbtnmojoneras.setText("Mojoneras");
        rbtnmojoneras.setOpaque(false);

        rdbComercios.add(rbtnpitillal);
        rbtnpitillal.setText("Pitillal");
        rbtnpitillal.setOpaque(false);

        rbtnnuevo.setText("Nuevo");
        rbtnnuevo.setActionCommand("Nuevo");
        rbtnnuevo.setOpaque(false);

        rbtnanterior.setText("Anterior");
        rbtnanterior.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(cmbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnbodega)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbtnmojoneras)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnmagisterio)
                                    .addComponent(rbtnbodegapdv))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtncoapinole)
                                    .addComponent(rbtnpitillal)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(rbtnnuevo)
                                .addGap(30, 30, 30)
                                .addComponent(rbtnanterior)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnbodega)
                    .addComponent(rbtnmagisterio)
                    .addComponent(rbtncoapinole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnbodegapdv)
                    .addComponent(rbtnmojoneras)
                    .addComponent(rbtnpitillal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnanterior)
                    .addComponent(rbtnnuevo))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmPrinicipal principal = new frmPrinicipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //  Mesesañoanterior();
        if (rbtnanterior.isSelected()) {
            Mesesañoanterior();
        } else {
            valorsucursal();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporteResurtido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteResurtido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteResurtido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteResurtido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporteResurtido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private com.toedter.calendar.JDateChooser cmbmes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnanterior;
    private javax.swing.JRadioButton rbtnbodega;
    private javax.swing.JRadioButton rbtnbodegapdv;
    private javax.swing.JRadioButton rbtncoapinole;
    private javax.swing.JRadioButton rbtnmagisterio;
    private javax.swing.JRadioButton rbtnmojoneras;
    private javax.swing.JRadioButton rbtnnuevo;
    private javax.swing.JRadioButton rbtnpitillal;
    private javax.swing.ButtonGroup rdbComercios;
    // End of variables declaration//GEN-END:variables
}
