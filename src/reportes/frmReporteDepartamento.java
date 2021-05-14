/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.MetodosReporteDepartamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class frmReporteDepartamento extends javax.swing.JFrame {

    /**
     * Creates new form frmReporteDepartamento
     */
    Metodos.MetodosReporteDepartamento met = new MetodosReporteDepartamento();
    SimpleDateFormat formatomysql = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatorestameses = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoexportar = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
    String fecha1, fecha2;
    String fechauno, fechados;
     int sucursal;

    public frmReporteDepartamento() {
        initComponents();
        jdcfinal.setDate(new Date());
        jdcinicio.setDate(new Date());
        ImageIcon img = new ImageIcon("C:\\Users\\\\Cpu\\Documents\\NetBeansProjects\\Sicar\\logo.png");
//define el icon a tu JFrame
        this.setIconImage(img.getImage());
        rbtnbodega.setSelected(true);
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

//    private void ultimodiames() {
//        String date = prueba.format(jdcfinal.getDate());
//        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        convertedDate = convertedDate.withDayOfMonth(
//                convertedDate.getMonth().length(convertedDate.isLeapYear()));
//        String cadena = convertedDate + "";
//        String cadena2 = formatomysql.format(jdcfinal.getDate());
//        if (cadena2.equals(cadena)) {
//            fecha1 = formatomysql.format(jdcinicio.getDate()) + " 06:00:00";
//            fecha2 = formatomysql.format(jdcfinal.getDate()) + " 21:00:00";
//
//        } else {
//            cadena = cadena.substring(8, 10);
//            JOptionPane.showMessageDialog(null, cadena);
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(jdcfinal.getDate()); // Configuramos la fecha que se recibe
//            calendar.add(Calendar.MONTH, -1);
//            String fechaultimodia = formatomysql.format(calendar.getTime());
//            fechaultimodia = fechaultimodia.substring(0, 8) + calendar.getActualMaximum(calendar.DAY_OF_MONTH) + " 21:00:00";
//
//            calendar.setTime(jdcfinal.getDate());
//            calendar.add(Calendar.MONTH, 0);
//            String fechaprimerdia = formatomysql.format(calendar.getTime());
//            fechaprimerdia = fechaprimerdia.substring(0, 8) + calendar.getActualMinimum(calendar.DAY_OF_MONTH) + " 06:00:00";
//
//        }
//
//    }
     public int valorsucursal(){
         if(rbtnbodega.isSelected()){
             sucursal=3;
         }else if(rbtnmagisterio.isSelected()){
             sucursal=1;
         }else if(rbtncoapinole.isSelected()){
             sucursal=2;
         }else{
             sucursal=0;
         }
         
         return sucursal;
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grbtnsucursal = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jdcinicio = new com.toedter.calendar.JDateChooser();
        jdcfinal = new com.toedter.calendar.JDateChooser();
        btncrear = new javax.swing.JButton();
        rbtnbodega = new javax.swing.JRadioButton();
        rbtnmagisterio = new javax.swing.JRadioButton();
        rbtncoapinole = new javax.swing.JRadioButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporte Por Departamentos");
        setBackground(new java.awt.Color(255, 255, 191));

        jPanel1.setBackground(new java.awt.Color(255, 255, 191));

        jdcinicio.setDateFormatString("dd/MM/yyyy");
        jdcinicio.setOpaque(false);

        jdcfinal.setDateFormatString("dd/MM/yyyy");
        jdcfinal.setOpaque(false);

        btncrear.setText("Crear");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        grbtnsucursal.add(rbtnbodega);
        rbtnbodega.setText("Bodega");
        rbtnbodega.setOpaque(false);

        grbtnsucursal.add(rbtnmagisterio);
        rbtnmagisterio.setText("Magisterio");
        rbtnmagisterio.setOpaque(false);

        grbtnsucursal.add(rbtncoapinole);
        rbtncoapinole.setText("Coapinole");
        rbtncoapinole.setOpaque(false);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbtnbodega)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnmagisterio)
                                .addGap(18, 18, 18)
                                .addComponent(rbtncoapinole))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnRegresar)
                        .addGap(54, 54, 54)
                        .addComponent(btncrear)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnbodega)
                    .addComponent(rbtnmagisterio)
                    .addComponent(rbtncoapinole))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncrear)
                    .addComponent(btnRegresar))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        // TODO add your andling code here:
        if(valorsucursal()==0){
            JOptionPane.showMessageDialog(null, "Favor de Seleccionar una sucursal","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println(RestarMeses());
        if (RestarMeses() > 11) {
            JOptionPane.showMessageDialog(null, "Solo Puede Seleccionar un Plazo de 12 Meses", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (jdcinicio.getDate().after(jdcfinal.getDate())) {
                JOptionPane.showMessageDialog(null, "Error en las Fechas", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                fecha1 = formatomysql.format(jdcinicio.getDate()) + " 06:00:00";
                fecha2 = formatomysql.format(jdcfinal.getDate()) + " 21:00:00";
                fechauno = formatoexportar.format(jdcinicio.getDate());
                fechados = formatoexportar.format(jdcfinal.getDate());

                met.modificaexcel(fecha1, fecha2,fechauno,fechados,valorsucursal());
            }
        }


    }//GEN-LAST:event_btncrearActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmPrinicipal principal=new frmPrinicipal();
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
            java.util.logging.Logger.getLogger(frmReporteDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporteDepartamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btncrear;
    private javax.swing.ButtonGroup grbtnsucursal;
    private javax.swing.JPanel jPanel1;
    public static com.toedter.calendar.JDateChooser jdcfinal;
    public static com.toedter.calendar.JDateChooser jdcinicio;
    private javax.swing.JRadioButton rbtnbodega;
    private javax.swing.JRadioButton rbtncoapinole;
    private javax.swing.JRadioButton rbtnmagisterio;
    // End of variables declaration//GEN-END:variables
}
