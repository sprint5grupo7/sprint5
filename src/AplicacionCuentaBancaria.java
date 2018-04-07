
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author cobos
 */
public class AplicacionCuentaBancaria {


    public static void main(String[] args){

        CuentaBancariaCliente c = null;

        try {
            c = new CuentaBancariaCliente("manuel manuel manuel", "1234", "5678", "06", "1234567890");
            c.cambiar_Saldo("1000");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String CCC = c.obtener_Entidad() + c.obtener_Oficina() + c.obtener_Control() + c.obtener_NumCuenta();

        int menu = 0;

        try{
        
        do {

                imprimirMenu();

            do {
                Scanner sc = new Scanner(System.in);
                
                try{
                    menu = sc.nextInt();
                }catch(InputMismatchException exect){
                    System.out.println("Debe de introducir un numero");
                }
                
                    
                if (menu < 0 || menu > 10) {
                    System.out.println("Eleccion incorrecta, prueba con otro numero");
                }
            } while (menu < 0 || menu > 10);

            Scanner ex = new Scanner(System.in);

            switch (menu) {
                case 1:
                    System.out.println(CCC);
                    break;
                case 2:
                    System.out.println(c.obtener_Titular());
                    break;
                case 3:
                    System.out.println(c.obtener_Entidad());
                    break;
                case 4:
                    System.out.println(c.obtener_Oficina());
                    break;
                case 5:
                    System.out.println(c.obtener_NumCuenta());
                    break;
                case 6:
                    System.out.println(c.obtener_Control());
                    break;
                case 7:
                    System.out.println("¿Que cantidad desea ingresar?");
                    double cantidad = 0;
                    boolean numero = false;
                    do {
                        try {
                            cantidad = ex.nextDouble();
                            numero = true;
                        } catch (InputMismatchException exec) {
                            System.out.println("Debe de introducir un número");
                        }

                        if (cantidad < 0) {
                            System.out.println("La cantidad debe de ser positiva");
                        }
                    } while (cantidad < 0 && !numero);

                    try {
                        c.ingresarDinero(cantidad);
                    } catch (IllegalArgumentException exe) {

                    }
                    break;
                case 8:
                    System.out.println("¿Que cantidad desea retirar?");
                    cantidad = 0;
                    numero = false;

                    do {
                        try {
                            cantidad = ex.nextDouble();
                            numero = true;
                        } catch (InputMismatchException exec) {
                            System.out.println("Debe de introducir un número");
                        }

                        if (cantidad < 0) {
                            System.out.println("La cantidad debe de ser positiva");
                        }
                    } while (cantidad < 0 && !numero);

                    try {
                        c.retirar(cantidad);
                    } catch (IllegalArgumentException exe) {

                    }

                    break;
                case 9:
                    System.out.println(c.obtener_Saldo());
                    break;
                case 10:
                    System.out.println("Banco cerrado");
                    break;

            }
        } while (!(menu == 10));

        }catch(Exception ex){
            System.err.println("Ha ocurrido algun error");
        }
        
    }

    private static void imprimirMenu() {
        System.out.println("Elige una opcion: ");
        System.out.println("1. Ver el número de cuenta completo(CCC).");
        System.out.println("2. Ver el titular de la cuenta.");
        System.out.println("3. Ver el código de la entidad.");
        System.out.println("4. Ver el código de la oficina.");
        System.out.println("5. Ver el número de la cuenta.");
        System.out.println("6. Ver los dígitos de control de la cuenta.");
        System.out.println("7. Realizar un ingreso.");
        System.out.println("8. Retirar efectivo.");
        System.out.println("9. Consultar saldo.");
        System.out.println("10.Salir de la aplicación.");
    }

}
