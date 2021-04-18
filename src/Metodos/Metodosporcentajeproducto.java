/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.Metodosporcentajeproducto.Persona.imprimeArrayPersonas;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
 * @author GHIA
 */
public class Metodosporcentajeproducto {

    int contador = 0;
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
    static float totalcantidad = 0;

    static protected ArrayList<Float> Cantidadproducto = new ArrayList();
    static protected ArrayList<String> Nombreproducto = new ArrayList();
    static protected ArrayList<Float> Porcentajeproducto = new ArrayList();
    static protected ArrayList<Float> Ventaproducto = new ArrayList();

    static protected ArrayList<Float> Cantidadproducto20 = new ArrayList();
    static protected ArrayList<String> Nombreproducto20 = new ArrayList();
    static protected ArrayList<Float> Porcentajeproducto20 = new ArrayList();
    static protected ArrayList<Float> Ventaproducto20 = new ArrayList();

    static int productosnum = 0, productosnum20 = 0;
    static float sumaproductos = 0, porcentajeporducto = 0;

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
        float cantidadproducto = 0, ventaproducto = 0;
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
                        rs2 = stmt2.executeQuery("select sum(detallev.cantidad),sum(detallev.importenorcon) from detallev inner join venta\n"
                                + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                                + " detallev.art_id=articulo.art_id\n"
                                + "where articulo.art_id='" + idarticulo + "' and\n"
                                + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
                        while (rs2.next()) {

                            cantidadproducto = cantidadproducto + (rs2.getFloat(1) * multiplicar);
                            ventaproducto = ventaproducto + (rs2.getFloat(2));

                        }
                        con2.close();
                    }
                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select sum(detallev.cantidad),articulo.descripcion,unidad.nombre,sum(detallev.importenorcon) from detallev inner join venta\n"
                            + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                            + " detallev.art_id=articulo.art_id inner join unidad on uni_id= articulo.unidadventa\n"
                            + "where articulo.art_id='" + valor + "' and\n"
                            + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
                    if (rs2.next()) {

                        cantidadproducto = cantidadproducto + rs2.getFloat(1);
                        nombreproducto = rs2.getString(2);
                        unidad = rs2.getString(3);
                        ventaproducto = ventaproducto + (rs2.getFloat(4));

                    }
                    con2.close();

