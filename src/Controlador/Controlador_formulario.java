package Controlador;
import Modelo.BuscarProducto;
import Modelo.EliminarProducto;
import Modelo.ListarProductos;
import Modelo.MostrarProductos;
import Modelo.Venta;
import Modelo.ProductoBuscado;
import Modelo.Registro;
import Modelo.Producto;
import Modelo.RegistrarProducto;
import interfazproyecto.MainJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Controlador_formulario implements ActionListener {
    MainJFrame Interfaz;
    
            
    public Controlador_formulario(MainJFrame MainJF) {
        this.Interfaz = MainJF;
        this.Interfaz.btnguardar.addActionListener(this);
        this.Interfaz.btnbuscar.addActionListener(this);
        this.Interfaz.btnactualizar.addActionListener(this);
        this.Interfaz.btneliminar.addActionListener(this);
        this.Interfaz.btnguardar2.addActionListener(this);
    }
    
    
    @Override

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==Interfaz.btnguardar){
            
            int cod =Integer.parseInt(Interfaz.txtcod.getText());
            int cantidad=Integer.parseInt(Interfaz.txtcantidad.getText());
            String fecha=Interfaz.txtfecha.getText();
            Venta V=new Venta(cod,cantidad,fecha);
            Registro R=new Registro();
            R.registrarbd(V);
            
            ListarProductos lp=new ListarProductos();
            lp.MostrarTabla(Interfaz.tablaproductos);
            
            //Interfaz.txttotal.setText(String.valueOf(Math.round(lp.tf*100.0)/100.0));
           
            limpiarentradas();
        }
        if(e.getSource()==Interfaz.btnbuscar){
            int cod = Integer.parseInt(Interfaz.txtcod.getText());
            ProductoBuscado pb=new ProductoBuscado(cod);
            
            BuscarProducto bp=new BuscarProducto();
            bp.BuscarProducto(pb);
        
            Interfaz.txtproducto.setText(bp.c);
            Interfaz.txtprecio.setText(String.valueOf(bp.pr));
            Interfaz.txtstock.setText(String.valueOf(bp.s)); 
        }
        if(e.getSource()==Interfaz.btnactualizar){
            ListarProductos lp=new ListarProductos();
            lp.MostrarTabla(Interfaz.tablaproductos);
            
             //Interfaz.txttotal.setText(String.valueOf(Math.round(lp.tf*100.0)/100.0));
        }
        
        if(e.getSource()==Interfaz.btneliminar){
            int row = Interfaz.tablaproductos.getSelectedRow();
            int fila = Interfaz.tablaproductos.getSelectedColumnCount();
            if (fila<1){
                JOptionPane.showMessageDialog(null,"Debe seleccionar el registro que desea eliminar");
            }else{
                EliminarProducto er=new EliminarProducto();
                er.EliminarProducto(Interfaz.tablaproductos.getValueAt(row, 0).toString());
                ListarProductos lp=new ListarProductos();
                lp.MostrarTabla(Interfaz.tablaproductos);
            }
        }
        
        if(e.getSource()==Interfaz.btnguardar2){
            int id = Integer.parseInt(Interfaz.txtid.getText());
            double precioC = Double.parseDouble(Interfaz.txtprecioc.getText());
            double precioV = Double.parseDouble(Interfaz.txtpreciov.getText());
            String nombre = Interfaz.txtnom.getText();
            String marca = Interfaz.txtmarca.getText();
            String dcp = Interfaz.txtdcp.getText();
            int stock = Integer.parseInt(Interfaz.txtstock1.getText());
            Producto p = new Producto(id, precioV, precioC, nombre, marca, dcp, stock);
            RegistrarProducto r=new RegistrarProducto();
            r.registrarprod(p);
            
            MostrarProductos mp=new MostrarProductos();
            mp.MostrarTabla(Interfaz.tablaprod);
            
        }
    }
    
    
    private void limpiarentradas() {
        Interfaz.txtcliente.setText("");
        Interfaz.txtcod.setText("");
        Interfaz.txtprecio.setText("");
        Interfaz.txtcantidad.setText("");
        Interfaz.txtproducto.setText("");
        Interfaz.txtstock.setText("");
        Interfaz.txtfecha.setText("");
    }
    
}
