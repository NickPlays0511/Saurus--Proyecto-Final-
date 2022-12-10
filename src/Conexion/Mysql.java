
package Conexion;
    
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Mysql {
    Connection cn;
    
    public Connection conectar(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
            
        } catch (Exception e){
            System.out.println("Error de conexion"+e);
        }
        return cn;
    }
}
