package Modelo;

import Conexion.Mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BuscarProducto {
    Mysql con=new Mysql();
    Connection cn=con.conectar();
    public String c;
    public int pr;
    public int s;
    
    public void BuscarProducto(ProductoBuscado pb){
        String consultasql = "SELECT NOMBRE, STOCK FROM prod_detalles WHERE ID_PROD = "+pb.getCod();
        String consultasql2 = "SELECT PRECIO_VENTA FROM productos WHERE ID_PROD = "+pb.getCod();
        Statement st;
        try {
        st = cn.createStatement();
        ResultSet rs = st.executeQuery(consultasql);
        while(rs.next()){
        c=rs.getString("NOMBRE");
        s=rs.getInt("STOCK");
        }
        ResultSet rs2 = st.executeQuery(consultasql2);
        while(rs2.next()){
        pr=rs2.getInt("PRECIO_VENTA");
        }
        }catch (Exception e){
            System.out.println("Error al obtener datos"+e);
        }
    }
}
