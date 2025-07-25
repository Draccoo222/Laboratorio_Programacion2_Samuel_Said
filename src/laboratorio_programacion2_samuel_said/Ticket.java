/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;

/**
 *
 * @author unwir
 */
public class Ticket {
    private String nomPasajero;
    private double monto = 0;
    private double montoOg = 1500;
    private boolean esPalindromo;
    
    public Ticket(String nomPasajero, double monto){
    
    }
    
    public String getName(String name){
       return nomPasajero;
    }
    
    public double getFinalAmount(){
    return monto;
    }
    
    public double getOriginalAmount(){
    return montoOg;
    }
    
    public boolean isPalindrome(){
    String nombre = nomPasajero.toLowerCase();
    int length = nomPasajero.length();
    
        for (int i = 0; i < length; i++) {
            if(nombre.charAt(i)!= nombre.charAt(length - 1 - i)){
            return false;
            }
        }     
        return true;
    }
    
    public double costoTicket(double montoOg){
    if(isPalindrome()){
        monto = montoOg - (montoOg*0.10);
        return monto;
    }
    return montoOg;
    }
            
    public void print(){
    
    }
}
