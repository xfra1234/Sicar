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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author usuario
 */
public class MetodosResurtido {

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
    String abrirarchivo = "", guardararchivo = "";
    int contador = 0, contador1 = 0;
    protected ArrayList<Integer> idNumeros = new ArrayList();

    public void sucursales(String fecha1, String fecha2, String fechauno, String fechados, int sucursal) {
        switch (sucursal) {
            case 1:
                abrirarchivo = ("C:\\Users\\Cpu\\Documents\\Cuotas-de-Venta-y-Rentabilidad-Sucursales_-Magisterio.xls");
                guardararchivo = ("C:\\Users\\Cpu\\Desktop\\Cuotas de Venta y Rentabilidad Sucursales_ Magisterio del " + fechauno + " al " + fechados + ".xls");
                resurtido(fecha1, fecha2, fechauno, fechados);
                break;
            case 2:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Cuotas-de-Venta-y-Rentabilidad-Sucursales_-Coapinole.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Cuotas de Venta y Rentabilidad Sucursales_ Coapinole del " + fechauno + " al " + fechados + ".xls");
                resurtido(fecha1, fecha2, fechauno, fechados);
                break;
            case 3:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Cuotas-de-Venta-y-Rentabilidad-Sucursales_-Bodega.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Cuotas de Venta y Rentabilidad Sucursales_ Bodega del " + fechauno + " al " + fechados + ".xls");
                resurtido(fecha1, fecha2, fechauno, fechados);
                break;
        }
    }

