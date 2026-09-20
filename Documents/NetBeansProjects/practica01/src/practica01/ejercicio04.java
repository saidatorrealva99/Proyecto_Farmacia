/*
 3. Se solicita implementar un programa que determine sus gastos durante su carrera profesional, se considera solo  
gastos en matricula por cada ciclo, gastos de mensualidad durante el ciclo, gastos de idiomas, y gastos en graduación, 
imprimir en pantalla los gastos totales por cada ciclo así mismo el monto total que dicha carrera requiere. 
 */
package practica01;
import java.util.Scanner;

public class ejercicio04 {

    
    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
    
    System.out.print("Alumno: ");
    String alumno = input.nextLine();
    
    System.out.print("Matricula: ");
    double matricula = input.nextDouble();  
    
    System.out.print("Mensualidad: ");
    double mensualidad = input.nextDouble();
    
    double ciclo = (mensualidad * 4) + matricula;
    System.out.println("Gastos por ciclo: " + ciclo);
    
    
    System.out.print("Gasto de idiomas: ");
    double idiomas = input.nextDouble() ;
    
    System.out.print("Gasto de graduacion: ");
    double graduacion = input.nextDouble() ;
    
    
    double total_carrera = (ciclo * 6) + idiomas + graduacion;
    System.out.println("El alumno " +alumno+ " gasto en total: " +total_carrera);
    }
    
}
