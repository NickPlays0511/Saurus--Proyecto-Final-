package Modelo;

import Conexion.Mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarProductos {
    Mysql con=new Mysql();
    Connection cn=con.conectar();
    public double pr;
    public String n;
    public double tf = 0.00;

    public void MostrarTabla(JTable tabla){
        
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("ID_Producto");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Total");
             
        Statement st;
        try {
            st=cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT ID_PROD, NOMBRE, CANTIDAD, PRECIO_VENTA, PRECIO_FINAL FROM productos NATURAL JOIN venta NATURAL JOIN prod_detalles");
            double p;
            while (rs.next()){
                //p = Math.round(rs.getDouble(3)/rs.getInt(2)*100.0)/100.0;
                Object [] lista={rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5)};
                modelo.addRow(lista);
                tf = tf + rs.getDouble(3);
            }
            tabla.setModel(modelo);
            
        }catch (Exception e){
            System.out.println("Error al listar los datos 1 "+e);
        }
    }
}
