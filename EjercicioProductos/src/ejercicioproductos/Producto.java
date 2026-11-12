/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioproductos;

/**
 *
 * @author lean
 */
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidad;

    public Producto(String codigo, String nombre, double precio, String categoria, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        //tendríamos que verificar que el precio se válido
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        // tarea: cambiar categoría a enum
        this.categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
