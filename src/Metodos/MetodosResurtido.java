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
                guardararchivo = ("C:\\Users\\Cpu\\Desktop\\Resurtido de sucursal_Magisterio de " + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, fechauno, fechados);
                break;
            case 2:

                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Resurtido de sucursal_Coapinole de" + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, fechauno, fechados);
                break;
            case 3:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Resurtido de sucursal_ Bodega de" + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, fechauno, fechados);
                break;

            case 4:
                abrirarchivo = ("C:\\Users\\billy\\Documents\\Resurtido de sucursal.xls");
                guardararchivo = ("C:\\Users\\billy\\Desktop\\Resurtido de sucursal_ Bodega pdv de" + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, fechauno, fechados);
                break;
        }
    }

    public void resurtidosucursal(String fecha1ma, String fecha3ma, String fecha1md, String fecha3md) {

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
                con3 = conectar.conectarMySQL();
                stmt3 = con3.createStatement();
                rs3 = stmt3.executeQuery("select articulo.art_id from articulo ");
                while (rs3.next()) {

                    con = conectar.conectarMySQL();
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("select paquete.paquete from paquete where "
                            + "paquete.paquete = " + rs3.getInt(1) + "");
                    if (rs.next()) {
                        con.close();
                    } else {
                        con.close();

                        con = conectar.conectarMySQL();
                        stmt = con.createStatement();
                        rs = stmt.executeQuery("select articulo.art_id,articulo.clave,articulo.existencia,"
                                + "articulo.descripcion,categoria.nombre"
                                + " from articulo inner join categoria on categoria.cat_id = articulo.cat_id "
                                + " where articulo.status !=-1  order by categoria.nombre,articulo.descripcion");
                        while (rs.next()) {
                            int idart = rs.getInt(1);
                            clave = rs.getString(2);
                            existencia = rs.getFloat(3);
                            descripcion = rs.getString(4);
                            categoria = rs.getString(5);

                            con2 = conectar.conectarMySQL();
                            stmt2 = con2.createStatement();
                            rs2 = stmt2.executeQuery("select sum(cantidad) from detallev "
                                    + "inner join venta on venta.ven_id = detallev.ven_id "
                                    + " where detallev.art_id=" + idart + " and "
                                    + " venta.fecha between '" + fecha1ma + "' and '" + fecha3ma + "'"
                                    + " and venta.status!=-1");
                            if (rs2.next()) {
                                cantidad3ma = cantidad3ma + rs2.getFloat(1);
                            }
                            con2.close();

                            con2 = conectar.conectarMySQL();
                            stmt2 = con2.createStatement();
                            rs2 = stmt2.executeQuery("select sum(cantidad) from detallev "
                                    + "inner join venta on venta.ven_id = detallev.ven_id "
                                    + " where detallev.art_id=" + idart + " and "
                                    + " venta.fecha between '" + fecha1md + "' and '" + fecha3md + "'"
                                    + " and venta.status!=-1");
                            if (rs2.next()) {
                                cantidad3md = cantidad3md + rs2.getFloat(1);
                            }
                            con2.close();

                            if (categoria.equals(descripcion2)) {
                                fila = hoja.getRow(filaa);
//                    
                                celda = fila.createCell(0);
                                celda.setCellValue(clave);
                                celda.setCellStyle(encabezados);

                                celda = fila.createCell(1);
                                celda.setCellValue(descripcion);
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
                                celda.setCellValue(categoria);
                                celda.setCellStyle(letraprincipal);

                                filaa = filaa + 1;

                                fila = hoja.getRow(filaa);

                                celda = fila.createCell(0);
                                celda.setCellValue(clave);
                                celda.setCellStyle(encabezados);

                                celda = fila.createCell(1);
                                celda.setCellValue(descripcion);
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
                                descripcion2 = categoria;
                            }

                            existencia = 0;
                            cantidad3ma = 0;
                            cantidad3md = 0;
                        }
                    }
                }

                con.close();

                //////////////////////////////////////////////////////////////////
                existencia = 0;
                cantidad3ma = 0;
                cantidad3md = 0;
                for (int x = 0; x < 19; x++) {
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
