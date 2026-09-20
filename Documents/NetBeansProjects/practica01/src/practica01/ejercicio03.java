
/*1. Desarrolla un algoritmo que determine el sueldo mensual del empleado A y el empleado B, 
considerando la cantidad de horas que labora en el día y el sueldo por hora es de S/18.00 así mismo la empresa 
requiere saber el historial de pagos por mes (enero a diciembre) y el total que se le ha pagado durante todo el año, 
recordar que el empleado está en planilla por lo tanto le corresponde julio y diciembre un sueldo de 2500 además por bonificación y 
escolaridad le corresponde el 10% del sueldo del mes de diciembre. Así mismo el empleado está interesado en saber cuánto fueron 
sus aportes a la AFP durante todo el año, recuerda que es el 11% de descuento a su sueldo de cada mes. 
Nota: Las horas que debe laborar el trabajador son variados por lo tanto se ingresan por teclado
*/
package practica01;
import java.util.Scanner;

public class ejercicio03 {

    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
    
    System.out.print("Empleado: ");
    String empleado = input.nextLine();
    
    System.out.print("Horas: ");
    double horas = input.nextDouble();
    
    System.out.print("Dias: ");
    int dias = input.nextInt();
    
    double semana = (horas * dias);
    System.out.println ("Total de horas trabajadas a la semana:" + semana);
    
    double mes = semana * 18;
    System.out.println("El empleado " +empleado+ " gana al mes: " +mes);
    
    double semestre1 = 6 * mes;
    System.out.println("Primer semestre: " + semestre1);
    
    
    System.out.print("Horas: ");
    double horas2 = input.nextDouble();
    
    System.out.print("Dias: ");
    int dias2 = input.nextInt();
    
    double semana2 = (horas2 * dias2);
    System.out.println ("Total de horas trabajadas a la semana:" + semana2);
    
    double mes2 = semana2 * 18;
    System.out.println("El empleado " +empleado+ " gana al mes: " +mes2);
    
    double semestre2 = 6 * mes;
    System.out.println("Segundo semestre: " + semestre2);
    
    double bonificacion = mes2 * 0.10;
    double anual = semestre1 + semestre2 + 2500 + bonificacion;
    System.out.println("El empleado " +empleado+ " gana al año: " + anual);

    double AFP = (semestre1 + semestre2) * 0.11;
    System.out.print("Aporte al año del " +empleado + " fue " +AFP);
    
    }
    
}

    
    

