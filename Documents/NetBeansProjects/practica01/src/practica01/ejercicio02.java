/*_2. ELABORA UN PROGRAMA QUE PERMITA DETERMINAR EL SALARIO DE UN EMPLEADO: */
package practica01;
import java.util.Scanner;

public class ejercicio02 {

    
    public static void main(String[] args) {
          String empleado;
       int dias, meses;
       double salario, horas, costo_h, pago_d, mult, Total;
       
       Scanner input = new Scanner(System.in);
        
       System.out.print("Ingrese el empleado: ");
       empleado = input.nextLine();
       
       System.out.print("Ingrese el costo de las horas: ");
       costo_h = input.nextDouble();
       
       System.out.print("Ingrese la cantidad de horas trabajadas por día: ");
       horas = input.nextDouble();
       
       System.out.print("Ingrese el numero dias laborales: ");
       dias = input.nextInt();
      
       pago_d = horas*costo_h;
       System.out.println("Total de horas trabajadas al mes: " + pago_d);
       
       mult = pago_d * dias;
       System.out.println("Sueldo mensual: " + mult);
       
       
       System.out.println("Ingrese el numero meses: ");
       meses = input.nextInt();
       
       Total = meses * mult;
       
       System.out.println("Sueldo Total del empleado: " + Total) ;
        
    }
    
}
    
    

