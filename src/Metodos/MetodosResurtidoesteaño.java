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
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author usuario
 */
public class MetodosResurtidoesteaño {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    Connection con2 = null;
    static ResultSet rs2 = null;
    private Statement stmt2 = null;
    Connection con3 = null;
    static ResultSet rs3 = null;
    private Statement stmt3 = null;
    Connection con4 = null;
    static ResultSet rs4 = null;
    private Statement stmt4 = null;
    conexion conectar = new conexion();
    conexion2 conectar2 = new conexion2();
    String abrirarchivo = "", guardararchivo = "";
    int contador = 0, contador1 = 0;
    float cantidad3ma = 0, existencia = 0, preciocompra = 0;
    String descripcion = "", descripcion2 = "", categoria = "", clave = "";
    int idpaquete;
    Double cero = 0.0;
    CellStyle Numerico;
    int filaa;
    protected ArrayList<Integer> idNumeros = new ArrayList();

    POIFSFileSystem fs;
    HSSFWorkbook libro;
    HSSFSheet hoja;
    HSSFRow fila;
    Row row;
    HSSFCell celda;
    HSSFDataFormat format;

    public void limpiarVariables() {
        cantidad3ma = 0;

        contador = 0;
        contador1 = 0;
        idpaquete = 0;
    }

    public void sucursales(String fecha1, String fecha2, int sucursal, String mes) {
        switch (sucursal) {
            case 1:
//                abrirarchivo = ("C:\\Users\\usuario\\Desktop\\Resurtido.xls");
//                guardararchivo = ("C:\\Users\\usuario\\Desktop\\Resurtido de sucursal2.xls");
                abrirarchivo = ("C:\\Users\\Cpu\\Documents\\Resurtido de sucursal mes.xls");
                guardararchivo = ("C:\\Users\\Cpu\\Desktop\\Resurtido solo este año de la sucursal_Magisterio de " + mes + " .xls");
                resurtidosucursal(fecha1, fecha2, sucursal);
                break;
            case 2:

                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Resurtido de sucursal mes.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Resurtido solo este año de la sucursal_Coapinole de" + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, sucursal);
                break;
            case 3:
                abrirarchivo = ("C:\\Users\\GHIA\\Documents\\Resurtido de sucursal mes.xls");
                guardararchivo = ("C:\\Users\\GHIA\\Desktop\\Resurtido solo este año de Bodega " + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, sucursal);
                break;

            case 4:
                abrirarchivo = ("C:\\Users\\billy\\Documents\\Resurtido de sucursal mes.xls");
                guardararchivo = ("C:\\Users\\billy\\Desktop\\Resurtido solo este año de Bodega pdv " + mes + ".xls");
                resurtidosucursal(fecha1, fecha2, sucursal);
                break;
        }
    }

    public void enviar0() {
        for (int x = 2; x < 8; x++) {
            fila = hoja.getRow(filaa);
            celda = fila.createCell(x);
            celda.setCellValue(cero);
            celda.setCellStyle(Numerico);
        }
    }

