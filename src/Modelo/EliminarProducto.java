package Modelo;

import Conexion.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EliminarProducto {
    Mysql con=new Mysql();
    Connection cn=con.conectar();
    
    public void EliminarProducto(String cod){
        Statement st;
        try {
            PreparedStatement ps=cn.prepareStatement("DELETE FROM venta WHERE ID_PROD ="+cod);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error al eliminar dato"+e);
        }
    }
}
