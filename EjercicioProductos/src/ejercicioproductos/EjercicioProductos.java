/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioproductos;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author lean
 */
public class EjercicioProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();
        String archivoEntrada = "productos.csv";
        
        String categoriaBuscada = "Electronica";
        String archivoSalida = "reultados"+categoriaBuscada+".xt";
        
        try{
            sistema.cargarProductosDesdeArchivo(archivoEntrada);
            System.out.println("productos cargados exitosamente");
            
            List<Producto> filtrados = sistema.buscarPorCategoria(categoriaBuscada);
            System.out.println("Se encontraron "+filtrados.size()+" productos");
            
            sistema.guardarResultadosEnTXT(filtrados, archivoSalida);
        }
        catch( ProductoMalFormadoException e){
            System.out.println("Error en el formato de los datos");
        }
        catch(IOException e){
            System.out.println("Error de lectura/escritura");
        }
    }
    
}
