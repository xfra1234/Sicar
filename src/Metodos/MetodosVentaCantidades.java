/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author usuario
 */
public class MetodosVentaCantidades {

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

    protected ArrayList<Float> Cantidadproducto = new ArrayList();
    protected ArrayList<String> Nombreproducto = new ArrayList();
    protected ArrayList<String> Unidadproducto = new ArrayList();

    Object filas[] = new Object[4];
    int contador = 0;//total de porductos

//    public void buscarcantidades(String fecha1, String fecha2) {
//        try {
//            int id;
//            double cantidad = 0;
//            con = conectar.conectarMySQL();
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select articulo.art_id form,articulo.descripcion,unidad.nombre from  articulo inner join"
//                    + " unidad on unidad.uni_id =articulo.unidadventa where articulo.status !=-1 and articulo.cat_id !=1 "
//                    + " and articulo.descripcion not like '%*%';");
//            con2 = conectar.conectarMySQL();
//            stmt2 = con.createStatement();
//
//            while (rs.next()) {
//                id = rs.getInt(1);
//                filas[0] = id;
//                filas[1] = rs.getString(2);
//                rs2 = stmt2.executeQuery("select sum(detallev.cantidad) from detallev inner join venta\n"
//                        + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
//                        + " detallev.art_id=articulo.art_id\n"
//                        + "where articulo.art_id='" + id + "' and\n"
//                        + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
//                while (rs2.next()) {
//                    cantidad = rs2.getDouble(1);
//
//                }
//
//                filas[2] = cantidad;
//                filas[3] = rs.getString(3);
//                ReporteVentasFecha.modelo.addRow(filas);
//                ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    public void prueba(String fecha1, String fecha2, String fechauno, String fechados) {
        try {
            int id;
            double cantidad = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select articulo.art_id form,articulo.descripcion,unidad.nombre from  articulo inner join"
                    + " unidad on unidad.uni_id =articulo.unidadventa where articulo.status !=-1 and articulo.cat_id !=1 "
            );
            con2 = conectar.conectarMySQL();
            stmt2 = con.createStatement();

            while (rs.next()) {

                id = rs.getInt(1);

                rs2 = stmt2.executeQuery("select paquete.paquete from paquete where paquete.paquete= '" + id + "';");

                if (rs2.next()) {

                } else {
                    idNumeros.add(id);
                }

            }
            con.close();
            con2.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Iterator<Integer> it = idNumeros.iterator();
        System.out.println(it);

