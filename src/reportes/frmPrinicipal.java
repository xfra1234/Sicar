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
import javax.swing.JOptionPane;
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
        ImageIcon icon10 = new ImageIcon(getClass().getResource("/Imagenes/ventas diaria.jpg"));
        Image image10 = icon10.getImage();
        panventadiaria = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image10,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel4 = new javax.swing.JLabel();
        ImageIcon icon11 = new ImageIcon(getClass().getResource("/Imagenes/servicio-domicilio.png"));
        Image image11 = icon11.getImage();
        panventadomicilio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image11,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel5 = new javax.swing.JLabel();
        ImageIcon icon5 = new ImageIcon(getClass().getResource("/Imagenes/resurtido.png"));
        Image image6 = icon5.getImage();
        panresurtido2 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image5,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel6 = new javax.swing.JLabel();
        ImageIcon icon9 = new ImageIcon(getClass().getResource("/Imagenes/ventas-mayoreo.jpg"));
        Image image9 = icon9.getImage();
        panventamayoreo = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image9,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel7 = new javax.swing.JLabel();
        ImageIcon icon12 = new ImageIcon(getClass().getResource("/Imagenes/mayoreo.png"));
        Image image12 = icon12.getImage();
        panventamayoreotodo = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image12,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel8 = new javax.swing.JLabel();

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
            .addGap(0, 244, Short.MAX_VALUE)
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
            .addGap(0, 118, Short.MAX_VALUE)
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
            .addGap(0, 118, Short.MAX_VALUE)
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

        panventadiaria.setBackground(new java.awt.Color(255, 255, 191));
        panventadiaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panventadiaria.setToolTipText("Reporte de Resurtido Bodega");
        panventadiaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panventadiaria.setOpaque(false);
        panventadiaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panventadiariaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panventadiariaLayout = new javax.swing.GroupLayout(panventadiaria);
        panventadiaria.setLayout(panventadiariaLayout);
        panventadiariaLayout.setHorizontalGroup(
            panventadiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panventadiariaLayout.setVerticalGroup(
            panventadiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel4.setText("Reporte de Resurtido de Bodega");

        panventadomicilio.setBackground(new java.awt.Color(255, 255, 191));
        panventadomicilio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panventadomicilio.setToolTipText("Reporte Venta Mayoreo");
        panventadomicilio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panventadomicilio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panventadomicilioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panventadomicilioLayout = new javax.swing.GroupLayout(panventadomicilio);
        panventadomicilio.setLayout(panventadomicilioLayout);
        panventadomicilioLayout.setHorizontalGroup(
            panventadomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        panventadomicilioLayout.setVerticalGroup(
            panventadomicilioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel5.setText("Reporte Ventas Mayores a $100");

        panresurtido2.setBackground(new java.awt.Color(255, 255, 191));
        panresurtido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panresurtido2.setToolTipText("Reporte de Resurtido Bodega");
        panresurtido2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panresurtido2.setOpaque(false);
        panresurtido2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panresurtido2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panresurtido2Layout = new javax.swing.GroupLayout(panresurtido2);
        panresurtido2.setLayout(panresurtido2Layout);
        panresurtido2Layout.setHorizontalGroup(
            panresurtido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        panresurtido2Layout.setVerticalGroup(
            panresurtido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel6.setText("Reporte Ventas Diaria");

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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panventamayoreoLayout.setVerticalGroup(
            panventamayoreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setText("Reporte Venta a Domicilio");

        panventamayoreotodo.setBackground(new java.awt.Color(255, 255, 191));
        panventamayoreotodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panventamayoreotodo.setToolTipText("Reporte de Resurtido Bodega");
        panventamayoreotodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panventamayoreotodo.setOpaque(false);
        panventamayoreotodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panventamayoreotodoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panventamayoreotodoLayout = new javax.swing.GroupLayout(panventamayoreotodo);
        panventamayoreotodo.setLayout(panventamayoreotodoLayout);
        panventamayoreotodoLayout.setHorizontalGroup(
            panventamayoreotodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        panventamayoreotodoLayout.setVerticalGroup(
            panventamayoreotodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jLabel8.setText("Reporte Ventas Mayoreo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panresurtido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pandepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panreporte80porciernto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(panresurtido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panventadiaria)
                            .addComponent(panventamayoreo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panventamayoreotodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panventadomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pandepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panresurtido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panventamayoreo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(panreporte80porciernto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panventadomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panresurtido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panventadiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panventamayoreotodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8))
                            .addComponent(jLabel4))))
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

    private void panventadiariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panventadiariaMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        frmReporteVentaDiario diaria = new frmReporteVentaDiario();
        mostrar(diaria);
    }//GEN-LAST:event_panventadiariaMouseClicked

    private void panventadomicilioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panventadomicilioMouseClicked
        // TODO add your handling code here:
        frmReporteVentasDomicilio domicilio = new frmReporteVentasDomicilio();
        mostrar(domicilio);

    }//GEN-LAST:event_panventadomicilioMouseClicked

    private void panresurtido2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panresurtido2MouseClicked
        // TODO add your handling code here:
        frmReporteResurtidoBodega bodega = new frmReporteResurtidoBodega();
        mostrar(bodega);
    }//GEN-LAST:event_panresurtido2MouseClicked

    private void panventamayoreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panventamayoreoMouseClicked
        // TODO add your handling code here:
        frmReporteVentaMayoreo mayoreo = new frmReporteVentaMayoreo();
        mostrar(mayoreo);
    }//GEN-LAST:event_panventamayoreoMouseClicked

    private void panventamayoreotodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panventamayoreotodoMouseClicked
        // TODO add your handling code here:
        frmReporteVentasMayoreoTodo mayoreo = new frmReporteVentasMayoreoTodo();
        mostrar(mayoreo);
    
    }//GEN-LAST:event_panventamayoreotodoMouseClicked

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane pandepartamentos;
    private javax.swing.JDesktopPane panreporte80porciernto;
    private javax.swing.JDesktopPane panresurtido;
    private javax.swing.JDesktopPane panresurtido2;
    private javax.swing.JDesktopPane panventadiaria;
    private javax.swing.JDesktopPane panventadomicilio;
    private javax.swing.JDesktopPane panventamayoreo;
    private javax.swing.JDesktopPane panventamayoreotodo;
    // End of variables declaration//GEN-END:variables
}
