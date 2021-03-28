/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
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

    public void buscarventas(String fecha1, String fecha2, String fechadiaprimero, String fechadiaultimo) {
        if ("".equals(fechadiaprimero) || "".equals(fechadiaultimo)) {

        }
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
            rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importenorcon) as suma "
                    + ",year(venta.fecha) as año\n"
                    + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                    + "on articulo.art_id = detallev.art_id\n"
                    + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                    + "on departamento.dep_id = categoria.dep_id\n"
                    + "where departamento.dep_id = 23 and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                    + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) ;");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getFloat(2);
                datos[2] = rs.getString(3);
                JOptionPane.showMessageDialog(null, "Mes " + datos[0] + " total " + datos[1] + " Año " + datos[2]);
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

    public void GeneraExcel(String fecha1, String fecha2) {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();
        HSSFCell celda;
        HSSFRow fila;

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

        fila = hoja.createRow(0);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("La Buena Semilla"));
        celda.setCellStyle(encabezados);

        fila = hoja.createRow(1);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Sucursal"));
        celda.setCellStyle(negrita);

        fila = hoja.createRow(5);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Ventas Netas Ut. Alta"));
        celda.setCellStyle(categoria);

        fila = hoja.createRow(6);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Ventas Netas Ut. Media"));
        celda.setCellStyle(categoria);

        fila = hoja.createRow(7);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Ventas Netas Ut. Baja"));
        celda.setCellStyle(categoria);

        fila = hoja.createRow(8);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Total"));
        celda.setCellStyle(negrita);

        hoja.autoSizeColumn(0);

        try {
            FileOutputStream elFichero = new FileOutputStream("C:\\Users\\GHIA\\Desktop\\prueba del .xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    public void cargar(String fecha1, String fecha2) {

        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement ps;
            File  file = new File("C:\\Users\\GHIA\\Desktop\\prueba del .xls");
            FileOutputStream archivo = new FileOutputStream(file);
            HSSFWorkbook  libro = new HSSFWorkbook();
            HSSFSheet hoja = libro.getSheetAt(0);
            HSSFCell celda;
            HSSFRow fila;

            CellStyle categoria = libro.createCellStyle();
            HSSFFont font3 = libro.createFont();
            font3.setFontName("Calibri");
            font3.setFontHeight((short) (10 * 22));
            categoria.setFont(font3);

            int numFilas = hoja.getLastRowNum();
            int filac = 5, columnadato = 1, nombremes = 3;
            rs2 = stmt.executeQuery("SET lc_time_names = 'es_ES';");
            rs = stmt.executeQuery("select MONTHNAME(venta.fecha) mes ,sum(detallev.importenorcon) as suma "
                    + ",year(venta.fecha) as año\n"
                    + "from detallev inner join  venta on venta.ven_id = detallev.ven_id inner join articulo "
                    + "on articulo.art_id = detallev.art_id\n"
                    + "inner join categoria on categoria.cat_id = articulo.cat_id inner join departamento "
                    + "on departamento.dep_id = categoria.dep_id\n"
                    + "where departamento.dep_id = 23 and venta.fecha >= date_sub('" + fecha1 + "', interval 0 month)"
                    + " and venta.fecha <= date_sub('" + fecha2 + "', interval 0 month)  group by month(fecha ) ;");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getFloat(2);
                datos[2] = rs.getString(3);
                fila = hoja.createRow(columnadato);
                celda = fila.createCell(filac);
                celda.setCellValue(new HSSFRichTextString(datos[2].toString()));
                celda.setCellStyle(categoria);
                celda = fila.createCell(nombremes);
                celda.setCellValue(new HSSFRichTextString(datos[1].toString()));
                celda.setCellStyle(categoria);
               
            }
             libro.write(archivo);
             archivo.close();
            JOptionPane.showMessageDialog(null, "Guardado");
            con.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
