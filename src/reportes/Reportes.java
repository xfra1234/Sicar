/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import Metodos.conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 *///
public class Reportes {

    /**
     * @param args the command line arguments
     */
    static int iniciar = 0;

    public static void main(String[] args) {
        // TODO code application logic here

//        conexion cone = new conexion();
//        cone.conectarMySQL();
        if (iniciar > 0) {
            JOptionPane.showMessageDialog(null,"El sistema ya se encuentra ejecutandose");

        } else {
            frmPrinicipal venta = new frmPrinicipal();
            venta.setLocationRelativeTo(null);
            venta.setVisible(true);
            iniciar=iniciar+1;
        }

    }

}
