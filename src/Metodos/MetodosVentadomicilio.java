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
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
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
public class MetodosVentadomicilio {

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
    Object datos[] = new Object[3];
    float ventas[] = new float[12];
    Object meses[] = new Object[13];
    String abrirarchivo = "", guardararchivo = "";
    float baja = 0.15f;
    float media = 0.85f;
    int idvendedor;

    public void sucursales(String fecha1, String fecha2, String fechauno, String fechados, int sucursal) {
        switch (sucursal) {
            case 1:
                abrirarchivo = ("C:\\Users\\Cpu\\Documents\\Ventas a domicilio.xls");
                guardararchivo = ("C:\\Users\\Cpu\\Desktop\\Ventas_Domicilio_ Magisterio del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
            case 2:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Ventas a domicilio.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Ventas_Domicilio_ Coapinole del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
            case 3:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Ventas a domicilio.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Ventas_Domicilio_ Bodega del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados, sucursal);
                break;

            case 4:
                abrirarchivo = ("C:\\Users\\billy\\Documents\\Ventas a domicilio.xls");
                guardararchivo = ("C:\\Users\\billy\\Desktop\\Ventas_Domicilio_ Bodega del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados, sucursal);
                break;

            case 5:
                abrirarchivo = ("C:\\Users\\billy\\Documents\\Ventas a domicilio.xls");
                guardararchivo = ("C:\\Users\\billy\\Desktop\\Ventas_Domicilio_ Mojoneras del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados, sucursal);
                break;
        }
    }

    public void excelsucursales(String fecha1, String fecha2, String fechauno, String fechados, int sucursal) {
        try ( FileInputStream file = new FileInputStream(new File(abrirarchivo))) {
            // leer archivo excel
            POIFSFileSystem fs = new POIFSFileSystem(file);
            HSSFWorkbook libro = new HSSFWorkbook(fs);
            //obtener la hoja que se va leer
            HSSFSheet hoja = libro.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            HSSFCell celda;
            HSSFRow fila;
            Row row;
            HSSFDataFormat format = libro.createDataFormat();

            CellStyle headerStyle = libro.createCellStyle();
            HSSFFont font = libro.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            CellStyle encabezados = libro.createCellStyle();
            HSSFFont font2 = libro.createFont();
            font2.setBold(true);
            font2.setFontName("Arial");
            font2.setFontHeight((short) (12 * 20));
            encabezados.setFont(font2);

            CellStyle categoria = libro.createCellStyle();
            HSSFFont font3 = libro.createFont();
            font3.setFontName("Calibri");
            font3.setFontHeight((short) (10 * 22));
            categoria.setFont(font3);

            CellStyle negrita = libro.createCellStyle();
            HSSFFont font4 = libro.createFont();
            font4.setBold(true);
            font4.setFontName("Arial");
            font4.setFontHeight((short) (10 * 20));
            negrita.setWrapText(true);
            negrita.setFont(font4);

            CellStyle Numerico = libro.createCellStyle();
            HSSFFont fontnumerico = libro.createFont();
            fontnumerico.setBold(true);
            fontnumerico.setFontName("Arial");
            fontnumerico.setFontHeight((short) (10 * 20));
            Numerico.setDataFormat(format.getFormat("###,##0.00"));
            Numerico.setFont(fontnumerico);

            int filadato = 6, columnadato = 1, nombremes = 3;
            fila = hoja.createRow(3);
            String mes, anio;
            float total = 0;
            float cantidad;
            row = hoja.getRow(6);
            int totalmeses = 0;
            try {
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                rs = stmt.executeQuery("select vnd_id from vendedor where nombre ='ventas domicilio';");
                if (rs.next()) {
                    idvendedor = rs.getInt(1);
                }
                con.close();
                totalmeses = 0;

                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 24 and venta.status!= -1 and venta.not_id is  null "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)"
                        + " and venta.vnd_id =20  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    anio = rs.getString(3);
                    cantidad = rs.getFloat(2);

                    mes = mes.toUpperCase().charAt(0) + mes.substring(1, mes.length());

                    meses[totalmeses] = mes + " " + anio;

                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    fila = hoja.getRow(nombremes);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(meses[totalmeses] + "");
                    celda.setCellStyle(negrita);

                    columnadato = columnadato + 2;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            /////////////// final ventas departamento alta              

            /////////////////
            columnadato = 1;
            filadato = 7;
            try {

                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 23 and venta.status!= -1 and venta.not_id is  null"
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month) "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    totalmeses = totalmeses + 1;

                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
                con.close();
                totalmeses = 0;

                //////////////// fin de las notas de credito 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            //// fin ventas de media

            columnadato = 1;
            filadato = 8;
            try {

                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 22 and venta.status!= -1 and venta.not_id is  null "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    totalmeses = totalmeses + 1;

                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
/////////////// fin de las ventas por ticket 

//////////////////// inicio ventas por notas de venta
            try {
                columnadato = 1;
                filadato = 12;
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 24 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month) "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);

                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            /////////////// final ventas departamento alta              

            /////////////////
            columnadato = 1;
            filadato = 13;
            try {

                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 23 and venta.status!= -1  "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month) "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    totalmeses = totalmeses + 1;

                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
                con.close();
                totalmeses = 0;

                //////////////// fin de las notas de credito 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            //// fin ventas de media

            columnadato = 1;
            filadato = 14;
            try {

                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 22 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    totalmeses = totalmeses + 1;

                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

//////////////////// fin de ventas por notas de venta
            //finaliza ventas por departamento 
            filadato = 17;
            columnadato = 1;
            nombremes = 4;

            ///inicia consultas de compras por departamento
            try {
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 24 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month) "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            try {
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 18;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 23 and venta.status!= -1  "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month) "
                        + " and venta.vnd_id =20 group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            try {
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 19;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 22 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)"
                        + " and venta.vnd_id =20  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    cantidad = rs.getFloat(2);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            try {
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 34;

                ////////////////////////// contar tickets lo cambio ya que no hay la misma cantidad  de ventas que de tickets
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes, count(ticket.tic_id),year(venta.fecha) as año"
//                        + " from venta inner join ticket on ticket.tic_id = venta.tic_id "
//                        + "where venta.status !=-1  "
//                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(venta.fecha ) "
//                        + " order by  year(venta.fecha), month(venta.fecha) ;");
//              ////////////////////////////////////////////////////////////////////////////////////////////////////  
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes, count(venta.ven_id),year(venta.fecha) as año"
                        + " from venta "
                        + " where venta.status !=-1 and venta.vnd_id =20 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(venta.fecha ) "
                        + " order by  year(venta.fecha), month(venta.fecha) ;");
                while (rs.next()) {

                    cantidad = rs.getFloat(2);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            try {
                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 38;
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes, count(nota.not_id),year(venta.fecha) as año"
                        + " from venta inner join nota on nota.not_id = venta.not_id "
                        + "where venta.status !=-1 and venta.vnd_id =20 "
                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(venta.fecha ) "
                        + " order by  year(venta.fecha), month(venta.fecha) ;");
                while (rs.next()) {

                    cantidad = rs.getFloat(2);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            for (int x = 1; x < columnadato; x++) {

                hoja.autoSizeColumn(x);
            }
            File Archivo = new File(guardararchivo);
            Archivo.createNewFile();
            FileOutputStream elFichero = new FileOutputStream(guardararchivo);
            libro.write(elFichero);
            elFichero.close();
            File archivo = new File(guardararchivo);
            Desktop.getDesktop().open(archivo);
            // se recorre cada fila hasta el final

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }
//
//    public void excelbodega(String fecha1, String fecha2, String fechauno, String fechados) {
//        try ( FileInputStream file = new FileInputStream(new File(abrirarchivo))) {
//            // leer archivo excel
//            POIFSFileSystem fs = new POIFSFileSystem(file);
//            HSSFWorkbook libro = new HSSFWorkbook(fs);
//            //obtener la hoja que se va leer
//            HSSFSheet hoja = libro.getSheetAt(0);
//            //obtener todas las filas de la hoja excel
//            HSSFCell celda;
//            HSSFRow fila;
//            Row row;
//            HSSFDataFormat format = libro.createDataFormat();
//            CellStyle headerStyle = libro.createCellStyle();
//            HSSFFont font = libro.createFont();
//            font.setBold(true);
//            headerStyle.setFont(font);
//
//            CellStyle encabezados = libro.createCellStyle();
//            HSSFFont font2 = libro.createFont();
//            font2.setBold(true);
//            font2.setFontName("Arial");
//            font2.setFontHeight((short) (12 * 20));
//            encabezados.setFont(font2);
//
//            CellStyle categoria = libro.createCellStyle();
//            HSSFFont font3 = libro.createFont();
//            font3.setFontName("Calibri");
//            font3.setFontHeight((short) (10 * 22));
//            categoria.setFont(font3);
//
//            CellStyle negrita = libro.createCellStyle();
//            HSSFFont font4 = libro.createFont();
//            font4.setBold(true);
//            font4.setFontName("Arial");
//            font4.setFontHeight((short) (10 * 20));
//            negrita.setWrapText(true);
//            negrita.setFont(font4);
//
//            CellStyle Numerico = libro.createCellStyle();
//            HSSFFont fontnumerico = libro.createFont();
//            fontnumerico.setBold(true);
//            fontnumerico.setFontName("Arial");
//            fontnumerico.setFontHeight((short) (10 * 20));
//            Numerico.setDataFormat(format.getFormat("###,##0.00"));
//            Numerico.setFont(fontnumerico);
//
//            int filadato = 5, columnadato = 1, nombremes = 3;
//            fila = hoja.createRow(3);
//            String mes, anio;
//            float total = 0;
//            float cantidad;
//            row = hoja.getRow(6);
//
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//
//                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
//                        + ",year(venta.fecha) as año\n"
//                        + " from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                        + " on articulo.art_id = detallev.art_id\n"
//                        + " inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                        + " on departamento.dep_id = categoria.dep_id\n"
//                        + " where departamento.dep_id = 24 and venta.status!= -1 "
//                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
//                        + "order by  year(fecha), month(fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
//
//                    mes = mes.toUpperCase().charAt(0) + mes.substring(1, mes.length());
//
//                    fila = hoja.getRow(nombremes);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(new HSSFRichTextString(mes + " " + anio));
//                    celda.setCellStyle(negrita);
//
//                    columnadato = columnadato + 2;
//
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//                columnadato = 1;
//                filadato = 6;
//                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
//                        + ",year(venta.fecha) as año\n"
//                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                        + "on articulo.art_id = detallev.art_id\n"
//                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                        + "on departamento.dep_id = categoria.dep_id\n"
//                        + "where departamento.dep_id = 23 and venta.status!= -1  "
//                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
//                        + "order by  year(fecha), month(fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
//
//                    columnadato = columnadato + 2;
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//                columnadato = 1;
//                filadato = 7;
//                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
//                        + ",year(venta.fecha) as año\n"
//                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                        + "on articulo.art_id = detallev.art_id\n"
//                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                        + "on departamento.dep_id = categoria.dep_id\n"
//                        + "where departamento.dep_id = 22 and venta.status!= -1  "
//                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
//                        + "order by  year(fecha), month(fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
//
//                    columnadato = columnadato + 2;
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//            //finaliza ventas por departamento 
//
//            filadato = 10;
//            columnadato = 1;
//            nombremes = 4;
//
//            ///inicia consultas de compras por departamento
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
//                        + ",year(venta.fecha) as año\n"
//                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                        + "on articulo.art_id = detallev.art_id\n"
//                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                        + "on departamento.dep_id = categoria.dep_id\n"
//                        + "where departamento.dep_id = 24 and venta.status!= -1 "
//                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
//                        + "order by  year(fecha), month(fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
////                    mes = mes.toUpperCase().charAt(0) + mes.substring(1, mes.length());
////                    fila = hoja.getRow(nombremes);
////                    celda = fila.createCell(columnadato);
////                    celda.setCellValue(new HSSFRichTextString(mes + " " + anio));
////                    celda.setCellStyle(negrita);
//
//                    columnadato = columnadato + 2;
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//                columnadato = 1;
//                filadato = 11;
//                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
//                        + ",year(venta.fecha) as año\n"
//                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                        + "on articulo.art_id = detallev.art_id\n"
//                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                        + "on departamento.dep_id = categoria.dep_id\n"
//                        + "where departamento.dep_id = 23 and venta.status!= -1  "
//                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
//                        + "order by  year(fecha), month(fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
//
//                    columnadato = columnadato + 2;
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//                columnadato = 1;
//                filadato = 12;
//                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
//                        + ",year(venta.fecha) as año\n"
//                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                        + "on articulo.art_id = detallev.art_id\n"
//                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                        + "on departamento.dep_id = categoria.dep_id\n"
//                        + "where departamento.dep_id = 22 and venta.status!= -1 "
//                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
//                        + "order by  year(fecha), month(fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
//
//                    columnadato = columnadato + 2;
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//
//            try {
//                con = conectar.conectarMySQL();
//                stmt = con.createStatement();
//                columnadato = 1;
//                filadato = 34;
//                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes, count(ticket.tic_id),year(venta.fecha) as año"
//                        + " from venta inner join ticket on ticket.tic_id = venta.tic_id "
//                        + "where venta.status !=-1  "
//                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(venta.fecha ) "
//                        + " order by  year(venta.fecha), month(venta.fecha) ;");
//                while (rs.next()) {
//                    mes = rs.getString(1);
//                    cantidad = rs.getFloat(2);
//                    anio = rs.getString(3);
//                    fila = hoja.getRow(filadato);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(cantidad);
//                    celda.setCellStyle(Numerico);
//
//                    columnadato = columnadato + 2;
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//            for (int x = 1; x < columnadato; x++) {
//
//                hoja.autoSizeColumn(x);
//            }
//            File Archivo = new File(guardararchivo);
//            Archivo.createNewFile();
//            FileOutputStream elFichero = new FileOutputStream(guardararchivo);
//            libro.write(elFichero);
//            elFichero.close();
//            File archivo = new File(guardararchivo);
//            Desktop.getDesktop().open(archivo);
//            // se recorre cada fila hasta el final
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//
//    }

}
