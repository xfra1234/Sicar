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
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Metodossalidaproducto {

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
    protected ArrayList<Integer> idNumeros = new ArrayList();
    protected ArrayList<Float> Cantidadproductoventas = new ArrayList();
    protected ArrayList<String> Nombreproducto = new ArrayList();
    protected ArrayList<Integer> Cantidadproductotraspasocoap = new ArrayList();
    protected ArrayList<Integer> Cantidadproductotraspasmag = new ArrayList();
    int contador = 0;

    public void tomadatos(String fecha1, String fecha2) {
        try {

            ////////////////////////////// mando llamar todos los articulos 
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select articulo.art_id from articulo inner join"
                    + " categoria on categoria.cat_id = articulo.cat_id  where articulo.status !=-1  order"
                    + " by categoria.nombre,articulo.descripcion");
            while (rs.next()) {
                int id = rs.getInt(1);
                ////////////////////////// mando a almacenar los que no sean subproductos
                con2 = conectar.conectarMySQL();
                stmt2 = con.createStatement();
                rs2 = stmt2.executeQuery("select paquete.paquete from paquete where paquete.paquete= '" + id + "';");
                if (rs2.next()) {

                } else {
                    idNumeros.add(id);
                    contador = contador + 1;
                }

                con2.close();
            }
            con.close();
            ////////////////////////////////// fin/////////////////////////////////////
            for (int x = 0; x < contador; x++) {
                int valor = idNumeros.get(x);
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select paquete.paquete from paquete where paquete.articulo =" + valor + " ");
                if (rs.next()) {
                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select paquete.paquete from paquete where paquete.articulo =" + valor + " ");
                    while (rs2.next()) {
                        int idsubproducto = rs2.getInt(1);

                        con3 = conectar.conectarMySQL();
                        stmt3 = con3.createStatement();
                        rs3 = stmt3.executeQuery("select * from detallet inner join traspaso "
                                + " on detallet.tra_id = traspaso.tra_id where detallet.art_id = "+idsubproducto+""
                                + " and fecha between\n"
                                + " '"+fecha1+"' and '"+fecha2+"'");

                    }
                    con2.close();
                } else {

                }
                con.close();
            }

        } catch (SQLException e) {
        }
    }

}
