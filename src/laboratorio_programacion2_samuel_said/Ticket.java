/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;

import javax.swing.JOptionPane;

/**
 *
 * @author unwir
 */
public class Ticket {
    private String nomPasajero;
    private double montoFinal ;
    private double montoOg = 1500;
    
    public Ticket(String nomPasajero, double montoOg){
    this.nomPasajero = nomPasajero;
    this.montoFinal = costoTicket(montoOg);
    this.montoOg = montoOg;
    }

    public String getName(String name){
       return nomPasajero;
    }
    
    public double getFinalAmount(){
    return montoFinal;
    }
    
    public double getOriginalAmount(){
    return montoOg;
    }
    
    public boolean isPalindrome(){
   return new PalindromoAir().isPalindromo(nomPasajero);
    }
    
    public double costoTicket(double montoOg){
    if(isPalindrome()){
        montoFinal = montoOg - (montoOg*0.10);
        return montoFinal;
    }
    return montoOg;
    }
            
    public void print(){
     String mensaje =
            "Nombre:           " + getName(nomPasajero) +
          "\nMonto original:   $" + String.format("%.2f", getOriginalAmount()) +
          "\nMonto final:      $" + String.format("%.2f", getFinalAmount()) +
          "\nDescuento aplicado: " + (isPalindrome() ? "Sí (10%)" : "No");
        JOptionPane.showMessageDialog(
            null,
            mensaje,
            "Detalle del Ticket",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
