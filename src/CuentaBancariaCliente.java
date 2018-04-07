/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author cobos
 */
public class CuentaBancariaCliente extends CuentaBancaria {


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
