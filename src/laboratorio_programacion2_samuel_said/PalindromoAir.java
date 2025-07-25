/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author saidn
 */
public class PalindromoAir {

    private Ticket[] asientos;
    private String nomPasajero;
    private final double montoOg = 1500;
    private final int capacidad = 30;
    private tablaBotones tabla;

    public PalindromoAir(tablaBotones tabla) {
        this.tabla = tabla;
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

        String asientoStr = JOptionPane.showInputDialog(
                null,
                "Ingrese número de asiento (1–" + capacidad + "):",
                "Selección de asiento",
                JOptionPane.QUESTION_MESSAGE
        );
        if (asientoStr == null || asientoStr.isEmpty()) {

            return false;
        }
        int asientoNum;
        try {
            asientoNum = Integer.parseInt(asientoStr) - 1;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Número de asiento inválido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (asientoNum < 0 || asientoNum >= capacidad) {
            JOptionPane.showMessageDialog(
                    null,
                    "Asiento fuera de rango",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (asientos[asientoNum] != null) {
            JOptionPane.showMessageDialog(
                    null,
                    "El asiento ya está ocupado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        Ticket t = new Ticket(name, montoOg);
        asientos[asientoNum] = t;

        boolean esPal = isPalindromo(name);
        Color nuevo = Color.decode(esPal ? "#B8860B" : "#8B0000");
        tabla.setColorAsiento(asientoNum, nuevo);

        JOptionPane.showMessageDialog(
                null,
                "Boleto vendido en asiento " + (asientoNum + 1)
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

        for (botonsito b : tabla.asientosVisuales) {
            b.setBackground(Color.green);
            b.repaint();
        }
    }

}
