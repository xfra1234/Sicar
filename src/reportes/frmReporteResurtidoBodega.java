/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.MetodosResurtidosoloproductos_esteaño;
import Metodos.MetodosResurtido_1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class frmReporteResurtidoBodega extends javax.swing.JFrame {

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
    SimpleDateFormat Mes = new SimpleDateFormat("EEEE dd MMMMM yyyy");

    int sucursal;
    Metodos.MetodosResurtido_1 met = new MetodosResurtido_1();
    Metodos.MetodosResurtidosoloproductos_esteaño met2 = new MetodosResurtidosoloproductos_esteaño();

    public frmReporteResurtidoBodega() {
        initComponents();
        cmbmes.setDate(new Date());
        rbtnbodega.setSelected(true);
        rdbCompleto.setSelected(true);
    }

   public int valorsucursal(){
         if(rbtnbodega.isSelected()){
             sucursal=3;
         }else if(rbtnmagisterio.isSelected()){
             sucursal=1;
         }else if(rbtncoapinole.isSelected()){
             sucursal=2;
         }else if(rbtnbodegapdv.isSelected()){
             sucursal=4;
         }else if(rbtnmojoneras.isSelected()){
             sucursal=5;
         }
         else{
             sucursal=0;
         }
         
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
        if (rdbCompleto.isSelected()) {
            met.sucursales(fecha3mad, fehca1mud, fechad1mud, fechad3md, valorsucursal(), Mesnueva);
        } else {
            met2.sucursales(fecha3mad, fehca1mud, fechad1mud, fechad3md, valorsucursal(), Mesnueva);
        }

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
        jPanel1 = new javax.swing.JPanel();
        cmbmes = new com.toedter.calendar.JDateChooser();
        rbtnbodega = new javax.swing.JRadioButton();
        rbtnmagisterio = new javax.swing.JRadioButton();
        rbtncoapinole = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rdbMensual = new javax.swing.JRadioButton();
        rdbCompleto = new javax.swing.JRadioButton();
        rbtnbodegapdv = new javax.swing.JRadioButton();
        rbtnmojoneras = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporte Resurtido de Bodega");
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

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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
        jLabel1.setText("Reporte  Para Resurtido de Bodega");

        buttonGroup1.add(rdbMensual);
        rdbMensual.setText("Mensual");
        rdbMensual.setActionCommand("rdbmensual");
        rdbMensual.setOpaque(false);

        buttonGroup1.add(rdbCompleto);
        rdbCompleto.setText("Completo");
        rdbCompleto.setOpaque(false);

        rdbComercios.add(rbtnbodegapdv);
        rbtnbodegapdv.setText("Bodega pdv");
        rbtnbodegapdv.setOpaque(false);

        rdbComercios.add(rbtnmojoneras);
        rbtnmojoneras.setText("Mojoneras");
        rbtnmojoneras.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(rbtnmojoneras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnbodega)
                        .addGap(35, 35, 35)
                        .addComponent(rbtnmagisterio)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnbodegapdv))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtncoapinole)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbMensual)
                        .addGap(84, 84, 84))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(27, 27, 27)
                .addComponent(cmbmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnbodega)
                    .addComponent(rbtnmagisterio)
                    .addComponent(rbtncoapinole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnmojoneras)
                    .addComponent(rbtnbodegapdv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbCompleto)
                    .addComponent(rdbMensual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        Mesesañoanterior();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser cmbmes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnbodega;
    private javax.swing.JRadioButton rbtnbodegapdv;
    private javax.swing.JRadioButton rbtncoapinole;
    private javax.swing.JRadioButton rbtnmagisterio;
    private javax.swing.JRadioButton rbtnmojoneras;
    private javax.swing.ButtonGroup rdbComercios;
    private javax.swing.JRadioButton rdbCompleto;
    private javax.swing.JRadioButton rdbMensual;
    // End of variables declaration//GEN-END:variables
}
