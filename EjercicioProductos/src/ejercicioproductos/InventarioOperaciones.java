/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicioproductos;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author lean
 */
public interface InventarioOperaciones {
    
    void cargarProductosDesdeArchivo(String rutaArchivo) throws IOException, ProductoMalFormadoException;
    
    List<Producto> buscarPorCategoria(String categoria);
    
    void guardarResultadosEnTXT(List<Producto> productos, String rutaArchivoDestino) throws IOException;
}
