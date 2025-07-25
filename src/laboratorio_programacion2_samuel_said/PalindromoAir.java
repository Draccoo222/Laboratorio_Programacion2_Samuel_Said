/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;

import javax.swing.JOptionPane;

/**
 *
 * @author saidn
 */
public class PalindromoAir {
    private Ticket[] asientos;
    private String nomPasajero;
    private double montoOg;
    private final int capacidad = 30;
    
    public PalindromoAir(){
        asientos = new Ticket[capacidad];
    }
    
    public int firstAvailable(int indice) {
        if (indice >= asientos.length) {
            return -1;
        }
        if (asientos[indice] == null) {
            return indice;
        }
        return firstAvailable(indice + 1);
    }
    
    public int searchPassenger(String nombre, int indice) {
        if (indice >= asientos.length) {
            return -1;
        }
        if (asientos[indice] != null && asientos[indice].getName(nombre).equalsIgnoreCase(nombre)) {
            return indice;
        }
        return searchPassenger(nombre, indice + 1);
    }
    
    
    public boolean isPalindromo(String name) {
        String s = name.toLowerCase();

        if (s.length() <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindromo(s.substring(1, s.length() - 1));
    }
    
    public void printPassengers(int index) {
        if (index >= asientos.length) {
            return;
        }
        if (asientos[index] != null) {
            asientos[index].print();
        }
        printPassengers(index + 1);
    }
    
     public double income(int index) {
        if (index >= asientos.length) {
            return 0;
        }
        double suma = (asientos[index] != null)
            ? asientos[index].getFinalAmount()
            : 0;
        return suma + income(index + 1);
    }

    public void reset(int index) {
        if (index >= asientos.length) {
            return;
        }
        asientos[index] = null;
        reset(index + 1);
    }

    public boolean sellTicket(String name) {
        int asientoLibre = firstAvailable(0);
        if (asientoLibre == -1) {
            JOptionPane.showMessageDialog(
                null,
                "El avion esta lleno",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        Ticket t = new Ticket(name, montoOg);
        asientos[asientoLibre] = t;
        JOptionPane.showMessageDialog(
            null,
            "Boleto vendido en asiento " + (asientoLibre + 1)
            + "\nMonto pagado: $" + String.format("%.2f", t.getFinalAmount()),
            "Venta exitosa",
            JOptionPane.INFORMATION_MESSAGE
        );
        return true;
    }

    public boolean cancelTicket(String name) {
        int pos = searchPassenger(name, 0);
        if (pos == -1) {
            JOptionPane.showMessageDialog(
                null,
                "Pasajero no encontrado",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        asientos[pos] = null;
        JOptionPane.showMessageDialog(
            null,
            "Ticket cancelado. Asiento " + (pos + 1) + " liberado",
            "Cancelacion exitosa",
            JOptionPane.INFORMATION_MESSAGE
        );
        return true;
    }

    public void dispatch() {
        double total = income(0);
        JOptionPane.showMessageDialog(
            null,
            "Total ingresos: $" + String.format("%.2f", total),
            "Despacho",
            JOptionPane.INFORMATION_MESSAGE
        );
        reset(0);
    }
    
}
