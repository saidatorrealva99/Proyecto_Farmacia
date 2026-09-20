/*
Desarrolla un algoritmo que determine la ganancia total de la empresa de transporte, 
teniendo como información, que su flota de vehículos es de 20 unidades y han partido 
al mismo tiempo y hora de la ciudad de Chiclayo a Lima, con pasajeros a bordo 50 por 
cada bus, sabiendo además que cada pasajero ha pagado 120 soles y adicional a ello, 
la suma de 15 soles por atención en todo el viaje, además se requiere determinar los 
gastos por cada vehículo, considerando que hay un total de 5 peajes y cada vehículo 
paga la suma de S/80.00  además consumen 20 litro de combustible y su costo es de S/50
se solicita que el programa genere de manera automática, los gastos de cada vehículo, 
los ingresos que cada bus ha generado y su ganancia total para la empresa. 
 */
package practica01;
import java.util.Scanner;
public class ejercicio05 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*Ganancia de cada bus*/
        double bus =50*135;
        /*Ganancia de las 20 unidades*/
        double flota_buses =20 *bus;
        System.out.println("Los ingreso de cada bus es : "+ bus);
        System.out.println("La ganancia total de la empresa por los 20 carros es : "+ flota_buses);
        
        /*GASTO POR BUS*/
        double peaje= 5*80;
        double combustible = 20 * 50;
        double Gasto_bus= peaje + combustible;
        double Gasto_Flota = Gasto_bus * 20;
        System.out.println("Los gastos de cada bus es : "+ Gasto_bus);
        System.out.println("El gasto total de la empresa por los 20 carros es de : "+ Gasto_Flota);
        double Ganancia_total= flota_buses - Gasto_Flota;
        
        System.out.println("La ganancia total de la empresa por los 20 carros es : "+ Ganancia_total);
    }
    
}
