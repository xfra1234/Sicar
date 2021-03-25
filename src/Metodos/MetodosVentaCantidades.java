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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import reportes.ReporteVentasFecha;
import reportes.conexion;

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
    conexion conectar = new conexion();

    Object filas[] = new Object[4];

    public void modeloTabla() {
        if (ReporteVentasFecha.controlmodelo == false) {
            ReporteVentasFecha.modelo.addColumn("ID Articulo");
            ReporteVentasFecha.modelo.addColumn("Nombre");
            ReporteVentasFecha.modelo.addColumn("Cantidad");
            ReporteVentasFecha.modelo.addColumn("Unidad");
            ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);
            acomodofilas();
            tamañocolumnas();
            ReporteVentasFecha.controlmodelo = true;
        } else {
            ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);
            acomodofilas();
            tamañocolumnas();

        }
    }

    public void acomodofilas(){
        
        ReporteVentasFecha.tblbuscar.setRowHeight(30);    
        ReporteVentasFecha.tcr.setHorizontalAlignment(SwingConstants.CENTER);
        ReporteVentasFecha.tblbuscar.getColumnModel().getColumn(0).setCellRenderer( ReporteVentasFecha.tcr);
        ReporteVentasFecha.tblbuscar.getColumnModel().getColumn(1).setCellRenderer( ReporteVentasFecha.tcr); 
        ReporteVentasFecha.tblbuscar.getColumnModel().getColumn(2).setCellRenderer( ReporteVentasFecha.tcr); 
        ReporteVentasFecha.tblbuscar.getColumnModel().getColumn(3).setCellRenderer( ReporteVentasFecha.tcr);  
        
    }
    public void tamañocolumnas()
    {
         TableColumnModel ModeloColumnas = ReporteVentasFecha.tblbuscar.getColumnModel();
          ModeloColumnas.getColumn(0).setPreferredWidth(40);
          ModeloColumnas.getColumn(1).setPreferredWidth(200);
          ModeloColumnas.getColumn(2).setPreferredWidth(60);
          ModeloColumnas.getColumn(3).setPreferredWidth(60);
    }
    
    
    public void buscarcantidades(String fecha1, String fecha2) {
        try {
            int id;
            double cantidad = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select articulo.art_id form,articulo.descripcion,unidad.nombre from  articulo inner join"
                    + " unidad on unidad.uni_id =articulo.unidadventa;");
            con2 = conectar.conectarMySQL();
            stmt2 = con.createStatement();

            while (rs.next()) {
                id =rs.getInt(1);
                filas[0] = id;
                filas[1] = rs.getString(2);
                rs2 = stmt2.executeQuery("select sum(detallev.cantidad) from detallev inner join venta\n"
                        + "on detallev.ven_id = venta.ven_id inner join articulo on\n"
                        + " detallev.art_id=articulo.art_id\n"
                        + "where articulo.art_id='"+id+"' and\n"
                        + "venta.fecha between '"+fecha1+"' and '"+fecha2+"';");
                while (rs2.next()) {
                    cantidad=rs2.getDouble(1);
                    
                }

                filas[2] = cantidad;
                filas[3] = rs.getString(3);
                ReporteVentasFecha.modelo.addRow(filas);
                ReporteVentasFecha.tblbuscar.setModel(ReporteVentasFecha.modelo);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
//    
//    public void GeneraExcel(JTable table,String fecha1,String fecha2) {
//        HSSFWorkbook libro = new HSSFWorkbook();      
//        HSSFSheet hoja = libro.createSheet();
//        CellStyle headerStyle = libro.createCellStyle();
//        HSSFFont font = libro.createFont();
//        font.setBold(true);
//        headerStyle.setFont(font);
//        
//        CellStyle style = libro.createCellStyle();
//        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        for (int i = 0; i <= table.getRowCount()-1; i++) {
//            HSSFRow fila = hoja.createRow(i);           
//            if(i==0){
//                for (int j = 0; j <= table.getColumnCount()-1; j++) {
//                    HSSFCell celda = fila.createCell(j);
//                    celda.setCellValue(new HSSFRichTextString(table.getColumnModel().getColumn(j).getHeaderValue().toString()));
//                     celda.setCellStyle(headerStyle);
//                }
//            }else{
//                for (int j = 0; j <= table.getColumnCount()-1; j++) {
//                    HSSFCell celda = fila.createCell(j);
//                    if(table.getValueAt(i, j)!=null)
//                        celda.setCellValue(new HSSFRichTextString(table.getValueAt(i, j).toString()));
//                 
//                }
//            }
//            try {
//                FileOutputStream elFichero = new FileOutputStream("C:\\Users\\GHIA\\Desktop\\Ventaporductos del "+fecha1+" al "+fecha2+" .xls");
//                libro.write(elFichero);
//                elFichero.close();
//            } catch (IOException e ) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//        JOptionPane.showMessageDialog(null, "Guardado");
//    }

    
    
     public void GeneraExcel(JTable table,String fecha1,String fecha2) {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();
        CellStyle headerStyle = libro.createCellStyle();
        HSSFFont font = libro.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = libro.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCell celda;
        HSSFRow fila;
        fila = hoja.createRow(0);
        for (int j = 0; j <= table.getColumnCount() - 1; j++) {
            celda = fila.createCell(j);
            celda.setCellValue(new HSSFRichTextString(table.getColumnModel().getColumn(j).getHeaderValue().toString()));
            celda.setCellStyle(headerStyle);

        }
        int contador = 1;
        for (int i = 0; i <= table.getRowCount() - 1; i++) {
            fila = hoja.createRow(i + 1);

            for (int j = 0; j <= table.getColumnCount() - 1; j++) {
                celda = fila.createCell(j);
                if (table.getValueAt(i, j) != null) {
                    celda.setCellValue(new HSSFRichTextString(table.getValueAt(i, j).toString()));
                }
                
                    hoja.autoSizeColumn(j);
                
            }

        }
        try {
            FileOutputStream elFichero = new FileOutputStream("C:\\Users\\GHIA\\Desktop\\Ventaporductos del "+fecha1+" al "+fecha2+" .xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        JOptionPane.showMessageDialog(null, "Guardado");
    }

    
    
}
