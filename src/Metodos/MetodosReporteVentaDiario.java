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
public class MetodosReporteVentaDiario {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    
    Connection con2 = null;
    static ResultSet rs2 = null;
    private Statement stmt2 = null;

    Connection con3 = null;
    static ResultSet rs3 = null;
    private Statement stmt3 = null;

    Object meses[] = new Object[13];
    String abrirarchivo = "", guardararchivo = "";

    conexion conectar = new conexion();
    conexion2 conectar2 = new conexion2();

    public void sucursales(String fecha1, String fecha2, String fechauno, String fechados, int sucursal) {
        switch (sucursal) {
            case 1:
                abrirarchivo = ("C:\\Users\\Cpu\\Documents\\Ventas Diarias.xls");
                guardararchivo = ("C:\\Users\\Cpu\\Desktop\\Ventas Diarias Sucursal_ Magisterio del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados,sucursal);
                break;
            case 2:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Ventas Diarias.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Ventas Diarias Sucursal_ Coapinole del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados,sucursal);
                break;
            case 3:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Ventas Diarias.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Ventas Diarias Sucursal_ Bodega del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados,sucursal);
                break;

            case 4:
                abrirarchivo = ("C:\\Users\\billy\\Documents\\Ventas Diarias.xls");
                guardararchivo = ("C:\\Users\\billy\\Desktop\\Ventas Diarias Sucursal_ Bodega pdv del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados,sucursal);
                break;
                
            case 5:
                abrirarchivo = ("C:\\Users\\USER\\Documents\\Ventas Diarias.xls");
                guardararchivo = ("C:\\Users\\USER\\Desktop\\Ventas Diarias Sucursal_ Mojoneras del " + fechauno + " al " + fechados + ".xls");
                excelsucursales(fecha1, fecha2, fechauno, fechados,sucursal);
                break;
        }
    }

    public void excelsucursales(String fecha1, String fecha2, String fechauno, String fechados,int sucursal) {
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

            int filadato = 11, columnadato = 9, nombremes = 3, filadia = 11;

            fila = hoja.createRow(3);
            String mes, anio, dia;
            float total = 0;
            float cantidad;
            row = hoja.getRow(6);
            int totalmeses = 0;
            try {
                if(sucursal ==4){
                    con = conectar2.conectarMySQL();
                }else{
                 con = conectar.conectarMySQL();   
                }
                stmt = con.createStatement();

                totalmeses = 0;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");

                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año,day(venta.fecha)\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 24 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by day(venta.fecha ) "
                        + "order by  year(fecha), month(fecha),day(venta.fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    dia = rs.getString(4);
                    anio = rs.getString(3);
                    cantidad = rs.getFloat(2);

                    mes = mes.toUpperCase().charAt(0) + mes.substring(1, mes.length());
                    dia = dia.toUpperCase().charAt(0) + dia.substring(1, dia.length());
                    meses[totalmeses] = dia + " " + mes + " " + anio;

                    fila = hoja.getRow(filadato);
                    celda = fila.getCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    fila = hoja.getRow(filadia);
                    celda = fila.getCell(0);
                    celda.setCellValue(meses[totalmeses] + "");
                    celda.setCellStyle(encabezados);

                    filadato = filadato + 1;
                    filadia = filadia + 1;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
            /////////////// final ventas departamento alta              

            /////////////////
            columnadato = 10;
            filadato = 11;
            try {

                if(sucursal ==4){
                    con = conectar2.conectarMySQL();
                }else{
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
                        + "where departamento.dep_id = 23 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by day(fecha ) "
                        + "order by  year(fecha), month(fecha),day(fecha);");
                while (rs.next()) {
                    mes = rs.getString(1);
                    anio = rs.getString(3);
                    cantidad = rs.getFloat(2);
                    totalmeses = totalmeses + 1;

                    fila = hoja.getRow(filadato);
                    celda = fila.getCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    filadato = filadato + 1;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            columnadato = 11;
            filadato = 11;
            try {

                if(sucursal ==4){
                    con = conectar2.conectarMySQL();
                }else{
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
                        + "where departamento.dep_id = 22 and venta.status!= -1"
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by day(fecha ) "
                        + "order by  year(fecha), month(fecha),day(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    anio = rs.getString(3);
                    cantidad = rs.getFloat(2);
                    totalmeses = totalmeses + 1;

                    fila = hoja.getRow(filadato);
                    celda = fila.getCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    filadato = filadato + 1;
                }
                con.close();
                totalmeses = 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }

            filadato = 11;
            columnadato = 13;
            nombremes = 4;

            try {
                if(sucursal ==4){
                    con = conectar2.conectarMySQL();
                }else{
                 con = conectar.conectarMySQL();   
                }
                stmt = con.createStatement();

                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes, count(venta.ven_id),year(venta.fecha) as año"
                        + " from venta "
                        + "where venta.status !=-1 and not_id is null "
                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by day(venta.fecha ) "
                        + " order by  year(venta.fecha), month(venta.fecha),day(venta.fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.getCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(Numerico);

                    filadato = filadato + 1;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                e.getStackTrace();
            }
            for (int x = 0; x < 30; x++) {

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

}
