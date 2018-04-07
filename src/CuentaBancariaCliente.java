/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta clase se encarga de crear, modificar y controlar todos los objetos
 * CuentaBancaria de los que dispongamos en nuestra aplicación
 * @author cobos
 */
public class CuentaBancariaCliente extends CuentaBancaria {


    /**
     * Constructor de la clase
     * @param titular String de una longitud determinada, la cual es controlada
     * @param entidad String
     * @param oficina String
     * @param DC String, dígitos de control (se comprueba si son correctos)
     * @param numCuenta String
     * @param ejemplo boolean, este es solo de un ejemplo de refactorización
     * @throws Exception La lanza si alguno de los datos es incorrecto
     */
    public CuentaBancariaCliente(String titular, String entidad, String oficina, String DC, String numCuenta, boolean ejemplo) throws Exception{
        cambiar_titular(titular);//llama al metodo para evitar errores
        String hola = obtenerDigitosControl(entidad, oficina, numCuenta);
        if((hola.charAt(0)==DC.charAt(0))&&(hola.charAt(1)==DC.charAt(1))){//comprueba que los DC sean correctos
        this.entidad = entidad;
        this.oficina = oficina;
        this.control = DC;
        this.numCuenta = numCuenta;
        }
        else{
            Exception ex = new IllegalArgumentException("datos incorrectos");
            throw ex;
        }
    }
        
   
    


    
    
}
