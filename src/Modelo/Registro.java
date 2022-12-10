package Modelo;

import Conexion.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Registro {
    Mysql con=new Mysql();
    Connection cn=con.conectar();
    public double pr;
    public static int cod;
    
   public void registrarbd(Venta v){
       Statement st;
        try{
            st=cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT PRECIO_VENTA FROM productos WHERE ID_PROD ="+v.getCod());
            cod = v.getCod();
            while (rs.next()){
                pr=rs.getDouble("PRECIO_VENTA");
            }
        }catch (Exception e){
            System.out.println("Error al listar los datos 1 "+e);
        }
        try {        
            PreparedStatement ps=cn.prepareStatement("INSERT INTO venta(FECHA_VENTA, ID_PROD, CANTIDAD, PRECIO_FINAL) VALUES(?,?,?,?)");
            ps.setString(1, v.getFecha());
            ps.setInt(2, v.getCod());
            ps.setInt(3, v.getCantidad());
            ps.setDouble(4, v.getCantidad()*pr);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error al listar los datos 2 "+e);
        }
   }
}