        while (it.hasNext()) {
            contador = contador + 1;
            System.out.println(it.next());
        }
        float cantidadproducto = 0;
        int alv = 0;
        String nombreproducto = "", unidad = "";
        Persona[] arrayPersonas = new Persona[contador];
        try {
            for (int i = 0; i < contador; i++) {
                int valor = idNumeros.get(i);

                con3 = conectar.conectarMySQL();
                stmt3 = con3.createStatement();
                rs3 = stmt3.executeQuery("select paquete.articulo from paquete where paquete.articulo= '" + valor + "';");
                if (rs3.next()) {

                    con = conectar.conectarMySQL();
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("select paquete.paquete,paquete.cantidad from paquete where paquete.articulo= '" + valor + "';");
                    while (rs.next()) {
                        int idarticulo;
                        idarticulo = rs.getInt(1);

                        con2 = conectar.conectarMySQL();
                        stmt2 = con2.createStatement();
                        float multiplicar = rs.getFloat(2);
                        rs2 = stmt2.executeQuery("select sum(detallev.cantidad) from detallev inner join venta\n"
                                + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                                + " detallev.art_id=articulo.art_id\n"
                                + "where articulo.art_id='" + idarticulo + "' and\n"
                                + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
                        while (rs2.next()) {

                            cantidadproducto = cantidadproducto + (rs2.getFloat(1) * multiplicar);

                        }
                        con2.close();

                        con2 = conectar.conectarMySQL();
                        stmt2 = con2.createStatement();
                        rs2 = stmt2.executeQuery("select sum(detallev.cantidad),articulo.descripcion,unidad.nombre from detallev inner join venta\n"
                                + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                                + " detallev.art_id=articulo.art_id inner join unidad on uni_id= articulo.unidadventa\n"
                                + "where articulo.art_id='" + valor + "' and\n"
                                + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
                        if (rs2.next()) {
                            cantidadproducto = cantidadproducto + rs2.getFloat(1);
                            nombreproducto = rs2.getString(2);
                            unidad = rs2.getString(3);
                        }
                        con2.close();
                    }

                    con.close();
                } else {
                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select sum(detallev.cantidad),articulo.descripcion,unidad.nombre  from detallev inner join venta\n"
                            + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                            + " detallev.art_id=articulo.art_id inner join unidad on uni_id= articulo.unidadventa\n"
                            + "where articulo.art_id='" + valor + "' and\n"
                            + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
                    if (rs2.next()) {
                        cantidadproducto = cantidadproducto + rs2.getFloat(1);
                        nombreproducto = rs2.getString(2);
                        unidad = rs2.getString(3);
                    }
                    con2.close();
                }
                Cantidadproducto.add(cantidadproducto);
                Nombreproducto.add(nombreproducto);
                Unidadproducto.add(unidad);
                 arrayPersonas[i] = new Persona(nombreproducto, cantidadproducto, unidad);
                cantidadproducto = 0;
                con3.close();
                alv = alv + 1;

            }
            GeneraExcel2(fechauno, fechados);
            System.out.println(alv + " final ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
           
           
//            System.out.println("Array sin ordenar por altura");
//            imprimeArrayPersonas(arrayPersonas);
            // Ordeno el array de personas por altura (de menor a mayor)
    }

    public void GeneraExcel2(String fechauno, String fechados) {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();

        //formato para el nombre de las columnas
        CellStyle headerStyle = libro.createCellStyle();
        HSSFFont font = libro.createFont();
        font.setBold(true);
        font.setFontName("Arial");
        font.setFontHeight((short) (14 * 20));
        headerStyle.setFont(font);

        //formato para las celdas de la tabla
        CellStyle style = libro.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //formato para encabezados
        CellStyle encabezados = libro.createCellStyle();
        HSSFFont font2 = libro.createFont();
        font2.setBold(true);
        font2.setFontName("Arial");
        font2.setFontHeight((short) (10 * 20));
        encabezados.setFont(font2);

        HSSFCell celda;
        HSSFRow fila;
        Date fecha = new Date();
        SimpleDateFormat formatoexport = new SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss");
        String f = formatoexport.format(fecha);
        f = f.toUpperCase().charAt(0) + f.substring(1, 9) + " " + f.toUpperCase().charAt(10) + f.substring(11, f.length());

        CellStyle letraprincipal = libro.createCellStyle();
        HSSFFont font3 = libro.createFont();
        font3.setBold(true);
        font3.setFontName("Arial");
        font3.setFontHeight((short) (15 * 20));
        letraprincipal.setFont(font3);

        fila = hoja.createRow(0);
        celda = fila.createCell(5);
        celda.setCellValue(new HSSFRichTextString("LA BUENA SEMILLA"));
        celda.setCellStyle(letraprincipal);
        //muestro la fecha de creacion

        fila = hoja.createRow(1);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Fecha de Creacion:"));
        celda.setCellStyle(encabezados);
        celda = fila.createCell(1);
        celda.setCellValue(new HSSFRichTextString(f));
        celda.setCellStyle(encabezados);
        celda = fila.createCell(5);
        celda.setCellValue(new HSSFRichTextString("Sucursal: "));
        celda.setCellStyle(encabezados);

        fila = hoja.createRow(2);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Reporte de Cantidad de Productos del "));
        celda.setCellStyle(encabezados);
        celda = fila.createCell(1);
        celda.setCellValue(new HSSFRichTextString(fechauno));
        celda.setCellStyle(encabezados);
        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Al"));
        celda.setCellStyle(encabezados);
        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString(fechados));
        celda.setCellStyle(encabezados);

        fila = hoja.createRow(4);

        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Producto"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(1);
        celda.setCellValue(new HSSFRichTextString("Cantidad"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Unidad"));
        celda.setCellStyle(headerStyle);

        int i = 5;

        for (int j = 0; j < contador; j++) {
            fila = hoja.createRow(i);
            celda = fila.createCell(0);
            celda.setCellValue(new HSSFRichTextString(Nombreproducto.get(j)));
            celda.setCellStyle(style);

            celda = fila.createCell(1);
            celda.setCellValue((Cantidadproducto.get(j)));
            celda.setCellStyle(style);

            celda = fila.createCell(2);
            celda.setCellValue(new HSSFRichTextString(Unidadproducto.get(j)));
            celda.setCellStyle(style);

            i = i + 1;

        }
        for (int x = 0; x < 5; x++) {
            hoja.autoSizeColumn(x);
        }

        try {
            FileOutputStream elFichero = new FileOutputStream("C:\\Users\\GHIA\\Desktop\\Ventaporductos del " + fechauno + " al " + fechados + ".xls");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "Guardado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }



    static class Persona implements Comparable<Persona> {

        public String nombrep,unidadp;
        public float cantidadp;

        public Persona(String nombrep, Float cantidadp, String unidadp) {
            this.nombrep = nombrep;
            this.cantidadp = cantidadp;
            this.unidadp = unidadp;
        }

        @Override
        public int compareTo(Persona o) {
            if (cantidadp < o.cantidadp) {
                return -1;
            }
            if (cantidadp > o.cantidadp) {
                return 1;
            }
            return 0;
        }

        static void imprimeArrayPersonas(Persona[] array) {
//            for (int i = 0; i < array.length; i++) {
//                System.out.println((i + 1) + ". " + array[i].nombrep + " - Cantidad: " + array[i].cantidadp + " - Unidad: " + array[i].unidadp);
//            }
            System.out.println(array[1].nombrep);
        }
        
        public void imprimirarrays() {
           
            return ;
        }

    }
}
