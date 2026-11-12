/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioproductos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lean
 */
public class SistemaInventario implements InventarioOperaciones{
    
    private List<Producto> inventario;

    public SistemaInventario() {
        this.inventario = new ArrayList<>();
    }

    @Override
    public void cargarProductosDesdeArchivo(String rutaArchivo) throws IOException, ProductoMalFormadoException {
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo) ) ){
            String linea;
            while( (linea = br.readLine()) != null ){
                //esperamos este formato: codigo, nombre, precio, cantidad
                
                String[] partes = linea.split(",");
                
                if(partes.length !=5 ){
                    throw new ProductoMalFormadoException("La línea no tiene 5 columnas: "+ linea);
                }
                
                try{
                    String codigo = partes[0].trim();
                    String nombre = partes[1].trim();
                    double precio = Double.parseDouble(partes[2].trim());
                    String categoria = partes[3].trim();
                    int cantidad = Integer.parseInt(partes[4]);
                    
                    Producto p = new Producto(codigo, nombre, precio, categoria, cantidad);
                    inventario.add(p); //tarea: como hacer para no agregegar productos repetidos ?
                }
                catch(NumberFormatException e){
                    throw new ProductoMalFormadoException("Error al convertir números en la linea "+ linea);
                }
            }
        }
    }

    @Override
    public List<Producto> buscarPorCategoria(String categoria) {
        List<Producto> encontrados = new ArrayList<>();
        for(Producto p : this.inventario){
            if(p.getCategoria().equalsIgnoreCase(categoria)){
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    @Override
    public void guardarResultadosEnTXT(List<Producto> productos, String rutaArchivoDestino) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoDestino))){
            String encabezado = String.format("%-10s | %-20s | %-10s | %-15s | %-10s", "CODIGO", "NOMBRE", "PRECIO", "CATEGORIA","CANTIDAD");
            
            bw.write(encabezado);
            bw.newLine();
            bw.write("-------------------------------------------");
            bw.newLine();
            
            for(Producto p : productos){
                String lineaFormateada = String.format("%-10s | %-20s | %-10s | %-15s | %-10s", p.getCodigo(),p.getNombre(),p.getPrecio(),p.getCategoria(), p.getCantidad());
                bw.write(lineaFormateada);
                bw.newLine();
            }
        }
    }
    
    
    
}
