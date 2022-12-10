package Main;

import Controlador.Controlador_formulario;
import Modelo.ListarProductos;
import Modelo.MostrarProductos;
import interfazproyecto.MainJFrame;

public class Principal {
    
    public static MainJFrame Interfaz;
    public static Controlador.Controlador_formulario c_in;
    public static void main(String[] args) {
        Interfaz = new MainJFrame();
        Interfaz.setVisible(true);
        Interfaz.setLocationRelativeTo(null);
        
        c_in = new Controlador_formulario(Interfaz);
        
        ListarProductos lp=new ListarProductos();
        lp.MostrarTabla(Interfaz.tablaproductos);
        
        MostrarProductos mp=new MostrarProductos();
        mp.MostrarTabla(Interfaz.tablaprod);
    }
    
}