    public void resurtidosucursal(String fecha1ma, String fecha3ma, int sucursal) {

        try ( FileInputStream file = new FileInputStream(new File(abrirarchivo))) {
            fs = new POIFSFileSystem(file);
            libro = new HSSFWorkbook(fs);
            //obtener la hoja que se va leer
            hoja = libro.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            format = libro.createDataFormat();

            // aplicar filtro al archivo
            hoja.setAutoFilter(new CellRangeAddress(0, 0, 0, 6));
            // dejar fija la primera fila
            hoja.createFreezePane(0, 1);

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

            /// formato Numerico con dos digitos despues del punto
            Numerico = libro.createCellStyle();
            HSSFFont fontnumerico = libro.createFont();
            fontnumerico.setBold(true);
            fontnumerico.setFontName("Arial");
            fontnumerico.setFontHeight((short) (10 * 20));
            Numerico.setDataFormat(format.getFormat("###,##0.00"));
            Numerico.setFont(fontnumerico);

            filaa = 1;
            try {

                if (sucursal == 4) {
                    con = conectar2.conectarMySQL();
                } else {
                    con = conectar.conectarMySQL();
                }
                stmt = con.createStatement();
                rs = stmt.executeQuery("select articulo.art_id,articulo.clave,articulo.existencia,"
                        + "articulo.descripcion,categoria.nombre,articulo.precioCompra "
                        + " from articulo inner join categoria on categoria.cat_id = articulo.cat_id "
                        + " where articulo.status !=-1  order by categoria.nombre,articulo.descripcion");
                while (rs.next()) {
                    if (sucursal == 4) {
                        con4 = conectar2.conectarMySQL();
                    } else {
                        con4 = conectar.conectarMySQL();
                    }
                    stmt4 = con4.createStatement();
                    rs4 = stmt4.executeQuery("select paquete.paquete from paquete where "
                            + "paquete.paquete = " + rs.getInt(1) + "");
                    if (rs4.next()) {
                        existencia = 0;
                    } else {
                        existencia = rs.getFloat(3);
                    }
                    con4.close();
                    int idart = rs.getInt(1);
                    clave = rs.getString(2);
                    descripcion = rs.getString(4);
                    categoria = rs.getString(5);
                    preciocompra = (float) (rs.getFloat(6) * 1.16);

                    if (sucursal == 4) {
                        con2 = conectar2.conectarMySQL();
                    } else {
                        con2 = conectar.conectarMySQL();
                    }
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

                    if (categoria.equals(descripcion2)) {
                        fila = hoja.getRow(filaa);

//                        celda = fila.createCell(0);
//                        celda.setCellValue(clave);
//                        celda.setCellStyle(encabezados);
                        celda = fila.createCell(0);
                        celda.setCellValue(descripcion);
                        celda.setCellStyle(encabezados);

                        celda = fila.createCell(1);
                        celda.setCellValue(existencia);
                        celda.setCellStyle(Numerico);

                        celda = fila.createCell(2);
                        celda.setCellValue(preciocompra);
                        celda.setCellStyle(Numerico);

                        celda = fila.createCell(3);
                        celda.setCellValue((cantidad3ma / 3));
                        celda.setCellStyle(Numerico);

                        if (filaa > 0) {
                            int filaformula = filaa + 1;

                            String Formula;

                            //// Formula 7 dias mes anterior
                            Formula = "D" + filaformula + "/4";
                            celda = fila.createCell(4);
                            celda.setCellFormula(Formula);
                            celda.setCellStyle(Numerico);

                            //// Formula Resurtido mes   anterior
                            Formula = "E" + filaformula + "-B" + filaformula;
                            celda = fila.createCell(5);
                            celda.setCellFormula(Formula);
                            celda.setCellStyle(Numerico);

                            //// Formula Dias Inventario Mes  Anterior  
                            Formula = "B" + filaformula + "*30/D" + filaformula;
                            celda = fila.createCell(7);
                            celda.setCellFormula(Formula);
                            celda.setCellStyle(Numerico);

                        }
                        filaa = filaa + 1;
//                        enviar0();
                    } else {
//                        filaa = filaa + 1;
//                        enviar0();
//                        fila = hoja.getRow(filaa);
//                        celda = fila.createCell(0);
//                        celda.setCellValue(categoria);
//                        celda.setCellStyle(letraprincipal);

//                        filaa = filaa + 1;
//                        enviar0();
                        fila = hoja.getRow(filaa);

//                        celda = fila.createCell(0);
//                        celda.setCellValue(clave);
//                        celda.setCellStyle(encabezados);
                        celda = fila.createCell(0);
                        celda.setCellValue(descripcion);
                        celda.setCellStyle(encabezados);

                        celda = fila.createCell(1);
                        celda.setCellValue(existencia);
                        celda.setCellStyle(Numerico);

                        celda = fila.createCell(2);
                        celda.setCellValue((preciocompra));
                        celda.setCellStyle(Numerico);

                        celda = fila.createCell(3);
                        celda.setCellValue((cantidad3ma / 3));
                        celda.setCellStyle(Numerico);

                        if (filaa > 0) {
                            int filaformula = filaa + 1;

                            String Formula;

                            //// Formula 7 dias mes anterior
                            Formula = "D" + filaformula + "/4";
                            celda = fila.createCell(4);
                            celda.setCellFormula(Formula);
                            celda.setCellStyle(Numerico);

                            //// Formula Resurtido mes   anterior
                            Formula = "E" + filaformula + "-B" + filaformula;
                            celda = fila.createCell(5);
                            celda.setCellFormula(Formula);
                            celda.setCellStyle(Numerico);

                            //// Formula Dias Inventario Mes  Anterior  
                            Formula = "B" + filaformula + "*30/D" + filaformula;
                            celda = fila.createCell(7);
                            celda.setCellFormula(Formula);
                            celda.setCellStyle(Numerico);
                        }
                        filaa = filaa + 1;
//                        enviar0();
                        descripcion2 = categoria;
                    }

                    existencia = 0;
                    cantidad3ma = 0;

                }
                con.close();

                //////////////////////////////////////////////////////////////////
                existencia = 0;
                cantidad3ma = 0;
                preciocompra = 0;

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
