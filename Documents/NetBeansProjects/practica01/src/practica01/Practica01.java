
package practica01;
import java.util.Scanner;

public class Practica01 {
    static String producto;
    static int cantidad;
    static double precio_u, ganancia;
  
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        
        System.out.print("Ingrese el producto: ");
        producto = input.nextLine();
        
        System.out.print("Precio Unitario: ");
        precio_u = input.nextDouble(); 
        
        System.out.print("Cantidad vendida: ");
        cantidad = input.nextInt(); 
        
        ganancia = cantidad * precio_u;
        
         System.out.println("Ganancia Total: " +ganancia);
    }
    
}