                    con.close();
                } else {
                    con2 = conectar.conectarMySQL();
                    stmt2 = con2.createStatement();
                    rs2 = stmt2.executeQuery("select sum(detallev.cantidad),articulo.descripcion,unidad.nombre,sum(detallev.importenorcon)  from detallev inner join venta\n"
                            + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                            + " detallev.art_id=articulo.art_id inner join unidad on uni_id= articulo.unidadventa\n"
                            + "where articulo.art_id='" + valor + "' and\n"
                            + "venta.fecha between '" + fecha1 + "' and '" + fecha2 + "';");
                    while (rs2.next()) {
                        cantidadproducto = cantidadproducto + rs2.getFloat(1);
                        nombreproducto = rs2.getString(2);
                        unidad = rs2.getString(3);
                        ventaproducto = ventaproducto + (rs2.getFloat(4));

                    }
                    con2.close();
                }

                arrayPersonas[i] = new Persona(nombreproducto, cantidadproducto, ventaproducto);
                totalcantidad = totalcantidad + ventaproducto;
                cantidadproducto = 0;
                ventaproducto = 0;
                con3.close();
                alv = alv + 1;

            }

            Arrays.sort(arrayPersonas, Collections.reverseOrder());
            imprimeArrayPersonas(arrayPersonas);
            GeneraExcel2(fechauno, fechados);
            System.out.println(totalcantidad);
            System.out.println(alv + " final ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

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

        CellStyle porcentaje = libro.createCellStyle();
        porcentaje.setDataFormat(libro.createDataFormat().getFormat("0.000%"));
        porcentaje.setFont(font2);

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
        celda.setCellValue(new HSSFRichTextString("Reporte de Productos que conforman el 80% de ventas  del "));
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
        celda.setCellValue(new HSSFRichTextString("Total de Productos "));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(1);
        celda.setCellValue(productosnum);
        celda.setCellStyle(encabezados);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Total de Venta "));
        celda.setCellStyle(encabezados);

        celda = fila.createCell(4);
        celda.setCellValue(totalcantidad);
        celda.setCellStyle(encabezados);

        fila = hoja.createRow(5);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Productos que Conforman el 80%"));
        celda.setCellStyle(headerStyle);
        
        
        fila = hoja.createRow(6);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Producto"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(1);
        celda.setCellValue(new HSSFRichTextString("Cantidad"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Venta"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Porcentaje"));
        celda.setCellStyle(headerStyle);

//        celda = fila.createCell(2);
//        celda.setCellValue(new HSSFRichTextString("Unidad"));
//        celda.setCellStyle(headerStyle);
        int i = 7;

        for (int j = 0; j < productosnum; j++) {
            fila = hoja.createRow(i);
            celda = fila.createCell(0);
            celda.setCellValue(new HSSFRichTextString(Nombreproducto.get(j)));
            celda.setCellStyle(encabezados);

//            celda = fila.createCell(1);
//            celda.setCellValue((Cantidadproducto.get(j)));
//            celda.setCellStyle(style);
            celda = fila.createCell(1);
            celda.setCellValue((Cantidadproducto.get(j)));
            celda.setCellStyle(encabezados);

            celda = fila.createCell(2);
            celda.setCellValue((Ventaproducto.get(j)));
            celda.setCellStyle(encabezados);

            celda = fila.createCell(3);
            celda.setCellValue((Porcentajeproducto.get(j)));
            celda.setCellStyle(porcentaje);

            i = i + 1;

        }
        i = i + 1;
        fila = hoja.createRow(i);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Productos que Conforman el 20% "));
        celda.setCellStyle(headerStyle);
        i = i + 1;
        
        fila = hoja.createRow(i);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Total de Productos"));
        celda.setCellStyle(encabezados);
        
        celda = fila.createCell(1);
        celda.setCellValue(productosnum20);
        celda.setCellStyle(encabezados);
        
        i = i + 1;
        fila = hoja.createRow(i);
        celda = fila.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Producto"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(1);
        celda.setCellValue(new HSSFRichTextString("Cantidad"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(2);
        celda.setCellValue(new HSSFRichTextString("Venta"));
        celda.setCellStyle(headerStyle);

        celda = fila.createCell(3);
        celda.setCellValue(new HSSFRichTextString("Porcentaje"));
        celda.setCellStyle(headerStyle);
        i = i + 1;
        for (int j = 0; j < productosnum20; j++) {
            fila = hoja.createRow(i);
            celda = fila.createCell(0);
            celda.setCellValue(new HSSFRichTextString(Nombreproducto20.get(j)));
            celda.setCellStyle(encabezados);

//            celda = fila.createCell(1);
//            celda.setCellValue((Cantidadproducto.get(j)));
//            celda.setCellStyle(style);
            celda = fila.createCell(1);
            celda.setCellValue((Cantidadproducto20.get(j)));
            celda.setCellStyle(encabezados);

            celda = fila.createCell(2);
            celda.setCellValue((Ventaproducto20.get(j)));
            celda.setCellStyle(encabezados);

            celda = fila.createCell(3);
            celda.setCellValue((Porcentajeproducto20.get(j)));
            celda.setCellStyle(porcentaje);

            i = i + 1;

        }
        
        
        
        for (int x = 0; x < 5; x++) {
            hoja.autoSizeColumn(x);
        }

        try {
            FileOutputStream elFichero = new FileOutputStream("C:\\Users\\\\Cpu\\Desktop\\Productos Conforman el 80% de venta " + fechauno + " al " + fechados + ".xls");
            libro.write(elFichero);
            elFichero.close();
            JOptionPane.showMessageDialog(null, "Guardado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    static class Persona implements Comparable<Persona> {

        public String nombrep;
        public float cantidadp, ventap;

        public Persona(String nombrep, Float cantidadp, Float ventap) {
            this.nombrep = nombrep;
            this.cantidadp = cantidadp;
            this.ventap = ventap;
        }

        @Override
        public int compareTo(Persona o) {
            if (ventap < o.ventap) {
                return -1;
            }
            if (ventap > o.ventap) {
                return 1;
            }
            return 0;
        }

        static void imprimeArrayPersonas(Persona[] array) {
            
            for (int i = 0; i < array.length; i++) {
                //

                if (sumaproductos > .80) {
                     porcentajeporducto = (array[i].ventap / totalcantidad);
                    if (porcentajeporducto == 0) {
                        break;
                    } else {
                        porcentajeporducto = (array[i].ventap / totalcantidad);
                        Nombreproducto20.add(array[i].nombrep);
                        Cantidadproducto20.add(array[i].cantidadp);
                        Ventaproducto20.add(array[i].ventap);
                        Porcentajeproducto20.add(porcentajeporducto);
                        sumaproductos = sumaproductos + porcentajeporducto;
                        porcentajeporducto = 0;
                        productosnum20 = productosnum20 + 1;
                        System.out.println(sumaproductos);
                    }

                } else {
                    porcentajeporducto = (array[i].ventap / totalcantidad);
                    sumaproductos = sumaproductos + porcentajeporducto;
                    System.out.println((i + 1) + ". " + array[i].nombrep + " - Cantidad: " + array[i].cantidadp + array[i].ventap + " Porcentaje  " + porcentajeporducto + " - total procentaje " + sumaproductos);
                    Nombreproducto.add(array[i].nombrep);
                    Cantidadproducto.add(array[i].cantidadp);
                    Ventaproducto.add(array[i].ventap);
                    Porcentajeproducto.add(porcentajeporducto);
                    porcentajeporducto = 0;
                    productosnum = productosnum + 1;
                }

            }
            System.out.println("Productos que formal el 80%" + productosnum);
            //System.out.println(array[1].nombrep);
        }

    }

}
