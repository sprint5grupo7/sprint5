/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author cobos
 */
public class CuentaBancariaCliente {

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
    
private String cliente;
private String saldo;
private String entidad;
private String oficina;
private String numCuenta;

private String control;

public static final int MAXIMO = 100;
public static final int MINIMO = 10;

    public CuentaBancariaCliente(String titular, String entidad, String oficina, String DC,String numCuenta) throws Exception{
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
        
   
    
    public String obtener_CCC(){
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
    
    public String obtener_Control(){
        return control;
    }
    
  
    public void cambiar_Saldo(String saldo) throws Exception{
        if(comprobarSaldo(saldo)){//antes comprueba que el saldo no sea negativo
            this.saldo=saldo;
        }
        else{
            Exception ex = new IllegalArgumentException("nombre no valido");
            throw ex;
        }
    }
    
  
    public void cambiar_titular(String titular) throws Exception{
        if(titular.length()>MINIMO&&titular.length()<MAXIMO){//comprueba que el nombre cumpla las reglas
            this.cliente=titular;
        }
        else{
            Exception ex = new IllegalArgumentException("nombre no valido");
            throw ex;
        }
    }

    public boolean comprobarSaldo(String saldo) throws Exception{
        double sald = Double.parseDouble(saldo);
        boolean comprobacion = true;
        
        if(sald<0){
            Exception ex = new IllegalArgumentException("saldo negativo no valido");
            throw ex;
        }
        else{
        return comprobacion;
        }
    }
        

    public void ingresarDinero(double cantidad) throws Exception{
        double actual = Double.parseDouble(saldo);
        
        if(cantidad>0){//comprueba que la cantidad no sea negativa
            actual+=cantidad;
        }
        else{
            Exception ex = new IllegalArgumentException();
            throw ex;
        }
        
        String nueva = String.valueOf(actual);
        
        this.saldo = nueva;
        
    }
    

    public void retirar(double cantidad) throws Exception{
        double actual = Double.parseDouble(saldo);
        
        if((cantidad<actual) && (cantidad>0)){//comprueba que la cantidad no sea negativa ni mayor que el saldo
            actual-=cantidad;
        }
        else{
            Exception ex = new IllegalArgumentException();
            throw ex;
        }
        
        String nueva = String.valueOf(actual);
        
        this.saldo = nueva;
        
        
    }
    
    
    
    
    
    
    
    




public static String obtenerDigitosControl(String entidad, String oficina, String numCuenta){//Calcula los dos digitos de control
    String control = new String();
    int primero = 0;
    int segundo = 0;
    
    String listaNum = new String();
    
    int [] comprobantes = new int[10];//array con las lista de numeros para comprobar
    
    comprobantes[0]=1;
    comprobantes[1]=2;
    comprobantes[2]=4;
    comprobantes[3]=8;
    comprobantes[4]=5;
    comprobantes[5]=10;
    comprobantes[6]=9;
    comprobantes[7]=7;
    comprobantes[8]=3;
    comprobantes[9]=6;
    
    
    listaNum = entidad+oficina;
    listaNum = '0'+listaNum;
    listaNum = '0'+listaNum;    
    int suma = 0;
    int resultado = 0;
    
    for(int i=0;i<10;i++){//primer digito de control
        suma += ((int)listaNum.charAt(i)-'0')*comprobantes[i];       
    }
    
    suma = suma%11;
    resultado = 11-suma;
    
    if(resultado==10){
        resultado=1;
    }
    else if(resultado==11){
        resultado=0;
    }
    control = control+resultado;
    
    
    listaNum = numCuenta;    //segundo digito de control
    suma = 0;
    resultado = 0;
    
    for(int i=0;i<10;i++){
        suma += ((int)listaNum.charAt(i)-'0')*comprobantes[i];       
    }
    
    suma = suma%11;
    resultado = 11-suma;
    
    if(resultado==10){
        resultado=1;
    }
    else if(resultado==11){
        resultado=0;
    }
    control = control+resultado;
        
    return control;
}



String CCC = entidad+oficina+control+numCuenta;

public static boolean comprobarCCC(String CCC){
    
    boolean comprobacion=false;
    
    String entidad = new String();//divido en partes el CCC
    for(int i=0;i<4;i++){
        entidad = entidad+CCC.charAt(i);
    }
    
    String oficina = new String();
    for(int i=4;i<8;i++){
        oficina = oficina+CCC.charAt(i);
    }
    
    String control = new String();
    for(int i=8;i<10;i++){
        control = control+CCC.charAt(i);
    }
    
    String numCuenta = new String();
    for(int i=10;i<20;i++){
        numCuenta = numCuenta+CCC.charAt(i);
    }
    
    String controlObtenidos = new String();
    controlObtenidos = obtenerDigitosControl(entidad, oficina, numCuenta);
    
    
   
    
    if((control.charAt(0)==controlObtenidos.charAt(0))&&(control.charAt(1)==controlObtenidos.charAt(1))){
        comprobacion=true;
    }
    else{
        comprobacion=false;
    }
    
    return comprobacion;
    
}


@Override
    public String toString(){
        return "Titular: "+cliente+", CCC: "+CCC+", SALDO: "+saldo;
    }


    
    
}