    public void resurtido(String fecha1ma, String fecha3ma, String fecha1md, String fecha3md) {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();
        HSSFCell celda;
        HSSFRow fila;

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

        fila = hoja.createRow(0);
        celda = fila.createCell(9);
        celda.setCellValue(new HSSFRichTextString("LA BUENA SEMILLA"));
        celda.setCellStyle(letraprincipal);

        fila = hoja.createRow(1);
        celda = fila.createCell(9);
        celda.setCellValue(new HSSFRichTextString("Sucursal:"));
        celda.setCellStyle(headerStyle);
        /////////////////////////////////////////////////////////////////////////

        fila = hoja.createRow(5);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Ordenado a"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(4);
        celda.setCellValue(new HSSFRichTextString("Total"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(6);
        celda.setCellValue(new HSSFRichTextString("Ventas Prom."));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(7);
        celda.setCellValue(new HSSFRichTextString("Ventas Promedio"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(8);
        celda.setCellValue(new HSSFRichTextString("7 Días"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(9);
        celda.setCellValue(new HSSFRichTextString("7 Días"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(11);
        celda.setCellValue(new HSSFRichTextString("Resurtido"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(12);
        celda.setCellValue(new HSSFRichTextString("Resurtido"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(14);
        celda.setCellValue(new HSSFRichTextString("Días Inventario"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(15);
        celda.setCellValue(new HSSFRichTextString("Días Inventario"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(17);
        celda.setCellValue(new HSSFRichTextString("Semanas Inventario "));
        celda.setCellStyle(encabezados);

        //////////////////////////////
        fila = hoja.createRow(6);
        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Existencia"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Bodega y No"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(4);
        celda.setCellValue(new HSSFRichTextString("Existencia"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(6);
        celda.setCellValue(new HSSFRichTextString("últimos 3:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(7);
        celda.setCellValue(new HSSFRichTextString("3 Meses del año"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(8);
        celda.setCellValue(new HSSFRichTextString("Mes"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(9);
        celda.setCellValue(new HSSFRichTextString("Año"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(11);
        celda.setCellValue(new HSSFRichTextString("Mes"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(12);
        celda.setCellValue(new HSSFRichTextString("Año"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(14);
        celda.setCellValue(new HSSFRichTextString("Mes"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(15);
        celda.setCellValue(new HSSFRichTextString("Año"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(17);
        celda.setCellValue(new HSSFRichTextString("Mes"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(18);
        celda.setCellValue(new HSSFRichTextString("Año"));
        celda.setCellStyle(encabezados);

        /////////////////////////////////////
        fila = hoja.createRow(7);
        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Unidades"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Surtido"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(4);
        celda.setCellValue(new HSSFRichTextString("Unidades"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(6);
        celda.setCellValue(new HSSFRichTextString("Meses Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(7);
        celda.setCellValue(new HSSFRichTextString("Anteriores hacia adelante"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(8);
        celda.setCellValue(new HSSFRichTextString("anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(9);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(11);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(12);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(14);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(15);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(17);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(18);
        celda.setCellValue(new HSSFRichTextString("Anterior"));
        celda.setCellStyle(encabezados);

        /////////////////////////////////
        fila = hoja.createRow(8);

        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("SKU"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(1);
        celda.setCellValue(new HSSFRichTextString("Descripción "));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Sicar:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Sicar:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(4);
        celda.setCellValue(new HSSFRichTextString("Sicar:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(6);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(7);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(8);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(9);
        celda.setCellValue(new HSSFRichTextString("Unidades"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(11);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(12);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(14);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(15);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(17);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(18);
        celda.setCellValue(new HSSFRichTextString("Unidades:"));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(20);
        celda.setCellValue(new HSSFRichTextString("Acciones a tomar:"));
        celda.setCellStyle(encabezados);
        int filaa = 9;
        String descripcion = "";

        try {
            int id;
            double cantidad = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select articulo.art_id from articulo inner join"
                    + " categoria on categoria.cat_id = articulo.cat_id order by categoria.nombre,articulo.descripcion  "
            );

            while (rs.next()) {

                id = rs.getInt(1);
                
                con2 = conectar.conectarMySQL();
                stmt2 = con.createStatement();

                rs2 = stmt2.executeQuery("select paquete.paquete from paquete where paquete.paquete= '" + id + "';");
                if (rs2.next()) {

                } else {
                    idNumeros.add(id);
                    contador = contador + 1;
                }

            }
            con.close();
            con2.close();
            int valor = 0;
            float existencia = 0;
            for (int x = 0; x < contador; x++) {
                valor = idNumeros.get(x);
                con = conectar.conectarMySQL();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from paquete where paquete.articulo=" + valor + "");
                if (rs.next()) {
                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select paquete.paquete from paquete where paquete.articulo=" + valor + "");
                    while (rs2.next()) {
                        con3 = conectar.conectarMySQL();
                        stmt3 = con3.createStatement();
                        rs3 = stmt3.executeQuery("select articulo.existencia*paquete.cantidad  from articulo"
                                + " inner join paquete on paquete.paquete = articulo.art_id "
                                + "where articulo.art_id=" + rs2.getInt(1) + "");
                        while (rs3.next()) {
                            existencia = rs.getFloat(1);
                        }
                    }
                    con2.close();
                    con3.close();

                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select existencia,clave,descripcion from articulo where art_id=" + valor + "");
                    while (rs2.next()) {
                        existencia = existencia + rs2.getFloat(1);
                    }
                    fila = hoja.createRow(filaa);
                    celda = fila.createCell(0);
                    celda.setCellValue(new HSSFRichTextString(rs2.getString(2)));
                    celda.setCellStyle(encabezados);

                    celda = fila.createCell(1);
                    celda.setCellValue(existencia);
                    celda.setCellStyle(encabezados);

                    celda = fila.createCell(2);
                    celda.setCellValue(new HSSFRichTextString(rs2.getString(3)));
                    celda.setCellStyle(encabezados);

                    filaa = filaa + 1;
                    con2.close();
                } else {
                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select existencia,clave from articulo where art_id=" + valor + "");
                    while (rs2.next()) {
                        existencia = existencia + rs2.getFloat(1);
                    }

                    fila = hoja.createRow(filaa);
                    celda = fila.createCell(0);
                    celda.setCellValue(new HSSFRichTextString(rs2.getString(2)));
                    celda.setCellStyle(encabezados);

                    celda = fila.createCell(1);
                    celda.setCellValue(existencia);
                    celda.setCellStyle(encabezados);

                    celda = fila.createCell(2);
                    celda.setCellValue(new HSSFRichTextString(rs2.getString(3)));
                    celda.setCellStyle(encabezados);

                    filaa = filaa + 1;
                    con2.close();
                }

                existencia = 0;
            }
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        for (int x = 0; x < 20; x++) {
            hoja.autoSizeColumn(x);
        }

        try {
            FileOutputStream elFichero = new FileOutputStream("C:\\Users\\\\GHIA\\Desktop\\olo.xls");
            libro.write(elFichero);
            elFichero.close();
            File archivo = new File("C:\\Users\\\\GHIA\\Desktop\\olo.xls");
            Desktop.getDesktop().open(archivo);
            //JOptionPane.showMessageDialog(null, "Guardado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
