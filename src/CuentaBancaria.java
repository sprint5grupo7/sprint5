/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cobos
 */
public class CuentaBancaria {
    
    public static final int MAXIMO = 100;
    public static final int MINIMO = 10;

    /**
 * Medienta el numero de entidad, de oficina y de numero de cuenta se 
 * encarga de calcular los digitos de control pertenecientes a estos mediante 
 * un algoritmo dado
 * @param entidad String
 * @param oficina String
 * @param numCuenta String
 * @return String con los dos digitos de control
 */
    public static String obtenerDigitosControl(String entidad, String oficina, String numCuenta) {
        //Calcula los dos digitos de control
        String control = new String();
        int primero = 0;
        int segundo = 0;
        String listaNum = new String();
        int[] comprobantes = new int[10]; //array con las lista de numeros para comprobar
        comprobantes[0] = 1;
        comprobantes[1] = 2;
        comprobantes[2] = 4;
        comprobantes[3] = 8;
        comprobantes[4] = 5;
        comprobantes[5] = 10;
        comprobantes[6] = 9;
        comprobantes[7] = 7;
        comprobantes[8] = 3;
        comprobantes[9] = 6;
        listaNum = entidad + oficina;
        listaNum = '0' + listaNum;
        listaNum = '0' + listaNum;
        int suma = 0;
        int resultado = 0;
        for (int i = 0; i < 10; i++) {
            //primer digito de control
            suma += ((int) listaNum.charAt(i) - '0') * comprobantes[i];
        }
        suma = suma % 11;
        resultado = 11 - suma;
        if (resultado == 10) {
            resultado = 1;
        } else if (resultado == 11) {
            resultado = 0;
        }
        control = control + resultado;
        listaNum = numCuenta; //segundo digito de control
        suma = 0;
        resultado = 0;
        for (int i = 0; i < 10; i++) {
            suma += ((int) listaNum.charAt(i) - '0') * comprobantes[i];
        }
        suma = suma % 11;
        resultado = 11 - suma;
        if (resultado == 10) {
            resultado = 1;
        } else if (resultado == 11) {
            resultado = 0;
        }
        control = control + resultado;
        return control;
    }

    /**
 * Comprueba si un numero completo es comprobando si sus digitos de control
 * coinciden con los calculados mediante el metodo anterior
 * @param CCC String que contiene todos los campos del numero
 * @return boolean indicando si es correcto o no
 */
    public static boolean comprobarCCC(String CCC) {
        boolean comprobacion = false;
        String entidad = new String(); //divido en partes el CCC
        for (int i = 0; i < 4; i++) {
            entidad = entidad + CCC.charAt(i);
        }
        String oficina = new String();
        for (int i = 4; i < 8; i++) {
            oficina = oficina + CCC.charAt(i);
        }
        String control = new String();
        for (int i = 8; i < 10; i++) {
            control = control + CCC.charAt(i);
        }
        String numCuenta = new String();
        for (int i = 10; i < 20; i++) {
            numCuenta = numCuenta + CCC.charAt(i);
        }
        String controlObtenidos = new String();
        controlObtenidos = obtenerDigitosControl(entidad, oficina, numCuenta);
        if ((control.charAt(0) == controlObtenidos.charAt(0)) && (control.charAt(1) == controlObtenidos.charAt(1))) {
            comprobacion = true;
        } else {
            comprobacion = false;
        }
        return comprobacion;
    }
    protected String cliente;
    protected String saldo;
    protected String entidad;
    protected String oficina;
    protected String numCuenta;
    protected String control;
    String CCC = entidad + oficina + control + numCuenta;

    public CuentaBancaria() {
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the saldo
     */
    public String getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the oficina
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * @param oficina the oficina to set
     */
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    /**
     * @return the numCuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String obtener_CCC() {
        return CCC;
    }

    public String obtener_Titular() {
        return cliente;
    }

    public String obtener_Saldo() {
        return saldo;
    }

    public String obtener_Entidad() {
        return entidad;
    }

    public String obtener_Oficina() {
        return oficina;
    }

    public String obtener_NumCuenta() {
        return numCuenta;
    }

    public String obtener_Control() {
        return control;
    }

    /**
     * Cambia el saldo de un cuenta al que le pase por parametro
     * @param saldo String 
     * @throws Exception Exception La lanza si el saldo no es correcto
     */
    public void cambiar_Saldo(String saldo) throws Exception {
        if (comprobarSaldo(saldo)) {
            //antes comprueba que el saldo no sea negativo
            this.saldo = saldo;
        } else {
            Exception ex = new IllegalArgumentException("nombre no valido");
            throw ex;
        }
    }

    /**
     * Cambia el titular de un cuenta al que le pase por parametro
     * @param titular String con una longitud entre el maximo y minimo
     * @throws Exception La lanza si la longitud no es la correcta
     */
    public void cambiar_titular(String titular) throws Exception {
        if (titular.length() > MINIMO && titular.length() < MAXIMO) {
            //comprueba que el nombre cumpla las reglas
            this.cliente = titular;
        } else {
            Exception ex = new IllegalArgumentException("nombre no valido");
            throw ex;
        }
    }

    /**
     * Se encarga de comprobar que el saldo no sea negativo
     * @param saldo String que combierta a double para la comprobación
     * @return
     * @throws Exception La lanza si el saldo no es correcto
     */
    public boolean comprobarSaldo(String saldo) throws Exception {
        double sald = Double.parseDouble(saldo);
        boolean comprobacion = true;
        if (sald < 0) {
            Exception ex = new IllegalArgumentException("saldo negativo no valido");
            throw ex;
        } else {
            return comprobacion;
        }
    }

    /**
     * Incrementa el saldo de una cueta la cantidad que le indiquemos
     * @param cantidad double, saldo a incrementar
     * @throws Exception La lanza si el saldo es negativo
     */
    public void ingresarDinero(double cantidad) throws Exception {
        double actual = Double.parseDouble(saldo);
        if (cantidad > 0) {
            //comprueba que la cantidad no sea negativa
            actual += cantidad;
        } else {
            Exception ex = new IllegalArgumentException();
            throw ex;
        }
        String nueva = String.valueOf(actual);
        this.saldo = nueva;
    }

    /**
     * Dismuniye el saldo de una cueta la cantidad que le indiquemos
     * @param cantidad double, saldo a disminuir
     * @throws Exception La lanza si el saldo es negativo o superior al actual
     */
    public void retirar(double cantidad) throws Exception {
        double actual = Double.parseDouble(saldo);
        if ((cantidad < actual) && (cantidad > 0)) {
            //comprueba que la cantidad no sea negativa ni mayor que el saldo
            actual -= cantidad;
        } else {
            Exception ex = new IllegalArgumentException();
            throw ex;
        }
        String nueva = String.valueOf(actual);
        this.saldo = nueva;
    }

    @Override
    public String toString() {
        return "Titular: " + cliente + ", CCC: " + CCC + ", SALDO: " + saldo;
    }
    
}
