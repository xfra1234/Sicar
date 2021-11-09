/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class frmPrinicipal extends javax.swing.JFrame {

    public Image imagenFondo;
    public URL fondo;
    int iniciar = 0;

    /**
     * Creates new form frmPrinicipal
     */
    public frmPrinicipal() {

        initComponents();
        ImageIcon img = new ImageIcon("C:\\Users\\\\Cpu\\Documents\\NetBeansProjects\\Sicar\\logo.png");
//define el icon a tu JFrame
        this.setIconImage(img.getImage());

    }

    public JPanel panel = new JPanel() {
        public void paintComponet(Graphics g) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    };

    public void mostrar(JFrame reporte) {
        reporte.setLocationRelativeTo(null);
        reporte.setVisible(true);
        reporte.setResizable(false);
        this.dispose();
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
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/fondo.png"));
        Image image2 = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Imagenes/departamento.png"));
        Image image3 = icon2.getImage();
        pandepartamentos = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image3,0,0,getWidth(),getHeight(),this);
            }
        };
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/Imagenes/porcentaje.png"));
        Image image4 = icon3.getImage();
        panreporte80porciernto = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image4,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/Imagenes/resurtido.png"));
        Image image5 = icon4.getImage();
        panresurtido = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image5,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel3 = new javax.swing.JLabel();
        ImageIcon icon5 = new ImageIcon(getClass().getResource("/Imagenes/resurtido.png"));
        Image image6 = icon5.getImage();
        panresurtido1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image5,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel4 = new javax.swing.JLabel();
        ImageIcon icon9 = new ImageIcon(getClass().getResource("/Imagenes/ventas-mayoreo.jpg"));
        Image image9 = icon9.getImage();
        panventamayoreo = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image9,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 191));

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jDesktopPane1.setOpaque(false);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        jLabel1.setText("Reporte departamentos");

        pandepartamentos.setBackground(new java.awt.Color(255, 255, 191));
        pandepartamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pandepartamentos.setToolTipText("Reporte De ventas Por Departamento");
        pandepartamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pandepartamentos.setOpaque(false);
        pandepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pandepartamentosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pandepartamentosLayout = new javax.swing.GroupLayout(pandepartamentos);
        pandepartamentos.setLayout(pandepartamentosLayout);
        pandepartamentosLayout.setHorizontalGroup(
            pandepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        pandepartamentosLayout.setVerticalGroup(
            pandepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panreporte80porciernto.setBackground(new java.awt.Color(255, 255, 191));
        panreporte80porciernto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panreporte80porciernto.setToolTipText("Reporte de Productos que Conforman el 80% de ventas");
        panreporte80porciernto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panreporte80porciernto.setOpaque(false);
        panreporte80porciernto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panreporte80porcierntoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panreporte80porcierntoLayout = new javax.swing.GroupLayout(panreporte80porciernto);
        panreporte80porciernto.setLayout(panreporte80porcierntoLayout);
        panreporte80porcierntoLayout.setHorizontalGroup(
            panreporte80porcierntoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        panreporte80porcierntoLayout.setVerticalGroup(
            panreporte80porcierntoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("Productos que conforman el 80%");

        panresurtido.setBackground(new java.awt.Color(255, 255, 191));
        panresurtido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panresurtido.setToolTipText("Reporte de Resurtido sucursal");
        panresurtido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panresurtido.setOpaque(false);
        panresurtido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panresurtidoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panresurtidoLayout = new javax.swing.GroupLayout(panresurtido);
        panresurtido.setLayout(panresurtidoLayout);
        panresurtidoLayout.setHorizontalGroup(
            panresurtidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        panresurtidoLayout.setVerticalGroup(
            panresurtidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel3.setText("Reporte de Resurtido de Sucursal");

        panresurtido1.setBackground(new java.awt.Color(255, 255, 191));
        panresurtido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panresurtido1.setToolTipText("Reporte de Resurtido Bodega");
        panresurtido1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panresurtido1.setOpaque(false);
        panresurtido1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panresurtido1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panresurtido1Layout = new javax.swing.GroupLayout(panresurtido1);
        panresurtido1.setLayout(panresurtido1Layout);
        panresurtido1Layout.setHorizontalGroup(
            panresurtido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        panresurtido1Layout.setVerticalGroup(
            panresurtido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel4.setText("Reporte de Resurtido de Bodega");

        panventamayoreo.setBackground(new java.awt.Color(255, 255, 191));
        panventamayoreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panventamayoreo.setToolTipText("Reporte Venta Mayoreo");
        panventamayoreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panventamayoreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panventamayoreoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panventamayoreoLayout = new javax.swing.GroupLayout(panventamayoreo);
        panventamayoreo.setLayout(panventamayoreoLayout);
        panventamayoreoLayout.setHorizontalGroup(
            panventamayoreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        panventamayoreoLayout.setVerticalGroup(
            panventamayoreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel5.setText("Reporte Ventas Mayoreo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panresurtido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pandepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(panresurtido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panreporte80porciernto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panventamayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15)))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panventamayoreo)
                    .addComponent(pandepartamentos)
                    .addComponent(panreporte80porciernto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panresurtido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panresurtido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pandepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pandepartamentosMouseClicked
        // TODO add your handling code here:
        frmReporteDepartamento reporte = new frmReporteDepartamento();
        mostrar(reporte);
    }//GEN-LAST:event_pandepartamentosMouseClicked

    private void panreporte80porcierntoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panreporte80porcierntoMouseClicked
        // TODO add your handling code here:
        frmproductosporcentaje reporte = new frmproductosporcentaje();
        mostrar(reporte);
    }//GEN-LAST:event_panreporte80porcierntoMouseClicked

    private void panresurtidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panresurtidoMouseClicked
        // TODO add your handling code here:
        frmReporteResurtido resurtido = new frmReporteResurtido();
        mostrar(resurtido);
    }//GEN-LAST:event_panresurtidoMouseClicked

    private void panresurtido1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panresurtido1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        frmReporteResurtidoBodega resurtido = new frmReporteResurtidoBodega();
        mostrar(resurtido);
    }//GEN-LAST:event_panresurtido1MouseClicked

    private void panventamayoreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panventamayoreoMouseClicked
        // TODO add your handling code here:
        frmReporteVentaMayoreo mayoreo = new frmReporteVentaMayoreo();
        mostrar(mayoreo);

    }//GEN-LAST:event_panventamayoreoMouseClicked

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
            java.util.logging.Logger.getLogger(frmPrinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrinicipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrinicipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane pandepartamentos;
    private javax.swing.JDesktopPane panreporte80porciernto;
    private javax.swing.JDesktopPane panreporte80porciernto1;
    private javax.swing.JDesktopPane panresurtido;
    private javax.swing.JDesktopPane panresurtido1;
    private javax.swing.JDesktopPane panventamayoreo;
    // End of variables declaration//GEN-END:variables
}
