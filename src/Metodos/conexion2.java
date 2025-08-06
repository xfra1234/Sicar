/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author usuario
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author carlo
 */
public class conexion2 {
    // Librería de MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "sicar";
//    public String database = "semill13_prueba";

    // Host
    public String hostname = "localhost";
//    public String hostname = "26.69.36.74";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=UTC";

    // Nombre de usuario
    public String username = "";
//    public String username = "semill13_root";

    // Clave de usuario
    public String password = "";
//       public String password = "qscesz@.1047";
    
    
     public Connection conectarMySQL(int sucursal) {
       
         if(sucursal==4){
             username = "consultas";
             password = "consultas";
         }
         else{
             username = "root";
             password = "dh638z7c";
         }
         
         
         
         
         Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
//            JOptionPane.showMessageDialog(null, "Exito");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }

        return conn;
    }
    
}
