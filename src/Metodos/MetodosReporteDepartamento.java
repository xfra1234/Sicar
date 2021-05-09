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
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
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

    
    
    
    
    public void modificaexcel(String fecha1, String fecha2,String fechauno, String fechados,int sucursal) {
       
        String abrirarchivo="",guardararchivo="";
        switch(sucursal){
            case 1:
                abrirarchivo = ("C:\\Users\\Cpu\\Documents\\Cuotas-de-Venta-y-Rentabilidad-Sucursales_-Magisterio.xls");
                guardararchivo =("C:\\Users\\Cpu\\Desktop\\Cuotas de Venta y Rentabilidad Sucursales_ Magisterio del " + fechauno + " al " + fechados + ".xls");
                break;  
             case 2:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Cuotas-de-Venta-y-Rentabilidad-Sucursales_-Magisterio.xls");
                guardararchivo =("C:\\Users\\GHIA\\Desktop\\Cuotas de Venta y Rentabilidad Sucursales_ Magisterio del " + fechauno + " al " + fechados + ".xls");
                break;  
        }
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

            int filadato = 5, columnadato = 1, nombremes = 3;
            fila = hoja.createRow(3);
            String mes, anio;
            float total = 0;
            float cantidad;
            row = hoja.getRow(6);

            try {
                con = conectar.conectarMySQL();
                stmt = con.createStatement();

                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 24 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);
                    mes = mes.toUpperCase().charAt(0) + mes.substring(1, mes.length());
                    fila = hoja.getRow(nombremes);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(new HSSFRichTextString(mes + " " + anio));
                    celda.setCellStyle(negrita);

                    columnadato = columnadato + 2;

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            try {
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 6;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 23 and venta.status!= -1  "
                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            try {
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 7;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importecon) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 22 and venta.status!= -1  "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //finaliza ventas por departamento 

            filadato = 10;
            columnadato = 1;
            nombremes = 4;

            ///inicia consultas de compras por departamento
            try {
                con = conectar.conectarMySQL();
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
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);
//                    mes = mes.toUpperCase().charAt(0) + mes.substring(1, mes.length());
//                    fila = hoja.getRow(nombremes);
//                    celda = fila.createCell(columnadato);
//                    celda.setCellValue(new HSSFRichTextString(mes + " " + anio));
//                    celda.setCellStyle(negrita);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            try {
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 11;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 23 and venta.status!= -1  "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            try {
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 12;
                rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importeCompra) as suma "
                        + ",year(venta.fecha) as año\n"
                        + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                        + "on articulo.art_id = detallev.art_id\n"
                        + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                        + "on departamento.dep_id = categoria.dep_id\n"
                        + "where departamento.dep_id = 22 and venta.status!= -1 "
                        + " and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) "
                        + "order by  year(fecha), month(fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);

                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
              try {
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                columnadato = 1;
                filadato = 27;
                rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes, count(ticket.tic_id),year(venta.fecha) as año"
                        + " from venta inner join ticket on ticket.tic_id = venta.tic_id "
                        + "where venta.status !=-1  "
                        + "and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                        + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(venta.fecha ) "
                        + " order by  year(venta.fecha), month(venta.fecha) ;");
                while (rs.next()) {
                    mes = rs.getString(1);
                    cantidad = rs.getFloat(2);
                    anio = rs.getString(3);
                    fila = hoja.getRow(filadato);
                    celda = fila.createCell(columnadato);
                    celda.setCellValue(cantidad);
                    celda.setCellStyle(categoria);
                  
                    columnadato = columnadato + 2;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            for (int x = 1; x < columnadato; x++) {

                hoja.autoSizeColumn(x);
            }
            FileOutputStream elFichero = new FileOutputStream(guardararchivo);
            libro.write(elFichero);
            elFichero.close();
            File archivo = new File(guardararchivo);
            Desktop.getDesktop().open(archivo);
            // se recorre cada fila hasta el final

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
//    public void cargar(String fecha1, String fecha2) {
//
//        try {
//            con = conectar.conectarMySQL();
//            stmt = con.createStatement();
//            PreparedStatement ps;
//            File  file = new File("C:\\Users\\GHIA\\Desktop\\prueba del .xls");
//            FileOutputStream archivo = new FileOutputStream(file);
//            HSSFWorkbook  libro = new HSSFWorkbook();
//            HSSFSheet hoja = libro.getSheetAt(0);
//            HSSFCell celda;
//            HSSFRow fila;
//            int rowCount =hoja.getLastRowNum();
//            JOptionPane.showMessageDialog(null, rowCount);
//            CellStyle categoria = libro.createCellStyle();
//            HSSFFont font3 = libro.createFont();
//            font3.setFontName("Calibri");
//            font3.setFontHeight((short) (10 * 22));
//            categoria.setFont(font3);
//
//            int numFilas = hoja.getLastRowNum();
//            int filac = 5, columnadato = 1, nombremes = 3;
//            rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
//            rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importenorcon) as suma "
//                    + ",year(venta.fecha) as año\n"
//                    + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
//                    + "on articulo.art_id = detallev.art_id\n"
//                    + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
//                    + "on departamento.dep_id = categoria.dep_id\n"
//                    + "where departamento.dep_id = 23 and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
//                    + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) ;");
//            while (rs.next()) {
//                datos[0] = rs.getString(1);
//                datos[1] = rs.getFloat(2);
//                datos[2] = rs.getString(3);
//                fila = hoja.createRow(columnadato);
//                celda = fila.createCell(filac);
//                celda.setCellValue(new HSSFRichTextString(datos[2].toString()));
//                celda.setCellStyle(categoria);
//                celda = fila.createCell(nombremes);
//                celda.setCellValue(new HSSFRichTextString(datos[1].toString()));
//                celda.setCellStyle(categoria);
//               
//            }
//             libro.write(archivo);
//             archivo.close();
//            JOptionPane.showMessageDialog(null, "Guardado");
//            con.close();
//
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
}
