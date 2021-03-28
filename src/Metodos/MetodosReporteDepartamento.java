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

/**
 *
 * @author usuario
 */
public class MetodosReporteDepartamento {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;

    Connection con2 = null;
    static ResultSet rs2 = null;
    private Statement stmt2 = null;

    Connection con3 = null;
    static ResultSet rs3 = null;
    private Statement stmt3 = null;

    conexion conectar = new conexion();
    Object datos[] = new Object[3];

    public void buscarventas(String fecha1, String fecha2, String fechadiaprimero, String fechadiaultimo) {
        if ("".equals(fechadiaprimero) || "".equals(fechadiaultimo)) {

        }
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs2=stmt.executeQuery("SET lc_time_names = 'es_ES';");
            rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importenorcon) as suma "
                    + ",year(venta.fecha) as año\n"
                    + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                    + "on articulo.art_id = detallev.art_id\n"
                    + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                    + "on departamento.dep_id = categoria.dep_id\n"
                    + "where departamento.dep_id = 23 and venta.fecha >= date_sub('"+fecha1+"', interval 0 month)"
                    + " and venta.fecha <= date_sub('"+fecha2+"', interval 0 month)  group by month(fecha ) ;");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getFloat(2);
                datos[2] = rs.getString(3);
                JOptionPane.showMessageDialog(null, "Mes "+datos[0] + " total " + datos[1] + " Año "+datos[2]);
            }
//           
//            con = conectar.conectarMySQL();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select sum(detallev.importenorcon) from articulo  inner join categoria on  "
//                    + "articulo.cat_id = categoria.cat_id inner join departamento on categoria.dep_id\n"
//                    + "=departamento.dep_id inner join detallev on detallev.art_id = articulo.art_id inner join venta "
//                    + "on detallev.ven_id = venta.ven_id where departamento.dep_id=23\n"
//                    + "and venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
//           while (rs.next()) {
//                datos[1] = rs.getFloat(1);
//            }
//           
//            con = conectar.conectarMySQL();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select sum(detallev.importenorcon) from articulo  inner join categoria on  "
//                    + "articulo.cat_id = categoria.cat_id inner join departamento on categoria.dep_id\n"
//                    + "=departamento.dep_id inner join detallev on detallev.art_id = articulo.art_id inner join venta "
//                    + "on detallev.ven_id = venta.ven_id where departamento.dep_id=24\n"
//                    + "and venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
//           while (rs.next()) {
//                datos[1] = rs.getFloat(1);
//            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
