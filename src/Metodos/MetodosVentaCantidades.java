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
    static ResultSet rs2 = null;
    private Statement stmt = null;
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
     
     public void buscarcantidades(String fecha1,String fecha2){
         try {
             double cantidad = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select articulo.art_id form,articulo.descripcion from  articulo;");
            while(rs.next())
            {
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                rs2=stmt.executeQuery("select sum(detallev.cantidad) from detallev inner join venta on "
                        + "detallev.ven_id = venta.ven_id inner join articulo "
                        + "on detallev.art_id=articulo.art_id" +
                        "where articulo.art_id=4 and venta.fecha"
                        + " between '2021-03-24 07:00:00' and '2021-03-24 20:00:00';");
                if(rs.next())
                {
                    cantidad=rs.getDouble(1);
                }
                
                filas[3]=cantidad;
                ReporteVentasFecha.modelo.addRow(filas);
                ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);
                
            }
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
         }
     }
    
   
}
