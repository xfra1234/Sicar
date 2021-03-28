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
    conexion conectar = new conexion();
    
    public void buscarventas(String fecha1,String fecha2)
    {
        try {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select sum(detallev.importenorcon) from articulo  inner join categoria on  "
                    + "articulo.cat_id = categoria.cat_id inner join departamento on categoria.dep_id\n" +
                    "=departamento.dep_id inner join detallev on detallev.art_id = articulo.art_id inner join venta "
                    + "on detallev.ven_id = venta.ven_id where departamento.dep_id=23\n" +
                    "and venta.fecha between '"+fecha1+"' and '"+fecha2+"';");
            if(rs.next()){
                JOptionPane.showMessageDialog(null, rs.getFloat(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
