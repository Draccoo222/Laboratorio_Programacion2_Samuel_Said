/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author unwir
 */
public class main extends JFrame {
tablaBotones ui = new tablaBotones();
    PalindromoAir aeropuerto = new PalindromoAir(ui);
    private JButton sellT = new JButton("Sell Ticket");
    private JButton cancelT = new JButton("Cancel Ticket");
    private JButton dispatch = new JButton("Dispatch");
    private JButton printP = new JButton("Print Passangers");
    private JButton income = new JButton("Income");
    private JButton searchPass = new JButton("Search Pass");

    public main() {
        components();
    }

    private void components() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);
        JLabel a = new JLabel();
        a.setBounds(270, 0, 300, 50);
        a.setText("PALINDROME AIRLINES");
        a.setFont(new Font("Arial Black", Font.BOLD, 20));

        ui.setBounds(10, 55, 600, 500);

        sellT.setBounds(550 + 65, 60 + 35, 150, 40);
        cancelT.setBounds(550 + 65, 120 + 35, 150, 40);
        dispatch.setBounds(550 + 65, 180 + 35, 150, 40);
        printP.setBounds(550 + 65, 240 + 35, 150, 40);
        income.setBounds(550 + 65, 300 + 35, 150, 40);
        searchPass.setBounds(550 + 65, 360 + 35, 150, 40);

        sellT.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del pasajero:");
            if (nombre != null && !nombre.isEmpty()) {
                aeropuerto.sellTicket(nombre);
            }
        });
        cancelT.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del pasajero a cancelar:");
            if (nombre != null && !nombre.isEmpty()) {
                aeropuerto.cancelTicket(nombre);
            }
        });
        dispatch.addActionListener(e -> {
            aeropuerto.dispatch();
        });
        printP.addActionListener(e -> {
            aeropuerto.printPassengers(0);
        });
        income.addActionListener(e -> {
            double total = aeropuerto.income(0);
            JOptionPane.showMessageDialog(
                    null,
                    "Total ingresos: $" + String.format("%.2f", total),
                    "Ingresos",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        searchPass.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del pasajero a buscar:");
            if (nombre != null && !nombre.isEmpty()) {
                int pos = aeropuerto.searchPassenger(nombre, 0);
                if (pos == -1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Pasajero no encontrado",
                            "Búsqueda",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Pasajero en asiento " + (pos + 1),
                            "Búsqueda",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        add(a);
        add(ui);
        add(sellT);
        add(cancelT);
        add(dispatch);
        add(printP);
        add(income);
        add(searchPass);

    }

    public static void main(String[] args) {
        main b = new main();
        b.setVisible(true);
    }
}
