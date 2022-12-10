package Modelo;
import Conexion.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class RegistrarProducto {
    Mysql con=new Mysql();
    Connection cn=con.conectar();
    
   public void registrarprod(Producto p){

        try {        
            PreparedStatement ps=cn.prepareStatement("INSERT INTO productos(ID_PROD, PRECIO_VENTA, PRECIO_COMPRA) VALUES(?,?,?)");
            ps.setInt(1, p.getId());
            ps.setDouble(2, p.getPrecioV());
            ps.setDouble(3, p.getPrecioC());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error al registrar el producto 1"+e);
        }
        
        try{
            PreparedStatement ps=cn.prepareStatement("INSERT INTO prod_detalles(ID_PROD, NOMBRE, MARCA, DESCRIPCION, STOCK) VALUES(?,?,?,?,?)");
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getMarca());
            ps.setString(4, p.getDcp());
            ps.setInt(5,p.getStock());
            ps.executeUpdate();
            
        }catch (Exception e){
            System.out.println("Error al registrar el producto 2"+e);
        }
   }
}
