/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.MetodosResurtido;
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
    Metodos.MetodosResurtido met= new MetodosResurtido();
    public frmReporteResurtido() {
        initComponents();
        cmbmes.setDate(new Date());
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
            fecha3mad = "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + "-" + fechaactual.get(fechaactual.YEAR) + " 00:00:00";
        } else {
            fecha3mad = (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + "-" + fechaactual.get(fechaactual.YEAR) + " 00:00:00";
        }

        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, -1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fehca1mud = "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + "-" + fechaactual.get(fechaactual.YEAR) + " 23:59:59";
        } else {
            fehca1mud = (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + "-" + fechaactual.get(fechaactual.YEAR) + " 23:59:59";
        }

 /////////////////////fin ////////////////       
     
 
 ///// obtener 3 meses adelante año pasado ///////////////////////
        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, 1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechad1mud = "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + "-" + (fechaactual.get(fechaactual.YEAR)-1) + " 00:00:00";
        } else {
            fechad1mud = (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + "-" + (fechaactual.get(fechaactual.YEAR)-1) + " 00:00:00";
        }

        fechaactual.setTime(cmbmes.getDate());
        fechaactual.add(fechaactual.MONTH, 3);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechad3md = "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + "-" + (fechaactual.get(fechaactual.YEAR)-1) + " 23:59:59";
        } else {
            fechad3md = (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + "-" +(fechaactual.get(fechaactual.YEAR)-1) + " 23:59:59";
        }
        
 //////////////////////// Fin //////////////////////////////////
           
         met.resurtido(fehca1mud, fecha3mad, fechad1mud, fechad3md);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cmbmes = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbmes.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(cmbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(cmbmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Mesesañoanterior();
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
    private com.toedter.calendar.JDateChooser cmbmes;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
