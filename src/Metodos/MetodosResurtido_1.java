/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author usuario
 */
public class MetodosResurtido_1 {

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
    conexion2 conectar2 = new conexion2();
    String abrirarchivo = "", guardararchivo = "";
    int contador = 0, contador1 = 0;
    float cantidad3ma = 0, cantidad3md = 0, existencia = 0;
    String descripcion = "", descripcion2 = "", categoria = "", clave = "";
    int idpaquete;
    protected ArrayList<Integer> idNumeros = new ArrayList();

    public void limpiarVariables() {
        cantidad3ma = 0;
        cantidad3md = 0;
        contador = 0;
        contador1 = 0;
        idpaquete = 0;
    }

    public void sucursales(String fecha1, String fecha2, String fechauno, String fechados, int sucursal, String mes) {
        switch (sucursal) {
            case 1:
//                abrirarchivo = ("C:\\Users\\usuario\\Desktop\\Resurtido.xls");
//                guardararchivo = ("C:\\Users\\usuario\\Desktop\\Resurtido de sucursal2.xls");
                abrirarchivo = ("C:\\Users\\Cpu\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\Cpu\\Desktop\\Resurtido de sucursal_Magisterio solo productos de " + mes + ".xls");
                resurtidocopiabodega(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
            case 2:

                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Resurtido de sucursal_Coapinole solo productos de " + mes + ".xls");
                resurtidocopiabodega(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
            case 3:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Resurtido de sucursal_ Bodega solo productos de" + mes + ".xls");
                resurtidocopiabodega(fecha1, fecha2, fechauno, fechados, sucursal);
                break;

            case 4:
                abrirarchivo = ("C:\\Users\\billy\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\billy\\Desktop\\Resurtido de sucursal_ Bodega pdv solo productos de" + mes + ".xls");
                resurtidocopiabodega(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
                
                case 5:
                abrirarchivo = ("C:\\Users\\USER\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\USER\\Desktop\\Resurtido de sucursal_ Bodega pdv solo productos de" + mes + ".xls");
                resurtidocopiabodega(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
        }
    }

    public void resurtidocopiabodega(String fecha1ma, String fecha3ma, String fecha1md, String fecha3md, int sucursal) {

        try ( FileInputStream file = new FileInputStream(new File(abrirarchivo))) {
            POIFSFileSystem fs = new POIFSFileSystem(file);
            HSSFWorkbook libro = new HSSFWorkbook(fs);
            //obtener la hoja que se va leer
            HSSFSheet hoja = libro.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            HSSFCell celda;
            HSSFRow fila;
            Row row;
            HSSFDataFormat format = libro.createDataFormat();
            /// creacion de estilos de letra 
            //formato para el nombre de las columnas
            CellStyle headerStyle = libro.createCellStyle();
            HSSFFont font = libro.createFont();
            font.setBold(true);
            font.setFontName("Arial");
            font.setFontHeight((short) (14 * 20));
            headerStyle.setFont(font);

            //formato para encabezados
            CellStyle encabezados = libro.createCellStyle();
            HSSFFont font2 = libro.createFont();
            font2.setBold(true);
            font2.setFontName("Arial");
            font2.setFontHeight((short) (10 * 20));
            encabezados.setFont(font2);

            CellStyle letraprincipal = libro.createCellStyle();
            HSSFFont font3 = libro.createFont();
            font3.setBold(true);
            font3.setFontName("Arial");
            font3.setFontHeight((short) (15 * 20));
            letraprincipal.setFont(font3);

            CellStyle Numerico = libro.createCellStyle();
            HSSFFont fontnumerico = libro.createFont();
            fontnumerico.setBold(true);
            fontnumerico.setFontName("Arial");
            fontnumerico.setFontHeight((short) (10 * 20));
            Numerico.setDataFormat(format.getFormat("###,##0.00"));
            Numerico.setFont(fontnumerico);

            int filaa = 9;
            try {
                int id;
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                rs = stmt.executeQuery("select articulo.art_id from articulo inner join"
                        + " categoria on categoria.cat_id = articulo.cat_id  where articulo.status !=-1  order"
                        + " by categoria.nombre,articulo.descripcion"
                );

                while (rs.next()) {

                    id = rs.getInt(1);

                    if (sucursal == 4) {
                        con2 = conectar2.conectarMySQL();
                    } else {
                        con2 = conectar.conectarMySQL();
                    }
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
                int valor = 0;
                float existencia = 0;
                for (int x = 0; x < contador; x++) {
                    valor = idNumeros.get(x);
                    if (sucursal == 4) {
                        con = conectar2.conectarMySQL();
                    } else {
                        con = conectar.conectarMySQL();
                    }
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("select paquete.paquete from paquete where paquete.articulo=" + valor + "");
                    if (rs.next()) {

//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select paquete.paquete,paquete.cantidad from paquete where paquete.articulo=" + valor + "");
//                        while (rs2.next()) {
//                            id = rs2.getInt(1);
//                            con3 = conectar.conectarMySQL();
//                            stmt3 = con3.createStatement();
//                            rs3 = stmt3.executeQuery("select existencia,status from articulo where art_id='" + id + "'"
//                                    + " and status !=-1");
//
//                            while (rs3.next()) {
//                                existencia = existencia + (rs3.getFloat(1) * rs2.getFloat(2));
//                            }
//
//                            con3.close();
//                        }
//                        con2.close();
                        //////////////////// inicio de 3 meses anteriores                   
                        /////////////////////// suma de cantidad venta de paquetes 
                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(cantidad) from detallep "
                                + "inner join venta on venta.ven_id = detallep.ven_id "
                                + " where detallep.articulo=" + valor + " and "
                                + " venta.fecha between '" + fecha1ma + "' and '" + fecha3ma + "'"
                                + " and venta.status!=-1");
                        if (rs2.next()) {

                            cantidad3ma = cantidad3ma + rs2.getFloat(1);

                        }
                        con2.close();
                        /////////////////////// suma de cantidad traspaso  de paquetes 
//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select sum(detallepaqt.cantidad)  FROM detallepaqt   "
//                                + "inner join traspaso on traspaso.tra_id = detallepaqt.tra_id\n"
//                                + " where articulo  = " + valor + " and  traspaso.fecha between '" + fecha1ma + "'"
//                                + " and '" + fecha3ma + "'  and traspaso.status=2 and sucori=8;");
//                        if (rs2.next()) {
//                            cantidad3ma = cantidad3ma + rs2.getFloat(1);
//                        }
//                        con2.close();

                        /////////////////////// suma de cantidad traspaso  de producto basee 
//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select sum(cantidad) as traspaso from detallet "
//                                + "inner join traspaso on traspaso.tra_id = detallet.tra_id where "
//                                + "detallet.art_id=" + valor + "\n"
//                                + "and traspaso.fecha between '" + fecha1ma + "' and "
//                                + "'" + fecha3ma + "'  and traspaso.status=2  and sucori=8;");
//                        if (rs2.next()) {
//                            cantidad3ma = cantidad3ma + rs2.getFloat(1);
//                        }
//
//                        con2.close();
                        /////////////////////// suma de cantidad venta  de producto basee 
                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(cantidad) from detallev "
                                + "inner join venta on venta.ven_id = detallev.ven_id "
                                + " where detallev.art_id=" + valor + " and "
                                + " venta.fecha between '" + fecha1ma + "' and '" + fecha3ma + "'"
                                + " and venta.status!=-1");
                        if (rs2.next()) {
                            cantidad3ma = cantidad3ma + rs2.getFloat(1);
                        }
                        con2.close();
                        /////////////////////// fin de 3 meses anteriores                    

                        //////////////////// inicio de 3 meses despues                   
                        /////////////////////// suma de cantidad venta de paquetes 
                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(cantidad) from detallep "
                                + "inner join venta on venta.ven_id = detallep.ven_id "
                                + " where detallep.articulo=" + valor + " and "
                                + " venta.fecha between '" + fecha1md + "' and '" + fecha3md + "'"
                                + " and venta.status!=-1");
                        if (rs2.next()) {

                            cantidad3md = cantidad3md + rs2.getFloat(1);

                        }
                        con2.close();
                        /////////////////////// suma de cantidad traspaso  de paquetes 
//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select sum(detallepaqt.cantidad)  FROM detallepaqt   "
//                                + "inner join traspaso on traspaso.tra_id = detallepaqt.tra_id\n"
//                                + " where articulo  = " + valor + " and  traspaso.fecha between '" + fecha1md + "'"
//                                + " and '" + fecha3md + "'  and traspaso.status=2 and sucori=8;");
//                        if (rs2.next()) {
//                            cantidad3md = cantidad3md + rs2.getFloat(1);
//                        }
//                        con2.close();

                        /////////////////////// suma de cantidad traspaso  de producto basee 
//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select sum(cantidad) as traspaso from detallet "
//                                + "inner join traspaso on traspaso.tra_id = detallet.tra_id where "
//                                + "detallet.art_id=" + valor + "\n"
//                                + "and traspaso.fecha between '" + fecha1md + "' and "
//                                + "'" + fecha3md + "'  and traspaso.status=2 and sucori=8;");
//                        if (rs2.next()) {
//                            cantidad3md = cantidad3md + rs2.getFloat(1);
//                        }
//
//                        con2.close();
                        /////////////////////// suma de cantidad venta  de producto basee 
                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(cantidad) from detallev "
                                + "inner join venta on venta.ven_id = detallev.ven_id "
                                + " where detallev.art_id=" + valor + " and "
                                + " venta.fecha between '" + fecha1md + "' and '" + fecha3md + "'"
                                + " and venta.status!=-1");
                        if (rs2.next()) {
                            cantidad3md = cantidad3md + rs2.getFloat(1);
                        }
                        con2.close();
                        /////////////////////// fin de 3 meses despues  

                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select articulo.clave,articulo.existencia,articulo.descripcion,categoria.nombre"
                                + " from articulo inner join categoria on categoria.cat_id = articulo.cat_id where art_id=" + valor + "");
                        if (rs2.next()) {
                            existencia = existencia + rs2.getFloat(2);
                        }

                        if (descripcion.equals(rs2.getString(4))) {
                            fila = hoja.getRow(filaa);
//                    
                            celda = fila.createCell(0);
                            celda.setCellValue(rs2.getString(1));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(1);
                            celda.setCellValue(new HSSFRichTextString(rs2.getString(3)));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(2);
                            celda.setCellValue(existencia);
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(3);
                            celda.setCellValue((cantidad3ma / 3));
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(4);
                            celda.setCellValue((cantidad3md / 3));
                            celda.setCellStyle(Numerico);
//                          

                            if (filaa > 10) {
                                int filaformula = filaa + 1;
                                String Formula;

                                //// Formula 7 dias mes anterior
                                Formula = "D" + filaformula + "/4";
                                celda = fila.getCell(5);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula 7 dias año  anterior
                                Formula = "E" + filaformula + "/4";
                                celda = fila.getCell(6);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido mes   anterior
                                Formula = "F" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(7);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido año Anterior  
                                Formula = "G" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(8);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Mes  Anterior  
                                Formula = "C" + filaformula + "*30/D" + filaformula;
                                celda = fila.getCell(9);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Año  Anterior  
                                Formula = "C" + filaformula + "*30/E" + filaformula;
                                celda = fila.getCell(10);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario Mes  Anterior  
                                Formula = "J" + filaformula + "/7";
                                celda = fila.getCell(11);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario AÑo  Anterior  
                                Formula = "K" + filaformula + "/7";
                                celda = fila.getCell(12);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                            }
                            filaa = filaa + 1;
                        } else {
                            filaa = filaa + 1;
                            fila = hoja.getRow(filaa);
                            celda = fila.createCell(0);
                            celda.setCellValue(rs2.getString(4));
                            celda.setCellStyle(letraprincipal);

                            filaa = filaa + 1;
                            fila = hoja.getRow(filaa);
                            celda = fila.createCell(0);
                            celda.setCellValue(rs2.getString(1));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(1);
                            celda.setCellValue(new HSSFRichTextString(rs2.getString(3)));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(2);
                            celda.setCellValue(existencia);
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(3);
                            celda.setCellValue((cantidad3ma / 3));
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(4);
                            celda.setCellValue((cantidad3md / 3));
                            celda.setCellStyle(Numerico);

                            if (filaa > 10) {
                                int filaformula = filaa + 1;
                                String Formula;

                                //// Formula 7 dias mes anterior
                                Formula = "D" + filaformula + "/4";
                                celda = fila.getCell(5);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula 7 dias año  anterior
                                Formula = "E" + filaformula + "/4";
                                celda = fila.getCell(6);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido mes   anterior
                                Formula = "F" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(7);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido año Anterior  
                                Formula = "G" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(8);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Mes  Anterior  
                                Formula = "C" + filaformula + "*30/D" + filaformula;
                                celda = fila.getCell(9);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Año  Anterior  
                                Formula = "C" + filaformula + "*30/E" + filaformula;
                                celda = fila.getCell(10);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario Mes  Anterior  
                                Formula = "J" + filaformula + "/7";
                                celda = fila.getCell(11);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario AÑo  Anterior  
                                Formula = "K" + filaformula + "/7";
                                celda = fila.getCell(12);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                            }
                            filaa = filaa + 1;
                        }
                        descripcion = rs2.getString(4);
                        con.close();
                        con2.close();

                    } else {

                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(cantidad) from detallev "
                                + "inner join venta on venta.ven_id = detallev.ven_id "
                                + " where detallev.art_id=" + valor + " and "
                                + " venta.fecha between '" + fecha1ma + "' and '" + fecha3ma + "'"
                                + " and venta.status!=-1");
                        if (rs2.next()) {
                            cantidad3ma = cantidad3ma + rs2.getFloat(1);
                        }
                        con2.close();

//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select sum(cantidad) as traspaso from detallet "
//                                + "inner join traspaso on traspaso.tra_id = detallet.tra_id where "
//                                + "detallet.art_id=" + valor + "\n"
//                                + "and traspaso.fecha between '" + fecha1ma + "' and "
//                                + "'" + fecha3ma + "'  and traspaso.status=2;");
//                        if (rs2.next()) {
//                            cantidad3ma = cantidad3ma + rs2.getFloat(1);
//                        }
//
//                        con2.close();
//                        con2 = conectar.conectarMySQL();
//                        stmt2 = con2.createStatement();
//                        rs2 = stmt2.executeQuery("select sum(cantidad) as traspaso from detallet "
//                                + "inner join traspaso on traspaso.tra_id = detallet.tra_id where "
//                                + "detallet.art_id=" + valor + "\n"
//                                + "and traspaso.fecha between '" + fecha1md + "' and "
//                                + "'" + fecha3md + "'  and traspaso.status=2;");
//                        if (rs2.next()) {
//                            cantidad3md = cantidad3md + rs2.getFloat(1);
//                        }
//
//                        con2.close();
                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(cantidad) from detallev "
                                + "inner join venta on venta.ven_id = detallev.ven_id "
                                + " where detallev.art_id=" + valor + " and "
                                + " venta.fecha between '" + fecha1md + "' and '" + fecha3md + "'"
                                + " and venta.status!=-1");
                        if (rs2.next()) {
                            cantidad3md = cantidad3md + rs2.getFloat(1);
                        }
                        con2.close();

                        if (sucursal == 4) {
                            con2 = conectar2.conectarMySQL();
                        } else {
                            con2 = conectar.conectarMySQL();
                        }
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select articulo.clave,articulo.existencia,articulo.descripcion,categoria.nombre"
                                + " from articulo inner join categoria on categoria.cat_id = articulo.cat_id where art_id=" + valor + "");
                        if (rs2.next()) {
                            existencia = existencia + rs2.getFloat(2);
                        }

                        if (descripcion.equals(rs2.getString(4))) {
                            fila = hoja.getRow(filaa);
//                    
                            celda = fila.createCell(0);
                            celda.setCellValue(rs2.getString(1));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(1);
                            celda.setCellValue(new HSSFRichTextString(rs2.getString(3)));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(2);
                            celda.setCellValue(existencia);
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(3);
                            celda.setCellValue((cantidad3ma / 3));
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(4);
                            celda.setCellValue((cantidad3md / 3));
                            celda.setCellStyle(Numerico);

                            if (filaa > 10) {
                                int filaformula = filaa + 1;
                                String Formula;

                                //// Formula 7 dias mes anterior
                                Formula = "D" + filaformula + "/4";
                                celda = fila.getCell(5);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula 7 dias año  anterior
                                Formula = "E" + filaformula + "/4";
                                celda = fila.getCell(6);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido mes   anterior
                                Formula = "F" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(7);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido año Anterior  
                                Formula = "G" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(8);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Mes  Anterior  
                                Formula = "C" + filaformula + "*30/D" + filaformula;
                                celda = fila.getCell(9);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Año  Anterior  
                                Formula = "C" + filaformula + "*30/E" + filaformula;
                                celda = fila.getCell(10);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario Mes  Anterior  
                                Formula = "J" + filaformula + "/7";
                                celda = fila.getCell(11);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario AÑo  Anterior  
                                Formula = "K" + filaformula + "/7";
                                celda = fila.getCell(12);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                            }
                            filaa = filaa + 1;
                        } else {
                            filaa = filaa + 1;
                            fila = hoja.getRow(filaa);
                            celda = fila.createCell(0);
                            celda.setCellValue(rs2.getString(4));
                            celda.setCellStyle(letraprincipal);

                            filaa = filaa + 1;
                            fila = hoja.getRow(filaa);
                            celda = fila.createCell(0);
                            celda.setCellValue(rs2.getString(1));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(1);
                            celda.setCellValue(new HSSFRichTextString(rs2.getString(3)));
                            celda.setCellStyle(encabezados);

                            celda = fila.createCell(2);
                            celda.setCellValue(existencia);
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(3);
                            celda.setCellValue((cantidad3ma / 3));
                            celda.setCellStyle(Numerico);

                            celda = fila.createCell(4);
                            celda.setCellValue((cantidad3md / 3));
                            celda.setCellStyle(Numerico);
//                    
//                    
                            if (filaa > 10) {
                                int filaformula = filaa + 1;
                                String Formula;

                                //// Formula 7 dias mes anterior
                                Formula = "D" + filaformula + "/4";
                                celda = fila.getCell(5);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula 7 dias año  anterior
                                Formula = "E" + filaformula + "/4";
                                celda = fila.getCell(6);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido mes   anterior
                                Formula = "F" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(7);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Resurtido año Anterior  
                                Formula = "G" + filaformula + "-C" + filaformula;
                                celda = fila.getCell(8);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Mes  Anterior  
                                Formula = "C" + filaformula + "*30/D" + filaformula;
                                celda = fila.getCell(9);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula Dias Inventario Año  Anterior  
                                Formula = "C" + filaformula + "*30/E" + filaformula;
                                celda = fila.getCell(10);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario Mes  Anterior  
                                Formula = "J" + filaformula + "/7";
                                celda = fila.getCell(11);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                                //// Formula semanas  Inventario AÑo  Anterior  
                                Formula = "K" + filaformula + "/7";
                                celda = fila.getCell(12);
                                celda.setCellFormula(Formula);
                                celda.setCellStyle(Numerico);

                            }
                            filaa = filaa + 1;
                        }
                        descripcion = rs2.getString(4);
                        con.close();
                        con2.close();
                    }

                    existencia = 0;
                    cantidad3ma = 0;
                    cantidad3md = 0;
                }
                for (int x = 0; x < 20; x++) {
                    hoja.autoSizeColumn(x);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            limpiarVariables();
            File Archivo = new File(guardararchivo);
            Archivo.createNewFile();
            FileOutputStream elFichero = new FileOutputStream(guardararchivo);
            libro.write(elFichero);
            elFichero.close();
            File archivo = new File(guardararchivo);
            Desktop.getDesktop().open(archivo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
