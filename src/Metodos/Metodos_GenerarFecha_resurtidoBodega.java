/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author coron
 */
public class Metodos_GenerarFecha_resurtidoBodega {

    int difM = 0;
    int difA = 0;
    Calendar promfechaadelante = Calendar.getInstance();
    Calendar fechaactual = Calendar.getInstance();
    String fecha3mesdia1 = ""; //fecha primer dia del tercer mes atras
    String fecha3mesdiault = ""; // fecha del ultimo dia del tercer mes atras
    String fecha2mesdia1 = ""; //fecha del primer dia del segundo mes atras
    String fecha2mesdiault = ""; //fecha del ultimo dia del segundo mes atras
    String fecha1mesdia1 = "";  //Fecha del primer dia del mes anterior
    String fecha1mesdiault = ""; //Fecha del ultimo dia del mes anterior
    String fechaaniodia1 = "";  //Fecha del primer dia del año anterior 
    String fechaaniodiault = "";// fehca del ultimio dia del año anterio
    String fechaanio3dia1 = "";  //Fecha del primer dia del año anterior mes adelante
    String fechaanio3diault = "";// fehca del ultimio dia del año anterio mes adelante
    MetodosResurtido met = new MetodosResurtido(); //inicializo el metodo de resurtido
    SimpleDateFormat Mes = new SimpleDateFormat("EEEE dd MMMMM yyyy ");

    public void generarfecha1mes(Date fecha) {
        String mesactual = Mes.format(fecha);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        fechaactual.setTime(fecha);
        //obtengo la fecha del primer dia mes anterior
        fechaactual.add(fechaactual.MONTH, -1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha1mesdia1 = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fecha1mesdia1 = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }
//obtengo la fecha del ultimo dia mes anterior
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, -1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha1mesdiault = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        } else {
            fecha1mesdiault = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }
        //termino de obtener las fechas y las imprimo
        System.out.println(fecha1mesdia1);
        System.out.println(fecha1mesdiault);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        fechaactual.setTime(fecha);
        //obtengo la fecha del primer dia mes 2 atras 
        fechaactual.add(fechaactual.MONTH, -2);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha2mesdia1 = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fecha2mesdia1 = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }
//obtengo la fecha del ultimo dia mes 2 atras 
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, -2);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha2mesdiault = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";

        } else {
            fecha2mesdiault = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }
        //termino de obtener las fechas y las imprimo
        System.out.println(fecha2mesdia1);
        System.out.println(fecha2mesdiault);

        fechaactual.setTime(fecha);
///////////////////////////////////////////////////////////////////////////////////////////////////////
        //obtengo la fecha del primer dia mes 3 atras 
        fechaactual.add(fechaactual.MONTH, -3);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha3mesdia1 = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fecha3mesdia1 = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }
//obtengo la fecha del ultimo dia mes 3 atras 
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, -3);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fecha3mesdiault = fechaactual.get(fechaactual.YEAR) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        } else {
            fecha3mesdiault = fechaactual.get(fechaactual.YEAR) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }
        //termino de obtener las fechas y las imprimo
        System.out.println(fecha3mesdia1);
        System.out.println(fecha3mesdiault);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        //obtengo dia 1 del año anterior
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, 1);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechaanio3dia1 = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fechaanio3dia1 = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }
        //obtengo ultimo del año anterior 3meses
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, 3);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechaanio3diault = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        } else {
            fechaanio3diault = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }

        System.out.println(fechaaniodia1);
        System.out.println(fechaaniodiault);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        

        //obtengo dia 1 del año anterior mismo mes
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, 0);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechaanio3dia1 = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        } else {
            fechaanio3dia1 = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + "01" + " 00:00:00";
        }

//obtengo ultimo del año anterior mismo mes
        fechaactual.setTime(fecha);
        fechaactual.add(fechaactual.MONTH, 0);
        if (fechaactual.get(fechaactual.MONTH) < 9) {
            fechaanio3diault = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + "0"
                    + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        } else {
            fechaanio3diault = (fechaactual.get(fechaactual.YEAR) - 1) + "-" + (fechaactual.get(fechaactual.MONTH) + 1) + "-" + fechaactual.getMaximum(fechaactual.DAY_OF_MONTH) + " 23:59:59";
        }
        System.out.println(fechaanio3dia1);
        System.out.println(fechaanio3diault);

        System.out.println(mesactual);
        
        met.sucursalesnuevo(fecha1mesdia1, fecha1mesdia1, fecha2mesdia1, fecha2mesdia1, fecha3mesdia1, fecha3mesdia1, fechaaniodia1, fechaaniodiault, fechaaniodia1, fechaaniodia1, 1, mesactual);
        
    }
}
