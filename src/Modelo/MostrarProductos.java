package Modelo;
import Conexion.Mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class MostrarProductos {
    Mysql con=new Mysql();
    Connection cn=con.conectar();

    public void MostrarTabla(JTable tabla){
        
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("ID producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Descripción");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio compra");
        modelo.addColumn("Precio venta");
             
        Statement st;
        Statement st2;
        try {
            st=cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT ID_PROD, NOMBRE, MARCA, DESCRIPCION, STOCK, PRECIO_COMPRA, PRECIO_VENTA FROM productos NATURAL JOIN prod_detalles");
            while (rs.next()){
                Object [] lista={rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
            
        }catch (Exception e){
            System.out.println("Error al listar los datos 1 "+e);
        }
        /*try {
            st2=cn.createStatement();
            ResultSet rs2=st2.executeQuery("SELECT NOMBRE, MARCA, DESCRIPCION, STOCK FROM prod_detalles");
            while (rs2.next()){
                Object [] lista={rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getInt(4)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
            
        }catch (Exception e){
            System.out.println("Error al listar los datos 2 "+e);
        }*/
    }
}
