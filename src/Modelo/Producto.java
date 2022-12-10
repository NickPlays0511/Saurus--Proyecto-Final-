package Modelo;

public class Producto {
    private int id;
    private double precioV;
    private double precioC;
    private String nombre;
    private String marca;
    private String dcp;
    private int stock;

    public Producto(int id, double precioV, double precioC, String nombre, String marca, String dcp, int stock) {
        this.id = id;
        this.precioV = precioV;
        this.precioC = precioC;
        this.nombre = nombre;
        this.marca = marca;
        this.dcp = dcp;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double precioC) {
        this.precioC = precioC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDcp() {
        return dcp;
    }

    public void setDcp(String dcp) {
        this.dcp = dcp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
