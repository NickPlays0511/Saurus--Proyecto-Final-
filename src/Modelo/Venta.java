package Modelo;

public class Venta {
    
    private int cod;
    private String cliente;
    private int cantidad;
    private String fecha;

    public Venta(int cod, int cantidad, String fecha) {
        this.cod = cod;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
