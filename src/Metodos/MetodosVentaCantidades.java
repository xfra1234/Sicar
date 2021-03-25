/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import reportes.ReporteVentasFecha;
import reportes.conexion;

/**
 *
 * @author usuario
 */
public class MetodosVentaCantidades {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    Connection con2 = null;
    static ResultSet rs2 = null;
    private Statement stmt2 = null;
    conexion conectar = new conexion();

    Object filas[] = new Object[4];

    public void modeloTabla() {
        if (ReporteVentasFecha.controlmodelo == false) {
            ReporteVentasFecha.modelo.addColumn("ID Articulo");
            ReporteVentasFecha.modelo.addColumn("Nombre");
            ReporteVentasFecha.modelo.addColumn("Cantidad");
            ReporteVentasFecha.modelo.addColumn("Unidad");
            ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);
            ReporteVentasFecha.controlmodelo = true;
        } else {
            ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);

        }
    }

    public void buscarcantidades(String fecha1, String fecha2) {
        try {
            int id;
            double cantidad = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select articulo.art_id form,articulo.descripcion,unidad.nombre from  articulo inner join"
                    + " unidad on unidad.uni_id =articulo.unidadventa;");
            con2 = conectar.conectarMySQL();
            stmt2 = con.createStatement();

            while (rs.next()) {
                id =rs.getInt(1);
                filas[0] = id;
                filas[1] = rs.getString(2);
                rs2 = stmt2.executeQuery("select sum(detallev.cantidad) from detallev inner join venta\n"
                        + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                        + " detallev.art_id=articulo.art_id\n"
                        + "where articulo.art_id='"+id+"' and\n"
                        + "venta.fecha between '"+fecha1+"' and '"+fecha2+"';");
                while (rs2.next()) {
                    cantidad=rs2.getDouble(1);
                    
                }

                filas[2] = cantidad;
                filas[3] = rs.getString(3);
                ReporteVentasFecha.modelo.addRow(filas);
                ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
