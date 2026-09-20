
package practica01;
import java.util.Scanner;
public class ejercicio6 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CAJERO AUTOMATICO");
        System.out.println("1. Consultar");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Salir");
      
        
        System.out.print("Ingrese su opción: ");
        int opcion =sc.nextInt();
        double saldo = 1500;
        
        switch (opcion) {
            case 1:
                System.out.println("Su saldo es de: " + saldo);
                break;
            case 2 :
                System.out.print("Cuanto desea depositar? " );
                double monto = sc.nextDouble();
                
                if (monto > 0){
                    double montoActual = saldo + monto;
                    
                    System.out.print("Realizó el deposito con exito.");
                    System.out.print("Su nuevo saldo es: " + montoActual);
                }else {
                    System.out.println("El monto de ser mayor que cero");
                }
                break;
            case 3:
                System.out.print("Cuanto desea retirar? " );
                monto = sc.nextDouble();
                if (monto <=0){
                    System.out.println("El monto de ser mayor al saldo disponible");
                }else if(monto>saldo){
                    System.out.println("Saldo inuficiente. Su monto actual es de: " + saldo ); 
                }  
                else{
                    double saldoNuevo = saldo - monto;
                    System.out.println("Realizó el deposito con exito.");
                    System.out.println("Su nuevo saldo es: " + saldoNuevo);                              
                }
                break;
            case 4: 
                System.out.println("Salir");
                break;
            default:
                System.out.println("Opcion no valida.");                
        }
       
    }
    
}
